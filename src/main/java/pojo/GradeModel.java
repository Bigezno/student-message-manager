package pojo;

import java.util.List;

public class GradeModel {
	private List<Grade> gradeList;      //用于批量表单提交时  批量绑定Grade为一个List

	public List<Grade> getGradeList() {
		return this.gradeList;
	}

	public void setGradeList(List<Grade> gradeList) {
		this.gradeList = gradeList;
	}
}
