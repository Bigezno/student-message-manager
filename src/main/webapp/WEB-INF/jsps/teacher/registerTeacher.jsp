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
<title>教师注册</title>

</head>

	<body>
			<h2>教师注册</h2>
			<form:form action="/student-message-manager/teacher/register.do" method="post" modelAttribute="teacher">
				<table>
					<tr>
						<td><form:label path="teacher_name">姓名：</form:label></td>
      			  		<td><form:input path="teacher_name" /></td>
        				<td><form:errors path="teacher_name" cssClass="error" /></td>
        			</tr>
        			
        			<tr>
						<td><form:label path="password">密码：</form:label></td>
      			  		<td><form:input path="password" /></td>
        				<td><form:errors path="password" cssClass="error" /></td>
        			</tr>
										
        			
        			<tr>
						<td><form:label path="email">邮箱：</form:label></td>
      			  		<td><form:input path="email" /></td>
        				<td><form:errors path="email" cssClass="error" /></td>
        			</tr>
        			
        			<tr>
				        <td colspan="2">
				            <input type="submit" value="注册"/>
				        </td>
				    </tr>
				</table>		
			</form:form>
	</body>
	
</html>