package com.tsc.iorder.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.domain.VipLevel;
import com.tsc.iorder.service.VipLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/VipLevel")
public class VipLevelController {
    @Autowired
    private VipLevelService service;
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        SearchParam searchParam = new SearchParam(map);
        PageHelper.startPage(searchParam.getStart(),searchParam.getPageSize());
        List<VipLevel> list = this.service.list(searchParam);
        PageInfo<VipLevel> pageInfo = new PageInfo<>(list);
        resMap.put("page",pageInfo);
        return resMap;
    }
    @RequestMapping("check")
    @ResponseBody
    public Map<String,Object> check(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        VipLevel vipLevel = this.service.findById((Integer)map.get("id"));
        Map<String,Double> discountMap = this.service.findDiscount(vipLevel);
        resMap.put("discountMap",discountMap);
        return resMap;
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@RequestBody Map<String,VipLevel> map){
        VipLevel vipLevel = this.service.findByName(map.get("vipLevel").getLevelName());
        VipLevel byId = this.service.findById(map.get("vipLevel").getId());
        if (!map.get("vipLevel").getLevelName().equals(byId.getLevelName())){
            if (vipLevel!=null){
                return false;
            }
        }
        return this.service.update(map.get("vipLevel"));
    }
    @RequestMapping("/checkAdd")
    @ResponseBody
    public Map<String,Object> checkAdd(){
        Map<String,Object> resMap = new HashMap<>();
        Map<String,Double> discountMap = this.service.checkAdd();
        resMap.put("discountMap",discountMap);
        return resMap;
    }
    @RequestMapping("/addVipLevel")
    @ResponseBody
    public boolean addVipLevel(@RequestBody Map<String,VipLevel> map){
        VipLevel vipLevel = map.get("vipLevel");
        VipLevel v = this.service.findByName(vipLevel.getLevelName());
        if (v!=null){
            return false;
        }
        return this.service.addVipLevel(vipLevel);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestBody Map<String,Object> map){
        return this.service.delete((int)map.get("id"));
    }
}
