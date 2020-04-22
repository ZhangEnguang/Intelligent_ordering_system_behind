package com.tsc.iorder.domain;

public class Table {
    private int id;
    private String tableName;

    public Table(int id, String tableName) {
        this.id = id;
        this.tableName = tableName;
    }

    public Table(String tableName) {
        this.tableName = tableName;
    }

    public Table() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", tableName='" + tableName + '\'' +
                '}';
    }
}
