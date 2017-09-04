package com.loren.blogdemo.utils;

import android.widget.Toast;

import com.loren.blogdemo.MyApplication;

/**
 * Created by 国荣 on 2017/6/17 15:59.
 * Copyright (c) 2017 . All rights reserved.
 */

public class ToastUtil {
	private static Toast sToast;

	public static void showToast(String content) {
		if(sToast == null) {
			sToast = Toast.makeText(MyApplication.getInstance(),content,Toast.LENGTH_SHORT);
		}else {
			sToast.setText(content);
		}
		sToast.show();
	}
}
