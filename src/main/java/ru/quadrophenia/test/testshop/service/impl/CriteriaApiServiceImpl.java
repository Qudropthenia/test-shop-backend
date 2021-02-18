package ru.quadrophenia.test.testshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import ru.quadrophenia.test.testshop.domain.entity.Goods;
import ru.quadrophenia.test.testshop.domain.entity.Goods_;
import ru.quadrophenia.test.testshop.service.CriteriaApiService;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
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
}
