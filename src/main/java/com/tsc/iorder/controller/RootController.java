package com.tsc.iorder.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsc.iorder.domain.Root;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.service.RootService;
import com.tsc.iorder.service.UserService;
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
    @Autowired
    private UserService userService;
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
    @RequestMapping("/addRoot")
    @ResponseBody
    public boolean addRoot(@RequestBody Map<String,Object> map){
        Root root = this.service.findRootByRootName((String)map.get("rootName"));
        if (root!=null){
            return false;
        }
        return this.service.addRoot((String)map.get("rootName"));
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@RequestBody Map<String,Object> map){
        Root root = this.service.findRootById((int)map.get("id"));
        Root rootByRootName = this.service.findRootByRootName((String) map.get("rootName"));
        if (!root.getRootName().equals(map.get("rootName"))){
            if (rootByRootName!=null){
                return false;
            }
        }
        Root resRoot = new Root((int) map.get("id"), (String) map.get("rootName"));
        return this.service.update(resRoot);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestBody Map<String,Object> map){
        this.userService.lockByRootId((int)map.get("id"));
        return this.service.delete((int)map.get("id"));
    }
}
