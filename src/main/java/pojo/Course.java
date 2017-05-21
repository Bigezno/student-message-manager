package pojo;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int course_id;  //课程id

	@NotNull(message = "课程名不能为空")
	private String course_name;  // 课程名

	@NotNull(message = "时间不能为空")
	private String time;      //授课时间

	@NotNull(message = "地点不能为空")
	private String address;  //授课地点

	@NotNull(message = "教师编号不能为空")
	private int teacher_id;
	private Teacher teacher;  //一对一关联，实现查找该课程的授课教师信息
	private List<Student> studentList;  // 一对多关联，实现查找该课程下的所有学生

	public int getTeacher_id() {
		return this.teacher_id;
	}

	
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getCourse_id() {
		return this.course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return this.course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudentList() {
		return this.studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public String toString() {
		return "Course [course_id=" + this.course_id + ", course_name=" + this.course_name + ", time=" + this.time
				+ ", address=" + this.address + ", teacher=" + this.teacher + "]";
	}
}

