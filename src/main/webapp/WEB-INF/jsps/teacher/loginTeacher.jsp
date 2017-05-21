<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教辅人员登录</title>

</head>
	<body>
			<h2>教辅人员登录</h2>
			<form action="/student-message-manager/teacher/login.do" method="post" >
				<table>
					<tr>
						<td>教师编号:</td>
						<td><input type="text" name="id" value="">${IdOrPwdError}</td>
					</tr>
					
					<tr>
						<td>密码：</td>
      			  		<td><input type="password" name="password" value=""></td>
        			</tr>
        			
        			
        			
        			<tr>
      			  		<td><input type="submit"  value="登录"></td>
        			</tr>
				</table>
			</form>
			
			
			
	</body>
</html>