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

import gov.omsb.tms.custom.dto.TraineeLevelListDTO;
import gov.omsb.tms.service.base.DutyLogServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=omsbtms",
		"json.web.service.context.path=DutyLog"
	},
	service = AopService.class
)
public class DutyLogServiceImpl extends DutyLogServiceBaseImpl {
	
	public List<TraineeLevelListDTO> getByTranieeIdAndProgramDutyAssignmentId(long traineeId, long programId,
			long cohortId, String languageCode) {
		LOGGER.info("traineeId==>"+traineeId);
		LOGGER.info("programId==>"+programId);
		LOGGER.info("cohortId==>"+cohortId);
		LOGGER.info("languageCode==>"+languageCode);
		
	return dutyLogLocalService.getByTranieeIdAndProgramDutyAssignmentId(traineeId,programId,cohortId,languageCode);
	}
	
	private static final Log LOGGER = LogFactoryUtil.getLog(DutyLogServiceImpl.class);
}