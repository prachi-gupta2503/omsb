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

import gov.omsb.tms.model.VisitTypeMaster;
import gov.omsb.tms.service.base.VisitTypeMasterLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.VisitTypeMaster", service = AopService.class)
public class VisitTypeMasterLocalServiceImpl extends VisitTypeMasterLocalServiceBaseImpl {

	public List<VisitTypeMaster> findByVisitTypeNameByLike(String visitTypeName) {
		return this.visitTypeMasterPersistence.findByVisitTypeNameByLike(visitTypeName);
	}

	public VisitTypeMaster addUpdateVisitTypeMaster(VisitTypeMaster visitTypeMaster, List<String> visitTypeNames,
			boolean isCreate) {
		if (Boolean.TRUE == validateRoleTypeNames(visitTypeNames, isCreate ? null : visitTypeMaster)) {
			return super.updateVisitTypeMaster(visitTypeMaster);
		} else {
			return null;
		}
	}

	public Boolean validateRoleTypeNames(List<String> visitTypeNames, VisitTypeMaster visitTypeMaster) {
		for (String visitTypeName : visitTypeNames) {
			String likeVisitTypeMaster = StringPool.PERCENT + StringPool.GREATER_THAN + visitTypeName
					+ StringPool.LESS_THAN + StringPool.PERCENT;
			// Find role type
			List<VisitTypeMaster> visitTypeMasters = findByVisitTypeNameByLike(likeVisitTypeMaster);
			if (!visitTypeMasters.isEmpty()) {
				if (Validator.isNull(visitTypeMaster)) {
					return false;
				} else {
					if (!visitTypeMasters.stream().map(VisitTypeMaster::getVisitTypeMasterId)
							.collect(Collectors.toList()).contains(visitTypeMaster.getVisitTypeMasterId())) {
						return false;
					}
				}
			}
		}
		return true;
	}
}