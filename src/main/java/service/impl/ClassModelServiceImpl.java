package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClassModelDao;
import pojo.ClassModel;
import service.ClassModelService;

@Service("classModelService")
public class ClassModelServiceImpl implements ClassModelService {

	@Autowired
	private ClassModelDao classModelDao;
	
	@Override
	public ClassModel getClassModel(int class_id) {
		
		return classModelDao.getClassModel(class_id);
	}

	@Override
	public List<ClassModel> getAllClassModel() {
		return classModelDao.getAllClassModel();
	}

	@Override
	public void saveClassModel(ClassModel classModel) {
		classModelDao.saveClassModel(classModel);
	}

	@Override
	public void deleteClassModel(ClassModel classModel) {
		classModelDao.deleteClassModel(classModel);
	}

	@Override
	public void updateClassModel(ClassModel classModel) {
		classModelDao.updateClassModel(classModel);
	}

}
