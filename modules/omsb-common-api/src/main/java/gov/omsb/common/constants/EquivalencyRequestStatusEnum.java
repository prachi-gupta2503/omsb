package gov.omsb.common.constants;

import java.util.HashMap;
import java.util.Map;

public enum EquivalencyRequestStatusEnum {

	CREATED("created", "omsb-created-bg"), INSUFFICIENT("insufficient", "omsb-insufficient-bg"),
	INITIATED("initiated", "omsb-initiated-bg"), EQUATED("equated", "omsb-equated-bg"),
	COMPLETED("completed", "omsb-completed-bg"), INPROGRESS("inProgress", "omsb-pending-bg"),
	RECEIVED("received", "omsb-insufficient-bg"), EMPLOYER_DRAFT("employerDraft", "omsb-pending-bg"),
	ADMIN_DRAFT("adminDraft", "omsb-pending-bg"), NOT_INITIATED("notInitiated", "omsb-raised-bg");
	
	private final String text;
	private final String color;

	private static Map<String, EquivalencyRequestStatusEnum> textToEnumMapping;

	private EquivalencyRequestStatusEnum(String text, String color) {
		this.text = text;
		this.color = color;
	}

	public static EquivalencyRequestStatusEnum getStatusByLabel(String label) {
		if (textToEnumMapping == null) {
			initMapping();
		}
		return textToEnumMapping.get(label);
	}

	private static void initMapping() {
		textToEnumMapping = new HashMap<>();
		for (EquivalencyRequestStatusEnum s : values()) {
			textToEnumMapping.put(s.text.toLowerCase(), s);
		}
	}

	public String getText() {
		return text;
	}

	public String getColor() {
		return color;
	}
}