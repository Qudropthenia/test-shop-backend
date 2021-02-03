package ru.quadrophenia.test.testshop.domain.report;

public class GoodsIdNameReport {
    private int id;
    private String name;

    public GoodsIdNameReport(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // geter`ы для передачи полей, значений.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
