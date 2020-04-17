package com.tsc.iorder.controller;

import com.tsc.iorder.domain.FoodType;
import com.tsc.iorder.domain.PieData;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.service.FoodService;
import com.tsc.iorder.service.FoodTypeService;
import com.tsc.iorder.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/EchartsData")
public class EcharsDataController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private FoodTypeService foodTypeService;
    @RequestMapping("/selectDatas")
    @ResponseBody
    public Map<String,Object> selectFood(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        SearchParam searchParam = new SearchParam();
        searchParam.setStartTime((String) map.get("startTime"));
        searchParam.setEndTime((String) map.get("endTime"));
        List<String> foodList = this.foodService.selectFood();
        List<Integer> foodCount = new ArrayList<>();
        List<Double> foodMoney = new ArrayList<>();
        for (String s : foodList) {
            searchParam.setFoodName(s);
            if (this.orderItemService.selectCount(searchParam) == null){
                foodCount.add(0);
            }else {
                foodCount.add(this.orderItemService.selectCount(searchParam));
            }
            if (this.orderItemService.selectMoney(searchParam) == null){
                foodMoney.add(0.0);
            }else {
                foodMoney.add(this.orderItemService.selectMoney(searchParam));
            }
        }
        Integer count = this.orderItemService.selectCountCount(searchParam);
        if (count == null){
            count = 0;
        }else {
            count = this.orderItemService.selectCountCount(searchParam);
        }
        Double money = this.orderItemService.selectMoneyCount(searchParam);
        if (money == null){
            money = 0.0;
        }else {
            money = this.orderItemService.selectMoneyCount(searchParam);
        }
        List<FoodType> foodTypeList = this.foodTypeService.list();
        List<PieData> pieDataList = new ArrayList<>();
        for (FoodType foodType : foodTypeList) {
            PieData pieData = new PieData();
            pieData.setName(foodType.getTypeName());
            searchParam.setTypeName(foodType.getTypeName());
            if (this.orderItemService.selectPieData(searchParam) == null){
                pieData.setValue(0.0);
            }else {
                pieData.setValue(this.orderItemService.selectPieData(searchParam));
            }
            pieDataList.add(pieData);
        }
        resMap.put("PieData",pieDataList);
        resMap.put("count",count);
        resMap.put("money",money);
        resMap.put("FoodList",foodList);
        resMap.put("FoodCounts",foodCount);
        resMap.put("FoodMoney",foodMoney);
        return resMap;
    }
}
