package com.tsc.iorder.domain;

public class User {
    private String id;
    private String username;
    private String password;
    private int root;
    private String img;
    private String name;
    private String rootName;

    public User(String id, String username, String password, int root, String img, String name, String rootName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.root = root;
        this.img = img;
        this.name = name;
        this.rootName = rootName;
    }

    public User(String username, String password, int root, String img, String name, String rootName) {
        this.username = username;
        this.password = password;
        this.root = root;
        this.img = img;
        this.name = name;
        this.rootName = rootName;
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
                '}';
    }
}
