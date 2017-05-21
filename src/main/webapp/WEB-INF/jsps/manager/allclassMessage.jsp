<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	// /student-message-manager
	String path = request.getContextPath();

	// http://localhost:8080/student-message-manager/
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	// http://localhost:8080
	String pagePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
	
	
%>

<style>
.error {
   color: #ff0000;
}

.errorblock {
   color: #000;
   background-color: #ffEEEE;
   border: 3px solid #ff0000;
   padding: 8px;
   margin: 16px;
}
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级管理</title>

</head>
	<body>
			
	班级列表：
	<table width="50%" border=1>
		<tr>
			<td>班级编号</td>
			<td>班级名称</td>
			<td>操作</td>
		</tr>
			<c:forEach items="${listClassModel}" var="classModel">
					<tr>
						<td>${classModel.class_id} </td>
						<td>${classModel.class_name }</td>
						<td><a href="${pagePath}/student-message-manager/classmodel/listStudent.do?id=${classModel.class_id}">查看该班学生</a></td>
					</tr>
			</c:forEach>
	</table>
			
			
			
	</body>
</html>