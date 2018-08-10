package com.mlethe.face.retrofit;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.mlethe.face.entity.Face;

import java.util.List;

public class Result implements Parcelable {
    /**
     * image_id : Dd2xUw9S/7yjr0oDHHSL/Q==
     * request_id : 1470472868,dacf2ff1-ea45-4842-9c07-6e8418cea78b
     * time_used : 752
     * faces : []
     */

    @SerializedName("image_id")
    private String imageId;
    @SerializedName("request_id")
    private String requestId;
    @SerializedName("time_used")
    private int timeUsed;
    @SerializedName("error_message")
    private String errorMessage;
    private List<Face> faces;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(int timeUsed) {
        this.timeUsed = timeUsed;
    }

    public List<Face> getFaces() {
        return faces;
    }

    public void setFaces(List<Face> faces) {
        this.faces = faces;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageId);
        dest.writeString(this.requestId);
        dest.writeInt(this.timeUsed);
        dest.writeTypedList(this.faces);
    }

    public Result() {
    }

    protected Result(Parcel in) {
        this.imageId = in.readString();
        this.requestId = in.readString();
        this.timeUsed = in.readInt();
        this.faces = in.createTypedArrayList(Face.CREATOR);
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel source) {
            return new Result(source);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    @Override
    public String toString() {
        return "Result{" +
                "imageId='" + imageId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", timeUsed=" + timeUsed +
                ", faces=" + faces +
                '}';
    }
}
