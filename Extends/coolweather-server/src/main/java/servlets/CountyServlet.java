package servlets;

import beans.County;
import com.alibaba.fastjson2.JSON;
import service.CountyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/county")
public class CountyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setHeader("content-type", "application/json;charset=UTF-8");
    String cCode = req.getParameter("cCode");
    CountyService service = new CountyService();
    List<County> counties = service.getCounty(cCode);
    resp.getWriter().write(JSON.toJSONString(counties));
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
