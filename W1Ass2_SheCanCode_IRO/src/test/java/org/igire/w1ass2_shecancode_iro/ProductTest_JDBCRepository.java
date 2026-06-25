package org.igire.w1ass2_shecancode_iro;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.igire.w1ass2_shecancode_iro.ProductCataloguePersistenceLayer.JDBC_Repository.Product;
import org.igire.w1ass2_shecancode_iro.ProductCataloguePersistenceLayer.JDBC_Repository.ProductJdbcRepository;
import org.igire.w1ass2_shecancode_iro.ProductCataloguePersistenceLayer.JDBC_Repository.ProductService;
import java.util.concurrent.*;

public class ProductTest_JDBCRepository {

    @Test 
    public void runConcurrencyTest() throws Exception {
        // 1. Setup: Use null for connection since we are mocking the database
        ProductJdbcRepository repo = new ProductJdbcRepository(null);
        ProductService service = new ProductService(null, repo);
        
        // Populate initial data
        repo.save(new Product("P1", 50));
        repo.save(new Product("P2", 50));
        
        int initialTotal = repo.findById("P1").getQuantity() + repo.findById("P2").getQuantity();

        // 2. Act: Run 10 concurrent transfers
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                try {
                    service.transfer("P1", "P2", 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        
        // 3. Assert: Final total should match initial total
        int finalStockP1 = repo.findById("P1").getQuantity();
        int finalStockP2 = repo.findById("P2").getQuantity();
        int finalTotal = finalStockP1 + finalStockP2;

        Assertions.assertEquals(initialTotal, finalTotal, "Stock mismatch! Data was lost.");
        System.out.println("Test complete: Final stock is " + finalTotal);
    }
}