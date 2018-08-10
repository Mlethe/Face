package com.mlethe.face.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Point implements Parcelable {
    private int y;
    private int x;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.y);
        dest.writeInt(this.x);
    }

    public Point() {
    }

    protected Point(Parcel in) {
        this.y = in.readInt();
        this.x = in.readInt();
    }

    public static final Parcelable.Creator<Point> CREATOR = new Parcelable.Creator<Point>() {
        @Override
        public Point createFromParcel(Parcel source) {
            return new Point(source);
        }

        @Override
        public Point[] newArray(int size) {
            return new Point[size];
        }
    };
}
