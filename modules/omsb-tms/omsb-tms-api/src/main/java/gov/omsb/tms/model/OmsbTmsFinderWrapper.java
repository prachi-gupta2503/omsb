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
 * This class is a wrapper for {@link OmsbTmsFinder}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OmsbTmsFinder
 * @generated
 */
public class OmsbTmsFinderWrapper
	extends BaseModelWrapper<OmsbTmsFinder>
	implements ModelWrapper<OmsbTmsFinder>, OmsbTmsFinder {

	public OmsbTmsFinderWrapper(OmsbTmsFinder omsbTmsFinder) {
		super(omsbTmsFinder);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("omsbTmsFinderId", getOmsbTmsFinderId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long omsbTmsFinderId = (Long)attributes.get("omsbTmsFinderId");

		if (omsbTmsFinderId != null) {
			setOmsbTmsFinderId(omsbTmsFinderId);
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
	}

	@Override
	public OmsbTmsFinder cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this omsb tms finder.
	 *
	 * @return the company ID of this omsb tms finder
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this omsb tms finder.
	 *
	 * @return the create date of this omsb tms finder
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this omsb tms finder.
	 *
	 * @return the group ID of this omsb tms finder
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this omsb tms finder.
	 *
	 * @return the modified date of this omsb tms finder
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the omsb tms finder ID of this omsb tms finder.
	 *
	 * @return the omsb tms finder ID of this omsb tms finder
	 */
	@Override
	public long getOmsbTmsFinderId() {
		return model.getOmsbTmsFinderId();
	}

	/**
	 * Returns the primary key of this omsb tms finder.
	 *
	 * @return the primary key of this omsb tms finder
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this omsb tms finder.
	 *
	 * @return the uuid of this omsb tms finder
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
	 * Sets the company ID of this omsb tms finder.
	 *
	 * @param companyId the company ID of this omsb tms finder
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this omsb tms finder.
	 *
	 * @param createDate the create date of this omsb tms finder
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this omsb tms finder.
	 *
	 * @param groupId the group ID of this omsb tms finder
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this omsb tms finder.
	 *
	 * @param modifiedDate the modified date of this omsb tms finder
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the omsb tms finder ID of this omsb tms finder.
	 *
	 * @param omsbTmsFinderId the omsb tms finder ID of this omsb tms finder
	 */
	@Override
	public void setOmsbTmsFinderId(long omsbTmsFinderId) {
		model.setOmsbTmsFinderId(omsbTmsFinderId);
	}

	/**
	 * Sets the primary key of this omsb tms finder.
	 *
	 * @param primaryKey the primary key of this omsb tms finder
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this omsb tms finder.
	 *
	 * @param uuid the uuid of this omsb tms finder
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
	protected OmsbTmsFinderWrapper wrap(OmsbTmsFinder omsbTmsFinder) {
		return new OmsbTmsFinderWrapper(omsbTmsFinder);
	}

}