<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String pagePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
	out.print("path:"+path+"<br/>");
	out.print("basePath:"+basePath+"<br/>");
	out.print("pagePath:"+pagePath+"<br/>");
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
<title>学生列表</title>

</head>
	<body>
			
	学生列表：
	<table width="50%" border=1>
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>密码</td> 
			<td>性别</td> 
			<td>入学日期</td>
			<td>手机</td>
			<td>地址</td>
			<td>邮箱</td>
			<td>操作</td>
		</tr>
			<c:forEach items="${listStudent}" var="student">
					<tr>
						<td>${student.student_id} </td>
						<td>${student.student_name }</td>
						<td>${student.password }</td>
						<td>${student.sex }</td>
						<td><fmt:formatDate value="${student.school_date }" pattern="yyyy-MM-dd"/></td>
						<td>${student.phone }</td>
						<td>${student.address }</td>
						<td>${student.email }</td>
						
						<!-- 还未修改 -->
						<td><a href="${pagePath}/student-message-manager/student/updateStudent.do?id=${student.student_id}">修改学生信息</a></td>
						
					</tr>
			</c:forEach>
	</table>
			
			
	</body>
</html>