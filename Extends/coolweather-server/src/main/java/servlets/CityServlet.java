package servlets;

import beans.City;
import com.alibaba.fastjson2.JSON;
import service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/city")
public class CityServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setHeader("content-type", "application/json;charset=UTF-8");
    String code = req.getParameter("code");
    CityService service = new CityService();
    List<City> cities = service.getCity(code);
    resp.getWriter().write(JSON.toJSONString(cities));
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}