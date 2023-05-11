<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smile 33OO</title>
<script type="text/javascript">
   function input_check(f) {
      if(f.id.value.trim() == "") {
         alert("아이디를 입력하세요")
         f.id.focus()
         return false;
      }
      if(f.pass.value.trim() == "") {
         alert("비밀번호를 입력하세요")
         f.pass.focus()
         return false;
      }
      if(f.tel.value.trim() == "") {
         alert("전화번호를 입력하세요")
         f.tel.focus()
         return false;
      }
      if(f.email.value.trim() == "") {
         alert("이메일을 입력하세요")
         f.email.focus()
         return false;
      }
      if(f.idchkchk.value.trim() != "checked") {
         alert("아이디 중복체크를 해주세요");
         return false;
      }
      return true;
   }
   function win_upload() {
      var op = "width=500, height=500, left=50,top=150";
      open("pictureForm","",op);
   } 
   function idchk() {
      if (document.f.id.value == '') {
         alert("아이디를 입력하세요")
         f.id.focus()
      } else {
        let op = "width=500,height=200,left=50,top=150"
        open("idchk?id="+document.f.id.value,"",op)
      }
   }
</script>
<style type="text/css">
   div{
      text-align:center;
   }
   #idChkBtn {
        position: relative;
        right: -14vh;
    }
</style>
</head>
<body>

<form action="join" method="post" name="f" onsubmit="return input_check(this)">
<input type="hidden" name="picture" value="">

<div class="container">
   <h2 align="center">회원가입</h2>
   <div class="row">
      <div class="col-3 bg-light" id="center">
   </div>
   <div class="col-9">
      <div class="form-group">
         <label for="id">아이디:</label>&nbsp;&nbsp;&nbsp;
            <input type="text" class="form-control" name="id" id="id" style="width:250px"><br>
            
             <input type="button" value="중복체크" onclick="idchk()" class="btn btn-dark" id="idChkBtn"><br>
             <input type="hidden" name="idchkchk" id="idchkchk" value="">
         <label for="pwd">비밀번호:</label>
            <input type="password" class="form-control" name="pass" id="pwd" style="width:250px"><br>
      </div>
</div>
<br>
   <div class="form-group">
      <label for="tel">전화번호:</label>&nbsp;
         <input type="text" class="form-control" name="tel" id="tel" style="width:250px">
   </div>
   <br>
      <div class="form-group">
         <label for="email">이메일:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="text" class="form-control" name="email" id="email" style="width:250px"><br>
   </div>
   <br>
      <div id="center" style="padding:3px;">
         <button type="submit" class="btn btn-dark">회원가입</button>
         <button type="reset" class="btn btn-dark">다시작성</button>
   </div>
</div>
</div>
</form>
</body>
</html>