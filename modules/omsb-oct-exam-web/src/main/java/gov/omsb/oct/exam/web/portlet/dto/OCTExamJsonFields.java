package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamJsonFields {
	private long id;
	private int examDuration;
	private long resultSource;
	private long examTitleId;
	private int scoreValidity;
	private int cutOffWindow;
	private int cutScore;
	private int examFormNo;
	
	@JsonProperty("examFormNumber")
	private List<OCTExamFormNumber> octExamFormNumbers;
	private String locationOnGoogleMap;
	private String venue;
	private float earlyBirdFees;
	private int earlyBirdFeesDate;
	private int autoSchedulingPeriod;
	private boolean eligibilityCheck;
	private boolean applyEligibility;
	private boolean modified;
	private int omaniMaxAttempts;
	private int omaniMaxTimePeriod;
	private int omaniTimePeriod;
	
	@JsonProperty("nonomaniMaxAttempts")
	private int nonOmaniMaxAttempts;

	@JsonProperty("nonomaniMaxTimePeriod")
	private int nonOmaniMaxTimePeriod;

	@JsonProperty("nonomaniTimePeriod")
	private int nonOmaniTimePeriod;

	@JsonProperty("examBlueprint")
	private List<OCTExamBlueprint> octExamBlueprints;

	@JsonProperty("regularFees")
	private List<OCTRegularFees> octRegularFees;

	@JsonProperty("rescheduleFees")
	private List<OCTRescheduleFees> octRescheduleFees;

	@JsonProperty("cancellationFees")
	private List<OCTExamCancellationFees> octExamCancellationFees;

	private int appealWindow;
	private float appealFees;
	private int reAppealWindow;
	private float reAppealFees;
	private String examTitleName;
	private String resultSourceName;

	public int getExamDuration() {
		return examDuration;
	}

	public void setExamDuration(int examDuration) {
		this.examDuration = examDuration;
	}

	public long getResultSource() {
		return resultSource;
	}

	public void setResultSource(long resultSource) {
		this.resultSource = resultSource;
	}

	public long getExamTitleId() {
		return examTitleId;
	}

	public void setExamTitleId(long examTitleId) {
		this.examTitleId = examTitleId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getCutScore() {
		return cutScore;
	}

	public void setCutScore(int cutScore) {
		this.cutScore = cutScore;
	}

	public int getExamFormNo() {
		return examFormNo;
	}

	public void setExamFormNo(int examFormNo) {
		this.examFormNo = examFormNo;
	}
	
	public List<OCTExamFormNumber> getOctExamFormNumbers() {
		return octExamFormNumbers;
	}

	public void setOctExamFormNumbers(List<OCTExamFormNumber> octExamFormNumbers) {
		this.octExamFormNumbers = octExamFormNumbers;
	}

	public String getLocationOnGoogleMap() {
		return locationOnGoogleMap;
	}

	public void setLocationOnGoogleMap(String locationOnGoogleMap) {
		this.locationOnGoogleMap = locationOnGoogleMap;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
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

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
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

	public List<OCTExamBlueprint> getOctExamBlueprints() {
		return octExamBlueprints;
	}

	public void setOctExamBlueprints(List<OCTExamBlueprint> octExamBlueprints) {
		this.octExamBlueprints = octExamBlueprints;
	}

	public List<OCTRegularFees> getOctRegularFees() {
		return octRegularFees;
	}

	public void setOctRegularFees(List<OCTRegularFees> octRegularFees) {
		this.octRegularFees = octRegularFees;
	}

	public List<OCTRescheduleFees> getOctRescheduleFees() {
		return octRescheduleFees;
	}

	public void setOctRescheduleFees(List<OCTRescheduleFees> octRescheduleFees) {
		this.octRescheduleFees = octRescheduleFees;
	}

	public List<OCTExamCancellationFees> getOctExamCancellationFees() {
		return octExamCancellationFees;
	}

	public void setOctExamCancellationFees(List<OCTExamCancellationFees> octExamCancellationFees) {
		this.octExamCancellationFees = octExamCancellationFees;
	}

	public int getAppealWindow() {
		return appealWindow;
	}

	public void setAppealWindow(int appealWindow) {
		this.appealWindow = appealWindow;
	}

	public float getAppealFees() {
		return appealFees;
	}

	public void setAppealFees(float appealFees) {
		this.appealFees = appealFees;
	}

	public int getReAppealWindow() {
		return reAppealWindow;
	}

	public void setReAppealWindow(int reAppealWindow) {
		this.reAppealWindow = reAppealWindow;
	}

	public float getReAppealFees() {
		return reAppealFees;
	} 

	public String getExamTitleName() {
		return examTitleName;
	}

	public void setExamTitleName(String examTitleName) {
		this.examTitleName = examTitleName;
	}

	public String getResultSourceName() {
		return resultSourceName;
	}

	public void setResultSourceName(String resultSourceName) {
		this.resultSourceName = resultSourceName;
	}
 
	public void setReAppealFees(float reAppealFees) {
		this.reAppealFees = reAppealFees;
	}

	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OCTExamJsonFields [examDuration=");
		builder.append(examDuration);
		builder.append(", resultSource=");
		builder.append(resultSource);
		builder.append(", examTitleId=");
		builder.append(examTitleId);
		builder.append(", scoreValidity=");
		builder.append(scoreValidity);
		builder.append(", cutOffWindow=");
		builder.append(cutOffWindow);
		builder.append(", cutScore=");
		builder.append(cutScore);
		builder.append(", examFormNo=");
		builder.append(examFormNo);
		builder.append(", octExamFormNumbers=");
		builder.append(octExamFormNumbers);
		builder.append(", locationOnGoogleMap=");
		builder.append(locationOnGoogleMap);
		builder.append(", venue=");
		builder.append(venue);
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
		builder.append(", modified=");
		builder.append(modified);
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
		builder.append(", octExamBlueprints=");
		builder.append(octExamBlueprints);
		builder.append(", octRegularFees=");
		builder.append(octRegularFees);
		builder.append(", octRescheduleFees=");
		builder.append(octRescheduleFees);
		builder.append(", octExamCancellationFees=");
		builder.append(octExamCancellationFees);
		builder.append(", appealWindow=");
		builder.append(appealWindow);
		builder.append(", appealFees=");
		builder.append(appealFees);
		builder.append(", reAppealWindow=");
		builder.append(reAppealWindow);
		builder.append(", reAppealFees=");
		builder.append(reAppealFees);
		builder.append("]");
		return builder.toString();
	}

}
