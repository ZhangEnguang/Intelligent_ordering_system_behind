package com.tsc.iorder.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.domain.Vip;
import com.tsc.iorder.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Vip")
public class VipController {
    @Autowired
    private VipService service;
    @RequestMapping("/addVip")
    @ResponseBody
    public boolean addVip(@RequestBody Map<String,Object> map){
        Vip vip = new Vip();
        vip.setName((String) map.get("name"));
        vip.setPhone((String) map.get("phone"));
        Vip resVip = this.service.findByPhone((String) map.get("phone"));
        if (resVip!=null){
            return false;
        }
        return this.service.addVip(vip);
    }
    @RequestMapping("/checkPhone")
    @ResponseBody
    public Map<String,Object> checkPhone(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        Vip vip = this.service.findByPhone((String)map.get("phone"));
        resMap.put("vip",vip);
        return resMap;
    }
    @RequestMapping("/recharge")
    @ResponseBody
    public Map<String,Object> recharge(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        Vip vip = this.service.findByPhone((String)map.get("phone"));
        if (!vip.getName().equals(map.get("name"))){
            resMap.put("isVip",false);
            return resMap;
        }
        Vip v = new Vip();
        v.setPhone((String) map.get("phone"));
        v.setMoney(Double.valueOf((String) map.get("money")));
        resMap.put("isVip",this.service.recharge(v));
        Vip byPhone = this.service.findByPhone((String) map.get("phone"));
        resMap.put("vip",byPhone);
        return resMap;
    }
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        SearchParam searchParam = new SearchParam(map);
        PageHelper.startPage(searchParam.getStart(),searchParam.getPageSize());
        List<Vip> list = this.service.list(searchParam);
        PageInfo<Vip> pageInfo = new PageInfo<>(list);
        resMap.put("page",pageInfo);
        return resMap;
    }
    @RequestMapping("/updateState")
    @ResponseBody
    public void updateState(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId((Integer) map.get("id"));
        searchParam.setEvent((int) map.get("event"));
        this.service.updateState(searchParam);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestBody Map<String,Object> map){
        return this.service.delete((Integer)map.get("id"));
    }
}
