package com.mlethe.face.retrofit;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface ServiceApi {

    @Multipart
    @POST("v3/detect")
    Call<Result> detect(@Part MultipartBody.Part image, @PartMap Map<String, RequestBody> params);
}
