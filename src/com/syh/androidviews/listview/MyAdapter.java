package com.syh.androidviews.listview;

import java.util.List;

import com.syh.androidviews.R;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class MyAdapter extends CommonAdapter<Persion> {

	public MyAdapter(Context context, List<Persion> datas, int itemLayout) {
		super(context, datas, itemLayout);
	}

	public void convert(View convertView, ViewGroup parent,
			final Persion persion) {
		TextView id = ViewHolder.get(convertView, R.id.tv_id);
		TextView name = ViewHolder.get(convertView, R.id.tv_name);
		TextView number = ViewHolder.get(convertView, R.id.tv_number);
		final CheckBox gayBox = ViewHolder.get(convertView, R.id.gay_cb);
		gayBox.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if (gayBox.isChecked()) {
					persion.setChecked(true);
				} else {
					persion.setChecked(false);
				}
			}
		});
		id.setText(persion.getId() + "");
		name.setText(persion.getName());
		number.setText(persion.getNumber());
		gayBox.setChecked(persion.isChecked());
	}

}
