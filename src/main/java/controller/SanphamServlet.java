/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuangcaoDAOImpl;
import dao.SanphamDAOImpl;
import dao.ThanhtoanDAOImpl;
import dao.VanchuyenDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Quangcao;
import model.Sanpham;
import model.Thanhtoan;
import model.Vanchuyen;

/**
 *
 * @author PhucNguyen
 * @contribute BaoThanh
 */
public class SanphamServlet extends HttpServlet {

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
        SanphamDAOImpl dao = new SanphamDAOImpl();
        List<Sanpham> sanpham = dao.getList();

        QuangcaoDAOImpl daoqc = new QuangcaoDAOImpl();
        List<Quangcao> qc = daoqc.getList();

        VanchuyenDAOImpl vchdao = new VanchuyenDAOImpl();
        List<Vanchuyen> vanchuyen = vchdao.getList();

        ThanhtoanDAOImpl thdao = new ThanhtoanDAOImpl();
        List<Thanhtoan> thanhtoan = thdao.getList();

        //top sell
        SanphamDAOImpl daosp = new SanphamDAOImpl();
        List<Sanpham> lstopsell = daosp.getSanphamByPrice15();
        
        //recently view
        List<Sanpham> recentview = daosp.searchByName("Samsung Galaxy Note");
        
        //Top new
        List<Sanpham> topnew = daosp.searchByName("Iphone 11");
        
        request.setAttribute("sanpham", sanpham);
        request.setAttribute("quangcao", qc);
        request.setAttribute("vanchuyen", vanchuyen);
        request.setAttribute("thanhtoan", thanhtoan);
        request.setAttribute("topsell", lstopsell);
        request.setAttribute("recentview", recentview);
        request.setAttribute("topnew", topnew);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
