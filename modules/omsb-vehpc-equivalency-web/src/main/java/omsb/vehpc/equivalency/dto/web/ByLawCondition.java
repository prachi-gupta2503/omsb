package omsb.vehpc.equivalency.dto.web;

public class ByLawCondition {
	private long id;
	private long ruleEngineModuleParameterId;
	private String moduleName;
	private String conditionValue;
	private String conditionType;
	private String parameterName;
	private String value;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getRuleEngineModuleParameterId() {
		return ruleEngineModuleParameterId;
	}
	public void setRuleEngineModuleParameterId(long ruleEngineModuleParameterId) {
		this.ruleEngineModuleParameterId = ruleEngineModuleParameterId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getConditionValue() {
		return conditionValue;
	}
	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}
	public String getConditionType() {
		return conditionType;
	}
	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ByLawCondition [id=");
		builder.append(id);
		builder.append(", ruleEngineModuleParameterId=");
		builder.append(ruleEngineModuleParameterId);
		builder.append(", moduleName=");
		builder.append(moduleName);
		builder.append(", conditionValue=");
		builder.append(conditionValue);
		builder.append(", conditionType=");
		builder.append(conditionType);
		builder.append(", parameterName=");
		builder.append(parameterName);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
	
}
