package pojo;

import java.io.Serializable;
import java.util.List;

public class ClassModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int class_id;   //班级id
	private String class_name;   //班级名称
	private List<Student> studentList;  //一对多关联，用于实现 列出该班级下的 学生 

	public int getClass_id() {
		return this.class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return this.class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public List<Student> getStudentList() {
		return this.studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public String toString() {
		return "ClassModel [class_id=" + this.class_id + ", class_name=" + this.class_name + ", studentList="
				+ this.studentList + "]";
	}
}
