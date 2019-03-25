<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息查询结果</title>
</head>
<body>

	<h2 align="center">学生信息查询结果</h2>



	<table border="1" cellspacing=0 cellPadding=0 align="center" width="80%">

		<tr>

			<th width="16%">学号</th>
			<th width="16%">姓名</th>
			<th width="16%">年龄</th>
			<th width="16%">性别</th>
			<th width="16%">班级</th>
			<th width="10%">更新 </th>
            <th width="10%">删除 </th>
		</tr>

		<c:forEach items="${requestScope.studentslist}" var="student" varStatus="varSta">

			<tr>
				<td align="center">${student.getSID()}</td>
				<td align="center">${student.getSname()}</td>
				<td align="center">${student.getSage()}</td>
				<td align="center">${student.getSex()}</td>
				<td align="center">${student.getSclass()}</td>
				<td align="center"><input type="button" value ="更新" onclick="window.location.href='${pageContext.request.contextPath }/UpdateStudent?SID=${student.getSID()}'" /></td>
				<td align="center"><input type="button" value ="删除" onclick="window.location.href='${pageContext.request.contextPath }/DeleteStudent?SID=${student.getSID()}'" /></td>
			</tr>
            
		</c:forEach>

	</table>

	<%-- ${requestScope.studentslist} 
	
	 序号：${varSta.count} - 姓名：${student.Sname} - 学号: ${student.SID} <br />
	 
	--%>

</body>
</html>