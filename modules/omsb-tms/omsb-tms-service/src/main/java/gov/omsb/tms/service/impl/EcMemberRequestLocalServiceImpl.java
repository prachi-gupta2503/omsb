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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.custom.dto.ECMembershipRequestListDTO;
import gov.omsb.tms.custom.dto.FacultySiteCompensationDTO;
import gov.omsb.tms.custom.dto.ResidentReportDTO;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.model.EcMemberRequestState;
import gov.omsb.tms.model.EcMemberRequestStatus;
import gov.omsb.tms.service.EcMemberRequestStateLocalServiceUtil;
import gov.omsb.tms.service.EcMemberRequestStatusLocalServiceUtil;
import gov.omsb.tms.service.base.EcMemberRequestLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.EcMemberRequest", service = AopService.class)
public class EcMemberRequestLocalServiceImpl extends EcMemberRequestLocalServiceBaseImpl {

	private static final Log LOGGER = LogFactoryUtil.getLog(EcMemberRequestLocalServiceImpl.class);

	public User getPotentialMemberUser(long requestId) {
		LOGGER.info("*********************requestId > " + requestId);

		try {
			EcMemberRequest request = getEcMemberRequest(requestId);
			return UserLocalServiceUtil.getUser(request.getPotentialEcMemberLruserid());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return null;
	}
	

	public List<ECMembershipRequestListDTO> getECMembershipRequestData(long programId, long roleId, long statusId, long potentialEcMemberLrUserid, String languageCode) {
		ecMemberRequestPersistence.flush();
		return this.omsbTmsFinderFinder.getECMembershipRequestData(programId, roleId, statusId,potentialEcMemberLrUserid, languageCode);
	}

	public EcMemberRequest createNewRequest(EcMemberRequest ecMemberRequest, User user) throws PortalException {
		LOGGER.info("createNewRequest Start");
		ecMemberRequest = this.updateEcMemberRequest(ecMemberRequest);

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		assetEntryLocalService.updateEntry(user.getUserId(), ecMemberRequest.getGroupId(),
				EcMemberRequest.class.getName(), ecMemberRequest.getEcMemberRequestId(),
				serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames());

		WorkflowHandlerRegistryUtil.startWorkflowInstance(ecMemberRequest.getCompanyId(), ecMemberRequest.getGroupId(),
				user.getUserId(), EcMemberRequest.class.getName(), ecMemberRequest.getEcMemberRequestId(),
				ecMemberRequest, serviceContext);

		LOGGER.info("createNewRequest End");

		return ecMemberRequest;
	}

	public EcMemberRequest updateStatus(long userId, long roleId, long ecMemberRequestId, int status,
			String ecRequestStateCode, String comments, ServiceContext serviceContext) throws PortalException {
		LOGGER.info("updateStatus 1");
		User user = userLocalService.getUser(userId);
		EcMemberRequest ecMemberRequest = ecMemberRequestLocalService.getEcMemberRequest(ecMemberRequestId);
		ecMemberRequest.setStatus(status);
		ecMemberRequest.setStatusByUserId(userId);
		ecMemberRequest.setStatusByUserName(user.getFullName());
		ecMemberRequest.setStatusDate(new Date());

		EcMemberRequestStatus ecMemberRequestStatus = EcMemberRequestStatusLocalServiceUtil
				.findByCode(ecRequestStateCode);

		EcMemberRequestState ecMemberRequestState = null;
		if (ecMemberRequestStatus != null) {
			long statusId = ecMemberRequestStatus.getEcMemberRequestStatusId();

			ecMemberRequestState = EcMemberRequestStateLocalServiceUtil.addRequestState(comments, ecMemberRequestId,
					statusId, userId, roleId,false);
		}

		if (ecMemberRequestState != null) {
			ecMemberRequest.setLatestEcMemberRequestStateId(ecMemberRequestState.getEcMemberRequestStateId());
		}

		updateEcMemberRequest(ecMemberRequest);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateVisible(EcMemberRequest.class.getName(), ecMemberRequestId, true);
		} else {
			assetEntryLocalService.updateVisible(EcMemberRequest.class.getName(), ecMemberRequestId, true);
		}

		return ecMemberRequest;
	}

	public EcMemberRequest updateStatus(long userId, long ecMemberRequestId, int status, ServiceContext serviceContext)
			throws PortalException {
		LOGGER.info("updateStatus 2");
		User user = userLocalService.getUser(userId);
		EcMemberRequest ecMemberRequest = ecMemberRequestLocalService.getEcMemberRequest(ecMemberRequestId);
		ecMemberRequest.setStatus(status);
		ecMemberRequest.setStatusByUserId(userId);
		ecMemberRequest.setStatusByUserName(user.getFullName());
		ecMemberRequest.setStatusDate(new Date());

		updateEcMemberRequest(ecMemberRequest);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateVisible(EcMemberRequest.class.getName(), ecMemberRequestId, true);
		} else {
			assetEntryLocalService.updateVisible(EcMemberRequest.class.getName(), ecMemberRequestId, true);
		}

		return ecMemberRequest;

	}

	public void deleteAllRequests() throws PortalException {
		LOGGER.info("deleteAllRequests");
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		List<EcMemberRequest> requestList = this.getEcMemberRequests(-1, -1);
		for (EcMemberRequest request : requestList) {
			try {
				long requestId = request.getEcMemberRequestId();
				request = deleteEcMemberRequest(request);
				try {
					WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(request.getCompanyId(),
							request.getGroupId(), EcMemberRequest.class.getName(), request.getEcMemberRequestId());

				} catch (Exception ex) {
					LOGGER.error("deleteWorkflowInstanceLinks error : " + request.getEcMemberRequestId() + " : "
							+ ex.getMessage());
				}

				try {
					AssetEntry assetEntry = assetEntryLocalService.fetchEntry(EcMemberRequest.class.getName(),
							requestId);
					assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

					assetEntryLocalService.deleteEntry(assetEntry);
				} catch (Exception ex) {
					LOGGER.error("deleteEntry error : " + request.getEcMemberRequestId() + " : " + ex.getMessage());
				}
				try {
					resourceLocalService.deleteResource(serviceContext.getCompanyId(), EcMemberRequest.class.getName(),
							ResourceConstants.SCOPE_INDIVIDUAL, requestId);

				} catch (Exception ex) {
					LOGGER.error("deleteResource error : " + request.getEcMemberRequestId() + " : " + ex.getMessage());
				}
			} catch (Exception e) {
				LOGGER.error("Error while deleting request " + e.getMessage());
			}
		}
	}
	
	public EcMemberRequest updateRequest(EcMemberRequest ecMemberRequest) {
		LOGGER.info("updateRequest");
		try {
			ecMemberRequest = updateEcMemberRequest(ecMemberRequest);
			ecMemberRequest = getEcMemberRequest(ecMemberRequest.getEcMemberRequestId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ecMemberRequest;
		
	}

	public EcMemberRequest getEcMemberRequestById(long ecMemberRequestId) throws PortalException {
		EcMemberRequest ecMemberRequest = ecMemberRequestLocalService.getEcMemberRequest(ecMemberRequestId);
		return ecMemberRequest;
	}

	public List<FacultySiteCompensationDTO> getFacultySiteCompensationReportDetailsOfEcMember(String languageCode,long programId) {
		return omsbTmsFinderFinder.getFacultySiteCompensationReportDetailsOfEcMember(languageCode,programId);
	}
	
	public List<ResidentReportDTO> getResidentsInEachSitePerBlock(long programId,String annualYear,String languageCode){
		return omsbTmsFinderFinder.getResidentsInEachSitePerBlock(programId,annualYear,languageCode);
	}
	
	public EcMemberRequest findByPotentialEcMemberId(long potentialEcMemberId) {
		try {
			return ecMemberRequestPersistence.findByPotentialEcMemberId(potentialEcMemberId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;

	}
	
	public List<EcMemberRequest> findByPotentialEcMemberLruserid(long potentialEcMemberLruserid) {
		try {
			return ecMemberRequestPersistence.findByPotentialEcMemberLruserid(potentialEcMemberLruserid);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;

	}
}