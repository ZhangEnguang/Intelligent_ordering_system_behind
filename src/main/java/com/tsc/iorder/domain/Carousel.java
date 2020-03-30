package com.tsc.iorder.domain;

public class Carousel {
    private int id;
    private int isShow;
    private String path;
    private String description;

    public Carousel(int id, int isShow, String path, String description) {
        this.id = id;
        this.isShow = isShow;
        this.path = path;
        this.description = description;
    }

    public Carousel(int isShow, String path, String description) {
        this.isShow = isShow;
        this.path = path;
        this.description = description;
    }

    public Carousel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        if (description==null||description.equals("")){
            return  "暂无描述";
        }
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "id=" + id +
                ", isShow=" + isShow +
                ", path='" + path + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
