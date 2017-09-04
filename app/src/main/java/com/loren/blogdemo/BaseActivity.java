package com.loren.blogdemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by 国荣 on 2017/3/20 15:25.
 * Copyright (c) 2017 . All rights reserved.
 */

public abstract class BaseActivity extends AppCompatActivity {
	protected String TAG = "loren";
	private String  APP_NAME;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initLayoutView();
		initView();
		initData();
		initData();
	}
	//Activity跳转
	public void startActivity(Class clazz, Intent intent, boolean isFinish) {
		if (intent == null) {
			intent = new Intent(this, clazz);
		}
		intent.setClass(this, clazz);
		startActivity(intent);
		if (isFinish) {
			finish();
		}
	}

	//透明状态栏,需要在setContentView前调用
	public void translucentBars() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			window.getDecorView()
					.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.setStatusBarColor(Color.TRANSPARENT);
			//window.setNavigationBarColor(Color.TRANSPARENT);
		}
	}
	/**
	 //	 * [页面跳转]
	 //	 *
	 //	 * @param clz
	 //	 */
	//	public void startActivity(Class<?> clz) {
	//		startActivity(clz, null);
	//	}
	//
	//	/**
	//	 * [携带数据的页面跳转]
	//	 *
	//	 * @param clz
	//	 * @param bundle
	//	 */
	//	public void startActivity(Class<?> clz, Bundle bundle) {
	//		Intent intent = new Intent();
	//		intent.setClass(this, clz);
	//		if (bundle != null) {
	//			intent.putExtras(bundle);
	//		}
	//		startActivity(intent);
	//	}



	public abstract void initLayoutView();

	public abstract void initView();

	public abstract void initData();

	public abstract void initEvent();

	//	/*
	//链接：https://www.zhihu.com/question/47045239/answer/105086885
	//
	//public abstract class BaseActivity extends FragmentActivity implements
	//		OnClickListener {
	//	/** 是否沉浸状态栏 **/
	//	private boolean isSetStatusBar     = true;
	//	/** 是否允许全屏 **/
	//	private boolean mAllowFullScreen   = true;
	//	/** 是否禁止旋转屏幕 **/
	//	private boolean isAllowScreenRoate = false;
	//	/** 当前Activity渲染的视图View **/
	//	private View    mContextView       = null;
	//	/** 是否输出日志信息 **/
	//
	//	@Override
	//	protected void onCreate(Bundle savedInstanceState) {
	//		super.onCreate(savedInstanceState);
	//		isDebug = MApplication.isDebug;
	//		APP_NAME = MApplication.APP_NAME;
	//		$Log(TAG + "-->onCreate()");
	//		try {
	//			Bundle bundle = getIntent().getExtras();
	//			initParms(bundle);
	//			mContextView = LayoutInflater.from(this)
	//					.inflate(bindLayout(), null);
	//			if (mAllowFullScreen) {
	//				this.getWindow().setFlags(
	//						WindowManager.LayoutParams.FLAG_FULLSCREEN,
	//						WindowManager.LayoutParams.FLAG_FULLSCREEN);
	//				requestWindowFeature(Window.FEATURE_NO_TITLE);
	//			}
	//			if (isSetStatusBar) {
	//				steepStatusBar();
	//			}
	//			setContentView(mContextView);
	//			if (!isAllowScreenRoate) {
	//				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	//			} else {
	//				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	//			}
	//			initView(mContextView);
	//			doBusiness(this);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}
	//
	//	/**
	//	 * [沉浸状态栏]
	//	 */
	//	private void steepStatusBar() {
	//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
	//			// 透明状态栏
	//			getWindow().addFlags(
	//					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
	//			// 透明导航栏
	//			getWindow().addFlags(
	//					WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
	//		}
	//	}
	//
	//	/**
	//	 * [初始化Bundle参数]
	//	 *
	//	 * @param parms
	//	 */
	//	public abstract void initParms(Bundle parms);
	//
	//	/**
	//	 * [绑定布局]
	//	 *
	//	 * @return
	//	 */
	//	public abstract int bindLayout();
	//
	//	/**
	//	 * [重写： 1.是否沉浸状态栏 2.是否全屏 3.是否禁止旋转屏幕]
	//	 */
	//	// public abstract void setActivityPre();

	//	/**
	//	 * [业务操作]
	//	 *
	//	 * @param mContext
	//	 */
	//	public abstract void doBusiness(Context mContext);
	//
	//	/** View点击 **/
	//	public abstract void widgetClick(View v);
	//
	//	@Override
	//	public void onClick(View v) {
	//		if (fastClick())
	//			widgetClick(v);
	//	}
	//
	//

	//
	//	/**
	//	 * [含有Bundle通过Class打开编辑界面]
	//	 *
	//	 * @param cls
	//	 * @param bundle
	//	 * @param requestCode
	//	 */
	//	public void startActivityForResult(Class<?> cls, Bundle bundle,
	//	                                   int requestCode) {
	//		Intent intent = new Intent();
	//		intent.setClass(this, cls);
	//		if (bundle != null) {
	//			intent.putExtras(bundle);
	//		}
	//		startActivityForResult(intent, requestCode);
	//	}
	//
	//	@Override
	//	protected void onResume() {
	//		super.onResume();
	//		$Log(TAG + "--->onResume()");
	//	}
	//
	//	@Override
	//	protected void onDestroy() {
	//		super.onDestroy();
	//		$Log(TAG + "--->onDestroy()");
	//	}
	//
	//	/**
	//	 * [是否允许全屏]
	//	 *
	//	 * @param allowFullScreen
	//	 */
	//	public void setAllowFullScreen(boolean allowFullScreen) {
	//		this.mAllowFullScreen = allowFullScreen;
	//	}
	//
	//	/**
	//	 * [是否设置沉浸状态栏]
	//	 *
	//	 * @param allowFullScreen
	//	 */
	//	public void setSteepStatusBar(boolean isSetStatusBar) {
	//		this.isSetStatusBar = isSetStatusBar;
	//	}
	//
	//	/**
	//	 * [是否允许屏幕旋转]
	//	 *
	//	 * @param isAllowScreenRoate
	//	 */
	//	public void setScreenRoate(boolean isAllowScreenRoate) {
	//		this.isAllowScreenRoate = isAllowScreenRoate;
	//	}
	//
	//	/**
	//	 * [日志输出]
	//	 *
	//	 * @param msg
	//	 */
	//	protected void $Log(String msg) {
	//		if (isDebug) {
	//			Log.d(APP_NAME, msg);
	//		}
	//	}
	//
	//	/**
	//	 * [防止快速点击]
	//	 *
	//	 * @return
	//	 */
	//	private boolean fastClick() {
	//		long lastClick = 0;
	//		if (System.currentTimeMillis() - lastClick <= 1000) {
	//			return false;
	//		}
	//		lastClick = System.currentTimeMillis();
	//		return true;
	//	}
	//}
	//	 */

}
