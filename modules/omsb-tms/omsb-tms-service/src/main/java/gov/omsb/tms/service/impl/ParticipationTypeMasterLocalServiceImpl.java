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

import gov.omsb.tms.model.ParticipationTypeMaster;
import gov.omsb.tms.service.base.ParticipationTypeMasterLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ParticipationTypeMaster", service = AopService.class)
public class ParticipationTypeMasterLocalServiceImpl extends ParticipationTypeMasterLocalServiceBaseImpl {

	public List<ParticipationTypeMaster> findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId) {
		return this.participationTypeMasterPersistence
				.findByParticipationTypeNameByLikeAndProgramDurationId(participationTypeName, programDurationId);
	}

	public List<ParticipationTypeMaster> findByProgramDurationId(long programDurationId) {
		return this.participationTypeMasterPersistence.findByProgramDurationId(programDurationId);
	}

	public ParticipationTypeMaster addUpdateParticipationTypeMaster(ParticipationTypeMaster participationTypeMaster,
			List<String> participationTypeNames, boolean isCreate) {
		if (Boolean.TRUE == validateParticipationTypeNames(participationTypeNames,
				participationTypeMaster.getProgramDurationId(), isCreate ? null : participationTypeMaster)) {
			return super.updateParticipationTypeMaster(participationTypeMaster);
		} else {
			return null;
		}
	}

	public Boolean validateParticipationTypeNames(List<String> participationTypeNames, long programDurationId,
			ParticipationTypeMaster participationTypeMaster) {
		for (String participationTypeName : participationTypeNames) {
			String likeParticipationTypeMaster = StringPool.PERCENT + StringPool.GREATER_THAN + participationTypeName
					+ StringPool.LESS_THAN + StringPool.PERCENT;
			// Find participation type
			List<ParticipationTypeMaster> participationTypeMasters = findByParticipationTypeNameByLikeAndProgramDurationId(
					likeParticipationTypeMaster, programDurationId);
			if (!participationTypeMasters.isEmpty()) {
				if (Validator.isNull(participationTypeMaster)) {
					return false;
				} else {
					if (!participationTypeMasters.stream().map(ParticipationTypeMaster::getParticipationTypeMasterId)
							.collect(Collectors.toList())
							.contains(participationTypeMaster.getParticipationTypeMasterId())) {
						return false;
					}
				}
			}
		}
		return true;
	}
}