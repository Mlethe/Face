package com.mlethe.face.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;

import com.mlethe.face.entity.Face;
import com.mlethe.face.entity.Point;

import java.lang.reflect.Field;
import java.util.List;

public class ImageView extends AppCompatImageView {

    private List<Face> faces;

    public ImageView(Context context) {
        this(context, null);
    }

    public ImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        canvas.drawCircle(421.7f, 553.3f, dp2px(2), paint);*/
        if (faces != null && faces.size() > 0) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(dp2px(1));
            // 图片偏移量  0->x方向偏移量    1->y方向偏移量
            int[] offset = getBitmapOffset(true);
            Bitmap bitmap = ((BitmapDrawable)getDrawable()).getBitmap();
//            Log.e("TAG", "onDraw: x->" + face.getLandmark().getContour_chin().getX() + "     y->" + face.getLandmark().getContour_chin().getY() + "     offsetX->" + offset[0] + "    offsetY->" + offset[1] + "   width->" + getMeasuredWidth() + "     height->" + getHeight() + "    imageWidth->" + bitmap.getWidth() + "    imageHeight->" + bitmap.getHeight());
            // 图片与ImageView的比例
            float ratio = (float) (getMeasuredWidth() - (offset[0] * 2)) / bitmap.getWidth();
//            Log.e("TAG", "onDraw: x->" + face.getLandmark().getContour_chin().getX() * ratio + "     y->" + (face.getLandmark().getContour_chin().getY() * ratio + offset[1]) + "    ratio->" + ratio);
            for (Face face : faces) {
                // 绘制所有关键点
                Face.Landmark landmark = face.getLandmark();
                if (landmark != null) {
                    /*Field[] fields = landmark.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        try {
                            Object o = field.get(landmark);
                            if (o instanceof Point) {
                                drawPoint(canvas, (Point) o, ratio, offset, paint);
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }*/
                    Point contour_chin = landmark.getContour_chin();
                    Point nose_tip = landmark.getNose_tip();
                    float radius = (float) Math.sqrt(Math.pow(Math.abs(contour_chin.getX()-nose_tip.getX()), 2) + Math.pow(Math.abs(contour_chin.getY()-nose_tip.getY()), 2));
                    canvas.drawCircle(getPosition(nose_tip.getX(), ratio, offset[0]), getPosition(nose_tip.getY(), ratio, offset[1]), radius * ratio, paint);
                }
            }
        }
    }

    /**
     * 绘制点
     * @param canvas
     * @param point
     * @param ratio
     * @param offset
     * @param paint
     */
    private void drawPoint(Canvas canvas, Point point, float ratio, int[] offset, Paint paint) {
        canvas.drawCircle(getPosition(point.getX(), ratio, offset[0]), getPosition(point.getY(), ratio, offset[1]), dp2px(2), paint);
    }

    /**
     * 计算点的位置
     * @param position
     * @param ratio
     * @param offset
     * @return
     */
    private float getPosition(int position, float ratio, int offset) {
        return position * ratio + offset;
    }

    private float dp2px(int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    public void setFaces(List<Face> faces) {
        this.faces = faces;
        invalidate();
    }

    /**
     * 获取Bitmap在ImageView中的偏移量数组,其中第0个值表示在水平方向上的偏移值,第1个值表示在垂直方向上的偏移值
     * @param includeLayout 在计算偏移的时候是否要考虑到布局的因素,如果要考虑该因素则为true,否则为false
     * @return the offsets of the bitmap inside the imageview, offset[0] means horizontal offset, offset[1] means vertical offset
     */
    private int[] getBitmapOffset(boolean includeLayout) {
        int[] offset = new int[2];
        float[] values = new float[9];

        Matrix matrix = getImageMatrix();
        matrix.getValues(values);

        // x方向上的偏移量(单位px)
        offset[0] = (int) values[2];
        // y方向上的偏移量(单位px)
        offset[1] = (int) values[5];

        if (includeLayout) {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();
            int paddingTop = getPaddingTop();
            int paddingLeft = getPaddingLeft();

            offset[0] += paddingLeft + params.leftMargin;
            offset[1] += paddingTop + params.topMargin;
        }
        return offset;
    }

}
