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
}
