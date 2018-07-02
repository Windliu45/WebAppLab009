/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
        
public class LoginModel {
    String memberIdString;
    String pwdString;
    String resultString;
    boolean result;


    public LoginModel(String memberId, String pwd) {
        this.memberIdString = memberId;
        this.pwdString = pwd;
    }

    public boolean getResult() {
    
                
    String connectionUrl = "jdbc:sqlserver://CR3-11;databaseName=MyDB;user=sa;password=12345";  

      String resultString ="";
      Connection con = null;  
      Statement stmt = null;  
      ResultSet rs = null;  
      
      try {  
         // Establish the connection.  
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
         con = DriverManager.getConnection(connectionUrl);  

         String SQL = "SELECT * FROM member where memberId = '"+memberIdString+"' and pwd = '"+pwdString+"'";  
         stmt = con.createStatement();  
         rs = stmt.executeQuery(SQL);  
        
            if(rs.next()){
        //        JOptionPane.showMessageDialog(null," UserName and Password Matched");
                resultString = "登入成功";
                result = true;

            }
            else{
       //         JOptionPane.showMessageDialog(null,"UserName and Password not Correct");
                resultString = "登入失敗";
                result = false;
            }
            con.close();
        }
//      // Handle any errors that may have occurred.  
      catch (Exception e) {  
         e.printStackTrace();  
      }  
      finally {  
         if (rs != null) try { rs.close(); } catch(Exception e) {}  
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
         if (con != null) try { con.close(); } catch(Exception e) {}  
      }  
         
       
        return result;
    }


 
    
    
    
}
