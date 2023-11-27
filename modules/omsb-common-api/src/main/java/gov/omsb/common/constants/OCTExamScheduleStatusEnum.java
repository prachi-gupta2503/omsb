package gov.omsb.common.constants;

import java.util.HashMap;
import java.util.Map;

public enum OCTExamScheduleStatusEnum {
	PENDING("pending", "omsb-pending-bg"),
	NOTANNOUNCED("not announced", "omsb-pending-bg"),
	ANNOUNCED("announced", "omsb-announced-bg"),
	BLOCKED("blocked", "omsb-insufficient-bg"),
	CANCELLED("cancelled", "omsb-insufficient-bg"),
	COMPLETED("completed", "omsb-completed-bg"); 
	

	
	private final String text;
	private final String color;

	private static Map<String, OCTExamScheduleStatusEnum> textToEnumMapping;

	private OCTExamScheduleStatusEnum(String text, String color) {
		this.text = text;
		this.color = color;
	}

	public static OCTExamScheduleStatusEnum getStatusByLabel(String label) {
		if (textToEnumMapping == null) {
			initMapping();
		}
		return textToEnumMapping.get(label);
	}

	private static void initMapping() {
		textToEnumMapping = new HashMap<>();
		for (OCTExamScheduleStatusEnum s : values()) {
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
