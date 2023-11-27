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
 * The base model interface for the TraineeCohortDetails service. Represents a row in the &quot;trainee_cohort_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.TraineeCohortDetailsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.TraineeCohortDetailsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeCohortDetails
 * @generated
 */
@ProviderType
public interface TraineeCohortDetailsModel
	extends BaseModel<TraineeCohortDetails>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a trainee cohort details model instance should use the {@link TraineeCohortDetails} interface instead.
	 */

	/**
	 * Returns the primary key of this trainee cohort details.
	 *
	 * @return the primary key of this trainee cohort details
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this trainee cohort details.
	 *
	 * @param primaryKey the primary key of this trainee cohort details
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this trainee cohort details.
	 *
	 * @return the uuid of this trainee cohort details
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this trainee cohort details.
	 *
	 * @param uuid the uuid of this trainee cohort details
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the trainee cohort details ID of this trainee cohort details.
	 *
	 * @return the trainee cohort details ID of this trainee cohort details
	 */
	public long getTraineeCohortDetailsId();

	/**
	 * Sets the trainee cohort details ID of this trainee cohort details.
	 *
	 * @param traineeCohortDetailsId the trainee cohort details ID of this trainee cohort details
	 */
	public void setTraineeCohortDetailsId(long traineeCohortDetailsId);

	/**
	 * Returns the group ID of this trainee cohort details.
	 *
	 * @return the group ID of this trainee cohort details
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this trainee cohort details.
	 *
	 * @param groupId the group ID of this trainee cohort details
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this trainee cohort details.
	 *
	 * @return the company ID of this trainee cohort details
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this trainee cohort details.
	 *
	 * @param companyId the company ID of this trainee cohort details
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this trainee cohort details.
	 *
	 * @return the create date of this trainee cohort details
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this trainee cohort details.
	 *
	 * @param createDate the create date of this trainee cohort details
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this trainee cohort details.
	 *
	 * @return the modified date of this trainee cohort details
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this trainee cohort details.
	 *
	 * @param modifiedDate the modified date of this trainee cohort details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the created by of this trainee cohort details.
	 *
	 * @return the created by of this trainee cohort details
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this trainee cohort details.
	 *
	 * @param createdBy the created by of this trainee cohort details
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified by of this trainee cohort details.
	 *
	 * @return the modified by of this trainee cohort details
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this trainee cohort details.
	 *
	 * @param modifiedBy the modified by of this trainee cohort details
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the trainee admission details rel ID of this trainee cohort details.
	 *
	 * @return the trainee admission details rel ID of this trainee cohort details
	 */
	public long getTraineeAdmissionDetailsRelId();

	/**
	 * Sets the trainee admission details rel ID of this trainee cohort details.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID of this trainee cohort details
	 */
	public void setTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId);

	/**
	 * Returns the cohort year of this trainee cohort details.
	 *
	 * @return the cohort year of this trainee cohort details
	 */
	@AutoEscape
	public String getCohortYear();

	/**
	 * Sets the cohort year of this trainee cohort details.
	 *
	 * @param cohortYear the cohort year of this trainee cohort details
	 */
	public void setCohortYear(String cohortYear);

	/**
	 * Returns the is current cohort of this trainee cohort details.
	 *
	 * @return the is current cohort of this trainee cohort details
	 */
	public Boolean getIsCurrentCohort();

	/**
	 * Sets the is current cohort of this trainee cohort details.
	 *
	 * @param isCurrentCohort the is current cohort of this trainee cohort details
	 */
	public void setIsCurrentCohort(Boolean isCurrentCohort);

	/**
	 * Returns the trainee level ID of this trainee cohort details.
	 *
	 * @return the trainee level ID of this trainee cohort details
	 */
	public long getTraineeLevelId();

	/**
	 * Sets the trainee level ID of this trainee cohort details.
	 *
	 * @param traineeLevelId the trainee level ID of this trainee cohort details
	 */
	public void setTraineeLevelId(long traineeLevelId);

	/**
	 * Returns the is current trainee level of this trainee cohort details.
	 *
	 * @return the is current trainee level of this trainee cohort details
	 */
	public Boolean getIsCurrentTraineeLevel();

	/**
	 * Sets the is current trainee level of this trainee cohort details.
	 *
	 * @param isCurrentTraineeLevel the is current trainee level of this trainee cohort details
	 */
	public void setIsCurrentTraineeLevel(Boolean isCurrentTraineeLevel);

	@Override
	public TraineeCohortDetails cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}