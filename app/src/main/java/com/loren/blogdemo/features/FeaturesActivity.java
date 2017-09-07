package com.loren.blogdemo.features;

import android.Manifest;
import android.app.AppOpsManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.loren.blogdemo.BaseActivity;
import com.loren.blogdemo.R;

public class FeaturesActivity extends BaseActivity implements View.OnClickListener {

	private static final int REQUESTID_PERMISSION_CAMEAR = 1;
	private Button    mCameraFeaturesBtn;
	private Button    mPicFeaturesBtn;
	private ImageView mImgFeaturesIv;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void initLayoutView() {
		setContentView(R.layout.activity_features);
	}

	@Override
	public void initView() {
		mCameraFeaturesBtn = (Button) findViewById(R.id.mCameraFeaturesBtn);
		mPicFeaturesBtn = (Button) findViewById(R.id.mPicFeaturesBtn);
		mImgFeaturesIv = (ImageView) findViewById(R.id.mImgFeaturesIv);

		mCameraFeaturesBtn.setOnClickListener(this);
		mPicFeaturesBtn.setOnClickListener(this);
	}

	@Override
	public void initData() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

			case R.id.mCameraFeaturesBtn:
				check();
				break;
			case R.id.mPicFeaturesBtn:
				break;
		}
	}

	private void check() {
		boolean b = checkPermission(REQUESTID_PERMISSION_CAMEAR,new String[]{AppOpsManager.OPSTR_CAMERA}, Manifest.permission.CAMERA);
		if(b) {
			//有权限,开启Camera
			openCamera();
		}else {
			ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUESTID_PERMISSION_CAMEAR);
		}
	}

	private void openCamera() {
		startActivity(null, new Intent(MediaStore.ACTION_IMAGE_CAPTURE), false);
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		switch (requestCode) {
			case REQUESTID_PERMISSION_CAMEAR: {
				// If request is cancelled, the result arrays are empty.
				if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					//权限满足,打开Camera
					openCamera();
				} else {
					// 权限被拒绝
					Toast.makeText(this, "没有权限", Toast.LENGTH_SHORT)
							.show();
					openAppDetails();
				}
				return;
			}
		}
	}
	/**
	 * 打开 APP 的详情设置
	 */
	private void openAppDetails() {
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("提示");
		dialog.setMessage("点击确定去设置中开启权限");
		dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Intent intent = new Intent();
				intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
				intent.addCategory(Intent.CATEGORY_DEFAULT);
				intent.setData(Uri.parse("package:" + getPackageName()));
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
				startActivity(intent);
			}
		});
		dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		dialog.show();
	}
}
