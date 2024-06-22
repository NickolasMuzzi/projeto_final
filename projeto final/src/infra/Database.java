package infra;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

  public Object connect() throws SQLException {
    try {
      return DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/projeto_final",
        "root",
        "04112002"
      );
    } catch (SQLException e) {
      System.out.println("Erro de banco de dados");
      throw e;
    }
  }
}
