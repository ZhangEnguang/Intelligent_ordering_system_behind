package com.tsc.iorder.dao;

import com.tsc.iorder.domain.Order;
import com.tsc.iorder.domain.SearchParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("orderMapper")
public interface OrderMapper {
    void saveOrder(Order order);

    List<Order> list(SearchParam searchParam);

    int selectCount(SearchParam searchParam);

    int delete(String oid);
}
