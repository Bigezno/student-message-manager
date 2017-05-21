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
	<form:form action="${pagePath}/student-message-manager/course/addCourse.do" method="post" commandName="course" >
	课程信息：
	<table >
		
		<tr>
			<td><form:label path="course_name">课程名：</form:label></td>
      		<td><form:input path="course_name" /></td>
        	<td><form:errors path="course_name" cssClass="error" /></td>
        </tr>
        
        <tr>
			<td><form:label path="teacher_id">授课教师编号：</form:label></td>
      		<td><form:input path="teacher_id" /></td>
        	<td><form:errors path="teacher_id" cssClass="error" /></td>
        </tr>
        
        <tr>
			<td><form:label path="time">上课时间：</form:label></td>
      		<td><form:input path="time" /></td>
        	<td><form:errors path="time" cssClass="error" /></td>
        </tr>
        
        <tr>
			<td><form:label path="address">地点：</form:label></td>
      		<td><form:input path="address" /></td>
        	<td><form:errors path="address" cssClass="error" /></td>
        </tr>
			
			
		</table>
		<input  type="submit" value="提交"/> 
	</form:form>
				
					
	</body>
	
</html>