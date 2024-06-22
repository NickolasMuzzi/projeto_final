package infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

  private Connection conn;
  Database database = new Database();

  public boolean login(User user) throws SQLException {
    this.conn = (Connection) this.database.connect();
    if (this.conn != null) {
      try {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setString(1, user.getUsername());
          stmt.setString(2, user.getPassword());

          try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
              System.out.println("Login successful.");
              return true;
            } else {
              System.out.println("Invalid username or password.");
              return false;
            }
          }
        }
      } catch (SQLException e) {
        throw e;
      } finally {
        conn.close();
      }
    } else {
      return false;
    }
  }
}
