/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class MemberModel {
    String id;
    String email;
    String pwd;
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

    public MemberModel() {
    }

    public MemberModel(String id, String email, String pwd, String first_name, String last_name, String birthday, String registered_day, String sex, String camp, String phone, String add_1, String add_2, String add_3) {
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday;
        this.registered_day = registered_day;
        this.sex = sex;
        this.camp = camp;
        this.phone = phone;
        this.add_1 = add_1;
        this.add_2 = add_2;
        this.add_3 = add_3;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRegistered_day() {
        return registered_day;
    }

    public void setRegistered_day(String registered_day) {
        this.registered_day = registered_day;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdd_1() {
        return add_1;
    }

    public void setAdd_1(String add_1) {
        this.add_1 = add_1;
    }

    public String getAdd_2() {
        return add_2;
    }

    public void setAdd_2(String add_2) {
        this.add_2 = add_2;
    }

    public String getAdd_3() {
        return add_3;
    }

    public void setAdd_3(String add_3) {
        this.add_3 = add_3;
    }
    
    
    public String AddMember() {
         
       String resultString ="Not work";
         String connectionUrl = "jdbc:sqlserver://CR3-11;databaseName=Project;user=sa;password=12345";  

      Connection con = null;  
      Statement stmt = null;  
      ResultSet rs = null;  
      
      try {  
         // Establish the connection.  
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
         con = DriverManager.getConnection(connectionUrl);  

         String SQL = "INSERT INTO member VALUES('"+id+"','"+email+"','"+pwd+"','"+first_name+"','"+last_name+"','"+birthday+"','"+registered_day+"','"+sex+"','"+camp+"','"+phone+"','"+add_1+"','"+add_2+"','"+add_3+"')";

         stmt = con.createStatement();  
         rs = stmt.executeQuery(SQL);  
        

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
         
       
         return resultString;
     }
   
    
}
