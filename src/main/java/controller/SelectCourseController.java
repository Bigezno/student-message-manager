package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.Course;
import pojo.Grade;
import pojo.Student;
import service.CourseService;
import service.GradeService;
import service.StudentService;
@Controller
@RequestMapping("course")
public class SelectCourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private StudentService studentService;
	
	private int s_id;
	
	//保存course_id和对应的teacher_id的map
	private Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	@RequestMapping(value="/selectCourse.do",method=RequestMethod.GET) 
	public ModelAndView getCourseMessage(int student_id) {
		
		// 列出所有课程
		List<Course> listCourse = courseService.getAllCourses();
		
		//用于给map添加teacher_id和course_id，支持学生选课
		for(Course course:listCourse){
			map.put(course.getCourse_id(), course.getTeacher().getTeacher_id());
		}
		
 		
		s_id = student_id;  //用于post方法，定位学生选课使用
		
		ModelAndView mav = new ModelAndView("course/selectcourse");
		mav.addObject("listCourse", listCourse);

		return mav;
	}
	
	
	//收集学生从selectcourse页面传上来的课程信息
	@RequestMapping(value="/selectCourse.do",method=RequestMethod.POST) 
	public ModelAndView getCourseMessagePOST(HttpServletRequest request) throws Exception{
		
		String [] courseIDs = request.getParameterValues("select_course"); //获取表单中所选课程的id(复选框)
		
		if(courseIDs==null||courseIDs.length==0) { //如果课程未选，则跳回
			ModelAndView mav = new ModelAndView("message/student");
			return mav;
		}
		
		for(String course_id:courseIDs) {  //选了多条
			int id = Integer.parseInt(course_id);
			Grade grade = new Grade();
			System.out.println(id);
			//这里出了问题
			grade.setCourse_id(id);
			grade.setStudent_id(s_id); 
			grade.setTeacher_id(map.get(id)); //根据course_id来取出teacher_id
			
			gradeService.selectCourse(grade);//学生选课,即添加一条grade表中的记录
		}
		
		ModelAndView mav = new ModelAndView("message/student");
		Student student = studentService.getStudent(s_id);
		mav.addObject("student", student);
		return mav;
	}
	
	
}
