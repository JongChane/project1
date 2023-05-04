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
		
		<div style="display:flex; justify-content:space-around; width:35%; margin-top:10px;">
			<div align="left"><a href="list?boardid=${boardid}">목록으로</a></div>
			<div>&nbsp;</div>
			<div>&nbsp;</div>
			<div align="right">
				<button>하이</button>
				<button>하이</button>
			</div>
		</div>
	</div>
	
<!--  	<div class="w3-container">
		<table>
			<tr>
				
				<td style="width:770px">
					댓글 : 30
				</td>
			</tr>
			<tr>
				<td>
					<span>BEST!</span><br>
					Lv10 | 고현빈 | 2023-05-03 15:41<br>
					ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ추성훈이 죽이러 올듯
				</td>
			</tr>
		</table>
	</div>
-->	
</body>
</html>