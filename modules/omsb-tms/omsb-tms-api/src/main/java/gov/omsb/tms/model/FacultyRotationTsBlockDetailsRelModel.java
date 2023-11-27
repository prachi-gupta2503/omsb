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
 * The base model interface for the FacultyRotationTsBlockDetailsRel service. Represents a row in the &quot;faculty_rotation_ts_block_details_rel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.FacultyRotationTsBlockDetailsRelModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.FacultyRotationTsBlockDetailsRelImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRotationTsBlockDetailsRel
 * @generated
 */
@ProviderType
public interface FacultyRotationTsBlockDetailsRelModel
	extends BaseModel<FacultyRotationTsBlockDetailsRel>, ShardedModel,
			StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a faculty rotation ts block details rel model instance should use the {@link FacultyRotationTsBlockDetailsRel} interface instead.
	 */

	/**
	 * Returns the primary key of this faculty rotation ts block details rel.
	 *
	 * @return the primary key of this faculty rotation ts block details rel
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this faculty rotation ts block details rel.
	 *
	 * @param primaryKey the primary key of this faculty rotation ts block details rel
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this faculty rotation ts block details rel.
	 *
	 * @return the uuid of this faculty rotation ts block details rel
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this faculty rotation ts block details rel.
	 *
	 * @param uuid the uuid of this faculty rotation ts block details rel
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the faculty rotation ts block details rel ID of this faculty rotation ts block details rel.
	 *
	 * @return the faculty rotation ts block details rel ID of this faculty rotation ts block details rel
	 */
	public long getFacultyRotationTsBlockDetailsRelId();

	/**
	 * Sets the faculty rotation ts block details rel ID of this faculty rotation ts block details rel.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the faculty rotation ts block details rel ID of this faculty rotation ts block details rel
	 */
	public void setFacultyRotationTsBlockDetailsRelId(
		long facultyRotationTsBlockDetailsRelId);

	/**
	 * Returns the group ID of this faculty rotation ts block details rel.
	 *
	 * @return the group ID of this faculty rotation ts block details rel
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this faculty rotation ts block details rel.
	 *
	 * @param groupId the group ID of this faculty rotation ts block details rel
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this faculty rotation ts block details rel.
	 *
	 * @return the company ID of this faculty rotation ts block details rel
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this faculty rotation ts block details rel.
	 *
	 * @param companyId the company ID of this faculty rotation ts block details rel
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this faculty rotation ts block details rel.
	 *
	 * @return the create date of this faculty rotation ts block details rel
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this faculty rotation ts block details rel.
	 *
	 * @param createDate the create date of this faculty rotation ts block details rel
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this faculty rotation ts block details rel.
	 *
	 * @return the modified date of this faculty rotation ts block details rel
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this faculty rotation ts block details rel.
	 *
	 * @param modifiedDate the modified date of this faculty rotation ts block details rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the created by of this faculty rotation ts block details rel.
	 *
	 * @return the created by of this faculty rotation ts block details rel
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this faculty rotation ts block details rel.
	 *
	 * @param createdBy the created by of this faculty rotation ts block details rel
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified by of this faculty rotation ts block details rel.
	 *
	 * @return the modified by of this faculty rotation ts block details rel
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this faculty rotation ts block details rel.
	 *
	 * @param modifiedBy the modified by of this faculty rotation ts block details rel
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the faculty ID of this faculty rotation ts block details rel.
	 *
	 * @return the faculty ID of this faculty rotation ts block details rel
	 */
	public long getFacultyId();

	/**
	 * Sets the faculty ID of this faculty rotation ts block details rel.
	 *
	 * @param facultyId the faculty ID of this faculty rotation ts block details rel
	 */
	public void setFacultyId(long facultyId);

	/**
	 * Returns the blocks metadata details rel ID of this faculty rotation ts block details rel.
	 *
	 * @return the blocks metadata details rel ID of this faculty rotation ts block details rel
	 */
	public long getBlocksMetadataDetailsRelId();

	/**
	 * Sets the blocks metadata details rel ID of this faculty rotation ts block details rel.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID of this faculty rotation ts block details rel
	 */
	public void setBlocksMetadataDetailsRelId(long blocksMetadataDetailsRelId);

	/**
	 * Returns the prog duration rotation ts rel ID of this faculty rotation ts block details rel.
	 *
	 * @return the prog duration rotation ts rel ID of this faculty rotation ts block details rel
	 */
	public long getProgDurationRotationTsRelId();

	/**
	 * Sets the prog duration rotation ts rel ID of this faculty rotation ts block details rel.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID of this faculty rotation ts block details rel
	 */
	public void setProgDurationRotationTsRelId(
		long progDurationRotationTsRelId);

	/**
	 * Returns the status of this faculty rotation ts block details rel.
	 *
	 * @return the status of this faculty rotation ts block details rel
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this faculty rotation ts block details rel.
	 *
	 * @param status the status of this faculty rotation ts block details rel
	 */
	public void setStatus(String status);

	@Override
	public FacultyRotationTsBlockDetailsRel cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}