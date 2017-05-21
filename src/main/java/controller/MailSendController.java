package controller;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import exception.StudentException;
import pojo.Teacher;
import service.TeacherService;

@Controller
public class MailSendController {
	
	@Resource(name="teacherService")
	private TeacherService teacherService;
	
	@Resource(name = "mailSender")
    private JavaMailSenderImpl sender;
    @Resource(name = "mailTaskExecutor")
    private TaskExecutor taskExecutor;
    
    
    private int t_id = 0;
    
    
    @RequestMapping(value = "/findword.do",method = RequestMethod.POST)
    public String toTest( String id) throws MessagingException, StudentException {
    	try {
    		 t_id = Integer.parseInt(id);
    	}catch (Exception e) {
    		throw new StudentException("请输入正确的教师编号");
    	}
    	
    	if(t_id==0){
    		throw new StudentException("请输入正确的教师编号");
    	}
    	 
    	Teacher teacher = teacherService.getTeacher(t_id);
    	
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender.getUsername());
        
        message.setTo(teacher.getEmail());
        message.setSubject("密码找回邮件");
       
        String time = String.valueOf(System.currentTimeMillis()); //时间戳
		String urlAddress = "<a href='http://localhost:8080/student-message-manamger/getword.do?time='"+time+">点击链接找回密码(半小时内有效) </a><br/> ";
		String hint = "<br/><br/>如果上述链接被邮箱屏蔽，请登录该网址进行校验(半小时内有效): http://localhost:8080/student-message-manamger/getword.do?time="+time;
		//message.setContent(urlAddress+hint,"text/html;charset=utf-8");
		 message.setText(urlAddress+hint);
        taskExecutor.execute(()->{
            sender.send(message);
        });
        return "teacher/loginTeacher";
    }
    
    @RequestMapping(value = "/findword.do",method = RequestMethod.GET)
    public ModelAndView findPWD()  {
    	ModelAndView model = new ModelAndView("findpassword");
        model.addObject("key_form", true);
        return model;
    }
    
    
    @RequestMapping(value = "/getword.do",method = RequestMethod.GET)
    public ModelAndView getPWD(String time)  {
    	ModelAndView model = new ModelAndView();
        if(time==null){
        	model.setViewName("error");
        	return model;
        }else {
        	long lastTime = Long.parseLong(time);
			long nowTime = System.currentTimeMillis();
			if (nowTime - lastTime <= 1000 * 60) {  //1分钟失效
				model.setViewName("error");
				model.addObject("errorMessage", "链接已失效");
				return model;
			}
        }
        model.setViewName("findpassword");
        model.addObject("key", true);
        model.addObject("pwd", teacherService.getTeacher(t_id).getPassword());
        return model;
    }
    
}
