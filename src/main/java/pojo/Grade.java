package pojo;

import java.io.Serializable;

public class Grade implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Integer grade_id;
	private Teacher teacher ; //teacher_id--->得到teacher_name
	private Student student;  //student_id --->得到student_name就行了
	private Course course; // course_id ---->得到course_name就行了
	
	private String grade;
	
	
	private Integer teacher_id; //用于教师添加，修改成绩使用
	private Integer student_id;  //用于学生选课，查看成绩使用
	private Integer course_id;  //用于支持上述两个对象操作grade数据表
	
	
	
	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

	public int getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(Integer grade_id) {
		this.grade_id = grade_id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Grade [grade_id=" + grade_id + ", teacher=" + teacher + ", student=" + student + ", course=" + course
				+ ", grade=" + grade + "]";
	}
	
	
	
	
}
