package com.tsc.iorder.domain;

public class PieData {
    private double value;
    private String name;

    public PieData(double value, String name) {
        this.value = value;
        this.name = name;
    }

    public PieData() {
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PieData{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
