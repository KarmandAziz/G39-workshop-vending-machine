package org.example.service;

import org.example.models.Product;

public class VendingMachineManager implements VendingMachine{   //this is how erik did it

    public static final int[] validDenominations = {1,2,5,10,50,100,200,500,1000};
    private final Product[] products;
    public int depositPool;


    public VendingMachineManager(Product[] products) {
        this.products = products;
    }

    @Override
    public void addCurrency(int amount) {
        for(int validDenominations : validDenominations){
            if(validDenominations == amount){
                depositPool +=amount;
            }
        }

    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                if (product.getPrice() <= depositPool) {
                    depositPool = (depositPool - product.getPrice());
                    return product;
                } else {
                    throw new RuntimeException("Product " + product.getProductName() + " is too expensive.");
                }
            }
        }
        throw new RuntimeException("Could not find Product with id " + id);
    }

    @Override
    public int endSession() {
        int temp = depositPool;
        depositPool = 0;
        return temp;
    }

    @Override
    public String getDescription(int id) {
        String notFound = "Could not find product with id " + id;
        for(Product product : products){
            if(product.getId() == id){
                return product.examine().concat("Price: ")+ product.getPrice();
            }
        }

        return notFound;
    }

    @Override
    public String[] getProducts() {
        String[] productsAsString = new String[products.length];
        for(int i=0; i<products.length; i++){
            productsAsString[i] = products[i].examine();
        }
        return  productsAsString;
    }
}
