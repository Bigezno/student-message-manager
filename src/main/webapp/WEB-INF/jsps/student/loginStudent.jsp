<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<script type="text/javascript">  
		function changeImg(obj){
			var i = Math.floor(Math.random()*4);  //Math.floor(Math.random()*10);时，可均衡获取0到9的随机整数。
			var createTypeFlag = ['ch','nl','n','l'];
			document.getElementById(obj.id).src="${pageContext.request.contextPath}/RandomPicture.do?createTypeFlag="+createTypeFlag[i]+"&"+Math.random();
			
		}
</script>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生登录</title>

</head>

	<body>
			<h2>学生登录</h2>
			<form action="/student-message-manager/student/login.do" method="post" >
				<table>
					<tr>
						<td>学号</td>
      			  		<td><input type="text" name="student_id" value="">${IdOrPwdError}</td>
        				<td></td>
        			</tr>
        			<tr>
						<td>密码：</td>
      			  		<td><input type="password" name="password" value=""></td>
      			  		<td></td>
        			</tr>
					
					<tr>
						<td>验证码:</td>
      			  		<td><input type="text" name="validateCode" value=""/> </td>
      			  		<td>
        					<img alt="看不清换一张" src="${pageContext.request.contextPath}/RandomPicture.do" id="createTypeFlag" onclick="changeImg(this)"> ${message}
        				</td>
        			</tr>
        			<tr>
				        <td colspan="2">
				            <input type="submit" value="登录"/>
				        </td>
				    </tr>
				</table>		
			</form>
	</body>
	
</html>