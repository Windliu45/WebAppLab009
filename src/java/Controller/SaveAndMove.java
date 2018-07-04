package Controller;

import Model.CarToOrder;
import Model.SavePeopleModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaveAndMove extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            
            
            //取得輸入資料
            String MYGIFT = request.getParameter("MYGIFT");
            String MYGIFTPHONE = request.getParameter("MYGIFTPHONE");
            String MYGIFTADDRESS = request.getParameter("MYGIFTADDRESS");
            String resString = "" ;
            
            //叫媽斗做事-存收件人資料
            SavePeopleModel spm = new SavePeopleModel(MYGIFT ,MYGIFTPHONE ,MYGIFTADDRESS);
            resString = spm.SavePeople();
            
            //叫媽斗做事-購物車的資料放到已成立訂單,然後再刪除購物車資料
            CarToOrder cto = new CarToOrder();
            cto.ChangeTable();
            //顯示訂購成功頁面
            RequestDispatcher rd2 = request.getRequestDispatcher("ThanksForYourBuy.jsp");
            rd2.forward(request, response);
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
