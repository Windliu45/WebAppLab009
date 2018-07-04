/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.M_function;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Member_Registered", urlPatterns = {"/Member_Registered"})
public class Member_Registered extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //從註冊頁面抓取資料
            String id = request.getParameter("id");
            String email = request.getParameter("email");
            String pwd = request.getParameter("pwd");
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String birthday = request.getParameter("birthday");
            String sex = request.getParameter("sex");
            String phone = request.getParameter("phone");
            String add_1 = request.getParameter("add_1");
            String add_2 = request.getParameter("add_2");
            String add_3 = request.getParameter("add_3");
            
                                   
            RequestDispatcher rd = null;
            HttpSession session = request.getSession();
            

            M_function MR = new M_function(email, pwd, id, first_name, last_name, birthday, sex, sex, phone, add_1, add_2, add_3);
            boolean result = MR.M_Reg();
            
            //servlet
            System.out.println(result);
            
              //判斷id是否存在於DB
              if(result){
                  rd = request.getRequestDispatcher("M_Login.jsp");
              }
              else{
                  rd = request.getRequestDispatcher("M_info.jsp");
              }
            //聯絡人資訊 
//            String r_first_name = request.getParameter("r_first_name");
//            String r_last_name = request.getParameter("r_last_name");
//            String r_sex = request.getParameter("r_sex");
//            String r_phone = request.getParameter("r_phone");
//            String r_add_1 = request.getParameter("r_add_1");
//            String r_add_2 = request.getParameter("r_add_2");
//            String r_add_3 = request.getParameter("r_add_3");
        }
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
