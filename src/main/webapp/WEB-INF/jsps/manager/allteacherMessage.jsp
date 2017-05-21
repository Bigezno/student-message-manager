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

	<!-- <script type="text/javascript">
		function deleteItems() {
			//将form的action指向删除商品的地址
			document.itemsForm.action="${pageContext.request.contextPath}/items/deleteItems.action";

			//进行form提交
			document.itemsForm.submit();

		}
	</script> -->



<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师列表</title>



</head>
	<body>


	
	教师列表：
	<table width="50%" border=1>
		<tr>
			<td>教师编号</td>
			<td>名称</td>
			<td>密码</td> 
			<td>email</td> 
			<td>操作</td>
		</tr>
			<c:forEach items="${listTeacher}" var="teacher">
				<tr>
					<td>${teacher.teacher_id} </td>
					<td>${teacher.teacher_name }</td>
					<td>${teacher.password }</td>
					<td>${teacher.email }</td>
					<td><a href="${pagePath}/student-message-manager/teacher/listTeacherCourse.do?id=${teacher.teacher_id}">查看教师课程</a></td>
				</tr>
			</c:forEach>
		</table>
	
			
			
			
	</body>
</html>