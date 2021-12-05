package controller;

import dao.DanhgiaDAOImpl;
import dao.DonhangDAOImpl;
import dao.NSP_NCC_DAOImpl;
import dao.UathichDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Donhang;
import model.Khachhang;
import model.Uathich;

/**
 *
 * @author BaoThanh
 */
public class DH_DG_UTADServlet extends HttpServlet {

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

        DonhangDAOImpl dhdao = new DonhangDAOImpl();
        List<Donhang> dh = dhdao.getList();

        UathichDAOImpl utdao = new UathichDAOImpl();
        List<Uathich> ut = utdao.getList();

//        DanhgiaDAOImpl dgdao = new DanhgiaDAOImpl();
//        List<Khachhang> dg = dgdao.getList();

        request.setAttribute("listdh", dh);
        request.setAttribute("listut", ut);
//        request.setAttribute("listdg", dh);

        request.getRequestDispatcher("admin/dh_dgandut.jsp").forward(request, response);
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
