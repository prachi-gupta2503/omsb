package gov.omsb.programs.web.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jayesh Goswami
 */
public class RotationDTO {

	long rotationId;
	String rotationName;
	String rotationRenderUrl;
	boolean isSharedRotation;
	List<TraineeLevelDTO> traineeLevelDTOs= new ArrayList<>();

	public long getRotationId() {
		return rotationId;
	}

	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}

	public String getRotationName() {
		return rotationName;
	}

	public void setRotationName(String rotationName) {
		this.rotationName = rotationName;
	}
	
	public List<TraineeLevelDTO> getTraineeLevelDTOs() {
		return traineeLevelDTOs;
	}

	public void setTraineeLevelDTOs(List<TraineeLevelDTO> traineeLevelDTOs) {
		this.traineeLevelDTOs = traineeLevelDTOs;
	}

	public String getRotationRenderUrl() {
		return rotationRenderUrl;
	}

	public void setRotationRenderUrl(String rotationRenderUrl) {
		this.rotationRenderUrl = rotationRenderUrl;
	}

	public boolean isSharedRotation() {
		return isSharedRotation;
	}

	public void setSharedRotation(boolean isSharedRotation) {
		this.isSharedRotation = isSharedRotation;
	}

	@Override
	public String toString() {
		return "RotationDTO [rotationId=" + rotationId + ", rotationName=" + rotationName + ", rotationRenderUrl="
				+ rotationRenderUrl + ", isSharedRotation=" + isSharedRotation + ", traineeLevelDTOs="
				+ traineeLevelDTOs + "]";
	}
}
