<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="uri" value="${pageContext.request.servletPath}" />
<!DOCTYPE html>
<html> 
<head>
<title><sitemesh:write property="title"/></title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1,h2,h3,h4,h5,h6 {
		font-family: 'TheJamsil5Bold'; sans-serif;
		font-weight: 400;
		font-style: normal;}
.w3-row-padding img {margin-bottom: 12px}
/* Set the width of the sidebar to 120px */
.w3-sidebar {width: 120px;background: #222;}
/* Add a left margin to the "page content" that matches the width of the sidebar (120px) */
#main {margin-left: 120px}
/* Remove margins from "page content" on small screens */
@media only screen and (max-width: 600px) {#main {margin-left: 0}}
@font-face {
    font-family: 'TheJamsil5Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302_01@1.0/TheJamsil5Bold.woff2') format('woff2');
    font-weight: 500;
    font-style: normal;
}
a{
    text-decoration-line: none;
}

</style>
<script type="text/javascript"
  src="http://cdn.ckeditor.com/4.5.7/full/ckeditor.js">
  </script>
<sitemesh:write property="head"/>
</head>
<!-- Top container -->
<div style="background-color:#282a35;  font-family:'TheJamsil5Bold'; sans-serif; font-weight: 500;"
		 class="w3-container w3-center w3-bar w3-top w3-large">
  <a href="${path}/member/main" class="w3-bar-item"><img src="${path}/image/332.PNG" class="w3-image" width="13%">&nbsp;&nbsp;Smile 3300</a>
  <a href="${path}/board/list?boardid=1" class="w3-bar-item w3-button">베스트게시판</a>
  <a href="${path}/board/list?boardid=2" class="w3-bar-item w3-button">유머게시판</a>
  <a href="${path}/board/list?boardid=3" class="w3-bar-item w3-button">해축게시판</a>
  <a href="${path}/board/list?boardid=4" class="w3-bar-item w3-button">음식게시판</a>
  <input type="text" class="w3-bar-item w3-input" placeholder="Search..">
  <a href="#" class="w3-bar-item w3-button" style="background-color:#282a35;">검색</a>
  <span class="w3-bar-item w3-right">
  <c:if test="${empty sessionScope.login}">
     <a href="${path}/member/loginForm">로그인</a>
     <a href="${path}/member/joinForm">회원가입</a>
  </c:if>
  <c:if test="${!empty sessionScope.login}">
     ${sessionScope.login}님&nbsp;&nbsp;
     <a href="${path}/member/info?id=${sessionScope.login}">내정보</a>&nbsp;
     <a href="${path}/member/logout">로그아웃</a>
  </c:if>
  </span>
</div>

<body class="w3-black">
<!-- Page Content -->
<div class="w3-padding-large" id="main">
  <!-- Header/Home -->
  <header class="w3-container w3-padding-32 w3-center w3-black" id="home">
    <h5 class="w3-xxxlarge"><span class="w3-hide-small">Smile 3300 &nbsp;&nbsp;
    <img src="${path}/image/332.PNG" class="w3-image" width="3%"></span></h5>
  </header>
<sitemesh:write property="body"/>
  <!-- About Section -->
  <div class="w3-content w3-justify w3-text-grey w3-padding-64" id="about">
  </div>
  </div>
<footer class="w3-padding-64 w3-content w3-text-grey">
    <div class="w3-section">
      <p><i class="fa fa-map-marker fa-fw w3-text-white w3-large w3-margin-right"></i> GDJ 62기 3300프로젝트</p>
      <p><i class="fa fa-phone fa-fw w3-text-white w3-large w3-margin-right"></i> Phone: 010-1234-1234</p>
      <p><i class="fa fa-envelope fa-fw w3-text-white w3-large w3-margin-right"> </i> Email: 3300@3300.com</p>
      <p>© 2023 • 3300.co.kr</p>
    </div></footer><br>
</body>
</html>