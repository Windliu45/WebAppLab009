package Model;        
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SavePeopleModel {
    String MYGIFT;
    String MYGIFTPHONE ;
    String MYGIFTADDRESS ;
       
    public SavePeopleModel(){}
    
    public SavePeopleModel( String MYGIFT ,String MYGIFTPHONE ,String MYGIFTADDRESS){
        this.MYGIFT = MYGIFT;
        this.MYGIFTPHONE = MYGIFTPHONE ;
        this.MYGIFTADDRESS = MYGIFTADDRESS ;    
    }
    
    //setter

    public void setMYGIFT(String MYGIFT) {
        this.MYGIFT = MYGIFT;
    }

    public void setMYGIFTPHONE(String MYGIFTPHONE) {
        this.MYGIFTPHONE = MYGIFTPHONE;
    }

    public void setMYGIFTADDRESS(String MYGIFTADDRESS) {
        this.MYGIFTADDRESS = MYGIFTADDRESS;
    }
    
    

//getter

    public String getMYGIFT() {
        return MYGIFT;
    }

    public String getMYGIFTPHONE() {
        return MYGIFTPHONE;
    }

    public String getMYGIFTADDRESS() {
        return MYGIFTADDRESS;
    }
    
    
    
    
    
    
    
    
    public String SavePeople(){
    
    String resulString = "";
    String url = "jdbc:sqlserver://172.16.168.210:1433;databaseName=member1;";
        String user = "sa" ;
        String pass = "12345" ;
        Connection con = null ;
        Statement stmt = null ;
        ResultSet rs = null ;
        
        try{
            //載入驅動程式
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //建立連線物件
            con = DriverManager.getConnection(url,user,pass);
            //建立SQL陳述句物件
            stmt = con.createStatement();
            //要叫SQL做的事
            String query = "insert into MyGift(MYGIFT,MYGIFTPHONE,MYGIFTADDRESS) values(  N'"+MYGIFT+"','"+MYGIFTPHONE+"','"+MYGIFTADDRESS+"')" ; //撈出所有購物車內容
            //執行SQL查詢,獲取結果
            rs = stmt.executeQuery(query);  
            }
        
        catch(SQLException | ClassNotFoundException e){
            System.err.println(e);
        }
        finally{
           try{if(rs != null)rs.close();}catch(SQLException ex){System.err.println(ex);}
           try{if(stmt != null)stmt.close();}catch(SQLException ex){System.err.println(ex);} 
           try{if(con != null)con.close();}catch(SQLException ex){System.err.println(ex);} 
        }
        return resulString;
    }
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

