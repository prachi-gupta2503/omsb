package omsb.vehpc.equivalency.dto.web;

public class EquivalencyWFStatus {
	private String label;
	private long code;
	private String label_i18n;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getLabel_i18n() {
		return label_i18n;
	}

	public void setLabel_i18n(String label_i18n) {
		this.label_i18n = label_i18n;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquivalencyWFStatus [label=");
		builder.append(label);
		builder.append(", code=");
		builder.append(code);
		builder.append(", label_i18n=");
		builder.append(label_i18n);
		builder.append("]");
		return builder.toString();
	}

}
