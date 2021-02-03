package ru.quadrophenia.test.testshop.service;

import ru.quadrophenia.test.testshop.domain.entity.Goods;
import ru.quadrophenia.test.testshop.domain.report.GoodsIdNameReport;

import java.util.List;

public interface TestService {
    Boolean addGoods(String name, Double price);
    List<Goods> getAllDoods();
    Object goodsFindById(int id);
    // Пример использования Criteria API
    List<GoodsIdNameReport> getGoodsIdName();
}
