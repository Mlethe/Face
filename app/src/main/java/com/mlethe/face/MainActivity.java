package com.mlethe.face;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.megvii.facepp.sdk.Facepp;
import com.megvii.licensemanager.sdk.LicenseManager;
import com.mlethe.face.entity.Face;
import com.mlethe.face.retrofit.Result;
import com.mlethe.face.retrofit.RetrofitClient;
import com.mlethe.face.retrofit.ServiceApi;
import com.mlethe.face.utils.ConUtil;
import com.mlethe.face.utils.FileUtil;
import com.mlethe.face.utils.Util;
import com.mlethe.face.view.ImageView;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import top.zibin.luban.Luban;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button chooseBtn, cameraBtn;

    private ImageView imageIv;

    private Facepp facepp;

    private static final int PHOTO_REQUEST_GALLERY = 0x0011;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chooseBtn = findViewById(R.id.choose_btn);
        cameraBtn = findViewById(R.id.camera_btn);
        imageIv = findViewById(R.id.image_iv);
        chooseBtn.setOnClickListener(this);
        cameraBtn.setOnClickListener(this);
        facepp = new Facepp();
        int type = Facepp.getSDKAuthType(ConUtil.getFileContent(this, R.raw.megviifacepp_0_5_2_model));
        if (type == 2) {    // 非联网授权
            String errorCode = facepp.init(this, ConUtil.getFileContent(this, R.raw.megviifacepp_0_5_2_model), 1);
            if (TextUtils.isEmpty(errorCode)) {
                return;
            }
            Facepp.FaceppConfig faceppConfig = facepp.getFaceppConfig();
            faceppConfig.detectionMode = Facepp.FaceppConfig.DETECTION_MODE_TRACKING_FAST;
            facepp.setFaceppConfig(faceppConfig);
            Log.e("TAG", "onCreate: 非联网授权");
        } else {
            final LicenseManager licenseManager = new LicenseManager(this);
            String uuid = ConUtil.getUUIDString(this);
            long apiName = Facepp.getApiName();

            licenseManager.setAuthTimeBufferMillis(0);

            licenseManager.takeLicenseFromNetwork(Util.CN_LICENSE_URL,uuid, Util.API_KEY, Util.API_SECRET, apiName,
                    "1", new LicenseManager.TakeLicenseCallback() {
                        @Override
                        public void onSuccess() {
                            String errorCode = facepp.init(MainActivity.this, ConUtil.getFileContent(MainActivity.this, R.raw.megviifacepp_0_5_2_model), 1);
                            Log.e("TAG", "onSuccess: 初始化成功" + "    errorCode->" + errorCode);
                            Facepp.FaceppConfig faceppConfig = facepp.getFaceppConfig();
                            faceppConfig.detectionMode = Facepp.FaceppConfig.DETECTION_MODE_TRACKING_FAST;
                            facepp.setFaceppConfig(faceppConfig);
                            Toast.makeText(MainActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailed(int i, byte[] bytes) {
                            if (TextUtils.isEmpty(Util.API_KEY)||TextUtils.isEmpty(Util.API_SECRET)) {
                                if (!ConUtil.isReadKey(MainActivity.this)) {
                                    Toast.makeText(MainActivity.this, "请到官网申请并填写API_KEY和API_SECRET", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(MainActivity.this, "请到官网申请并填写API_KEY和API_SECRET", Toast.LENGTH_SHORT).show();
                                }
                                Log.e("TAG", "onFailed: 请到官网申请并填写API_KEY和API_SECRET");
                            }else{
                                String msg="";
                                if (bytes!=null&&bytes.length>0){
                                    msg=  new String(bytes);
                                }
                                Toast.makeText(MainActivity.this, "code="+i+"，msg="+msg, Toast.LENGTH_SHORT).show();
                                Log.e("TAG", "onFailed: code="+i+"，msg="+msg);
                            }
                        }
                    });
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.choose_btn) {
            // 激活系统图库，选择一张图片
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
            startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
        } else if (id == R.id.camera_btn) {
            Intent intent = new Intent(this, CameraActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode == PHOTO_REQUEST_GALLERY) {
            Uri uri = data.getData();
            /*Log.e("TAG", "onActivityResult: path->" + FileUtil.getFilePathByUri(this, uri));
            Luban.with(this)
                    .load(FileUtil.getFilePathByUri(this, uri))
                    .ignoreBy(100)
                    .setTargetDir(getPath())
                    .setFocusAlpha(false)
                    .filter(new CompressionPredicate() {
                        @Override
                        public boolean apply(String path) {
                            return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                        }
                    })
                    .setCompressListener(new OnCompressListener() {
                        @Override
                        public void onStart() {
                            // TODO 压缩开始前调用，可以在方法内启动 loading UI
                        }

                        @Override
                        public void onSuccess(File file) {
                            // TODO 压缩成功后调用，返回压缩后的图片文件
                            if (file.exists()) {
                                Log.e("TAG", "onSuccess: 存在");
                            } else {
                                Log.e("TAG", "onSuccess: 不存在");
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            // TODO 当压缩过程出现问题时调用
                            e.printStackTrace();
                        }
                    }).launch();*/
            if (uri != null) {
                String path = FileUtil.getFilePathByUri(this, uri);
                if (TextUtils.isEmpty(path)) {
                    return;
                }
                Flowable.just(FileUtil.getFilePathByUri(this, uri))
                        .observeOn(Schedulers.io())
                        .map(new Function<String, File>() {
                            @Override
                            public File apply(String string) throws Exception {
                                List<File> files = Luban.with(MainActivity.this).load(string).ignoreBy(100).setTargetDir(getPath()).get();
                                if (files == null && files.size() <= 0) {
                                    return null;
                                }
                                return files.get(0);
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<File>() {
                            @Override
                            public void accept(File file) throws Exception {
                                submit(file);
//                            Facepp.Face[] faces = facepp.detect(FileUtil.getBytes(file), bitmap.getWidth(), bitmap.getHeight(), Facepp.IMAGEMODE_NV21);
//                            Log.e("TAG", "onActivityResult: faces->" + faces);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                throwable.printStackTrace();
                            }
                        });
            }
            /*try {
                List<File> files = Luban.with(MainActivity.this).load(uri).get();
                Bitmap bitmap = BitmapFactory.decodeFile(files.get(0).getPath());
                Facepp.Face[] faces = facepp.detect(FileUtil.getBytes(files.get(0)), bitmap.getWidth(), bitmap.getHeight(), Facepp.IMAGEMODE_NV21);
                Log.e("TAG", "onActivityResult: faces->" + faces);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
    }

    private void submit(final File file) {
        RequestBody fileRequest = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("image_file", file.getName(), fileRequest);
        Map<String, RequestBody> params = new HashMap<>();
        params.put("api_key", createRequestBody(Util.API_KEY));
        params.put("api_secret", createRequestBody(Util.API_SECRET));
        params.put("return_landmark", createRequestBody(2 + ""));
        RetrofitClient.getInstance().create(ServiceApi.class)
                .detect(part, params)
                .enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
                        imageIv.setImageBitmap(bitmap);
                        List<Face> faces = response.body().getFaces();
                        if (faces != null)
                            imageIv.setFaces(faces);
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    private RequestBody createRequestBody(String string) {
        RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), string);
        return body;
    }

    private String getPath() {
        String path = Environment.getExternalStorageDirectory() + "/Luban/image/";
        File file = new File(path);
        if (file.mkdirs()) {
            return path;
        }
        return path;
    }

    @Override
    protected void onDestroy() {
        facepp.release();
        super.onDestroy();
    }
}
