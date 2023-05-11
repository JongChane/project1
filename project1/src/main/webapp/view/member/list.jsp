<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<div class="container">
		<h2 align="center">회원 목록</h2>
		<div align="center">
			<table style="width:800px; height:300px; margin:auto;">
				<tr>
					<th>아이디</th>
					<th>전화번호</th>
				</tr>
				<c:forEach var="m" items="${list}">
					<tr>
						<td><a href="info?id=${m.member_id}">${m.member_id}</a></td>
						<td>${m.tel}</td>
						<td><a href="updateForm?member_id=${m.member_id}"> 수정 </a>&nbsp;&nbsp;&nbsp;
							<c:if test="${m.member_id != 'admin'}">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteForm?id=${m.member_id}"> 강제탈퇴 </a>
							</c:if></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>