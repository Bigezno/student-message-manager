package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *提供通用的学生，老师，管理员登录和注册服务
 *根据jsp页面传递的请求参数来区分不同的角色登录和注册，然后将请求转发到不同的controller处理
 */

@Controller
public class LoginAndRegisterController {
	
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
    public String login(HttpServletRequest request) {
		//获取从主页中输入的登录角色，跳转到相应的登录界面
    	String loginTarget = request.getParameter("loginTarget");
		if(loginTarget.equals("student")) {
			return "redirect:/student/login.do";
		} else if(loginTarget.equals("teacher")) {
			return "redirect:/teacher/login.do";
		} else {
			return "redirect:/manager/login.do";
		}
    	
    }
    
    
	@RequestMapping(value="/register.do",method=RequestMethod.POST)
    public String register(HttpServletRequest request) {
    	
    	String registerTarget = request.getParameter("registerTarget");
    	if(registerTarget.equals("student")) {
			return "redirect:/student/register.do";
		} else  {
			return "redirect:/teacher/register.do";
		} 
    	
    }
}
