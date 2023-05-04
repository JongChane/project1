<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 보기</title>
</head>
<body>
	<div class="container">
	<h2 id="center">회원 상세 정보</h2>
	<table class="table table-hover">
		<tr><td rowspan="6" width="30%">
		<th width="20%">아이디</th><td>${mem.member_id}</td></tr>
			<tr><th>전화</th><td>${mem.tel}</td></tr>
			<tr><th>이메일</th><td>${mem.email}</td></tr>
			<tr><th>레벨</th><td>${mem.level}</td></tr>
 			
			<tr><td colspan="2" id="center">
		<a href="updateForm?member_id=${mem.member_id}">수정</a>
			<c:if test="${param.member_id != 'admin'}">
		<a href="deleteForm?member_id=${mem.member_id}">탈퇴</a>
		</c:if>
	</td></tr>
	</table>
 		<table>
		<tr>
			<td colspan="5" style="text-align:right">글개수:${boardcount}
			<a href="popularList?boardid=${boardid}"></a>
			</td>
		</tr>
		<tr>
			<th width="5%">글번호</th>
			<th width="10%">분류</th>
			<th width="40%">제목</th>
			<th width="15%">글쓴이</th>
			<th width="10%">작성일</th>
			<th width="10%">조회수</th>
			<th width="10%">추천수</th>
		</tr>
		<c:forEach var="b" items="${list}">
 			<tr>
 				<td>${boardnum}</td>
 					<c:set var="boardnum" value="${boardnum +1}" />
 				<td>${b.category_num}</td>
 				<td style="text-align: left">
 					<a href="info?board_num=${b.board_num}">${b.title}</a>
 				</td>
 				<td>${b.member_id}</td>
				<%-- 오늘 등록된 게시물 날짜 format대로 출력하기 --%>
			<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="t" /> 
 			<fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd" var="r" /> 
 		<td><c:if test="${t==r}">
  	 		<fmt:formatDate value="${b.regdate}" pattern="HH:mm:ss" />
	 		</c:if>
		 <c:if test="${t!=r}">
   		 <fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd HH:mm" />
  		</c:if>
 		</td>
		 		<td>${b.readcnt}</td>
		 		<td>${b.recommendcnt}</td>
			</tr>
		</c:forEach>
		<%-- 페이지 처리하기 --%>
 		<tr>
 			<td colspan="5" class="w3-center">
      	<c:if test="${pageNum <= 1}">[이전]</c:if>
      	<c:if test="${pageNum > 1}">
      		<a href="javascript:listsubmit(${pageNum-1})">[이전]</a>
      	</c:if>
      	<c:forEach var="a" begin="${startpage}" end="${endpage}">
        	<c:if test="${a == pageNum}">[${a}]</c:if>
        	<c:if test="${a != pageNum}">
          	<a href="javascript:listsubmit(${a})">[${a}]</a>
        	</c:if>
      	</c:forEach>
      	<c:if test="${pageNum >= maxpage}">[다음]</c:if>
      	<c:if test="${pageNum < maxpage}">
      		<a href="javascript:listsubmit(${pageNum+1})">[다음]</a>
      	</c:if>
 			</td>
 		</tr>  
	</table>	
			</div>
	
</body>
</html>
