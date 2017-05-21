package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GradeDao;
import pojo.Grade;
import service.GradeService;

@Service("gradeService")
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDao gradeDao;
	
	@Override
	public List<Grade> getGrade(int student_id) {
		return gradeDao.getGrade(student_id);
	}

	@Override
	public void selectCourse(Grade grade) {
		gradeDao.selectCourse(grade);

	}

	@Override
	public void addGrade(Grade grade) {
		gradeDao.addGrade(grade);
	}

	@Override
	public List<Grade> getAllStudentInCourse(int course_id) {
		return gradeDao.getAllStudentInCourse(course_id);
	}

}
