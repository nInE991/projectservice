package com.example.projectservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OrdersLog {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(nullable = false)
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(nullable = false)
	private Orders orders;
	@Column
	private String note;

	public OrdersLog() {
	}

	public OrdersLog(Date date, Orders orders, String note) {
		this.date = date;
		this.orders = orders;
		this.note = note;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
