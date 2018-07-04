
package domain;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vincent
 */
public class M_function {
     String email;
     String pwd;
     String id;
     String first_name;
     String last_name;
     String birthday;
     String registered_day;
     String sex;
     String camp;
     String phone;
     String add_1;
     String add_2;
     String add_3;
     

     //設定建構子，接收從MemberVerify(Controller)傳過來的資料
    public M_function(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
        
    }

    public M_function(String email, String pwd, String id, String first_name, String last_name, String birthday, String sex, String camp, String phone, String add_1, String add_2, String add_3) {
        this.email = email;
        this.pwd = pwd;
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday;
        this.sex = sex;
        this.camp = camp;
        this.phone = phone;
        this.add_1 = add_1;
        this.add_2 = add_2;
        this.add_3 = add_3;
    }     

    
    /**********************建構子^**********************************/
        //會員登入驗證方法
      public boolean M_Login(){
        boolean ML =false;
                 
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Project;";
        String user = "sa";
        String pass = "12345";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 載入驅動程式
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // 建立 連線 物件
            con = DriverManager.getConnection(url, user, pass); // 連線失敗，con 為 null
            // 建立 SQL 陳述句 物件
            stmt = con.createStatement();
            // 撰寫 SQL 查詢 字串
            String query = "select email,pwd from member where email='"+email+"'"; // 查詢所有員工
            // 執行 SQL 查詢 ， 獲取結果集(ResultSet)
            rs = stmt.executeQuery(query);
            // 逐筆讀取所查詢結果
            while (rs.next()) { // 取得下一筆資料，若有讀到資料回傳 true
            // 讀取目前這筆資料的各項欄位
            //String id = rs.getString("id");
            String SQLemail = rs.getString("email");
            String SQLpassword = rs.getString("pwd");
            
            if(SQLemail.equals(email)){
                if(SQLpassword.equals(pwd)){
                    ML = true;
                }
            }
            
            //String first_name = rs.getString("first_name");
            //String last_name = rs.getString("last_name");
            //java.util.Date birthday = rs.getDate("birthday");
            //java.util.Date registered_day = rs.getDate("registered_day");
            //String sex = rs.getString("sex");
            //String camp = rs.getString("camp");
            //String phone = rs.getString("phone");
            //String add_1 = rs.getString("add_1");
            //String add_2 = rs.getString("add_2");
            //String add_3 = rs.getString("add_3");
                // 將員工資料組合成一個字串
                //String s =/* id + " " + */email ;//+ " " + password + " "+first_name+ " "
                 //       +last_name+" "+ birthday+" "+sex +" "+camp +""+phone +" "
                   //     + add_1+add_2+add_3;
                // 輸出目前所讀到的員工資料
                //System.out.println(s);
                // 將字串加入陣列
                //.add(s);
                
            } // while
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e);
        } finally { //無論是否發生例外，finally 最後一定會執行
            // 關閉資源
            // 捕捉關閉資源所發生的例外
            try { if (rs != null) rs.close(); } catch (SQLException ex) { System.err.println(ex); }
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) { System.err.println(ex); }
            try { if (con != null) con.close(); } catch (SQLException ex) { System.err.println(ex); }
         // finally  
        }
        return ML;
    }
      
      
        //會員註冊方法
        public boolean M_Reg() {
        boolean result = false;
        
        
        String url = "jdbc:sqlserver://10.0.2.15;databaseName=Project;";
        String user = "sa";
        String pass = "12345";
        Connection con = null;
        Statement stmt = null;
        //ResultSet rs = null;
        try{
            // 載入驅動程式
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // 建立 連線 物件
            con = DriverManager.getConnection(url, user, pass); // 連線失敗，con 為 null
            // 建立 SQL 陳述句 物件
            stmt = con.createStatement();
            // 撰寫 SQL 查詢 字串
            String qq = "INSERT INTO member values('"+id+"','"+email+"','"+pwd+"','"+first_name+"','"+last_name+"','"+birthday+"','','"+sex+"','"+camp+"','"+phone+"','"+add_1+"','"+add_2+"','"+add_3+"')"; // 查詢所有員工
            // 執行 SQL 查詢 ， 獲取結果集(ResultSet)
            //rs = stmt.executeUpdate(qq);
            System.out.println(qq);
            int row  = stmt.executeUpdate(qq);
            if(row >0){
                System.out.println("Insert 成功");
                result = true;
            }
            
           
            // 逐筆讀取所查詢結果    
//        while (rs.next()) { // 取得下一筆資料，若有讀到資料回傳 true
//        //讀取目前這筆資料的各項欄位
//        String SQLid = rs.getString("id");
//        String SQLemail = rs.getString("email");
//        String SQLpassword = rs.getString("pwd");
//        String SQLfirst_name = rs.getString("first_name");
//        String SQLlast_name = rs.getString("last_name");
//        java.util.Date SQLbirthday = rs.getDate("birthday");
//        String SQLsex = rs.getString("sex");
//        String SQLcamp = rs.getString("camp");
//        String SQLphone = rs.getString("phone");
//        String SQLadd_1 = rs.getString("add_1");
//        String SQLadd_2 = rs.getString("add_2");
//        String SQLadd_3 = rs.getString("add_3");
//        
//        
//            }
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e);
        } finally { //無論是否發生例外，finally 最後一定會執行
            // 關閉資源
            // 捕捉關閉資源所發生的例外
            //try { if (rs != null) rs.close(); } catch (SQLException ex) { System.err.println(ex); }
            try { if (stmt != null) stmt.close(); } catch (SQLException ex) { System.err.println(ex); }
            try { if (con != null) con.close(); } catch (SQLException ex) { System.err.println(ex); }
         // finally  
        }
        return result;
}
        

    

/************************************************************************************/

    
      
      
      
}

 
    
