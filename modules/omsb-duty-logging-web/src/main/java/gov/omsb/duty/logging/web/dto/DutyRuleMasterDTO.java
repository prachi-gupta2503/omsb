package gov.omsb.duty.logging.web.dto;

import java.util.ArrayList;
import java.util.List;

public class DutyRuleMasterDTO {
	private long id;
	private String name;
	private List<DutyRuleMasterDTO> options= new ArrayList<DutyRuleMasterDTO>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DutyRuleMasterDTO> getOptions() {
		return options;
	}
	public void setOptions(List<DutyRuleMasterDTO> options) {
		this.options = options;
	}
	@Override
	public String toString() {
		return "DutyRuleMasterDTO [id=" + id + ", name=" + name + ", options=" + options + "]";
	}
	

}
