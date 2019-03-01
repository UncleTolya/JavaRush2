package com.javarush.task.task18.task1828;

import java.math.BigInteger;

public class Item {
    public static int itemCounter;

    private BigInteger id;
    private String productName;
    private double price;
    private int quantity;


    public Item(String productName, double price, int quantity) {
//        this.id = ++itemCounter;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(BigInteger id, String productName, double price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static void setItemCounter(int itemCounter) {
        Item.itemCounter = itemCounter;
    }
}
