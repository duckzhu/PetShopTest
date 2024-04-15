package com.example.petshoptest.mapper;


import com.example.petshoptest.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

//    int deleteByPrimaryKey(String orderId);
    int insert(Order order);
    Order selectByPrimaryKey(int id);

//    List<Order> list(Order order);
    List<Order> selectAll();

    Integer updateByPrimaryKey(Order order);
}