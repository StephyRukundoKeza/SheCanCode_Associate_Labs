package org.igire.week1_shecancode_iro.RealTimeOrderMatchingEngine.ThreadSafeOrderBook;

public record Order(String id, String name, double price, int quantity, boolean isBuy) {
    /*
    public record Order(String id, String name, double price, int quantity, boolean isBuy) {
    public Order {
        // Validation logic
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID cannot be empty");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty");
        if (price <= 0) throw new IllegalArgumentException("Price must be positive");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
    }

     */
}
