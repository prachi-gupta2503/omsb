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

import gov.omsb.tms.model.ProgdurationObjectivesRel;
import gov.omsb.tms.service.base.ProgdurationObjectivesRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.ProgdurationObjectivesRel",
	service = AopService.class
)
public class ProgdurationObjectivesRelLocalServiceImpl
	extends ProgdurationObjectivesRelLocalServiceBaseImpl {
	
	public List<ProgdurationObjectivesRel> findByProgDurationId(long progDurationId) {
		ClassLoader classLoader = getClass().getClassLoader();
		
	    DynamicQuery dynamicQuery =  DynamicQueryFactoryUtil.forClass(ProgdurationObjectivesRel.class, classLoader);
	    dynamicQuery.add(PropertyFactoryUtil.forName("progDurationId").eq(progDurationId));
	    
	    return progdurationObjectivesRelLocalService.dynamicQuery(dynamicQuery);
	}
	
	public  ProgdurationObjectivesRel addProgdurationObjectivesRel(long groupId, long companyId, long progDurationId, String objectives) {
		_logger.info("addProgdurationObjectivesRel Invoked");		
		long pdObjectivesId = counterLocalService.increment(getClass().getName(), 1);
		ProgdurationObjectivesRel newObjectivesRel = progdurationObjectivesRelLocalService.createProgdurationObjectivesRel(pdObjectivesId);
		newObjectivesRel.setGroupId(groupId);
		newObjectivesRel.setCompanyId(companyId);
		newObjectivesRel.setProgDurationId(progDurationId);
		newObjectivesRel.setObjectives(objectives);
		ProgdurationObjectivesRel objectivesRel = addProgdurationObjectivesRel(newObjectivesRel);
		_logger.info("addProgdurationObjectivesRel Exit");
		return objectivesRel;
	}

	private static final Log _logger = LogFactoryUtil.getLog(ProgdurationObjectivesRelLocalServiceImpl.class.getName());
}