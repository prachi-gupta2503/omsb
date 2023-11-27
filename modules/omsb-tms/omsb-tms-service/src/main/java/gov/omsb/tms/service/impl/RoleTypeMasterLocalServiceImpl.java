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

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.model.RoleTypeMaster;
import gov.omsb.tms.service.base.RoleTypeMasterLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.RoleTypeMaster", service = AopService.class)
public class RoleTypeMasterLocalServiceImpl extends RoleTypeMasterLocalServiceBaseImpl {

	public List<RoleTypeMaster> findByRoleTypeNameByLike(String roleTypeName) {
		return this.roleTypeMasterPersistence.findByRoleTypeNameByLike(roleTypeName);
	}

	public RoleTypeMaster addUpdateRoleTypeMaster(RoleTypeMaster roleTypeMaster, List<String> roleTypeNames,
			boolean isCreate) {
		if (Boolean.TRUE == validateRoleTypeNames(roleTypeNames, isCreate ? null : roleTypeMaster)) {
			return super.updateRoleTypeMaster(roleTypeMaster);
		} else {
			return null;
		}
	}

	public Boolean validateRoleTypeNames(List<String> roleTypeNames, RoleTypeMaster roleTypeMaster) {
		for (String roleTypeName : roleTypeNames) {
			String likeRoleTypeMaster = StringPool.PERCENT + StringPool.GREATER_THAN + roleTypeName
					+ StringPool.LESS_THAN + StringPool.PERCENT;
			// Find role type
			List<RoleTypeMaster> roleTypeMasters = findByRoleTypeNameByLike(likeRoleTypeMaster);
			if (!roleTypeMasters.isEmpty()) {
				if (Validator.isNull(roleTypeMaster)) {
					return false;
				} else {
					if (!roleTypeMasters.stream().map(RoleTypeMaster::getRoleTypeMasterId).collect(Collectors.toList())
							.contains(roleTypeMaster.getRoleTypeMasterId())) {
						return false;
					}
				}
			}
		}
		return true;
	}

}