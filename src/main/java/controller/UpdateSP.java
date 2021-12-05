package controller;

import dao.KhachhangDAOImpl;
import dao.SanphamDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Khachhang;
import model.Sanpham;

/**
 *
 * @author BaoThanh
 */
@WebServlet(name = "UpdateSP", urlPatterns = {"/UpdateSP"})
public class UpdateSP extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private SanphamDAOImpl spDAO = new SanphamDAOImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSP() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String ID = request.getParameter("maSP");
        String tenSP = request.getParameter("tenSP");
        String anh = request.getParameter("anh");
        String gia = request.getParameter("gia");
        String moTa = request.getParameter("moTa");
        String thuongHieu = request.getParameter("thuongHieu");
        
        String err = "";
        String url = "admin/sanpham.jsp";
        
        try {
            spDAO.updateSP(new Sanpham(0,tenSP, anh, Double.parseDouble(gia), moTa, thuongHieu));
            response.sendRedirect("admin/sanpham.jsp");
            RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (IOException | ServletException e) {
            response.sendRedirect("admin/sanpham.jsp");
        }

    }
}
