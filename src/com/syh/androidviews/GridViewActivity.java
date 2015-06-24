package com.syh.androidviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class GridViewActivity extends Activity {

	private GridView gridView;
	private List<Map<String, Object>> dataList;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview);
		initViews();
	}

	private void initViews() {
		gridView = (GridView) findViewById(R.id.gridView);

		SimpleAdapter adapter = new SimpleAdapter(this, getDate(),
				R.layout.gridview_item, new String[] { "image", "text" },
				new int[] { R.id.grid_img, R.id.grid_text });
		gridView.setAdapter(adapter);
		
		gridView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
            Toast.makeText(GridViewActivity.this, ""+dataList.get(position).get("text"), Toast.LENGTH_SHORT).show();
			}
		});
	}

	private List<Map<String, Object>> getDate() {
		dataList = new ArrayList<Map<String, Object>>();
		int[] drawable = { R.drawable.address_book, R.drawable.calendar,
				R.drawable.camera, R.drawable.clock, R.drawable.games_control,
				R.drawable.messenger, R.drawable.ringtone, R.drawable.settings,
				R.drawable.speech_balloon, R.drawable.weather,
				R.drawable.world, R.drawable.youtube };
		String[] iconName = { "联系人", "日历", "照相机", "时钟", "游戏", "短信", "铃声", "设置",
				"语音", "天气", "浏览器", "Youtube" };
		for (int i = 0; i < drawable.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", drawable[i]);
			map.put("text", iconName[i]);
			dataList.add(map);
		}
		Log.i("Main", "size=" + dataList.size());
		return dataList;
	}
}
