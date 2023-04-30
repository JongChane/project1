<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<script type="text/javascript">
   function input_check(f) {
	   if(f.member_id.value.trim() == "") {
		   alert("아이디를 입력하세요")
		   f.member_id.focus()
		   return false;
	   }
	   if(f.pass.value.trim() == "") {
		   alert("비밀번호를 입력하세요")
		   f.pass.focus()
		   return false;
	   }
	   return true;
   }
</script>
<form action="join" method="post" name="f" onsubmit="return input_check(this)">
<input type="hidden" name="picture" value="">
<div class="container">
	<h2 id="center">회원가입</h2>
	<div class="row">
		<div class="col-3 bg-light" id="center">
	</div>
	<div class="col-9">
		<div class="form-group">
			<br><label for="id">아이디:</label>
				<input type="text" class="form-control" name="member_id" id="id">
			<br><label for="pwd">비밀번호:</label>
				<input type="password" class="form-control" name="pass" id="pwd">
		</div>
	</div>
</div>
	<div class="form-group">
		<label for="tel">전화번호</label>
			<input type="text" class="form-control" name="tel" id="tel">
	</div>
		<div class="form-group">
			<label for="email">이메일</label>
				<input type="text" class="form-control" name="email" id="email">
	</div>
		<div id="center" style="padding:3px;">
			<button type="submit" class="btn btn-dark">회원가입</button>
			<button type="reset" class="btn btn-dark">다시작성</button>
	</div>
</div>
</form>
</body>
</html>