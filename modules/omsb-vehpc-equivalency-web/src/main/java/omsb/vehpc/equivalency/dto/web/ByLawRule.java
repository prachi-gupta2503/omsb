package omsb.vehpc.equivalency.dto.web;

public class ByLawRule {
	private long id;
	private long ruleEngineModuleParameterId;
	private String ModuleName;
	private String byLawConditionIds;
	private boolean matchAll;
	private long ruleKey;
	private String equivalencyLevel;
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
	public long getRuleKey() {
		return ruleKey;
	}
	public void setRuleKey(long ruleKey) {
		this.ruleKey = ruleKey;
	}
	public String getEquivalencyLevel() {
		return equivalencyLevel;
	}
	public void setEquivalencyLevel(String equivalencyLevel) {
		this.equivalencyLevel = equivalencyLevel;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ByLawRule [id=");
		builder.append(id);
		builder.append(", ruleEngineModuleParameterId=");
		builder.append(ruleEngineModuleParameterId);
		builder.append(", ModuleName=");
		builder.append(ModuleName);
		builder.append(", byLawConditionIds=");
		builder.append(byLawConditionIds);
		builder.append(", matchAll=");
		builder.append(matchAll);
		builder.append(", ruleKey=");
		builder.append(ruleKey);
		builder.append(", equivalencyLevel=");
		builder.append(equivalencyLevel);
		builder.append("]");
		return builder.toString();
	}
	
}

