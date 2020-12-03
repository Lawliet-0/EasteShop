import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnection {
    public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static final String DBUSER = "scott";
    public static final String DBPASS = "tiger";
    public static Statement DbCon(){
        try {
            Connection conn = null;
            Statement stmt = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            stmt = conn.createStatement();
            return stmt;
        }
        catch (Exception e){
            Statement stmt=null;
            return stmt;
        }
    }
}
