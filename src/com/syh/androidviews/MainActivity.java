package com.syh.androidviews;

import java.util.ArrayList;
import java.util.List;
import com.syh.androidviews.listview.MyAdapter;
import com.syh.androidviews.listview.Persion;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
	}

	private void initViews() {
		listView = (ListView) findViewById(R.id.lv);
		MyAdapter adapter = new MyAdapter(getBaseContext(), getListViewDatas(),
				R.layout.list_item);
		listView.setAdapter(adapter);
	}

	/**
	 * 设置listview的数据源 Tile:getListViewDatas
	 * 
	 * @return List<Persion>
	 */
	private List<Persion> getListViewDatas() {
		List<Persion> datas = new ArrayList<Persion>();
		for (int i = 0; i < 20; i++) {
			Persion persion = new Persion();
			persion.setId(i);
			persion.setName("shenyonghe" + i);
			persion.setNumber("13312345678");
			datas.add(persion);
		}
		return datas;
	}
}
