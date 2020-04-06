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
}
