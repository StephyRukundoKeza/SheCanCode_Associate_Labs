package org.igire.w1ass2_shecancode_iro.ECommerceAnalyticsEngine.StreamPipelineforProductAnalytics;

import java.util.List;

public class Order {
    private List<LineItem> lineItems; // This is the internal storage
    private String status;

    // YOUR CONSTRUCTOR IS LIKELY THE MISSING PIECE
    public Order(List<LineItem> lineItems, String status) {
        this.lineItems = lineItems; // This line assigns the data!
        this.status = status;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public String getStatus() {
        return status;
    }
}