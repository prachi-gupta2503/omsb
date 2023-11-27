package gov.omsb.oct.exam.web.portlet.dto;

import java.util.List;

public class OCTExamScheduleAdminItems {

	private List<OCTExamScheduleAdmin> items;

	@Override
	public String toString() {
		return "OCTExamScheduleAdminItems [items=" + items + "]";
	}

	public List<OCTExamScheduleAdmin> getItems() {
		return items;
	}

	public void setItems(List<OCTExamScheduleAdmin> items) {
		this.items = items;
	}
}
