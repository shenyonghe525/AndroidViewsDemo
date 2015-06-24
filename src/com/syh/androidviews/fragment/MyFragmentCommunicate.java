package com.syh.androidviews.fragment;

import com.syh.androidviews.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyFragmentCommunicate extends Fragment {

	private MyListener listener;

	public interface MyListener {
		public void sendCodeToActivity(String code);
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
		String text = getArguments().getString("name");
		Toast.makeText(getActivity(), "成功接收到从activity传来的数据", Toast.LENGTH_SHORT)
				.show();
		tv.setText("fragment从activity获得的数据:" + text);
		Button btnButton = (Button) view.findViewById(R.id.frament1_btn);
		btnButton.setText("传值到activity");
		btnButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
                listener.sendCodeToActivity("fragment to activity");
			}
		});
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		listener = (MyListener) activity;
		super.onAttach(activity);
	}

}
