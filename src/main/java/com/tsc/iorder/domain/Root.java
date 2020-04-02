package com.tsc.iorder.domain;

public class Root {
    private int id;
    private String rootName;

    public Root(int id, String rootName) {
        this.id = id;
        this.rootName = rootName;
    }

    public Root(String rootName) {
        this.rootName = rootName;
    }

    public Root() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    @Override
    public String toString() {
        return "Root{" +
                "id=" + id +
                ", rootName='" + rootName + '\'' +
                '}';
    }
}
