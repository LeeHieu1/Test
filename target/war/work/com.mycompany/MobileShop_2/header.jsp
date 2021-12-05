<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="header-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="user-menu">
                    <ul>
                        <%
                            String username = null;
                            Cookie[] cookies = request.getCookies();
                            if (cookies != null) {
                                for (Cookie cookie : cookies) {
                                    if (cookie.getName().equals("username")) {
                                        username = cookie.getValue();
                                    }
                                }
                            }

                            if (username != null) {
                        %>
                        <li> Welcome <%=username%></li>
                            <%
                                }
                            %>
                        <li><a href="myaccount.jsp"><i class="fa fa-user"></i>Tài khoản</a></li>
                        <li><a href="favorite.jsp"><i class="fa fa-heart"></i> Yêu thích</a></li>
                        <li><a href="cart.jsp"><i class="fa fa-user"></i> Giỏ hàng</a></li>
                        <li><a href="history.jsp"><i class="fa fa-user"></i> Lịch sử</a></li>
                        <li><a href="LogoutServlet">Đăng xuất</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-md-4">
                <div class="header-right">
                    <ul class="list-unstyled list-inline">
                        <li class="dropdown dropdown-small">
                            <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="value">USD </span><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">USD</a></li>
                                <li><a href="#">VND</a></li>
                                <li><a href="#">INR</a></li>
                                <li><a href="#">GBP</a></li>
                            </ul>
                        </li>

                        <li class="dropdown dropdown-small">
                            <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="value">Tiếng Việt </span><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1520933144/flags/uk.jpg" alt="TiengViet"><span>Tiếng Việt</span></a></li>
                                <li><a href="/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1520933144/flags/uk.jpg" alt="English"><span>English</span></a></li>
                                <li><a href="/sk/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076897/flags/10242sk.jpg" alt="Slovenský"><span>Slovenský</span></a></li>
                                <li><a href="/lv/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1597837596/flags/lav_60x40 png.jpg" alt="Latvių"><span>Latvių</span></a></li>
                                <li><a href="/pt/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076983/flags/12852pt.jpg" alt="Português"><span>Português</span></a></li>
                                <li><a href="/cz/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076973/flags/5287cz.jpg" alt="Čeština"><span>Čeština</span></a></li>
                                <li><a href="/dk/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076965/flags/2468dk.jpg" alt="Dansk"><span>Dansk</span></a></li>
                                <li><a href="/nl/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076947/flags/10602nl.jpg" alt="Nederlands"><span>Nederlands</span></a></li>
                                <li><a href="/bg/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076931/flags/15668bg.jpg" alt="български"><span>български</span></a></li>
                                <li><a href="/gr/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076764/flags/8770gr.jpg" alt="ελληνικά"><span>ελληνικά</span></a></li>
                                <li><a href="/ro/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1545921339/flags/14698ro.jpg" alt="Română"><span>Română</span></a></li>
                                <li><a href="/hr/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076725/flags/4666hr.jpg" alt="Hrvatski"><span>Hrvatski</span></a></li>
                                <li><a href="/si/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076882/flags/15298si.jpg" alt="Slovenščina"><span>Slovenščina</span></a></li>
                                <li><a href="/pl/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076836/flags/4328pl.jpg" alt="Polski"><span>Polski</span></a></li>
                                <li><a href="/es/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076816/flags/1987es.jpg" alt="Español"><span>Español</span></a></li>
                                <li><a href="/fr/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076802/flags/10263fr.jpg" alt="Français"><span>Français</span></a></li>
                                <li><a href="/de/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076783/flags/14248de.jpg" alt="Deutsch"><span>Deutsch</span></a></li>
                                <li><a href="/it/"><img src="data:image/png;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=" class="lazyload" data-src="https://images.mobileshop.eu/1558076709/flags/14344it.jpg" alt="Italiano"><span>Italiano</span></a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End header area -->

<div class="site-branding-area">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="logo">
                    <h1><a href="./"><img src="img/logo.png"></a></h1>
                </div>
            </div>

            <div class="col-sm-6">
                <div class="shopping-item">
                    <a href="cart.jsp">Cart - <span class="cart-amunt">$100</span> <i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End site branding area -->

<div class="mainmenu-area">
    <div class="container">
        <div class="row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div> 
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="SanphamServlet">Home</a></li>
                    <li><a href="ShopServlet">Shop page</a></li>
                    <li><a href="single-product.jsp">Single product</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                    <li><a href="checkout.jsp">Checkout</a></li>
                    <li><a href="#">Category</a></li>
                    <li><a href="#">Others</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </div>  
        </div>
    </div>
</div> <!-- End mainmenu area -->
