package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.StudentDao;
import pojo.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Student getStudent(int id) {
		return studentDao.getStudent(id);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public void saveStudent(Student student) {
		studentDao.saveStudent(student);
	}

	@Override
	public void deleteStudent(Student student) {
		studentDao.deleteStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);		
	}
}
