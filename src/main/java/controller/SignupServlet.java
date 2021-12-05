package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
import dao.KhachhangDAOImpl;

/**
 *
 * @author BaoThanh
 */
@WebServlet(name = "SignupServlet", urlPatterns = {"/SignupServlet"})
public class SignupServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private KhachhangDAOImpl khDAO = new KhachhangDAOImpl();
//	private List<Cart> cart = new ArrayList<Cart>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        

        String tenkh = request.getParameter("tenkh");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String diachi = request.getParameter("diachi");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");

        System.out.println(username);

        String err = "";
        String url = "/signup.jsp";

        if (username.equals("") || password.equals("") || email.equals("") || diachi.equals("") || sdt.equals("")) {
            err += "Phải nhập đầy đủ thông tin!";
        } else {
            if (khDAO.checkKH(username) == true) {
                err += "Tài khoản đã tồn tại!";
            } else {
                Pattern pattenObj = Pattern
                        .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Matcher matcherObj = pattenObj.matcher(email);
                if (!matcherObj.matches()) {
                    err += "Email sai định dạng!";
                }
            }
        }

        if (err.length() > 0) {
            request.setAttribute("err", err);
        }

        try {
            if (err.length() == 0) {
                HttpSession session = request.getSession();
//				session.setAttribute("cart", cart);
                khDAO.addKH(new Khachhang(tenkh,username,password,diachi,sdt,email));
                khDAO.login(username, password);
                Cookie loginCookie = new Cookie("username", username);
                loginCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
                response.addCookie(loginCookie);
                response.sendRedirect("index.jsp");

            } else {
                url = "/signup.jsp";
                RequestDispatcher rd = getServletContext()
                        .getRequestDispatcher(url);
                rd.forward(request, response);
            }

        } catch (IOException | ServletException e) {
            response.sendRedirect("/signup.jsp");
        }

    }

}
