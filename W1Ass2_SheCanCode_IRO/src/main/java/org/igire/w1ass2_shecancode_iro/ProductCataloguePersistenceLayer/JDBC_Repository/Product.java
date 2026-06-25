package org.igire.w1ass2_shecancode_iro.ProductCataloguePersistenceLayer.JDBC_Repository;

import jakarta.persistence.*;

@Entity
public class Product {

    private String id;
    private int quantity;

   
    public Product(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
