package servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.gson.Gson;

@WebServlet("/mock")
public class Servlet extends HttpServlet {

  private Gson gson = new Gson();

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//    String userJsonString = this.gson.toJson(category);
//    PrintWriter out = response.getWriter();
//    response.setContentType("application/json");
//    response.setCharacterEncoding("UTF-8");
//    out.print(userJsonString);
//    out.flush();
  }
}