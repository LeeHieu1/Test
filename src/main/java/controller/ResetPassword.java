package controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Khachhang;
import dao.KhachhangDAO;
import dao.KhachhangDAOImpl;


/**
 *
 * @author BaoThanh
 */
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachhangDAOImpl khDAO = new KhachhangDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		String err = "";
		if (username.equals("")) {
			err += "Phải nhập đầy đủ thông tin!";
		} else {
			if (khDAO.checkKH(username) == false) {
				err += "Tên đăng nhập không tồn tại!";
			}
		}

		if (err.length() > 0) {
			request.setAttribute("err", err);
		}
		
		String url = "/resetpassword.jsp";
		try {
			if (err.length() == 0) {

				Khachhang u = khDAO.getKH(username);
				Khachhang new_kh = new Khachhang(u.getTenKH(), username, "passwordreset", u.getDiaChi(),u.getSdt(), u.getEmail());
				khDAO.updateKH(new_kh);
				url = "/login.jsp";
				String mess = "Kiểm tra email để nhận mật khẩu mới!";
				request.setAttribute("mess", mess);
				
				//gửi mật khẩu mới qua email.
				   final String username_mail = "temp@gmail.com";
				   final String password = "matkhau";
				   String to = u.getEmail();
				   String subject = "Reset Password";
				   String text ="<i>Reset Password</i><br/>";
						   text+="<p>User: <strong>"; text+=username; text+="</strong></p>";
						   text+="<p>New password: <strong>passwordreset</strong></p>";
				   Properties props = new Properties();
				   props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");
				   Session session_mail = Session.getInstance(props,
				   new javax.mail.Authenticator() {
                                      @Override
				      protected PasswordAuthentication getPasswordAuthentication() {
				        return new PasswordAuthentication(username_mail, password);
				      }
				   });
				   try {
				     Message message = new MimeMessage(session_mail);
				     message.setHeader("Content-Type", "text/plain; charset=UTF-8");
				     message.setFrom(new InternetAddress(username_mail));
				     message.setRecipients(Message.RecipientType.TO,
				     InternetAddress.parse(to));
				     message.setSubject(subject);
				     message.setContent(text, "text/html; charset=utf-8");
				     Transport.send(message);
				   } catch (MessagingException e) {
				     throw new RuntimeException(e);
				   }
				
			} else {
				url = "/resetpassword.jsp";
				
			}
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (IOException | RuntimeException | ServletException e) {
			response.sendRedirect("/resetpassword.jsp");
		}
	}

}
