package com.loren.blogdemo.features;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.loren.blogdemo.BaseActivity;
import com.loren.blogdemo.R;

public class FeaturesActivity extends BaseActivity implements View.OnClickListener {

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
	public void initEvent() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

			case R.id.mCameraFeaturesBtn:

				break;
			case R.id.mPicFeaturesBtn:
				break;
		}
	}
}
