<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<title>教师管理</title>
	</head>
	<body>
			<h2>添加,修改成绩</h2>
		<form action="${path}/student-message-manager/grade/addGrade.do" method="post">
		
			<table width="%50" border="1" >
				<tr>
						<th>课程编号</th>
						<th>课程名</th>
						<th>学号</th>
						<th>学生姓名</th>
						<th>填写成绩</th>
						
				</tr>
				
					<c:forEach items="${gradeList}" var="grade" varStatus="listIndex"  >
						
						<tr>
							<!-- gradeList[0].course_id -->
							<!-- gradeList[1].course_id -->
							<!-- gradeList[2].course_id -->
							
							<!-- GradeModel中有同名属性  List<Grade> gradeList -->
							<td><input name="gradeList[${listIndex.index}].course_id" type="text"  value="${grade.course.course_id}"></td>
							<td>${grade.course.course_name}</td>
							<td><input name="gradeList[${listIndex.index}].student_id" type="text"  value="${grade.student.student_id}"></td>
							<td>${grade.student.student_name}</td>
							<td><input name="gradeList[${listIndex.index}].grade" type="text"  value="${grade.grade}"></td>
						</tr>
					</c:forEach>
					
					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th> <input type="submit"  value="提交"> </th>
						
				</tr>
				</table>
				
			</form>
	</body>
</html>