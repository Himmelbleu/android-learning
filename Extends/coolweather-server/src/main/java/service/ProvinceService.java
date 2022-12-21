package service;

import beans.Province;
import utils.MysqlUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceService {

  private final MysqlUtil mysqlUtil = new MysqlUtil();

  public List<Province> getProvince() {
    mysqlUtil.connect();
    List<Province> provinces = new ArrayList<>();
    ResultSet rs = mysqlUtil.query("SELECT * FROM province");
    try {
      while (rs.next()) {
        Province p = new Province();
        p.setId(rs.getInt("id"));
        p.setProvinceName(rs.getString("provincename"));
        p.setProvinceCode(Integer.parseInt(rs.getString("provincecode")));
        provinces.add(p);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    mysqlUtil.close();
    return provinces;
  }

}
