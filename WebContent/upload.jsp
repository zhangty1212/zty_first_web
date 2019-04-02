<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>文件上传</title>
<style type="text/css">
</style>
</head>

<body>
	<form name="frm_test"
		action="${pageContext.request.contextPath }/UploadFile" method="post"
		enctype="multipart/form-data">

		<table border="1" width="40%" cellspacing="0" cellpadding="0" >
			<tr>
				<td>用户名</td>
				<td><input type="text" name="userName"
					style="width: 90%; height: 30px;"></td>
			</tr>
			<tr>
				<td>文件</td>
				<td><input type="file" name="file_img"
					style="width: 90%; height: 30px;"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="注册"></td>
			</tr>
		</table>

	</form>
</body>
</html>
