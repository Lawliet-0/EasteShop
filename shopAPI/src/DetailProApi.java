import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "DetailProApi",
        urlPatterns = {"/det"})
public class DetailProApi extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        Product product = new Product();
        String uname=request.getParameter("uname");
        int balance=product.funBalance(uname);
        String id=request.getParameter("name");
        String pno=request.getParameter("pno");
        System.out.println("id:"+id);
        ResultSet resultSet;
        resultSet=product.funquery(id);
        int num;
        num=product.funquerycount(id);
        try {
            resultSet.next();
            int price=resultSet.getInt(3);
            String name=resultSet.getString(2);
            System.out.println("单价:"+price);
            System.out.println("名字:"+name);
            System.out.println("数量:"+num);
            Map<String, Object> result = new ConcurrentHashMap<>();
            result.put("price",price );
            result.put("num",num);
            result.put("name",name);
            result.put("msg", "后台已收到");
            result.put("balance",balance );
            Gson gson=new GsonBuilder().create();
            Writer out = response.getWriter();
            out.write(gson.toJson(result));
            out.flush();
        }
        catch (Exception e){

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
