<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

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
body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
.w3-row-padding img {margin-bottom: 12px}
/* Set the width of the sidebar to 120px */
.w3-sidebar {width: 120px;background: #222;}
/* Add a left margin to the "page content" that matches the width of the sidebar (120px) */
#main {margin-left: 120px}
/* Remove margins from "page content" on small screens */
@media only screen and (max-width: 600px) {#main {margin-left: 0}}
</style>
<sitemesh:write property="head"/>
</head>
<body class="w3-black">

<!-- Icon Bar (Sidebar - hidden on small screens) -->
<nav class="w3-sidebar w3-bar-block w3-small w3-hide-small w3-center">
  <!-- Avatar image in top left corner -->
  <img src="${path}/image/pepe.png" style="width:60%">
  <a href="${path}/book/testForm" class="w3-bar-item w3-button w3-padding-large w3-black">
    <i class="fa fa-pencil w3-xxlarge"></i>
    <p>글쓰기</p>
  </a>
  <a href="${path}/book/testlist" class="w3-bar-item w3-button w3-padding-large w3-black">
    <i class="fa fa-address-book w3-xxlarge"></i>
    <p>글목록</p>
  </a>
</nav>

<!-- Navbar on small screens (Hidden on medium and large screens) -->
<div class="w3-top w3-hide-large w3-hide-medium" id="myNavbar">
  <div class="w3-bar w3-black w3-opacity w3-hover-opacity-off w3-center w3-small">
    <a href="${path}/book/testForm" class="w3-bar-item w3-button" style="width:25% !important">글쓰기</a>
    <a href="${path}/book/testlist" class="w3-bar-item w3-button" style="width:25% !important">글목록</a>
  </div>
</div>

<!-- Page Content -->
<div class="w3-padding-large" id="main">
  <!-- Header/Home -->
  <header class="w3-container w3-padding-32 w3-center w3-black" id="home">
    <h1 class="w3-jumbo"><span class="w3-hide-small">I'm</span> pepe.</h1>
    <p>페페 더 프로그 방명록</p>
    <img src="${path}/image/pepedi.jpg" class="w3-image" width="15%">
  </header>
<sitemesh:write property="body"/>
  <!-- About Section -->
  <div class="w3-content w3-justify w3-text-grey w3-padding-64" id="about">
  </div>
  </div>

</body>
</html>