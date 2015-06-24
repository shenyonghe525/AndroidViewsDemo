package com.syh.androidviews.fragment;

import com.syh.androidviews.R;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragmentLife extends Fragment {

	private static final String TAG = "<---MyFragment3--->";

	/**
	 * 每次创建都会绘制Fragment的view组件 时回调
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Log.d(TAG, "onCreateView()");
		// layout布局转换成view并返回
		/**
		 * resource:Fragment需要加载的布局文件 root:加载layout的父 ViewGroup
		 * attachToRoot:false 不返回父ViewGroup
		 */
		View view = inflater.inflate(R.layout.farment1, container, false);
		TextView tv = (TextView) view.findViewById(R.id.frament1_tv);
		tv.setText("fragment生命周期");
		return view;
	}

	/**
	 * 当Fragment被添加到Activity的时候回调用，并且只调用一次
	 */
	@Override
	public void onAttach(Activity activity) {
		Log.d(TAG, "onAttach()");
		super.onAttach(activity);
	}

	/**
	 * 创建Fragment时会回调，并且只调用一次
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate()");
		super.onCreate(savedInstanceState);
	}

	/**
	 * 当Fragment所在的Activity启动完成后调用
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.d(TAG, "onActivityCreated()");
		super.onActivityCreated(savedInstanceState);
	}

	/**
	 * 启动Fragment
	 */
	@Override
	public void onStart() {
		Log.d(TAG, "onStart()");
		super.onStart();
	}

	/**
	 * 恢复fragment时调用，调用onStart()后一定会调用onResum()
	 */
	@Override
	public void onResume() {
		Log.d(TAG, "onResume()");
		super.onResume();
	}

	/**
	 * 暂停fragment
	 */
	@Override
	public void onPause() {
		Log.d(TAG, "onPause()");
		super.onPause();
	}

	/**
	 * 停止fragment
	 */
	@Override
	public void onStop() {
		Log.d(TAG, "onStop()");
		super.onStop();
	}

	/**
	 * 销毁fragment所包含的组件时调用
	 */
	@Override
	public void onDestroyView() {
		Log.d(TAG, "onDestroyView()");
		super.onDestroyView();
	}

	/**
	 * 销毁fragment时回调
	 */
	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy()");
		super.onDestroy();
	}

	/**
	 * fragment被从activity中删除时 调用。并且只被调用一次
	 */
	@Override
	public void onDetach() {
		Log.d(TAG, "onDetach()");
		super.onDetach();
	}

}
