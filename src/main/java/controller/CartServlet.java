/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KhuyenmaiDAOImpl;
import dao.SanphamDAOImpl;
import dao.VanchuyenDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Khuyenmai;
import model.Sanpham;
import model.Vanchuyen;

/**
 *
 * @author PhucNguyen
 */
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private List<Cart> items = new ArrayList<Cart>();
    
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
        VanchuyenDAOImpl daovc = new VanchuyenDAOImpl();

        String command = request.getParameter("command");
        String id = request.getParameter("maSP");
        String cp = request.getParameter("coupon");

        if (command.equals("addcart")) {
            Sanpham p = dao.getSanpham(Integer.parseInt(id));
            addToCart(p);
            // sau khi them vao gio hang ta se chuyen toi trang gio hang
            // can tao session de luu tru gia tri
            HttpSession session = request.getSession();

            session.setAttribute("update", items);
            response.sendRedirect("cart.jsp");
        } else {
            if (command.equals("deletecart")) {
                Sanpham p = dao.getSanpham(Integer.parseInt(id));
                deleteFromCart(p);
                HttpSession session = request.getSession();

                // ta test xem gio hang co them duoc ko?
                System.out.println(items.size());
                session.setAttribute("update", items);
                response.sendRedirect("cart.jsp");
            } else {
                if (command.equals("removecart")) {
                    Sanpham p = dao.getSanpham(Integer.parseInt(id));
                    removeFromCart(p);
                    HttpSession session = request.getSession();

                    //lưu vào session
                    session.setAttribute("update", items);
                    response.sendRedirect("cart.jsp");
                } else {
                    if (command.equals("setCart")) {
                        Sanpham p = dao.getSanpham(Integer.parseInt(id));
                        setCart(p, Integer.parseInt((String) request.getParameter("soluong")));
                        HttpSession session = request.getSession();

                        List<Sanpham> list = dao.getSanphamByPrice();
                        Vanchuyen vc = daovc.getVanchuyen(1);

                        session.setAttribute("listspcart", list);                       
                        session.setAttribute("vanchuyen", vc);
                        session.setAttribute("update", items);
                        response.sendRedirect("cart.jsp");
                    }

                }
            }
        }
    }

    public String addToCart(Sanpham p) {
        for (Cart item : items) {
            if (item.getSanpham().getMaSP() == p.getMaSP()) {
                item.setQuantity(item.getQuantity() + 1);

                return "update";
            }
        }
        Cart c = new Cart();
        c.setSanpham(p);
        c.setQuantity(1);
        items.add(c);
        return "update";
    }

    private String removeFromCart(Sanpham p) {
        for (Cart item : items) {
            if (item.getSanpham().getMaSP() == p.getMaSP()) {
                items.remove(item);
                return "update";
            }
        }
        return "update";
    }

    private String setCart(Sanpham p, int s) {
        for (int i = 0; i < items.size(); i++) {
            Cart item = items.get(i);
            if (item.getSanpham().getMaSP() == p.getMaSP()) {
                item.setQuantity(s);
                return "update";
            }
        }
        Cart c = new Cart();
        c.setSanpham(p);
        c.setQuantity(s);
        items.add(c);
        return "update";
    }

    public String deleteFromCart(Sanpham p) {
        for (Cart item : items) {
            if (item.getSanpham().getMaSP() == p.getMaSP() && item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                return "update";
            }
        }
        return "update";
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
