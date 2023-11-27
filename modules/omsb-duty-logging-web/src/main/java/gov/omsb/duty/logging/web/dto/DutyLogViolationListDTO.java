package gov.omsb.duty.logging.web.dto;

public class DutyLogViolationListDTO {

	

	
	private String program;
	private String residencyLevel;
	private String rotaionTrainingName;
	private String blockNo;
	private String date;
	private long acgme80HoursRule;
	private long acgme24HoursRule;
	private long acgmeCallRuleOption1;
	private long acgmeCallRuleOption2;
	private long acgmeShortBreakRule;
	private long acgmeDayOffRule;
	private long dutyLogViolationId;
	
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getResidencyLevel() {
		return residencyLevel;
	}
	public void setResidencyLevel(String residencyLevel) {
		this.residencyLevel = residencyLevel;
	}
	public String getRotaionTrainingName() {
		return rotaionTrainingName;
	}
	public void setRotaionTrainingName(String rotaionTrainingName) {
		this.rotaionTrainingName = rotaionTrainingName;
	}
	public String getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getAcgme80HoursRule() {
		return acgme80HoursRule;
	}
	public void setAcgme80HoursRule(long acgme80HoursRule) {
		this.acgme80HoursRule = acgme80HoursRule;
	}
	public long getAcgme24HoursRule() {
		return acgme24HoursRule;
	}
	public void setAcgme24HoursRule(long acgme24HoursRule) {
		this.acgme24HoursRule = acgme24HoursRule;
	}
	
	public long getAcgmeCallRuleOption1() {
		return acgmeCallRuleOption1;
	}
	public void setAcgmeCallRuleOption1(long acgmeCallRuleOption1) {
		this.acgmeCallRuleOption1 = acgmeCallRuleOption1;
	}
	public long getAcgmeCallRuleOption2() {
		return acgmeCallRuleOption2;
	}
	public void setAcgmeCallRuleOption2(long acgmeCallRuleOption2) {
		this.acgmeCallRuleOption2 = acgmeCallRuleOption2;
	}
	public long getAcgmeShortBreakRule() {
		return acgmeShortBreakRule;
	}
	public void setAcgmeShortBreakRule(long acgmeShortBreakRule) {
		this.acgmeShortBreakRule = acgmeShortBreakRule;
	}
	public long getAcgmeDayOffRule() {
		return acgmeDayOffRule;
	}
	public void setAcgmeDayOffRule(long acgmeDayOffRule) {
		this.acgmeDayOffRule = acgmeDayOffRule;
	}
	public long getDutyLogViolationId() {
		return dutyLogViolationId;
	}
	public void setDutyLogViolationId(long dutyLogViolationId) {
		this.dutyLogViolationId = dutyLogViolationId;
	}
	@Override
	public String toString() {
		return "DutyLogViolationListDTO [program=" + program + ", residencyLevel=" + residencyLevel
				+ ", rotaionTrainingName=" + rotaionTrainingName + ", blockNo=" + blockNo + ", date=" + date
				+ ", acgme80HoursRule=" + acgme80HoursRule + ", acgme24HoursRule=" + acgme24HoursRule
				+ ", acgmeCallRuleOption1=" + acgmeCallRuleOption1 + ", acgmeCallRuleOption2=" + acgmeCallRuleOption2
				+ ", acgmeShortBreakRule=" + acgmeShortBreakRule + ", acgmeDayOffRule=" + acgmeDayOffRule
				+ ", dutyLogViolationId=" + dutyLogViolationId + "]";
	}
	
	
}
