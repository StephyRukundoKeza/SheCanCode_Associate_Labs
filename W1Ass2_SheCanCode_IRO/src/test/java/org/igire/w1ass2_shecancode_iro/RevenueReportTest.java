package org.igire.w1ass2_shecancode_iro;

import org.igire.w1ass2_shecancode_iro.ECommerceAnalyticsEngine.StreamPipelineforProductAnalytics.LineItem;
import org.igire.w1ass2_shecancode_iro.ECommerceAnalyticsEngine.StreamPipelineforProductAnalytics.Order;
import org.igire.w1ass2_shecancode_iro.ECommerceAnalyticsEngine.StreamPipelineforProductAnalytics.ProductsAnalytics;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RevenueReportTest {
    @Test
    public void runBenchmark() {

        ProductsAnalytics productsAnalytics = new ProductsAnalytics();
        List<Order> largeOrderList = createDummyOrders(100000);

        for (int i = 0; i < 5; i++) {
            productsAnalytics.calculateBulkRevenue(largeOrderList);
        }

        // 1. Measure Sequential
        long startSeq = System.nanoTime();
        productsAnalytics.calculateBulkRevenue(largeOrderList);
        long endSeq = System.nanoTime();
        System.out.println("Sequential Time: " + (endSeq - startSeq) / 1000000.0 + " ms");

        // 2. Benchmark Parallel
        long startPar = System.nanoTime();
        productsAnalytics.calculateBulkRevenueParallel(largeOrderList); // Change stream() to parallelStream()
        long endPar = System.nanoTime();
        System.out.println("Parallel Time: " + (endPar - startPar) / 1000000.0 + " ms");
    }

    private List<Order> createDummyOrders(int count) {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // Create some dummy items for this order
            List<LineItem> items = new ArrayList<>();
            items.add(new LineItem("ProductA", 10.0, 6)); // quantity > 5
            items.add(new LineItem("ProductB", 20.0, 2)); // quantity <= 5

            // Create an order and add it to our list
            Order order = new Order(items, "DELIVERED");
            orders.add(order);
        }
        return orders;
    }
}
