<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师信息</title>
</head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String pagePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>

<body>
	<h3>教师基本信息</h3>
	编号：${teacher.teacher_id}   <br/> 
	姓名：${teacher.teacher_name}   <br/> 
	密码： ${teacher.password} <br/> 
	邮箱：${teacher.email}   <br/> 
	
	<h3>-------------教师课程表-------------</h3>
	<table>
				<tr>
						<th>课程编号</th>
						<th>课程名</th>
						<th>上课时间</th>
						<th>地点</th>
						<th>操作</th>
						
				</tr>
				
					<c:forEach items="${listCourse}" var="course" >
						<tr>
							<td>${course.course_id}</td>
							<td>${course.course_name}</td>
							<td>${course.time}</td>
							<td>${course.address}</td>
							<td>
							
							<a href="${pagePath}/student-message-manager/grade/addGrade.do?course_id=${course.course_id}">添加学生成绩</a> 
							
							</td>
						</tr>
					</c:forEach>
				</table>
	
	
	
	
	
</body>
</html>