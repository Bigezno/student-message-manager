package pojo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import validator.ValidatorGroup1;

public class Teacher implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	//teacher_id,teacher_name,password,email
	
	private int teacher_id;
	
	@NotNull(message="姓名不能为空",groups=ValidatorGroup1.class)
	private String teacher_name;
	
	@NotNull(message="密码不能为空",groups=ValidatorGroup1.class)
	private String password;
	
	@Email(groups=ValidatorGroup1.class)
	private String email;

	
	private List<Course> courseList;
	
	
	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", password=" + password
				+ ", email=" + email + ", courseList=" + courseList + "]";
	}

	
	
	
	
	
	
	
	
}
