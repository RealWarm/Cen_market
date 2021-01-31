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
        <form action="/sale/saleregist"	method="post"enctype="multipart/form-data">
			<input type="file" name="uploadFiles" multiple="multiple">
            
            <div class="sale__regist__btn">
                <button type="submit" class="sale__regist__submit">등록!!!</button>
                <input type="reset" class="register-reset-btn"></input>
            </div>
        </form>
      
    </div>
	
</body>
</html>