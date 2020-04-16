package com.tsc.iorder.dao;

import com.tsc.iorder.domain.Orderitem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("oreritemMapper")
public interface OrderitemMapper {
    void saveItem(Orderitem orderitem);

    int delete(String oid);
}
