package org.example.models;

public class Fruit implements Product {


    private int id;
    private String fruitType;
    private String color;
    private double price;

    public Fruit(int id, String fruitType, String color, double price) {
        this.id = id;
        this.fruitType = fruitType;
        this.color = color;
        this.price = price;
    }

    @Override
    public String examine() {
        return "{id: " +id + ", " + color + " " + fruitType+ " price" +price +"}";
    }

    @Override
    public String use() {
        return fruitType + " will be eaten!";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getProductName() {
        return fruitType;
    }

    @Override
    public void setProductName(String productName) {
        this.fruitType = productName;

    }

    @Override
    public int getPrice() {
        return (int) price;
    }

    @Override
    public void setPrice(int price) {
        this.price = this.price + price;

    }
}
