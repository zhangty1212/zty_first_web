<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>文件下载页面</title>
</head>

<body>

<h3 align="center"> 文件下载查询结果 </h3>




	<table border="1" cellspacing=0 cellPadding=0 align="center"
		width="80%">

		<tr>

			<th width="60%">下载清单</th>
		</tr>
		
		<!-- 遍历Map集合 -->
		
		<c:forEach var="me" items="${fileNameMap}">

			<tr>
				<c:url value="/DownLoadFile" var="downurl">
					<c:param name="filename" value="${me.key}"></c:param>
				</c:url>

				<td>
				${me.value} &nbsp;&nbsp; <a href="${downurl}">下载</a>
				</td>
			</tr>

		</c:forEach>	

	</table>

</body>

</html>