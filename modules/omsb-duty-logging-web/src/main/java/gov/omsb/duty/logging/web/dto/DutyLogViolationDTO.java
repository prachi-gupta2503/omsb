package gov.omsb.duty.logging.web.dto;


import java.util.Date;

public class DutyLogViolationDTO {

	private long dutyLogViolationId;
	private long programId;
	private long traineeLevelId;
	private long rotationId;
	private long traineeSiteId;
	private String blockNo;
	private Date blockStartDate;
	private Date blockEndDate;
	private Integer acgme80HoursRule;
	private Integer acgmeCallRuleOption1;
	private Integer acgmeCallRuleOption2;
	private Integer acgmeShortBreakRule;
	private Integer acgme24HoursRule;
	private Integer acgmeDayOffRule;

		public void setAcgmeCallRuleOption1(Integer acgmeCallRuleOption1) {
		this.acgmeCallRuleOption1 = acgmeCallRuleOption1;
	}


	public void setAcgmeCallRuleOption2(Integer acgmeCallRuleOption2) {
		this.acgmeCallRuleOption2 = acgmeCallRuleOption2;
	}


		public long getDutyLogViolationId() {
		return dutyLogViolationId;
	}


	public void setDutyLogViolationId(long dutyLogViolationId) {
		this.dutyLogViolationId = dutyLogViolationId;
	}


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

	public Integer getAcgme80HoursRule() {
		return acgme80HoursRule;
	}

	public void setAcgme80HoursRule(Integer acgme80HoursRule) {
		this.acgme80HoursRule = acgme80HoursRule;
	}

	
	public long getAcgmeCallRuleOption1() {
		return acgmeCallRuleOption1;
	}


	
	public long getAcgmeCallRuleOption2() {
		return acgmeCallRuleOption2;
	}


	public Integer getAcgmeShortBreakRule() {
		return acgmeShortBreakRule;
	}

	public void setAcgmeShortBreakRule(Integer acgmeShortBreakRule) {
		this.acgmeShortBreakRule = acgmeShortBreakRule;
	}

	public Integer getAcgme24HoursRule() {
		return acgme24HoursRule;
	}

	public void setAcgme24HoursRule(Integer acgme24HoursRule) {
		this.acgme24HoursRule = acgme24HoursRule;
	}

	public Integer getAcgmeDayOffRule() {
		return acgmeDayOffRule;
	}

	public void setAcgmeDayOffRule(Integer acgmeDayOffRule) {
		this.acgmeDayOffRule = acgmeDayOffRule;
	}

	
}
