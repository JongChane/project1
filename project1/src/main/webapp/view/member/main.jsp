<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<style type="text/css">
.inline-block {
	display: inline-block;
	text-align: center;
	width: 400px;
	height: 300px;
}
</style>
</head>
<body>
	<div class="container" style="text-align: center;">
		<div>
			<table class="inline-block">
				<tr>
					<th>베스트게시판</th>
				</tr>
				<c:forEach items="${best}" var="board" varStatus="status">
					<c:if test="${status.index < 5}">
						<tr>
							<td>
							<c:choose>
							  <c:when test="${board.category_num == 1}">유머</c:when>
							  <c:when test="${board.category_num == 2}">영화</c:when>
							  <c:when test="${board.category_num == 3}">감동</c:when>
							  <c:when test="${board.category_num == 4}">공포</c:when>
							  <c:when test="${board.category_num == 5}">뉴스</c:when>
							  <c:when test="${board.category_num == 6}">루머</c:when>
							  <c:when test="${board.category_num == 7}">움짤</c:when>
							  <c:when test="${board.category_num == 8}">분석</c:when>
							  <c:when test="${board.category_num == 9}">레시피</c:when>
							  <c:when test="${board.category_num == 10}">맛집</c:when>
							  <c:when test="${board.category_num == 11}">자랑</c:when>
							  <c:otherwise></c:otherwise>
							</c:choose>
							</td>
							<td>${board.content}</td>
							<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="t" />
							<fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"
								var="r" />
							<c:if test="${t==r}">
								<td><fmt:formatDate value="${board.regdate}"
										pattern="HH:mm:ss" /></td>
							</c:if>
							<c:if test="${t!=r}">
								<td><fmt:formatDate value="${board.regdate}"
										pattern="yyyy-MM-dd HH:mm" /></td>
							</c:if>
						</tr>
					</c:if>
				</c:forEach>
			</table>
			<table class="inline-block">
				<tr>
					<th>유머게시판</th>
				</tr>
				<c:forEach items="${humor}" var="board" varStatus="status">
					<c:if test="${status.index < 5}">
						<tr>
							<td>${board.category_num == 1 ? "유머" : board.category_num == 2 ? "영화" : board.category_num == 3? "감동" : board.category_num == 4 ? "공포" : ""}</td>
							<td>${board.content}</td>
							<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="t" />
							<fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"
								var="r" />
							<c:if test="${t==r}">
								<td><fmt:formatDate value="${board.regdate}"
										pattern="HH:mm:ss" /></td>
							</c:if>
							<c:if test="${t!=r}">
								<td><fmt:formatDate value="${board.regdate}"
										pattern="yyyy-MM-dd HH:mm" /></td>
							</c:if>
						</tr>
					</c:if>
				</c:forEach>
			</table>

		</div>
		<table class="inline-block">
			<tr>
				<th>해축게시판</th>
			</tr>
			<c:forEach items="${soccer}" var="board" varStatus="status">
				<c:if test="${status.index < 5}">
					<tr>
						<td>${board.category_num == 5 ? "뉴스" : board.category_num == 6 ? "루머" : board.category_num == 7? "움짤" : board.category_num == 8 ? "분석" : ""}</td>
						<td>${board.content}</td>
						<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="t" />
						<fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"
							var="r" />
						<c:if test="${t==r}">
							<td><fmt:formatDate value="${board.regdate}"
									pattern="HH:mm:ss" /></td>
						</c:if>
						<c:if test="${t!=r}">
							<td><fmt:formatDate value="${board.regdate}"
									pattern="yyyy-MM-dd HH:mm" /></td>
						</c:if>
					</tr>
				</c:if>
			</c:forEach>
		</table>

		<table class="inline-block">
			<tr>
				<th>음식게시판</th>
			</tr>
			<c:forEach items="${food}" var="board" varStatus="status">
				<c:if test="${status.index < 5}">
					<tr>
						<td>${board.category_num == 9 ? "레시피" : board.category_num == 10 ? "맛집" : board.category_num == 11? "자랑" : ""}</td>
						<td>${board.content}</td>
						<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="t" />
						<fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"
							var="r" />
						<c:if test="${t==r}">
							<td><fmt:formatDate value="${board.regdate}"
									pattern="HH:mm:ss" /></td>
						</c:if>
						<c:if test="${t!=r}">
							<td><fmt:formatDate value="${board.regdate}"
									pattern="yyyy-MM-dd HH:mm" /></td>
						</c:if>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
	</div>
</body>
</html>