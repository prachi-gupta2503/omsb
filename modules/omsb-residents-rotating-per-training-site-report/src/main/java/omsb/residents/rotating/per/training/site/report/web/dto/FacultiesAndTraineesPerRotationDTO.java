package omsb.residents.rotating.per.training.site.report.web.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FacultiesAndTraineesPerRotationDTO {

	public FacultiesAndTraineesPerRotationDTO() {
		super();
	}

	private String rotationName;
	private long rotationId;
	private int noOfFaculty;
	private Set<String> facultyNameList = new HashSet<>();
	
	private int traineesInProgramBlock1 = 0;
	private int traineesNotInProgramBlock1 = 0;
	private int traineesInProgramBlock2 = 0;
	private int traineesNotInProgramBlock2 = 0;
	private int traineesInProgramBlock3 = 0;
	private int traineesNotInProgramBlock3 = 0;
	private int traineesInProgramBlock4 = 0;
	private int traineesNotInProgramBlock4 = 0;
	private int traineesInProgramBlock5 = 0;
	private int traineesNotInProgramBlock5 = 0;
	private int traineesInProgramBlock6 = 0;
	private int traineesNotInProgramBlock6 = 0;
	private int traineesInProgramBlock7 = 0;
	private int traineesNotInProgramBlock7 = 0;
	private int traineesInProgramBlock8 = 0;
	private int traineesNotInProgramBlock8 = 0;
	private int traineesInProgramBlock9 = 0;
	private int traineesNotInProgramBlock9 = 0;
	private int traineesInProgramBlock10 = 0;
	private int traineesNotInProgramBlock10 = 0;
	private int traineesInProgramBlock11 = 0;
	private int traineesNotInProgramBlock11 = 0;
	private int traineesInProgramBlock12 = 0;
	private int traineesNotInProgramBlock12 = 0;
	private int traineesInProgramBlock13 = 0;
	private int traineesNotInProgramBlock13 = 0;
	
	public int getTotalTraineesInRotation() {
		return traineesInProgramBlock1 + traineesNotInProgramBlock1+traineesInProgramBlock2+traineesNotInProgramBlock2+
				traineesInProgramBlock3+traineesNotInProgramBlock3+traineesInProgramBlock4+traineesNotInProgramBlock4+
				traineesInProgramBlock5+traineesNotInProgramBlock5+traineesInProgramBlock6+traineesNotInProgramBlock6+
				traineesInProgramBlock7+traineesNotInProgramBlock7+traineesInProgramBlock8+traineesNotInProgramBlock8+
				traineesInProgramBlock9+traineesNotInProgramBlock9+traineesInProgramBlock10+traineesNotInProgramBlock10+
				traineesInProgramBlock11+traineesNotInProgramBlock11+traineesInProgramBlock12+traineesNotInProgramBlock12+
				traineesInProgramBlock13+traineesNotInProgramBlock13;
	}
	
	public void addBlockInfo(int blockNo, int traineesInProgram, int traineesNotInProgram) {
		switch (blockNo) {
		case 1:
			traineesInProgramBlock1 = traineesInProgram;
			traineesNotInProgramBlock1 = traineesNotInProgram;
			break;
		case 2:
			traineesInProgramBlock2 = traineesInProgram;
			traineesNotInProgramBlock2 = traineesNotInProgram;
			break;
		case 3:
			traineesInProgramBlock3 = traineesInProgram;
			traineesNotInProgramBlock3 = traineesNotInProgram;
			break;
		case 4:
			traineesInProgramBlock4 = traineesInProgram;
			traineesNotInProgramBlock4 = traineesNotInProgram;
			break;
		case 5:
			traineesInProgramBlock5 = traineesInProgram;
			traineesNotInProgramBlock5 = traineesNotInProgram;
			break;
		case 6:
			traineesInProgramBlock6 = traineesInProgram;
			traineesNotInProgramBlock6 = traineesNotInProgram;
			break;
		case 7:
			traineesInProgramBlock7 = traineesInProgram;
			traineesNotInProgramBlock7 = traineesNotInProgram;
			break;
		case 8:
			traineesInProgramBlock8 = traineesInProgram;
			traineesNotInProgramBlock8 = traineesNotInProgram;
			break;
		case 9:
			traineesInProgramBlock9 = traineesInProgram;
			traineesNotInProgramBlock9 = traineesNotInProgram;
			break;
		case 10:
			traineesInProgramBlock10 = traineesInProgram;
			traineesNotInProgramBlock10 = traineesNotInProgram;
			break;
		case 11:
			traineesInProgramBlock11 = traineesInProgram;
			traineesNotInProgramBlock11 = traineesNotInProgram;
			break;
		case 12:
			traineesInProgramBlock12 = traineesInProgram;
			traineesNotInProgramBlock12 = traineesNotInProgram;
			break;
		case 13:
			traineesInProgramBlock13 = traineesInProgram;
			traineesNotInProgramBlock13 = traineesNotInProgram;
			break;
		}
		
	}
	
	public void addFaculty(String facultyName) {
		facultyNameList.add(facultyName);
	}
	
	public Set<String> getFacultyNameList() {
		return facultyNameList;
	}
	public void setFacultyNameList(Set<String> facultyNameList) {
		this.facultyNameList = facultyNameList;
	}
	public String getRotationName() {
		return rotationName;
	}
	public int getNoOfFaculty() {
		return noOfFaculty;
	}
	
	public int getTraineesInProgramBlock1() {
		return traineesInProgramBlock1;
	}
	public int getTraineesNotInProgramBlock1() {
		return traineesNotInProgramBlock1;
	}
	public int getTraineesInProgramBlock2() {
		return traineesInProgramBlock2;
	}
	public int getTraineesNotInProgramBlock2() {
		return traineesNotInProgramBlock2;
	}
	public int getTraineesInProgramBlock3() {
		return traineesInProgramBlock3;
	}
	public int getTraineesNotInProgramBlock3() {
		return traineesNotInProgramBlock3;
	}
	public int getTraineesInProgramBlock4() {
		return traineesInProgramBlock4;
	}
	public int getTraineesNotInProgramBlock4() {
		return traineesNotInProgramBlock4;
	}
	public int getTraineesInProgramBlock5() {
		return traineesInProgramBlock5;
	}
	public int getTraineesNotInProgramBlock5() {
		return traineesNotInProgramBlock5;
	}
	public int getTraineesInProgramBlock6() {
		return traineesInProgramBlock6;
	}
	public int getTraineesNotInProgramBlock6() {
		return traineesNotInProgramBlock6;
	}
	public int getTraineesInProgramBlock7() {
		return traineesInProgramBlock7;
	}
	public int getTraineesNotInProgramBlock7() {
		return traineesNotInProgramBlock7;
	}
	public int getTraineesInProgramBlock8() {
		return traineesInProgramBlock8;
	}
	public int getTraineesNotInProgramBlock8() {
		return traineesNotInProgramBlock8;
	}
	public int getTraineesInProgramBlock9() {
		return traineesInProgramBlock9;
	}
	public int getTraineesNotInProgramBlock9() {
		return traineesNotInProgramBlock9;
	}
	public int getTraineesInProgramBlock10() {
		return traineesInProgramBlock10;
	}
	public int getTraineesNotInProgramBlock10() {
		return traineesNotInProgramBlock10;
	}
	public int getTraineesInProgramBlock11() {
		return traineesInProgramBlock11;
	}
	public int getTraineesNotInProgramBlock11() {
		return traineesNotInProgramBlock11;
	}
	public int getTraineesInProgramBlock12() {
		return traineesInProgramBlock12;
	}
	public int getTraineesNotInProgramBlock12() {
		return traineesNotInProgramBlock12;
	}
	public int getTraineesInProgramBlock13() {
		return traineesInProgramBlock13;
	}
	public int getTraineesNotInProgramBlock13() {
		return traineesNotInProgramBlock13;
	}
	public void setRotationName(String rotationName) {
		this.rotationName = rotationName;
	}
	public void setNoOfFaculty(int noOfFaculty) {
		this.noOfFaculty = noOfFaculty;
	}

	public void setTraineesInProgramBlock1(int traineesInProgramBlock1) {
		this.traineesInProgramBlock1 = traineesInProgramBlock1;
	}
	public void setTraineesNotInProgramBlock1(int traineesNotInProgramBlock1) {
		this.traineesNotInProgramBlock1 = traineesNotInProgramBlock1;
	}
	public void setTraineesInProgramBlock2(int traineesInProgramBlock2) {
		this.traineesInProgramBlock2 = traineesInProgramBlock2;
	}
	public void setTraineesNotInProgramBlock2(int traineesNotInProgramBlock2) {
		this.traineesNotInProgramBlock2 = traineesNotInProgramBlock2;
	}
	public void setTraineesInProgramBlock3(int traineesInProgramBlock3) {
		this.traineesInProgramBlock3 = traineesInProgramBlock3;
	}
	public void setTraineesNotInProgramBlock3(int traineesNotInProgramBlock3) {
		this.traineesNotInProgramBlock3 = traineesNotInProgramBlock3;
	}
	public void setTraineesInProgramBlock4(int traineesInProgramBlock4) {
		this.traineesInProgramBlock4 = traineesInProgramBlock4;
	}
	public void setTraineesNotInProgramBlock4(int traineesNotInProgramBlock4) {
		this.traineesNotInProgramBlock4 = traineesNotInProgramBlock4;
	}
	public void setTraineesInProgramBlock5(int traineesInProgramBlock5) {
		this.traineesInProgramBlock5 = traineesInProgramBlock5;
	}
	public void setTraineesNotInProgramBlock5(int traineesNotInProgramBlock5) {
		this.traineesNotInProgramBlock5 = traineesNotInProgramBlock5;
	}
	public void setTraineesInProgramBlock6(int traineesInProgramBlock6) {
		this.traineesInProgramBlock6 = traineesInProgramBlock6;
	}
	public void setTraineesNotInProgramBlock6(int traineesNotInProgramBlock6) {
		this.traineesNotInProgramBlock6 = traineesNotInProgramBlock6;
	}
	public void setTraineesInProgramBlock7(int traineesInProgramBlock7) {
		this.traineesInProgramBlock7 = traineesInProgramBlock7;
	}
	public void setTraineesNotInProgramBlock7(int traineesNotInProgramBlock7) {
		this.traineesNotInProgramBlock7 = traineesNotInProgramBlock7;
	}
	public void setTraineesInProgramBlock8(int traineesInProgramBlock8) {
		this.traineesInProgramBlock8 = traineesInProgramBlock8;
	}
	public void setTraineesNotInProgramBlock8(int traineesNotInProgramBlock8) {
		this.traineesNotInProgramBlock8 = traineesNotInProgramBlock8;
	}
	public void setTraineesInProgramBlock9(int traineesInProgramBlock9) {
		this.traineesInProgramBlock9 = traineesInProgramBlock9;
	}
	public void setTraineesNotInProgramBlock9(int traineesNotInProgramBlock9) {
		this.traineesNotInProgramBlock9 = traineesNotInProgramBlock9;
	}
	public void setTraineesInProgramBlock10(int traineesInProgramBlock10) {
		this.traineesInProgramBlock10 = traineesInProgramBlock10;
	}
	public void setTraineesNotInProgramBlock10(int traineesNotInProgramBlock10) {
		this.traineesNotInProgramBlock10 = traineesNotInProgramBlock10;
	}
	public void setTraineesInProgramBlock11(int traineesInProgramBlock11) {
		this.traineesInProgramBlock11 = traineesInProgramBlock11;
	}
	public void setTraineesNotInProgramBlock11(int traineesNotInProgramBlock11) {
		this.traineesNotInProgramBlock11 = traineesNotInProgramBlock11;
	}
	public void setTraineesInProgramBlock12(int traineesInProgramBlock12) {
		this.traineesInProgramBlock12 = traineesInProgramBlock12;
	}
	public void setTraineesNotInProgramBlock12(int traineesNotInProgramBlock12) {
		this.traineesNotInProgramBlock12 = traineesNotInProgramBlock12;
	}
	public void setTraineesInProgramBlock13(int traineesInProgramBlock13) {
		this.traineesInProgramBlock13 = traineesInProgramBlock13;
	}
	public void setTraineesNotInProgramBlock13(int traineesNotInProgramBlock13) {
		this.traineesNotInProgramBlock13 = traineesNotInProgramBlock13;
	}
	public long getRotationId() {
		return rotationId;
	}
	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}
	
	@Override
	public String toString() {
		return "FacultiesAndTraineesPerRotationDTO [rotationName=" + rotationName + ", rotationId=" + rotationId
				+ ", noOfFaculty=" + noOfFaculty + ", facultyNameList=" + facultyNameList + ", traineesInProgramBlock1="
				+ traineesInProgramBlock1 + ", traineesNotInProgramBlock1=" + traineesNotInProgramBlock1
				+ ", traineesInProgramBlock2=" + traineesInProgramBlock2 + ", traineesNotInProgramBlock2="
				+ traineesNotInProgramBlock2 + ", traineesInProgramBlock3=" + traineesInProgramBlock3
				+ ", traineesNotInProgramBlock3=" + traineesNotInProgramBlock3 + ", traineesInProgramBlock4="
				+ traineesInProgramBlock4 + ", traineesNotInProgramBlock4=" + traineesNotInProgramBlock4
				+ ", traineesInProgramBlock5=" + traineesInProgramBlock5 + ", traineesNotInProgramBlock5="
				+ traineesNotInProgramBlock5 + ", traineesInProgramBlock6=" + traineesInProgramBlock6
				+ ", traineesNotInProgramBlock6=" + traineesNotInProgramBlock6 + ", traineesInProgramBlock7="
				+ traineesInProgramBlock7 + ", traineesNotInProgramBlock7=" + traineesNotInProgramBlock7
				+ ", traineesInProgramBlock8=" + traineesInProgramBlock8 + ", traineesNotInProgramBlock8="
				+ traineesNotInProgramBlock8 + ", traineesInProgramBlock9=" + traineesInProgramBlock9
				+ ", traineesNotInProgramBlock9=" + traineesNotInProgramBlock9 + ", traineesInProgramBlock10="
				+ traineesInProgramBlock10 + ", traineesNotInProgramBlock10=" + traineesNotInProgramBlock10
				+ ", traineesInProgramBlock11=" + traineesInProgramBlock11 + ", traineesNotInProgramBlock11="
				+ traineesNotInProgramBlock11 + ", traineesInProgramBlock12=" + traineesInProgramBlock12
				+ ", traineesNotInProgramBlock12=" + traineesNotInProgramBlock12 + ", traineesInProgramBlock13="
				+ traineesInProgramBlock13 + ", traineesNotInProgramBlock13=" + traineesNotInProgramBlock13 + "]";
	}
	
	
	
	
	
	
}
