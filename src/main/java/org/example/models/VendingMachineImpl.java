package org.example.models;

public class VendingMachineImpl implements VendingMachine {


    private final int[] acceptedValues = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
    private final Product[] products;
    private int depositPool;

    public VendingMachineImpl(Product[] products, int depositPool) {
        this.products = products;
        this.depositPool = depositPool;
    }

    public VendingMachineImpl(Product... products) {
        this.products = products;
    }


    @Override
    public void addCurrency(int amount) {
        for (int money : acceptedValues) {
            if (amount == money) depositPool += amount;
        }
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        Product product = null;
        for(Product buy : products){
            if(buy.getId() == id) product = buy;
            if(this.depositPool >= product.getPrice())
                return product;
        }
        return product;
    }


    @Override
    public int endSession() {
        int close = getBalance();
        this.depositPool = 0;
        return close;

    }

    @Override
    public String getDescription(int id) {
        return "Product " + request(id).getProductName();

    }

    @Override
    public String[] getProducts() {
        String[] allProducts = new String[this.products.length];
        String productSummary;
        for (int p = 0; p < this.products.length; p++) {
            productSummary = "Id :" + this.products[p].getId() +
                    "Name :" + this.products[p].getProductName() +
                    "Price :" + this.products[p].getPrice();
            allProducts[p] = productSummary;
        }
        return allProducts;
    }

}
