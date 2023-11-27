package gov.omsb.exam.web.portlet.dto;

public class ByLawCondition {

	private long id;
	private long ruleEngineModuleParameterId;
	private String moduleName;
	private String conditionValue;
	private String conditionType;
	private String parameterName;
	private String value;
	private String ModuleName;

	public String getConditionType() {
		return conditionType;
	}
	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}
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
	public String getConditionValue() {
		return conditionValue;
	}
	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}
	
	
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	@Override
	public String toString() {
		return "ByLawCondition [id=" + id + ", ruleEngineModuleParameterId=" + ruleEngineModuleParameterId
				+ ", parameterName=" + parameterName + ", value=" + value + ", conditionValue=" + conditionValue + "]";
	}
	
	
}
