<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新学生信息</title>
</head>
<body>
	<h2 align="center">更新学生信息</h2>

	<form action="${pageContext.request.contextPath }/UpdateStudentAdd" method="post">

		<table border="1" cellspacing=0 cellPadding=0 align="center" width="40%">
			<tr>
				<td width="50%" align="center">学号</td>
				<td width="50%" align="center"><input type="text" name="number"
					readonly="readonly" width="99%" value="${student.getSID()}" /></td>
			</tr>
			<tr>
				<td align="center">姓名</td>
				<td align="center"><input type="text" name="name" width="99%"
					value="${student.getSname()}" /></td>
			</tr>
			<tr>
				<td align="center">年龄</td>
				<td align="center"><input type="text" name="age" width="99%"
					value="${student.getSage()}" /></td>
			</tr>
			<tr>
				<td align="center">性别</td>
				<td align="center"><input type="text" name="sex" width="99%"
					value="${student.getSex()}" /></td>
			</tr>
			<tr>
				<td align="center">班级</td>
				<td align="center"><input type="text" name="class" width="99%"
					value="${student.getSclass()}" /></td>
			</tr>
			
			<!-- 注意：submit 和 reset 功能，一定要和 form 标签一起使用才有效，请谨记，不要犯低级错误 !!!  --> 
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
					&nbsp;&nbsp; <input type="reset" value="重置" /></td>

			</tr>

		</table>
	</form>
</body>
</html>