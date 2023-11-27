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

package gov.omsb.form.builder.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RangeOptionMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RangeOptionMaster
 * @generated
 */
public class RangeOptionMasterWrapper
	extends BaseModelWrapper<RangeOptionMaster>
	implements ModelWrapper<RangeOptionMaster>, RangeOptionMaster {

	public RangeOptionMasterWrapper(RangeOptionMaster rangeOptionMaster) {
		super(rangeOptionMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rangeOptionId", getRangeOptionId());
		attributes.put("rangeOptionName", getRangeOptionName());
		attributes.put("rangeOptions", getRangeOptions());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rangeOptionId = (Long)attributes.get("rangeOptionId");

		if (rangeOptionId != null) {
			setRangeOptionId(rangeOptionId);
		}

		String rangeOptionName = (String)attributes.get("rangeOptionName");

		if (rangeOptionName != null) {
			setRangeOptionName(rangeOptionName);
		}

		String rangeOptions = (String)attributes.get("rangeOptions");

		if (rangeOptions != null) {
			setRangeOptions(rangeOptions);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public RangeOptionMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this range option master.
	 *
	 * @return the company ID of this range option master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the created by of this range option master.
	 *
	 * @return the created by of this range option master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this range option master.
	 *
	 * @return the created date of this range option master
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the group ID of this range option master.
	 *
	 * @return the group ID of this range option master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this range option master.
	 *
	 * @return the modified by of this range option master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this range option master.
	 *
	 * @return the modified date of this range option master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this range option master.
	 *
	 * @return the primary key of this range option master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the range option ID of this range option master.
	 *
	 * @return the range option ID of this range option master
	 */
	@Override
	public long getRangeOptionId() {
		return model.getRangeOptionId();
	}

	/**
	 * Returns the range option name of this range option master.
	 *
	 * @return the range option name of this range option master
	 */
	@Override
	public String getRangeOptionName() {
		return model.getRangeOptionName();
	}

	/**
	 * Returns the range options of this range option master.
	 *
	 * @return the range options of this range option master
	 */
	@Override
	public String getRangeOptions() {
		return model.getRangeOptions();
	}

	/**
	 * Returns the uuid of this range option master.
	 *
	 * @return the uuid of this range option master
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
	 * Sets the company ID of this range option master.
	 *
	 * @param companyId the company ID of this range option master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the created by of this range option master.
	 *
	 * @param createdBy the created by of this range option master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this range option master.
	 *
	 * @param createdDate the created date of this range option master
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the group ID of this range option master.
	 *
	 * @param groupId the group ID of this range option master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this range option master.
	 *
	 * @param modifiedBy the modified by of this range option master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this range option master.
	 *
	 * @param modifiedDate the modified date of this range option master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this range option master.
	 *
	 * @param primaryKey the primary key of this range option master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the range option ID of this range option master.
	 *
	 * @param rangeOptionId the range option ID of this range option master
	 */
	@Override
	public void setRangeOptionId(long rangeOptionId) {
		model.setRangeOptionId(rangeOptionId);
	}

	/**
	 * Sets the range option name of this range option master.
	 *
	 * @param rangeOptionName the range option name of this range option master
	 */
	@Override
	public void setRangeOptionName(String rangeOptionName) {
		model.setRangeOptionName(rangeOptionName);
	}

	/**
	 * Sets the range options of this range option master.
	 *
	 * @param rangeOptions the range options of this range option master
	 */
	@Override
	public void setRangeOptions(String rangeOptions) {
		model.setRangeOptions(rangeOptions);
	}

	/**
	 * Sets the uuid of this range option master.
	 *
	 * @param uuid the uuid of this range option master
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
	protected RangeOptionMasterWrapper wrap(
		RangeOptionMaster rangeOptionMaster) {

		return new RangeOptionMasterWrapper(rangeOptionMaster);
	}

}