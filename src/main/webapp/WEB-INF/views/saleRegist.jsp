<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" 	prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" 	prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>나라중고장터</title>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/resources/css/saleRegist.css">
</head>
<body>
	<jsp:include page="header.jsp" flush="false"/>
	<div class="info__container">

        <!-- Top Title -->
        <section class="top__title">
            <div class="tag__name__top">
                <h2 id="main__name">기본정보</h2><span class="tag__star__main"> *필수항목</span>
            </div>
        </section>

        <hr class="main__hr">

        <!-- Product Image -->
        <form class="sale__regist__form" method="POST" action="/sale/saleregist" enctype="multipart/form-data">        
            <section class="image__upload">
                <div class="tag__name">
                    상품이미지<span class="tag__star">*</span>
                </div>

                <div class="upload__box">
                    <!-- <form  action="/file/upload" method="post"  enctype="multipart/form-data">
                <input type="file" name="file"/>            
            </form> -->

                    <input type="file" name="uploadFiles" multiple="multiple">

                    <div class="how">
                        <b>* 상품 이미지는 640x640에 최적화 되어 있습니다.</b>
                        <p>
                            - 이미지는 상품등록 시 정사각형으로 짤려서 등록됩니다. <br>
                            - 이미지를 클릭 할 경우 원본이미지를 확인할 수 있습니다. <br>
                            - 이미지를 클릭 후 이동하여 등록순서를 변경할 수 있습니다. <br>
                            - 큰 이미지일경우 이미지가 깨지는 경우가 발생할 수 있습니다. <br>
                            최대 지원 사이즈인 640 X 640 으로 리사이즈 해서 올려주세요.(개당 이미지 최대 10M)
                        </p>
                    </div>

                </div>

            </section>
            <hr class="inner__hr">

            <!-- Title -->
            <section class="title">
                <div class="tag__name">
                    제목<span class="tag__star">*</span>
                </div>

                <input type="text" class="title_input" name="sb_name" placeholder="제목을 입력해주세요.">

            </section>
            <hr class="inner__hr">


            <!-- Details -->
            <section class="details">
                <div class="tag__name">
                    설명
                </div>

                <textarea name="sb_detail" id="tag__details" cols="60" rows="10"></textarea>
            </section>

            <!-- price -->
            <section class="price">
                <div class="tag__name">
                    가격<span class="tag__star">*</span>
                </div>
                <input type="text" id="price" name="Total_price">

            </section>
            <hr class="inner__hr">

            <!-- quantity -->
            <section class="quantity">
                <div class="tag__name">
                    총 수량<span class="tag__star">*</span>
                </div>
                <input type="text" id="quantity" name="Total_quantity">

            </section>
            <hr class="inner__hr">

            <!-- Category -->
            <section class="Category">
                <div class="category__greate">

                </div>

                <div class="category__middle">

                </div>

                <div class="category__small">

                </div>

                <h3>선택한 카테고리</h3>
            </section>
            <hr class="inner__hr">


            <!-- Address -->
            <section class="address">
                <div class="tag__name">
                    거래주소<span class="tag__star">*</span>
                </div>

                <div class="address__info">
                    <button class="org__address">내 주소</button>
                    <button class="recent__address">최근지역</button>
                    <input type="text" class="address__detail" name="">
                </div>

            </section>
            <hr class="inner__hr">

            <!-- Trade_Type -->
            <section class="trade__type">
                <div class="tag__name">
                    	거래주소<span class="tag__star">*</span>
                </div>

                <div class="how">
                    <input type="radio" id="meet" name="trade_shape" value="직거래">
                    <label for="meet">직거래</label>
                    <input type="radio" id="mail" name="trade_shape" value="택배거래">
                    <label for="mail">택배거래</label>
                </div>

            </section>

            <div class="sale__regist__btn">
                <button type="submit" class="sale__regist__submit">게시글 등록하기</button>                
            </div>

        </form>
    </div>
	
</body>
</html>