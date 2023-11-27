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

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.service.base.DutyTypesServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=omsbtms",
		"json.web.service.context.path=DutyTypes" }, service = AopService.class)
public class DutyTypesServiceImpl extends DutyTypesServiceBaseImpl {
	
	public DutyTypes deleteDutyTypes(long dutyTypeId) throws PortalException {
		return dutyTypesLocalService.deleteDutyTypes(dutyTypeId);
	}

	public String getDutyTypesByDutyType(String dutyType) {
		return dutyTypesLocalService.getDutyTypesListByDutyType(dutyType);
	}
	
	
}