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
 * The base model interface for the ProgramWorkflowDetailsRel service. Represents a row in the &quot;program_workflow_details_rel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.ProgramWorkflowDetailsRelModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.ProgramWorkflowDetailsRelImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramWorkflowDetailsRel
 * @generated
 */
@ProviderType
public interface ProgramWorkflowDetailsRelModel
	extends BaseModel<ProgramWorkflowDetailsRel>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a program workflow details rel model instance should use the {@link ProgramWorkflowDetailsRel} interface instead.
	 */

	/**
	 * Returns the primary key of this program workflow details rel.
	 *
	 * @return the primary key of this program workflow details rel
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this program workflow details rel.
	 *
	 * @param primaryKey the primary key of this program workflow details rel
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this program workflow details rel.
	 *
	 * @return the uuid of this program workflow details rel
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this program workflow details rel.
	 *
	 * @param uuid the uuid of this program workflow details rel
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the program workflow details rel ID of this program workflow details rel.
	 *
	 * @return the program workflow details rel ID of this program workflow details rel
	 */
	public long getProgramWorkflowDetailsRelId();

	/**
	 * Sets the program workflow details rel ID of this program workflow details rel.
	 *
	 * @param programWorkflowDetailsRelId the program workflow details rel ID of this program workflow details rel
	 */
	public void setProgramWorkflowDetailsRelId(
		long programWorkflowDetailsRelId);

	/**
	 * Returns the group ID of this program workflow details rel.
	 *
	 * @return the group ID of this program workflow details rel
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this program workflow details rel.
	 *
	 * @param groupId the group ID of this program workflow details rel
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this program workflow details rel.
	 *
	 * @return the company ID of this program workflow details rel
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this program workflow details rel.
	 *
	 * @param companyId the company ID of this program workflow details rel
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this program workflow details rel.
	 *
	 * @return the create date of this program workflow details rel
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this program workflow details rel.
	 *
	 * @param createDate the create date of this program workflow details rel
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this program workflow details rel.
	 *
	 * @return the created by of this program workflow details rel
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this program workflow details rel.
	 *
	 * @param createdBy the created by of this program workflow details rel
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this program workflow details rel.
	 *
	 * @return the modified date of this program workflow details rel
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this program workflow details rel.
	 *
	 * @param modifiedDate the modified date of this program workflow details rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this program workflow details rel.
	 *
	 * @return the modified by of this program workflow details rel
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this program workflow details rel.
	 *
	 * @param modifiedBy the modified by of this program workflow details rel
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the program ID of this program workflow details rel.
	 *
	 * @return the program ID of this program workflow details rel
	 */
	public long getProgramId();

	/**
	 * Sets the program ID of this program workflow details rel.
	 *
	 * @param programId the program ID of this program workflow details rel
	 */
	public void setProgramId(long programId);

	/**
	 * Returns the workflow approval order of this program workflow details rel.
	 *
	 * @return the workflow approval order of this program workflow details rel
	 */
	@AutoEscape
	public String getWorkflowApprovalOrder();

	/**
	 * Sets the workflow approval order of this program workflow details rel.
	 *
	 * @param workflowApprovalOrder the workflow approval order of this program workflow details rel
	 */
	public void setWorkflowApprovalOrder(String workflowApprovalOrder);

	@Override
	public ProgramWorkflowDetailsRel cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}