package com.syh.androidviews;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SeekBarActivity extends Activity implements
		OnSeekBarChangeListener {

	private SeekBar seekBar;
	private TextView tv1, tv2;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seekbar);
		initViews();
	}

	private void initViews() {
		seekBar = (SeekBar) findViewById(R.id.seekBar);
		seekBar.setOnSeekBarChangeListener(this);
		tv1 = (TextView) findViewById(R.id.sb_tv1);
		tv2 = (TextView) findViewById(R.id.sb_tv2);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		tv1.setText("正在拖动");
		tv2.setText("当前进度为:" + progress);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		tv1.setText("开始拖动");
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		tv1.setText("结束拖动");
	}
}
