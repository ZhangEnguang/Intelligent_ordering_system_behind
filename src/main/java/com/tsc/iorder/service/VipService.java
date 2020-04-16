package com.tsc.iorder.service;

import com.tsc.iorder.dao.VipMapper;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.domain.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VipService {
    @Autowired
    private VipMapper mapper;

    public boolean addVip(Vip vip) {
        int i = this.mapper.addVip(vip);
        return i!=0;
    }

    public Vip findByPhone(String phone) {
        return this.mapper.findByPhone(phone);
    }

    public boolean recharge(Vip v) {
        int i = this.mapper.recharge(v);
        return i!=0;
    }

    public List<Vip> list(SearchParam searchParam) {
        return this.mapper.list(searchParam);
    }

    public void updateState(SearchParam searchParam) {
        this.mapper.updateState(searchParam);
    }

    public boolean delete(Integer id) {
        int i = this.mapper.delete(id);
        return i!=0;
    }

    public void updateMoney(Vip byPhone) {
        this.mapper.updateMoney(byPhone);
    }
}
