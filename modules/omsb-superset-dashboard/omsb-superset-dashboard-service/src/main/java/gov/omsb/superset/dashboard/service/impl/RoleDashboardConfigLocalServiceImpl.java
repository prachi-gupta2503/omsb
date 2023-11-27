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

package gov.omsb.superset.dashboard.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.superset.dashboard.model.RoleDashboardConfig;
import gov.omsb.superset.dashboard.service.base.RoleDashboardConfigLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.superset.dashboard.model.RoleDashboardConfig",
	service = AopService.class
)
public class RoleDashboardConfigLocalServiceImpl
	extends RoleDashboardConfigLocalServiceBaseImpl {
	
	public List<RoleDashboardConfig> getRoleDashboardConfigByGroupIdAndCompanyId(long groupId, long companyId){
		return roleDashboardConfigPersistence.findByGroupIdAndCompanyId(groupId, companyId);
	}
	
	public List<RoleDashboardConfig> getRoleDashboardConfigByRoleId(long roleId){
		return roleDashboardConfigPersistence.findByRoleId(roleId);
	}
}