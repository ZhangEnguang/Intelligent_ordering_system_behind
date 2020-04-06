package com.tsc.iorder.domain;

import java.math.BigDecimal;

public class User {
    private String id;
    private String username;
    private String password;
    private int root;
    private String img;
    private String name;
    private String rootName;
    private String date;
    private int state;
    private double serviceTimes;
    private double serviceGrade;
    private double rate;

    public User(String id, String username, String password, int root, String img, String name, String rootName, String date, int state, double serviceTimes, double serviceGrade) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.root = root;
        this.img = img;
        this.name = name;
        this.rootName = rootName;
        this.date = date;
        this.state = state;
        this.serviceTimes = serviceTimes;
        this.serviceGrade = serviceGrade;
        this.rate = this.formatDouble(serviceGrade/serviceTimes);
    }

    public User(String username, String password, int root, String img, String name, String rootName, String date, int state, double serviceTimes, double serviceGrade) {
        this.username = username;
        this.password = password;
        this.root = root;
        this.img = img;
        this.name = name;
        this.rootName = rootName;
        this.date = date;
        this.state = state;
        this.serviceTimes = serviceTimes;
        this.serviceGrade = serviceGrade;
        this.rate = this.formatDouble(serviceGrade/serviceTimes);
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getServiceTimes() {
        return serviceTimes;
    }

    public void setServiceTimes(double serviceTimes) {
        this.serviceTimes = serviceTimes;
    }

    public double getserviceGrade() {
        return serviceGrade;
    }

    public void setserviceGrade(double serviceGrade) {
        this.serviceGrade = serviceGrade;
    }

    public double getRate() {
        Double rate = null;
        if (this.serviceGrade!=0&&this.serviceTimes!=0){
            rate = this.formatDouble(this.serviceGrade / this.serviceTimes);
        }else {
            rate = 0.0;
        }
        return rate;
    }

    public void setRate(double serviceGrade,double serviceTimes) {
        this.rate = this.formatDouble(serviceGrade/serviceTimes);
    }
    private Double formatDouble(Double d){
        BigDecimal b   =   new   BigDecimal(d);
        double   result   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", root=" + root +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", rootName='" + rootName + '\'' +
                ", date='" + date + '\'' +
                ", state=" + state +
                ", serviceTimes=" + serviceTimes +
                ", serviceGrade=" + serviceGrade +
                ", rate=" + rate +
                '}';
    }
}
