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
 * The base model interface for the EcMemberRequestStatus service. Represents a row in the &quot;ec_member_request_status&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.EcMemberRequestStatusModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.EcMemberRequestStatusImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestStatus
 * @generated
 */
@ProviderType
public interface EcMemberRequestStatusModel
	extends BaseModel<EcMemberRequestStatus>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ec member request status model instance should use the {@link EcMemberRequestStatus} interface instead.
	 */

	/**
	 * Returns the primary key of this ec member request status.
	 *
	 * @return the primary key of this ec member request status
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ec member request status.
	 *
	 * @param primaryKey the primary key of this ec member request status
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this ec member request status.
	 *
	 * @return the uuid of this ec member request status
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this ec member request status.
	 *
	 * @param uuid the uuid of this ec member request status
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the ec member request status ID of this ec member request status.
	 *
	 * @return the ec member request status ID of this ec member request status
	 */
	public long getEcMemberRequestStatusId();

	/**
	 * Sets the ec member request status ID of this ec member request status.
	 *
	 * @param ecMemberRequestStatusId the ec member request status ID of this ec member request status
	 */
	public void setEcMemberRequestStatusId(long ecMemberRequestStatusId);

	/**
	 * Returns the group ID of this ec member request status.
	 *
	 * @return the group ID of this ec member request status
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this ec member request status.
	 *
	 * @param groupId the group ID of this ec member request status
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this ec member request status.
	 *
	 * @return the company ID of this ec member request status
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ec member request status.
	 *
	 * @param companyId the company ID of this ec member request status
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this ec member request status.
	 *
	 * @return the create date of this ec member request status
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this ec member request status.
	 *
	 * @param createDate the create date of this ec member request status
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this ec member request status.
	 *
	 * @return the modified date of this ec member request status
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this ec member request status.
	 *
	 * @param modifiedDate the modified date of this ec member request status
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the code of this ec member request status.
	 *
	 * @return the code of this ec member request status
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this ec member request status.
	 *
	 * @param code the code of this ec member request status
	 */
	public void setCode(String code);

	/**
	 * Returns the name en of this ec member request status.
	 *
	 * @return the name en of this ec member request status
	 */
	@AutoEscape
	public String getNameEn();

	/**
	 * Sets the name en of this ec member request status.
	 *
	 * @param nameEn the name en of this ec member request status
	 */
	public void setNameEn(String nameEn);

	/**
	 * Returns the name ar of this ec member request status.
	 *
	 * @return the name ar of this ec member request status
	 */
	@AutoEscape
	public String getNameAr();

	/**
	 * Sets the name ar of this ec member request status.
	 *
	 * @param nameAr the name ar of this ec member request status
	 */
	public void setNameAr(String nameAr);

	@Override
	public EcMemberRequestStatus cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}