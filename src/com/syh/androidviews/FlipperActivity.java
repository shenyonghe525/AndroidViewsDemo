package com.syh.androidviews;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ViewFlipper;
/**
 * 自动播放视图的功能，可以设置滑动动画以及时间,也可以添加滑动的响应时间
 * @author shenyonghe
 *
 * 2015-6-23
 */
public class FlipperActivity extends Activity {
	
	private ViewFlipper flipper;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewflipper); 
        flipper =(ViewFlipper) findViewById(R.id.flipper);
        flipper.startFlipping();
	}

	
}
