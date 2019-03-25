<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">添加学生信息</h2>


	<form action="${pageContext.request.contextPath }/AddStudent"
		method="post">

		<table border="1" cellspacing=0 cellPadding=0 align="center"
			width="40%">
			<tr>
				<td width="50%" align="center">学号</td>
				<td width="50%" align="center"><input type="text" name="number"
					style="height: 25px; width: 99%;" /></td>
			</tr>
			<tr>
				<td align="center">姓名</td>
				<td align="center"><input type="text" name="name"
					style="height: 25px; width: 99%;" /></td>
			</tr>
			<tr>
				<td align="center">年龄</td>
				<td align="center"><input type="text" name="age"
					style="height: 25px; width: 99%;" /></td>
			</tr>
			<tr>
				<td align="center">性别</td>
				<td align="center"><input type="text" name="sex"
					style="height: 25px; width: 99%;" /></td>
			</tr>
			<tr>
				<td align="center">班级</td>
				<td align="center"><input type="text" name="class"
					style="height: 25px; width: 99%;" /></td>
			</tr>
			<tr>

				<!--  注意： 这里是用的 form 表单，提交表单数据给servlet, type 类型一定要写 'submit'  -->
				<td colspan="2" align="right"><input type="submit"
					style="height: 35px; width: 20%;" value="添加" /></td>
			</tr>

		</table>

	</form>

</body>
</html>