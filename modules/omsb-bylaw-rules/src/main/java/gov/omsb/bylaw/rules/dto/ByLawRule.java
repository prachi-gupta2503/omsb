package gov.omsb.bylaw.rules.dto;

public class ByLawRule {

	private long id;
	private long ruleEngineModuleParameterId;
	private String ModuleName;
	private String byLawConditionIds;
	private boolean matchAll;
	private long ruleKey;
	private String equivalencyLevel;
	
	public long getRuleKey() {
		return ruleKey;
	}
	public void setRuleKey(long ruleKey) {
		this.ruleKey = ruleKey;
	}
	private String byLawCondition;
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
		return ModuleName;
	}
	public void setModuleName(String moduleName) {
		ModuleName = moduleName;
	}
	public String getByLawConditionIds() {
		return byLawConditionIds;
	}
	public void setByLawConditionIds(String byLawConditionIds) {
		this.byLawConditionIds = byLawConditionIds;
	}
	public boolean isMatchAll() {
		return matchAll;
	}
	public void setMatchAll(boolean matchAll) {
		this.matchAll = matchAll;
	}
	public String getByLawCondition() {
		return byLawCondition;
	}
	public void setByLawCondition(String byLawCondition) {
		this.byLawCondition = byLawCondition;
	}
	public String getEquivalencyLevel() {
		return equivalencyLevel;
	}
	public void setEquivalencyLevel(String equivalencyLevel) {
		this.equivalencyLevel = equivalencyLevel;
	}
	
	
	
}
