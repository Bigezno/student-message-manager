package service;

import java.util.List;

import pojo.Student;

public interface StudentService {
	
	Student getStudent(int id); //查找一个学生
	
	List<Student> getAllStudents();//列出所有
	
	void saveStudent(Student student); //添加
	
	void deleteStudent(Student student); //删除
	
	void updateStudent(Student student); //修改
	
}
