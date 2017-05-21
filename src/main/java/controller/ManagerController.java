package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.ClassModel;
import pojo.Course;
import pojo.Manager;
import pojo.Student;
import pojo.Teacher;
import service.ClassModelService;
import service.CourseService;
import service.StudentService;
import service.TeacherService;
import validator.ValidatorGroup1;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired  
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private ClassModelService classModelService;
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public ModelAndView loginGet() {
		ModelAndView mav = new ModelAndView("manager/loginManager");
		mav.addObject("manager", new Manager());
		return mav;
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String loginPost(@ModelAttribute("manager") 
							@Validated(value={ValidatorGroup1.class}) Manager manager,
							BindingResult bindingResult,
							HttpSession session) {
		
		
		
		if(bindingResult.hasErrors()) {
			return "manager/loginManager";
		}
		session.setAttribute("user", manager.getManager_name()); //用于拦截器登录判断
		
		return "message/manager";  //跳到管理信息界面
	}
	
	
	//教师列表页面
	@RequestMapping(value="/allteacherMessage.do",method=RequestMethod.GET)
	public ModelAndView allstudentMessage() {
		
		//列出所有教师
		List<Teacher> listTeacher = teacherService.getAllTeachers();
		ModelAndView mav = new ModelAndView("manager/allteacherMessage");
		mav.addObject("listTeacher", listTeacher);
		
		return mav ;
	}
	
	// 学生列表页面
	@RequestMapping(value="/allstudentMessage.do",method=RequestMethod.GET)
	public ModelAndView allteacherMessage() {
		
		//列出所有学生
		List<Student> listStudent = studentService.getAllStudents();
		
		ModelAndView mav = new ModelAndView("manager/allstudentMessage");
		mav.addObject("listStudent", listStudent);
		
		return mav;
	}
	
	//班级列表页面
	@RequestMapping(value = "/allclassMessage.do", method = RequestMethod.GET)
	public ModelAndView allcourseMessage() {
		
		//列出所有班级
		List<ClassModel> listClassModel = classModelService.getAllClassModel();
		ModelAndView mav = new ModelAndView("manager/allclassMessage");
		mav.addObject("listClassModel", listClassModel);

		return mav;
	}
	
	
	//课程列表页面
	@RequestMapping(value="/allcourseMessage.do",method=RequestMethod.GET)
	public ModelAndView allclassMessage() {
		
		//列出所有课程
		List<Course> listCourse= courseService.getAllCourses();
		ModelAndView mav = new ModelAndView("manager/allcourseMessage");
		mav.addObject("listCourse", listCourse);
		
		
		return mav;
	}
	
	
}
