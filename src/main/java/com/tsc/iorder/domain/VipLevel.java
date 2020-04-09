package com.tsc.iorder.domain;

public class VipLevel {
    private int id;
    private double minNum;
    private double maxNum;
    private String levelName;
    private double discountNum;

    public VipLevel(int id, double minNum, double maxNum, String levelName, double discountNum) {
        this.id = id;
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.levelName = levelName;
        this.discountNum = discountNum;
    }

    public VipLevel(double minNum, double maxNum, String levelName, double discountNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.levelName = levelName;
        this.discountNum = discountNum;
    }

    public VipLevel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMinNum() {
        return minNum;
    }

    public void setMinNum(double minNum) {
        this.minNum = minNum;
    }

    public double getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(double maxNum) {
        this.maxNum = maxNum;
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
        return "VipLevel{" +
                "id=" + id +
                ", minNum=" + minNum +
                ", maxNum=" + maxNum +
                ", levelName='" + levelName + '\'' +
                ", discountNum=" + discountNum +
                '}';
    }
}
