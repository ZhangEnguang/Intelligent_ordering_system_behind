package com.tsc.iorder.service;

import com.tsc.iorder.dao.FoodMapper;
import com.tsc.iorder.domain.Food;
import com.tsc.iorder.domain.SearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodMapper mapper;

    public List<Food> list(SearchParam searchParam) {
        return this.mapper.list(searchParam);
    }

    public void lockByTypeId(int id) {
        this.mapper.lockByTypeId(id);
    }

    public void updateIsDiscount(SearchParam searchParam) {
        this.mapper.updateIsDiscount(searchParam);
    }

    public void updateIsState(SearchParam searchParam) {
        this.mapper.updateIsState(searchParam);
    }

    public void show(SearchParam searchParam) {
        this.mapper.show(searchParam);
    }

    public void unShow(SearchParam searchParam) {
        this.mapper.unShow(searchParam);
    }

    public void updateDiscount(SearchParam searchParam) {
        this.mapper.updateDiscount(searchParam);
    }

    public Food findByFoodName(String foodName) {
        return this.mapper.findByFoodName(foodName);
    }

    public boolean addFood(Food food) {
        int i = this.mapper.addFood(food);
        return i!=0;
    }

    public Food findById(int id) {
        return this.mapper.findById(id);
    }

    public List<Food> findByImg(String img) {
        return this.mapper.findByImg(img);
    }

    public boolean update(Food food) {
        int i = this.mapper.update(food);
        return i!=0;
    }

    public boolean delete(SearchParam searchParam) {
        int i = this.mapper.delete(searchParam);
        return i!=0;
    }

    public List<Food> searchOne(SearchParam searchParam) {
        return this.mapper.searchOne(searchParam);
    }

    public List<Food> searchDiscount(SearchParam searchParam) {
        return this.mapper.searchDiscount(searchParam);
    }

    public List<Food> searchGraceful(SearchParam searchParam) {
        return this.mapper.searchGraceful(searchParam);
    }

    public List<Food> searchDrink(SearchParam searchParam) {
        return this.mapper.searchDrink(searchParam);
    }

    public List<Food> searchSweet(SearchParam searchParam) {
        return this.mapper.searchSweet(searchParam);
    }
}
