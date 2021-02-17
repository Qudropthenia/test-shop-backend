package ru.quadrophenia.test.testshop.domain.entity;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "client", length = 100)
    private String client;
    @Column(name = "date")
    private Date date;
    @Column(name = "address", length = 100)
    private String address;
    @ManyToMany(targetEntity = Goods.class, cascade = CascadeType.MERGE)
    @JoinTable(
            name="\"order_line\"",
            joinColumns=@JoinColumn(name="order_id", nullable=false),
            inverseJoinColumns=@JoinColumn(name="goods_id")
    )
    private Set<Goods> goods = new HashSet<>();

    public Order() {
    }

    public Order(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Set<Goods> goods) {
        this.goods = goods;
    }
}
