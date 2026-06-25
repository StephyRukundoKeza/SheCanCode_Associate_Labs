package org.igire.w1ass2_shecancode_iro.ECommerceAnalyticsEngine.StreamPipelineforProductAnalytics;

public class LineItem {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String productCategory;

    public LineItem(String productA, double v, int i) {
    }


    // Getters
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public String getProductName() {
        return productName;
    }
    public String getCategory() {
        return productCategory;
    }

    public String getProductId() {
        return productId;
    }
}
