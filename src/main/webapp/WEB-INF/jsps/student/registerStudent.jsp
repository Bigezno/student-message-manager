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
<title>学生注册</title>

</head>

	<body>
			<h2>学生注册</h2>
			<form:form action="/student-message-manamger/student/save.do" method="post" modelAttribute="student">
				<table>
					<tr>
						<td><form:label path="student_name">姓名：</form:label></td>
      			  		<td><form:input path="student_name" /></td>
        				<td><form:errors path="student_name" cssClass="error" /></td>
        			</tr>
        			
        			<tr>
						<td><form:label path="password">密码：</form:label></td>
      			  		<td><form:input path="password" /></td>
        				<td><form:errors path="password" cssClass="error" /></td>
        			</tr>
					
					<tr>
						<td><form:label path="sex">性别：</form:label></td>
      			  		<td><form:select path="sex">
      			  			<form:option value="男" label="男" />
      			  			<form:option value="女" label="女" />
      			  			</form:select>
      			  		</td>
        				<td><form:errors path="sex" cssClass="error" /></td>
        			</tr>
						
					<tr>
						<td><form:label path="class_id">班级编号：</form:label></td>
      			  		<td><form:input path="class_id" /></td>
        				<td><form:errors path="class_id" cssClass="error" /></td>
        			</tr>
        			
        			<tr>
						<td><form:label path="school_date" >入学日期：</form:label></td>
      			  		<td><form:input path="school_date" placeholder="yyyy-MM-dd"/></td>
        				<td><form:errors path="school_date" cssClass="error" /></td>
        			</tr>
        			
        			<tr>
						<td><form:label path="phone">电话：</form:label></td>
      			  		<td><form:input path="phone" /></td>
        				<td><form:errors path="phone" cssClass="error" /></td>
        			</tr>
        			
        			<tr>
						<td><form:label path="address">地址：</form:label></td>
      			  		<td><form:input path="address" /></td>
        				<td><form:errors path="address" cssClass="error" /></td>
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