package org.igire.week1_shecancode_iro.InventoryManagementSystem.GenericWarehouseStore;

import java.util.Comparator;

public class Product {
    private String id;
    private String category;
    private double price;


    public Product(String id, String category, double price) {
        this.id = id;
        this.category = category;
        this.price = price;
    }

    public String getId(){
        return id;
    }

    public String getCategory(){
        return category;
    }

    public double getPrice(){
        return price;
    }

    public static final Comparator<Product> comp = Comparator
            .comparing(Product:: getCategory)
            .thenComparing(Product:: getPrice, Comparator.reverseOrder());



}


