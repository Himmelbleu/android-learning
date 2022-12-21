package utils;

import java.sql.*;

public class MysqlUtil {

  private Connection connection = null;
  private Statement statement = null;
  private ResultSet resultSet = null;
  private int effects = 0;

  public void connect() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coolweather?useSSL=false&allowPublicKeyRetrieval=true", "root", "enziandom");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

  }

  public ResultSet query(String sql) {
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return resultSet;
  }

  public int update(String sql) {
    try {
      statement = connection.createStatement();
      effects = statement.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return effects;
  }

  public void close() {
    try {
      if (resultSet != null) resultSet.close();
      if (statement != null) statement.close();
      if (connection != null) connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
