package com.tsc.iorder.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsc.iorder.domain.Root;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Root")
public class RootController {
    @Autowired
    private RootService service;
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list(){
        Map<String,Object> map = new HashMap<>();
        List<Root> list = this.service.list();
        map.put("list",list);
        return map;
    }
    @RequestMapping("/listNoRoot")
    @ResponseBody
    public Map<String,Object> listNoRoot(){
        Map<String,Object> map = new HashMap<>();
        List<Root> list = this.service.listNoRoot();
        map.put("list",list);
        return map;
    }
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String,Object> getList(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        SearchParam searchParam = new SearchParam(map);
        PageHelper.startPage(searchParam.getStart(),searchParam.getPageSize());
        List<Root> list = this.service.getList(searchParam);
        PageInfo<Root> pageInfo = new PageInfo<>(list);
        resMap.put("page",pageInfo);
        return resMap;
    }
}
