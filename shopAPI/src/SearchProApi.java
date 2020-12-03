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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "SearchProApi",
        urlPatterns = {"/seaApi"})
public class SearchProApi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String name=request.getParameter("name");
        System.out.println("从微信小程序接受来的值为:"+name);
        Product product=new Product();
        ResultSet resultSet;
        resultSet=product.funqueryByname(name);
        int num;
        num=product.funquerycountByname(name);
        try {
            resultSet.next();
            int price=resultSet.getInt(3);
            String name1=resultSet.getString(2);
            String pno=resultSet.getString(1);
            System.out.println("编号:"+pno);
            System.out.println("单价:"+price);
            System.out.println("名字:"+name1);
            System.out.println("数量:"+num);
            Map<String, Object> result = new ConcurrentHashMap<>();
            result.put("pno",pno );
            result.put("price",price );
            result.put("num",num);
            result.put("name",name1);
            result.put("msg", "后台已收到");
            Gson gson=new GsonBuilder().create();
            Writer out = response.getWriter();
            out.write(gson.toJson(result));
            out.flush();
        }
        catch (Exception e){

        }
    }
}
