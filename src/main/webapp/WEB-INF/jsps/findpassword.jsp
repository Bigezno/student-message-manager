<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>找回密码</title>
  </head>
  
  <body>
  		<c:if test="${key}">
  			您的密码：${pwd}
  		</c:if>
  		
  		<c:if test="${key_form}">
  			您好，请务必填写关于您的账号的正确信息。        <br/>
  			<form action="" method="post">
		    		请输入教师编号：<input name="id" type="text" value="" />
		    		<input type="submit" value="提交" />
		    	</form>
  		</c:if>
		    	
  	
  </body>
</html>