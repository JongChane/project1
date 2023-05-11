<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- --%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smile 33OO</title>
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style type="text/css">
   .able { color:green; font-size: 15px;}
   .disable { color:red; font-size: 20px;}
</style>
<body>
<div class="container">
<table class="table"> 
   <tr><td>아이디</td><td>${param.id}</td></tr>
    <tr><td colspan="2"><div id="msg">${msg}</div></td></tr>
    <tr><td colspan="2"><button onclick="self.close()" class="btn btn-primary">닫기</button>
    </td></tr>
</table>    
<script>
  if (${able}) {
     
   opener.document.f.id.style.color="green"
   opener.document.f.idchkchk.value="checked";
   //id="msg" 태그에 class 속성 등록
   document.querySelector("#msg").setAttribute("class","able")
  } else {
     //joinForm.jsp 페이지
   opener.document.f.id.value=""
   document.querySelector("#msg").setAttribute("class","disable")
  }
</script>
</div>
</body>
</html>