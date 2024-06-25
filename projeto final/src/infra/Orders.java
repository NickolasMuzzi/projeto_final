package infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import classes.Order;

public class Orders {

    private Connection conn;
    private Database database = new Database();

    public void new_order(Order order) throws SQLException {
        this.conn = (Connection) this.database.connect();
        if (this.conn != null) {
            try {
                String sql = "INSERT INTO orders "
                        + "(card_number, card_holder_name, expiration_date, cvv, installments, total_amount, product_ids, payment_date) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, order.getCardNumber());
                    stmt.setString(2, order.getCardHolderName());
                    stmt.setString(3, order.getExpirationDate());
                    stmt.setString(4, order.getCvv());
                    stmt.setInt(5, order.getInstallments());
                    stmt.setDouble(6, order.getTotalAmount());
                    String productIds = String.join(",",
                            order.getProductIds().stream().map(Object::toString).toArray(String[]::new));
                    stmt.setString(7, productIds);
                    stmt.setTimestamp(8, new java.sql.Timestamp(order.getPaymentDate().getTime()));

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Order placed successfully.");
                    }
                }
            } catch (SQLException e) {
                throw e;
            } finally {
                conn.close();
            }
        }
    }
}
