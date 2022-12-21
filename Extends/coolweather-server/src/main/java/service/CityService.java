package service;

import beans.City;
import utils.MysqlUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityService {

  private final MysqlUtil mysqlUtil = new MysqlUtil();

  public List<City> getCity(String citycode) {
    mysqlUtil.connect();
    List<City> cities = new ArrayList<>();
    ResultSet rs = mysqlUtil.query("SELECT * FROM city WHERE citycode = " + citycode);
    try {
      while (rs.next()) {
        City c = new City();
        c.setId(rs.getInt("id"));
        c.setCityname(rs.getString("cityname"));
        c.setCitycode(rs.getInt("citycode"));
        c.setProvinceid(Integer.parseInt(rs.getString("provinceid")));
        cities.add(c);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    mysqlUtil.close();
    return cities;
  }

}
