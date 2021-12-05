<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-fixed">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Admin</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-left">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-globe"></i>
                        <b class="caret hidden-sm hidden-xs"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="SanphamADServlet">Quản lý sản phẩm</a></li>
                        <li><a href="NSP_NCCADServlet">Quản lý nhà cung cấp & nhóm sản phẩm</a></li>
                        <li><a href="QuangcaoADServlet">Quản lý quảng cáo</a></li>
                        <li><a href="KhachhangADServlet">Quản lý khách hàng</a></li>
                        <li><a href="VCH_THADServlet">Quản lý vận chuyển & thanh toán</a></li>
                        <li><a href="DH_DG_UTADServlet">Quản lý đơn hàng , đánh giá & ưa thích</a></li>
                    </ul>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-search"></i>
                        <p class="hidden-lg hidden-md">Search</p>
                    </a>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="LogoutadminServlet">
                        <p>Đăng xuất</p>
                    </a>
                </li>
                <li class="separator hidden-lg hidden-md"></li>
            </ul>
        </div>
    </div>
</nav>