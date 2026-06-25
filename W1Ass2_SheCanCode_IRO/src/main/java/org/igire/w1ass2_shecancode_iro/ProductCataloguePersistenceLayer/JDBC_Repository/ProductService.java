package org.igire.w1ass2_shecancode_iro.ProductCataloguePersistenceLayer.JDBC_Repository;

import java.sql.Connection;
import java.sql.SQLException;

public class ProductService {
    private Connection connection;
    private ProductJdbcRepository repo;

    public ProductService(Connection connection, ProductJdbcRepository repo) {
        this.connection = connection;
        this.repo = repo;
    }

    public void transfer(String fromId, String toId, int quantity) throws SQLException {
        // If connection is null, we are in "Mock/Test" mode, skip database transactions
        boolean useTransaction = (this.connection != null);

        try {
            if (useTransaction) {
                connection.setAutoCommit(false); // Start Transaction
            }

            Product from = repo.findById(fromId);
            Product to = repo.findById(toId);

            repo.updateQuantity(fromId, from.getQuantity() - quantity);
            repo.updateQuantity(toId, to.getQuantity() + quantity);

            if (useTransaction) {
                connection.commit();
            }
        } catch (Exception e) {
            if (useTransaction) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (useTransaction) {
                connection.setAutoCommit(true);
            }
        }
    }
}