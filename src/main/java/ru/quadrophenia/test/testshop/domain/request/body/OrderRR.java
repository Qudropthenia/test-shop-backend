package ru.quadrophenia.test.testshop.domain.request.body;

import ru.quadrophenia.test.testshop.domain.entity.Goods;
import ru.quadrophenia.test.testshop.domain.entity.Order;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderRR {
	private int id;
	private String client;
	private String date;
	private String address;
	private Set<Goods> goods = new HashSet<>();

	public OrderRR() {
	}

	public OrderRR(Order order) {
		setId(order.getId());
		setClient(order.getClient());
		setAddress(order.getAddress());
		Date date = order.getDate();
		String strDate = "";
		try {
			strDate = new SimpleDateFormat("dd.MM.yyyy").format(date);
		} catch (Exception ex ) {
		}
		setDate(strDate);
		setGoods(order.getGoods());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}
}
