package com.syh.androidviews.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.syh.androidviews.R;

public class MyFragmentStatic extends Fragment {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
		tv.setText("静态加载");
		Button button = (Button) view.findViewById(R.id.frament1_btn);
		button.setText("获取Name");
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "获得通过Activity设置的name:" + name,
						Toast.LENGTH_SHORT).show();
			}
		});
		return view;
	}

}
