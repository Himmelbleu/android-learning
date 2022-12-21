package servlets;

import beans.Province;
import com.alibaba.fastjson2.JSON;
import service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/province")
public class ProvinceServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setHeader("content-type", "application/json;charset=UTF-8");
    ProvinceService service = new ProvinceService();
    List<Province> provinces = service.getProvince();
    resp.getWriter().write(JSON.toJSONString(provinces));
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }

}
