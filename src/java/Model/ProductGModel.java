package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductGModel {
    
    int 卡片組編號;
    String 系列代號;
    String 縮圖;
    String 卡片組簡述;
    int 價格;
    String SQL = "Select 卡片組編號, 系列代號, 縮圖, 卡片組簡述, 價格 from cardgroup";
    
   
    int sequenceType;

    public ProductGModel() {
    }

    public void setSequenceType(int sequenceType) {
        this.sequenceType = sequenceType;
    }

    public List<String[]> ProductModelNumber() {

        List<String[]> list = new ArrayList<>();

        String connectionUrl = "jdbc:sqlserver://CR3-11;databaseName=Project;user=sa;password=12345";

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establish the connection.  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            switch (sequenceType) {
                case 1:
                    SQL = "Select 卡片編號, 系列代號, 稀有度, 縮圖, 卡片描述 from card order by 稀有度";
                    break;
                case 2:
                    SQL = "Select 卡片編號, 系列代號, 稀有度, 縮圖, 卡片描述 from card order by 系列代號";
                    break;
                default:
                    SQL = "Select 卡片組編號, 系列代號, 縮圖, 卡片組簡述, 價格 from cardgroup";
            }

            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String[] stringArray = new String[5];
                stringArray[0] = Integer.toString(rs.getInt("卡片組編號"));
                stringArray[1] = rs.getString("系列代號");
                stringArray[3] = rs.getString("縮圖");
                stringArray[4] = rs.getString("卡片組簡述");
                stringArray[2] = rs.getString("價格");
                list.add(stringArray);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }

        return list;
    }

}
