package com.syh.androidviews.fragment;

import com.syh.androidviews.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragmentDy extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// layout布局转换成view并返回
		/**
		 * resource:Fragment需要加载的布局文件 root:加载layout的父 ViewGroup
		 * attachToRoot:false 不返回父ViewGroup
		 */
		View view = inflater.inflate(R.layout.farment1, container, false);
		TextView tv = (TextView) view.findViewById(R.id.frament1_tv);
		tv.setText("动态加载fragment");
		return view;
	}

}
