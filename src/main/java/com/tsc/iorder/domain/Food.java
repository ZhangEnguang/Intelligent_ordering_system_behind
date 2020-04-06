package com.tsc.iorder.domain;

import java.math.BigDecimal;

public class Food {
    private int id;
    private String foodName;
    private String img;
    private int typeid;
    private String typeName;
    private double price;
    private String description;
    private int isDiscount;
    private double discount;
    private double discountPrice;
    private int state;

    public Food(int id, String foodName, String img, int typeid, String typeName, double price, String description, int isDiscount, double discount,  int state) {
        this.id = id;
        this.foodName = foodName;
        this.img = img;
        this.typeid = typeid;
        this.typeName = typeName;
        this.price = price;
        this.description = description;
        this.isDiscount = isDiscount;
        this.discount = discount;
        this.discountPrice = this.formatDouble(price*(discount/10));
        this.state = state;
    }

    public Food(String foodName, String img, int typeid, String typeName, double price, String description, int isDiscount, double discount, int state) {
        this.foodName = foodName;
        this.img = img;
        this.typeid = typeid;
        this.typeName = typeName;
        this.price = price;
        this.description = description;
        this.isDiscount = isDiscount;
        this.discount = discount;
        this.discountPrice = this.formatDouble(price*(discount/10));
        this.state = state;
    }

    public Food() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(int isDiscount) {
        this.isDiscount = isDiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscountPrice() {
        Double discountPrice = null;
        if (this.price!=0&&this.discount!=0){
           discountPrice = this.formatDouble(price*(discount/10));
        }else {
            discountPrice = 0.0;
        }
        return discountPrice;
    }

    public void setDiscountPrice(double price,double discount) {
        this.discountPrice = this.formatDouble(price*(discount/10));
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    private Double formatDouble(Double d){
        BigDecimal b   =   new   BigDecimal(d);
        double   result   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", img='" + img + '\'' +
                ", typeid=" + typeid +
                ", typeName='" + typeName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", isDiscount=" + isDiscount +
                ", discount=" + discount +
                ", discountPrice=" + discountPrice +
                ", state=" + state +
                '}';
    }
}
