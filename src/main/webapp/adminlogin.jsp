<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Login Page</title>
        <!--Made with love by Mutiullah Samim -->

        <!--Bootsrap 4 CDN-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


        <!--Fontawesome CDN-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

        <!--Custom styles-->
        <link rel="stylesheet"  href="css/login.css">
        <%@page contentType="text/html" pageEncoding="UTF-8"%>


    </head>
    <body>
        <%
            String err = "";
            if (request.getAttribute("err") != null) {
                err = (String) request.getAttribute("err");
            }
        %>
        <div class="container">
            <div class="d-flex justify-content-center h-100">
                <div class="card">
                    <div class="card-header">
                        <h3>Đăng nhập</h3>
                        <div class="d-flex justify-content-end social_icon">
                            <span><i class="fab fa-facebook-square"></i></span>
                            <span><i class="fab fa-google-plus-square"></i></span>
                            <span><i class="fab fa-twitter-square"></i></span>
                        </div>
                        <div class="d-flex justify-content">
                            <a href="login.jsp">Bạn là user ?</a>
                        </div>
                    </div>       
                    <div class="card-body">  
                        <form action="LoginadminServlet" method="POST">
                            <% String mess = "";
                                if (request.getAttribute("mess") != null) {
                                    mess = (String) request.getAttribute("mess");%>
                            <li style="color: red"><%=mess%></li>	
                                <% }%>
                            <li style="color: red"><%=err%></li>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" name="ad_user" class="form-control" placeholder="Tài khoản">

                            </div>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="password" name="ad_pass" class="form-control" placeholder="Mật khẩu">
                            </div>
                            <!--                            <div class="row align-items-center remember">
                                                            <input type="checkbox">Remember Me
                                                        </div>-->
                            <div class="form-group">
                                <input type="submit" value="Đăng nhập" class="btn float-right login_btn">
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
