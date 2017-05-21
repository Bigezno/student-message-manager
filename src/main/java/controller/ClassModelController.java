package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ClassModel;
import service.ClassModelService;



@Controller
@RequestMapping("/classmodel")
public class ClassModelController {

	@Autowired
	private ClassModelService classModelService;
	
	//以Json格式输出,某个班级的所有学生
	@RequestMapping("/listStudent.do")
	public @ResponseBody ClassModel listClassStudent(Integer id) throws Exception{
		
		ClassModel classModel = null;
		if(id!=0||id!=null) {
			classModel = classModelService.getClassModel(id);
		}
		
		return classModel;
	}
	
	
}
