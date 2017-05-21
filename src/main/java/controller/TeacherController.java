package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Course;
import pojo.Teacher;
import service.TeacherService;
import validator.ValidatorGroup1;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	
	
	//列出教师的课程
	@RequestMapping("/listTeacherCourse.do")
	public @ResponseBody List<Course> listTeacherCourse(Integer id) throws Exception{
		List<Course> listCourse = teacherService.getTeacherCourses(id);
		
		return listCourse;
	}
	
	
	
	
	
	//登录
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String loginGet(@ModelAttribute("teacher") Teacher teacher) {
		
		return "teacher/loginTeacher";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String loginPost( HttpServletRequest request,HttpSession session,Model model) {
		
		Teacher teacher = null;
		String idString = request.getParameter("id");
		String password = request.getParameter("password");
		if(idString!=null&&!idString.equals("")) {
			int id  = Integer.parseInt(idString);
			teacher = teacherService.getTeacher(id);
			if(password.equals(teacher.getPassword())) {
				List<Course> listCourse = teacherService.getTeacherCourses(id);
				session.setAttribute("teacher", teacher);
				session.setAttribute("user", teacher.getTeacher_name());  //用于拦截器登录判断
				model.addAttribute("listCourse", listCourse);
    			return "message/teacher";  //跳到老师信息页面
			}
		}
		
		request.setAttribute("IdOrPwdError", "编号或密码输入错误");
		return "teacher/loginTeacher";  //重新登录
	}
	
	
	
	//注册
	@RequestMapping(value="/register.do",method=RequestMethod.GET)
	public String registerGet(@ModelAttribute("teacher") Teacher teacher) {
		return "teacher/registerTeacher";
	}
	
	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	public String registerPost(@ModelAttribute("teacher") @Validated(value={ValidatorGroup1.class}) Teacher teacher,BindingResult bindingResult) {
														//表示只校验有该分组的字段，ValidatorGroup1单纯用于分组标记的接口
		if(bindingResult.hasErrors()) {
			return "teacher/registerTeacher";
		}
		
		teacherService.saveTeacher(teacher);
		
		
		return "message/teacher";  //跳到管理信息界面
	}
	
}
