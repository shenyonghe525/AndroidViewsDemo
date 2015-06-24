package com.syh.androidviews;

import java.util.ArrayList;
import java.util.List;
import com.syh.androidviews.viewpager.Fragment1;
import com.syh.androidviews.viewpager.Fragment2;
import com.syh.androidviews.viewpager.Fragment3;
import com.syh.androidviews.viewpager.Fragment4;
import com.syh.androidviews.viewpager.MyFragmentPagerAdapter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.Toast;

public class ViewPagerActivity extends FragmentActivity implements
		OnPageChangeListener {

	private List<View> viewList;

	private ViewPager viewpager;

	private PagerTabStrip tap;

	private List<String> titleList;

	private List<Fragment> fragments;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpager);
		initViews();
	}

	private void initViews() {
		viewpager = (ViewPager) findViewById(R.id.viewPager);
		tap = (PagerTabStrip) findViewById(R.id.viewPager_tap);
		viewList = new ArrayList<View>();
		View view1 = View.inflate(this, R.layout.pagerview1, null);
		View view2 = View.inflate(this, R.layout.pagerview2, null);
		View view3 = View.inflate(this, R.layout.pagerview3, null);
		View view4 = View.inflate(this, R.layout.pagerview4, null);
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewList.add(view4);

		/**
		 * 通过fragment作为数据源
		 */
		fragments = new ArrayList<Fragment>();
		fragments.add(new Fragment1());
		fragments.add(new Fragment2());
		fragments.add(new Fragment3());
		fragments.add(new Fragment4());

		titleList = new ArrayList<String>();
		titleList.add("第1页");
		titleList.add("第2页");
		titleList.add("第3页");
		titleList.add("第4页");

		// 为PagerTabStrip设置一些属性
		tap.setBackgroundColor(Color.YELLOW);
		tap.setTextColor(Color.RED);
		tap.setDrawFullUnderline(false);
		tap.setTabIndicatorColor(Color.GREEN);

		// 创建PagerAdapter适配器
		// MyPagerAdapter adapter = new MyPagerAdapter(viewList,titleList);
		// viewpager加载适配器
		// viewpager.setAdapter(adapter);

		// 创建FragmentAdapter适配器,其中frgment使用的v4的包，为了兼容这个，activity要继承自FragmentActivity,并通过getSupportFragmentManager()获取fm
		MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
				getSupportFragmentManager(), fragments, titleList);
		viewpager.setAdapter(adapter);
		viewpager.setOnPageChangeListener(this);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(ViewPagerActivity.this, "当前是第" + (arg0+1) + "页",
				Toast.LENGTH_SHORT).show();
	}
}
