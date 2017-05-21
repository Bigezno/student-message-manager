package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CourseDao;
import pojo.Course;
import service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	
	@Override
	public Course getCourse(int course_id) {
		return courseDao.getCourse(course_id);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseDao.getAllCourses();
	}

	@Override
	public void saveCourse(Course course) {
		courseDao.saveCourse(course);
	}

	@Override
	public void deleteCourse(Course course) {
		courseDao.deleteCourse(course);
	}

	@Override
	public void updateCourse(Course course) {
		courseDao.updateCourse(course);
	}

}
