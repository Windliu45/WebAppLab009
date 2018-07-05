package customer;

import java.io.IOException;
import java.io.PrintWriter;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet(name = "JdbcServer", urlPatterns = {"/JdbcServer"})
public class JdbcServer extends HttpServlet {

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

            String message = request.getParameter("Message");

            //RequestDispatcher rd = null;
            //HttpSession session = request.getSession();

            String url = "jdbc:sqlserver://localhost:1433;databaseName=Project1;";
            String user = "sa";
            String pass = "12345";
            String query = "insert into q_info values(?,'','',?,?,?)";//使用問號代表參數 之後設定
            //try-with-resources 自動關閉資源
            try {
                // 載入驅動程式
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                //try-with-resources 自動關閉資源 try()括號裡的資源自動關閉
                try (Connection con = DriverManager.getConnection(url, user, pass);
                        PreparedStatement pstmt = con.prepareStatement(query);) {
                    //設定各項 ? 參數值
                    pstmt.setString(1,"P123456111");//設定第1個 ?參數
              //      pstmt.setString(2,"" );
              //      pstmt.setString(3,"" );
              
                    pstmt.setString(2,"5" );
                    pstmt.setString(3, message);
                    pstmt.setString(4, "");
                    //資料庫所使用的日期是 java,.sql.Date 所以必須先將java.util.Date 變成java.sql.
                    //執行 新增 修改 刪除 須使用 executeUpdate()方法
                    //  executeUpdate()回傳 int  整數  表示資料庫更新了幾筆資料          
                    int count = pstmt.executeUpdate();
                    if (count == 0) {
                        System.out.println("新增失敗");
                    }else{
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);

                    }
                }

            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);

            }

            
        }
    }
//
//    //private void listMessage() {
//    private int listproject1() {
//        System.out.println("-------------------------" + new java.util.Date());
//        int count;
//        String url = "jdbc:sqlserver://localhost:1433;datebaseName=Prject1;";
//        String user = "sa";
//        String pass = "12345";
//        String query = "insert into listproject1 values(?,?,?,?)";
//        Connection con = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLserverDriver");
//            con = DriverManager.getConnection(url, user, pass);
//            stmt = con.createStatement();
//            rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                double q_id = rs.getInt("q_id");
//                double q_type = rs.getInt("q_type");
//                double q_content = rs.getInt("q_content");
//                double q_answer = rs.getInt("q_answer");
//                String s = q_id + " " + q_type + " " + q_content + " " + q_answer;
//                System.out.println(s);
//                //Object nextElement = rs.nextElement();
//                // list.add(s);
//            }
//
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println("customer.JdbcServer.listproject1(ex)");
//            }
//            try {
//                if (stmt != null) {
//                    rs.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println("customer.JdbcServer.listproject1(ex)");
//            }
//            try {
//                if (con != null) {
//                    rs.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println("customer.JdbcServer.listproject1(ex)");
//            }
//        }

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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>
    }
