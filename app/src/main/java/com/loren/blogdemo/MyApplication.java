package com.loren.blogdemo;

import android.app.Application;

/**
 * Created by 国荣 on 2017/9/4 17:34.
 * Copyright (c) 2017 . All rights reserved.
 */

public class MyApplication extends Application {

	private static MyApplication sMyApplication;

	//Application的单例
	public static Application getInstance() {
		return sMyApplication;
	}
	@Override
	public void onCreate() {
		super.onCreate();
		sMyApplication = this;
	}
}
