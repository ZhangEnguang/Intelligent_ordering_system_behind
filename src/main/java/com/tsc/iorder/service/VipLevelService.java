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

    public boolean update(VipLevel vipLevel) {
        int i = this.mapper.update(vipLevel);
        return i!=0;
    }

    public Map<String, Double> checkAdd() {
        Map<String,Double> resMap = new HashMap<>();
        Double maxOfdiscount = this.mapper.checkDiscountMax();
        VipLevel vipLevel = this.mapper.checkDiscountMin();
        Double minOfmin = this.mapper.checkMinMin();
        VipLevel vipLevel1 = this.mapper.checkMinMax();
        VipLevel vipLevel2 = this.mapper.checkMaxMax();
        resMap.put("maxOfdiscount",maxOfdiscount-0.1);
        if (vipLevel!=null){
            resMap.put("isFull",vipLevel.getDiscountNum());
        }else {
            resMap.put("isFull",0.0);
        }
        if (vipLevel1!=null){
            resMap.put("isAFull",vipLevel1.getMinNum());
        }else {
            resMap.put("isAFull",0.0);
        }
        if (vipLevel2!=null){
            resMap.put("isSFull",vipLevel2.getMaxNum());
        }else {
            resMap.put("isSFull",0.0);
        }
        resMap.put("minOfdiscount",0.1);
        resMap.put("minOfmin",minOfmin);
        resMap.put("maxOfmin",99999999.9);
        resMap.put("minOfmax",minOfmin+1);
        resMap.put("maxOfmax",99999999.9);
        return resMap;
    }

    public boolean addVipLevel(VipLevel vipLevel) {
        int i = this.mapper.addVipLevel(vipLevel);
        return i!=0;
    }

    public boolean delete(int id) {
        int i = this.mapper.delete(id);
        return i!=0;
    }

    public VipLevel findByName(String levelName) {
        return this.mapper.findByName(levelName);
    }
}
