<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동아리 커뮤니티 ::: 자유게시판</title>
</head>
<body>
<!-- 처음 요청일 들어오는 home.jsp에서 session에 readIdx를 저장합니다. -->
<c:if test="${sessionScope.readIdx == null }">
	<% StringBuilder readIdx = new StringBuilder("/");
	   session.setAttribute("readIdx", readIdx);
	%>
</c:if>
	<a href="list.do">커뮤니티 게시판</a><br>
	<c:if test="${sessionScope.user == null }">
		<a href="login.do">로그인</a>
		<!-- <a href="./login.do">로그인</a> -->		<!-- 현재경로 freeboard에서 login.do -->
		<!-- <a href="/login.do">로그인</a> -->		<!-- root context 에서 login.do -->
	</c:if>
	<c:if test="${sessionScope.user != null}">
	<!-- 로그인된 상태 -->
		<br>${user.name }(${user.email }) 님 반갑습니다. <br>
		<a href="logout.do">로그아웃</a>
	</c:if>
	<a href="gallery.do">갤러리</a>
</body>
</html>