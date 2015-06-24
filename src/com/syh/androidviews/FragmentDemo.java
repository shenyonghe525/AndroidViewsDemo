package com.syh.androidviews;

import com.syh.androidviews.fragment.FragmentActivity1;
import com.syh.androidviews.fragment.MyFragmentCommunicate;
import com.syh.androidviews.fragment.MyFragmentDy;
import com.syh.androidviews.fragment.MyFragmentLife;
import com.syh.androidviews.fragment.MyFragmentCommunicate.MyListener;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class FragmentDemo extends Activity implements MyListener {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		inintViews();
	}

	private void inintViews() {
		RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);
		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.rabtn_static:
					Intent intent = new Intent(FragmentDemo.this,
							FragmentActivity1.class);
					startActivity(intent);
					break;

				case R.id.rabtn_dynamic:
					MyFragmentDy myFragment2 = new MyFragmentDy();
					FragmentManager fragmentManager2 = getFragmentManager();
					FragmentTransaction beginTransaction2 = fragmentManager2
							.beginTransaction();
					beginTransaction2.add(R.id.dy_frament, myFragment2);
					beginTransaction2.addToBackStack(null);
					beginTransaction2.commit();
					break;
				case R.id.rabtn_life:
					MyFragmentLife myFragment3 = new MyFragmentLife();
					FragmentManager fragmentManager3 = getFragmentManager();
					FragmentTransaction beginTransaction3 = fragmentManager3
							.beginTransaction();
					beginTransaction3.add(R.id.dy_frament, myFragment3);
					beginTransaction3.addToBackStack(null);
					beginTransaction3.commit();
					break;
				case R.id.rabtn_communicate:
					MyFragmentCommunicate myFragment4 = new MyFragmentCommunicate();
					Bundle bundle = new Bundle();
					bundle.putString("name", "activity to fragment");
					myFragment4.setArguments(bundle);
					FragmentManager fragmentManager4 = getFragmentManager();
					FragmentTransaction beginTransaction4 = fragmentManager4
							.beginTransaction();
					beginTransaction4.add(R.id.dy_frament, myFragment4,
							"fragment4");
					beginTransaction4.addToBackStack(null);
					beginTransaction4.commit();
					Toast.makeText(getBaseContext(), "activity to fragment",
							Toast.LENGTH_SHORT).show();
					break;
				}
			}
		});
	}

	@Override
	public void sendCodeToActivity(String code) {
		Toast.makeText(this, "收到从fragment传来的数据:" + code, Toast.LENGTH_SHORT)
				.show();
	}

}
