<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<form action="update" method="post" name="f">
	<input type="hidden" name="board_num" value="${b.board_num}">
	<div class="container">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${b.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="5" cols="68" name="content">${b.content}</textarea>
				</td>
			</tr>
			<script>
				CKEDITOR.replace("content", {
					filebrowserImageUploadUrl : "imgupload"
				})
			</script>
			<tr>
				<td colspan="2"><a href="javascript:document.f.submit()">[게시물수정]</a></td>
			</tr>
		</table>
	</div>
</form>	
</body>
</html>