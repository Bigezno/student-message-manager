package dao;

import java.util.List;

import pojo.Student;

public interface StudentDao {
	
	Student getStudent(int id); //查找一个用户
	
	List<Student> getAllStudents();//查找所有用户信息
	
	void saveStudent(Student student); //添加
	
	void deleteStudent(Student student); //删除
	
	void updateStudent(Student student); //修改
}
