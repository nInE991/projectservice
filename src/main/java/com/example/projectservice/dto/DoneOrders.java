package com.example.projectservice.dto;

public class DoneOrders {
	private String date;
	private Integer count;

	public DoneOrders() {
	}

	public DoneOrders(String date, Integer count) {
		this.date = date;
		this.count = count;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
