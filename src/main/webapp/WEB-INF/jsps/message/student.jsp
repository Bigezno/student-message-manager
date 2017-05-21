<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String pagePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
</head>
<body>
	学生信息：
	
	<table width="50%" border=1>
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>密码</td> 
			<td>性别</td> 
			<td>班级编号</td>
			<td>入学日期</td>
			<td>手机</td>
			<td>地址</td>
			<td>邮箱</td>
		</tr>
			
		<tr>
			<td> ${student.student_id} </td>
			<td> ${student.student_name } </td>
			<td> ${student.password } </td>
			<td> ${student.sex }</td>
			<td> ${student.class_id }</td>
			<td> <fmt:formatDate value="${student.school_date }" pattern="yyyy-MM-dd"/> </td>
			<td>  ${student.phone }</td>
			<td> ${student.address } </td>
			<td> ${student.email } </td>
				
		</tr>
			
		</table>
	
	<table>
		<tr>
			<th>  
				<a href="${pagePath}/student-message-manager/grade/lookGrade.do?student_id=${student.student_id}">查看选课成绩 </a>  
			</th>
		</tr>
		<tr>
			<th>
			
			<a href="${pagePath}/student-message-manager/course/selectCourse.do?student_id=${student.student_id}">选课</a>
			
			</th>
		</tr>
	</table>
		
</body>
</html>