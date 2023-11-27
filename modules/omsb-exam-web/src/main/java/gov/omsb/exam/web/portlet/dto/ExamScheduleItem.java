package gov.omsb.exam.web.portlet.dto;

import java.util.List;

public class ExamScheduleItem {
	
	private List<ExamSchedule> items;

	@Override
	public String toString() {
		return "ExamScheduleItem [items=" + items + "]";
	}
	public List<ExamSchedule> getItems() {
		return items;
	}
	public void setItems(List<ExamSchedule> items) {
		this.items = items;
	}
}
