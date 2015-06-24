package com.syh.androidviews;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends Activity {

	private TextView textView;

	private List<String> list;

	private ArrayAdapter<String> adapter;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner);
		initViews();
	}

	private void initViews() {
		textView = (TextView) findViewById(R.id.spinnner_txt);
		textView.setText("您选择的城市是:北京");
		Spinner spinner = (Spinner) findViewById(R.id.spinner);

		list = new ArrayList<String>();
		list.add("北京");
		list.add("上海");
		list.add("广州");
		list.add("深圳");
		// 这里面的样式是spinner本身的样式
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		// 设置下拉列表的样式
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//设置Spinner下拉列表的标题
		spinner.setPrompt("一线城市");
		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				String cityName = adapter.getItem(position);
				textView.setText("您选择的城市是:"+cityName);

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
	}
}
