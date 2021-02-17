package ru.quadrophenia.test.testshop.domain.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Date> date;
	public static volatile SingularAttribute<Order, String> address;
	public static volatile SingularAttribute<Order, String> client;
	public static volatile SetAttribute<Order, Goods> goods;
	public static volatile SingularAttribute<Order, Integer> id;

	public static final String DATE = "date";
	public static final String ADDRESS = "address";
	public static final String CLIENT = "client";
	public static final String GOODS = "goods";
	public static final String ID = "id";

}

