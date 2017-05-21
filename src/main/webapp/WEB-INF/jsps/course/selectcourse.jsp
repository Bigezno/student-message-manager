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
			<h2>选课表</h2>   
			<form action="${path}/student-message-manager/course/selectCourse.do" method="post" >
					
			<table>
				<tr>
						<th>课程编号</th>
						<th>课程名</th>
						<th>授课老师</th>
						<th>上课时间</th>
						<th>地点</th>
						<th>选课</th>
						
				</tr>
				
					<c:forEach items="${listCourse}" var="course" >
						<tr>
							<td>${course.course_id}</td>
							<td>${course.course_name}</td>
							<td>${course.teacher.teacher_name}</td>
							<td>${course.time}</td>
							<td>${course.address}</td>
							<td>
								<input name="select_course" type="checkbox" value="${course.course_id}">
							</td>
						</tr>
					</c:forEach>
					
					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th><input type="submit" value="提交"></th>
						
				</tr>
					
				</table>
			</form>	
	</body>
</html>