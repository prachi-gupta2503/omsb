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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException;
import gov.omsb.tms.model.EcMemberRequestStatus;
import gov.omsb.tms.service.base.EcMemberRequestStatusLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.EcMemberRequestStatus",
	service = AopService.class
)
public class EcMemberRequestStatusLocalServiceImpl
	extends EcMemberRequestStatusLocalServiceBaseImpl {
	
	public EcMemberRequestStatus findByName(String name) {
		EcMemberRequestStatus ecMemberRequestStatus = null;
		try {
			ecMemberRequestStatus  = this.ecMemberRequestStatusPersistence.findByNameEn(name);
		} catch (NoSuchEcMemberRequestStatusException e) {
			log.error(e);
		}
		return ecMemberRequestStatus;
	}
	
	public EcMemberRequestStatus findByCode(String code) {
		EcMemberRequestStatus ecMemberRequestStatus = null;
		
		List<EcMemberRequestStatus>  ecMemberRequestStatusList = this.ecMemberRequestStatusPersistence.findByCode(code);
		if(ecMemberRequestStatusList != null && ecMemberRequestStatusList.size()>0) {
			ecMemberRequestStatus = ecMemberRequestStatusList.get(0);
		}
			
		return ecMemberRequestStatus;
	}
	
	
	private static final Log log = LogFactoryUtil.getLog(EcMemberRequestStatusLocalServiceImpl.class);
	
}