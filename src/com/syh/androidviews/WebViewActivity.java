package com.syh.androidviews;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("SetJavaScriptEnabled")
public class WebViewActivity extends Activity {

	private WebView webView;
	private ProgressDialog progressDialog;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		initViews();
	}

	private void initViews() {
		webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("http://www.baidu.com");
		// 覆盖由默认或者第三方浏览器的打卡方式，试用新建的浏览器打开页面
		webView.setWebViewClient(new WebViewClient() {

			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// 返回值为true的时候网页在新建浏览器中打开，否则在系统浏览器或第三方浏览器中打开
				view.loadUrl(url);
				return true;
			}

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {

				super.onReceivedError(view, errorCode, description, failingUrl);
				webView.loadUrl("file:///android_asset/www/index.html");
			}
		});
		WebSettings settings = webView.getSettings();
//		settings.setJavaScriptEnabled(true);
		// 页面加载优先使用缓存
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		webView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// newProgress 1-100
				if (newProgress == 100) {
					// 网页加载完成,关闭ProgressDialog
					closeDialog();
				} else {
					// 网页正在加载,打开ProgressDialog
					openDialog(newProgress);
				}
			}

			private void closeDialog() {
				if (progressDialog != null && progressDialog.isShowing()) {
					progressDialog.dismiss();
					progressDialog = null;
				}
			}

			private void openDialog(int newProgress) {
				if (progressDialog == null) {
					progressDialog = new ProgressDialog(WebViewActivity.this);
					progressDialog.setTitle("正在加载......");
					progressDialog
							.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					progressDialog.setProgress(newProgress);
					progressDialog.show();
				} else {
					progressDialog.setProgress(newProgress);
				}
			}
		});
	}

	// 改写物理返回键的逻辑
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (webView.canGoBack()) {
				webView.goBack();// 返回上一页
				return true;
			} else {
				System.exit(0);// 退出应用程序
			}
		}
		return super.onKeyDown(keyCode, event);
	}

}
