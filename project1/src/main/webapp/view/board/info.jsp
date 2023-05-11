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
      if (comm1.style.display == 'table-row')
          document.querySelector('#comment'+rno).style.display = 'none';
      else 
         document.querySelector('#comment'+rno).style.display = 'table-row';
   }
    function input_check(f){
       if(f.content.value.trim() == ""){
          alert("글 작성 하세요")
          f.content.focus()
          return false;
       }
    }
</script>
<meta charset="UTF-8">
<title>Smile 33OO</title>
</head>

<body>
   <div class="w3-container" style="width:1050px; height:300px; margin:auto;" align="center">
      <table>
         <tr>
            <td>[분류]&nbsp;&nbsp;&nbsp;&nbsp;${category_name}</td>
         </tr>
         <tr>
            <td>[제목]&nbsp;&nbsp;&nbsp;&nbsp;${b.title}</td>
         </tr>
         <tr>
            <td><c:choose>
        	<c:when test="${level == 1}">
            	<img src="../image/1.gif">
        	</c:when>
        	<c:when test="${level == 2}">
            	<img src="../image/2.gif">
        	</c:when>
        	<c:when test="${level == 3}">
            	<img src="../image/3.gif">
        	</c:when>
        	<c:when test="${level == 4}">
            	<img src="../image/4.gif">
        	</c:when>
        	<c:when test="${level == 5}">
        		<img src="../image/5.gif">
        	</c:when>
        	<c:when test="${level == 6}">
        		<img src="../image/6.gif">
        	</c:when>
        	<c:when test="${level == 7}">
        		<img src="../image/7.gif">
        	</c:when>
        	<c:when test="${level == 8}">
        		<img src="../image/8.gif">
        	</c:when>
        	<c:when test="${level == 9}">
        		<img src="../image/9.gif">
        	</c:when>
        	<c:when test="${level == 10}">
        		<img src="../image/10.gif">
        	</c:when>        
    	</c:choose>	&nbsp;&nbsp;|&nbsp;&nbsp;${b.member_id}&nbsp;&nbsp;|&nbsp;&nbsp;조회수 : <fmt:formatNumber value="${b.readcnt}" groupingUsed="true"/>&nbsp;&nbsp;
             |&nbsp;&nbsp;추천수 : <fmt:formatNumber value="${b.recommendcnt}" groupingUsed="true"/>&nbsp;&nbsp;|&nbsp;&nbsp;댓글수 : ${b.commcnt}&nbsp;&nbsp;|&nbsp;&nbsp;<fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
         </tr>
         <tr>
            <td>${b.content}</td>
         </tr>
         <tr>
         <td class="w3-center">
            <c:if test="${sessionScope.login eq b.member_id}">
            <a href="updateForm?board_num=${b.board_num}" class="w3-btn"style="margin-right:10px;">[수정]</a>
            <a href="deleteForm?board_num=${b.board_num}" style="margin-right:50px;">[삭제]</a>
         </c:if>
         </td> 
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
         <div align= "left">
            <a href="list?boardid=${boardid}">목록으로</a>
         </div>

   
   <%-- 댓글 작성시 화면 출력 공간 --%>
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
            <td> ${c.content}</td>
           	<td><fmt:formatDate value="${c.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td class="w3-right">
               <form id="comrecommend" method="post" action="comrecommend" name="rf">
                   <input type="hidden" id="comment_num" name="comment_num" value="${c.comment_num}">
                   <input type="hidden" id="board_num" name="board_num" value="${b.board_num}">
                   <button type="submit">👍 : ${c.recommendcnt}</button>
               </form>
                <c:if test="${sessionScope.login eq c.member_id}">
            <a class="w3-btn w3-border w3-green" href="commdel?board_num=${b.board_num}&comment_num=${c.comment_num}">삭제</a>
            </c:if>
            </td>
    			</tr>
      </c:if>
      </c:forEach>
      
      <c:forEach var="c" items="${commlist}" varStatus="stat">
         <tr class="w3-black">
         <td>
          <c:if test="${c.grplevel ==1 }">└&nbsp;&nbsp;</c:if>
            ${c.member_id}
          <c:choose>
        	<c:when test="${level == 1}">
            	<img src="../image/1.gif">
        	</c:when>
        	<c:when test="${level == 2}">
            	<img src="../image/2.gif">
        	</c:when>
        	<c:when test="${level == 3}">
            	<img src="../image/3.gif">
        	</c:when>
        	<c:when test="${level == 4}">
            	<img src="../image/4.gif">
        	</c:when>
        	<c:when test="${level == 5}">
        		<img src="../image/5.gif">
        	</c:when>
        	<c:when test="${level == 6}">
        		<img src="../image/6.gif">
        	</c:when>
        	<c:when test="${level == 7}">
        		<img src="../image/7.gif">
        	</c:when>
        	<c:when test="${level == 8}">
        		<img src="../image/8.gif">
        	</c:when>
        	<c:when test="${level == 9}">
        		<img src="../image/9.gif">
        	</c:when>
        	<c:when test="${level == 10}">
        		<img src="../image/10.gif">
        	</c:when>        
    			</c:choose>
         </td>

         <td>${c.content}</td>
         <td><fmt:formatDate value="${c.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
         <td>
            <c:if test="${c.grplevel !=1 }">
               <input type="button" name="reply" id="reply${stat.count}" value="[댓글달기]" onclick="showreply(${stat.count})">
            </c:if>
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
      <tr id="comment${stat.count}" style="display: none;">
         <td colspan="5">
           <form action="reply"  method="post" name="comment" >
            <input type="hidden" name="board_num" value="${b.board_num}">
            <input type="hidden" name="member_id" value="${sessionScope.login}">
            <input type="hidden" name="comment_num" value="${c.comment_num}">
            <input type="hidden" name="grpstep" value="${c.grpstep}">
            <input type="hidden" name="grplevel" value="${c.grplevel}">
            
            <!-- ============================================================================ -->
             <span style="color:black">└</span>&nbsp;&nbsp;&nbsp;
             <input style="width:85%" type="text" name="content"/>             
             <button type="submit" class="w3-btn w3-border w3-white">댓글등록</button>
            </form>
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
   
   <%-- 댓글 등록,삭제 및 조회 --%>
   <span id="comment">
   <form action="comment" method="post" onsubmit="return input_check(this)">
   <div style=" margin:auto;" align="center">
   <input type="hidden" name="board_num" value="${b.board_num}">
   <input type="hidden" name="member_id" value="${sessionScope.login}">
         <p><textarea rows="2" cols="100" name="content" ></textarea></p>
         <p><button type="submit" class="w3-btn w3-border w3-white" style="margin:auto;">댓글등록</button></p>
      </div>
   </form>
   </span>
   </div>
</body>
</html>
