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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel;
import gov.omsb.tms.model.ProgdurationObjectivesRel;
import gov.omsb.tms.service.base.ProgdurationCompetenciesRequirementsRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel",
	service = AopService.class
)
public class ProgdurationCompetenciesRequirementsRelLocalServiceImpl
	extends ProgdurationCompetenciesRequirementsRelLocalServiceBaseImpl {
	
	public List<ProgdurationCompetenciesRequirementsRel> getByProgDurationId(long progDurationId) {
		ClassLoader classLoader = getClass().getClassLoader();
		
	    DynamicQuery dynamicQuery =  DynamicQueryFactoryUtil.forClass(ProgdurationCompetenciesRequirementsRel.class, classLoader);
	    
	    dynamicQuery.add(PropertyFactoryUtil.forName("progDurationId").eq(progDurationId));
	    
	    return progdurationCompetenciesRequirementsRelLocalService.dynamicQuery(dynamicQuery);
	}
	
	public  ProgdurationCompetenciesRequirementsRel addProgdurationCompetenciesRequirementsRel(long groupId, long companyId, long progDurationId, long competenciesMasterId, String requirements) {
		_logger.info("addProgdurationCompetenciesRequirementsRel Invoked");		
		long progdurationCompetenciesRelId = counterLocalService.increment(getClass().getName(), 1);
		ProgdurationCompetenciesRequirementsRel progdurationCompetenciesRequirementsRel = createProgdurationCompetenciesRequirementsRel(progdurationCompetenciesRelId);
		progdurationCompetenciesRequirementsRel.setGroupId(groupId);
		progdurationCompetenciesRequirementsRel.setCompanyId(companyId);
		progdurationCompetenciesRequirementsRel.setProgDurationId(progDurationId);
		progdurationCompetenciesRequirementsRel.setCompetenciesMasterId(competenciesMasterId);
		progdurationCompetenciesRequirementsRel.setRequirements(requirements);
		
		ProgdurationCompetenciesRequirementsRel requirementsRel = addProgdurationCompetenciesRequirementsRel(progdurationCompetenciesRequirementsRel);
		_logger.info("addProgdurationCompetenciesRequirementsRel Exit");
		return requirementsRel;
	}

	private static final Log _logger = LogFactoryUtil.getLog(ProgdurationCompetenciesRequirementsRelLocalServiceImpl.class.getName());
}