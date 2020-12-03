import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "DetailUserApi",
        urlPatterns = {"/detUser"})
public class DetailUserApi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String uname=request.getParameter("uname");
        List UserInfo=new ArrayList();
        Product product=new Product();
        UserInfo=product.funqueryUserInfo(uname);
        Map<String, Object> result = new ConcurrentHashMap<>();
        result.put("UserInfo",UserInfo);
        result.put("msg", "后台已收到");
        Gson gson=new GsonBuilder().create();
        Writer out = response.getWriter();
        out.write(gson.toJson(result));
        out.flush();
    }
}
