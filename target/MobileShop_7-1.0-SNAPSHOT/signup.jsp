<!DOCTYPE html>
<html lang = "vi">
    <head>
        <title>Đăng ký</title>
        <!--Made with love by Mutiullah Samim -->

        <!--Bootsrap 4 CDN-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <!--Fontawesome CDN-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

        <!--Custom styles-->
        <link rel="stylesheet"  href="css/signup.css">
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
    </head>
    <body>
        <%
            String err = "";
            if (request.getAttribute("err") != null) {
                err = (String) request.getAttribute("err");
            }
        %>
        <!--/start-login-two-->
        <div class="login-02">
            <div class="two-login  hvr-float-shadow">
                <div class="two-login-head">
                    <img src="img/top-note.png" alt="" />
                    <h2>Đăng ký</h2>
                    <lable></lable>
                </div>
                <form action="SignupServlet" method="post">
                    <li style="color: red"><%=err%></li>
                    Tên người dùng
                    <li><input type="text" class="text" value=""
                               name="tenkh"><a href="#" class=" icon2 user2"></a></li>
                    Tài khoản
                    <li><input type="text" class="text" value=""
                               name="username"><a href="#" class=" icon2 user2"></a></li>

                    Mật khẩu	
                    <li><input type="password" value=""
                               name="password"><a href="#" class=" icon2 lock2"></a></li>
                    Địa chỉ
                    <li><input type="text" value=""
                               name="diachi"><a href="#" class=" icon2 lock2"></a></li>
                    Số điện thoại
                    <li><input type="text" value=""				
                               name="sdt"><a href="#" class=" icon2 lock2"></a></li>
                    Email
                    <li><input type="text" value=""
                               name="email"><a href="#" class=" icon2 lock2"></a></li>

                    <div class="p-container">
                        <label><input type="checkbox" name="checkbox" value="ON" ><i></i>Tôi đồng ý <a href="#">Điều khoản dịch vụ</a></label>
                    </div>
                    <div class="submit two">
                        <input type="submit" value="ĐĂNG KÝ">
                    </div>
                    <h5>
                        <a href="login.jsp">Đăng nhập</a>
                    </h5>
                </form>
            </div>
        </div>
    </body>
</html>
