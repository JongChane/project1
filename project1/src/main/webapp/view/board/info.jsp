<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="w3-container">
		<table>
			<tr>
				<td>${category_name}</td>
			</tr>
			<tr>
				<td>${b.title}</td>
			</tr>
			<tr>
				<td>Lv10 | ${b.member_id} | 조회수 : ${b.readcnt} | 댓글 1000 | <fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			</tr>
			
			<tr>
				<td>${b.content}</td>
			</tr>
			<tr>
				<td class="w3-center">
					<input type="button" value="추천 :${b.recommendcnt}">
				</td>
				
			</tr>
			
		</table>
		
		<div style="display:flex; justify-content:space-between; width:35%; margin-top:10px;">
			<div align="left">
				<a href="list?boardid=${boardid}">목록으로</a>
			</div>
			<div>
				&nbsp;
				&nbsp;
			</div>
			<c:if test="${sessionScope.login eq b.member_id}">
			<div align="right">
				<a href="updateForm?board_num=${b.board_num}" class="w3-btn"style="margin-right:10px;">수정</a>
				<a href="deleteForm?board_num=${b.board_num}" style="margin-right:50px;">삭제</a>
			</div>
			</c:if>
		</div>
	</div>
	
	<%-- 댓글 작성시 화면 출력 공간 --%>
	<div class="w3-container">
	<table class="w3-table-all">
		<c:forEach var="c" items="${commlist}">
		<tr class="w3-black">
			<td>${c.member_id}</td>
			<td>${c.content}</td>
			<td><fmt:formatDate value="${c.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td class="w3-right">
			<a class="w3-btn w3-border w3-green" href="commdel?num=${param.num}&seq=${c.comment_num}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	
	<%-- 댓글 등록,삭제 및 조회 --%>
	<span id="comment"></span>
	<form action="comment" method="post">
	<input type="hidden" name="board_num" value="${b.board_num}">
	<input type="hidden" name="member_id" value="${sessionScope.login}">
	<div class="w3-row-padding">
		<div class="w3-col s6 ">
			<p><textarea rows="2" cols="68" name="content"></textarea></p>
		</div>
		<div class="w3-col s6">
			<p><button type="submit" class="w3-btn w3-border w3-white">댓글등록</button></p>
		</div>
	</div>
	</form>
	
</body>
</html>