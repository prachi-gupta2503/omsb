package gov.omsb.duty.logging.web.dto;

public class CommonDTO {

	private long id;

	
	private String name;

	
	public CommonDTO() {
		super();
	}

	public CommonDTO(long id) {
		super();
		this.id = id;
	}

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
	
	
}
