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
 * This class is a wrapper for {@link FacultyRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequest
 * @generated
 */
public class FacultyRequestWrapper
	extends BaseModelWrapper<FacultyRequest>
	implements FacultyRequest, ModelWrapper<FacultyRequest> {

	public FacultyRequestWrapper(FacultyRequest facultyRequest) {
		super(facultyRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("facultyRequestId", getFacultyRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("programId", getProgramId());
		attributes.put("potentialFacultyId", getPotentialFacultyId());
		attributes.put("potentialFacultyTypeId", getPotentialFacultyTypeId());
		attributes.put(
			"lastestFacultyRequestStateId", getLastestFacultyRequestStateId());
		attributes.put("coveringLetterId", getCoveringLetterId());
		attributes.put("cvId", getCvId());
		attributes.put("passportCopyId", getPassportCopyId());
		attributes.put("notionalIdCopyId", getNotionalIdCopyId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long facultyRequestId = (Long)attributes.get("facultyRequestId");

		if (facultyRequestId != null) {
			setFacultyRequestId(facultyRequestId);
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

		Long programId = (Long)attributes.get("programId");

		if (programId != null) {
			setProgramId(programId);
		}

		Long potentialFacultyId = (Long)attributes.get("potentialFacultyId");

		if (potentialFacultyId != null) {
			setPotentialFacultyId(potentialFacultyId);
		}

		Long potentialFacultyTypeId = (Long)attributes.get(
			"potentialFacultyTypeId");

		if (potentialFacultyTypeId != null) {
			setPotentialFacultyTypeId(potentialFacultyTypeId);
		}

		Long lastestFacultyRequestStateId = (Long)attributes.get(
			"lastestFacultyRequestStateId");

		if (lastestFacultyRequestStateId != null) {
			setLastestFacultyRequestStateId(lastestFacultyRequestStateId);
		}

		Long coveringLetterId = (Long)attributes.get("coveringLetterId");

		if (coveringLetterId != null) {
			setCoveringLetterId(coveringLetterId);
		}

		Long cvId = (Long)attributes.get("cvId");

		if (cvId != null) {
			setCvId(cvId);
		}

		Long passportCopyId = (Long)attributes.get("passportCopyId");

		if (passportCopyId != null) {
			setPassportCopyId(passportCopyId);
		}

		Long notionalIdCopyId = (Long)attributes.get("notionalIdCopyId");

		if (notionalIdCopyId != null) {
			setNotionalIdCopyId(notionalIdCopyId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public FacultyRequest cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this faculty request.
	 *
	 * @return the company ID of this faculty request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the covering letter ID of this faculty request.
	 *
	 * @return the covering letter ID of this faculty request
	 */
	@Override
	public long getCoveringLetterId() {
		return model.getCoveringLetterId();
	}

	/**
	 * Returns the create date of this faculty request.
	 *
	 * @return the create date of this faculty request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this faculty request.
	 *
	 * @return the created by of this faculty request
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the cv ID of this faculty request.
	 *
	 * @return the cv ID of this faculty request
	 */
	@Override
	public long getCvId() {
		return model.getCvId();
	}

	/**
	 * Returns the faculty request ID of this faculty request.
	 *
	 * @return the faculty request ID of this faculty request
	 */
	@Override
	public long getFacultyRequestId() {
		return model.getFacultyRequestId();
	}

	/**
	 * Returns the group ID of this faculty request.
	 *
	 * @return the group ID of this faculty request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the lastest faculty request state ID of this faculty request.
	 *
	 * @return the lastest faculty request state ID of this faculty request
	 */
	@Override
	public long getLastestFacultyRequestStateId() {
		return model.getLastestFacultyRequestStateId();
	}

	/**
	 * Returns the modified by of this faculty request.
	 *
	 * @return the modified by of this faculty request
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this faculty request.
	 *
	 * @return the modified date of this faculty request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the notional ID copy ID of this faculty request.
	 *
	 * @return the notional ID copy ID of this faculty request
	 */
	@Override
	public long getNotionalIdCopyId() {
		return model.getNotionalIdCopyId();
	}

	/**
	 * Returns the passport copy ID of this faculty request.
	 *
	 * @return the passport copy ID of this faculty request
	 */
	@Override
	public long getPassportCopyId() {
		return model.getPassportCopyId();
	}

	/**
	 * Returns the potential faculty ID of this faculty request.
	 *
	 * @return the potential faculty ID of this faculty request
	 */
	@Override
	public long getPotentialFacultyId() {
		return model.getPotentialFacultyId();
	}

	/**
	 * Returns the potential faculty type ID of this faculty request.
	 *
	 * @return the potential faculty type ID of this faculty request
	 */
	@Override
	public long getPotentialFacultyTypeId() {
		return model.getPotentialFacultyTypeId();
	}

	/**
	 * Returns the primary key of this faculty request.
	 *
	 * @return the primary key of this faculty request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program ID of this faculty request.
	 *
	 * @return the program ID of this faculty request
	 */
	@Override
	public long getProgramId() {
		return model.getProgramId();
	}

	/**
	 * Returns the status of this faculty request.
	 *
	 * @return the status of this faculty request
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this faculty request.
	 *
	 * @return the status by user ID of this faculty request
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this faculty request.
	 *
	 * @return the status by user name of this faculty request
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this faculty request.
	 *
	 * @return the status by user uuid of this faculty request
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this faculty request.
	 *
	 * @return the status date of this faculty request
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the uuid of this faculty request.
	 *
	 * @return the uuid of this faculty request
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this faculty request is approved.
	 *
	 * @return <code>true</code> if this faculty request is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this faculty request is denied.
	 *
	 * @return <code>true</code> if this faculty request is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this faculty request is a draft.
	 *
	 * @return <code>true</code> if this faculty request is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this faculty request is expired.
	 *
	 * @return <code>true</code> if this faculty request is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this faculty request is inactive.
	 *
	 * @return <code>true</code> if this faculty request is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this faculty request is incomplete.
	 *
	 * @return <code>true</code> if this faculty request is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this faculty request is pending.
	 *
	 * @return <code>true</code> if this faculty request is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this faculty request is scheduled.
	 *
	 * @return <code>true</code> if this faculty request is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this faculty request.
	 *
	 * @param companyId the company ID of this faculty request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the covering letter ID of this faculty request.
	 *
	 * @param coveringLetterId the covering letter ID of this faculty request
	 */
	@Override
	public void setCoveringLetterId(long coveringLetterId) {
		model.setCoveringLetterId(coveringLetterId);
	}

	/**
	 * Sets the create date of this faculty request.
	 *
	 * @param createDate the create date of this faculty request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this faculty request.
	 *
	 * @param createdBy the created by of this faculty request
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the cv ID of this faculty request.
	 *
	 * @param cvId the cv ID of this faculty request
	 */
	@Override
	public void setCvId(long cvId) {
		model.setCvId(cvId);
	}

	/**
	 * Sets the faculty request ID of this faculty request.
	 *
	 * @param facultyRequestId the faculty request ID of this faculty request
	 */
	@Override
	public void setFacultyRequestId(long facultyRequestId) {
		model.setFacultyRequestId(facultyRequestId);
	}

	/**
	 * Sets the group ID of this faculty request.
	 *
	 * @param groupId the group ID of this faculty request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the lastest faculty request state ID of this faculty request.
	 *
	 * @param lastestFacultyRequestStateId the lastest faculty request state ID of this faculty request
	 */
	@Override
	public void setLastestFacultyRequestStateId(
		long lastestFacultyRequestStateId) {

		model.setLastestFacultyRequestStateId(lastestFacultyRequestStateId);
	}

	/**
	 * Sets the modified by of this faculty request.
	 *
	 * @param modifiedBy the modified by of this faculty request
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this faculty request.
	 *
	 * @param modifiedDate the modified date of this faculty request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the notional ID copy ID of this faculty request.
	 *
	 * @param notionalIdCopyId the notional ID copy ID of this faculty request
	 */
	@Override
	public void setNotionalIdCopyId(long notionalIdCopyId) {
		model.setNotionalIdCopyId(notionalIdCopyId);
	}

	/**
	 * Sets the passport copy ID of this faculty request.
	 *
	 * @param passportCopyId the passport copy ID of this faculty request
	 */
	@Override
	public void setPassportCopyId(long passportCopyId) {
		model.setPassportCopyId(passportCopyId);
	}

	/**
	 * Sets the potential faculty ID of this faculty request.
	 *
	 * @param potentialFacultyId the potential faculty ID of this faculty request
	 */
	@Override
	public void setPotentialFacultyId(long potentialFacultyId) {
		model.setPotentialFacultyId(potentialFacultyId);
	}

	/**
	 * Sets the potential faculty type ID of this faculty request.
	 *
	 * @param potentialFacultyTypeId the potential faculty type ID of this faculty request
	 */
	@Override
	public void setPotentialFacultyTypeId(long potentialFacultyTypeId) {
		model.setPotentialFacultyTypeId(potentialFacultyTypeId);
	}

	/**
	 * Sets the primary key of this faculty request.
	 *
	 * @param primaryKey the primary key of this faculty request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program ID of this faculty request.
	 *
	 * @param programId the program ID of this faculty request
	 */
	@Override
	public void setProgramId(long programId) {
		model.setProgramId(programId);
	}

	/**
	 * Sets the status of this faculty request.
	 *
	 * @param status the status of this faculty request
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this faculty request.
	 *
	 * @param statusByUserId the status by user ID of this faculty request
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this faculty request.
	 *
	 * @param statusByUserName the status by user name of this faculty request
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this faculty request.
	 *
	 * @param statusByUserUuid the status by user uuid of this faculty request
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this faculty request.
	 *
	 * @param statusDate the status date of this faculty request
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the uuid of this faculty request.
	 *
	 * @param uuid the uuid of this faculty request
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
	protected FacultyRequestWrapper wrap(FacultyRequest facultyRequest) {
		return new FacultyRequestWrapper(facultyRequest);
	}

}