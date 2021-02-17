package ru.quadrophenia.test.testshop.domain.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Goods.class)
public abstract class Goods_ {

	public static volatile SingularAttribute<Goods, Double> price;
	public static volatile SingularAttribute<Goods, String> name;
	public static volatile SingularAttribute<Goods, Integer> id;

	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String ID = "id";

}

