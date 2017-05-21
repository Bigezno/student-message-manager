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
<title>管理员登录</title>

</head>
	<body>
			
			<h2>管理员登录</h2>
			<form:form action="/student-message-manager/manager/login.do" method="post" modelAttribute="manager">
				<table>
					<tr>
						<td><form:label path="manager_name">账号：</form:label></td>
      			  		<td><form:input path="manager_name" /></td>
        				<td><form:errors path="manager_name" cssClass="error" /></td>
        			</tr>
        			
        			<tr>
						<td><form:label path="password">密码：</form:label></td>
      			  		<td><form:input path="password" /></td>
        				<td><form:errors path="password" cssClass="error" /></td>
        			</tr>
        			
        			<tr>
				        <td colspan="2">
				            <input type="submit" value="登录"/>
				        </td>
				    </tr>
				</table>		
			</form:form>
			
			
	</body>
</html>