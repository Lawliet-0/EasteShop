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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "SearchPro",
        urlPatterns = {"/search"})
public class SearchPro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String name=request.getParameter("name");
        System.out.println("搜索的数据为:"+name);
        Statement stmt = null;
        stmt = DbConnection.DbCon();
        ResultSet resultSet=null;
        try {
            ResultSet rs = stmt.executeQuery("SELECT PNAME FROM Product WHERE PNAME= '"+name+"'");
            resultSet=rs;
            if(rs.next()==false){    //查不到数据 sql执行false
                System.out.println("查询失败");
            }
            else {
                int success=1;
                System.out.println("查询成功");
                Map<String, Object> result = new ConcurrentHashMap<>();
                result.put("name",name);
                Gson gson=new GsonBuilder().create();
                Writer out = response.getWriter();
                out.write(gson.toJson(result));
                out.flush();
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }




    }
}
