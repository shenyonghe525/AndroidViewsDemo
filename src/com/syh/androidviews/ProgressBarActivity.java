package com.syh.androidviews;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarActivity extends Activity implements OnClickListener {

	private ProgressBar progressBar;
	private Button add, reduce, reset, progressDiaogBtn;
	private TextView progressInfo;
	private int max;
	private ProgressDialog progressDialog;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressbar);
		initView();
	}

	private void initView() {
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		progressInfo = (TextView) findViewById(R.id.tv_progressInfo);
		max = progressBar.getMax();
		String info = "进度条的第一进度为:"
				+ (int) (progressBar.getProgress() / (float) max * 100)
				+ "% 第二进度为:"
				+ (int) (progressBar.getSecondaryProgress() / (float) max * 100)
				+ "%";
		progressInfo.setText(info);
		add = (Button) findViewById(R.id.btn_add);
		reduce = (Button) findViewById(R.id.btn_reduce);
		reset = (Button) findViewById(R.id.btn_reset);
		progressDiaogBtn = (Button) findViewById(R.id.btn_showdialog);
		add.setOnClickListener(this);
		reduce.setOnClickListener(this);
		reset.setOnClickListener(this);
		progressDiaogBtn.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_add:
			// 第一第二进度都增加10刻度
			progressBar.incrementProgressBy(10);
			progressBar.incrementSecondaryProgressBy(10);
			break;

		case R.id.btn_reduce:
			// 第一第二进度都减少10刻度
			progressBar.incrementProgressBy(-10);
			progressBar.incrementSecondaryProgressBy(-10);
			break;
		case R.id.btn_reset:
			progressBar.setProgress(50);
			progressBar.setSecondaryProgress(80);
			break;
		case R.id.btn_showdialog:
			progressDialog = new ProgressDialog(this);
			// 设置显示风格
			progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			// 设置标题
			progressDialog.setTitle("标题党");
			// 设置对话框的文字内容
			progressDialog.setMessage("欢迎下载毛片!");
			// 设置图标
			progressDialog.setIcon(R.drawable.ic_launcher);

			// 设置最大进度
			progressDialog.setMax(100);
			// 设置初始化进度
			progressDialog.incrementProgressBy(50);
			// 进度条是否明确显示进度
			progressDialog.setIndeterminate(false);
			// 设置一个确定按钮
			progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定",
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(ProgressBarActivity.this, "感谢老司机!",
									Toast.LENGTH_SHORT).show();
						}
					});
			// 是否可以通过返回按钮退出对话框
			progressDialog.setCancelable(true);
			progressDialog.show();
			break;
		}
		String info = "进度条的第一进度为:"
				+ (int) (progressBar.getProgress() / (float) max * 100)
				+ "% 第二进度为:"
				+ (int) (progressBar.getSecondaryProgress() / (float) max * 100)
				+ "%";
		progressInfo.setText(info);
	}
}
