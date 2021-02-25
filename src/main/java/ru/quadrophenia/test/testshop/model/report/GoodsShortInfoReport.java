package ru.quadrophenia.test.testshop.model.report;

import ru.quadrophenia.test.testshop.model.request.GoodsShortInfo;

import java.util.Objects;

public class GoodsShortInfoReport {
    private int id;
    private String name;
    private Double price;

    public GoodsShortInfoReport(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsShortInfo)) return false;
        GoodsShortInfo that = (GoodsShortInfo) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice());
    }
}
