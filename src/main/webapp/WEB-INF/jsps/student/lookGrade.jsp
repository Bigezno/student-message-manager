<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<title>选课系统表</title>
	</head>
	<body>
			<h2>学生选课表</h2>
			<table>
				<tr>
						<th>课程编号</th>
						<th>课程名</th>
						<th>授课老师</th>
						<th>上课时间</th>
						<th>地点</th>
						<th>成绩</th>
						
				</tr>
				
					<c:forEach items="${gradeList}" var="grade" >
						<tr>
							<td>${grade.course.course_id}</td>
							<td>${grade.course.course_name}</td>
							<td>${grade.teacher.teacher_name}</td>
							<td>${grade.course.time}</td>
							<td>${grade.course.address}</td>
							<td>${grade.grade}</td>
						</tr>
					</c:forEach>
				</table>
			
	</body>
</html>