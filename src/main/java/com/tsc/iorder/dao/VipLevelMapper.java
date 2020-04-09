package com.tsc.iorder.dao;

import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.domain.VipLevel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component("vipLevelMapper")
public interface VipLevelMapper {
    List<VipLevel> list(SearchParam searchParam);

    VipLevel findById(Integer id);

    Double findDiscountMax(double discountNum);

    Double findDiscountMin(double discountNum);

    Double findMinMin(double minNum);

    Double findMinMax(double minNum);

    Double findMaxMin(double maxNum);

    Double findMaxMax(double maxNum);
}
