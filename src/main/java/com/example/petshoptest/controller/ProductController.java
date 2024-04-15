package com.example.petshoptest.controller;

import com.example.petshoptest.mapper.ProductMapper;
import com.example.petshoptest.mapper.UserMapper;
import com.example.petshoptest.model.Product;
import com.example.petshoptest.model.User;
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
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> productList = productMapper.selectAll();
        model.addAttribute("productList", productList);
        return "productList";
    }

    @GetMapping("/selectOne")
    public String selectOne(Product product, Model model) {
        product = productMapper.selectByPrimaryKey(product.getId());
        model.addAttribute("product", product);
        return "productManage";
    }

    @GetMapping("/add")
    public String add(Model model) {
        return "productAdd";
    }

    @PostMapping("/add")
    public String add(Product product, Model model) {
        productMapper.insert(product);
        model.addAttribute("error", "商品新增成功");
        List<Product> productList = productMapper.selectAll();
        model.addAttribute("productList", productList);
        return "productList";
    }

    @PostMapping("/update")
    public String update(Product product,Model model) {
        Date date = new Date();
        product.setUpdateDate(date);
        productMapper.updateByPrimaryKey(product);
        model.addAttribute("error", "商品更新成功");
        List<Product> productList = productMapper.selectAll();
        model.addAttribute("productList", productList);
        return "productList";
    }

    @GetMapping("/delete")
    public String delete(Product product, Model model) {
        productMapper.deleteByPrimaryKey(product.getId());
        model.addAttribute("error", "商品删除成功");
        List<Product> productList = productMapper.selectAll();
        model.addAttribute("productList", productList);
        return "productList";
    }


}
