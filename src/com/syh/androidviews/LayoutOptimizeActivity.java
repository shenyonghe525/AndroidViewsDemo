package com.syh.androidviews;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;

public class LayoutOptimizeActivity extends Activity {

	private Button show;
	private ViewStub stub;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.optimize_layout);
		show = (Button) findViewById(R.id.btn_show);
		stub = (ViewStub) findViewById(R.id.stub);
		show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 只能被执行一次
				stub.inflate();
			}
		});
	}
}
