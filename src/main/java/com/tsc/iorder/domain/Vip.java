package com.tsc.iorder.domain;

public class Vip {
    private int id;
    private String name;
    private String phone;
    private double money;
    private double buyNum;
    private int state;
    private String levelName;
    private double discountNum;

    public Vip(int id, String name, String phone, double money, double buyNum, int state, String levelName, double discountNum) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.money = money;
        this.buyNum = buyNum;
        this.state = state;
        this.levelName = levelName;
        this.discountNum = discountNum;
    }

    public Vip(String name, String phone, double money, double buyNum, int state, String levelName, double discountNum) {
        this.name = name;
        this.phone = phone;
        this.money = money;
        this.buyNum = buyNum;
        this.state = state;
        this.levelName = levelName;
        this.discountNum = discountNum;
    }

    public Vip() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(double buyNum) {
        this.buyNum = buyNum;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public double getDiscountNum() {
        return discountNum;
    }

    public void setDiscountNum(double discountNum) {
        this.discountNum = discountNum;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", money=" + money +
                ", buyNum=" + buyNum +
                ", state=" + state +
                ", levelName='" + levelName + '\'' +
                ", discountNum=" + discountNum +
                '}';
    }
}
