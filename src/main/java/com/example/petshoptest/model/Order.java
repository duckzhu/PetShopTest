package com.example.petshoptest.model;

import lombok.Data;

import java.util.Date;
@Data
public class Order{
    private int id;
    private String payment;
    private int status;
    private int productId;
    private int productNum;
    private String statusStr;
    private Date addDate;
    private Date updateDate;
    private Date paymentTime;
    private Date consignTime;
    private String shippingName;
    private String shippingCode;
    private int userId;
    private String buyerMessage;
    private String buyerName;
    private String price;
    private String productName;
}