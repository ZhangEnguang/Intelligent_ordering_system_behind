package com.tsc.iorder.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsc.iorder.domain.FoodType;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.service.FoodService;
import com.tsc.iorder.service.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/FoodType")
public class FoodTypeController {
    @Autowired
    private FoodTypeService service;
    @Autowired
    private FoodService foodService;
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String,Object> getList(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        SearchParam searchParam = new SearchParam(map);
        PageHelper.startPage(searchParam.getStart(),searchParam.getPageSize());
        List<FoodType> list = this.service.getList(searchParam);
        PageInfo<FoodType> pageInfo = new PageInfo<>(list);
        resMap.put("page",pageInfo);
        return resMap;
    }
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list(){
        Map<String,Object> map = new HashMap<>();
        List<FoodType> list = this.service.list();
        map.put("list",list);
        return map;
    }
    @RequestMapping("/addType")
    @ResponseBody
    public boolean addType(@RequestBody Map<String,Object> map){
        FoodType foodType = this.service.findTypeByTypeName((String)map.get("typeName"));
        if (foodType!=null){
            return false;
        }
        return this.service.addType((String)map.get("typeName"));
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@RequestBody Map<String,Object> map){
        FoodType foodType = this.service.findFoodTypeById((int)map.get("id"));
        FoodType foodTypeByTypeName = this.service.findTypeByTypeName((String) map.get("typeName"));
        if (!foodType.getTypeName().equals(map.get("typeName"))){
            if (foodTypeByTypeName!=null){
                return false;
            }
        }
        FoodType resType = new FoodType((int) map.get("id"), (String) map.get("typeName"));
        return this.service.update(resType);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestBody Map<String,Object> map){
        this.foodService.lockByTypeId((int)map.get("id"));
        return this.service.delete((int)map.get("id"));
    }
}
