package course_registeration_Java;

public class Course {

	private String department;
	private String courseNumber;
	private String CRN;
	
	Course(String _department, String _courseNumber,String _CRN){
		this.department = _department;
		this.courseNumber = _courseNumber;
		this.CRN = _CRN;
	}
	
	String getDepartment() {
		return this.department;
	}
	
	String getCourseNumber() {
		return this.courseNumber;
	}
	
	String getCRN() {
		return this.CRN;
	}
	
}
