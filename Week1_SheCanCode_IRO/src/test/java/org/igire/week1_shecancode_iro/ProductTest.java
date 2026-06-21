package org.igire.week1_shecancode_iro;

import org.igire.week1_shecancode_iro.InventoryManagementSystem.GenericWarehouseStore.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testProductSorting() {
        List<Product> products = new ArrayList<>();
        // 5 Products covering different categories and prices
        products.add(new Product("P1", "Electronics", 100.0));
        products.add(new Product("P2", "Books", 20.0));
        products.add(new Product("P3", "Electronics", 500.0)); // Same cat as P1, higher price
        products.add(new Product("P4", "Books", 50.0));      // Same cat as P2, higher price
        products.add(new Product("P5", "Food", 0.0));        // Edge case: Free item

        products.sort(Product.comp);

        assertEquals("Books", products.get(0).getCategory());
        assertEquals(50.0, products.get(0).getPrice());

        for (Product p : products) {
            System.out.println(p.getCategory() + " - " + p.getPrice());
        }

    }
}
