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

import gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException;
import gov.omsb.tms.model.ProgramWorkflowDetailsRel;
import gov.omsb.tms.service.base.ProgramWorkflowDetailsRelLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.ProgramWorkflowDetailsRel",
	service = AopService.class
)
public class ProgramWorkflowDetailsRelLocalServiceImpl
	extends ProgramWorkflowDetailsRelLocalServiceBaseImpl {
	
	public ProgramWorkflowDetailsRel findByProgramId(long programId) {
		ProgramWorkflowDetailsRel programWorkflowDetailsRel = null;
		try {
			programWorkflowDetailsRel = this.programWorkflowDetailsRelPersistence.findByProgramWorkflowByProgramId(programId);
		} catch (NoSuchProgramWorkflowDetailsRelException e) {
			_logger.error("Error While Fetching ProgramWorkflowDetailsRel :: " + e.getMessage());
		}
		return programWorkflowDetailsRel;		
	}
	
	private static final Log _logger = LogFactoryUtil.getLog(ProgramWorkflowDetailsRelLocalServiceImpl.class);
	
}