package com.syh.androidviews.listview;

public class Persion {
	private int id;
	private String name;
	private String number;
	private boolean isChecked;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Persion(int id, String name, String number) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
	}

	public Persion() {

	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

}
