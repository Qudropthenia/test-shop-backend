package ru.quadrophenia.test.testshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.quadrophenia.test.testshop.domain.entity.Goods;
import ru.quadrophenia.test.testshop.domain.entity.Goods_;
import ru.quadrophenia.test.testshop.domain.entity.Order;
import ru.quadrophenia.test.testshop.domain.entity.Order_;
import ru.quadrophenia.test.testshop.model.request.OrderRR;
import ru.quadrophenia.test.testshop.model.factory.OrderFactory;
import ru.quadrophenia.test.testshop.service.CriteriaApiService;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CriteriaApiServiceImpl implements CriteriaApiService {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Goods> listGoodsAll() {
		CriteriaBuilder crBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Goods> crQuery = crBuilder.createQuery(Goods.class);
		Root<Goods> goodsRoot = crQuery.from(Goods.class);
		crQuery.orderBy(crBuilder.asc(goodsRoot.get(Goods_.name)));
		List<Goods> resultList = entityManager.createQuery(crQuery).getResultList();

		return resultList;
	}

	@Override
	public Goods saveGoods(Goods g) {
		entityManager.merge(g);
		return g;
	}

	@Override
	@Transactional
	public Boolean delGoods(int id) {
		Boolean result = true;
		Goods goods = entityManager.find(Goods.class, id);
		try {
			entityManager.remove(goods);
		} catch (IllegalArgumentException e) {
			result = false;
		}

		return result;
	}

	@Override
	public List<Goods> findGoodsByIdName(Integer id, String name) {
		CriteriaBuilder crBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Goods> crQuery = crBuilder.createQuery(Goods.class);
		Root<Goods> goodsRoot = crQuery.from(Goods.class);
		// Условия отбора
		List<Predicate> predicates = new ArrayList<>();
		if (name != null) {
			name = "%" + name + "%";
			Predicate like = crBuilder.like(crBuilder.upper(goodsRoot.get(Goods_.name)), name);
			predicates.add(like);
		}
		if (id != null) {
			predicates.add(crBuilder.equal(goodsRoot.get(Goods_.id), id));
		}
		Predicate predicate = crBuilder.or(predicates.toArray(new Predicate[]{}));
		crQuery.where(predicate);
		crBuilder.asc(goodsRoot.get(Goods_.name));
		List<Goods> resultList = entityManager.createQuery(crQuery).getResultList();

		return resultList;
	}

	@Override
	public List<Order> listOrdersAll() {
		CriteriaBuilder crBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Order> crQuery = crBuilder.createQuery(Order.class);
		Root<Order> orderRoot = crQuery.from(Order.class);
		List<Order> resultList = entityManager.createQuery(crQuery).getResultList();

		return resultList;
	}

	@Override
	@Transactional
	public Order saveOrder(OrderRR orderRR) {
		Order order = OrderFactory.getOrder(orderRR);
		entityManager.merge(order);

		return order;
	}

	@Override
	public Order saveOrder(Order order) {
		entityManager.merge(order);

		return order;
	}

	@Override
	public Order findOrderById(int id) {
//		return entityManager.find(Order.class, id);
		CriteriaBuilder crBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Order> crQuery = crBuilder.createQuery(Order.class);
		Root<Order> orderRoot = crQuery.from(Order.class);
		crQuery.where(crBuilder.equal(orderRoot.get(Order_.id), id));
		Order result = entityManager.createQuery(crQuery).getSingleResult();

		return result;
	}

	@Override
	public Boolean delOrder(int id) {
		Boolean result = true;
		Order order = null;
		order = entityManager.find(Order.class, id);
		try {
			entityManager.remove(order);
		} catch (Exception e) {
			result = false;
		}

		return result;
	}
}
