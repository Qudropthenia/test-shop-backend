package ru.quadrophenia.test.testshop.model.request;

import ru.quadrophenia.test.testshop.domain.entity.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderBody extends Order {
	private String strDate;

	public OrderBody() {
		super();
	}

	public Order getOrder() {
		Date date;
		try {
			 date = new SimpleDateFormat("dd.MM.yyyy").parse(this.strDate);
		} catch (ParseException e) {
			date = null;
			e.printStackTrace();
		}
		super.setDate(date);
		return  (Order) this;
	}

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String date) {
		this.strDate = date;
	}
}
