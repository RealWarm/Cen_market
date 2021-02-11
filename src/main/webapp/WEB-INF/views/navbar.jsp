<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Navigation -->
  <script src="https://kit.fontawesome.com/5271ab50ad.js" crossorigin="anonymous"></script>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/main">
      	<i class="fas fa-shopping-cart" style="color:pink; font-size:20px"></i>
      	나라중고장터</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/main">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/sale/saleregist">판매등록</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/sale/category">카테고리</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/member/mypage">마이페이지</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/logout">로그아웃</a>
          </li>                   
      </div>
    </div>
  </nav>