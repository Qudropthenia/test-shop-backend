package ru.quadrophenia.test.testshop.repository;

import org.springframework.data.repository.CrudRepository;
import ru.quadrophenia.test.testshop.domain.entity.Goods;

import java.util.List;

public interface GoodsRepository extends CrudRepository<Goods, Integer> {
    List<Goods> findAll();
    Goods findById(int id);
    List<Goods> findByNameContaining(String name);
}
