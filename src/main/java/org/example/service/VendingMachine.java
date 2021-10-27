package org.example.service;

import org.example.models.Product;

public interface VendingMachine {        //this is how erik did

    void addCurrency(int amount);
    int getBalance();
    Product request(int id);
    int endSession();
    String getDescription(int id);
    String[] getProducts();

}
