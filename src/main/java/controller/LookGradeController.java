package controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import exception.StudentException;
import pojo.Grade;
import pojo.GradeModel;
import service.GradeService;

/**
 *学生查看成绩处理类 
 */

@Controller
@RequestMapping("/grade")
public class LookGradeController {
	
	@Autowired
	private GradeService gradeService;
	
	//查看选修课成绩
	@RequestMapping(value="/lookGrade.do",method=RequestMethod.GET)
	public ModelAndView lookGrade(int student_id) throws StudentException {
		
		try{
			
			List<Grade> gradeList = gradeService.getGrade(student_id);
			ModelAndView mav = new ModelAndView("student/lookGrade");
			mav.addObject("gradeList", gradeList);
			return mav;
		} catch(Exception e) {
			throw new StudentException(e.toString());
		}
		
	}
	
	
	//教师添加成绩:GET方法用于列出该课程下的所有学生，然后添加grade到List<Grade>中，批量添加
	@RequestMapping(value="/addGrade.do",method=RequestMethod.GET)
	public ModelAndView addGrade(Integer course_id) throws StudentException {
		
		try{
			
			//gradeList中 有 course_id，course_name,student_id,student_name
			//送至addGrade.jsp页面中的表单显示，然后收集教师的添加的成绩送至post方法，保存到数据表中
			List<Grade> gradeList = gradeService.getAllStudentInCourse(course_id);
			ModelAndView mav = new ModelAndView("teacher/addGrade");
			mav.addObject("gradeList", gradeList);
			return mav;
		} catch(Exception e) {
			throw new StudentException(e.toString());
		}
		
	}
	
	
	
	@RequestMapping(value="/addGrade.do",method=RequestMethod.POST)
	public String addGradePOST(GradeModel gradeModel) throws StudentException {
		// 后台获取foreach表单的list集合：
		//			1. 创建一个GradeModel，里面封装了一个grade的list，名为gradeList，并有get,set方法
		//			2. 在表单页面 <c:forEach items="${gradeList}" var="gradeList" varStatus="listIndex"  >
		//					<input name="gradeList[${listIndex-1}].course_id" />
		//					<input name="gradeList[${listIndex-1}].student_id" />  
		//					<input name="gradeList[${listIndex-1}].grade" />
		//		
		//			3.controller层接收时：使用参数 GradeModel gradeModel，于是表单中的gradeList就会set给gradeModel中的字段gradeList
		//
		//
		
		try{
			List<Grade> gradeList = gradeModel.getGradeList();
			for(Grade grade:gradeList) {   //批量添加
				gradeService.addGrade(grade);
			}
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("teacher", "");
			return "message/teacher" ; //显示添加后的数据
		} catch(Exception e) {
			throw new StudentException(e.toString());
		}
		
	}
	
}
