package ru.quadrophenia.test.testshop.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "\"goods\"")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "price")
    private Double price;

    public Goods() {
    }

    public Goods(int id) {
        this.id = id;
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
}
