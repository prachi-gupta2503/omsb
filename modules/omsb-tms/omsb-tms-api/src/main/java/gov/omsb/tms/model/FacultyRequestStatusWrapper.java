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
 * This class is a wrapper for {@link FacultyRequestStatus}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestStatus
 * @generated
 */
public class FacultyRequestStatusWrapper
	extends BaseModelWrapper<FacultyRequestStatus>
	implements FacultyRequestStatus, ModelWrapper<FacultyRequestStatus> {

	public FacultyRequestStatusWrapper(
		FacultyRequestStatus facultyRequestStatus) {

		super(facultyRequestStatus);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("facultyRequestStatusId", getFacultyRequestStatusId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("nameEn", getNameEn());
		attributes.put("nameAr", getNameAr());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long facultyRequestStatusId = (Long)attributes.get(
			"facultyRequestStatusId");

		if (facultyRequestStatusId != null) {
			setFacultyRequestStatusId(facultyRequestStatusId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String nameEn = (String)attributes.get("nameEn");

		if (nameEn != null) {
			setNameEn(nameEn);
		}

		String nameAr = (String)attributes.get("nameAr");

		if (nameAr != null) {
			setNameAr(nameAr);
		}
	}

	@Override
	public FacultyRequestStatus cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the code of this faculty request status.
	 *
	 * @return the code of this faculty request status
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this faculty request status.
	 *
	 * @return the company ID of this faculty request status
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this faculty request status.
	 *
	 * @return the create date of this faculty request status
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the faculty request status ID of this faculty request status.
	 *
	 * @return the faculty request status ID of this faculty request status
	 */
	@Override
	public long getFacultyRequestStatusId() {
		return model.getFacultyRequestStatusId();
	}

	/**
	 * Returns the group ID of this faculty request status.
	 *
	 * @return the group ID of this faculty request status
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this faculty request status.
	 *
	 * @return the modified date of this faculty request status
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name ar of this faculty request status.
	 *
	 * @return the name ar of this faculty request status
	 */
	@Override
	public String getNameAr() {
		return model.getNameAr();
	}

	/**
	 * Returns the name en of this faculty request status.
	 *
	 * @return the name en of this faculty request status
	 */
	@Override
	public String getNameEn() {
		return model.getNameEn();
	}

	/**
	 * Returns the primary key of this faculty request status.
	 *
	 * @return the primary key of this faculty request status
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this faculty request status.
	 *
	 * @return the uuid of this faculty request status
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
	 * Sets the code of this faculty request status.
	 *
	 * @param code the code of this faculty request status
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this faculty request status.
	 *
	 * @param companyId the company ID of this faculty request status
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this faculty request status.
	 *
	 * @param createDate the create date of this faculty request status
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the faculty request status ID of this faculty request status.
	 *
	 * @param facultyRequestStatusId the faculty request status ID of this faculty request status
	 */
	@Override
	public void setFacultyRequestStatusId(long facultyRequestStatusId) {
		model.setFacultyRequestStatusId(facultyRequestStatusId);
	}

	/**
	 * Sets the group ID of this faculty request status.
	 *
	 * @param groupId the group ID of this faculty request status
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this faculty request status.
	 *
	 * @param modifiedDate the modified date of this faculty request status
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name ar of this faculty request status.
	 *
	 * @param nameAr the name ar of this faculty request status
	 */
	@Override
	public void setNameAr(String nameAr) {
		model.setNameAr(nameAr);
	}

	/**
	 * Sets the name en of this faculty request status.
	 *
	 * @param nameEn the name en of this faculty request status
	 */
	@Override
	public void setNameEn(String nameEn) {
		model.setNameEn(nameEn);
	}

	/**
	 * Sets the primary key of this faculty request status.
	 *
	 * @param primaryKey the primary key of this faculty request status
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this faculty request status.
	 *
	 * @param uuid the uuid of this faculty request status
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
	protected FacultyRequestStatusWrapper wrap(
		FacultyRequestStatus facultyRequestStatus) {

		return new FacultyRequestStatusWrapper(facultyRequestStatus);
	}

}