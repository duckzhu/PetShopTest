package com.example.petshoptest.mapper;


import com.example.petshoptest.model.Order;
import com.example.petshoptest.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    int deleteByPrimaryKey(int id);
    int insert(Product product);
    Product selectByPrimaryKey(int id);

//    List<Product> list(Product product);
    List<Product> selectAll();
    Integer updateByPrimaryKey(Product product);
}