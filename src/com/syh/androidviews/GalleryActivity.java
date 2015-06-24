package com.syh.androidviews;

import com.syh.androidviews.gallery.ImageAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import android.widget.Gallery;
import android.widget.ImageSwitcher;

public class GalleryActivity extends Activity implements
		OnItemSelectedListener, ViewFactory {

	private int[] resId = { R.drawable.item1, R.drawable.item2,
			R.drawable.item3, R.drawable.item4, R.drawable.item5,
			R.drawable.item6, R.drawable.item7, R.drawable.item8,
			R.drawable.item9, R.drawable.item10, R.drawable.item11,
			R.drawable.item12 };

	private Gallery gallery;
	private ImageSwitcher imageSwitcher;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery);
		initViews();
	}

	private void initViews() {
		gallery = (Gallery) findViewById(R.id.gallery);
		ImageAdapter adapter = new ImageAdapter(resId, this);
		gallery.setAdapter(adapter);
		gallery.setOnItemSelectedListener(this);
		imageSwitcher = (ImageSwitcher) findViewById(R.id.imageswitcher);
		imageSwitcher.setFactory(this);
		imageSwitcher.setInAnimation(this, R.anim.left_in);
		imageSwitcher.setOutAnimation(this, R.anim.right_out);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		imageSwitcher.setBackgroundResource(resId[position % resId.length]);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}

	@Override
	public View makeView() {
		ImageView imageView = new ImageView(this);
		imageView.setScaleType(ScaleType.FIT_CENTER);

		return imageView;
	}
}
