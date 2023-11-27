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

package gov.omsb.tms.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.util.List;

import gov.omsb.tms.custom.dto.ECMembershipRequestStateDTO;
import gov.omsb.tms.model.EcMemberRequestState;
import gov.omsb.tms.service.base.EcMemberRequestStateLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.EcMemberRequestState",
	service = AopService.class
)
public class EcMemberRequestStateLocalServiceImpl
	extends EcMemberRequestStateLocalServiceBaseImpl {
	
	public EcMemberRequestState addComments(String comment, long ecMemberRequestId)
	{
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long ecMemberRequestStateId = counterLocalService.increment(EcMemberRequestState.class.getName());
		EcMemberRequestState ecMemberRequestState = createEcMemberRequestState(ecMemberRequestStateId);
		ecMemberRequestState.setComments(comment);
		ecMemberRequestState.setEcMemberRequestId(ecMemberRequestId);
		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		ecMemberRequestState.setGroupId(groupId);
		ecMemberRequestState.setCompanyId(companyId);
		addEcMemberRequestState(ecMemberRequestState);
		return ecMemberRequestState;
		
	}
	

	public EcMemberRequestState addRequestState(String comment, long ecMemberRequestId, long statusId, long userId, long roleId, boolean isPublic)
	{
		long ecMemberRequestStateId = counterLocalService.increment(EcMemberRequestState.class.getName());
		EcMemberRequestState ecMemberRequestState = createEcMemberRequestState(ecMemberRequestStateId);
		ecMemberRequestState.setComments(comment);
		ecMemberRequestState.setEcMemberRequestId(ecMemberRequestId);
		ecMemberRequestState.setEcMemberRequestStatusId(statusId);
		ecMemberRequestState.setCreatedBy(userId);
		ecMemberRequestState.setCreatedByRoleId(roleId);
		ecMemberRequestState.setIsPublic(isPublic);
		addEcMemberRequestState(ecMemberRequestState);
		return ecMemberRequestState;
		
	}

	public List<ECMembershipRequestStateDTO> eCMembershipRequestStateList(long emMemberRequestId){ 
		  return this.omsbTmsFinderFinder.getECMembershipRequestStateData(emMemberRequestId);  
	}
	
	public List<EcMemberRequestState> findByEcMemberRequestId(long ecMemberRequestId){
		return this.ecMemberRequestStatePersistence.findByEcMemberRequestId(ecMemberRequestId);
	}
	
	public List<EcMemberRequestState> findByVisibility(long ecMemberRequestId, boolean isPublic){
		return this.ecMemberRequestStatePersistence.findByVisibility(ecMemberRequestId, isPublic);
	}
}