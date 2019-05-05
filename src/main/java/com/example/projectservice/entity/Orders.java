package com.example.projectservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_generator")
	@SequenceGenerator(name = "orders_generator", sequenceName = "orders_id_seq", allocationSize = 1)
	private Integer id;
	@Column(nullable = false)
	private String serial;
	@Column(nullable = false)
	private String note;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(nullable = false)
	private Customer customer;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn
	private Price price;
	@Column(nullable = false)
	private Date date;
	@Column
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Column
	private Boolean finish;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(nullable = false)
	private OrdersStatus status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getFinish() {
		return finish;
	}

	public void setFinish(Boolean finish) {
		this.finish = finish;
	}

	public OrdersStatus getStatus() {
		return status;
	}

	public void setStatus(OrdersStatus status) {
		this.status = status;
	}
}
