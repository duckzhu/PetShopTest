package com.example.petshoptest.controller;

import com.example.petshoptest.mapper.OrderMapper;
import com.example.petshoptest.mapper.ProductMapper;
import com.example.petshoptest.mapper.UserMapper;
import com.example.petshoptest.model.Order;
import com.example.petshoptest.model.Product;
import com.example.petshoptest.model.User;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/list")
    public String list(Model model) {
        List<Order> orderList = orderMapper.selectAll();
        model.addAttribute("orderList", orderList);
        return "orderList";
    }

    @GetMapping("/add")
    public String add(Order order,Model model) {
        Product product = productMapper.selectByPrimaryKey(order.getProductId());
        model.addAttribute("product", product);
        return "orderAdd";
    }

    @PostMapping("/add")
    public String add(Order order, Model model,HttpSession httpSession) {
        User user = (User)httpSession.getAttribute("user");
        if(user == null){
            throw new RuntimeException("非法购买，用户没有登录");
        }
        order.setStatus(2);
        order.setStatusStr("已付款");
        order.setBuyerName(user.getUserName());
        order.setUserId(user.getId());
        if(StringUtils.isNotBlank(order.getPrice()) && order.getProductNum() != 0){
            Integer price = Integer.valueOf(order.getPrice());
            order.setPayment(String.valueOf(price* order.getProductNum()));
        }
        orderMapper.insert(order);
        model.addAttribute("error", "订单新增成功");
        List<Product> productList = productMapper.selectAll();
        model.addAttribute("productList", productList);
        return "product";
    }

    @GetMapping("/selectOne")
    public String selectOne(Order order, Model model) {
        order = orderMapper.selectByPrimaryKey(order.getId());
        model.addAttribute("order", order);
        return "orderManage";
    }


    @PostMapping("/update")
    public String update(Order order,Model model) {
        Date date = new Date();
        order.setUpdateDate(date);
        orderMapper.updateByPrimaryKey(order);
        model.addAttribute("error", "订单更新成功");
        List<Order> orderList = orderMapper.selectAll();
        model.addAttribute("orderList", orderList);
        return "orderList";
    }

}
