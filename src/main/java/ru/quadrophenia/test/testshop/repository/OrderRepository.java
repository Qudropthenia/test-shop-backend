package ru.quadrophenia.test.testshop.repository;

import org.springframework.data.repository.CrudRepository;
import ru.quadrophenia.test.testshop.domain.entity.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findAll();
    Order findById(int id);
}
