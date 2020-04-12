package com.tsc.iorder.dao;

import com.tsc.iorder.domain.Food;
import com.tsc.iorder.domain.SearchParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("foodMapper")
public interface FoodMapper {
    List<Food> list(SearchParam searchParam);

    void lockByTypeId(int id);

    void updateIsDiscount(SearchParam searchParam);

    void updateIsState(SearchParam searchParam);

    void show(SearchParam searchParam);

    void unShow(SearchParam searchParam);

    void updateDiscount(SearchParam searchParam);

    Food findByFoodName(String foodName);

    int addFood(Food food);

    Food findById(int id);

    List<Food> findByImg(String img);

    int update(Food food);

    int delete(SearchParam searchParam);

    List<Food> searchOne(SearchParam searchParam);

    List<Food> searchDiscount(SearchParam searchParam);

    List<Food> searchGraceful(SearchParam searchParam);

    List<Food> searchDrink(SearchParam searchParam);

    List<Food> searchSweet(SearchParam searchParam);
}
