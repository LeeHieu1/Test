package controller;

import dao.KhachhangDAOImpl;
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

/**
 *
 * @author BaoThanh
 */
@WebServlet(name = "KhachhangServlet", urlPatterns = {"/KhachhangServlet"})
public class KhachhangServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private KhachhangDAOImpl khDAO = new KhachhangDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String maKH = request.getParameter("maKH");
        String tenKH = request.getParameter("tenKH");
        String tenTK = request.getParameter("tenTK");
        String matKhau = request.getParameter("matKhau");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");

        String err = "";
        String url = "/myaccount.jsp";

        if (matKhau.equals("") || email.equals("") || sdt.equals("") || diaChi.equals("")) {
            err += "Phải nhập đầy đủ thông tin!";
        } else {

            Pattern pattenObj = Pattern
                    .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher matcherObj = pattenObj.matcher(email);
            if (!matcherObj.matches()) {
                err += "Email sai định dạng!";
            } else {
                Pattern pattenObj2 = Pattern
                        .compile("(09)\\d{8}|(01)\\d{9}");
                Matcher matcherObj2 = pattenObj2.matcher(sdt);
                if (!matcherObj2.matches()) {
                    err += "Sđt sai định dạng!";
                }
            }
        }

        if (err.length() > 0) {
            request.setAttribute("err", err);
        }

        try {
            if (err.length() == 0) {
                Khachhang u = new Khachhang( tenKH, tenTK, matKhau, diaChi, sdt, email);
                khDAO.updateKH(u);
                url = "/SanphamServlet";
            } else {
                url = "/index.jsp";
            }
            RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (IOException | ServletException e) {
            response.sendRedirect("/SanphamServlet");
        }
    }

}
