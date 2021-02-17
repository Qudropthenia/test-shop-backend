package ru.quadrophenia.test.testshop.service;

import ru.quadrophenia.test.testshop.domain.entity.Goods;
import ru.quadrophenia.test.testshop.domain.entity.Order;
import ru.quadrophenia.test.testshop.domain.request.body.OrderRR;

import java.util.List;

public interface SpringDataService {
	List<Goods> listGoodsAll();
	Goods saveGoods(Goods g);
	Boolean delGoods(int id);
	List<Goods> findGoodsByIdName(Integer id, String name);
	Order saveOrder(OrderRR orderRR);
	List<Order> listOrdersAll();
	Order findOrderById(int id);
	Boolean delOrder(int id);
}
