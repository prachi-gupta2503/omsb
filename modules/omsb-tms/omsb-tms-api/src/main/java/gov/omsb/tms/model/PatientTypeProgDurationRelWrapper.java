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
 * This class is a wrapper for {@link PatientTypeProgDurationRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientTypeProgDurationRel
 * @generated
 */
public class PatientTypeProgDurationRelWrapper
	extends BaseModelWrapper<PatientTypeProgDurationRel>
	implements ModelWrapper<PatientTypeProgDurationRel>,
			   PatientTypeProgDurationRel {

	public PatientTypeProgDurationRelWrapper(
		PatientTypeProgDurationRel patientTypeProgDurationRel) {

		super(patientTypeProgDurationRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"PatientTypeProgDurationRelId", getPatientTypeProgDurationRelId());
		attributes.put("patientTypeMasterId", getPatientTypeMasterId());
		attributes.put("programDurationId", getProgramDurationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PatientTypeProgDurationRelId = (Long)attributes.get(
			"PatientTypeProgDurationRelId");

		if (PatientTypeProgDurationRelId != null) {
			setPatientTypeProgDurationRelId(PatientTypeProgDurationRelId);
		}

		Long patientTypeMasterId = (Long)attributes.get("patientTypeMasterId");

		if (patientTypeMasterId != null) {
			setPatientTypeMasterId(patientTypeMasterId);
		}

		Long programDurationId = (Long)attributes.get("programDurationId");

		if (programDurationId != null) {
			setProgramDurationId(programDurationId);
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
	}

	@Override
	public PatientTypeProgDurationRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this patient type prog duration rel.
	 *
	 * @return the company ID of this patient type prog duration rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this patient type prog duration rel.
	 *
	 * @return the create date of this patient type prog duration rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this patient type prog duration rel.
	 *
	 * @return the created by of this patient type prog duration rel
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this patient type prog duration rel.
	 *
	 * @return the group ID of this patient type prog duration rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this patient type prog duration rel.
	 *
	 * @return the modified by of this patient type prog duration rel
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this patient type prog duration rel.
	 *
	 * @return the modified date of this patient type prog duration rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the patient type master ID of this patient type prog duration rel.
	 *
	 * @return the patient type master ID of this patient type prog duration rel
	 */
	@Override
	public long getPatientTypeMasterId() {
		return model.getPatientTypeMasterId();
	}

	/**
	 * Returns the patient type prog duration rel ID of this patient type prog duration rel.
	 *
	 * @return the patient type prog duration rel ID of this patient type prog duration rel
	 */
	@Override
	public long getPatientTypeProgDurationRelId() {
		return model.getPatientTypeProgDurationRelId();
	}

	/**
	 * Returns the primary key of this patient type prog duration rel.
	 *
	 * @return the primary key of this patient type prog duration rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program duration ID of this patient type prog duration rel.
	 *
	 * @return the program duration ID of this patient type prog duration rel
	 */
	@Override
	public long getProgramDurationId() {
		return model.getProgramDurationId();
	}

	/**
	 * Returns the uuid of this patient type prog duration rel.
	 *
	 * @return the uuid of this patient type prog duration rel
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this patient type prog duration rel.
	 *
	 * @param companyId the company ID of this patient type prog duration rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this patient type prog duration rel.
	 *
	 * @param createDate the create date of this patient type prog duration rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this patient type prog duration rel.
	 *
	 * @param createdBy the created by of this patient type prog duration rel
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this patient type prog duration rel.
	 *
	 * @param groupId the group ID of this patient type prog duration rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this patient type prog duration rel.
	 *
	 * @param modifiedBy the modified by of this patient type prog duration rel
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this patient type prog duration rel.
	 *
	 * @param modifiedDate the modified date of this patient type prog duration rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the patient type master ID of this patient type prog duration rel.
	 *
	 * @param patientTypeMasterId the patient type master ID of this patient type prog duration rel
	 */
	@Override
	public void setPatientTypeMasterId(long patientTypeMasterId) {
		model.setPatientTypeMasterId(patientTypeMasterId);
	}

	/**
	 * Sets the patient type prog duration rel ID of this patient type prog duration rel.
	 *
	 * @param PatientTypeProgDurationRelId the patient type prog duration rel ID of this patient type prog duration rel
	 */
	@Override
	public void setPatientTypeProgDurationRelId(
		long PatientTypeProgDurationRelId) {

		model.setPatientTypeProgDurationRelId(PatientTypeProgDurationRelId);
	}

	/**
	 * Sets the primary key of this patient type prog duration rel.
	 *
	 * @param primaryKey the primary key of this patient type prog duration rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program duration ID of this patient type prog duration rel.
	 *
	 * @param programDurationId the program duration ID of this patient type prog duration rel
	 */
	@Override
	public void setProgramDurationId(long programDurationId) {
		model.setProgramDurationId(programDurationId);
	}

	/**
	 * Sets the uuid of this patient type prog duration rel.
	 *
	 * @param uuid the uuid of this patient type prog duration rel
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
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
	protected PatientTypeProgDurationRelWrapper wrap(
		PatientTypeProgDurationRel patientTypeProgDurationRel) {

		return new PatientTypeProgDurationRelWrapper(
			patientTypeProgDurationRel);
	}

}