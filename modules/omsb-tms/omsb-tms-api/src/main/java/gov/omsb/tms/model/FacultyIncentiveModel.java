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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the FacultyIncentive service. Represents a row in the &quot;faculty_incentive&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.FacultyIncentiveModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.FacultyIncentiveImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyIncentive
 * @generated
 */
@ProviderType
public interface FacultyIncentiveModel
	extends BaseModel<FacultyIncentive>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a faculty incentive model instance should use the {@link FacultyIncentive} interface instead.
	 */

	/**
	 * Returns the primary key of this faculty incentive.
	 *
	 * @return the primary key of this faculty incentive
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this faculty incentive.
	 *
	 * @param primaryKey the primary key of this faculty incentive
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this faculty incentive.
	 *
	 * @return the uuid of this faculty incentive
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this faculty incentive.
	 *
	 * @param uuid the uuid of this faculty incentive
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the faculty incentive ID of this faculty incentive.
	 *
	 * @return the faculty incentive ID of this faculty incentive
	 */
	public long getFacultyIncentiveId();

	/**
	 * Sets the faculty incentive ID of this faculty incentive.
	 *
	 * @param FacultyIncentiveId the faculty incentive ID of this faculty incentive
	 */
	public void setFacultyIncentiveId(long FacultyIncentiveId);

	/**
	 * Returns the group ID of this faculty incentive.
	 *
	 * @return the group ID of this faculty incentive
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this faculty incentive.
	 *
	 * @param groupId the group ID of this faculty incentive
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this faculty incentive.
	 *
	 * @return the company ID of this faculty incentive
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this faculty incentive.
	 *
	 * @param companyId the company ID of this faculty incentive
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this faculty incentive.
	 *
	 * @return the create date of this faculty incentive
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this faculty incentive.
	 *
	 * @param createDate the create date of this faculty incentive
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this faculty incentive.
	 *
	 * @return the modified date of this faculty incentive
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this faculty incentive.
	 *
	 * @param modifiedDate the modified date of this faculty incentive
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the role ID of this faculty incentive.
	 *
	 * @return the role ID of this faculty incentive
	 */
	public long getRoleId();

	/**
	 * Sets the role ID of this faculty incentive.
	 *
	 * @param roleId the role ID of this faculty incentive
	 */
	public void setRoleId(long roleId);

	/**
	 * Returns the amount in omr of this faculty incentive.
	 *
	 * @return the amount in omr of this faculty incentive
	 */
	public long getAmountInOMR();

	/**
	 * Sets the amount in omr of this faculty incentive.
	 *
	 * @param amountInOMR the amount in omr of this faculty incentive
	 */
	public void setAmountInOMR(long amountInOMR);

	/**
	 * Returns the applicable form of this faculty incentive.
	 *
	 * @return the applicable form of this faculty incentive
	 */
	public Date getApplicableForm();

	/**
	 * Sets the applicable form of this faculty incentive.
	 *
	 * @param applicableForm the applicable form of this faculty incentive
	 */
	public void setApplicableForm(Date applicableForm);

	@Override
	public FacultyIncentive cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}