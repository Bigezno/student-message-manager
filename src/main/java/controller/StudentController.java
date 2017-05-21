package controller;


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

import pojo.Student;
import service.StudentService;
import validator.ValidatorGroup1;

@Controller
@RequestMapping("/student")
public class StudentController {
	// 注入studentService 对象  
    @Autowired  
    private StudentService studentService;
	
    
    //在所有功能处理方法之前在模型数据中绑定一个student对象
    @ModelAttribute("student")  //ModelMap 中的属性作用域是 request 级别
    public Student student() {
       return new Student();
    }
    
    
    //修改学生信息
    @RequestMapping(value="/updateStudent.do",method=RequestMethod.GET)
    public String updateStudent(int id,Model model) {
    	Student student = studentService.getStudent(id);
    	model.addAttribute("student", student);  //可以覆盖模型数据中同名的模型数据
		return "student/updateStudent";  
    }
    
    
    @RequestMapping(value="/updateStudent.do",method=RequestMethod.POST)
    public String updateStudentSuccess(@ModelAttribute("student") @Validated(value={ValidatorGroup1.class}) Student student,BindingResult bindingResult) {
    	System.out.println(student);
		
    	//1.验证参数输入是否正确,错误则跳回修改界面，同时使用errors标签回显错误信息
    	if (bindingResult.hasErrors()) {
    		    return null; //返回原始页面
    	}
    	
    	//2.保存修改过后的学生信息到数据库中
    	studentService.updateStudent(student);
    
		
		return "message/student";  //跳到学生信息页面
    	
    }
    
    
    
    @RequestMapping(value="/login.do",method=RequestMethod.GET)
    public String loginStudentGet() {
    	return "student/loginStudent";  //跳转到loginStudent.jsp页面去登录
    }
    
    @RequestMapping(value="/login.do",method=RequestMethod.POST)
    public String loginStudentPost(HttpServletRequest request,Model model,HttpSession session) {
    	//1.先检测 图片验证码,而不是去检测表单数据，因为检测数据要操作数据库，造成时间开销
    	String validateCode = request.getParameter("validateCode");
    	String checkcode = (String) request.getSession().getAttribute("checkcode");
    	
    	if(validateCode.equals("")||!checkcode.equalsIgnoreCase(validateCode)){  //如果验证码不对，则显示错误
			request.setAttribute("message", "验证码输入错误");
			return "student/loginStudent";
		}
    	
    	String idString = request.getParameter("student_id");
    	String password = request.getParameter("password");
    	
    	if(idString==null||idString.equals("")) {
    		request.setAttribute("IdOrPwdError", "学号不能为空");
    		return "student/loginStudent";
    	} else {
    		int id = Integer.parseInt(idString);
    		Student student = studentService.getStudent(id);
//    		System.out.println("student.id="+student.getId());
    		
    		if(student!=null&&student.getPassword().equals(password)) {
    			model.addAttribute("student", student);  //可以覆盖模型数据中同名的模型数据
    			session.setAttribute("user", student.getStudent_name());  //用于拦截器登录判断
    			return "message/student";  //跳到学生信息页面
    		}
    	}
    	
    	request.setAttribute("IdOrPwdError", "学号或密码输入错误");
    	return "student/loginStudent";  
    }
    
    
    @RequestMapping("/register.do")
    public String registerStudent() {
    	return "student/registerStudent";  //跳转到registerStudent.jsp页面去注册
    }
    
    //1.绑定注册页面表单传递上来的数据，进行数据类型转换，验证，然后格式化输出
    @RequestMapping(value="/save.do",method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") @Validated(value={ValidatorGroup1.class}) Student student,BindingResult bindingResult){
		System.out.println(student);
		
		//1.验证参数输入是否正确,错误则跳回注册界面，同时使用errors标签回显错误信息
		if (bindingResult.hasErrors()) {
	         return null; //返回原始页面
	    }
		
		//1.保存学生信息到数据库中
		studentService.saveStudent(student);
		
		return "message/student";  //跳到学生信息页面
	}
    
}
