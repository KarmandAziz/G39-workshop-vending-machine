package org.example.models;

public class Snack implements Product{
    private int id;
    private double price;
    private String snackName;
    private String calories;

    public Snack(int id, double price, String snackName, String calories) {
        this.id = id;
        this.price = price;
        this.snackName = snackName;
        this.calories = calories;
    }

    @Override
    public String examine() {
        return "{ Id: " +id + ", " + snackName + "with " + calories + "calories" + ", Price: " + price + "}";
    }

    @Override
    public String use() {
        return "You eat some snack";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getProductName() {
        return snackName;
    }

    @Override
    public void setProductName(String productName) {
        this.snackName = productName;

    }

    @Override
    public int getPrice() {
        return (int) price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;

    }
}
