package com.mlethe.face.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLES11Ext;
import android.opengl.GLES20;

import javax.microedition.khronos.opengles.GL10;

public class OpenGLUtil {
	
	/**
	 *判断手机支不支持 OpenGLES20
	 */
	public static boolean detectOpenGLES20(Context context) {  
	    ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);  
	    ConfigurationInfo info = am.getDeviceConfigurationInfo();  
	    return (info.reqGlEsVersion >= 0x20000);  
	} 
	
	public static int createTextureID() {
		int[] tex = new int[1];
		//生成一个纹理
		// 第一个参数是生成纹理ID个数，第二个参数是存放的位置，第三个参数是偏移量（到现在还不明白啥用）
		GLES20.glGenTextures(1, tex, 0);
		//将此纹理绑定到外部纹理上
		GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, tex[0]);
		//设置纹理过滤参数
		GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES,
				GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
		GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES,
				GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
		GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES,
				GL10.GL_TEXTURE_WRAP_S, GL10.GL_CLAMP_TO_EDGE);
		GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES,
				GL10.GL_TEXTURE_WRAP_T, GL10.GL_CLAMP_TO_EDGE);
		//解除纹理绑定
		GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 0);
		return tex[0];
	}
}
