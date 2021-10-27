package org.example;

import org.example.models.Drinks;
import org.example.models.Fruit;
import org.example.models.Product;
import org.example.models.Snack;
import org.example.service.VendingMachine;
import org.example.service.VendingMachineManager;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Product[] products = {
                new Drinks(1, "Coke", false, 300, 25),
                new Drinks(2, "Fanta", false, 300, 25),
                new Drinks(3, "Calsberg", true, 300, 65),
                new Fruit(1, "Apple", "red", 5),
                new Fruit(2, "Pear", "green", 5),
                new Snack(1, 25, "Snickers", "200"),
                new Snack(2, 1000, "Goldbar", "250")
        };

        VendingMachine vendingMachine = new VendingMachineManager(products);

        for(String string : vendingMachine.getProducts()){
            System.out.println(string);
            System.out.println("------");
        }

        vendingMachine.addCurrency(50);
        vendingMachine.request(1);


    }
}
