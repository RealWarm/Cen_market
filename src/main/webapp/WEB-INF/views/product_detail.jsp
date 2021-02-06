<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>나라중고장터</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="icon" type="image/jpg" href="/resources/img/shopping.png">
    <!-- Bootstrap core CSS -->
	<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<!-- Bootstrap core JavaScript -->
  	<script src="/resources/vendor/jquery/jquery.min.js"></script>
  	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  	<!-- Custom styles for this template -->
  	<link href="/resources/css/shop-item.css" rel="stylesheet">
  	
</head>
<body>

  <jsp:include page="navbar.jsp" flush="false"/>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">
        <h1 class="my-4">카테고리</h1>
        <div class="list-group">
          <a href="#" class="list-group-item active">시설기관 카테고리</a>
          <a href="#" class="list-group-item">제품종류 카테고리</a>
          <a href="#" class="list-group-item">등록시간 카테고리</a>
        </div>
      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">
        

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          
          <div class="carousel-inner" role="listbox">
          		<div class="carousel-item active">
	              <img class="d-block img-fluid" src="/resources/upload_data/${top}" alt="First slide">
	            </div>
          	<c:forEach items="${imglist}" var="list" begin="1" end="3">
	            <div class="carousel-item">
	              <img class="d-block img-fluid" src="/resources/upload_data/${list.view_name}" alt="slide">
	            </div>
            </c:forEach>
            
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>




        <div class="card mt-4">          
          <div class="card-body">
            <h3 class="card-title">${detail.sb_name}</h3>
            <h4>${detail.total_price} 원 </h4>
            <p class="card-text">수량 : ${detail.total_quantity} 개</p>
          </div>
        </div>
        <!-- /.card -->

        <div class="card card-outline-secondary my-4">
          <div class="card-header">
            상품문의 댓글
          </div>
          <div class="card-body">
            <p>생각보다 너무좋아요 가격이 저렵해서 걱정이 많았지만 사길 잘한거같아요 그리고 판매자분도 연락을 잘해주시고 너무 좋았어요. </p>
            <small class="text-muted">Posted by Anonymous on 3/1/17</small>
            <hr>
            <p>구매하길 잘했어요. 또 사고 싶어요</p>
            <small class="text-muted">Posted by Anonymous on 3/1/17</small>
            <hr>
            <p>믿고사길 잘했어요 혹시나 또파신다면 또 사고 싶어요</p>
            <small class="text-muted">Posted by Anonymous on 3/1/17</small>
            <hr>
            <a href="/main" class="btn btn-success">댓글남기기</a>
          </div>
        </div>
        <!-- /.card -->

      </div>
      <!-- /.col-lg-9 -->

    </div>

  </div>
  <!-- /.container -->

  <jsp:include page="footer.jsp" flush="false"/>

 

</body>
</html>