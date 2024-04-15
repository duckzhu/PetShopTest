package com.example.petshoptest.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "index"; // 对应src/main/resources/templates/index.html
    }


    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "hello";
    }



}
