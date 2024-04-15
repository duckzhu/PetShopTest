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
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/login")
    public String loginGet(Model model) {
        log.info("登录页面");
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(User user, Model model) {
        User user1 = userMapper.selectByNameAndPwd(user);
        if (user1 != null) {
            httpSession.setAttribute("user", user1);
            if(user1.getLevel() == 1){
                return "manager";
            }else{
                List<Product> productList = productMapper.selectAll();
                model.addAttribute("productList", productList);
                return "product";
            }
//            User name = (User) httpSession.getAttribute("user");

        } else {
            model.addAttribute("error", "用户名或密码错误，请重新登录！");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerGet(Model model) {
        log.info("注册页面");
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(User user, Model model) {
        System.out.println("用户名" + user.getUserName());
        try {
            userMapper.selectIsName(user);
            model.addAttribute("error", "该账号已存在！");
        } catch (Exception e) {
            Date date = new Date();
            user.setAddDate(date);
            user.setUpdateDate(date);
            userMapper.insert(user);
            System.out.println("注册成功");
            model.addAttribute("error", "恭喜您，注册成功！");
            return "login";
        }

        return "register";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<User> userList = userMapper.selectAll();
        model.addAttribute("userList", userList);
        return "userList";
    }

    @GetMapping("/delete")
    public String delete(User user, Model model) {
        userMapper.deleteByPrimaryKey(user.getId());
        model.addAttribute("error", "删除成功");
        List<User> userList = userMapper.selectAll();
        model.addAttribute("userList", userList);
        return "userList";
    }

    @GetMapping("/selectOne")
    public String selectOne(User user, Model model) {
        user = userMapper.selectById(user.getId());
        model.addAttribute("user", user);
        return "userManage";
    }

//    @GetMapping("/manage")
//    public String userManageGet(Model model) {
//        User user = (User) httpSession.getAttribute("user");
//        User user1 = userMapper.selectByNameAndPwd(user);
//        model.addAttribute("user", user1);
//        return "userManage";
//    }

    @PostMapping("/update")
    public String update(Model model, User user, HttpSession httpSession) {
//        User user1 = (User) httpSession.getAttribute("user");
        Date date = new Date();
        user.setUpdateDate(date);
        int i = userMapper.update(user);
        List<User> userList = userMapper.selectAll();
        model.addAttribute("userList", userList);
        model.addAttribute("error", "修改成功");
        return "userList";
    }


}
