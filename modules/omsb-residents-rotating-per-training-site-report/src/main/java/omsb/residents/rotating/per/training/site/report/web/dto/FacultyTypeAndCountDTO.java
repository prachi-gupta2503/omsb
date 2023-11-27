package omsb.residents.rotating.per.training.site.report.web.dto;

public class FacultyTypeAndCountDTO {

	public FacultyTypeAndCountDTO() {
		super();
	}
	
	private String facultyType;
	private int facultyCount;
	
	public String getFacultyType() {
		return facultyType;
	}
	public int getFacultyCount() {
		return facultyCount;
	}
	public void setFacultyType(String facultyType) {
		this.facultyType = facultyType;
	}
	public void setFacultyCount(int facultyCount) {
		this.facultyCount = facultyCount;
	}
	
	@Override
	public String toString() {
		return "FacultyTypeAndCountDTO [facultyType=" + facultyType + ", facultyCount=" + facultyCount + "]";
	}
	
	
}
