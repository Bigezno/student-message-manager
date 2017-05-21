package dao;

import java.util.List;

import pojo.Course;

public interface CourseDao {
	
	//根据course_id查找该课程详细信息
	Course getCourse(int course_id);
	
	//列出所有课程信息
	List<Course> getAllCourses();
	
	//添加
	void saveCourse(Course course);
	
	//删除
	void deleteCourse(Course course);
		
	//修改
	void updateCourse(Course course);
}
