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
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.custom.dto.ProgramCohortDTO;
import gov.omsb.tms.exception.NoSuchProgdurationTraineelevelBlocksLevelTypeRelException;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRelModel;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.base.ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel", service = AopService.class)
public class ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceImpl
		extends ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceBaseImpl {

	public List<ProgdurationTraineelevelBlocksLevelTypeRel> findByProgramDurationId(long programDurationId) {
		return this.progdurationTraineelevelBlocksLevelTypeRelPersistence.findByProgramDurationId(programDurationId);
	}

	public List<ProgramCohortDTO> getProgramCohorts(List<Long> programIds, List<String> yearRange,
			String languageCode) {
		return omsbTmsFinderFinder.getProgramCohorts(programIds, yearRange, languageCode);
	}

	public List<TraineeLevelMaster> getTraineeLevelFromProgramDurationId(long programDurationId) {
		return progdurationTraineelevelBlocksLevelTypeRelPersistence.findByProgramDurationId(programDurationId).stream()
				.map(ProgdurationTraineelevelBlocksLevelTypeRelModel::getTraineeLevelId).collect(Collectors.toList())
				.stream().map(id -> {
					try {
						return traineeLevelMasterPersistence.findByPrimaryKey(id);
					} catch (NoSuchModelException e) {
						_logger.error(e);
						return null;
					}
				}).collect(Collectors.toList());
	}

	public ProgdurationTraineelevelBlocksLevelTypeRel findByProgramDurationIdAndTraineeLevelId(long programDurationId,
			long traineeLevelId) {
		ProgdurationTraineelevelBlocksLevelTypeRel progdurationTraineelevelBlocksLevelTypeRel = null;
		try {
			progdurationTraineelevelBlocksLevelTypeRel = 
					this.progdurationTraineelevelBlocksLevelTypeRelPersistence
					.findByProgramDurationIdAndTraineeLevelId(programDurationId, traineeLevelId);
		} catch (NoSuchProgdurationTraineelevelBlocksLevelTypeRelException e) {
			_logger.error(e);
		}
		return progdurationTraineelevelBlocksLevelTypeRel;
	}

	public List<ProgramCohortDTO> getProgramCohortsRelationalDataByProgramDurationId(long programDurationId,
			String languageCode) {
		return omsbTmsFinderFinder.getProgramCohortsRelationalDataByProgramDurationId(programDurationId, languageCode);
	}

	private static final Log _logger = LogFactoryUtil
			.getLog(ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceImpl.class.getName());

}