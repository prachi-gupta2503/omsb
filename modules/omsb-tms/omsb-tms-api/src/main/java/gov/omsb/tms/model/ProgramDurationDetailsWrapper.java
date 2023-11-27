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
 * This class is a wrapper for {@link ProgramDurationDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDurationDetails
 * @generated
 */
public class ProgramDurationDetailsWrapper
	extends BaseModelWrapper<ProgramDurationDetails>
	implements ModelWrapper<ProgramDurationDetails>, ProgramDurationDetails {

	public ProgramDurationDetailsWrapper(
		ProgramDurationDetails programDurationDetails) {

		super(programDurationDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("progDurationId", getProgDurationId());
		attributes.put("programId", getProgramId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ayApplicableForm", getAyApplicableForm());
		attributes.put("noOfBlocks", getNoOfBlocks());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long progDurationId = (Long)attributes.get("progDurationId");

		if (progDurationId != null) {
			setProgDurationId(progDurationId);
		}

		Long programId = (Long)attributes.get("programId");

		if (programId != null) {
			setProgramId(programId);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String ayApplicableForm = (String)attributes.get("ayApplicableForm");

		if (ayApplicableForm != null) {
			setAyApplicableForm(ayApplicableForm);
		}

		Integer noOfBlocks = (Integer)attributes.get("noOfBlocks");

		if (noOfBlocks != null) {
			setNoOfBlocks(noOfBlocks);
		}
	}

	@Override
	public ProgramDurationDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ay applicable form of this program duration details.
	 *
	 * @return the ay applicable form of this program duration details
	 */
	@Override
	public String getAyApplicableForm() {
		return model.getAyApplicableForm();
	}

	/**
	 * Returns the company ID of this program duration details.
	 *
	 * @return the company ID of this program duration details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this program duration details.
	 *
	 * @return the create date of this program duration details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this program duration details.
	 *
	 * @return the group ID of this program duration details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this program duration details.
	 *
	 * @return the modified date of this program duration details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the no of blocks of this program duration details.
	 *
	 * @return the no of blocks of this program duration details
	 */
	@Override
	public int getNoOfBlocks() {
		return model.getNoOfBlocks();
	}

	/**
	 * Returns the primary key of this program duration details.
	 *
	 * @return the primary key of this program duration details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prog duration ID of this program duration details.
	 *
	 * @return the prog duration ID of this program duration details
	 */
	@Override
	public long getProgDurationId() {
		return model.getProgDurationId();
	}

	/**
	 * Returns the program ID of this program duration details.
	 *
	 * @return the program ID of this program duration details
	 */
	@Override
	public long getProgramId() {
		return model.getProgramId();
	}

	/**
	 * Returns the uuid of this program duration details.
	 *
	 * @return the uuid of this program duration details
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
	 * Sets the ay applicable form of this program duration details.
	 *
	 * @param ayApplicableForm the ay applicable form of this program duration details
	 */
	@Override
	public void setAyApplicableForm(String ayApplicableForm) {
		model.setAyApplicableForm(ayApplicableForm);
	}

	/**
	 * Sets the company ID of this program duration details.
	 *
	 * @param companyId the company ID of this program duration details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this program duration details.
	 *
	 * @param createDate the create date of this program duration details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this program duration details.
	 *
	 * @param groupId the group ID of this program duration details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this program duration details.
	 *
	 * @param modifiedDate the modified date of this program duration details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the no of blocks of this program duration details.
	 *
	 * @param noOfBlocks the no of blocks of this program duration details
	 */
	@Override
	public void setNoOfBlocks(int noOfBlocks) {
		model.setNoOfBlocks(noOfBlocks);
	}

	/**
	 * Sets the primary key of this program duration details.
	 *
	 * @param primaryKey the primary key of this program duration details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prog duration ID of this program duration details.
	 *
	 * @param progDurationId the prog duration ID of this program duration details
	 */
	@Override
	public void setProgDurationId(long progDurationId) {
		model.setProgDurationId(progDurationId);
	}

	/**
	 * Sets the program ID of this program duration details.
	 *
	 * @param programId the program ID of this program duration details
	 */
	@Override
	public void setProgramId(long programId) {
		model.setProgramId(programId);
	}

	/**
	 * Sets the uuid of this program duration details.
	 *
	 * @param uuid the uuid of this program duration details
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
	protected ProgramDurationDetailsWrapper wrap(
		ProgramDurationDetails programDurationDetails) {

		return new ProgramDurationDetailsWrapper(programDurationDetails);
	}

}