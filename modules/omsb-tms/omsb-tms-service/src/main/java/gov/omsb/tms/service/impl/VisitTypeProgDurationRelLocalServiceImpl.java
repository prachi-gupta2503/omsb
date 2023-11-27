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
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.exception.NoSuchVisitTypeProgDurationRelException;
import gov.omsb.tms.model.VisitTypeProgDurationRel;
import gov.omsb.tms.service.base.VisitTypeProgDurationRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.VisitTypeProgDurationRel", service = AopService.class)
public class VisitTypeProgDurationRelLocalServiceImpl extends VisitTypeProgDurationRelLocalServiceBaseImpl {

	public List<VisitTypeProgDurationRel> findByProgramDurationId(long programDurationId) {
		return super.visitTypeProgDurationRelPersistence.findByProgramDurationId(programDurationId);
	}
	
	public Map<Long, String> getOtherVisitTypesFromVisitMaster(long programDurationId, String type, String languageCode){
		return super.omsbTmsFinderFinder.getProcedureMasterParameter(programDurationId,type,languageCode);
	}

	public VisitTypeProgDurationRel findByProgramDurationIdAndVisitTypeMasterId(long programDurationId, long visitTypeMasterId) {
		try {
			return super.visitTypeProgDurationRelPersistence.findByProgramDurationIdAndVisitTypeMasterId(programDurationId, visitTypeMasterId);
		} catch (NoSuchVisitTypeProgDurationRelException e) {
			_logger.error(e.getMessage(), e);
			return null;
		}
	}

	private static final Log _logger = LogFactoryUtil.getLog(VisitTypeProgDurationRelLocalServiceImpl.class);
}