package gov.omsb.tms.custom.dto;

import java.util.Date;

public class DutyLogViolationDTO {

	private long programId;
	private long traineeLevelId;
	private long rotationId;
	private long traineeSiteId;
	private String blockNo;
	private Date blockStartDate;
	private Date blockEndDate;
	private long acgme80HoursRule;
	private long acgmeCallRuleOption1;
	private long acgmeCallRuleOption2;
	private long acgmeShortBreakRule;
	private long acgme24HoursRule;
	private long acgmeDayOffRule;
	
	
	public long getProgramId() {
		return programId;
	}
	public void setProgramId(long programId) {
		this.programId = programId;
	}
	public long getTraineeLevelId() {
		return traineeLevelId;
	}
	public void setTraineeLevelId(long traineeLevelId) {
		this.traineeLevelId = traineeLevelId;
	}
	public long getRotationId() {
		return rotationId;
	}
	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}
	public long getTraineeSiteId() {
		return traineeSiteId;
	}
	public void setTraineeSiteId(long traineeSiteId) {
		this.traineeSiteId = traineeSiteId;
	}
	public String getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}
	public Date getBlockStartDate() {
		return blockStartDate;
	}
	public void setBlockStartDate(Date blockStartDate) {
		this.blockStartDate = blockStartDate;
	}
	public Date getBlockEndDate() {
		return blockEndDate;
	}
	public void setBlockEndDate(Date blockEndDate) {
		this.blockEndDate = blockEndDate;
	}
	public long getAcgme80HoursRule() {
		return acgme80HoursRule;
	}
	public void setAcgme80HoursRule(long acgme80HoursRule) {
		this.acgme80HoursRule = acgme80HoursRule;
	}
	public long getAcgmeShortBreakRule() {
		return acgmeShortBreakRule;
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
	public void setAcgmeShortBreakRule(long acgmeShortBreakRule) {
		this.acgmeShortBreakRule = acgmeShortBreakRule;
	}
	public long getAcgme24HoursRule() {
		return acgme24HoursRule;
	}
	public void setAcgme24HoursRule(long acgme24HoursRule) {
		this.acgme24HoursRule = acgme24HoursRule;
	}
	public long getAcgmeDayOffRule() {
		return acgmeDayOffRule;
	}
	public void setAcgmeDayOffRule(long acgmeDayOffRule) {
		this.acgmeDayOffRule = acgmeDayOffRule;
	}

	
}
