<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원관리</title>
	<style type="text/css">
		.container {
			width: 100%;
			height: 100%;
			display: grid;
			grid-template-columns: repeat(2, 1fr);
			grid-template-rows: repeat(2, 1fr);
			grid-gap: 20px;
		}
		.container > div{
			width:80%
		}
		
		.category {
			font-weight: bold;
			font-size: 30px;
			margin-bottom: 10px;
		}

		.board {
			margin-bottom: 10px;
			font-size: 16px;
		}

		.date {
			font-size: 14px;
			color: gray;
		}

		.container > div {
			padding: 10px;
			border: 1px solid #ccc;
			background-color: black;
			height: 500px;
			overflow-y: auto;
			scrollbar-width: thin;
			scrollbar-color: gray;
		}

		.container > div:nth-child(2n-1){margin : 0 0 0 150px;}
		.container > div:nth-child(2n){margin : 0 30x 0 0;}
		.container > div::-webkit-scrollbar {
			width: 8px;
		}

		.container > div::-webkit-scrollbar-thumb {
			background-color: gray;
			border-radius: 4px;
		}
	</style>
</head>
<body>
<div class="container">
	<div>
    <div class="category">베스트게시판</div><hr>
    <c:forEach items="${best}" var="board" varStatus="status">
        <c:if test="${status.index < 7}">
            <div class="board" style="display: flex; justify-content: space-between; align-items: center;">
                <c:choose>
                    <c:when test="${board.category_num == 1}">유머</c:when>
                    <c:when test="${board.category_num == 2}">썰</c:when>
                    <c:when test="${board.category_num == 3}">공포</c:when>
                    <c:when test="${board.category_num == 4}">감동</c:when>
                    <c:when test="${board.category_num == 5}">뉴스</c:when>
                    <c:when test="${board.category_num == 6}">루머</c:when>
                    <c:when test="${board.category_num == 7}">움짤</c:when>
                    <c:when test="${board.category_num == 8}">분석</c:when>
                    <c:when test="${board.category_num == 9}">레시피</c:when>
                    <c:when test="${board.category_num == 10}">맛집</c:when>
                    <c:when test="${board.category_num == 11}">자랑</c:when>
                </c:choose>
					  <a href="../board/info?board_num=${board.board_num}">
					  <c:if test="${not empty bestImg[status.index]}">
            <img src="${bestImg[status.index]}" style="width: 90px; height: 90px; margin-right: 10px;">
       			 </c:if>
						${board.title}
						<span style="color:orange;">[${board.commcnt}]</span>
       		 </a>         
                <div class="date"><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd HH:mm" /></div>
            </div>
          <hr>
        </c:if>
    </c:forEach>
</div>

	<div>
		<div class="category">유머게시판</div><hr>
		<c:forEach items="${humor}" var="board" varStatus="status">
			<c:if test="${status.index < 7}">
				<div class="board" style="display: flex; justify-content: space-between; align-items: center;">
					${board.category_num == 1 ? "유머" : board.category_num == 2 ? "썰" : board.category_num == 3? "공포" : board.category_num == 4 ? "감동" : ""}
					<a href="../board/info?board_num=${board.board_num}">
					  <c:if test="${not empty humorImg[status.index]}">
            <img src="${humorImg[status.index]}" style="width: 90px; height: 90px; margin-right: 10px;">
       			 </c:if>
						${board.title}
						<span style="color:orange;">[${board.commcnt}]</span>
       		 </a>         
					<div class="date"><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd HH:mm" /></div>
				</div>
					<hr>
			</c:if>
		</c:forEach>
	</div>

	<div>
		<div class="category">해축게시판</div><hr>
		<c:forEach items="${soccer}" var="board" varStatus="status">
				<c:if test="${status.index < 7}">
					<div class="board" style="display: flex; justify-content: space-between; align-items: center;">
					${board.category_num == 5 ? "뉴스" : board.category_num == 6 ? "루머" : board.category_num == 7? "움짤" : board.category_num == 8 ? "분석" : ""}
					<a href="../board/info?board_num=${board.board_num}">
					  <c:if test="${not empty soccerImg[status.index]}">
            <img src="${soccerImg[status.index]}" style="width: 90px; height: 90px; margin-right: 10px;">
       			 </c:if>
						${board.title}
						<span style="color:orange;">[${board.commcnt}]</span>
       		 </a>         
					<div class="date"><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd HH:mm" /></div>
				</div>
				<hr>
			</c:if>
		</c:forEach>
	</div>

	<div>
		<div class="category">음식게시판</div><hr>
		<c:forEach items="${food}" var="board" varStatus="status">
				<c:if test="${status.index < 7}">
					<div class="board" style="display: flex; justify-content: space-between; align-items: center;">
					${board.category_num == 9 ? "레시피" : board.category_num == 10 ? "맛집" : board.category_num == 11? "자랑" : ""}
					  <a href="../board/info?board_num=${board.board_num}">
					  <c:if test="${not empty foodImg[status.index]}">
            <img src="${foodImg[status.index]}" style="width: 90px; height: 90px; margin-right: 10px;">
       			 </c:if>
						${board.title}
						<span style="color:orange;">[${board.commcnt}]</span>
       		 </a>         
					<div class="date"><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd HH:mm" /></div>
				</div>
				<hr>
			</c:if>
		</c:forEach>
	</div>
</div>
</body></html>
