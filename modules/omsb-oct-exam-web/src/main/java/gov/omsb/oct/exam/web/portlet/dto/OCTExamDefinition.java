package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamDefinition {

	private long id;
	private long oCExamId;
	private long oCExamTitleId;
	private int examDuration;
	private int cutScore;
	private int scoreValidity;
	private int cutOffWindow;
	private long resultSource;
	private int examFormNumber;
	private String venue;
	private String locationOnGoogleMap;
	private int reAppealWindow;
	private float appealFees;
	private int appealWindow;
	private float reAppealFees;
	private float earlyBirdFees;
	private int earlyBirdFeesDate;
	private int autoSchedulingPeriod;
	private boolean eligibilityCheck;
	private boolean applyEligibility;
	private int omaniMaxAttempts;
	private int omaniMaxTimePeriod;
	private int omaniTimePeriod;
	private int nonOmaniMaxAttempts;
	private int nonOmaniMaxTimePeriod;
	private int nonOmaniTimePeriod;
	private int timePeriodBetweenAttempts;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getoCExamId() {
		return oCExamId;
	}

	public void setoCExamId(long oCExamId) {
		this.oCExamId = oCExamId;
	}

	public long getoCExamTitleId() {
		return oCExamTitleId;
	}

	public void setoCExamTitleId(long oCExamTitleId) {
		this.oCExamTitleId = oCExamTitleId;
	}

	public int getExamDuration() {
		return examDuration;
	}

	public void setExamDuration(int examDuration) {
		this.examDuration = examDuration;
	}

	public int getCutScore() {
		return cutScore;
	}

	public void setCutScore(int cutScore) {
		this.cutScore = cutScore;
	}

	public int getScoreValidity() {
		return scoreValidity;
	}

	public void setScoreValidity(int scoreValidity) {
		this.scoreValidity = scoreValidity;
	}

	public int getCutOffWindow() {
		return cutOffWindow;
	}

	public void setCutOffWindow(int cutOffWindow) {
		this.cutOffWindow = cutOffWindow;
	}
	public long getResultSource() {
		return resultSource;
	}
	public void setResultSource(long resultSource) {
		this.resultSource = resultSource;
	}

	public int getExamFormNumber() {
		return examFormNumber;
	}

	public void setExamFormNumber(int examFormNumber) {
		this.examFormNumber = examFormNumber;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getLocationOnGoogleMap() {
		return locationOnGoogleMap;
	}

	public void setLocationOnGoogleMap(String locationOnGoogleMap) {
		this.locationOnGoogleMap = locationOnGoogleMap;
	}

	public int getReAppealWindow() {
		return reAppealWindow;
	}

	public void setReAppealWindow(int reAppealWindow) {
		this.reAppealWindow = reAppealWindow;
	}

	public float getAppealFees() {
		return appealFees;
	}

	public void setAppealFees(float appealFees) {
		this.appealFees = appealFees;
	}

	public int getAppealWindow() {
		return appealWindow;
	}

	public void setAppealWindow(int appealWindow) {
		this.appealWindow = appealWindow;
	}

	public float getReAppealFees() {
		return reAppealFees;
	}

	public void setReAppealFees(float reAppealFees) {
		this.reAppealFees = reAppealFees;
	}

	public float getEarlyBirdFees() {
		return earlyBirdFees;
	}

	public void setEarlyBirdFees(float earlyBirdFees) {
		this.earlyBirdFees = earlyBirdFees;
	}

	public int getEarlyBirdFeesDate() {
		return earlyBirdFeesDate;
	}

	public void setEarlyBirdFeesDate(int earlyBirdFeesDate) {
		this.earlyBirdFeesDate = earlyBirdFeesDate;
	}

	public int getAutoSchedulingPeriod() {
		return autoSchedulingPeriod;
	}

	public void setAutoSchedulingPeriod(int autoSchedulingPeriod) {
		this.autoSchedulingPeriod = autoSchedulingPeriod;
	}

	public boolean isEligibilityCheck() {
		return eligibilityCheck;
	}

	public void setEligibilityCheck(boolean eligibilityCheck) {
		this.eligibilityCheck = eligibilityCheck;
	}

	public boolean isApplyEligibility() {
		return applyEligibility;
	}

	public void setApplyEligibility(boolean applyEligibility) {
		this.applyEligibility = applyEligibility;
	}

	public int getOmaniMaxAttempts() {
		return omaniMaxAttempts;
	}

	public void setOmaniMaxAttempts(int omaniMaxAttempts) {
		this.omaniMaxAttempts = omaniMaxAttempts;
	}

	public int getOmaniMaxTimePeriod() {
		return omaniMaxTimePeriod;
	}

	public void setOmaniMaxTimePeriod(int omaniMaxTimePeriod) {
		this.omaniMaxTimePeriod = omaniMaxTimePeriod;
	}

	public int getOmaniTimePeriod() {
		return omaniTimePeriod;
	}

	public void setOmaniTimePeriod(int omaniTimePeriod) {
		this.omaniTimePeriod = omaniTimePeriod;
	}

	public int getNonOmaniMaxAttempts() {
		return nonOmaniMaxAttempts;
	}

	public void setNonOmaniMaxAttempts(int nonOmaniMaxAttempts) {
		this.nonOmaniMaxAttempts = nonOmaniMaxAttempts;
	}

	public int getNonOmaniMaxTimePeriod() {
		return nonOmaniMaxTimePeriod;
	}

	public void setNonOmaniMaxTimePeriod(int nonOmaniMaxTimePeriod) {
		this.nonOmaniMaxTimePeriod = nonOmaniMaxTimePeriod;
	}

	public int getNonOmaniTimePeriod() {
		return nonOmaniTimePeriod;
	}

	public void setNonOmaniTimePeriod(int nonOmaniTimePeriod) {
		this.nonOmaniTimePeriod = nonOmaniTimePeriod;
	}

	public int getTimePeriodBetweenAttempts() {
		return timePeriodBetweenAttempts;
	}

	public void setTimePeriodBetweenAttempts(int timePeriodBetweenAttempts) {
		this.timePeriodBetweenAttempts = timePeriodBetweenAttempts;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OCTExamDefinition [id=");
		builder.append(id);
		builder.append(", oCExamId=");
		builder.append(oCExamId);
		builder.append(", oCExamTitleId=");
		builder.append(oCExamTitleId);
		builder.append(", examDuration=");
		builder.append(examDuration);
		builder.append(", cutScore=");
		builder.append(cutScore);
		builder.append(", scoreValidity=");
		builder.append(scoreValidity);
		builder.append(", cutOffWindow=");
		builder.append(cutOffWindow);
		builder.append(", resultSource=");
		builder.append(resultSource);
		builder.append(", examFormNumber=");
		builder.append(examFormNumber);
		builder.append(", venue=");
		builder.append(venue);
		builder.append(", locationOnGoogleMap=");
		builder.append(locationOnGoogleMap);
		builder.append(", reAppealWindow=");
		builder.append(reAppealWindow);
		builder.append(", appealFees=");
		builder.append(appealFees);
		builder.append(", appealWindow=");
		builder.append(appealWindow);
		builder.append(", reAppealFees=");
		builder.append(reAppealFees);
		builder.append(", earlyBirdFees=");
		builder.append(earlyBirdFees);
		builder.append(", earlyBirdFeesDate=");
		builder.append(earlyBirdFeesDate);
		builder.append(", autoSchedulingPeriod=");
		builder.append(autoSchedulingPeriod);
		builder.append(", eligibilityCheck=");
		builder.append(eligibilityCheck);
		builder.append(", applyEligibility=");
		builder.append(applyEligibility);
		builder.append(", omaniMaxAttempts=");
		builder.append(omaniMaxAttempts);
		builder.append(", omaniMaxTimePeriod=");
		builder.append(omaniMaxTimePeriod);
		builder.append(", omaniTimePeriod=");
		builder.append(omaniTimePeriod);
		builder.append(", nonOmaniMaxAttempts=");
		builder.append(nonOmaniMaxAttempts);
		builder.append(", nonOmaniMaxTimePeriod=");
		builder.append(nonOmaniMaxTimePeriod);
		builder.append(", nonOmaniTimePeriod=");
		builder.append(nonOmaniTimePeriod);
		builder.append(", timePeriodBetweenAttempts=");
		builder.append(timePeriodBetweenAttempts);
		builder.append("]");
		return builder.toString();
	}

	
	
}
