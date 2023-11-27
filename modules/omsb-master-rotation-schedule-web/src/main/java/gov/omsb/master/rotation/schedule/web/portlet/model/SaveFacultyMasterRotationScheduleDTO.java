package gov.omsb.master.rotation.schedule.web.portlet.model;

import java.util.List;

public class SaveFacultyMasterRotationScheduleDTO {
	
	public static class FacultyDetail {
		private long facultyId;
		private String facultyName;
		
		public long getFacultyId() {
			return facultyId;
		}
		public void setFacultyId(long facultyId) {
			this.facultyId = facultyId;
		}
		public String getFacultyName() {
			return facultyName;
		}
		public void setFacultyName(String facultyName) {
			this.facultyName = facultyName;
		}
	
		@Override
		public String toString() {
			return "FacultyDetail [facultyId=" + facultyId + ", facultyName=" + facultyName + "]";
		}
		
	}

	private long blockId; //blocksMetadataDetailsRelId
	private long rotationId; //progDurationRotationTsRelId
	private List<FacultyDetail> facultyDetails;

	public long getBlockId() {
		return blockId;
	}
	public void setBlockId(long blockId) {
		this.blockId = blockId;
	}
	public long getRotationId() {
		return rotationId;
	}
	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}
	public List<FacultyDetail> getFacultyDetails() {
		return facultyDetails;
	}
	public void setFacultyDetails(List<FacultyDetail> facultyDetails) {
		this.facultyDetails = facultyDetails;
	}

	@Override
	public String toString() {
		return "SaveFacultyMasterRotationScheduleDTO [blockId=" + blockId + ", rotationId=" + rotationId
				+ ", facultyDetails=" + facultyDetails + "]";
	}
}
