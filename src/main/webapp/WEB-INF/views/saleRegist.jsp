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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="icon" type="image/jpg" href="/resources/img/shopping.png">      
    <link href="/resources/css/saleRegist.css" rel="stylesheet">
</head>
<body>	
	<%-- <jsp:include page="navbar.jsp" flush="false"/> --%>
	<div class="info__container">
        <!-- Top Title -->
        <section class="top__title">
            <div class="tag__name__top">
                <h2 id="main__name">기본정보</h2><span class="tag__star__main"> *필수항목</span>
            </div>
        </section>
        <hr class="main__hr">

        <!-- 중앙입력란 -->
        <form class="sale__regist__form" method="POST" action="/sale/saleregist" enctype="multipart/form-data">
            <div class="info__container_inner">
                <table class="tbl__total">
                    <tbody>
                        <!-- image -->
                        <tr>
                            <th class="tag"><label for="upload__box">상품이미지<span class="tag__star">*</span></label></th>
                            <th class="inner">
                                <div class="upload__box">
                                    <input type="file" class="btn__upload" name="uploadFiles" multiple="multiple">
                                    <!-- <img src="/resources/img/btn_upload.PNG" alt="선택버튼" class="btn__upload__img"> -->

                                    <div class="how">
                                        <b class="up__bold">* 상품 이미지는 500x325에 최적화 되어 있습니다.</b>
                                        <p class="up__semi">
                                            - 이미지는 상품등록 시 정사각형으로 짤려서 등록됩니다. <br>
                                            - 이미지를 클릭 할 경우 원본이미지를 확인할 수 있습니다. <br>
                                            - 이미지를 클릭 후 이동하여 등록순서를 변경할 수 있습니다. <br>
                                            - 큰 이미지일경우 이미지가 깨지는 경우가 발생할 수 있습니다. <br>
                                            최대 지원 사이즈인 500x325 으로 리사이즈 해서 올려주세요. <br>
                                            (개당 이미지 최대 10M)
                                        </p>
                                    </div>

                                </div>
                            </th>
                        </tr>

                        <!-- Title -->
                        <tr>
                            <th class="tag"><label for="title__input">제 목<span class="tag__star"> *</span></label></th>
                            <th class="inner"><input type="text" name="sb_name" id="title__input"></th>
                        </tr>

                        <!-- Details -->
                        <tr>
                            <th class="tag"><label for="tag__details">세부사항</label></th>
                            <th class="inner details"><textarea name="sb_detail" id="tag__details"></textarea></th>
                        </tr>

                        <!-- price -->
                        <tr>
                            <th class="tag"><label for="price">가 격<span class="tag__star"> *</span></label></th>
                            <th class="inner"><input type="text" id="price" name="Total_price"><span class="price__tag">  원</span></th>
                        </tr>

                        <!-- quantity -->
                        <tr>
                            <th class="tag"><label for="quantity">수 량<span class="tag__star"> *</span></label></th>
                            <th class="inner"><input type="text" name="Total_quantity" id="quantity"><span class="quantity__tag"> 개</span></th>
                        </tr>

                        <!-- Category -->
                        <tr>
                            <th class="tag"><label for="how">카테고리<span class="tag__star"> *</span></label></th>
                            <th class="inner">
                                <div class="how">                                    
                                    <label for="ct__cloth"><input type="radio" id="ct__cloth" name="ct_num" value="100">의류</label>                                    
                                    <label for="ct__electron"><input type="radio" id="ct__electron" name="ct_num" value="200">가전제품</label>                                    
                                    <label for="ct__book"><input type="radio" id="ct__book" name="ct_num" value="300">도서/문구</label>                                    
                                    <label for="ct__furniture"><input type="radio" id="ct__furniture" name="ct_num" value="400">가구/책상/의자</label>                                    
                                    <label for="ct__vehicle"><input type="radio" id="ct__vehicle" name="ct_num" value="500">차량/오토바이</label>
                                </div>
                            </th>
                        </tr>

                        <!-- Address -->
                        <tr>
                            <th class="tag"><label for="address__detail">거래지역<span class="tag__star"> *</span></label></th>
                            <th class="inner">
                                <div class="address__info">
                                    <div class="btn__area">
                                        <button type="button" class="org__address">내 기관 주소</button>
                                        <button type="button" class="recent__address">최근지역</button>
                                    </div>                                    
                                    <br>
                                    <input type="text" class="address__detail" name="recent_address">
                                    <div class="warning">* 주의 : (동)까지만 입력해주세요 <span class="tag__star">예시) 관악구 신림동</span></div>
                                </div>
                            </th>
                        </tr>

                        <!-- Trade_Type -->
                        <tr>
                            <th class="tag"><label for="">거래형태<span class="tag__star"> *</span></label></th>
                            <th class="inner">
                                <div class="how">
                                    
                                    <label for="meet"><input type="radio" id="meet" name="trade_shape" value="직거래">직거래</label>                                    
                                    <label for="mail"><input type="radio" id="mail" name="trade_shape" value="택배거래">택배거래</label>                                    
                                    <label for="all"><input type="radio" id="all" name="trade_shape" value="모두가능">모두가능</label>
                                </div>
                            </th>
                        </tr>

                    </tbody>
                </table>
                
            </div> <!-- info__container_inner -->

            <div class="sale__regist__btn">
                <button type="submit" class="sale__regist__submit">게시글 등록하기</button>
            </div>

        </form> <!-- 중앙입력란 -->

    </div> <!-- Top Title -->
	<%-- <jsp:include page="footer.jsp" flush="false"/> --%>
</body>
</html>