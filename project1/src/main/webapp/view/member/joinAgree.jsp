<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 약관</title>
<script type="text/javascript">

const agreeCheckbox = document.getElementsByName("agreeCheckbox")[0];
const signupButton = document.getElementById("signupButton");

agreeCheckbox.addEventListener("change", function() {
  if (this.checked) {
    signupButton.disabled = false;
  } else {
    signupButton.disabled = true;
  }
});
</script>
<style type="text/css">
	h2{
		color : white;
		align : center;
	}
	.scrolltable {
  		display: block;
  		overflow: auto;
	}

</style>
</head>
<body>
	<div class="container">
		<h2 align="center">개인정보 약관 동의서</h2>
		<hr>
		<table class='scrolltable' style="width:800px; height:300px; margin:auto;">
			<tr><th> 개인정보 수집 동의서 </th></tr>
			<tr><td> 개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			개인정보 동의해라개인정보 동의해라개인정보 동의해라개인정보 동의해라
			 </td></tr>
		</table>
		<br>
		<div class="container">
  <table style="margin:auto;">
    <tr>
      <td>
        동의<input type='checkbox' name="agreeCheckbox" value="Agree" />
      </td>
    </tr> 
  </table>
  <br>
  <div style="text-align:center;">
    <button type="button" class="btn btn-dark" onclick="location='joinForm'">동의 및 회원가입</button>
  </div>
</div>
		<hr>
	</div>
</body>
</html>