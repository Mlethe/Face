package com.mlethe.face;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mlethe.face.utils.OpenGLUtil;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CameraActivity extends AppCompatActivity implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback {

    private GLSurfaceView mGlSurfaceView;

    private int textureID;

    private SurfaceTexture mSurface;

    private Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mGlSurfaceView = findViewById(R.id.gl_surface_view);
        mGlSurfaceView.setEGLContextClientVersion(2);
        mGlSurfaceView.setRenderer(this);
        mGlSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGlSurfaceView.onResume();

        // 打开相机
        // 0->后置摄像头    1->前置摄像头
        int cameraId = Camera.CameraInfo.CAMERA_FACING_FRONT;
        mCamera = Camera.open(cameraId);
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(cameraId, cameraInfo);
        Camera.Parameters parameters = mCamera.getParameters();
        int width = 640;
        int height = 480;
        // 获取相机大小
        Camera.Size bestPreviewSize = calBestPreviewSize(parameters, width, height);
        parameters.setPreviewSize(bestPreviewSize.width, bestPreviewSize.height);
//        parameters.setPreviewSize(1280, 720);
        mCamera.setParameters(parameters);

        // 开启检测人脸
        mCamera.setPreviewCallback(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mGlSurfaceView.onPause();

        if (mCamera != null) {
            mCamera.stopPreview();
            mCamera.setPreviewCallback(null);
            mCamera.release();
            mCamera = null;
        }
    }

    /**
     * 主要进行一些初始化工作，比如对透视进行修正、设置清屏所用颜色等
     * @param gl10
     * @param eglConfig
     */
    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES20.glClearColor(0, 0, 0, 0);
        textureID = OpenGLUtil.createTextureID();
        mSurface = new SurfaceTexture(textureID);
        // 设置照相机有数据时的监听
        mSurface.setOnFrameAvailableListener(this);

        try {
            // 设置预览容器
            mCamera.setPreviewTexture(mSurface);
            //开启预览
            mCamera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过传入的宽高算出最接近于宽高值的相机大小
     */
    private Camera.Size calBestPreviewSize(Camera.Parameters camPara,
                                           final int width, final int height) {
        List<Camera.Size> allSupportedSize = camPara.getSupportedPreviewSizes();
        ArrayList<Camera.Size> widthLargerSize = new ArrayList<Camera.Size>();
        for (Camera.Size tmpSize : allSupportedSize) {
            Log.w("ceshi", "tmpSize.width===" + tmpSize.width
                    + ", tmpSize.height===" + tmpSize.height);
            if (tmpSize.width > tmpSize.height) {
                widthLargerSize.add(tmpSize);
            }
        }

        Collections.sort(widthLargerSize, new Comparator<Camera.Size>() {
            @Override
            public int compare(Camera.Size lhs, Camera.Size rhs) {
                int off_one = Math.abs(lhs.width * lhs.height - width * height);
                int off_two = Math.abs(rhs.width * rhs.height - width * height);
                return off_one - off_two;
            }
        });

        return widthLargerSize.get(0);
    }

    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjMatrix = new float[16];
    private final float[] mVMatrix = new float[16];

    /**
     * 当设备水平或者垂直变化时调用此方法，设置新的显示比例
     * @param gl10
     * @param width
     * @param height
     */
    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        //计算宽高比
        float ratio = (float) height / width;
        //设置透视投影
        Matrix.frustumM(mProjMatrix, 0, -1, 1, -ratio, ratio, 3, 7);

    }

    /**
     * 绘制当前画面
     * @param gl10
     */
    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClearColor(1, 1, 1, 1);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);// 清除屏幕和深度缓存

        float[] mtx = new float[16];
        mSurface.getTransformMatrix(mtx);
        drawCameraMatrix(mtx);
        // Set the camera position (View matrix)
        Matrix.setLookAtM(mVMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1f, 0f);

        // Calculate the projection and view transformation
        //计算变换矩阵
        Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mVMatrix, 0);

        drawPointsMatrix(mMVPMatrix);

        mSurface.updateTexImage();// 更新image，会调用onFrameAvailable方法
    }

    /**
     * 绘制：
     *
     * 我们在 onDrawFrame 回调中执行绘制操作，绘制的过程其实就是为 shader 代码变量赋值，并调用绘制命令的过程：
     */
    public void drawCameraMatrix(float[] mtx) {
        float textureVertices[] = { 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, };
        FloatBuffer textureVerticesBuffer = floatBufferUtil(textureVertices);

        int mProgram = GLES20.glCreateProgram(); // create empty OpenGL ES Program

        // vertex着色器code
        final String vertexShaderCode = "attribute vec4 vPosition;"
                + "attribute vec2 inputTextureCoordinate;"
                + "varying vec2 textureCoordinate;" + "void main()" + "{"
                + "gl_Position = vPosition; gl_PointSize = 10.0;"
                + "textureCoordinate = inputTextureCoordinate;" + "}";
        // 拿出两个着色器 顶点着色器和碎片着色器
        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        GLES20.glAttachShader(mProgram, vertexShader); // add the vertex shader

        // fragment着色器code
        final String fragmentShaderCode = "#extension GL_OES_EGL_image_external : require\n"
                + "precision mediump float;"
                + "varying vec2 textureCoordinate;\n"
                + "uniform samplerExternalOES s_texture;\n"
                + "void main() {"
                + "  gl_FragColor = texture2D( s_texture, textureCoordinate );\n"
                + "}";
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER,
                fragmentShaderCode);
        GLES20.glAttachShader(mProgram, fragmentShader); // add the fragment

        // shader to program
        GLES20.glLinkProgram(mProgram); // creates OpenGL ES program executables

        // to program
        GLES20.glUseProgram(mProgram);

        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, textureID);
        // get handle to vertex shader's vPosition member
        // (顶点着色器的vPosition成员得到处理)
        int mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");

        // Enable a handle to the triangle vertices(使一个句柄三角形顶点)
        GLES20.glEnableVertexAttribArray(mPositionHandle);

        // number of coordinates per vertex in this array (顶点坐标数)
        final int COORDS_PER_VERTEX = 2;

        // vertex
        // 直角坐标系
        float squareCoords[] = { -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, };
        // initialize vertex byte buffer for shape coordinates(初始化顶点字节缓冲区形状坐标)
        FloatBuffer vertexBuffer = floatBufferUtil(squareCoords);

        // 顶点步幅
        final int vertexStride = COORDS_PER_VERTEX * 4; // 4 bytes per
        // Prepare the <insert shape here> coordinate data (准备<插入形状这里>坐标数据)
        GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX,
                GLES20.GL_FLOAT, false, vertexStride, vertexBuffer);

        int mTextureCoordHandle = GLES20.glGetAttribLocation(mProgram,
                "inputTextureCoordinate");
        GLES20.glEnableVertexAttribArray(mTextureCoordHandle);

        //照相机镜像
        textureVerticesBuffer.clear();
        textureVerticesBuffer.put(transformTextureCoordinates(textureVertices,
                mtx));
        textureVerticesBuffer.position(0);

        short drawOrder[] = { 0, 1, 2, 0, 2, 3 }; // order to draw vertices
        // initialize byte buffer for the draw list (绘制列表初始化字节缓冲区)
        ShortBuffer drawListBuffer = ShortBufferUtil(drawOrder);

        GLES20.glVertexAttribPointer(mTextureCoordHandle, COORDS_PER_VERTEX,
                GLES20.GL_FLOAT, false, vertexStride, textureVerticesBuffer);
        GLES20.glDrawElements(GLES20.GL_TRIANGLES, drawOrder.length,
                GLES20.GL_UNSIGNED_SHORT, drawListBuffer);

        // Disable vertex array
        GLES20.glDisableVertexAttribArray(mPositionHandle);
        GLES20.glDisableVertexAttribArray(mTextureCoordHandle);
    }

    // 定义一个工具方法，将float[]数组转换为OpenGL ES所需的FloatBuffer
    public FloatBuffer floatBufferUtil(float[] arr) {
        // 初始化ByteBuffer，长度为arr数组的长度*4，因为一个int占4个字节
        ByteBuffer qbb = ByteBuffer.allocateDirect(arr.length * 4);
        // 数组排列用nativeOrder
        qbb.order(ByteOrder.nativeOrder());
        FloatBuffer mBuffer = qbb.asFloatBuffer();
        mBuffer.put(arr);
        mBuffer.position(0);
        return mBuffer;
    }

    // 定义一个工具方法，将Short[]数组转换为OpenGL ES所需的ShortBuffer
    private ShortBuffer ShortBufferUtil(short[] arr) {
        ByteBuffer dlb = ByteBuffer.allocateDirect(arr.length * 2);
        dlb.order(ByteOrder.nativeOrder());
        ShortBuffer buffer = dlb.asShortBuffer();
        buffer.put(arr);
        buffer.position(0);

        return buffer;
    }

    /**
     * 图像旋转
     */
    private float[] transformTextureCoordinates(float[] coords, float[] matrix) {
        float[] result = new float[coords.length];
        float[] vt = new float[4];

        for (int i = 0; i < coords.length; i += 2) {
            float[] v = { coords[i], coords[i + 1], 0, 1 };
            // for (int j = 0; j < v.length; j ++) {
            // Log.w("ceshi", "v[" + j + "]======" + coords[j]);
            // }
            Matrix.multiplyMV(vt, 0, matrix, 0, v, 0);
            result[i] = vt[0];// x轴镜像
            // result[i + 1] = vt[1];y轴镜像
            result[i + 1] = coords[i + 1];
        }
        //
        // for (int i = 0; i < coords.length; i ++) {
        // Log.w("ceshi", "coords[" + i + "]======" + coords[i]);
        // }
        //
        // for (int i = 0; i < result.length / 2; i ++) {
        // Log.w("ceshi", "result[" + i + "]======" + result[i]);
        // }

        // [0.0, 1.0, 1.0, 1.0]; v
        // [0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0]; coords
        // [1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0]; result

        return result;
    }

    /**
     * 加载 著色器
     */
    private int loadShader(int type, String shaderCode) {
        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }

    public void drawPointsMatrix(float[] mvpMatrix) {

        short drawOrder[] = { 0, 1, 2, 0, 2, 3 }; // order to draw

        ByteBuffer dlb = ByteBuffer.allocateDirect(
                // (# of coordinate values * 2 bytes per short)
                drawOrder.length * 2);
        dlb.order(ByteOrder.nativeOrder());
        ShortBuffer drawListBuffer = dlb.asShortBuffer();
        drawListBuffer.put(drawOrder);
        drawListBuffer.position(0);

        short drawLineOrder[] = { 0, 1, 0, 2, 0, 3}; // order to draw

        ByteBuffer line_dlb = ByteBuffer.allocateDirect(
                // (# of coordinate values * 2 bytes per short)
                drawLineOrder.length * 2);
        line_dlb.order(ByteOrder.nativeOrder());
        ShortBuffer drawLineListBuffer = line_dlb.asShortBuffer();
        drawLineListBuffer.put(drawLineOrder);
        drawLineListBuffer.position(0);

        short cubeOrders[][] = {{ 0, 1 }, { 0, 2 }, { 0, 3 } };
        ShortBuffer cubeListBuffer[] = new ShortBuffer[5];
        for (int i = 0; i < cubeOrders.length; ++i) {
            final short cubeOrder[] = cubeOrders[i];
            ByteBuffer cubedlb = ByteBuffer.allocateDirect(
                    // (# of coordinate values * 2 bytes per short)
                    cubeOrder.length * 2);
            cubedlb.order(ByteOrder.nativeOrder());
            cubeListBuffer[i] = cubedlb.asShortBuffer();
            cubeListBuffer[i].put(cubeOrder);
            cubeListBuffer[i].position(0);
        }

        short drawFaceRectOrder[] = {0, 1, 1, 2, 2, 3, 3, 0};

        ByteBuffer faceRectLDB = ByteBuffer.allocateDirect(drawFaceRectOrder.length * 2);
        faceRectLDB.order(ByteOrder.nativeOrder());
        ShortBuffer faceRectListBuffer = faceRectLDB.asShortBuffer();
        faceRectListBuffer.put(drawFaceRectOrder);
        faceRectListBuffer.position(0);

        String vertexShaderCode =
                // This matrix member variable provides a hook to manipulate
                // the coordinates of the objects that use this vertex shader
                "uniform mat4 uMVPMatrix;" +
                        "attribute vec4 vPosition;" + "void main() {" +
                        // the matrix must be included as a modifier of gl_Position
                        "  gl_Position = vPosition * uMVPMatrix; gl_PointSize = 8.0;" + "}";

        String fragmentShaderCode = "precision mediump float;" + "uniform vec4 vColor;" + "void main() {"
                + "  gl_FragColor = vColor;" + "}";

        // prepare shaders and OpenGL program
        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);

        int mProgram = GLES20.glCreateProgram(); // create empty OpenGL Program
        GLES20.glAttachShader(mProgram, vertexShader); // add the vertex shader
        // to program
        GLES20.glAttachShader(mProgram, fragmentShader); // add the fragment
        // shader to program
        GLES20.glLinkProgram(mProgram); // create OpenGL program executables

        // Add program to OpenGL environment
        GLES20.glUseProgram(mProgram);

        // get handle to vertex shader's vPosition member
        int mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");

        // get handle to fragment shader's vColor member
        int mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");

        // get handle to shape's transformation matrix
        int mMVPMatrixHandle = GLES20.glGetUniformLocation(mProgram, "uMVPMatrix");
        checkGlError("glGetUniformLocation");

        // Apply the projection and view transformation
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mvpMatrix, 0);
        checkGlError("glUniformMatrix4fv");
        // Enable a handle to the triangle vertices
        GLES20.glEnableVertexAttribArray(mPositionHandle);

        float color_rect[] = { 0X61 / 255.0f, 0XB3 / 255.0f, 0X4D / 255.0f, 1.0f };

        // Set color for drawing the triangle
        GLES20.glUniform4fv(mColorHandle, 1, color_rect, 0);

        float color[] = { 0.2f, 0.709803922f, 0.898039216f, 1.0f };

        GLES20.glUniform4fv(mColorHandle, 1, color, 0);

        // Disable vertex array
        GLES20.glDisableVertexAttribArray(mPositionHandle);
    }

    public static void checkGlError(String glOperation) {
        int error;
        while ((error = GLES20.glGetError()) != GLES20.GL_NO_ERROR) {
            Log.e("ceshi", glOperation + ": glError " + error);
            throw new RuntimeException(glOperation + ": glError " + error);
        }
    }

    @Override
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        mGlSurfaceView.requestRender();
    }

    @Override
    public void onPreviewFrame(byte[] bytes, Camera camera) {

    }
}
