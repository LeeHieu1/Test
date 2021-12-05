package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuantriDAOImpl;
import dao.SanphamDAOImpl;
import java.util.List;
import model.Sanpham;

/**
 *
 * @author BaoThanh
 */
@WebServlet(name = "LoginadminServlet", urlPatterns = {"/LoginadminServlet"})
public class LoginadminServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private QuantriDAOImpl qtrDAO = new QuantriDAOImpl();

    public LoginadminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("ad_user");
        String password = request.getParameter("ad_pass");

        String err = "";

        if (username.equals("") || password.equals("")) {
            err += "Phải nhập đầy đủ thông tin!";
        } else {
            if (qtrDAO.login(username, password) == null) {
                err += "Tên đăng nhập hoặc mật khẩu không chính xác!";
            }
        }

        if (err.length() > 0) {
            request.setAttribute("err", err);
        }

        String url = "/adminlogin.jsp";

        try {
            if (err.length() == 0) {
                HttpSession session = request.getSession();
                session.setAttribute("ad_user", username);
                qtrDAO.login(username, password);
                Cookie loginCookie = new Cookie("ad_user", username);
                loginCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
                response.addCookie(loginCookie);
                response.sendRedirect("SanphamADServlet");
                url = "/SanphamADServlet";

            } else {
                url = "/adminlogin.jsp";
                RequestDispatcher rd = getServletContext()
                        .getRequestDispatcher(url);
                rd.forward(request, response);
            }

        } catch (IOException | ServletException e) {
            response.sendRedirect("/adminlogin.jsp");
        }
    }

}
