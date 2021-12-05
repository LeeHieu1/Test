<%@page import="model.Nhomsanpham"%>
<%@page import="java.util.List"%>
<%@page import="dao.NSP_NCC_DAOImpl"%>
<%@page import="dao.NSP_NCC_DAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="footer-top-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <div class="footer-about-us">
                    <h2><span>Nhóm 9 Shop</span></h2>
                    <p>Nhóm 9 Shop</p>
                    <div class="footer-social">
                        <a href="https://www.facebook.com/lebaothanh.nguyen.73/" target="_blank"><i class="fa fa-facebook"></i></a>
                        <a href="https://www.youtube.com/playlist?list=PLZvkH_Jjc9AJpDuCdNIeXrrA2fuAZgqgw" target="_blank"><i class="fa fa-youtube"></i></a>
                        <a href="https://github.com/Bao-Thanh/LTW" target="_blank"><i class="fa fa-github"></i></a>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-menu">
                    <h2 class="footer-wid-title">Thông tin của bạn </h2>
                    <ul>
                        <li><a href="myaccount.jsp"><i class="fa fa-user"></i>Tài khoản</a></li>
                        <li><a href="baotri.jsp"><i class="fa fa-heart"></i> Yêu thích</a></li>
                        <li><a href="cart.jsp"><i class="fa fa-user"></i> Giỏ hàng</a></li>
                        <li><a href="baotri.jsp"><i class="fa fa-user"></i> Lịch sử</a></li>
                    </ul>                        
                </div>
            </div>

            <%
                NSP_NCC_DAOImpl dao = new NSP_NCC_DAOImpl();
                List<Nhomsanpham> category = dao.getListNSP();
                request.setAttribute("category", category);
            %>
            <div class="col-md-3 col-sm-6">
                <div class="footer-menu">
                    <h2 class="footer-wid-title">Category điện thoại</h2>
                    <ul>
                        <c:forEach items="${category}" var="nsp" >
                            <li><a href="CategoryServlet?tenNSP=${nsp.tenNhomSP}">${nsp.tenNhomSP}</a></li>
                            </c:forEach>
                    </ul>                        
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-newsletter">
                    <h2 class="footer-wid-title">Nhóm 9</h2>
                    <p>Nếu bạn có vấn để có thể liên lạc với chúng tôi qua<a href="https://https://www.facebook.com/lebaothanh.nguyen.73/" target="_blank"> facebook </a> </p>
                    <div class="newsletter-form">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End footer top area -->

<!--<div class="footer-bottom-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="copyright">
                    <p>&copy; 2015 uCommerce. All Rights Reserved. <a href="http://www.freshdesignweb.com" target="_blank">freshDesignweb.com</a></p>
                </div>
            </div>

            <div class="col-md-4">
                <div class="footer-card-icon">
                    <i class="fa fa-cc-discover"></i>
                    <i class="fa fa-cc-mastercard"></i>
                    <i class="fa fa-cc-paypal"></i>
                    <i class="fa fa-cc-visa"></i>
                </div>
            </div>
        </div>
    </div>
</div>  End footer bottom area -->

