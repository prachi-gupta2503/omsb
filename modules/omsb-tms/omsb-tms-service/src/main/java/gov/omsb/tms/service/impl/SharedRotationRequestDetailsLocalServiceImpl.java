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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.model.SharedRotationRequestDetails;
import gov.omsb.tms.service.base.SharedRotationRequestDetailsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.SharedRotationRequestDetails",
	service = AopService.class
)
public class SharedRotationRequestDetailsLocalServiceImpl
	extends SharedRotationRequestDetailsLocalServiceBaseImpl {
	
	public List<SharedRotationRequestDetails> findByRequestRaisedBy(String requestRaisedBy){
		return this.sharedRotationRequestDetailsPersistence.findByRequestRaisedBy(requestRaisedBy);
	}

	public List<SharedRotationRequestDetails> getSharedRotationRequestDetailsByApproverId(long approverId) {
		List<SharedRotationRequestDetails> sharedRotationRequestDetails = new ArrayList<>();
		for(Long id : omsbTmsFinderFinder.getSharedRotationIdForApprover(approverId)) {
			try {
				SharedRotationRequestDetails sharedRotationRequestDetail = sharedRotationRequestDetailsLocalService.getSharedRotationRequestDetails(id);
				sharedRotationRequestDetails.add(sharedRotationRequestDetail);
			} catch (PortalException e) {
				_logger.error(e);
			}
		}
		return sharedRotationRequestDetails;
	}

	private static final Log _logger = LogFactoryUtil.getLog(SharedRotationRequestDetailsLocalServiceImpl.class);
}