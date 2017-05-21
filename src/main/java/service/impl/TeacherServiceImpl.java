package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TeacherDao;
import pojo.Course;
import pojo.Teacher;
import service.TeacherService;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{
	@Autowired  
	private TeacherDao teacherDao;
	
	
	@Override
	public Teacher getTeacher(int id) {
		return	teacherDao.getTeacher(id);
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherDao.getAllTeachers();
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		teacherDao.saveTeacher(teacher);
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		teacherDao.deleteTeacher(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		teacherDao.updateTeacher(teacher);
		
	}

	@Override
	public List<Course> getTeacherCourses(int teacher_id) {
		return teacherDao.getTeacherCourses(teacher_id);
	}

}
