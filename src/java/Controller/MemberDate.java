/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
@WebServlet(name = "MemberDate", urlPatterns = {"/MemberDate"})
public class MemberDate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //取得會員陣列
            List<String> member = listMember(); //方法
            //將陣列寄放request櫃檯
            request.setAttribute("M_list", member);
            
            //轉發
            RequestDispatcher rd = request.getRequestDispatcher("M_list.jsp");
            rd.forward(request, response);
            
        }
    }

    //宣告回傳一個陣列
    private List<String> listMember(){
        //輸出資料到Tomcat 除錯用
        System.out.println("------"+ new java.util.Date());
        List<String> member = new ArrayList<>(); //建立陣列
        
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
            String query = "select * from member"; // 查詢所有員工
            // 執行 SQL 查詢 ， 獲取結果集(ResultSet)
            rs = stmt.executeQuery(query);
            // 逐筆讀取所查詢結果
            while (rs.next()) { // 取得下一筆資料，若有讀到資料回傳 true
            // 讀取目前這筆資料的各項欄位
            String id = rs.getString("id");
            String email = rs.getString("email");
            String password = rs.getString("pwd");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            java.util.Date birthday = rs.getDate("birthday");
            java.util.Date registered_day = rs.getDate("registered_day");
            String sex = rs.getString("sex");
            String camp = rs.getString("camp");
            String phone = rs.getString("phone");
            String add_1 = rs.getString("add_1");
            String add_2 = rs.getString("add_2");
            String add_3 = rs.getString("add_3");
                // 將員工資料組合成一個字串
                String s = id + " " + email + " " + password + " "+first_name+ " "
                        +last_name+" "+ birthday+" "+sex +" "+camp +""+phone +" "
                        + add_1+add_2+add_3;
                // 輸出目前所讀到的員工資料
                System.out.println(s);
                // 將字串加入陣列
                member.add(s);
                
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
        return member;
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
