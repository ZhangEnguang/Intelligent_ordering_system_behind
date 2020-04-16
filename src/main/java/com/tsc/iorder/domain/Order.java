package com.tsc.iorder.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {
    private String oid;
    private String uid;
    private String name;
    private double subtotal;
    private List<Orderitem> orderitems;
    private String ordertime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    public Order(String oid, String uid,String name, double subtotal, List<Orderitem> orderitems, String ordertime) {
        this.oid = oid;
        this.uid = uid;
        this.name = name;
        this.subtotal = subtotal;
        this.orderitems = orderitems;
        this.ordertime = ordertime;
    }

    public Order(String uid,String name, double subtotal, List<Orderitem> orderitems, String ordertime) {
        this.uid = uid;
        this.name = name;
        this.subtotal = subtotal;
        this.orderitems = orderitems;
        this.ordertime = ordertime;
    }

    public Order() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public List<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", subtotal=" + subtotal +
                ", orderitems=" + orderitems +
                ", ordertime='" + ordertime + '\'' +
                '}';
    }
}
