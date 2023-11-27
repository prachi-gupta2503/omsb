package gov.omsb.tms.ecm.web.dto;

public class ActionDetail{
	private String name;
	private String handler;
    private String description;
    
    public ActionDetail(String name, String handler, String description) {
        this.name = name;
		this.handler = handler;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ActionDetail{" +
                "name='" + name + '\'' +
                ", handler='" + handler + '\'' +
                ", description=" + description +
                '}';
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
