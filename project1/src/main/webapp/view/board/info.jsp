<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<script>
  window.onload = function(){
   document.querySelector('#reply').addEventListener('click', function() {
      document.querySelector('#comment').style.display = 'block';
      })
   };
   function showreply(rno) {
      comm1 = document.querySelector('#comment'+rno)
      console.log(comm1.style.display)
      if (comm1.style.display == 'block')
          document.querySelector('#comment'+rno).style.display = 'none';
      else 
         document.querySelector('#comment'+rno).style.display = 'block';
   }
</script>
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
            <td>Lv${level} | ${b.member_id} | 조회수 : ${b.readcnt} | 추천수 : ${b.recommendcnt} | 댓글수 : ${b.commcnt} | <fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
         </tr>
         
         <tr>
            <td>${b.content}</td>
         </tr>
         <tr>
            <td class="w3-center">
               <form id="recommend" method="post" action="recommend" name="rf">
                <input type="hidden" id="board_num" name="board_num" value="${b.board_num}">
                <button type="submit">👍 : ${b.recommendcnt}</button>
               </form>
            </td>
            
         </tr>
         
      </table>
      
      <div style="display:flex; justify-content:space-between; width:35%; margin-top:10px;">
         <div align="left">
            <a href="list?boardid=${boardid}">목록으로</a>
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
      
      <c:forEach var="c" items="${top3Comments}" varStatus="status">
      <c:if test="${c.recommendcnt > 10}">
         <c:choose>
            <c:when test="${status.index == 0}">
               <tr style="background-color:orange;">
               <td>🥇</td>
            </c:when>
            <c:when test="${status.index == 1}">
               <tr style="background-color:silver;">
               <td>🥈</td>
            </c:when>
            <c:when test="${status.index == 2}">
              <tr class="w3-brown">
              <td>🥉</td>              
            </c:when>
         </c:choose>
            <td>${c.member_id}</td>
            <td>${c.content}</td>
            <td><fmt:formatDate value="${c.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td class="w3-right">
               <form id="comrecommend" method="post" action="comrecommend" name="rf">
                   <input type="hidden" id="comment_num" name="comment_num" value="${c.comment_num}">
                   <input type="hidden" id="board_num" name="board_num" value="${b.board_num}">
                   <button type="submit">👍 : ${c.recommendcnt}</button>
               </form>
            <a class="w3-btn w3-border w3-green" href="commdel?board_num=${param.board_num}&grp=${c.grp}&comment_num=${c.comment_num}&grplevel=${c.grplevel}">삭제</a>
            </td>
    
      </c:if>
      </tr>
      </c:forEach>
      
      <c:forEach var="c" items="${commlist}" varStatus="stat">
         <tr class="w3-black">

         
                 
         <td>
            <c:if test="${c.grplevel ==1 }">└&nbsp;&nbsp;</c:if>
            ${c.member_id}
         </td>

         <td>${c.content}</td>
         <td><fmt:formatDate value="${c.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
         <td>
            <c:if test="${c.grplevel !=1 }">
               <input type="button" name="reply" id="reply${stat.count}" value="[댓글달기]" onclick="showreply(${stat.count})">
            </c:if>
            <form action="reply" id="comment${stat.count}" method="post" name="comment" style="display: none;">
            <input type="hidden" name="board_num" value="${b.board_num}">
            <input type="hidden" name="member_id" value="${sessionScope.login}">
            <input type="hidden" name="comment_num" value="${c.comment_num}">
            <input type="hidden" name="grpstep" value="${c.grpstep}">
            <input type="hidden" name="grplevel" value="${c.grplevel}">
            <div class="w3-row-padding">
               <div class="w3-col s6 ">
                  <p><textarea rows="2" cols="68" name="content"></textarea></p>
               </div>
               
               <div class="w3-col s6">
                  <p><button type="submit" class="w3-btn w3-border w3-white">댓글등록</button></p>
               </div>
            </div>
            </form>
         </td>
         <td class="w3-right">
               <form id="comrecommend" method="post" action="comrecommend" name="rf">
                <input type="hidden" id="comment_num" name="comment_num" value="${c.comment_num}">
                <input type="hidden" id="board_num" name="board_num" value="${b.board_num}">
                <button type="submit">👍 : ${c.recommendcnt}</button>
               </form>
               <c:if test="${sessionScope.login eq c.member_id}">
               <a class="w3-btn w3-border w3-green" href="commdel?board_num=${param.board_num}&grp=${c.grp}&comment_num=${c.comment_num}&grplevel=${c.grplevel}">삭제</a>
               </c:if>
         </td>
      </tr>
      </c:forEach>
         <%-- 페이지 처리하기 --%>
       <tr class="w3-black">
          <td colspan="5" class="w3-center">
         <c:if test="${pageNum <= 1}">[이전]</c:if>
         <c:if test="${pageNum > 1}">
            <a href="info?board_num=${b.board_num}&readcnt=f&pageNum=${pageNum - 1}">[이전]</a>
         </c:if>
         <c:forEach var="a" begin="${startpage}" end="${endpage}">
           <c:if test="${a == pageNum}">[${a}]</c:if>
           <c:if test="${a != pageNum}">
             <a href="info?board_num=${b.board_num}&readcnt=f&pageNum=${a}">[${a}]</a>
           </c:if>
         </c:forEach>
         <c:if test="${pageNum >= maxpage}">[다음]</c:if>
         <c:if test="${pageNum < maxpage}">
            <a href="info?board_num=${b.board_num}&readcnt=f&pageNum=${pageNum + 1}">[다음]</a>
         </c:if>
          </td>
       </tr>  
   </table>
   </div>
   
   <%-- 댓글 등록,삭제 및 조회 --%>
   <span id="comment">
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
   
   </span>
</body>
</html>