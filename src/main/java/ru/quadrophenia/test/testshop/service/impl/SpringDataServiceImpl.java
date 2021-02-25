package ru.quadrophenia.test.testshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.quadrophenia.test.testshop.domain.entity.Goods;
import ru.quadrophenia.test.testshop.domain.entity.Order;
import ru.quadrophenia.test.testshop.model.request.OrderRR;
import ru.quadrophenia.test.testshop.repository.GoodsRepository;
import ru.quadrophenia.test.testshop.repository.OrderRepository;
import ru.quadrophenia.test.testshop.service.SpringDataService;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SpringDataServiceImpl implements SpringDataService {
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private GoodsRepository goodsRep;

	@Autowired
	private OrderRepository orderRep;

	@Override
	public List<Goods> listGoodsAll() {
		return goodsRep.findAllByOrderByNameAsc();
	}

	@Override
	public Goods saveGoods(Goods g) {
		Goods goods = (g.getId() > 0) ? g : new Goods(g.getName(), g.getPrice());
		return goodsRep.save(goods);
	}

	@Override
	public Boolean delGoods(int id) {
		try {
			goodsRep.deleteById(id);
			return true;
		} catch (IllegalArgumentException | EmptyResultDataAccessException e) {
			return false;
		}
	}

	@Override
	public List<Goods> findGoodsByIdName(Integer id, String name) {
		List<Goods> result = new ArrayList<>();

		if (id != null && id > 0) {
			Goods goods = goodsRep.findById(id.intValue());
			if (goods != null) result.add(goods);
		} else if (name != null) {
			List<Goods> goodsList = goodsRep.findByNameContainingIgnoreCaseOrderByNameAsc(name);
			if (goodsList != null) result = goodsList;
		}

		return result;
	}

	@Override
	public Order saveOrder(OrderRR orderRR) {
		Order order = new Order();

		order.setId(orderRR.getId());
		order.setClient(orderRR.getClient());
		try {
			Date date = new SimpleDateFormat("dd.MM.yyyy").parse(orderRR.getDate());
			order.setDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		order.setAddress(orderRR.getAddress());
		order.setGoods(orderRR.getGoods());
		orderRep.save(order);

//		return new OrderRR(order);
		return order;
	}

	@Override
	public List<Order> listOrdersAll() {
		return orderRep.findAll();
	}

	@Override
	public Order findOrderById(int id) {
		return orderRep.findById(id);
	}

	@Override
	public Boolean delOrder(int id) {
		try {
			orderRep.deleteById(id);
			return true;
		} catch (IllegalArgumentException | EmptyResultDataAccessException e) {
			return false;
		}
	}
}
