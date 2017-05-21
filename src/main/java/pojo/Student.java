package pojo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import validator.Sex;
import validator.ValidatorGroup1;
import validator.phone;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int student_id;   // 学号
	private int class_id;
	
	@Size(min=1,max=20,message="{username.not.illegal}",groups=ValidatorGroup1.class)
	@NotNull(message ="{username.not.empty}",groups=ValidatorGroup1.class)
	private String student_name; // 姓名
	
	@NotNull(message="{password.not.empty}",groups=ValidatorGroup1.class)  
	@Size(min=6,max=10,message = "{password.not.illegal}",groups=ValidatorGroup1.class)
	private String password; // 密码
	
	@Sex(message="{sex.not.illegal}",groups=ValidatorGroup1.class)
	@NotNull(message ="{sex.not.empty}",groups=ValidatorGroup1.class)
	private String sex; 	// 性别
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message ="{birthday.not.empty}",groups=ValidatorGroup1.class)
	private Date school_date;   // 生日
	
	@phone(message="{phone.not.illegal}",groups=ValidatorGroup1.class)
	@NotNull(message ="{phone.not.empty}",groups=ValidatorGroup1.class)
	private String phone; //电话
	
	@NotNull(message ="{address.not.empty}",groups=ValidatorGroup1.class)
	private String address; //地址
	
	@Email(groups=ValidatorGroup1.class) 
	private String email; //邮箱

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getSchool_date() {
		return school_date;
	}

	public void setSchool_date(Date school_date) {
		this.school_date = school_date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", class_id=" + class_id + ", student_name=" + student_name
				+ ", password=" + password + ", sex=" + sex + ", school_date=" + school_date + ", phone=" + phone
				+ ", address=" + address + ", email=" + email + "]";
	}
	
	
	
	
	
	
	
	
	
}
