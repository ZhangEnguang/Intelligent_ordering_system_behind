package com.tsc.iorder.controller;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsc.iorder.domain.*;
import com.tsc.iorder.service.OrderService;
import com.tsc.iorder.service.VipService;
import com.tsc.iorder.util.CommonUtils;
import com.tsc.iorder.util.DoubleUtil;
import com.tsc.iorder.util.UUID16;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderService service;
    @Autowired
    private VipService vipService;
    @RequestMapping("/addOrder")
    @ResponseBody
    public Map<String,Object> addOrder(@RequestBody Order order,String phone,int tid){
        Map<String,Object> map = new HashMap<>();
        Vip byPhone = null;
        if (phone!=null&&!phone.equals("")){
            byPhone = vipService.findByPhone(phone);
        }
        order.setOid(UUID16.getUUID16());
        order.setTid(tid);
        List<Orderitem> orderitems = order.getOrderitems();
        for (Orderitem orderitem : orderitems) {
            Double formatDouble;
            if (orderitem.getFood().getIsDiscount() == 1){
                if (byPhone!=null){
                    formatDouble = DoubleUtil.formatDouble(orderitem.getCount() * orderitem.getFood().getDiscountPrice()*byPhone.getDiscountNum()/10);
                }else {
                    formatDouble = DoubleUtil.formatDouble(orderitem.getCount() * orderitem.getFood().getDiscountPrice());
                }
            }else {
                if (byPhone!=null){
                    formatDouble = DoubleUtil.formatDouble(orderitem.getCount() * orderitem.getFood().getPrice()*byPhone.getDiscountNum()/10);
                }else {
                    formatDouble = DoubleUtil.formatDouble(orderitem.getCount() * orderitem.getFood().getPrice());
                }
            }
            orderitem.setTotal(formatDouble);
            orderitem.setOid(order.getOid());
            orderitem.setFid(orderitem.getFood().getId());
        }
        if (byPhone!=null){
            byPhone.setMoney(order.getSubtotal());
            this.vipService.updateMoney(byPhone);
        }
        this.service.saveOrder(order);
        map.put("oid",order.getOid());
        return map;
    }
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        SearchParam searchParam = new SearchParam(map);
        PageHelper.startPage(searchParam.getStart(),searchParam.getPageSize());
        searchParam.setStartTime((String) map.get("startTime"));
        searchParam.setEndTime((String) map.get("endTime"));
        List<Order> list = this.service.list(searchParam);
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        int count = this.service.selectCount(searchParam);
        resMap.put("count",count);
        resMap.put("page",pageInfo);
        return resMap;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestBody Map<String,Object> map){
        return this.service.delete((String)map.get("oid"));
    }
    @RequestMapping("/download")
    @ResponseBody
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> map = CommonUtils.getParameterMap(request);
        SearchParam searchParam = new SearchParam(map);
        PageHelper.startPage(searchParam.getStart(),searchParam.getPageSize());
        searchParam.setStartTime((String) map.get("startTime"));
        searchParam.setEndTime((String) map.get("endTime"));
        List<ExcelData> list = this.service.listExcel(searchParam);
        PageInfo<ExcelData> pageInfo = new PageInfo<>(list);
        if (pageInfo.getList()!=null){
            EasyExcel.write(response.getOutputStream(),ExcelData.class).sheet("sheet1").doWrite(pageInfo.getList());
        }
    }
}
