package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarToOrder {

    public CarToOrder() {
    }

    public void ChangeTable() {

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
            String query1 = "insert into buy(會員編號,產品編號,產品名稱,產品數量,產品單價) select 會員編號,產品編號,產品名稱,產品數量,產品單價 from car "; //撈出所有購物車內容
            //抓到使用者資料這邊就要加上where指定位子String query1 = "insert into buy(會員編號,產品編號,產品名稱,產品數量,產品單價) select 會員編號,產品編號,產品名稱,產品數量,產品單價 from car where 會員編號 = '####' "; //撈出所有購物車內容
            String query2 = "delete from car ";
            //這邊抓到使用者的名稱會員編號就要改成這裡String query2 = "delete from car "
            
            //con.setAutoCommit(false); 我想要一次執行多個sql用的東西  這是開頭
            con.setAutoCommit(false); //false為到con.commit才一次弄 只要一條語句失敗就全部都不執行 true則相反
            
            //以下兩個是把要執行的用addBatch加入
            stmt.addBatch(query1);  
            stmt.addBatch(query2);
            //執行SQL查詢,獲取結果            
            //rs = stmt.executeQuery(query1);
            
            //???
            stmt.executeBatch();
            //con.commit(); 這是一次執行多個sql的結尾
            con.commit();
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
