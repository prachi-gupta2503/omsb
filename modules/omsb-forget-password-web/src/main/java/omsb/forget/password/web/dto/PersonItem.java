package omsb.forget.password.web.dto;

import java.util.List;

import gov.omsb.common.dto.Person;

public class PersonItem {
	private List<Person> items;

	public List<Person> getItems() {
		return items;
	}

	public void setItems(List<Person> items) {
		this.items = items;
	}
}
