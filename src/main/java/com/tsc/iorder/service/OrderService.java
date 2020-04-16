package com.tsc.iorder.service;

import com.tsc.iorder.dao.OrderMapper;
import com.tsc.iorder.dao.OrderitemMapper;
import com.tsc.iorder.domain.Order;
import com.tsc.iorder.domain.Orderitem;
import com.tsc.iorder.domain.SearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper mapper;
    @Autowired
    private OrderitemMapper orderitemMapper;

    public void saveOrder(Order order) {
        this.mapper.saveOrder(order);
        List<Orderitem> orderitems = order.getOrderitems();
        for (Orderitem orderitem : orderitems) {
            this.orderitemMapper.saveItem(orderitem);
        }
    }

    public List<Order> list(SearchParam searchParam) {
        return this.mapper.list(searchParam);
    }

    public int selectCount(SearchParam searchParam) {
        return this.mapper.selectCount(searchParam);
    }

    public boolean delete(String oid) {
        int i = this.mapper.delete(oid);
        int j = this.orderitemMapper.delete(oid);
        return i!=0&&j!=0;
    }
}
