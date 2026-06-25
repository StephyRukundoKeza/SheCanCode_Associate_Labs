package org.igire.w1ass2_shecancode_iro.ECommerceAnalyticsEngine.StreamPipelineforProductAnalytics;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductsAnalytics {

    // Calculates revenue for items with quantity > 5
    public double calculateBulkRevenue(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.getLineItems().stream())
                .filter(item -> item.getQuantity() > 5)
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .reduce(0.0, Double::sum);
    }

    // Parallel version of Bulk Revenue for high-intensity computation
    public double calculateBulkRevenueParallel(List<Order> orders) {
        return orders.parallelStream()
                .flatMap(order -> order.getLineItems().stream())
                .filter(item -> item.getQuantity() > 5)
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .reduce(0.0, Double::sum);
    }

    public List<String> topNProductsByRevenue(List<Order> orders, int n) {
        return orders.parallelStream()
                .flatMap(order -> order.getLineItems().stream())
                .collect(Collectors.groupingBy(
                        LineItem::getProductName,
                        Collectors.summingDouble(item -> item.getPrice() * item.getQuantity())
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, Long> countItemsPerCategory(List<LineItem> items) {
        return items.stream()
                .collect(Collectors.groupingBy(LineItem::getCategory, Collectors.counting()));
    }

    public Map<Boolean, List<Order>> partitionOrdersByStatus(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.partitioningBy(order -> "DELIVERED".equals(order.getStatus())));
    }

    public Map<String, Double> getAveragePriceByProduct(List<LineItem> items) {
        return items.stream()
                .collect(Collectors.toMap(
                        LineItem::getProductId,
                        LineItem::getPrice,
                        (existingPrice, newPrice) -> (existingPrice + newPrice) / 2
                ));
    }
}