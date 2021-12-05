<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Nhóm 9 Shop</title>

        <!-- Google Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/responsive.css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <header>
            <jsp:include page="header.jsp" flush="true"></jsp:include>
            </header>
        <%--
            QuangcaoDAOImpl qcdao = new QuangcaoDAOImpl();
            List<Quangcao> quangcao = qcdao.getList();
            request.setAttribute("quangcao", quangcao);
        --%>
        <div class="slider-area">
            <!-- Slider -->
            <div class="block-slider block-slider4">
                <ul class="" id="bxslider-home4">
                    <c:forEach items="${quangcao}" var="qc" >
                        <li>
                            <a class="caption button-radius" href="ShopServlet"><img src="${qc.anh}" alt=""></a> 
                            <div class="caption-group">
                                <%-- <h2 class="caption title">
                                    <span class="primary"> <strong>${qc.tenQC}</strong></span>
                                </h2>  --%>              
                                <c:set var="promotion" scope="session" value="${(qc.gia - 0.5*qc.gia)}"/>
                                <%--<h4 class="caption subtitle">Giá sốc: ${qc.gia - 10}
                                    <del>${qc.gia}</del>
                                </h4>--%>
                                <!--                                <a class="caption button-radius" href="ShopServlet"><span class="icon"></span>Shop now</a>-->
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <!-- ./Slider -->
        </div> <!-- End slider area -->

        <div class="promo-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <div class="single-promo promo1">
                            <i class="fa fa-refresh"></i>
                            <p>Đổi trả trong 30 ngày</p>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6" data-toggle="modal" data-target="#vanchuyen">
                        <div class="single-promo promo2">
                            <i class="fa fa-truck"></i>
                            <p>Vận chuyển</p>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6" data-toggle="modal" data-target="#thanhtoan">
                        <div class="single-promo promo3">
                            <i class="fa fa-lock"></i>
                            <p>Mua sắm an toàn</p>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="single-promo promo4">
                            <i class="fa fa-gift"></i>
                            <p>Sản phẩm mới</p>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End promo area -->

        <%--
            SanphamDAOImpl dao = new SanphamDAOImpl();
            List<Sanpham> sanpham = dao.getListSPgia();

            request.setAttribute("sanpham", sanpham);
        --%> 

        <div class="maincontent-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="latest-product">
                            <h2 class="section-title">Latest Products</h2>
                            <div class="product-carousel">
                                <c:forEach items="${sanpham}" var="sp" >
                                    <div class="single-product">
                                        <div class="product-f-image">
                                            <img src="${sp.anh}" alt="">
                                            <div class="product-hover">

                                                <a href="cart?command=setCart&maSP=${sp.maSP}&soluong=1" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>
                                                <a href="singleproduct?maSP=${sp.maSP}" class="view-details-link"><i class="fa fa-link"></i> See details</a>
                                            </div>
                                        </div>

                                        <h2><a href="singleproduct?maSP=${sp.maSP}">${sp.tenSP}</a></h2>

                                        <div class="product-carousel-price">
                                            <ins>$${sp.gia}</ins> <del></del>
                                        </div> 
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End main content area -->

        <div class="brands-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="brand-wrapper">
                            <div class="brand-list">
                                <a href="CategoryServlet?tenNSP=Oppo"><img src="img/brand1.jpg" alt=""></a>
                                <a href="CategoryServlet?tenNSP=SamSung"><img src="img/brand3.jpg" alt=""></a>
                                <a href="CategoryServlet?tenNSP=Apple"><img src="img/apple.png" alt=""></a>

                                <!--                                <img src="img/brand1.png" alt="">
                                                                <img src="img/brand2.png" alt="">                            -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End brands area -->

        <div class="product-widget-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="single-product-widget">
                            <h2 class="product-wid-title">Top Sellers</h2>
                            <a href="ShopServlet" class="wid-view-more">View All</a>
                            <c:forEach items="${topsell}" var="top">
                                <div class="single-wid-product">
                                    <a href="singleproduct?maSP=${top.maSP}"><img src="${top.anh}" alt="" class="product-thumb"></a>
                                    <h2><a href="singleproduct?maSP=${top.maSP}">${top.tenSP}</a></h2>
                                    <div class="product-wid-rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product-wid-price">
                                        <ins>$${top.gia}</ins> 
                                    </div>                            
                                </div>
                            </c:forEach>

                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-product-widget">
                            <h2 class="product-wid-title">Recently Viewed</h2>
                            <a href="ShopServlet" class="wid-view-more">View All</a>
                            <c:forEach items="${recentview}" var="rc">
                                <div class="single-wid-product">
                                    <a href="singleproduct?maSP=${rc.maSP}"><img src="${rc.anh}" alt="" class="product-thumb"></a>
                                    <h2><a href="singleproduct?maSP=${rc.maSP}">${rc.tenSP}</a></h2>
                                    <div class="product-wid-rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product-wid-price">
                                        <ins>$${rc.gia}</ins>
                                    </div>                            
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-product-widget">
                            <h2 class="product-wid-title">Top New</h2>
                            <a href="ShopServlet" class="wid-view-more">View All</a>
                            <c:forEach items="${topnew}" var="topnew">
                                <div class="single-wid-product">
                                    <a href="singleproduct?maSP=${topnew.maSP}"><img src="${topnew.anh}" alt="" class="product-thumb"></a>
                                    <h2><a href="singleproduct?maSP=${topnew.maSP}">${topnew.tenSP}</a></h2>
                                    <div class="product-wid-rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product-wid-price">
                                        <ins>$${topnew.gia}</ins> 
                                    </div>                            
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End product widget area -->
        <jsp:include page="footer.jsp" flush="true"></jsp:include>

            <!-- Latest jQuery form server -->
            <script src="https://code.jquery.com/jquery.min.js"></script>

            <!-- Bootstrap JS form CDN -->
            <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

            <!-- jQuery sticky menu -->
            <script src="js/owl.carousel.min.js"></script>
            <script src="js/jquery.sticky.js"></script>

            <!-- jQuery easing -->
            <script src="js/jquery.easing.1.3.min.js"></script>

            <!-- Main Script -->
            <script src="js/main.js"></script>

            <!-- Slider -->
            <script type="text/javascript" src="js/bxslider.min.js"></script>
            <script type="text/javascript" src="js/script.slider.js"></script>
        </body>
    </html>

    <!-- Modal -->
    <div class="modal fade" id="vanchuyen" tabindex="-1" aria-labelledby="vanchuyen" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title" id="vanchuyen">Các loại hình vận chuyển</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Hãng vận chuyển</th>
                                <th scope="col">Giá</th>
                                <th scope="col">Mô tả</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${vanchuyen}" var="vch" >
                            <tr>
                                <td>${vch.tenVC}</td>
                                <td>${vch.gia}</td>
                                <td>${vch.moTa}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="thanhtoan" tabindex="-1" aria-labelledby="thanhtoan" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title" id="thanhtoan">Webiste chấp nhận các hình thức thanh toán</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Loại thanh toán</th>
                            <th scope="col">Mô tả</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${thanhtoan}" var="th" >
                            <tr>
                                <td>${th.tenTT}</td>
                                <td>${th.moTa}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>



