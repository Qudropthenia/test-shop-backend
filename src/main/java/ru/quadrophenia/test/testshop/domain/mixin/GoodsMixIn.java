package ru.quadrophenia.test.testshop.domain.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class GoodsMixIn {
	Integer id;
	String name;
	Double price;
	@JsonIgnore
	abstract Double getPrice();
}
