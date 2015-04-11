package com.example.guiddemo;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtil {
	
	/**
     * �Ƿ���ʾ��ӭ����,true��ʾ��ʾ��false��ʾ����ʾ
     */
    public static final String SHOW_GUIDE = "showguide";

	/**
	 * ���浽Preference
	 */
	public static void setBoolean(Context context, String key, boolean value) {
		// �õ�SharedPreferences
		SharedPreferences preferences = context.getSharedPreferences(
				"preference", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	/**
	 * ��Preferenceȡ������
	 */
	public static boolean getBoolean(Context context, String key) {
		SharedPreferences preferences = context.getSharedPreferences(
				"preference", Context.MODE_PRIVATE);
		// ����keyֵ��keyֵĬ��ֵ��false
		return preferences.getBoolean(key, false);

	}
}
