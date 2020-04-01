package com.tsc.iorder.domain;

import java.util.Map;

public class SearchParam {
    private int start;
    private int pageSize;
    private int event;
    private int id;
    private String input;

    public SearchParam() {
    }
    public SearchParam(Map<String,Object> params){
        this.start = (int) params.get("start");
        this.pageSize = (int) params.get("pageSize");
        this.input = (String) params.get("input");
    }
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
