import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeletePage",
        urlPatterns = {"/cw02"})
public class Test extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static final String DBUSER = "scott";
    public static final String DBPASS = "tiger";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            Connection conn = null;
            Statement stmt = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            stmt = conn.createStatement();
            response.setContentType("text/html;charset=utf-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET,POST");
            int id3;
            id3=Integer.parseInt(request.getParameter("name"));
            ResultSet rs=stmt.executeQuery("select *from EMP WHERE EMPNO="+id3+"");
            System.out.println("姓名   =  " + id3);
            while(rs.next()){
                PrintWriter out = response.getWriter();
                System.out.println(rs.getString("ENAME"));
            }
            Writer out = response.getWriter();
            out.write("后台已连接");
            out.flush();
            Product product =new Product();
        }
        catch (Exception e){

        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

