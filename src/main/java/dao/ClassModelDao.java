package dao;

import java.util.List;

import pojo.ClassModel;


public interface ClassModelDao {
	
	//根据班级id，查询班级信息（班级名，该班级学生）
	ClassModel getClassModel(int class_id);
	
	//列出所有班级（班级id，班级名，不包括班级下学生）
	List<ClassModel> getAllClassModel();
	
	//添加一个班级
	void saveClassModel(ClassModel classModel);
	
	//删除一个班级：仅仅管理员能用，慎重
	void deleteClassModel(ClassModel classModel);
	
	//修改一个班级：只能修改班级名
	void updateClassModel(ClassModel classModel);
	
}
