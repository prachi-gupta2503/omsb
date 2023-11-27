/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package gov.omsb.tms.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TraineeLoggedProcedureDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeLoggedProcedureDetails
 * @generated
 */
public class TraineeLoggedProcedureDetailsWrapper
	extends BaseModelWrapper<TraineeLoggedProcedureDetails>
	implements ModelWrapper<TraineeLoggedProcedureDetails>,
			   TraineeLoggedProcedureDetails {

	public TraineeLoggedProcedureDetailsWrapper(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails) {

		super(traineeLoggedProcedureDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"traineeLoggedProcedureDetailsId",
			getTraineeLoggedProcedureDetailsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("programDurationId", getProgramDurationId());
		attributes.put("rotationId", getRotationId());
		attributes.put("traineeLevelId", getTraineeLevelId());
		attributes.put("procedureGroupId", getProcedureGroupId());
		attributes.put("procedureId", getProcedureId());
		attributes.put("genderId", getGenderId());
		attributes.put("patientTypeId", getPatientTypeId());
		attributes.put("visitTypeId", getVisitTypeId());
		attributes.put("cptCode", getCptCode());
		attributes.put("trainingSitesId", getTrainingSitesId());
		attributes.put("roleTypeId", getRoleTypeId());
		attributes.put("facultyId", getFacultyId());
		attributes.put("traineeId", getTraineeId());
		attributes.put("patientId", getPatientId());
		attributes.put("patientDOB", getPatientDOB());
		attributes.put("procedurePerformedDate", getProcedurePerformedDate());
		attributes.put("diagnosisDescription", getDiagnosisDescription());
		attributes.put("traineeComments", getTraineeComments());
		attributes.put("supervisorComments", getSupervisorComments());
		attributes.put("procedureStatus", getProcedureStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long traineeLoggedProcedureDetailsId = (Long)attributes.get(
			"traineeLoggedProcedureDetailsId");

		if (traineeLoggedProcedureDetailsId != null) {
			setTraineeLoggedProcedureDetailsId(traineeLoggedProcedureDetailsId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long programDurationId = (Long)attributes.get("programDurationId");

		if (programDurationId != null) {
			setProgramDurationId(programDurationId);
		}

		Long rotationId = (Long)attributes.get("rotationId");

		if (rotationId != null) {
			setRotationId(rotationId);
		}

		Long traineeLevelId = (Long)attributes.get("traineeLevelId");

		if (traineeLevelId != null) {
			setTraineeLevelId(traineeLevelId);
		}

		Long procedureGroupId = (Long)attributes.get("procedureGroupId");

		if (procedureGroupId != null) {
			setProcedureGroupId(procedureGroupId);
		}

		Long procedureId = (Long)attributes.get("procedureId");

		if (procedureId != null) {
			setProcedureId(procedureId);
		}

		Long genderId = (Long)attributes.get("genderId");

		if (genderId != null) {
			setGenderId(genderId);
		}

		Long patientTypeId = (Long)attributes.get("patientTypeId");

		if (patientTypeId != null) {
			setPatientTypeId(patientTypeId);
		}

		Long visitTypeId = (Long)attributes.get("visitTypeId");

		if (visitTypeId != null) {
			setVisitTypeId(visitTypeId);
		}

		String cptCode = (String)attributes.get("cptCode");

		if (cptCode != null) {
			setCptCode(cptCode);
		}

		Long trainingSitesId = (Long)attributes.get("trainingSitesId");

		if (trainingSitesId != null) {
			setTrainingSitesId(trainingSitesId);
		}

		Long roleTypeId = (Long)attributes.get("roleTypeId");

		if (roleTypeId != null) {
			setRoleTypeId(roleTypeId);
		}

		Long facultyId = (Long)attributes.get("facultyId");

		if (facultyId != null) {
			setFacultyId(facultyId);
		}

		Long traineeId = (Long)attributes.get("traineeId");

		if (traineeId != null) {
			setTraineeId(traineeId);
		}

		String patientId = (String)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		Date patientDOB = (Date)attributes.get("patientDOB");

		if (patientDOB != null) {
			setPatientDOB(patientDOB);
		}

		Date procedurePerformedDate = (Date)attributes.get(
			"procedurePerformedDate");

		if (procedurePerformedDate != null) {
			setProcedurePerformedDate(procedurePerformedDate);
		}

		String diagnosisDescription = (String)attributes.get(
			"diagnosisDescription");

		if (diagnosisDescription != null) {
			setDiagnosisDescription(diagnosisDescription);
		}

		String traineeComments = (String)attributes.get("traineeComments");

		if (traineeComments != null) {
			setTraineeComments(traineeComments);
		}

		String supervisorComments = (String)attributes.get(
			"supervisorComments");

		if (supervisorComments != null) {
			setSupervisorComments(supervisorComments);
		}

		String procedureStatus = (String)attributes.get("procedureStatus");

		if (procedureStatus != null) {
			setProcedureStatus(procedureStatus);
		}
	}

	@Override
	public TraineeLoggedProcedureDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this trainee logged procedure details.
	 *
	 * @return the company ID of this trainee logged procedure details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the cpt code of this trainee logged procedure details.
	 *
	 * @return the cpt code of this trainee logged procedure details
	 */
	@Override
	public String getCptCode() {
		return model.getCptCode();
	}

	/**
	 * Returns the localized cpt code of this trainee logged procedure details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized cpt code of this trainee logged procedure details
	 */
	@Override
	public String getCptCode(java.util.Locale locale) {
		return model.getCptCode(locale);
	}

	/**
	 * Returns the localized cpt code of this trainee logged procedure details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized cpt code of this trainee logged procedure details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getCptCode(java.util.Locale locale, boolean useDefault) {
		return model.getCptCode(locale, useDefault);
	}

	/**
	 * Returns the localized cpt code of this trainee logged procedure details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized cpt code of this trainee logged procedure details
	 */
	@Override
	public String getCptCode(String languageId) {
		return model.getCptCode(languageId);
	}

	/**
	 * Returns the localized cpt code of this trainee logged procedure details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized cpt code of this trainee logged procedure details
	 */
	@Override
	public String getCptCode(String languageId, boolean useDefault) {
		return model.getCptCode(languageId, useDefault);
	}

	@Override
	public String getCptCodeCurrentLanguageId() {
		return model.getCptCodeCurrentLanguageId();
	}

	@Override
	public String getCptCodeCurrentValue() {
		return model.getCptCodeCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized cpt codes of this trainee logged procedure details.
	 *
	 * @return the locales and localized cpt codes of this trainee logged procedure details
	 */
	@Override
	public Map<java.util.Locale, String> getCptCodeMap() {
		return model.getCptCodeMap();
	}

	/**
	 * Returns the create date of this trainee logged procedure details.
	 *
	 * @return the create date of this trainee logged procedure details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this trainee logged procedure details.
	 *
	 * @return the created by of this trainee logged procedure details
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the diagnosis description of this trainee logged procedure details.
	 *
	 * @return the diagnosis description of this trainee logged procedure details
	 */
	@Override
	public String getDiagnosisDescription() {
		return model.getDiagnosisDescription();
	}

	/**
	 * Returns the localized diagnosis description of this trainee logged procedure details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized diagnosis description of this trainee logged procedure details
	 */
	@Override
	public String getDiagnosisDescription(java.util.Locale locale) {
		return model.getDiagnosisDescription(locale);
	}

	/**
	 * Returns the localized diagnosis description of this trainee logged procedure details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized diagnosis description of this trainee logged procedure details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDiagnosisDescription(
		java.util.Locale locale, boolean useDefault) {

		return model.getDiagnosisDescription(locale, useDefault);
	}

	/**
	 * Returns the localized diagnosis description of this trainee logged procedure details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized diagnosis description of this trainee logged procedure details
	 */
	@Override
	public String getDiagnosisDescription(String languageId) {
		return model.getDiagnosisDescription(languageId);
	}

	/**
	 * Returns the localized diagnosis description of this trainee logged procedure details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized diagnosis description of this trainee logged procedure details
	 */
	@Override
	public String getDiagnosisDescription(
		String languageId, boolean useDefault) {

		return model.getDiagnosisDescription(languageId, useDefault);
	}

	@Override
	public String getDiagnosisDescriptionCurrentLanguageId() {
		return model.getDiagnosisDescriptionCurrentLanguageId();
	}

	@Override
	public String getDiagnosisDescriptionCurrentValue() {
		return model.getDiagnosisDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized diagnosis descriptions of this trainee logged procedure details.
	 *
	 * @return the locales and localized diagnosis descriptions of this trainee logged procedure details
	 */
	@Override
	public Map<java.util.Locale, String> getDiagnosisDescriptionMap() {
		return model.getDiagnosisDescriptionMap();
	}

	/**
	 * Returns the faculty ID of this trainee logged procedure details.
	 *
	 * @return the faculty ID of this trainee logged procedure details
	 */
	@Override
	public long getFacultyId() {
		return model.getFacultyId();
	}

	/**
	 * Returns the gender ID of this trainee logged procedure details.
	 *
	 * @return the gender ID of this trainee logged procedure details
	 */
	@Override
	public long getGenderId() {
		return model.getGenderId();
	}

	/**
	 * Returns the group ID of this trainee logged procedure details.
	 *
	 * @return the group ID of this trainee logged procedure details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this trainee logged procedure details.
	 *
	 * @return the modified by of this trainee logged procedure details
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this trainee logged procedure details.
	 *
	 * @return the modified date of this trainee logged procedure details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the patient dob of this trainee logged procedure details.
	 *
	 * @return the patient dob of this trainee logged procedure details
	 */
	@Override
	public Date getPatientDOB() {
		return model.getPatientDOB();
	}

	/**
	 * Returns the patient ID of this trainee logged procedure details.
	 *
	 * @return the patient ID of this trainee logged procedure details
	 */
	@Override
	public String getPatientId() {
		return model.getPatientId();
	}

	/**
	 * Returns the patient type ID of this trainee logged procedure details.
	 *
	 * @return the patient type ID of this trainee logged procedure details
	 */
	@Override
	public long getPatientTypeId() {
		return model.getPatientTypeId();
	}

	/**
	 * Returns the primary key of this trainee logged procedure details.
	 *
	 * @return the primary key of this trainee logged procedure details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedure group ID of this trainee logged procedure details.
	 *
	 * @return the procedure group ID of this trainee logged procedure details
	 */
	@Override
	public long getProcedureGroupId() {
		return model.getProcedureGroupId();
	}

	/**
	 * Returns the procedure ID of this trainee logged procedure details.
	 *
	 * @return the procedure ID of this trainee logged procedure details
	 */
	@Override
	public long getProcedureId() {
		return model.getProcedureId();
	}

	/**
	 * Returns the procedure performed date of this trainee logged procedure details.
	 *
	 * @return the procedure performed date of this trainee logged procedure details
	 */
	@Override
	public Date getProcedurePerformedDate() {
		return model.getProcedurePerformedDate();
	}

	/**
	 * Returns the procedure status of this trainee logged procedure details.
	 *
	 * @return the procedure status of this trainee logged procedure details
	 */
	@Override
	public String getProcedureStatus() {
		return model.getProcedureStatus();
	}

	/**
	 * Returns the program duration ID of this trainee logged procedure details.
	 *
	 * @return the program duration ID of this trainee logged procedure details
	 */
	@Override
	public long getProgramDurationId() {
		return model.getProgramDurationId();
	}

	/**
	 * Returns the role type ID of this trainee logged procedure details.
	 *
	 * @return the role type ID of this trainee logged procedure details
	 */
	@Override
	public long getRoleTypeId() {
		return model.getRoleTypeId();
	}

	/**
	 * Returns the rotation ID of this trainee logged procedure details.
	 *
	 * @return the rotation ID of this trainee logged procedure details
	 */
	@Override
	public long getRotationId() {
		return model.getRotationId();
	}

	/**
	 * Returns the supervisor comments of this trainee logged procedure details.
	 *
	 * @return the supervisor comments of this trainee logged procedure details
	 */
	@Override
	public String getSupervisorComments() {
		return model.getSupervisorComments();
	}

	/**
	 * Returns the localized supervisor comments of this trainee logged procedure details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized supervisor comments of this trainee logged procedure details
	 */
	@Override
	public String getSupervisorComments(java.util.Locale locale) {
		return model.getSupervisorComments(locale);
	}

	/**
	 * Returns the localized supervisor comments of this trainee logged procedure details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized supervisor comments of this trainee logged procedure details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSupervisorComments(
		java.util.Locale locale, boolean useDefault) {

		return model.getSupervisorComments(locale, useDefault);
	}

	/**
	 * Returns the localized supervisor comments of this trainee logged procedure details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized supervisor comments of this trainee logged procedure details
	 */
	@Override
	public String getSupervisorComments(String languageId) {
		return model.getSupervisorComments(languageId);
	}

	/**
	 * Returns the localized supervisor comments of this trainee logged procedure details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized supervisor comments of this trainee logged procedure details
	 */
	@Override
	public String getSupervisorComments(String languageId, boolean useDefault) {
		return model.getSupervisorComments(languageId, useDefault);
	}

	@Override
	public String getSupervisorCommentsCurrentLanguageId() {
		return model.getSupervisorCommentsCurrentLanguageId();
	}

	@Override
	public String getSupervisorCommentsCurrentValue() {
		return model.getSupervisorCommentsCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized supervisor commentses of this trainee logged procedure details.
	 *
	 * @return the locales and localized supervisor commentses of this trainee logged procedure details
	 */
	@Override
	public Map<java.util.Locale, String> getSupervisorCommentsMap() {
		return model.getSupervisorCommentsMap();
	}

	/**
	 * Returns the trainee comments of this trainee logged procedure details.
	 *
	 * @return the trainee comments of this trainee logged procedure details
	 */
	@Override
	public String getTraineeComments() {
		return model.getTraineeComments();
	}

	/**
	 * Returns the localized trainee comments of this trainee logged procedure details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized trainee comments of this trainee logged procedure details
	 */
	@Override
	public String getTraineeComments(java.util.Locale locale) {
		return model.getTraineeComments(locale);
	}

	/**
	 * Returns the localized trainee comments of this trainee logged procedure details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized trainee comments of this trainee logged procedure details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTraineeComments(
		java.util.Locale locale, boolean useDefault) {

		return model.getTraineeComments(locale, useDefault);
	}

	/**
	 * Returns the localized trainee comments of this trainee logged procedure details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized trainee comments of this trainee logged procedure details
	 */
	@Override
	public String getTraineeComments(String languageId) {
		return model.getTraineeComments(languageId);
	}

	/**
	 * Returns the localized trainee comments of this trainee logged procedure details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized trainee comments of this trainee logged procedure details
	 */
	@Override
	public String getTraineeComments(String languageId, boolean useDefault) {
		return model.getTraineeComments(languageId, useDefault);
	}

	@Override
	public String getTraineeCommentsCurrentLanguageId() {
		return model.getTraineeCommentsCurrentLanguageId();
	}

	@Override
	public String getTraineeCommentsCurrentValue() {
		return model.getTraineeCommentsCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized trainee commentses of this trainee logged procedure details.
	 *
	 * @return the locales and localized trainee commentses of this trainee logged procedure details
	 */
	@Override
	public Map<java.util.Locale, String> getTraineeCommentsMap() {
		return model.getTraineeCommentsMap();
	}

	/**
	 * Returns the trainee ID of this trainee logged procedure details.
	 *
	 * @return the trainee ID of this trainee logged procedure details
	 */
	@Override
	public long getTraineeId() {
		return model.getTraineeId();
	}

	/**
	 * Returns the trainee level ID of this trainee logged procedure details.
	 *
	 * @return the trainee level ID of this trainee logged procedure details
	 */
	@Override
	public long getTraineeLevelId() {
		return model.getTraineeLevelId();
	}

	/**
	 * Returns the trainee logged procedure details ID of this trainee logged procedure details.
	 *
	 * @return the trainee logged procedure details ID of this trainee logged procedure details
	 */
	@Override
	public long getTraineeLoggedProcedureDetailsId() {
		return model.getTraineeLoggedProcedureDetailsId();
	}

	/**
	 * Returns the training sites ID of this trainee logged procedure details.
	 *
	 * @return the training sites ID of this trainee logged procedure details
	 */
	@Override
	public long getTrainingSitesId() {
		return model.getTrainingSitesId();
	}

	/**
	 * Returns the uuid of this trainee logged procedure details.
	 *
	 * @return the uuid of this trainee logged procedure details
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the visit type ID of this trainee logged procedure details.
	 *
	 * @return the visit type ID of this trainee logged procedure details
	 */
	@Override
	public long getVisitTypeId() {
		return model.getVisitTypeId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the company ID of this trainee logged procedure details.
	 *
	 * @param companyId the company ID of this trainee logged procedure details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the cpt code of this trainee logged procedure details.
	 *
	 * @param cptCode the cpt code of this trainee logged procedure details
	 */
	@Override
	public void setCptCode(String cptCode) {
		model.setCptCode(cptCode);
	}

	/**
	 * Sets the localized cpt code of this trainee logged procedure details in the language.
	 *
	 * @param cptCode the localized cpt code of this trainee logged procedure details
	 * @param locale the locale of the language
	 */
	@Override
	public void setCptCode(String cptCode, java.util.Locale locale) {
		model.setCptCode(cptCode, locale);
	}

	/**
	 * Sets the localized cpt code of this trainee logged procedure details in the language, and sets the default locale.
	 *
	 * @param cptCode the localized cpt code of this trainee logged procedure details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCptCode(
		String cptCode, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setCptCode(cptCode, locale, defaultLocale);
	}

	@Override
	public void setCptCodeCurrentLanguageId(String languageId) {
		model.setCptCodeCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized cpt codes of this trainee logged procedure details from the map of locales and localized cpt codes.
	 *
	 * @param cptCodeMap the locales and localized cpt codes of this trainee logged procedure details
	 */
	@Override
	public void setCptCodeMap(Map<java.util.Locale, String> cptCodeMap) {
		model.setCptCodeMap(cptCodeMap);
	}

	/**
	 * Sets the localized cpt codes of this trainee logged procedure details from the map of locales and localized cpt codes, and sets the default locale.
	 *
	 * @param cptCodeMap the locales and localized cpt codes of this trainee logged procedure details
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCptCodeMap(
		Map<java.util.Locale, String> cptCodeMap,
		java.util.Locale defaultLocale) {

		model.setCptCodeMap(cptCodeMap, defaultLocale);
	}

	/**
	 * Sets the create date of this trainee logged procedure details.
	 *
	 * @param createDate the create date of this trainee logged procedure details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this trainee logged procedure details.
	 *
	 * @param createdBy the created by of this trainee logged procedure details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the diagnosis description of this trainee logged procedure details.
	 *
	 * @param diagnosisDescription the diagnosis description of this trainee logged procedure details
	 */
	@Override
	public void setDiagnosisDescription(String diagnosisDescription) {
		model.setDiagnosisDescription(diagnosisDescription);
	}

	/**
	 * Sets the localized diagnosis description of this trainee logged procedure details in the language.
	 *
	 * @param diagnosisDescription the localized diagnosis description of this trainee logged procedure details
	 * @param locale the locale of the language
	 */
	@Override
	public void setDiagnosisDescription(
		String diagnosisDescription, java.util.Locale locale) {

		model.setDiagnosisDescription(diagnosisDescription, locale);
	}

	/**
	 * Sets the localized diagnosis description of this trainee logged procedure details in the language, and sets the default locale.
	 *
	 * @param diagnosisDescription the localized diagnosis description of this trainee logged procedure details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDiagnosisDescription(
		String diagnosisDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDiagnosisDescription(
			diagnosisDescription, locale, defaultLocale);
	}

	@Override
	public void setDiagnosisDescriptionCurrentLanguageId(String languageId) {
		model.setDiagnosisDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized diagnosis descriptions of this trainee logged procedure details from the map of locales and localized diagnosis descriptions.
	 *
	 * @param diagnosisDescriptionMap the locales and localized diagnosis descriptions of this trainee logged procedure details
	 */
	@Override
	public void setDiagnosisDescriptionMap(
		Map<java.util.Locale, String> diagnosisDescriptionMap) {

		model.setDiagnosisDescriptionMap(diagnosisDescriptionMap);
	}

	/**
	 * Sets the localized diagnosis descriptions of this trainee logged procedure details from the map of locales and localized diagnosis descriptions, and sets the default locale.
	 *
	 * @param diagnosisDescriptionMap the locales and localized diagnosis descriptions of this trainee logged procedure details
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDiagnosisDescriptionMap(
		Map<java.util.Locale, String> diagnosisDescriptionMap,
		java.util.Locale defaultLocale) {

		model.setDiagnosisDescriptionMap(
			diagnosisDescriptionMap, defaultLocale);
	}

	/**
	 * Sets the faculty ID of this trainee logged procedure details.
	 *
	 * @param facultyId the faculty ID of this trainee logged procedure details
	 */
	@Override
	public void setFacultyId(long facultyId) {
		model.setFacultyId(facultyId);
	}

	/**
	 * Sets the gender ID of this trainee logged procedure details.
	 *
	 * @param genderId the gender ID of this trainee logged procedure details
	 */
	@Override
	public void setGenderId(long genderId) {
		model.setGenderId(genderId);
	}

	/**
	 * Sets the group ID of this trainee logged procedure details.
	 *
	 * @param groupId the group ID of this trainee logged procedure details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this trainee logged procedure details.
	 *
	 * @param modifiedBy the modified by of this trainee logged procedure details
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this trainee logged procedure details.
	 *
	 * @param modifiedDate the modified date of this trainee logged procedure details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the patient dob of this trainee logged procedure details.
	 *
	 * @param patientDOB the patient dob of this trainee logged procedure details
	 */
	@Override
	public void setPatientDOB(Date patientDOB) {
		model.setPatientDOB(patientDOB);
	}

	/**
	 * Sets the patient ID of this trainee logged procedure details.
	 *
	 * @param patientId the patient ID of this trainee logged procedure details
	 */
	@Override
	public void setPatientId(String patientId) {
		model.setPatientId(patientId);
	}

	/**
	 * Sets the patient type ID of this trainee logged procedure details.
	 *
	 * @param patientTypeId the patient type ID of this trainee logged procedure details
	 */
	@Override
	public void setPatientTypeId(long patientTypeId) {
		model.setPatientTypeId(patientTypeId);
	}

	/**
	 * Sets the primary key of this trainee logged procedure details.
	 *
	 * @param primaryKey the primary key of this trainee logged procedure details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedure group ID of this trainee logged procedure details.
	 *
	 * @param procedureGroupId the procedure group ID of this trainee logged procedure details
	 */
	@Override
	public void setProcedureGroupId(long procedureGroupId) {
		model.setProcedureGroupId(procedureGroupId);
	}

	/**
	 * Sets the procedure ID of this trainee logged procedure details.
	 *
	 * @param procedureId the procedure ID of this trainee logged procedure details
	 */
	@Override
	public void setProcedureId(long procedureId) {
		model.setProcedureId(procedureId);
	}

	/**
	 * Sets the procedure performed date of this trainee logged procedure details.
	 *
	 * @param procedurePerformedDate the procedure performed date of this trainee logged procedure details
	 */
	@Override
	public void setProcedurePerformedDate(Date procedurePerformedDate) {
		model.setProcedurePerformedDate(procedurePerformedDate);
	}

	/**
	 * Sets the procedure status of this trainee logged procedure details.
	 *
	 * @param procedureStatus the procedure status of this trainee logged procedure details
	 */
	@Override
	public void setProcedureStatus(String procedureStatus) {
		model.setProcedureStatus(procedureStatus);
	}

	/**
	 * Sets the program duration ID of this trainee logged procedure details.
	 *
	 * @param programDurationId the program duration ID of this trainee logged procedure details
	 */
	@Override
	public void setProgramDurationId(long programDurationId) {
		model.setProgramDurationId(programDurationId);
	}

	/**
	 * Sets the role type ID of this trainee logged procedure details.
	 *
	 * @param roleTypeId the role type ID of this trainee logged procedure details
	 */
	@Override
	public void setRoleTypeId(long roleTypeId) {
		model.setRoleTypeId(roleTypeId);
	}

	/**
	 * Sets the rotation ID of this trainee logged procedure details.
	 *
	 * @param rotationId the rotation ID of this trainee logged procedure details
	 */
	@Override
	public void setRotationId(long rotationId) {
		model.setRotationId(rotationId);
	}

	/**
	 * Sets the supervisor comments of this trainee logged procedure details.
	 *
	 * @param supervisorComments the supervisor comments of this trainee logged procedure details
	 */
	@Override
	public void setSupervisorComments(String supervisorComments) {
		model.setSupervisorComments(supervisorComments);
	}

	/**
	 * Sets the localized supervisor comments of this trainee logged procedure details in the language.
	 *
	 * @param supervisorComments the localized supervisor comments of this trainee logged procedure details
	 * @param locale the locale of the language
	 */
	@Override
	public void setSupervisorComments(
		String supervisorComments, java.util.Locale locale) {

		model.setSupervisorComments(supervisorComments, locale);
	}

	/**
	 * Sets the localized supervisor comments of this trainee logged procedure details in the language, and sets the default locale.
	 *
	 * @param supervisorComments the localized supervisor comments of this trainee logged procedure details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSupervisorComments(
		String supervisorComments, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setSupervisorComments(supervisorComments, locale, defaultLocale);
	}

	@Override
	public void setSupervisorCommentsCurrentLanguageId(String languageId) {
		model.setSupervisorCommentsCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized supervisor commentses of this trainee logged procedure details from the map of locales and localized supervisor commentses.
	 *
	 * @param supervisorCommentsMap the locales and localized supervisor commentses of this trainee logged procedure details
	 */
	@Override
	public void setSupervisorCommentsMap(
		Map<java.util.Locale, String> supervisorCommentsMap) {

		model.setSupervisorCommentsMap(supervisorCommentsMap);
	}

	/**
	 * Sets the localized supervisor commentses of this trainee logged procedure details from the map of locales and localized supervisor commentses, and sets the default locale.
	 *
	 * @param supervisorCommentsMap the locales and localized supervisor commentses of this trainee logged procedure details
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSupervisorCommentsMap(
		Map<java.util.Locale, String> supervisorCommentsMap,
		java.util.Locale defaultLocale) {

		model.setSupervisorCommentsMap(supervisorCommentsMap, defaultLocale);
	}

	/**
	 * Sets the trainee comments of this trainee logged procedure details.
	 *
	 * @param traineeComments the trainee comments of this trainee logged procedure details
	 */
	@Override
	public void setTraineeComments(String traineeComments) {
		model.setTraineeComments(traineeComments);
	}

	/**
	 * Sets the localized trainee comments of this trainee logged procedure details in the language.
	 *
	 * @param traineeComments the localized trainee comments of this trainee logged procedure details
	 * @param locale the locale of the language
	 */
	@Override
	public void setTraineeComments(
		String traineeComments, java.util.Locale locale) {

		model.setTraineeComments(traineeComments, locale);
	}

	/**
	 * Sets the localized trainee comments of this trainee logged procedure details in the language, and sets the default locale.
	 *
	 * @param traineeComments the localized trainee comments of this trainee logged procedure details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTraineeComments(
		String traineeComments, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setTraineeComments(traineeComments, locale, defaultLocale);
	}

	@Override
	public void setTraineeCommentsCurrentLanguageId(String languageId) {
		model.setTraineeCommentsCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized trainee commentses of this trainee logged procedure details from the map of locales and localized trainee commentses.
	 *
	 * @param traineeCommentsMap the locales and localized trainee commentses of this trainee logged procedure details
	 */
	@Override
	public void setTraineeCommentsMap(
		Map<java.util.Locale, String> traineeCommentsMap) {

		model.setTraineeCommentsMap(traineeCommentsMap);
	}

	/**
	 * Sets the localized trainee commentses of this trainee logged procedure details from the map of locales and localized trainee commentses, and sets the default locale.
	 *
	 * @param traineeCommentsMap the locales and localized trainee commentses of this trainee logged procedure details
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTraineeCommentsMap(
		Map<java.util.Locale, String> traineeCommentsMap,
		java.util.Locale defaultLocale) {

		model.setTraineeCommentsMap(traineeCommentsMap, defaultLocale);
	}

	/**
	 * Sets the trainee ID of this trainee logged procedure details.
	 *
	 * @param traineeId the trainee ID of this trainee logged procedure details
	 */
	@Override
	public void setTraineeId(long traineeId) {
		model.setTraineeId(traineeId);
	}

	/**
	 * Sets the trainee level ID of this trainee logged procedure details.
	 *
	 * @param traineeLevelId the trainee level ID of this trainee logged procedure details
	 */
	@Override
	public void setTraineeLevelId(long traineeLevelId) {
		model.setTraineeLevelId(traineeLevelId);
	}

	/**
	 * Sets the trainee logged procedure details ID of this trainee logged procedure details.
	 *
	 * @param traineeLoggedProcedureDetailsId the trainee logged procedure details ID of this trainee logged procedure details
	 */
	@Override
	public void setTraineeLoggedProcedureDetailsId(
		long traineeLoggedProcedureDetailsId) {

		model.setTraineeLoggedProcedureDetailsId(
			traineeLoggedProcedureDetailsId);
	}

	/**
	 * Sets the training sites ID of this trainee logged procedure details.
	 *
	 * @param trainingSitesId the training sites ID of this trainee logged procedure details
	 */
	@Override
	public void setTrainingSitesId(long trainingSitesId) {
		model.setTrainingSitesId(trainingSitesId);
	}

	/**
	 * Sets the uuid of this trainee logged procedure details.
	 *
	 * @param uuid the uuid of this trainee logged procedure details
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the visit type ID of this trainee logged procedure details.
	 *
	 * @param visitTypeId the visit type ID of this trainee logged procedure details
	 */
	@Override
	public void setVisitTypeId(long visitTypeId) {
		model.setVisitTypeId(visitTypeId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected TraineeLoggedProcedureDetailsWrapper wrap(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails) {

		return new TraineeLoggedProcedureDetailsWrapper(
			traineeLoggedProcedureDetails);
	}

}