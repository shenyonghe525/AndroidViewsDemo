package com.syh.androidviews.viewpager;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * 此适配器会将pagerview里面所有页面的view加载进来,不会动态的管理各个页面的view，因此不适合页面包含view较多的
 * 适合每个页卡得业务逻辑都很复杂的情况
 * @author shenyonghe
 * 
 *         2015-6-23
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> fragmentList;
	private List<String> titleList;

	public MyFragmentPagerAdapter(FragmentManager fm,
			List<Fragment> fragmentList, List<String> titleList) {
		super(fm);
		this.fragmentList = fragmentList;
		this.titleList = titleList;
	}

	@Override
	public Fragment getItem(int arg0) {
		return fragmentList.get(arg0);
	}

	@Override
	public int getCount() {
		return fragmentList.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return titleList.get(position);
	}
}
