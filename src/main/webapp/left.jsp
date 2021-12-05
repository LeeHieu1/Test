<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${splist}" var="o">
    <div class="thubmnail-recent">
    <img src="${o.anh}" class="recent-thumb" alt="">
        <h2><a href="singleproduct?maSP=${o.maSP}">${o.tenSP}</a></h2>
        <div class="product-sidebar-price">
            <ins>$${o.gia}</ins> <del></del>
        </div>                            
    </div>
</c:forEach>