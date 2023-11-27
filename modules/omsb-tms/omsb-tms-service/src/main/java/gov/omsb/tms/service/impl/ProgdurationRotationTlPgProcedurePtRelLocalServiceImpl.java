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

import gov.omsb.tms.custom.dto.SetupProcedureDTO;
import gov.omsb.tms.exception.NoSuchProgdurationRotationTlPgProcedurePtRelException;
import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;
import gov.omsb.tms.service.base.ProgdurationRotationTlPgProcedurePtRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel", service = AopService.class)
public class ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl
		extends ProgdurationRotationTlPgProcedurePtRelLocalServiceBaseImpl {

	public List<SetupProcedureDTO> getSetUpProcedureDetails(String languageCode) {
		return omsbTmsFinderFinder.getSetUpProcedureDetails(languageCode);
	}

	public List<ProgdurationRotationTlPgProcedurePtRel> findProgdurationRotationTlPgProcedurePtRelByProcedureGroupId(
			long procedureGroupId) {
		return progdurationRotationTlPgProcedurePtRelPersistence.findByProcedureGroupId(procedureGroupId);
	}

	public ProgdurationRotationTlPgProcedurePtRel findProgdurationRotationTlPgProcedurePtRelByProcedureId(
			long procedureId) {
		ProgdurationRotationTlPgProcedurePtRel progdurationRotationTlPgProcedurePtRel = null;
		try {
			progdurationRotationTlPgProcedurePtRel = progdurationRotationTlPgProcedurePtRelPersistence
					.findByProcedureId(procedureId);
		} catch (NoSuchProgdurationRotationTlPgProcedurePtRelException e) {
			_logger.error(e);
		}
		return progdurationRotationTlPgProcedurePtRel;
	}

	public List<ProgdurationRotationTlPgProcedurePtRel> findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId) {
		return progdurationRotationTlPgProcedurePtRelPersistence
				.findByProgramDurationIdAndProcedureGroupIdAndProcedureId(programDurationId, procedureGroupId,
						procedureId);
	}
	
	public List<ProgdurationRotationTlPgProcedurePtRel> findByProgramDurationId(long programDurationId) {
		return progdurationRotationTlPgProcedurePtRelPersistence.findByProgramDurationId(programDurationId);
	}

	public ProgdurationRotationTlPgProcedurePtRel findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
			long programDurationId, long procedureGroupId, long procedureId, long rotationId) {
		try {
			return progdurationRotationTlPgProcedurePtRelPersistence
					.findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(programDurationId,
							procedureGroupId, procedureId, rotationId);
		} catch (NoSuchProgdurationRotationTlPgProcedurePtRelException e) {
			_logger.error(e);
			return null;
		}
	}

	private static final Log _logger = LogFactoryUtil
			.getLog(ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl.class.getName());

}