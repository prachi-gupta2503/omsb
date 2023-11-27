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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FacultyType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyType
 * @generated
 */
public class FacultyTypeWrapper
	extends BaseModelWrapper<FacultyType>
	implements FacultyType, ModelWrapper<FacultyType> {

	public FacultyTypeWrapper(FacultyType facultyType) {
		super(facultyType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("facultyTypeId", getFacultyTypeId());
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
		Long facultyTypeId = (Long)attributes.get("facultyTypeId");

		if (facultyTypeId != null) {
			setFacultyTypeId(facultyTypeId);
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
	public FacultyType cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the code of this faculty type.
	 *
	 * @return the code of this faculty type
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this faculty type.
	 *
	 * @return the company ID of this faculty type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this faculty type.
	 *
	 * @return the create date of this faculty type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the faculty type ID of this faculty type.
	 *
	 * @return the faculty type ID of this faculty type
	 */
	@Override
	public long getFacultyTypeId() {
		return model.getFacultyTypeId();
	}

	/**
	 * Returns the group ID of this faculty type.
	 *
	 * @return the group ID of this faculty type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this faculty type.
	 *
	 * @return the modified date of this faculty type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name ar of this faculty type.
	 *
	 * @return the name ar of this faculty type
	 */
	@Override
	public String getNameAr() {
		return model.getNameAr();
	}

	/**
	 * Returns the name en of this faculty type.
	 *
	 * @return the name en of this faculty type
	 */
	@Override
	public String getNameEn() {
		return model.getNameEn();
	}

	/**
	 * Returns the primary key of this faculty type.
	 *
	 * @return the primary key of this faculty type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the code of this faculty type.
	 *
	 * @param code the code of this faculty type
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this faculty type.
	 *
	 * @param companyId the company ID of this faculty type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this faculty type.
	 *
	 * @param createDate the create date of this faculty type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the faculty type ID of this faculty type.
	 *
	 * @param facultyTypeId the faculty type ID of this faculty type
	 */
	@Override
	public void setFacultyTypeId(long facultyTypeId) {
		model.setFacultyTypeId(facultyTypeId);
	}

	/**
	 * Sets the group ID of this faculty type.
	 *
	 * @param groupId the group ID of this faculty type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this faculty type.
	 *
	 * @param modifiedDate the modified date of this faculty type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name ar of this faculty type.
	 *
	 * @param nameAr the name ar of this faculty type
	 */
	@Override
	public void setNameAr(String nameAr) {
		model.setNameAr(nameAr);
	}

	/**
	 * Sets the name en of this faculty type.
	 *
	 * @param nameEn the name en of this faculty type
	 */
	@Override
	public void setNameEn(String nameEn) {
		model.setNameEn(nameEn);
	}

	/**
	 * Sets the primary key of this faculty type.
	 *
	 * @param primaryKey the primary key of this faculty type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected FacultyTypeWrapper wrap(FacultyType facultyType) {
		return new FacultyTypeWrapper(facultyType);
	}

}