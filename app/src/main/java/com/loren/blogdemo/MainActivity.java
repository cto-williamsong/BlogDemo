package com.loren.blogdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.loren.blogdemo.features.FeaturesActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

	private Button mFeaturesMainBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void initLayoutView() {
		setContentView(R.layout.activity_main);
	}

	@Override
	public void initView() {
		mFeaturesMainBtn = (Button) findViewById(R.id.mFeaturesMainBtn);
		mFeaturesMainBtn.setOnClickListener(this);

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

			case R.id.mFeaturesMainBtn:
				startActivity(FeaturesActivity.class, null, false);
			break;

			default:
				break;
		}
	}
}


