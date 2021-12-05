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

import dao.KhachhangDAOImpl;

/**
 *
 * @author BaoThanh
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private KhachhangDAOImpl khDAO = new KhachhangDAOImpl();


    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String err = "";

        if (username.equals("") || password.equals("")) {
            err += "Phải nhập đầy đủ thông tin!";
        } else {
            if (khDAO.login(username, password) == null) {
                err += "Tên đăng nhập hoặc mật khẩu không chính xác!";
            }
        }

        if (err.length() > 0) {
            request.setAttribute("err", err);
        }

        String url = "/login.jsp";

        try {
            if (err.length() == 0) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                khDAO.login(username, password);
                Cookie loginCookie = new Cookie("username", username);
                loginCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
                response.addCookie(loginCookie);
                response.sendRedirect("SanphamServlet");
                url = "/SanphamServlet";

            } else {
                url = "/login.jsp";
                RequestDispatcher rd = getServletContext()
                        .getRequestDispatcher(url);
                rd.forward(request, response);
            }

        } catch (IOException | ServletException e) {
            response.sendRedirect("/login.jsp");
        }
    }

}
