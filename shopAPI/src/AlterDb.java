import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AlterDb",
        urlPatterns = {"/reduce"})
public class AlterDb extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String num=request.getParameter("isreduce");
        String pname=request.getParameter("pname");
        String prono=request.getParameter("prono");
        String uname=request.getParameter("uname");
        int price=Integer.parseInt(request.getParameter("price"));
        Product product=new Product();
        int balance=product.funBalance(uname);
        if(num!=null)
        {
            product.funreduce(prono);
            int c=product.funquerycount(prono);
            System.out.println("数量减一");
            product.funUserAdd(uname,pname,price,balance);
            product.funUserBalance(uname,price);
            System.out.println("当前余额减少:"+price);
        }
    }
}
