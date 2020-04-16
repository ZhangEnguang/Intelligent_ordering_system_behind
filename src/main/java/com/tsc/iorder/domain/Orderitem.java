package com.tsc.iorder.domain;

public class Orderitem {
    private int id;
    private String oid;
    private int fid;
    private Food food;
    private int count;
    private double total;
    private Order order;

    public Orderitem(int id, String oid, int fid, Food food, int count, double total, Order order) {
        this.id = id;
        this.oid = oid;
        this.fid = fid;
        this.food = food;
        this.count = count;
        this.total = total;
        this.order = order;
    }

    public Orderitem(String oid, int fid, Food food, int count, double total, Order order) {
        this.oid = oid;
        this.fid = fid;
        this.food = food;
        this.count = count;
        this.total = total;
        this.order = order;
    }

    public Orderitem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Orderitem{" +
                "id=" + id +
                ", oid='" + oid + '\'' +
                ", fid=" + fid +
                ", food=" + food +
                ", count=" + count +
                ", total=" + total +
                ", order=" + order +
                '}';
    }
}
