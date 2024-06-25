package infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import classes.User;

public class Register {

  private Connection conn;
  Database database = new Database();

  public void register(User user) throws SQLException {
    this.conn = (Connection) this.database.connect();
    if (this.conn != null) {
      try {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setString(1, user.getUsername());
          stmt.setString(2, user.getPassword());

          int rowsAffected = stmt.executeUpdate();
          if (rowsAffected > 0) {
            System.out.println("User registered successfully.");
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
