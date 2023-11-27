package omsb.residents.rotating.per.training.site.report.web.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResidentsInEachSitePerBlockDTO {

	private long trainingSiteId;
	private String trainingSiteName;
	private Map<Long,FacultiesAndTraineesPerRotationDTO> facultiesAndTraineesPerRotationDTOMap = new HashMap<>();
	private List<FacultyTypeAndCountDTO> facultyTypeAndCountDTOList;
	
	public int getTotalFacultyCount() {
		int total = 0;
		for (FacultyTypeAndCountDTO facultyTypeAndCountDTO : facultyTypeAndCountDTOList) {
			total += facultyTypeAndCountDTO.getFacultyCount();
		}
		return total;
	}
	
	
	
	public List<FacultyTypeAndCountDTO> getFacultyTypeAndCountDTOList() {
		return facultyTypeAndCountDTOList;
	}



	public void setFacultyTypeAndCountDTOList(List<FacultyTypeAndCountDTO> facultyTypeAndCountDTOList) {
		this.facultyTypeAndCountDTOList = facultyTypeAndCountDTOList;
	}



	public FacultiesAndTraineesPerRotationDTO addFacultiesAndTraineesPerRotationDTO(Long rotationId, FacultiesAndTraineesPerRotationDTO facultiesAndTraineesPerRotationDTO) {
		return facultiesAndTraineesPerRotationDTOMap.put(rotationId, facultiesAndTraineesPerRotationDTO);
	}
	
	public FacultiesAndTraineesPerRotationDTO getFacultiesAndTraineesPerRotationDTO(Long rotationId) {
		return facultiesAndTraineesPerRotationDTOMap.get(rotationId);
	}
	
	public int getTotalTraineesBlock1() {
		int total = 0;
		for (FacultiesAndTraineesPerRotationDTO facultyPerRotationDTO : facultiesAndTraineesPerRotationDTOMap.values()) {
			total += facultyPerRotationDTO.getTraineesInProgramBlock1() + facultyPerRotationDTO.getTraineesNotInProgramBlock1();
		}
		return total;
	}
	
	public int getTotalTraineesBlock2() {
		int total = 0;
		for (FacultiesAndTraineesPerRotationDTO facultyPerRotationDTO : facultiesAndTraineesPerRotationDTOMap.values()) {
			total += facultyPerRotationDTO.getTraineesInProgramBlock2() + facultyPerRotationDTO.getTraineesNotInProgramBlock2();
		}
		return total;
	}
	
	public int getTotalTraineesBlock3() {
		int total = 0;
		for (FacultiesAndTraineesPerRotationDTO facultyPerRotationDTO : facultiesAndTraineesPerRotationDTOMap.values()) {
			total += facultyPerRotationDTO.getTraineesInProgramBlock3() + facultyPerRotationDTO.getTraineesNotInProgramBlock3();
		}
		return total;
	}
	
	public int getTotalTraineesBlock4() {
		int total = 0;
		for (FacultiesAndTraineesPerRotationDTO facultyPerRotationDTO : facultiesAndTraineesPerRotationDTOMap.values()) {
			total += facultyPerRotationDTO.getTraineesInProgramBlock4() + facultyPerRotationDTO.getTraineesNotInProgramBlock4();
		}
		return total;
	}
	
	public int getTotalTraineesBlock5() {
		int total = 0;
		for (FacultiesAndTraineesPerRotationDTO facultyPerRotationDTO : facultiesAndTraineesPerRotationDTOMap.values()) {
			total += facultyPerRotationDTO.getTraineesInProgramBlock5() + facultyPerRotationDTO.getTraineesNotInProgramBlock5();
		}
		return total;
	}
	
	public int getTotalTraineesBlock6() {
		int total = 0;
		for (FacultiesAndTraineesPerRotationDTO facultyPerRotationDTO : facultiesAndTraineesPerRotationDTOMap.values()) {
			total += facultyPerRotationDTO.getTraineesInProgramBlock6() + facultyPerRotationDTO.getTraineesNotInProgramBlock6();
		}
		return total;
	}
	
	public int getTotalTraineesBlock7() {
		int total = 0;
		for (FacultiesAndTraineesPerRotationDTO facultyPerRotationDTO : facultiesAndTraineesPerRotationDTOMap.values()) {
			total += facultyPerRotationDTO.getTraineesInProgramBlock7() + facultyPerRotationDTO.getTraineesNotInProgramBlock7();
		}
		return total;
	}
	
	public int getTotalTraineesBlock8() {
		int total = 0;
		for (FacultiesAndTraineesPerRotationDTO facultyPerRotationDTO : facultiesAndTraineesPerRotationDTOMap.values()) {
			total += facultyPerRotationDTO.getTraineesInProgramBlock8() + facultyPerRotationDTO.getTraineesNotInProgramBlock8();
		}
		return total;
	}
	
	public int getTotalTraineesBlock9() {
		int total = 0;
		for (FacultiesAndTraineesPerRotationDTO facultyPerRotationDTO : facultiesAndTraineesPerRotationDTOMap.values()) {
			total += facultyPerRotationDTO.getTraineesInProgramBlock9() + facultyPerRotationDTO.getTraineesNotInProgramBlock9();
		}
		return total;
	}
	
	public int getTotalTraineesBlock10() {
		int total = 0;
		for (FacultiesAndTraineesPerRotationDTO facultyPerRotationDTO : facultiesAndTraineesPerRotationDTOMap.values()) {
			total += facultyPerRotationDTO.getTraineesInProgramBlock10() + facultyPerRotationDTO.getTraineesNotInProgramBlock10();
		}
		return total;
	}
	
	public int getTotalTraineesBlock11() {
		int total = 0;
		for (FacultiesAndTraineesPerRotationDTO facultyPerRotationDTO : facultiesAndTraineesPerRotationDTOMap.values()) {
			total += facultyPerRotationDTO.getTraineesInProgramBlock11() + facultyPerRotationDTO.getTraineesNotInProgramBlock11();
		}
		return total;
	}
	
	public int getTotalTraineesBlock12() {
		int total = 0;
		for (FacultiesAndTraineesPerRotationDTO facultyPerRotationDTO : facultiesAndTraineesPerRotationDTOMap.values()) {
			total += facultyPerRotationDTO.getTraineesInProgramBlock12() + facultyPerRotationDTO.getTraineesNotInProgramBlock12();
		}
		return total;
	}
	
	public int getTotalTraineesBlock13() {
		int total = 0;
		for (FacultiesAndTraineesPerRotationDTO facultyPerRotationDTO : facultiesAndTraineesPerRotationDTOMap.values()) {
			total += facultyPerRotationDTO.getTraineesInProgramBlock13() + facultyPerRotationDTO.getTraineesNotInProgramBlock13();
		}
		return total;
	}
	
	public int getTotalTraineeCountInTrainingSite() {
		return getTotalTraineesBlock1() + getTotalTraineesBlock2() + getTotalTraineesBlock3() + getTotalTraineesBlock4() +
				getTotalTraineesBlock5() + getTotalTraineesBlock6() + getTotalTraineesBlock7() + getTotalTraineesBlock8() +
				getTotalTraineesBlock9() + getTotalTraineesBlock10() + getTotalTraineesBlock11() + getTotalTraineesBlock12() +
				getTotalTraineesBlock13();
	}

	public String getTrainingSiteName() {
		return trainingSiteName;
	}

	public List<FacultiesAndTraineesPerRotationDTO> getfacultiesAndTraineesPerRotationDTOList() {
		
		Collection<FacultiesAndTraineesPerRotationDTO> values = facultiesAndTraineesPerRotationDTOMap.values();
        ArrayList<FacultiesAndTraineesPerRotationDTO> listOfValues= new ArrayList<>(values);
		
		return listOfValues;
	}

	public void setTrainingSiteName(String trainingSiteName) {
		this.trainingSiteName = trainingSiteName;
	}

	public long getTrainingSiteId() {
		return trainingSiteId;
	}
	public void setTrainingSiteId(long trainingSiteId) {
		this.trainingSiteId = trainingSiteId;
	}
	
	@Override
	public String toString() {
		return "ResidentsInEachSitePerBlockDTO [trainingSiteId=" + trainingSiteId + ", trainingSiteName="
				+ trainingSiteName + ", facultiesAndTraineesPerRotationDTOList="
				+ facultiesAndTraineesPerRotationDTOMap.values() + "]";
	}
	
	
	
}
