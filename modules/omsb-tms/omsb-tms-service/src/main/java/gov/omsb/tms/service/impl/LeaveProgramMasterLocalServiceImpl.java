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
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.exception.NoSuchLeaveProgramMasterException;
import gov.omsb.tms.model.LeaveProgramMaster;
import gov.omsb.tms.service.base.LeaveProgramMasterLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.LeaveProgramMaster",
	service = AopService.class
)
public class LeaveProgramMasterLocalServiceImpl
	extends LeaveProgramMasterLocalServiceBaseImpl {
	
	public List<LeaveProgramMaster> getLeaveProgramMasterByProgramMasterId(long programMasterId) throws SystemException {
		return this.leaveProgramMasterPersistence.findByProgramMasterId(programMasterId);
	}
	
	public LeaveProgramMaster getLeaveProgramMasterByProgramMasterIdLeaveTypesId(long programMasterId,long leaveTypesId) throws SystemException {
		try {
			return this.leaveProgramMasterPersistence.findByProgramMasterLeaveTypeId(programMasterId,leaveTypesId);
		} catch (NoSuchLeaveProgramMasterException e) {
			e.printStackTrace();
		}
		return null;
	}
}