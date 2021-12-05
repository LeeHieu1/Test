/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CauhinhDAOImpl;
import dao.SanphamDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cauhinh;
import model.Sanpham;

/**
 *
 * @author PhucNguyen
 */
public class SingleproductServlet extends HttpServlet {

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
        String singleID = request.getParameter("maSP");
        
        CauhinhDAOImpl dao = new CauhinhDAOImpl();
        Cauhinh sp = dao.getCauhinh(Integer.parseInt(singleID));
        
        SanphamDAOImpl daosp = new SanphamDAOImpl();
        Sanpham sanpham = daosp.getSanpham(Integer.parseInt(singleID));
        
        SanphamDAOImpl daolist = new SanphamDAOImpl();
        List<Sanpham> listsp = daolist.getSanphamByPrice();
        
        
        SanphamDAOImpl daoth = new SanphamDAOImpl();
        List<Sanpham> listth = daoth.getThuongHieu(sanpham.getThuongHieu());
        
        SanphamDAOImpl daoprice = new SanphamDAOImpl();
        List<Sanpham> listspprice = daoprice.getSanphamByPrice();
        
        
        request.setAttribute("cauhinh", sp);
        request.setAttribute("singleSP", sanpham);
        request.setAttribute("splist", listsp);
        request.setAttribute("th", listth);
        request.setAttribute("SPprice", listspprice);
        
        
        request.getRequestDispatcher("single-product.jsp").forward(request, response);
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
