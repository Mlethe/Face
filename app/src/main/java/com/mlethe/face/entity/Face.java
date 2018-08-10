package com.mlethe.face.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Face implements Parcelable {
    /**
     * landmark : {"mouth_upper_lip_left_contour2":{"y":185,"x":146},"contour_chin":{"y":231,"x":137},"right_eye_pupil":{"y":146,"x":205},"mouth_upper_lip_bottom":{"y":195,"x":159}}
     * attributes : {"gender":{"value":"Female"},"age":{"value":21},"glass":{"value":"None"},"headpose":{"yaw_angle":-26.625063,"pitch_angle":12.921974,"roll_angle":22.814377},"smile":{"threshold":30.1,"value":2.566890001296997}}
     * face_rectangle : {"width":140,"top":89,"left":104,"height":141}
     * face_token : ed319e807e039ae669a4d1af0922a0c8
     */

    private Landmark landmark;
    private Attributes attributes;
    @SerializedName("face_rectangle")
    private FaceRectangle faceRectangle;
    @SerializedName("face_token")
    private String faceToken;

    public Landmark getLandmark() {
        return landmark;
    }

    public void setLandmark(Landmark landmark) {
        this.landmark = landmark;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public FaceRectangle getFaceRectangle() {
        return faceRectangle;
    }

    public void setFaceRectangle(FaceRectangle faceRectangle) {
        this.faceRectangle = faceRectangle;
    }

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }

    public static class Landmark implements Parcelable {
        private Point contour_left1;
        private Point contour_left2;
        private Point contour_left3;
        private Point contour_left4;
        private Point contour_left5;
        private Point contour_left6;
        private Point contour_left7;
        private Point contour_left8;
        private Point contour_left9;
        private Point contour_left10;
        private Point contour_left11;
        private Point contour_left12;
        private Point contour_left13;
        private Point contour_left14;
        private Point contour_left15;
        private Point contour_left16;
        private Point contour_chin;
        private Point contour_right1;
        private Point contour_right2;
        private Point contour_right3;
        private Point contour_right4;
        private Point contour_right5;
        private Point contour_right6;
        private Point contour_right7;
        private Point contour_right8;
        private Point contour_right9;
        private Point contour_right10;
        private Point contour_right11;
        private Point contour_right12;
        private Point contour_right13;
        private Point contour_right14;
        private Point contour_right15;
        private Point contour_right16;
        private Point left_eyebrow_left_corner;
        private Point left_eyebrow_upper_left_quarter;
        private Point left_eyebrow_upper_middle;
        private Point left_eyebrow_upper_right_quarter;
        private Point left_eyebrow_upper_right_corner;
        private Point left_eyebrow_lower_left_quarter;
        private Point left_eyebrow_lower_middle;
        private Point left_eyebrow_lower_right_quarter;
        private Point left_eyebrow_lower_right_corner;
        private Point right_eyebrow_upper_left_corner;
        private Point right_eyebrow_upper_left_quarter;
        private Point right_eyebrow_upper_middle;
        private Point right_eyebrow_upper_right_quarter;
        private Point right_eyebrow_right_corner;
        private Point right_eyebrow_lower_left_corner;
        private Point right_eyebrow_lower_left_quarter;
        private Point right_eyebrow_lower_middle;
        private Point right_eyebrow_lower_right_quarter;
        // 鼻子106点
        private Point nose_bridge1;
        private Point nose_bridge2;
        private Point nose_bridge3;
        private Point nose_left_contour1;
        private Point nose_left_contour2;
        private Point nose_left_contour3;
        private Point nose_left_contour4;
        private Point nose_left_contour5;
        private Point nose_middle_contour;
        private Point nose_right_contour1;
        private Point nose_right_contour2;
        private Point nose_right_contour3;
        private Point nose_right_contour4;
        private Point nose_right_contour5;
        // 鼻子83点
        private Point nose_contour_left1;
        private Point nose_contour_left2;
        private Point nose_contour_left3;
        private Point nose_contour_lower_middle;
        private Point nose_contour_right1;
        private Point nose_contour_right2;
        private Point nose_contour_right3;
        private Point nose_left;
        private Point nose_right;

        private Point nose_tip;

        private Point left_eye_left_corner;
        private Point left_eye_upper_left_quarter;
        private Point left_eye_top;
        private Point left_eye_upper_right_quarter;
        private Point left_eye_right_corner;
        private Point left_eye_lower_right_quarter;
        private Point left_eye_bottom;
        private Point left_eye_lower_left_quarter;
        private Point left_eye_pupil;
        private Point left_eye_center;
        private Point right_eye_left_corner;
        private Point right_eye_upper_left_quarter;
        private Point right_eye_top;
        private Point right_eye_upper_right_quarter;
        private Point right_eye_right_corner;
        private Point right_eye_lower_right_quarter;
        private Point right_eye_bottom;
        private Point right_eye_lower_left_quarter;
        private Point right_eye_pupil;
        private Point right_eye_center;
        private Point mouth_left_corner;
        private Point mouth_upper_lip_left_contour1;
        private Point mouth_upper_lip_left_contour2;
        private Point mouth_upper_lip_left_contour3;
        private Point mouth_upper_lip_left_contour4;
        private Point mouth_right_corner;
        private Point mouth_upper_lip_right_contour1;
        private Point mouth_upper_lip_right_contour2;
        private Point mouth_upper_lip_right_contour3;
        private Point mouth_upper_lip_right_contour4;
        private Point mouth_upper_lip_top;
        private Point mouth_upper_lip_bottom;
        private Point mouth_lower_lip_right_contour1;
        private Point mouth_lower_lip_right_contour2;
        private Point mouth_lower_lip_right_contour3;
        private Point mouth_lower_lip_left_contour1;
        private Point mouth_lower_lip_left_contour2;
        private Point mouth_lower_lip_left_contour3;
        private Point mouth_lower_lip_top;
        private Point mouth_lower_lip_bottom;

        public Point getContour_left1() {
            return contour_left1;
        }

        public void setContour_left1(Point contour_left1) {
            this.contour_left1 = contour_left1;
        }

        public Point getContour_left2() {
            return contour_left2;
        }

        public void setContour_left2(Point contour_left2) {
            this.contour_left2 = contour_left2;
        }

        public Point getContour_left3() {
            return contour_left3;
        }

        public void setContour_left3(Point contour_left3) {
            this.contour_left3 = contour_left3;
        }

        public Point getContour_left4() {
            return contour_left4;
        }

        public void setContour_left4(Point contour_left4) {
            this.contour_left4 = contour_left4;
        }

        public Point getContour_left5() {
            return contour_left5;
        }

        public void setContour_left5(Point contour_left5) {
            this.contour_left5 = contour_left5;
        }

        public Point getContour_left6() {
            return contour_left6;
        }

        public void setContour_left6(Point contour_left6) {
            this.contour_left6 = contour_left6;
        }

        public Point getContour_left7() {
            return contour_left7;
        }

        public void setContour_left7(Point contour_left7) {
            this.contour_left7 = contour_left7;
        }

        public Point getContour_left8() {
            return contour_left8;
        }

        public void setContour_left8(Point contour_left8) {
            this.contour_left8 = contour_left8;
        }

        public Point getContour_left9() {
            return contour_left9;
        }

        public void setContour_left9(Point contour_left9) {
            this.contour_left9 = contour_left9;
        }

        public Point getContour_left10() {
            return contour_left10;
        }

        public void setContour_left10(Point contour_left10) {
            this.contour_left10 = contour_left10;
        }

        public Point getContour_left11() {
            return contour_left11;
        }

        public void setContour_left11(Point contour_left11) {
            this.contour_left11 = contour_left11;
        }

        public Point getContour_left12() {
            return contour_left12;
        }

        public void setContour_left12(Point contour_left12) {
            this.contour_left12 = contour_left12;
        }

        public Point getContour_left13() {
            return contour_left13;
        }

        public void setContour_left13(Point contour_left13) {
            this.contour_left13 = contour_left13;
        }

        public Point getContour_left14() {
            return contour_left14;
        }

        public void setContour_left14(Point contour_left14) {
            this.contour_left14 = contour_left14;
        }

        public Point getContour_left15() {
            return contour_left15;
        }

        public void setContour_left15(Point contour_left15) {
            this.contour_left15 = contour_left15;
        }

        public Point getContour_left16() {
            return contour_left16;
        }

        public void setContour_left16(Point contour_left16) {
            this.contour_left16 = contour_left16;
        }

        public Point getContour_chin() {
            return contour_chin;
        }

        public void setContour_chin(Point contour_chin) {
            this.contour_chin = contour_chin;
        }

        public Point getContour_right1() {
            return contour_right1;
        }

        public void setContour_right1(Point contour_right1) {
            this.contour_right1 = contour_right1;
        }

        public Point getContour_right2() {
            return contour_right2;
        }

        public void setContour_right2(Point contour_right2) {
            this.contour_right2 = contour_right2;
        }

        public Point getContour_right3() {
            return contour_right3;
        }

        public void setContour_right3(Point contour_right3) {
            this.contour_right3 = contour_right3;
        }

        public Point getContour_right4() {
            return contour_right4;
        }

        public void setContour_right4(Point contour_right4) {
            this.contour_right4 = contour_right4;
        }

        public Point getContour_right5() {
            return contour_right5;
        }

        public void setContour_right5(Point contour_right5) {
            this.contour_right5 = contour_right5;
        }

        public Point getContour_right6() {
            return contour_right6;
        }

        public void setContour_right6(Point contour_right6) {
            this.contour_right6 = contour_right6;
        }

        public Point getContour_right7() {
            return contour_right7;
        }

        public void setContour_right7(Point contour_right7) {
            this.contour_right7 = contour_right7;
        }

        public Point getContour_right8() {
            return contour_right8;
        }

        public void setContour_right8(Point contour_right8) {
            this.contour_right8 = contour_right8;
        }

        public Point getContour_right9() {
            return contour_right9;
        }

        public void setContour_right9(Point contour_right9) {
            this.contour_right9 = contour_right9;
        }

        public Point getContour_right10() {
            return contour_right10;
        }

        public void setContour_right10(Point contour_right10) {
            this.contour_right10 = contour_right10;
        }

        public Point getContour_right11() {
            return contour_right11;
        }

        public void setContour_right11(Point contour_right11) {
            this.contour_right11 = contour_right11;
        }

        public Point getContour_right12() {
            return contour_right12;
        }

        public void setContour_right12(Point contour_right12) {
            this.contour_right12 = contour_right12;
        }

        public Point getContour_right13() {
            return contour_right13;
        }

        public void setContour_right13(Point contour_right13) {
            this.contour_right13 = contour_right13;
        }

        public Point getContour_right14() {
            return contour_right14;
        }

        public void setContour_right14(Point contour_right14) {
            this.contour_right14 = contour_right14;
        }

        public Point getContour_right15() {
            return contour_right15;
        }

        public void setContour_right15(Point contour_right15) {
            this.contour_right15 = contour_right15;
        }

        public Point getContour_right16() {
            return contour_right16;
        }

        public void setContour_right16(Point contour_right16) {
            this.contour_right16 = contour_right16;
        }

        public Point getLeft_eyebrow_left_corner() {
            return left_eyebrow_left_corner;
        }

        public void setLeft_eyebrow_left_corner(Point left_eyebrow_left_corner) {
            this.left_eyebrow_left_corner = left_eyebrow_left_corner;
        }

        public Point getLeft_eyebrow_upper_left_quarter() {
            return left_eyebrow_upper_left_quarter;
        }

        public void setLeft_eyebrow_upper_left_quarter(Point left_eyebrow_upper_left_quarter) {
            this.left_eyebrow_upper_left_quarter = left_eyebrow_upper_left_quarter;
        }

        public Point getLeft_eyebrow_upper_middle() {
            return left_eyebrow_upper_middle;
        }

        public void setLeft_eyebrow_upper_middle(Point left_eyebrow_upper_middle) {
            this.left_eyebrow_upper_middle = left_eyebrow_upper_middle;
        }

        public Point getLeft_eyebrow_upper_right_quarter() {
            return left_eyebrow_upper_right_quarter;
        }

        public void setLeft_eyebrow_upper_right_quarter(Point left_eyebrow_upper_right_quarter) {
            this.left_eyebrow_upper_right_quarter = left_eyebrow_upper_right_quarter;
        }

        public Point getLeft_eyebrow_upper_right_corner() {
            return left_eyebrow_upper_right_corner;
        }

        public void setLeft_eyebrow_upper_right_corner(Point left_eyebrow_upper_right_corner) {
            this.left_eyebrow_upper_right_corner = left_eyebrow_upper_right_corner;
        }

        public Point getLeft_eyebrow_lower_left_quarter() {
            return left_eyebrow_lower_left_quarter;
        }

        public void setLeft_eyebrow_lower_left_quarter(Point left_eyebrow_lower_left_quarter) {
            this.left_eyebrow_lower_left_quarter = left_eyebrow_lower_left_quarter;
        }

        public Point getLeft_eyebrow_lower_middle() {
            return left_eyebrow_lower_middle;
        }

        public void setLeft_eyebrow_lower_middle(Point left_eyebrow_lower_middle) {
            this.left_eyebrow_lower_middle = left_eyebrow_lower_middle;
        }

        public Point getLeft_eyebrow_lower_right_quarter() {
            return left_eyebrow_lower_right_quarter;
        }

        public void setLeft_eyebrow_lower_right_quarter(Point left_eyebrow_lower_right_quarter) {
            this.left_eyebrow_lower_right_quarter = left_eyebrow_lower_right_quarter;
        }

        public Point getLeft_eyebrow_lower_right_corner() {
            return left_eyebrow_lower_right_corner;
        }

        public void setLeft_eyebrow_lower_right_corner(Point left_eyebrow_lower_right_corner) {
            this.left_eyebrow_lower_right_corner = left_eyebrow_lower_right_corner;
        }

        public Point getRight_eyebrow_upper_left_corner() {
            return right_eyebrow_upper_left_corner;
        }

        public void setRight_eyebrow_upper_left_corner(Point right_eyebrow_upper_left_corner) {
            this.right_eyebrow_upper_left_corner = right_eyebrow_upper_left_corner;
        }

        public Point getRight_eyebrow_upper_left_quarter() {
            return right_eyebrow_upper_left_quarter;
        }

        public void setRight_eyebrow_upper_left_quarter(Point right_eyebrow_upper_left_quarter) {
            this.right_eyebrow_upper_left_quarter = right_eyebrow_upper_left_quarter;
        }

        public Point getRight_eyebrow_upper_middle() {
            return right_eyebrow_upper_middle;
        }

        public void setRight_eyebrow_upper_middle(Point right_eyebrow_upper_middle) {
            this.right_eyebrow_upper_middle = right_eyebrow_upper_middle;
        }

        public Point getRight_eyebrow_upper_right_quarter() {
            return right_eyebrow_upper_right_quarter;
        }

        public void setRight_eyebrow_upper_right_quarter(Point right_eyebrow_upper_right_quarter) {
            this.right_eyebrow_upper_right_quarter = right_eyebrow_upper_right_quarter;
        }

        public Point getRight_eyebrow_right_corner() {
            return right_eyebrow_right_corner;
        }

        public void setRight_eyebrow_right_corner(Point right_eyebrow_right_corner) {
            this.right_eyebrow_right_corner = right_eyebrow_right_corner;
        }

        public Point getRight_eyebrow_lower_left_corner() {
            return right_eyebrow_lower_left_corner;
        }

        public void setRight_eyebrow_lower_left_corner(Point right_eyebrow_lower_left_corner) {
            this.right_eyebrow_lower_left_corner = right_eyebrow_lower_left_corner;
        }

        public Point getRight_eyebrow_lower_left_quarter() {
            return right_eyebrow_lower_left_quarter;
        }

        public void setRight_eyebrow_lower_left_quarter(Point right_eyebrow_lower_left_quarter) {
            this.right_eyebrow_lower_left_quarter = right_eyebrow_lower_left_quarter;
        }

        public Point getRight_eyebrow_lower_middle() {
            return right_eyebrow_lower_middle;
        }

        public void setRight_eyebrow_lower_middle(Point right_eyebrow_lower_middle) {
            this.right_eyebrow_lower_middle = right_eyebrow_lower_middle;
        }

        public Point getRight_eyebrow_lower_right_quarter() {
            return right_eyebrow_lower_right_quarter;
        }

        public void setRight_eyebrow_lower_right_quarter(Point right_eyebrow_lower_right_quarter) {
            this.right_eyebrow_lower_right_quarter = right_eyebrow_lower_right_quarter;
        }

        public Point getNose_bridge1() {
            return nose_bridge1;
        }

        public void setNose_bridge1(Point nose_bridge1) {
            this.nose_bridge1 = nose_bridge1;
        }

        public Point getNose_bridge2() {
            return nose_bridge2;
        }

        public void setNose_bridge2(Point nose_bridge2) {
            this.nose_bridge2 = nose_bridge2;
        }

        public Point getNose_bridge3() {
            return nose_bridge3;
        }

        public void setNose_bridge3(Point nose_bridge3) {
            this.nose_bridge3 = nose_bridge3;
        }

        public Point getNose_left_contour1() {
            return nose_left_contour1;
        }

        public void setNose_left_contour1(Point nose_left_contour1) {
            this.nose_left_contour1 = nose_left_contour1;
        }

        public Point getNose_left_contour2() {
            return nose_left_contour2;
        }

        public void setNose_left_contour2(Point nose_left_contour2) {
            this.nose_left_contour2 = nose_left_contour2;
        }

        public Point getNose_left_contour3() {
            return nose_left_contour3;
        }

        public void setNose_left_contour3(Point nose_left_contour3) {
            this.nose_left_contour3 = nose_left_contour3;
        }

        public Point getNose_left_contour4() {
            return nose_left_contour4;
        }

        public void setNose_left_contour4(Point nose_left_contour4) {
            this.nose_left_contour4 = nose_left_contour4;
        }

        public Point getNose_left_contour5() {
            return nose_left_contour5;
        }

        public void setNose_left_contour5(Point nose_left_contour5) {
            this.nose_left_contour5 = nose_left_contour5;
        }

        public Point getNose_middle_contour() {
            return nose_middle_contour;
        }

        public void setNose_middle_contour(Point nose_middle_contour) {
            this.nose_middle_contour = nose_middle_contour;
        }

        public Point getNose_right_contour1() {
            return nose_right_contour1;
        }

        public void setNose_right_contour1(Point nose_right_contour1) {
            this.nose_right_contour1 = nose_right_contour1;
        }

        public Point getNose_right_contour2() {
            return nose_right_contour2;
        }

        public void setNose_right_contour2(Point nose_right_contour2) {
            this.nose_right_contour2 = nose_right_contour2;
        }

        public Point getNose_right_contour3() {
            return nose_right_contour3;
        }

        public void setNose_right_contour3(Point nose_right_contour3) {
            this.nose_right_contour3 = nose_right_contour3;
        }

        public Point getNose_right_contour4() {
            return nose_right_contour4;
        }

        public void setNose_right_contour4(Point nose_right_contour4) {
            this.nose_right_contour4 = nose_right_contour4;
        }

        public Point getNose_right_contour5() {
            return nose_right_contour5;
        }

        public void setNose_right_contour5(Point nose_right_contour5) {
            this.nose_right_contour5 = nose_right_contour5;
        }

        public Point getNose_contour_left1() {
            return nose_contour_left1;
        }

        public void setNose_contour_left1(Point nose_contour_left1) {
            this.nose_contour_left1 = nose_contour_left1;
        }

        public Point getNose_contour_left2() {
            return nose_contour_left2;
        }

        public void setNose_contour_left2(Point nose_contour_left2) {
            this.nose_contour_left2 = nose_contour_left2;
        }

        public Point getNose_contour_left3() {
            return nose_contour_left3;
        }

        public void setNose_contour_left3(Point nose_contour_left3) {
            this.nose_contour_left3 = nose_contour_left3;
        }

        public Point getNose_contour_lower_middle() {
            return nose_contour_lower_middle;
        }

        public void setNose_contour_lower_middle(Point nose_contour_lower_middle) {
            this.nose_contour_lower_middle = nose_contour_lower_middle;
        }

        public Point getNose_contour_right1() {
            return nose_contour_right1;
        }

        public void setNose_contour_right1(Point nose_contour_right1) {
            this.nose_contour_right1 = nose_contour_right1;
        }

        public Point getNose_contour_right2() {
            return nose_contour_right2;
        }

        public void setNose_contour_right2(Point nose_contour_right2) {
            this.nose_contour_right2 = nose_contour_right2;
        }

        public Point getNose_contour_right3() {
            return nose_contour_right3;
        }

        public void setNose_contour_right3(Point nose_contour_right3) {
            this.nose_contour_right3 = nose_contour_right3;
        }

        public Point getNose_left() {
            return nose_left;
        }

        public void setNose_left(Point nose_left) {
            this.nose_left = nose_left;
        }

        public Point getNose_right() {
            return nose_right;
        }

        public void setNose_right(Point nose_right) {
            this.nose_right = nose_right;
        }

        public Point getNose_tip() {
            return nose_tip;
        }

        public void setNose_tip(Point nose_tip) {
            this.nose_tip = nose_tip;
        }

        public Point getLeft_eye_left_corner() {
            return left_eye_left_corner;
        }

        public void setLeft_eye_left_corner(Point left_eye_left_corner) {
            this.left_eye_left_corner = left_eye_left_corner;
        }

        public Point getLeft_eye_upper_left_quarter() {
            return left_eye_upper_left_quarter;
        }

        public void setLeft_eye_upper_left_quarter(Point left_eye_upper_left_quarter) {
            this.left_eye_upper_left_quarter = left_eye_upper_left_quarter;
        }

        public Point getLeft_eye_top() {
            return left_eye_top;
        }

        public void setLeft_eye_top(Point left_eye_top) {
            this.left_eye_top = left_eye_top;
        }

        public Point getLeft_eye_upper_right_quarter() {
            return left_eye_upper_right_quarter;
        }

        public void setLeft_eye_upper_right_quarter(Point left_eye_upper_right_quarter) {
            this.left_eye_upper_right_quarter = left_eye_upper_right_quarter;
        }

        public Point getLeft_eye_right_corner() {
            return left_eye_right_corner;
        }

        public void setLeft_eye_right_corner(Point left_eye_right_corner) {
            this.left_eye_right_corner = left_eye_right_corner;
        }

        public Point getLeft_eye_lower_right_quarter() {
            return left_eye_lower_right_quarter;
        }

        public void setLeft_eye_lower_right_quarter(Point left_eye_lower_right_quarter) {
            this.left_eye_lower_right_quarter = left_eye_lower_right_quarter;
        }

        public Point getLeft_eye_bottom() {
            return left_eye_bottom;
        }

        public void setLeft_eye_bottom(Point left_eye_bottom) {
            this.left_eye_bottom = left_eye_bottom;
        }

        public Point getLeft_eye_lower_left_quarter() {
            return left_eye_lower_left_quarter;
        }

        public void setLeft_eye_lower_left_quarter(Point left_eye_lower_left_quarter) {
            this.left_eye_lower_left_quarter = left_eye_lower_left_quarter;
        }

        public Point getLeft_eye_pupil() {
            return left_eye_pupil;
        }

        public void setLeft_eye_pupil(Point left_eye_pupil) {
            this.left_eye_pupil = left_eye_pupil;
        }

        public Point getLeft_eye_center() {
            return left_eye_center;
        }

        public void setLeft_eye_center(Point left_eye_center) {
            this.left_eye_center = left_eye_center;
        }

        public Point getRight_eye_left_corner() {
            return right_eye_left_corner;
        }

        public void setRight_eye_left_corner(Point right_eye_left_corner) {
            this.right_eye_left_corner = right_eye_left_corner;
        }

        public Point getRight_eye_upper_left_quarter() {
            return right_eye_upper_left_quarter;
        }

        public void setRight_eye_upper_left_quarter(Point right_eye_upper_left_quarter) {
            this.right_eye_upper_left_quarter = right_eye_upper_left_quarter;
        }

        public Point getRight_eye_top() {
            return right_eye_top;
        }

        public void setRight_eye_top(Point right_eye_top) {
            this.right_eye_top = right_eye_top;
        }

        public Point getRight_eye_upper_right_quarter() {
            return right_eye_upper_right_quarter;
        }

        public void setRight_eye_upper_right_quarter(Point right_eye_upper_right_quarter) {
            this.right_eye_upper_right_quarter = right_eye_upper_right_quarter;
        }

        public Point getRight_eye_right_corner() {
            return right_eye_right_corner;
        }

        public void setRight_eye_right_corner(Point right_eye_right_corner) {
            this.right_eye_right_corner = right_eye_right_corner;
        }

        public Point getRight_eye_lower_right_quarter() {
            return right_eye_lower_right_quarter;
        }

        public void setRight_eye_lower_right_quarter(Point right_eye_lower_right_quarter) {
            this.right_eye_lower_right_quarter = right_eye_lower_right_quarter;
        }

        public Point getRight_eye_bottom() {
            return right_eye_bottom;
        }

        public void setRight_eye_bottom(Point right_eye_bottom) {
            this.right_eye_bottom = right_eye_bottom;
        }

        public Point getRight_eye_lower_left_quarter() {
            return right_eye_lower_left_quarter;
        }

        public void setRight_eye_lower_left_quarter(Point right_eye_lower_left_quarter) {
            this.right_eye_lower_left_quarter = right_eye_lower_left_quarter;
        }

        public Point getRight_eye_pupil() {
            return right_eye_pupil;
        }

        public void setRight_eye_pupil(Point right_eye_pupil) {
            this.right_eye_pupil = right_eye_pupil;
        }

        public Point getRight_eye_center() {
            return right_eye_center;
        }

        public void setRight_eye_center(Point right_eye_center) {
            this.right_eye_center = right_eye_center;
        }

        public Point getMouth_left_corner() {
            return mouth_left_corner;
        }

        public void setMouth_left_corner(Point mouth_left_corner) {
            this.mouth_left_corner = mouth_left_corner;
        }

        public Point getMouth_upper_lip_left_contour1() {
            return mouth_upper_lip_left_contour1;
        }

        public void setMouth_upper_lip_left_contour1(Point mouth_upper_lip_left_contour1) {
            this.mouth_upper_lip_left_contour1 = mouth_upper_lip_left_contour1;
        }

        public Point getMouth_upper_lip_left_contour2() {
            return mouth_upper_lip_left_contour2;
        }

        public void setMouth_upper_lip_left_contour2(Point mouth_upper_lip_left_contour2) {
            this.mouth_upper_lip_left_contour2 = mouth_upper_lip_left_contour2;
        }

        public Point getMouth_upper_lip_left_contour3() {
            return mouth_upper_lip_left_contour3;
        }

        public void setMouth_upper_lip_left_contour3(Point mouth_upper_lip_left_contour3) {
            this.mouth_upper_lip_left_contour3 = mouth_upper_lip_left_contour3;
        }

        public Point getMouth_upper_lip_left_contour4() {
            return mouth_upper_lip_left_contour4;
        }

        public void setMouth_upper_lip_left_contour4(Point mouth_upper_lip_left_contour4) {
            this.mouth_upper_lip_left_contour4 = mouth_upper_lip_left_contour4;
        }

        public Point getMouth_right_corner() {
            return mouth_right_corner;
        }

        public void setMouth_right_corner(Point mouth_right_corner) {
            this.mouth_right_corner = mouth_right_corner;
        }

        public Point getMouth_upper_lip_right_contour1() {
            return mouth_upper_lip_right_contour1;
        }

        public void setMouth_upper_lip_right_contour1(Point mouth_upper_lip_right_contour1) {
            this.mouth_upper_lip_right_contour1 = mouth_upper_lip_right_contour1;
        }

        public Point getMouth_upper_lip_right_contour2() {
            return mouth_upper_lip_right_contour2;
        }

        public void setMouth_upper_lip_right_contour2(Point mouth_upper_lip_right_contour2) {
            this.mouth_upper_lip_right_contour2 = mouth_upper_lip_right_contour2;
        }

        public Point getMouth_upper_lip_right_contour3() {
            return mouth_upper_lip_right_contour3;
        }

        public void setMouth_upper_lip_right_contour3(Point mouth_upper_lip_right_contour3) {
            this.mouth_upper_lip_right_contour3 = mouth_upper_lip_right_contour3;
        }

        public Point getMouth_upper_lip_right_contour4() {
            return mouth_upper_lip_right_contour4;
        }

        public void setMouth_upper_lip_right_contour4(Point mouth_upper_lip_right_contour4) {
            this.mouth_upper_lip_right_contour4 = mouth_upper_lip_right_contour4;
        }

        public Point getMouth_upper_lip_top() {
            return mouth_upper_lip_top;
        }

        public void setMouth_upper_lip_top(Point mouth_upper_lip_top) {
            this.mouth_upper_lip_top = mouth_upper_lip_top;
        }

        public Point getMouth_upper_lip_bottom() {
            return mouth_upper_lip_bottom;
        }

        public void setMouth_upper_lip_bottom(Point mouth_upper_lip_bottom) {
            this.mouth_upper_lip_bottom = mouth_upper_lip_bottom;
        }

        public Point getMouth_lower_lip_right_contour1() {
            return mouth_lower_lip_right_contour1;
        }

        public void setMouth_lower_lip_right_contour1(Point mouth_lower_lip_right_contour1) {
            this.mouth_lower_lip_right_contour1 = mouth_lower_lip_right_contour1;
        }

        public Point getMouth_lower_lip_right_contour2() {
            return mouth_lower_lip_right_contour2;
        }

        public void setMouth_lower_lip_right_contour2(Point mouth_lower_lip_right_contour2) {
            this.mouth_lower_lip_right_contour2 = mouth_lower_lip_right_contour2;
        }

        public Point getMouth_lower_lip_right_contour3() {
            return mouth_lower_lip_right_contour3;
        }

        public void setMouth_lower_lip_right_contour3(Point mouth_lower_lip_right_contour3) {
            this.mouth_lower_lip_right_contour3 = mouth_lower_lip_right_contour3;
        }

        public Point getMouth_lower_lip_left_contour1() {
            return mouth_lower_lip_left_contour1;
        }

        public void setMouth_lower_lip_left_contour1(Point mouth_lower_lip_left_contour1) {
            this.mouth_lower_lip_left_contour1 = mouth_lower_lip_left_contour1;
        }

        public Point getMouth_lower_lip_left_contour2() {
            return mouth_lower_lip_left_contour2;
        }

        public void setMouth_lower_lip_left_contour2(Point mouth_lower_lip_left_contour2) {
            this.mouth_lower_lip_left_contour2 = mouth_lower_lip_left_contour2;
        }

        public Point getMouth_lower_lip_left_contour3() {
            return mouth_lower_lip_left_contour3;
        }

        public void setMouth_lower_lip_left_contour3(Point mouth_lower_lip_left_contour3) {
            this.mouth_lower_lip_left_contour3 = mouth_lower_lip_left_contour3;
        }

        public Point getMouth_lower_lip_top() {
            return mouth_lower_lip_top;
        }

        public void setMouth_lower_lip_top(Point mouth_lower_lip_top) {
            this.mouth_lower_lip_top = mouth_lower_lip_top;
        }

        public Point getMouth_lower_lip_bottom() {
            return mouth_lower_lip_bottom;
        }

        public void setMouth_lower_lip_bottom(Point mouth_lower_lip_bottom) {
            this.mouth_lower_lip_bottom = mouth_lower_lip_bottom;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.contour_left1, flags);
            dest.writeParcelable(this.contour_left2, flags);
            dest.writeParcelable(this.contour_left3, flags);
            dest.writeParcelable(this.contour_left4, flags);
            dest.writeParcelable(this.contour_left5, flags);
            dest.writeParcelable(this.contour_left6, flags);
            dest.writeParcelable(this.contour_left7, flags);
            dest.writeParcelable(this.contour_left8, flags);
            dest.writeParcelable(this.contour_left9, flags);
            dest.writeParcelable(this.contour_left10, flags);
            dest.writeParcelable(this.contour_left11, flags);
            dest.writeParcelable(this.contour_left12, flags);
            dest.writeParcelable(this.contour_left13, flags);
            dest.writeParcelable(this.contour_left14, flags);
            dest.writeParcelable(this.contour_left15, flags);
            dest.writeParcelable(this.contour_left16, flags);
            dest.writeParcelable(this.contour_chin, flags);
            dest.writeParcelable(this.contour_right1, flags);
            dest.writeParcelable(this.contour_right2, flags);
            dest.writeParcelable(this.contour_right3, flags);
            dest.writeParcelable(this.contour_right4, flags);
            dest.writeParcelable(this.contour_right5, flags);
            dest.writeParcelable(this.contour_right6, flags);
            dest.writeParcelable(this.contour_right7, flags);
            dest.writeParcelable(this.contour_right8, flags);
            dest.writeParcelable(this.contour_right9, flags);
            dest.writeParcelable(this.contour_right10, flags);
            dest.writeParcelable(this.contour_right11, flags);
            dest.writeParcelable(this.contour_right12, flags);
            dest.writeParcelable(this.contour_right13, flags);
            dest.writeParcelable(this.contour_right14, flags);
            dest.writeParcelable(this.contour_right15, flags);
            dest.writeParcelable(this.contour_right16, flags);
            dest.writeParcelable(this.left_eyebrow_left_corner, flags);
            dest.writeParcelable(this.left_eyebrow_upper_left_quarter, flags);
            dest.writeParcelable(this.left_eyebrow_upper_middle, flags);
            dest.writeParcelable(this.left_eyebrow_upper_right_quarter, flags);
            dest.writeParcelable(this.left_eyebrow_upper_right_corner, flags);
            dest.writeParcelable(this.left_eyebrow_lower_left_quarter, flags);
            dest.writeParcelable(this.left_eyebrow_lower_middle, flags);
            dest.writeParcelable(this.left_eyebrow_lower_right_quarter, flags);
            dest.writeParcelable(this.left_eyebrow_lower_right_corner, flags);
            dest.writeParcelable(this.right_eyebrow_upper_left_corner, flags);
            dest.writeParcelable(this.right_eyebrow_upper_left_quarter, flags);
            dest.writeParcelable(this.right_eyebrow_upper_middle, flags);
            dest.writeParcelable(this.right_eyebrow_upper_right_quarter, flags);
            dest.writeParcelable(this.right_eyebrow_right_corner, flags);
            dest.writeParcelable(this.right_eyebrow_lower_left_corner, flags);
            dest.writeParcelable(this.right_eyebrow_lower_left_quarter, flags);
            dest.writeParcelable(this.right_eyebrow_lower_middle, flags);
            dest.writeParcelable(this.right_eyebrow_lower_right_quarter, flags);
            dest.writeParcelable(this.nose_bridge1, flags);
            dest.writeParcelable(this.nose_bridge2, flags);
            dest.writeParcelable(this.nose_bridge3, flags);
            dest.writeParcelable(this.nose_left_contour1, flags);
            dest.writeParcelable(this.nose_left_contour2, flags);
            dest.writeParcelable(this.nose_left_contour3, flags);
            dest.writeParcelable(this.nose_left_contour4, flags);
            dest.writeParcelable(this.nose_left_contour5, flags);
            dest.writeParcelable(this.nose_middle_contour, flags);
            dest.writeParcelable(this.nose_right_contour1, flags);
            dest.writeParcelable(this.nose_right_contour2, flags);
            dest.writeParcelable(this.nose_right_contour3, flags);
            dest.writeParcelable(this.nose_right_contour4, flags);
            dest.writeParcelable(this.nose_right_contour5, flags);
            dest.writeParcelable(this.nose_contour_left1, flags);
            dest.writeParcelable(this.nose_contour_left2, flags);
            dest.writeParcelable(this.nose_contour_left3, flags);
            dest.writeParcelable(this.nose_contour_lower_middle, flags);
            dest.writeParcelable(this.nose_contour_right1, flags);
            dest.writeParcelable(this.nose_contour_right2, flags);
            dest.writeParcelable(this.nose_contour_right3, flags);
            dest.writeParcelable(this.nose_left, flags);
            dest.writeParcelable(this.nose_right, flags);
            dest.writeParcelable(this.nose_tip, flags);
            dest.writeParcelable(this.left_eye_left_corner, flags);
            dest.writeParcelable(this.left_eye_upper_left_quarter, flags);
            dest.writeParcelable(this.left_eye_top, flags);
            dest.writeParcelable(this.left_eye_upper_right_quarter, flags);
            dest.writeParcelable(this.left_eye_right_corner, flags);
            dest.writeParcelable(this.left_eye_lower_right_quarter, flags);
            dest.writeParcelable(this.left_eye_bottom, flags);
            dest.writeParcelable(this.left_eye_lower_left_quarter, flags);
            dest.writeParcelable(this.left_eye_pupil, flags);
            dest.writeParcelable(this.left_eye_center, flags);
            dest.writeParcelable(this.right_eye_left_corner, flags);
            dest.writeParcelable(this.right_eye_upper_left_quarter, flags);
            dest.writeParcelable(this.right_eye_top, flags);
            dest.writeParcelable(this.right_eye_upper_right_quarter, flags);
            dest.writeParcelable(this.right_eye_right_corner, flags);
            dest.writeParcelable(this.right_eye_lower_right_quarter, flags);
            dest.writeParcelable(this.right_eye_bottom, flags);
            dest.writeParcelable(this.right_eye_lower_left_quarter, flags);
            dest.writeParcelable(this.right_eye_pupil, flags);
            dest.writeParcelable(this.right_eye_center, flags);
            dest.writeParcelable(this.mouth_left_corner, flags);
            dest.writeParcelable(this.mouth_upper_lip_left_contour1, flags);
            dest.writeParcelable(this.mouth_upper_lip_left_contour2, flags);
            dest.writeParcelable(this.mouth_upper_lip_left_contour3, flags);
            dest.writeParcelable(this.mouth_upper_lip_left_contour4, flags);
            dest.writeParcelable(this.mouth_right_corner, flags);
            dest.writeParcelable(this.mouth_upper_lip_right_contour1, flags);
            dest.writeParcelable(this.mouth_upper_lip_right_contour2, flags);
            dest.writeParcelable(this.mouth_upper_lip_right_contour3, flags);
            dest.writeParcelable(this.mouth_upper_lip_right_contour4, flags);
            dest.writeParcelable(this.mouth_upper_lip_top, flags);
            dest.writeParcelable(this.mouth_upper_lip_bottom, flags);
            dest.writeParcelable(this.mouth_lower_lip_right_contour1, flags);
            dest.writeParcelable(this.mouth_lower_lip_right_contour2, flags);
            dest.writeParcelable(this.mouth_lower_lip_right_contour3, flags);
            dest.writeParcelable(this.mouth_lower_lip_left_contour1, flags);
            dest.writeParcelable(this.mouth_lower_lip_left_contour2, flags);
            dest.writeParcelable(this.mouth_lower_lip_left_contour3, flags);
            dest.writeParcelable(this.mouth_lower_lip_top, flags);
            dest.writeParcelable(this.mouth_lower_lip_bottom, flags);
        }

        public Landmark() {
        }

        protected Landmark(Parcel in) {
            this.contour_left1 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left2 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left3 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left4 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left5 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left6 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left7 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left8 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left9 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left10 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left11 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left12 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left13 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left14 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left15 = in.readParcelable(Point.class.getClassLoader());
            this.contour_left16 = in.readParcelable(Point.class.getClassLoader());
            this.contour_chin = in.readParcelable(Point.class.getClassLoader());
            this.contour_right1 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right2 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right3 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right4 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right5 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right6 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right7 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right8 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right9 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right10 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right11 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right12 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right13 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right14 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right15 = in.readParcelable(Point.class.getClassLoader());
            this.contour_right16 = in.readParcelable(Point.class.getClassLoader());
            this.left_eyebrow_left_corner = in.readParcelable(Point.class.getClassLoader());
            this.left_eyebrow_upper_left_quarter = in.readParcelable(Point.class.getClassLoader());
            this.left_eyebrow_upper_middle = in.readParcelable(Point.class.getClassLoader());
            this.left_eyebrow_upper_right_quarter = in.readParcelable(Point.class.getClassLoader());
            this.left_eyebrow_upper_right_corner = in.readParcelable(Point.class.getClassLoader());
            this.left_eyebrow_lower_left_quarter = in.readParcelable(Point.class.getClassLoader());
            this.left_eyebrow_lower_middle = in.readParcelable(Point.class.getClassLoader());
            this.left_eyebrow_lower_right_quarter = in.readParcelable(Point.class.getClassLoader());
            this.left_eyebrow_lower_right_corner = in.readParcelable(Point.class.getClassLoader());
            this.right_eyebrow_upper_left_corner = in.readParcelable(Point.class.getClassLoader());
            this.right_eyebrow_upper_left_quarter = in.readParcelable(Point.class.getClassLoader());
            this.right_eyebrow_upper_middle = in.readParcelable(Point.class.getClassLoader());
            this.right_eyebrow_upper_right_quarter = in.readParcelable(Point.class.getClassLoader());
            this.right_eyebrow_right_corner = in.readParcelable(Point.class.getClassLoader());
            this.right_eyebrow_lower_left_corner = in.readParcelable(Point.class.getClassLoader());
            this.right_eyebrow_lower_left_quarter = in.readParcelable(Point.class.getClassLoader());
            this.right_eyebrow_lower_middle = in.readParcelable(Point.class.getClassLoader());
            this.right_eyebrow_lower_right_quarter = in.readParcelable(Point.class.getClassLoader());
            this.nose_bridge1 = in.readParcelable(Point.class.getClassLoader());
            this.nose_bridge2 = in.readParcelable(Point.class.getClassLoader());
            this.nose_bridge3 = in.readParcelable(Point.class.getClassLoader());
            this.nose_left_contour1 = in.readParcelable(Point.class.getClassLoader());
            this.nose_left_contour2 = in.readParcelable(Point.class.getClassLoader());
            this.nose_left_contour3 = in.readParcelable(Point.class.getClassLoader());
            this.nose_left_contour4 = in.readParcelable(Point.class.getClassLoader());
            this.nose_left_contour5 = in.readParcelable(Point.class.getClassLoader());
            this.nose_middle_contour = in.readParcelable(Point.class.getClassLoader());
            this.nose_right_contour1 = in.readParcelable(Point.class.getClassLoader());
            this.nose_right_contour2 = in.readParcelable(Point.class.getClassLoader());
            this.nose_right_contour3 = in.readParcelable(Point.class.getClassLoader());
            this.nose_right_contour4 = in.readParcelable(Point.class.getClassLoader());
            this.nose_right_contour5 = in.readParcelable(Point.class.getClassLoader());
            this.nose_contour_left1 = in.readParcelable(Point.class.getClassLoader());
            this.nose_contour_left2 = in.readParcelable(Point.class.getClassLoader());
            this.nose_contour_left3 = in.readParcelable(Point.class.getClassLoader());
            this.nose_contour_lower_middle = in.readParcelable(Point.class.getClassLoader());
            this.nose_contour_right1 = in.readParcelable(Point.class.getClassLoader());
            this.nose_contour_right2 = in.readParcelable(Point.class.getClassLoader());
            this.nose_contour_right3 = in.readParcelable(Point.class.getClassLoader());
            this.nose_left = in.readParcelable(Point.class.getClassLoader());
            this.nose_right = in.readParcelable(Point.class.getClassLoader());
            this.nose_tip = in.readParcelable(Point.class.getClassLoader());
            this.left_eye_left_corner = in.readParcelable(Point.class.getClassLoader());
            this.left_eye_upper_left_quarter = in.readParcelable(Point.class.getClassLoader());
            this.left_eye_top = in.readParcelable(Point.class.getClassLoader());
            this.left_eye_upper_right_quarter = in.readParcelable(Point.class.getClassLoader());
            this.left_eye_right_corner = in.readParcelable(Point.class.getClassLoader());
            this.left_eye_lower_right_quarter = in.readParcelable(Point.class.getClassLoader());
            this.left_eye_bottom = in.readParcelable(Point.class.getClassLoader());
            this.left_eye_lower_left_quarter = in.readParcelable(Point.class.getClassLoader());
            this.left_eye_pupil = in.readParcelable(Point.class.getClassLoader());
            this.left_eye_center = in.readParcelable(Point.class.getClassLoader());
            this.right_eye_left_corner = in.readParcelable(Point.class.getClassLoader());
            this.right_eye_upper_left_quarter = in.readParcelable(Point.class.getClassLoader());
            this.right_eye_top = in.readParcelable(Point.class.getClassLoader());
            this.right_eye_upper_right_quarter = in.readParcelable(Point.class.getClassLoader());
            this.right_eye_right_corner = in.readParcelable(Point.class.getClassLoader());
            this.right_eye_lower_right_quarter = in.readParcelable(Point.class.getClassLoader());
            this.right_eye_bottom = in.readParcelable(Point.class.getClassLoader());
            this.right_eye_lower_left_quarter = in.readParcelable(Point.class.getClassLoader());
            this.right_eye_pupil = in.readParcelable(Point.class.getClassLoader());
            this.right_eye_center = in.readParcelable(Point.class.getClassLoader());
            this.mouth_left_corner = in.readParcelable(Point.class.getClassLoader());
            this.mouth_upper_lip_left_contour1 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_upper_lip_left_contour2 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_upper_lip_left_contour3 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_upper_lip_left_contour4 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_right_corner = in.readParcelable(Point.class.getClassLoader());
            this.mouth_upper_lip_right_contour1 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_upper_lip_right_contour2 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_upper_lip_right_contour3 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_upper_lip_right_contour4 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_upper_lip_top = in.readParcelable(Point.class.getClassLoader());
            this.mouth_upper_lip_bottom = in.readParcelable(Point.class.getClassLoader());
            this.mouth_lower_lip_right_contour1 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_lower_lip_right_contour2 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_lower_lip_right_contour3 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_lower_lip_left_contour1 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_lower_lip_left_contour2 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_lower_lip_left_contour3 = in.readParcelable(Point.class.getClassLoader());
            this.mouth_lower_lip_top = in.readParcelable(Point.class.getClassLoader());
            this.mouth_lower_lip_bottom = in.readParcelable(Point.class.getClassLoader());
        }

        public static final Creator<Landmark> CREATOR = new Creator<Landmark>() {
            @Override
            public Landmark createFromParcel(Parcel source) {
                return new Landmark(source);
            }

            @Override
            public Landmark[] newArray(int size) {
                return new Landmark[size];
            }
        };
    }

    public static class Attributes implements Parcelable {
        /**
         * gender : {"value":"Female"}
         * age : {"value":21}
         * glass : {"value":"None"}
         * headpose : {"yaw_angle":-26.625063,"pitch_angle":12.921974,"roll_angle":22.814377}
         * smile : {"threshold":30.1,"value":2.566890001296997}
         */

        private Value gender;
        private Value age;
        private Value glass;
        private Headpose headpose;
        private Smile smile;

        public Value getGender() {
            return gender;
        }

        public void setGender(Value gender) {
            this.gender = gender;
        }

        public Value getAge() {
            return age;
        }

        public void setAge(Value age) {
            this.age = age;
        }

        public Value getGlass() {
            return glass;
        }

        public void setGlass(Value glass) {
            this.glass = glass;
        }

        public Headpose getHeadpose() {
            return headpose;
        }

        public void setHeadpose(Headpose headpose) {
            this.headpose = headpose;
        }

        public Smile getSmile() {
            return smile;
        }

        public void setSmile(Smile smile) {
            this.smile = smile;
        }

        public static class Headpose implements Parcelable {
            /**
             * yaw_angle : -26.625063
             * pitch_angle : 12.921974
             * roll_angle : 22.814377
             */

            private double yaw_angle;
            private double pitch_angle;
            private double roll_angle;

            public double getYaw_angle() {
                return yaw_angle;
            }

            public void setYaw_angle(double yaw_angle) {
                this.yaw_angle = yaw_angle;
            }

            public double getPitch_angle() {
                return pitch_angle;
            }

            public void setPitch_angle(double pitch_angle) {
                this.pitch_angle = pitch_angle;
            }

            public double getRoll_angle() {
                return roll_angle;
            }

            public void setRoll_angle(double roll_angle) {
                this.roll_angle = roll_angle;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeDouble(this.yaw_angle);
                dest.writeDouble(this.pitch_angle);
                dest.writeDouble(this.roll_angle);
            }

            public Headpose() {
            }

            protected Headpose(Parcel in) {
                this.yaw_angle = in.readDouble();
                this.pitch_angle = in.readDouble();
                this.roll_angle = in.readDouble();
            }

            public static final Creator<Headpose> CREATOR = new Creator<Headpose>() {
                @Override
                public Headpose createFromParcel(Parcel source) {
                    return new Headpose(source);
                }

                @Override
                public Headpose[] newArray(int size) {
                    return new Headpose[size];
                }
            };
        }

        public static class Smile implements Parcelable {
            /**
             * threshold : 30.1
             * value : 2.566890001296997
             */

            private double threshold;
            private double value;

            public double getThreshold() {
                return threshold;
            }

            public void setThreshold(double threshold) {
                this.threshold = threshold;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeDouble(this.threshold);
                dest.writeDouble(this.value);
            }

            public Smile() {
            }

            protected Smile(Parcel in) {
                this.threshold = in.readDouble();
                this.value = in.readDouble();
            }

            public static final Creator<Smile> CREATOR = new Creator<Smile>() {
                @Override
                public Smile createFromParcel(Parcel source) {
                    return new Smile(source);
                }

                @Override
                public Smile[] newArray(int size) {
                    return new Smile[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.gender, flags);
            dest.writeParcelable(this.age, flags);
            dest.writeParcelable(this.glass, flags);
            dest.writeParcelable(this.headpose, flags);
            dest.writeParcelable(this.smile, flags);
        }

        public Attributes() {
        }

        protected Attributes(Parcel in) {
            this.gender = in.readParcelable(Value.class.getClassLoader());
            this.age = in.readParcelable(Value.class.getClassLoader());
            this.glass = in.readParcelable(Value.class.getClassLoader());
            this.headpose = in.readParcelable(Headpose.class.getClassLoader());
            this.smile = in.readParcelable(Smile.class.getClassLoader());
        }

        public static final Creator<Attributes> CREATOR = new Creator<Attributes>() {
            @Override
            public Attributes createFromParcel(Parcel source) {
                return new Attributes(source);
            }

            @Override
            public Attributes[] newArray(int size) {
                return new Attributes[size];
            }
        };
    }

    public static class FaceRectangle implements Parcelable {
        /**
         * width : 140
         * top : 89
         * left : 104
         * height : 141
         */

        private int width;
        private int top;
        private int left;
        private int height;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.width);
            dest.writeInt(this.top);
            dest.writeInt(this.left);
            dest.writeInt(this.height);
        }

        public FaceRectangle() {
        }

        protected FaceRectangle(Parcel in) {
            this.width = in.readInt();
            this.top = in.readInt();
            this.left = in.readInt();
            this.height = in.readInt();
        }

        public static final Parcelable.Creator<FaceRectangle> CREATOR = new Parcelable.Creator<FaceRectangle>() {
            @Override
            public FaceRectangle createFromParcel(Parcel source) {
                return new FaceRectangle(source);
            }

            @Override
            public FaceRectangle[] newArray(int size) {
                return new FaceRectangle[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.landmark, flags);
        dest.writeParcelable(this.attributes, flags);
        dest.writeParcelable(this.faceRectangle, flags);
        dest.writeString(this.faceToken);
    }

    public Face() {
    }

    protected Face(Parcel in) {
        this.landmark = in.readParcelable(Landmark.class.getClassLoader());
        this.attributes = in.readParcelable(Attributes.class.getClassLoader());
        this.faceRectangle = in.readParcelable(FaceRectangle.class.getClassLoader());
        this.faceToken = in.readString();
    }

    public static final Parcelable.Creator<Face> CREATOR = new Parcelable.Creator<Face>() {
        @Override
        public Face createFromParcel(Parcel source) {
            return new Face(source);
        }

        @Override
        public Face[] newArray(int size) {
            return new Face[size];
        }
    };
}
