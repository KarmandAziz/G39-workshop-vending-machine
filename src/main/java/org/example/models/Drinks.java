package org.example.models;

public class Drinks implements Product{

    private final int id;
    private String drinkName;
    private final boolean alcoholic;
    private final int calories;
    private double price;


    public Drinks(int id, String drinkName, boolean alcoholic, int calories, double price) {
        this.id = id;
        this.drinkName = drinkName;
        this.alcoholic = alcoholic;
        this.calories = calories;
        this.price = price;
    }

    @Override
    public String examine() {
        return "{id: " +id + ", " + drinkName + " Alcoholic : " + alcoholic + " price: " +price +"}";
    }

    @Override
    public String use() {
        String description = "You drink some " + drinkName + " with " + calories + " calories!";
        description += getAlcoholic() ? " and feel a bit tipsy" :  " ";
        return description;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getProductName() {
        return drinkName;
    }

    @Override
    public void setProductName(String productName) {
        this.drinkName = productName;

    }

    @Override
    public int getPrice() {
        return (int) price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;

    }

    public boolean getAlcoholic() {
        return alcoholic;
    }
}
