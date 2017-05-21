package service;

import java.util.List;

import pojo.Grade;

public interface GradeService {
	
	//根据学生id来查找成绩
	List<Grade> getGrade(int student_id);
	
	//学生选课：需要course_id和student_id
	void selectCourse(Grade grade);
	
	//教师添加成绩,需要course_id和分数(grade)
	void addGrade(Grade grade);
	
	//根据course_id列出该课程的所有学生信息
	List<Grade> getAllStudentInCourse(int course_id);
}
