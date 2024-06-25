package infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import classes.Product;

public class Products {

    private Connection conn;
    Database database = new Database();

    public List<Product> getProducts() throws SQLException {
        this.conn = (Connection) this.database.connect();
        List<Product> productList = new ArrayList<>();

        if (this.conn != null) {
            try {
                String sql = "SELECT * FROM products";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            int id = rs.getInt("id");
                            String name = rs.getString("name");
                            String description = rs.getString("description");
                            double price = rs.getDouble("price");

                            Product product = new Product(id, name, price, description);
                            productList.add(product);
                        }
                        return productList;
                    }
                }
            } catch (SQLException e) {
                throw e;
            } finally {
                conn.close();
            }
        } else {
            return productList;
        }
    }
}
