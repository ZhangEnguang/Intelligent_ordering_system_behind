package com.tsc.iorder.service;

import com.tsc.iorder.dao.OrderitemMapper;
import com.tsc.iorder.domain.PieData;
import com.tsc.iorder.domain.SearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderitemMapper mapper;

    public Integer selectCount(SearchParam searchParam) {
        return this.mapper.selectCount(searchParam);
    }
    public Double selectMoney(SearchParam searchParam){
        return this.mapper.selectMoney(searchParam);
    }

    public Integer selectCountCount(SearchParam searchParam) {
        return this.mapper.selectCountCount(searchParam);
    }

    public Double selectMoneyCount(SearchParam searchParam) {
        return this.mapper.selectMoneyCount(searchParam);
    }

    public Double selectPieData(SearchParam searchParam) {
        return this.mapper.selectPieData(searchParam);
    }
}
