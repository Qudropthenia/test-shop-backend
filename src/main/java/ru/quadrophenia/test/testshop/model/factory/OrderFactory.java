package ru.quadrophenia.test.testshop.model.factory;

import ru.quadrophenia.test.testshop.domain.entity.Order;
import ru.quadrophenia.test.testshop.model.DateConvertor;
import ru.quadrophenia.test.testshop.model.request.OrderRR;

import java.text.ParseException;
import java.util.Date;

public class OrderFactory {
	public static Order getOrder(OrderRR rr) {
		Order order = new Order();

		order.setId(rr.getId());
		order.setClient(rr.getClient());
		Date date = null;
		try {
			date = DateConvertor.strToDate(rr.getDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		order.setDate(date);
		order.setAddress(rr.getAddress());
		order.setGoods(rr.getGoods());

		return order;
	}
}
