package ru.quadrophenia.test.testshop.repository;

import org.springframework.data.repository.CrudRepository;
import ru.quadrophenia.test.testshop.domain.entity.Goods;

import java.util.List;

public interface GoodsRepository extends CrudRepository<Goods, Integer> {
    List<Goods> findAllByOrderByNameAsc();
    Goods findById(int id);
    List<Goods> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
}
