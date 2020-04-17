package com.tsc.iorder.dao;

import com.tsc.iorder.domain.Orderitem;
import com.tsc.iorder.domain.PieData;
import com.tsc.iorder.domain.SearchParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("oreritemMapper")
public interface OrderitemMapper {
    void saveItem(Orderitem orderitem);

    int delete(String oid);

    Integer selectCount(SearchParam searchParam);

    Double selectMoney(SearchParam searchParam);

    Integer selectCountCount(SearchParam searchParam);

    Double selectMoneyCount(SearchParam searchParam);

    Double selectPieData(SearchParam searchParam);
}
