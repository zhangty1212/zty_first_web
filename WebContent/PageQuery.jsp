<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!-- 引入jstl核心标签库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>分页查询数据</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>
	<table border="1" width="80%" align="center" cellpadding="5"
		cellspacing="0">
		<tr>
			<!-- <td>序号</td>
			<td>员工编号</td>
			<td>员工姓名</td> -->

			<th>序号</th>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>班级</th>

		</tr>
		<!-- 迭代数据 -->
		<c:choose>
			<c:when test="${not empty requestScope.pageBean.pageData}">
				<c:forEach var="student" items="${requestScope.pageBean.pageData}"
					varStatus="vs">
					<tr>
						<td align="center">${vs.count }</td>
						<td align="center">${student.getSID()}</td>
						<td align="center">${student.getSname()}</td>
						<td align="center">${student.getSage()}</td>
						<td align="center">${student.getSex()}</td>
						<td align="center">${student.getSclass()}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="6">对不起，没有你要找的数据</td>
				</tr>
			</c:otherwise>
		</c:choose>

		<tr>
			<td colspan="6" align="center">
				当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页&nbsp;&nbsp; 
				<a href="${pageContext.request.contextPath }/PageQuery?currentPage=1">首页</a> 
				<a href="${pageContext.request.contextPath }/PageQuery?currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>
			    <a href="${pageContext.request.contextPath }/PageQuery?currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a>
			    <a href="${pageContext.request.contextPath }/PageQuery?currentPage=${requestScope.pageBean.totalPage}">末页</a>
			</td>
		</tr>
	</table>
</body>
</html>









