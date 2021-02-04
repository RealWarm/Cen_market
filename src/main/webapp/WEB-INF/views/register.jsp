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
    <link rel="stylesheet" href="/resources/css/style1.css">
    <!-- Bootstrap core CSS -->
	<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<!-- Bootstrap core JavaScript -->
  	<script src="/resources/vendor/jquery/jquery.min.js"></script>
  	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script> 
</head>
<body>
	<!-- <div id="header">
        <div class="header-inner">
            <h1 class="header-logo"><a href="/"><img src="/resources/img/kor_used1.PNG" alt="naraused" width="400px" height="80"></a></h1>
            <div id="gnb">
                <h2 class="blind">대표메뉴</h2>
                    <ul class="nav">
                        <li><a href="/">로그인</a></li>
                        <li><a href="javascript:void(0)">아이디 찾기</a></li>
                        <li><a href="javascript:void(0)">비밀번호 찾기</a></li>
                    </ul>
            </div>
            <ul class="user-menu">
                <li><a href="">로그인</a></li>
                <li><a href="">회원가입</a></li>
            </ul>
        </div>
    </div> -->
    <jsp:include page="navbar.jsp" flush="false"/>
    <div class="main-join-wrap">
        <form class="join-form" action="/member/register" method="POST">
            <div class="join-title-main">
                <h2 class="join-title">회원가입</h2>
            </div>
            <div class="join-insert-wrap">
                <table class="join-table">
                    <caption class="blind">회원가입 정보입력</caption>
                    <colgroup>
                        <col style="width:20%">
                    </colgroup>
                    <tbody>
                        <tr>
                            <th scope="row">
                                <label for="id">*아이디</label>
                            </th>
                            <td>
                                <input type="text" title="아이디" id="id" name="id" maxlength="12" required="">
                                <button class="check-bt">중복확인</button>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="password">*비밀번호</label></th>
                            <td>
                                <input type="password" title="아이디" id="password" name="password" required="">
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="user_check_pw">*비밀번호 확인</label></th>
                            <td>
                                <input type="password" title="비밀번호 확인" id="user_check_pw" name="user_check_pw" required="">
                            </td>
                        </tr>
                        <tr>
                            <th><label for="name">*이름</label></th>
                            <td>
                                <input type="text" title="이름" id="name" name="name" required="">
                            </td>
                        </tr>
                        <tr>
                            <th><label for="nickname">*닉네임</label></th>
                            <td>
                                <input type="text" title="닉네임" id="nickname" name="nickname" required="">
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="phnum">*휴대폰</label></th>
                            <td>
                                <input type="phone" title="휴대폰" id="phnum" name="phnum" required="">
                            </td>                        
                        <tr>
                            <th scope="row"><label for="email">*이메일</label></th>
                            <td>
                                <input type="email" id="email" name="email" required="" placeholder='joe@example.com'>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="org_name">*기관명(주소 + 기관)</label></th>
                            <td>
                            	<input type="hidden" id="org_code" name="org_code" value="0">
                                <input type="text" id="org_name" name="org_name" placeholder='신림동 동사무서'>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="join-button-wrap">
                <input type="submit" value="회원가입" class="join-button join-submit">
                <input type="reset" value="취소" class="join-button">
            </div>
        </form>
    </div>
    <jsp:include page="footer.jsp" flush="false"/>


</body>
</html>