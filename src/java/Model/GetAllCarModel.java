package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetAllCarModel {

    public GetAllCarModel(){}  
    
    
    public List<String[]> listcar() {
        //測試用
        System.out.println("----------------------------------------------------------" + new java.util.Date());
        List<String[]> list = new ArrayList<>();

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
            String query = "select * from car"; //撈出所有購物車內容
            //執行SQL查詢,獲取結果
            rs = stmt.executeQuery(query);

            //逐筆讀取所查詢結果
            while (rs.next()) {
                String[] stringArray = new String[6];
                stringArray[0] = rs.getString("會員編號");
                stringArray[1] = rs.getString("產品編號");
                stringArray[2] = rs.getString("產品名稱");
                stringArray[3] = Integer.toString(rs.getInt("產品單價"));
                stringArray[4] = Integer.toString(rs.getInt("產品數量"));
                stringArray[5] = Integer.toString(rs.getInt("產品總價"));

                list.add(stringArray);
            }
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
        return list;
    }

}
