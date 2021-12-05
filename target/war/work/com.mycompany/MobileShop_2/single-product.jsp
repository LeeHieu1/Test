<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Single Product - Nhóm 9 Shop</title>

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

            <div class="product-big-title-area">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="product-bit-title text-center">
                                <h2>Shop</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="single-product-area">
                <div class="zigzag-bottom"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="single-sidebar">
                                <h2 class="sidebar-title">Search Products</h2>
                                <form action="search" method="post">
                                    <input value="${txtS}" name="txt" type="text" placeholder="Search products...">
                                    <input type="submit" value="Search">
                                </form>
                            </div>

                            <div class="single-sidebar">
                                <h2 class="sidebar-title">Products</h2>
                            <c:forEach items="${splist}" var="o">
                                <div class="thubmnail-recent">
                                    <img src="${o.anh}" class="recent-thumb" alt="">
                                    <h2><a href="singleproduct?maSP=${o.maSP}">${o.tenSP}</a></h2>
                                    <div class="product-sidebar-price">
                                        <ins>$${o.gia}</ins> <del></del>
                                    </div>                             
                                </div> 
                            </c:forEach>
                        </div>

                        <div class="single-sidebar">
                            <h2 class="sidebar-title">Recent Posts</h2>
                            <ul>                               
                                <li><a href="">Sony Smart TV - 2015</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-8">
                        <div class="product-content-right">
                            <div class="product-breadcroumb">
                                <a href="">Home</a>
                                <a href="">${singleSP.thuongHieu}</a>
                                <a href="">${singleSP.tenSP}</a>
                            </div>

                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="product-images">
                                        <div class="product-main-img">
                                            <img src="${singleSP.anh}" alt="">
                                        </div>

                                        <div class="product-gallery">
                                            
                                        </div>
                                    </div>
                                </div>

                                <div class="col-sm-6">
                                    <div class="product-inner">
                                        <h2 class="product-name">${singleSP.tenSP}</h2>
                                        <div class="product-inner-price">
                                            <ins>$${singleSP.gia}</ins> <del></del>
                                        </div>    

                                        <form action="" class="cart">
                                            <div class="quantity">
                                                <input type="number" size="4" class="input-text qty text" title="Qty" value="1" name="quantity" min="1" step="1">
                                            </div>
                                            <button class="add_to_cart_button" type="submit">Add to cart</button>
                                        </form>   

                                        <div class="product-inner-category">
                                            <p>Category: <a href="">Summer</a>. Tags: <a href="">awesome</a>, <a href="">best</a>, <a href="">sale</a>, <a href="">shoes</a>. </p>
                                        </div> 

                                        <div role="tabpanel">
                                            <ul class="product-tab" role="tablist">
                                                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Description</a></li>
                                                <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Reviews</a></li>
                                            </ul>
                                            <div class="tab-content">
                                                <div role="tabpanel" class="tab-pane fade in active" id="home">
                                                    <h2>Product Description</h2>  
                                                    <p>Màn hình: ${cauhinh.manHinh}<br>
                                                        Hệ điều hành: ${cauhinh.heDieuHanh} <br>
                                                        Camera sau: ${cauhinh.cameraSau}<br>
                                                        Camera trước: ${cauhinh.cameraTruoc}<br>
                                                        CPU: ${cauhinh.cpu}<br>
                                                        Ram: ${cauhinh.ram}<br>
                                                        Bộ nhớ trong: ${cauhinh.rom}<br>
                                                        Thẻ sim: ${cauhinh.theSim}<br>
                                                        Dung lượng Pin: ${cauhinh.dungLuongPin}<br></p>
                                                </div>
                                                <div role="tabpanel" class="tab-pane fade" id="profile">
                                                    <h2>Reviews</h2>
                                                    <div class="submit-review">
                                                        <p><label for="name">Name</label> <input name="name" type="text"></p>
                                                        <p><label for="email">Email</label> <input name="email" type="email"></p>
                                                        <div class="rating-chooser">
                                                            <p>Your rating</p>

                                                            <div class="rating-wrap-post">
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                            </div>
                                                        </div>
                                                        <p><label for="review">Your review</label> <textarea name="review" id="" cols="30" rows="10"></textarea></p>
                                                        <p><input type="submit" value="Submit"></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>


                            <div class="related-products-wrapper">
                                <h2 class="related-products-title">Related Products</h2>
                                <div class="related-products-carousel">
                                    <c:forEach items="${th}" var="th">
                                        <div class="single-product">
                                            <div class="product-f-image">
                                                <img src="${th.anh}" alt="">
                                                <div class="product-hover">
                                                    <a href="" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>
                                                    <a href="singleproduct?maSP=${th.maSP}" class="view-details-link"><i class="fa fa-link"></i> See details</a>
                                                </div>
                                            </div>

                                            <h2><a href="">${th.tenSP}</a></h2>

                                            <div class="product-carousel-price">
                                                <ins>$${th.gia}</ins> <del></del>
                                            </div> 
                                        </div>
                                    </c:forEach>                               
                                </div>
                            </div>
                        </div>                    
                    </div>
                </div>
            </div>
        </div>


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
    </body>
</html>
