package com.syh.androidviews.viewpager;

import java.util.ArrayList;
import java.util.List;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter {

	private List<View> viewList;
	private List<String> titleList;

	public MyPagerAdapter(List<View> list, List<String> titleList) {
		viewList = new ArrayList<View>();
		this.viewList = list;
		this.titleList = titleList;
	}

	/**
	 * 返回页卡的数量
	 */
	public int getCount() {
		return viewList.size();
	}

	/**
	 * view是否来自于object
	 */
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	/**
	 * 实例化一个页卡
	 */
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(viewList.get(position));
		return viewList.get(position);
	}

	/**
	 * 销毁一个页卡
	 */
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(viewList.get(position));
	}

	/**
	 * 传递标题信息
	 */
	public CharSequence getPageTitle(int position) {
		return titleList.get(position);
	}
}
