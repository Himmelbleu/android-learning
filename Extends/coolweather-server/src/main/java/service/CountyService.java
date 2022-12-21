package service;

import beans.County;
import utils.MysqlUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountyService {

  private final MysqlUtil mysqlUtil = new MysqlUtil();

  public List<County> getCounty(String cCode) {
    mysqlUtil.connect();
    List<County> counties = new ArrayList<>();
    ResultSet rs = mysqlUtil.query("SELECT * FROM county WHERE cityid = " + cCode);
    try {
      while (rs.next()) {
        County c = new County();
        c.setId(rs.getInt("id"));
        c.setCityid(rs.getInt("cityid"));
        c.setCountyname(rs.getString("countyname"));
        c.setWeatherid(rs.getString("weatherid"));
        counties.add(c);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    mysqlUtil.close();
    return counties;
  }

}
