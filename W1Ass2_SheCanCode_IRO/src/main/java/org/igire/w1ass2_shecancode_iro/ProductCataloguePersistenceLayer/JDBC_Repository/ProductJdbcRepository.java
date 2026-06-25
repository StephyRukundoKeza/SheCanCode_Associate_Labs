package org.igire.w1ass2_shecancode_iro.ProductCataloguePersistenceLayer.JDBC_Repository;

import java.util.HashMap;
import java.util.Map;

// This replaces your SQL-based repo for testing purposes
public class ProductJdbcRepository {
    private Map<String, Product> database = new HashMap<>();

    // We don't need a connection here anymore!
    public ProductJdbcRepository(Object connection) {} 

    public void save(Product p) {
        database.put(p.getId(), p);
    }

    public Product findById(String id) {
        return database.get(id);
    }

    public void updateQuantity(String id, int newQuantity) {
        Product p = database.get(id);
        if (p != null) p.setQuantity(newQuantity);
    }
}


/*package org.igire.w1ass2_shecancode_iro.ProductCataloguePersistenceLayer.JDBC_Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductJdbcRepository {

    private Connection connection;

    public ProductJdbcRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(Product p) throws SQLException {
        String sql = "INSERT INTO products (id, quantity) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, p.getId());
            stmt.setInt(2, p.getQuantity());
            stmt.executeUpdate();
        }
    }



    public Product findById(String id)throws SQLException {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return new Product(rs.getString("id"), rs.getInt("quantity"));
        }
        return null;
    }

    public Product[] findAll() throws SQLException {
    
    Product[] products = new Product[50]; 
    String sql = "SELECT * FROM products";
    int i = 0;

    try (PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        
        // loop through the database results
        while (rs.next()) {
            // 3. We put each product into the next slot in the array
            products[i] = new Product(rs.getString("id"), rs.getInt("quantity"));
            i++;
        }
    }
    return products;
}
    public void deleteById(String id) throws SQLException {
    String sql = "DELETE FROM products WHERE id = ?";
    
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, id);
        stmt.executeUpdate();
    }
}

public void updateQuantity(String id, int newQuantity) throws SQLException {
        String sql = "UPDATE products SET quantity = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, newQuantity);
            stmt.setString(2, id);
            stmt.executeUpdate();
        }
    }
    

}*/
