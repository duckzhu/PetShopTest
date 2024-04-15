package com.example.petshoptest.model;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private int id;
    private String name;
    private Integer state;
    private Date addDate;
    private Date updateDate;
    private String picPath;
    private String introduction;
    private String price;

}
