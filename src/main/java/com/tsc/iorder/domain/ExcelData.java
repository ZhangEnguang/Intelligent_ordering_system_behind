package com.tsc.iorder.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.tsc.iorder.util.DoubleUtil;

@ColumnWidth(20)
public class ExcelData {
    @ExcelProperty(value = "订单编号",index = 0)
    private String oid;
    @ExcelProperty(value = "点餐人",index = 1)
    private String name;
    @ExcelProperty(value = "菜品名称",index = 2)
    private String foodName;
    @ExcelProperty(value = "菜品现价(元)",index = 3)
    private String price;
    @ExcelProperty(value = "份数",index = 4)
    private Integer count;
    @ExcelProperty(value = "折后小计(元)",index = 5)
    private Double total;
    @ExcelProperty(value = "生成时间",index = 6)
    private String ordertime;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPrice() {
        String price = "";
        if (this.price == null){
            price = "菜品已删除";
        }else {
            price = String.valueOf(DoubleUtil.formatDouble(Double.valueOf(this.price)));
        }
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }
}
