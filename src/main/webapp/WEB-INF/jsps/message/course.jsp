<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程信息</title>

</head>

	<body>
			<h2>课程表</h2>
				<table>
					<tr>
						<td>课程编号：</td>
						<td>${course.course_id}</td>
					</tr>
					<tr>
						<td>课程名：</td>
						<td>${course.course_name}</td>
					</tr>
					<tr>
						<td>授课老师：</td>
						<td>${course.teacher.name}</td>
					</tr>
					<tr>
						<td>上课时间：</td>
						<td>${course.time}</td>
					</tr>
					<tr>
						<td>地点：</td>
						<td>${course.address}</td>
					</tr>
				</table>		
	</body>
	
</html>