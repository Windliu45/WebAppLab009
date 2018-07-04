
package Model;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class LoginModel1 {
 
    String memberIdString;
    String pwdString;
    String resultString;
    boolean result;


    public LoginModel1(String memberId, String pwd) {
        this.memberIdString = memberId;
        this.pwdString = pwd;
    }

    public boolean getResult() {
                
    String connectionUrl = "jdbc:sqlserver://CR3-11;databaseName=MyDB;user=sa;password=12345";  
    String SQL = "SELECT * FROM member where memberId = '"+memberIdString+"' and pwd = '"+pwdString+"'";  
      String resultString ="";
   
      try {  
         // Establish the connection.  
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
         
         try(
            Connection con = DriverManager.getConnection(connectionUrl); 
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery(SQL); ){ 
            
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
      }
//      // Handle any errors that may have occurred.  
      catch (Exception e) {  
         e.printStackTrace();  
      }  
      
       
        return result;
    }
}

