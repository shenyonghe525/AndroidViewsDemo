package com.syh.androidviews;

import java.util.Calendar;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class DatePickerActivity extends Activity {

	private TimePicker timePicker;
	private DatePicker datePicker;
	private Calendar calendar;

	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datapicker);
		// 获取日历的一个对象
		calendar = Calendar.getInstance();
		// 获取年月日时分秒的信息
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
		day = calendar.get(Calendar.DAY_OF_MONTH);
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		minute = calendar.get(Calendar.MINUTE);
		setTitle(year + "-" + month + "-" + day + " " + hour + ":" + minute);
		initView();
	}

	private void initView() {
		timePicker = (TimePicker) findViewById(R.id.timePicker);
		datePicker = (DatePicker) findViewById(R.id.datePicker);
		// datePicker初始化
		datePicker.init(year, calendar.get(Calendar.MONTH), day,
				new OnDateChangedListener() {

					public void onDateChanged(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {

						setTitle(year + "-" + (monthOfYear + 1) + "-"
								+ dayOfMonth + " " + hour + ":" + minute);
					}
				});

		timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {

			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				setTitle(hourOfDay + ":" + minute);
			}
		});

//		new DatePickerDialog(this, new OnDateSetListener() {
//
//			public void onDateSet(DatePicker view, int year, int monthOfYear,
//					int dayOfMonth) {
//				setTitle(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
//			}
//		}, year, calendar.get(Calendar.MONTH), day).show();

		new TimePickerDialog(this, new OnTimeSetListener() {

			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				setTitle(hourOfDay + ":" + minute);
			}
		}, hour, minute, true).show();
	}
}
