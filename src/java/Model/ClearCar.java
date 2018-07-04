package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClearCar {

    public ClearCar() {
    }

    public void ClearCarMethod() {
        System.out.println("----------------------------------------------------------" + new java.util.Date());
        List<String> list = new ArrayList<>();

        String url = "jdbc:sqlserver://172.16.168.210:1433;databaseName=member1;";
        String user = "sa";
        String pass = "12345";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //載入驅動程式
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //建立連線物件
            con = DriverManager.getConnection(url, user, pass);
            //建立SQL陳述句物件
            stmt = con.createStatement();
            //要叫SQL做的事
            String query2 = "delete from car ";
            //##############這邊抓到使用者的名稱會員編號就要改成這裡String query2 = "delete from car where "

            //執行SQL查詢,獲取結果            
            rs = stmt.executeQuery(query2);

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

        }

    }

}
