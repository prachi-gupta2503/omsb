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
 * This class is a wrapper for {@link EcMemberRequestStatus}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestStatus
 * @generated
 */
public class EcMemberRequestStatusWrapper
	extends BaseModelWrapper<EcMemberRequestStatus>
	implements EcMemberRequestStatus, ModelWrapper<EcMemberRequestStatus> {

	public EcMemberRequestStatusWrapper(
		EcMemberRequestStatus ecMemberRequestStatus) {

		super(ecMemberRequestStatus);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ecMemberRequestStatusId", getEcMemberRequestStatusId());
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

		Long ecMemberRequestStatusId = (Long)attributes.get(
			"ecMemberRequestStatusId");

		if (ecMemberRequestStatusId != null) {
			setEcMemberRequestStatusId(ecMemberRequestStatusId);
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
	public EcMemberRequestStatus cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the code of this ec member request status.
	 *
	 * @return the code of this ec member request status
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this ec member request status.
	 *
	 * @return the company ID of this ec member request status
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ec member request status.
	 *
	 * @return the create date of this ec member request status
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the ec member request status ID of this ec member request status.
	 *
	 * @return the ec member request status ID of this ec member request status
	 */
	@Override
	public long getEcMemberRequestStatusId() {
		return model.getEcMemberRequestStatusId();
	}

	/**
	 * Returns the group ID of this ec member request status.
	 *
	 * @return the group ID of this ec member request status
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this ec member request status.
	 *
	 * @return the modified date of this ec member request status
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name ar of this ec member request status.
	 *
	 * @return the name ar of this ec member request status
	 */
	@Override
	public String getNameAr() {
		return model.getNameAr();
	}

	/**
	 * Returns the name en of this ec member request status.
	 *
	 * @return the name en of this ec member request status
	 */
	@Override
	public String getNameEn() {
		return model.getNameEn();
	}

	/**
	 * Returns the primary key of this ec member request status.
	 *
	 * @return the primary key of this ec member request status
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this ec member request status.
	 *
	 * @return the uuid of this ec member request status
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
	 * Sets the code of this ec member request status.
	 *
	 * @param code the code of this ec member request status
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this ec member request status.
	 *
	 * @param companyId the company ID of this ec member request status
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ec member request status.
	 *
	 * @param createDate the create date of this ec member request status
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the ec member request status ID of this ec member request status.
	 *
	 * @param ecMemberRequestStatusId the ec member request status ID of this ec member request status
	 */
	@Override
	public void setEcMemberRequestStatusId(long ecMemberRequestStatusId) {
		model.setEcMemberRequestStatusId(ecMemberRequestStatusId);
	}

	/**
	 * Sets the group ID of this ec member request status.
	 *
	 * @param groupId the group ID of this ec member request status
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this ec member request status.
	 *
	 * @param modifiedDate the modified date of this ec member request status
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name ar of this ec member request status.
	 *
	 * @param nameAr the name ar of this ec member request status
	 */
	@Override
	public void setNameAr(String nameAr) {
		model.setNameAr(nameAr);
	}

	/**
	 * Sets the name en of this ec member request status.
	 *
	 * @param nameEn the name en of this ec member request status
	 */
	@Override
	public void setNameEn(String nameEn) {
		model.setNameEn(nameEn);
	}

	/**
	 * Sets the primary key of this ec member request status.
	 *
	 * @param primaryKey the primary key of this ec member request status
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this ec member request status.
	 *
	 * @param uuid the uuid of this ec member request status
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
	protected EcMemberRequestStatusWrapper wrap(
		EcMemberRequestStatus ecMemberRequestStatus) {

		return new EcMemberRequestStatusWrapper(ecMemberRequestStatus);
	}

}