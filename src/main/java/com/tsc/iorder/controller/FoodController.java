package com.tsc.iorder.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsc.iorder.domain.Food;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.service.FoodService;
import com.tsc.iorder.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Food")
public class FoodController {
    @Autowired
    private FoodService service;
    public static String urlFood = "F:/ideaFile/Intelligent_ordering_system/IntelligentOrderingSystem/static/images/food";
    public static String dbFood = "/static/images/food/";
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
    @RequestMapping("/isExit")
    @ResponseBody
    public Map<String,Object> isExit(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        Food food = this.service.findByFoodName((String)map.get("foodName"));
        resMap.put("food",food);
        return resMap;
    }
    @RequestMapping("/upload")
    @ResponseBody
    public boolean upload(@RequestParam("file") MultipartFile file,Food food) throws IOException {
        Food foodByName = this.service.findByFoodName(food.getFoodName());
        if (foodByName!=null){
            return false;
        }
        String fileName = FileUtil.saveFile(file, urlFood);
        food.setImg(dbFood+fileName);
        return this.service.addFood(food);
    }
    @RequestMapping("/checkUpdate")
    @ResponseBody
    public boolean checkUpdate(@RequestBody Map<String,Object> map){
        Food foodByName = this.service.findByFoodName((String) map.get("foodName"));
        Food foodById = this.service.findById((Integer) map.get("id"));
        if (foodById.getFoodName().equals(map.get("foodName"))){
            return true;
        }else {
            if (foodByName!=null){
                return false;
            }else {
                return true;
            }
        }
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@RequestParam("updateFile") MultipartFile file,Food food) throws IOException {
        Food foodByName = this.service.findByFoodName(food.getFoodName());
        Food foodById = this.service.findById(food.getId());
        if (!foodById.getFoodName().equals(food.getFoodName())){
            if (foodByName!=null){
                return false;
            }
        }
        String[] img = foodById.getImg().split("/");
        File dir = new File(urlFood);
        String fileName = img[img.length-1];
        if (!foodById.getImg().equals(dbFood+file.getOriginalFilename())){
            fileName = FileUtil.saveFile(file, urlFood);
        }
        food.setImg(dbFood+fileName);
        boolean b = this.service.update(food);
        List<Food> list = this.service.findByImg(foodById.getImg());
        if (list==null||list.size()==0){
            FileUtil.deleteFile(dir,img[img.length-1]);
        }
        return b;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId((Integer) map.get("id"));
        Food foodById = this.service.findById((Integer) map.get("id"));
        String[] img = foodById.getImg().split("/");
        File dir = new File(urlFood);
        List<Food> list = this.service.findByImg(foodById.getImg());
        if (list!=null&&list.size()==1){
            FileUtil.deleteFile(dir,img[img.length-1]);
        }
        return this.service.delete(searchParam);
    }
}
