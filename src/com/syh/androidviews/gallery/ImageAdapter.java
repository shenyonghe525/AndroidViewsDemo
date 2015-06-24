package com.syh.androidviews.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ImageAdapter extends BaseAdapter {

	private int[] resId;
	private Context context;

	public ImageAdapter(int[] resId, Context context) {
		this.resId = resId;
		this.context = context;
	}

	/**
	 * 无限循环
	 */
	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override
	public Object getItem(int position) {
		return resId[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ImageView imageView = new ImageView(context);
		imageView.setBackgroundResource(resId[position % resId.length]);
		imageView.setLayoutParams(new Gallery.LayoutParams(800, 600));
		imageView.setScaleType(ScaleType.FIT_XY);
		return imageView;
	}

}
