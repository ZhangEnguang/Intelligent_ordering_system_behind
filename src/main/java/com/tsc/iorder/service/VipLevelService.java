package com.tsc.iorder.service;

import com.tsc.iorder.dao.VipLevelMapper;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.domain.VipLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VipLevelService {
    @Autowired
    private VipLevelMapper mapper;
    public List<VipLevel> list(SearchParam searchParam) {
        return this.mapper.list(searchParam);
    }

    public VipLevel findById(Integer id) {
        return this.mapper.findById(id);
    }

    public Map<String, Double> findDiscount(VipLevel vipLevel) {
        Map<String,Double> resMap = new HashMap<>();
        Double maxOfdiscount = this.mapper.findDiscountMax(vipLevel.getDiscountNum());
        Double minOfdiscount = this.mapper.findDiscountMin(vipLevel.getDiscountNum());
        Double minOfmin = this.mapper.findMinMin(vipLevel.getMinNum());
        Double maxOfmin = this.mapper.findMinMax(vipLevel.getMinNum());
        Double minOfmax = this.mapper.findMaxMin(vipLevel.getMaxNum());
        Double maxOfmax = this.mapper.findMaxMax(vipLevel.getMaxNum());
        resMap.put("maxOfdiscount",maxOfdiscount-0.1);
        resMap.put("minOfdiscount",minOfdiscount+0.1);
        resMap.put("minOfmin",minOfmin);
        resMap.put("maxOfmin",maxOfmin-1);
        resMap.put("minOfmax",minOfmax+1);
        resMap.put("maxOfmax",maxOfmax);
        return resMap;
    }
}
