<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员界面</title>
</head>
<body>

	<table>
		<tr>
			<td><a href="${path}/student-message-manager/manager/allstudentMessage.do" >学生管理</a></td>
		</tr>
		<tr>
			<td><a href="${path}/student-message-manager/manager/allteacherMessage.do" >教师管理</a></td>
		</tr>
		<tr>
			<td><a href="${path}/student-message-manager/manager/allcourseMessage.do" >课程管理</a></td>
		</tr>
		<tr>
			<td><a href="${path}/student-message-manager/manager/allclassMessage.do" >班级管理</a></td>
		</tr>
	</table>

	
	
	
</body>
</html>