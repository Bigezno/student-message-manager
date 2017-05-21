<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<title>课程信息</title>

</head>

	<body>
		<h2>课程表</h2>
			<table width="50%" border=1>
				<tr>
					<td>课程编号</td>
					<td>课程名</td>
					<td>授课老师</td>
					<td>上课时间</td>
					<td>地点</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${listCourse}" var="course">
						<tr>
							<td>${course.course_id} </td>
							<td>${course.course_name }</td>
							<td>${course.teacher.teacher_name }</td>
							<td>${course.time }</td>
							<td>${course.address }</td>
							<td>
								<a href="${pagePath}/student-message-manager/course/deleteCourse.do?id=${classModel.course_id}">删除课程</a>
							</td>
						</tr>
				</c:forEach>
				
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						
					</td>
					<td>	
						<a href="${pagePath}/student-message-manager/course/addCourse.do?id=${classModel.course_id}">添加课程</a> 
					</td>
				</tr>
			</table>		
	</body>
	
</html>