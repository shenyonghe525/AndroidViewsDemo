package com.syh.androidviews.fragment;

import com.syh.androidviews.R;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class FragmentActivity1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_lay);
		FragmentManager fragmentManager1 = getFragmentManager();
		Fragment findFragmentById = fragmentManager1
				.findFragmentById(R.id.frament);
		MyFragmentStatic myStatic = (MyFragmentStatic) findFragmentById;
		myStatic.setName("fragment 静态 传值");
	}
}
