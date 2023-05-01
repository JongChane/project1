<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
<script type="text/javascript">
    function popularListsubmit(page) {
    	f = document.sf;  //검색 form 태그
    	f.pageNum.value=page;
    	f.submit();
    }
</script>    
</head>
<body>
<h2>${boardName}</h2>
<table>
	<c:if test="${boardcount == 0}">
		<tr>
			<td colspan="5">등록된 게시글이 없습니다.</td>
		</tr>	
	</c:if>
	<c:if test="${boardcount > 0}">
		<tr>
			<td colspan="5" style="text-align:right">글개수:${boardcount}
			<a href="list?boardid=${boardid}">[전체글]</a>
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
		<c:forEach var="b" items="${popularList}">
 			<tr>
 				<td>${boardnum}</td>
 					<c:set var="boardnum" value="${boardnum - 1}" />
 				<td>${b.category_num}</td>
 				<td style="text-align: left">
 					<a href="info?board_num=${b.board_num}">${b.title}</a>
 				</td>
 				<td>${b.member_id}</td>
				<%-- 오늘 등록된 게시물 날짜 format대로 출력하기 --%>
 				<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="t" /> 
 				<fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd" var="r" /> 
 				<td>
 					<c:if test="${t==r}">
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
      		<a href="javascript:popularListsubmit(${pageNum-1})">[이전]</a>
      	</c:if>
      	<c:forEach var="a" begin="${startpage}" end="${endpage}">
        	<c:if test="${a == pageNum}">[${a}]</c:if>
        	<c:if test="${a != pageNum}">
          	<a href="javascript:popularListsubmit(${a})">[${a}]</a>
        	</c:if>
      	</c:forEach>
      	<c:if test="${pageNum >= maxpage}">[다음]</c:if>
      	<c:if test="${pageNum < maxpage}">
      		<a href="javascript:popularListsubmit(${pageNum+1})">[다음]</a>
      	</c:if>
 			</td>
 		</tr>  
	</c:if>
	<tr><td colspan="5" style="text-align:right">
	<p align="right"><a href="writeForm">[글쓰기]</a></p>
</table>
<div>
	<form action="popularList?boardid=${boardid}" method="post" name="sf">
   	<input type="hidden" name="pageNum" value="1" >
   	<select name="column" >
     	<option value="">선택하시오</option>
     	<option value="member_id">글쓴이</option>
	 	 	<option value="title">제목</option>
		 	<option value="content">내용</option>
    	<option value="title,content">제목+내용</option>
   	</select>
    <script type="text/javascript">
			document.sf.column.value='${param.column}'
    </script>
		<input type="text" placeholder="Search" name="find" value="${param.find}">
		<button type="submit">Search</button>
	</form>
</div>
</body>
</html>