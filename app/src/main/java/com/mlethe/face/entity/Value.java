package com.mlethe.face.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Value implements Parcelable {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.value);
    }

    public Value() {
    }

    protected Value(Parcel in) {
        this.value = in.readString();
    }

    public static final Parcelable.Creator<Value> CREATOR = new Parcelable.Creator<Value>() {
        @Override
        public Value createFromParcel(Parcel source) {
            return new Value(source);
        }

        @Override
        public Value[] newArray(int size) {
            return new Value[size];
        }
    };
}
