package com.tsc.iorder.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsc.iorder.domain.Food;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Food")
public class FoodController {
    @Autowired
    private FoodService service;
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        SearchParam searchParam = new SearchParam(map);
        PageHelper.startPage(searchParam.getStart(),searchParam.getPageSize());
        List<Food> list = this.service.list(searchParam);
        PageInfo<Food> pageInfo = new PageInfo<>(list);
        resMap.put("page",pageInfo);
        return resMap;
    }
    @RequestMapping("/updateIsDiscount")
    @ResponseBody
    public void updateIsDiscount(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId((Integer) map.get("id"));
        searchParam.setEvent((int) map.get("event"));
        this.service.updateIsDiscount(searchParam);
    }
    @RequestMapping("/updateIsState")
    @ResponseBody
    public void updateIsState(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId((Integer) map.get("id"));
        searchParam.setEvent((Integer) map.get("event"));
        this.service.updateIsState(searchParam);
    }
    @RequestMapping("/show")
    @ResponseBody
    public void show(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId((int) map.get("id"));
        this.service.show(searchParam);
    }
    @RequestMapping("/unShow")
    @ResponseBody
    public void unShow(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId((int) map.get("id"));
        this.service.unShow(searchParam);
    }
    @RequestMapping("/updateDiscount")
    @ResponseBody
    public void updateDiscount(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId((Integer) map.get("id"));
        searchParam.setDiscount(Double.valueOf((String)map.get("discount")));
        this.service.updateDiscount(searchParam);
    }
}
