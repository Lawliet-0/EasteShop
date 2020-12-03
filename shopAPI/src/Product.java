import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {
    private String id;
    private String name;
    private int price;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public static ResultSet funqueryByname(String name){
        try {
            Statement stmt = null;
            stmt = DbConnection.DbCon();
            ResultSet rs = stmt.executeQuery("select *from Product WHERE pname='"+name+"'");
            return rs;
        } catch (Exception e) {
            ResultSet rs = null;
            return rs;
        }
    }
    public static ResultSet funquery(String id) {
        try {
            Statement stmt = null;
            stmt = DbConnection.DbCon();
            ResultSet rs = stmt.executeQuery("select *from Product WHERE pno=" + id + "");
            return rs;
        } catch (Exception e) {
            ResultSet rs = null;
            return rs;
        }
    }
    public static void funreduce(String prono){
        try {
            Statement stmt = null;
            stmt = DbConnection.DbCon();
            ResultSet rs = stmt.executeQuery("UPDATE Product SET pnum=pnum-1 WHERE pno=" + prono + "");
        } catch (Exception e) {
            ResultSet rs = null;
        }
    }
    public static void funUserAdd(String uname,String upname,int price,int balance){
        try {
            Statement stmt = null;
            stmt = DbConnection.DbCon();
            System.out.println("当前用户姓名为:"+uname);
            System.out.println("当前商品名为:"+upname+"单价为:"+price);

            ResultSet rs = stmt.executeQuery("SELECT * FROM UserInfo  WHERE uname='"+uname+"'AND upname='"+upname+"'");
            if(rs.next()){
                System.out.println("已经有该用户的购买记录");
                stmt.executeQuery("UPDATE UserInfo SET unum=unum+1 WHERE upname='"+ upname +"'AND uname='"+uname+"'");
            }
            else {
                System.out.println("还没有该用户的购买记录");
                stmt.executeQuery("insert into UserInfo values('"+ upname +"','"+uname+"',"+price +",1,"+balance+")");
            }
        } catch (Exception e) {
            System.out.println("有异常");
        }
    }
    public static int funquerycount(String prono) {
        try {
            int c=1;
            Statement stmt = null;
            stmt = DbConnection.DbCon();
            ResultSet rs = stmt.executeQuery("SELECT PNUM FROM Product WHERE pno=" + prono + "");
            if(rs.next()){
                System.out.println("当前商品数量为:"+rs.getInt(1));
            }
            c=rs.getInt(1);
            return c;
        } catch (java.sql.SQLException  e) {
            ResultSet rs = null;
            System.out.println("java.sql.SQLException");
            System.out.println(e);
            return 2;
        }
    }
    public static int funquerycountByname(String name) {
        try {
            int c=1;
            Statement stmt = null;
            stmt = DbConnection.DbCon();
            ResultSet rs = stmt.executeQuery("SELECT PNUM FROM Product WHERE pname='"+name+"'");
            if(rs.next()){
                System.out.println("当前商品数量为:"+rs.getInt(1));
            }
            c=rs.getInt(1);
            return c;
        } catch (java.sql.SQLException  e) {
            ResultSet rs = null;
            System.out.println("java.sql.SQLException");
            System.out.println(e);
            return 2;
        }
    }
    public static List funqueryUserInfo(String uname){
        try {
            List UserInfo=new ArrayList();
            Statement stmt = null;
            stmt = DbConnection.DbCon();
            ResultSet rs=stmt.executeQuery("SELECT * FROM UserInfo  WHERE uname='"+uname+"'");
            int num=rs.getMetaData().getColumnCount();
            while (rs.next()){
                Map mapOfColValues=new HashMap(num);
                for (int i=1;i<=num;i++)
                {
                    mapOfColValues.put(rs.getMetaData().getColumnName(i),rs.getObject(i));
                }
                UserInfo.add(mapOfColValues);
                System.out.println(mapOfColValues);
            }
            System.out.println("集合为:"+UserInfo);
            return UserInfo;
        }
        catch (Exception e){
            List list=null;
            System.out.println("查询有错误");
            System.out.println(e);
            return list;
        }
    }
    public static void funUserBalance(String uname,int price) {
        try {
            Statement stmt = null;
            stmt = DbConnection.DbCon();
            stmt.executeQuery("UPDATE UserInfo SET balance=balance-"+price+" WHERE  uname='"+uname+"'");
        } catch (Exception e) {

        }
    }
    public static int funBalance(String uname){
        int b=0;
        try {
            Statement stmt = null;
            stmt = DbConnection.DbCon();
            ResultSet rs=stmt.executeQuery("SELECT balance FROM UserInfo WHERE  uname='"+uname+"'");
            if (rs.next()){
                b=rs.getInt(1);
            }
            return b;
        } catch (Exception e) {
            return b;
        }

    }

}

