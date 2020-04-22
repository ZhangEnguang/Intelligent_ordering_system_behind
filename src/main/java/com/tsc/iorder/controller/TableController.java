package com.tsc.iorder.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.domain.Table;
import com.tsc.iorder.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Table")
public class TableController {
    @Autowired
    private TableService service;
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String,Object> getList(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        SearchParam searchParam = new SearchParam(map);
        PageHelper.startPage(searchParam.getStart(),searchParam.getPageSize());
        List<Table> list = this.service.getList(searchParam);
        PageInfo<Table> pageInfo = new PageInfo<>(list);
        resMap.put("page",pageInfo);
        return resMap;
    }
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list(){
        Map<String,Object> map = new HashMap<>();
        List<Table> list = this.service.list();
        map.put("list",list);
        return map;
    }
    @RequestMapping("/addTable")
    @ResponseBody
    public boolean addType(@RequestBody Map<String,Object> map){
        Table table = this.service.findTableByTableName((String)map.get("tableName"));
        if (table!=null){
            return false;
        }
        return this.service.addTable((String)map.get("tableName"));
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@RequestBody Map<String,Object> map){
        Table table = this.service.findTableById((int)map.get("id"));
        Table tableByTableName = this.service.findTableByTableName((String) map.get("tableName"));
        if (!table.getTableName().equals(map.get("tableName"))){
            if (tableByTableName!=null){
                return false;
            }
        }
        Table resTable = new Table((int) map.get("id"), (String) map.get("tableName"));
        return this.service.update(resTable);
    }
    @RequestMapping("/findById")
    @ResponseBody
    public Map<String,Object> findById(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        Table table = this.service.findTableById((int)map.get("id"));
        resMap.put("table",table);
        return resMap;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestBody Map<String,Object> map){
        return this.service.delete((int)map.get("id"));
    }
}
