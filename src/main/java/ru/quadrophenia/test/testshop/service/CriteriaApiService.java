package ru.quadrophenia.test.testshop.service;

import ru.quadrophenia.test.testshop.domain.entity.Goods;
import ru.quadrophenia.test.testshop.domain.entity.Order;
import ru.quadrophenia.test.testshop.model.request.OrderRR;

import java.util.List;

public interface CriteriaApiService {
	List<Goods> listGoodsAll();
	Goods saveGoods(Goods g);
	Boolean delGoods(int id);
	List<Goods> findGoodsByIdName(Integer id, String name);
	List<Order> listOrdersAll();
	Order saveOrder(OrderRR orderRR);
	Order saveOrder(Order order);
	Order findOrderById(int id);
	Boolean delOrder(int id);
}
