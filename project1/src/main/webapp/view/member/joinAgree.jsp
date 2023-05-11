<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smile 33OO</title>
<script type="text/javascript">
function is_checked(){
const agreeCheckbox = document.getElementsByName("agreeCheckbox");
const signupButton = document.getElementById("signupButton");

agreeCheckbox[0].addEventListener("change", function() {
  if (this.checked) {
    signupButton.disabled = false;
  } else {
    signupButton.disabled = true;
  }
});
}
function signUp() {

	  const agreeCheckbox = document.getElementsByName("agreeCheckbox");

	  if (agreeCheckbox[0].checked) {
	    return true;
	  }
		alert("가입하기 전에 개인정보처리방침에 동의해야 합니다.");
	  return false;
	}

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
<body onload="is_checked();">
	<div class="container">
		<h2 align="center">개인정보 약관 동의서</h2>
		<hr>
		<table class='scrolltable' style="width:800px; height:300px; margin:auto;">
			<tr><th> 개인정보 수집 동의서 </th></tr>
			<tr><td> Ⅰ. 개인정보의 수집 및 이용 동의서<br>
 - 이용자가 제공한 모든 정보는 다음의 목적을 위해 활용하며, 하기 목적 이외의 용도로는 사용되지 않습니다.<br>
① 개인정보 수집 항목 및 수집·이용 목적<br>
 가) 수집 항목 (필수항목)<br>
- 전화번호(자택, 휴대전화), 이메일, 기재된 정보 또는 신청자가 제공한 정보<br>
 나) 수집 및 이용 목적<br>
- 33OO사이트 회원가입<br>
 ② 개인정보 보유 및 이용기간<br>
 - 수집·이용 동의일로부터 개인정보의 수집·이용목적을 달성할 때까지<br>
 ③ 동의거부관리<br>
 - 귀하께서는 본 안내에 따른 개인정보 수집, 이용에 대하여 동의를 거부하실 권리가 있습니다. 다만,<br>
귀하가 개인정보의 수집/이용에 동의를 거부하시는 경우에 회원가입을 진행할 수 없음을 알려드립니다.<br>

			 </td></tr>
		</table>
		<br>
		<div>
  <div style="text-align:center;">
 <form action="joinForm" onsubmit="return signUp();">
        동의<input type='checkbox'name="agreeCheckbox" value="Agree"/>
  <br>
    <button type="submit" class="btn btn-dark" id="signupButton">동의 및 회원가입</button>
    </form>
  </div>
</div>
      <hr>
   </div>
</body>
</html>