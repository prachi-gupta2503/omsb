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
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.service.LeaveMasterLocalServiceUtil;
import gov.omsb.tms.service.base.LeaveMasterLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.LeaveMaster", service = AopService.class)
public class LeaveMasterLocalServiceImpl extends LeaveMasterLocalServiceBaseImpl {

	public LeaveMaster addLeaveMaster(ServiceContext serviceContext, long traineeId, Date dateOfApplication,
			long leaveTypeId, Date fromDate, Date toDate, int numberOfDays, String contactName, String contactEmail,
			String contactNumber, long programId) {

		long leaveMasterId = counterLocalService.increment(LeaveMaster.class.getName());
		LeaveMaster leaveMaster = null;

		try {
			User user = userLocalService.getUser(serviceContext.getUserId());
			leaveMaster = leaveMasterLocalService.createLeaveMaster(leaveMasterId);

			leaveMaster.setCreateDate(new Date());
			leaveMaster.setCreatedBy(traineeId);
			leaveMaster.setGroupId(serviceContext.getScopeGroupId());
			leaveMaster.setCompanyId(serviceContext.getCompanyId());

			leaveMaster.setTraineeId(traineeId);
			leaveMaster.setLeaveTypeId(leaveTypeId);
			leaveMaster.setLeaveTraineeId(traineeId);
			leaveMaster.setBlockName(StringPool.BLANK);
			leaveMaster.setLeaveFrom(fromDate);
			leaveMaster.setLeaveTo(toDate);
			leaveMaster.setNoOfDays(numberOfDays);
			leaveMaster.setContactName(contactName);
			leaveMaster.setContactEmail(contactEmail);
			leaveMaster.setContactNo(contactNumber);
			leaveMaster.setApplicationDate(dateOfApplication);
			leaveMaster.setProgramId(programId);

			leaveMaster.setStatus(WorkflowConstants.STATUS_DRAFT);
			leaveMaster.setStatusByUserId(user.getUserId());
			leaveMaster.setStatusDate(new Date());
			leaveMaster.setStatusByUserName(user.getFullName());

			leaveMaster = leaveMasterLocalService.addLeaveMaster(leaveMaster);

			AssetEntry assetEntry = assetEntryLocalService.updateEntry(user.getUserId(),
					serviceContext.getScopeGroupId(), new Date(), new Date(), LeaveMaster.class.getName(),
					leaveMaster.getLeaveMasterId(), leaveMaster.getUuid(), 0, null, null, true, false, new Date(), null,
					new Date(), null, ContentTypes.TEXT_HTML, "Applied For Leave", "Applied For Leave", null, null,
					null, 0, 0, null);
			Indexer<LeaveMaster> indexer = IndexerRegistryUtil.nullSafeGetIndexer(LeaveMaster.class);
			indexer.reindex(leaveMaster);

			WorkflowHandlerRegistryUtil.startWorkflowInstance(leaveMaster.getCompanyId(), leaveMaster.getGroupId(),
					leaveMaster.getCreatedBy(), LeaveMaster.class.getName(), leaveMaster.getLeaveMasterId(),
					leaveMaster, serviceContext);

		} catch (PortalException e) {
			log.error("Error Occurred While Adding Leave -> " + e.getMessage());
		}

		return leaveMaster;

	}

	public LeaveMaster updateStatus(long userId, long leaveMasterId, int status, ServiceContext serviceContext) {

		LeaveMaster leaveMaster = leaveMasterPersistence.fetchByPrimaryKey(leaveMasterId);

		leaveMaster.setStatus(status);
		leaveMaster.setStatusByUserId(userId);
		leaveMaster.setStatusDate(new Date());

		User user = null;

		try {
			user = userLocalService.getUser(userId);
			leaveMaster.setStatusByUserName(user.getFullName());
			leaveMaster.setStatusByUserUuid(user.getUserUuid());
		} catch (PortalException e) {
			log.error("Error Occurred While Updating LeaveMaster Workflow Releated Fields -> " + e.getMessage());
		}

		leaveMaster = leaveMasterPersistence.update(leaveMaster);

		try {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				// update the asset status to visibile
				assetEntryLocalService.updateEntry(LeaveMaster.class.getName(), leaveMasterId, new Date(), null, true,
						true);
			} else {
				// set leave entity status to false
				assetEntryLocalService.updateVisible(LeaveMaster.class.getName(), leaveMasterId, false);
			}
		} catch (Exception e) {
			log.error("Error Occurred While Updating AssetEntry -> " + e.getMessage());
		}

		return leaveMaster;

	}

	public List<LeaveMaster> findLeaveDetailsByTraineeId(long traineeId) {
		return leaveMasterPersistence.findByTraineeId(traineeId);
	}
	
	public List<LeaveMaster> findLeaveDetailsByTraineeIds(List<Long> traineeIds, Date startDate , Date endDate) {
		List<LeaveMaster> leaveMasterList = new ArrayList<>();
		try {
			DynamicQuery savedSearch = LeaveMasterLocalServiceUtil.dynamicQuery();
			savedSearch.add(RestrictionsFactoryUtil.in("traineeId", traineeIds));
			savedSearch.add(RestrictionsFactoryUtil.between("leaveFrom", startDate, endDate));
			
			leaveMasterList = LeaveMasterLocalServiceUtil.dynamicQuery(savedSearch);
		} catch (Exception e) {
			log.info("findLeaveDetailsByTraineeId ::: " + e);
		}
		return leaveMasterList;
	}
	
	public List<LeaveMaster> findLeaveDetailsByTraineeIdsWithStatus(List<Long> traineeIds, Date startDate , Date endDate, int status) {
		List<LeaveMaster> leaveMasterList = new ArrayList<>();
		try {
			DynamicQuery savedSearch = LeaveMasterLocalServiceUtil.dynamicQuery();
			savedSearch.add(RestrictionsFactoryUtil.in("traineeId", traineeIds));
			savedSearch.add(RestrictionsFactoryUtil.between("leaveFrom", startDate, endDate));
			savedSearch.add(RestrictionsFactoryUtil.eq("status", status));
			
			leaveMasterList = LeaveMasterLocalServiceUtil.dynamicQuery(savedSearch);
		} catch (Exception e) {
			log.info("findLeaveDetailsByTraineeIdsWithStatus ::: " + e);
		}
		return leaveMasterList;
	}

	private static final Log log = LogFactoryUtil.getLog(LeaveMasterLocalServiceImpl.class.getName());

}