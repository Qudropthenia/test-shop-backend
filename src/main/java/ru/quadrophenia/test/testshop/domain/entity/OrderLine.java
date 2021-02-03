package ru.quadrophenia.test.testshop.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity
//@Table(name = "order_line")
public class OrderLine {
    private int id;
    private Set<Order> orders = new HashSet<>();
    private Set<Goods> goods = new HashSet<>();

    public OrderLine() {
    }

    public OrderLine(int id) {
        this.id = id;
    }

    @Id
    @Column(columnDefinition = "int identity")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @ManyToMany(targetEntity = Order.class, cascade = CascadeType.MERGE)
    @JoinTable(joinColumns = @JoinColumn(name = "order_line_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "orders_id"))
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Basic
    @ManyToMany(targetEntity = Order.class, cascade = CascadeType.MERGE)
    @JoinTable(joinColumns = @JoinColumn(name = "order_line_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "orders_id"))
    public Set<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Set<Goods> goods) {
        this.goods = goods;
    }
}
