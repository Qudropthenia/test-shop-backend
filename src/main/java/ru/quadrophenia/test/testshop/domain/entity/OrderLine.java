package ru.quadrophenia.test.testshop.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity
//@Table(name = "\"order_line\"")
public class OrderLine {
    @Id
    @Column(columnDefinition = "int identity")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @ManyToMany(targetEntity = Order.class, cascade = CascadeType.MERGE)
//    @JoinTable(joinColumns = @JoinColumn(name = "order_line_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "orders_id"))
    @ManyToMany
    @JoinTable(
            name = "\"order_line\""
    )
    private Set<Order> orders = new HashSet<>();
//    @ManyToMany(targetEntity = Goods.class, cascade = CascadeType.MERGE)
//    @JoinTable(joinColumns = @JoinColumn(name = "order_line_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "goods_id"))
    @JoinTable(joinColumns = @JoinColumn(name = "\"order_line_id\"", nullable = false), inverseJoinColumns = @JoinColumn(name = "\"goods_id\""))
    private Set<Goods> goods = new HashSet<>();

    public OrderLine() {
    }

    public OrderLine(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Set<Goods> goods) {
        this.goods = goods;
    }
}
