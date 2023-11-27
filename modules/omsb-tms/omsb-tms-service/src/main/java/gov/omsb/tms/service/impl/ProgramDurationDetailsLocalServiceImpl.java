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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.custom.dto.ProgramCohortDTO;
import gov.omsb.tms.exception.NoSuchProgramDurationDetailsException;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.service.base.ProgramDurationDetailsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ProgramDurationDetails", service = AopService.class)
public class ProgramDurationDetailsLocalServiceImpl extends ProgramDurationDetailsLocalServiceBaseImpl {

	public List<ProgramDurationDetails> findProgramDurationByProgramId(long programId) {
		return this.programDurationDetailsPersistence.findByProgramId(programId);
	}

	public List<Long> getProgramDurationIdFromProgramIds(List<Long> programIds) {
		List<ProgramDurationDetails> progrmaDurationList = new ArrayList<>();

		programIds.forEach(
				programId -> progrmaDurationList.addAll(programDurationDetailsPersistence.findByProgramId(programId)));

		return progrmaDurationList.stream().map(ProgramDurationDetails::getProgDurationId).collect(Collectors.toList());
	}

	public ProgramDurationDetails findByProgramIdAndAYApplicableFrom(long programId, String ayApplicableForm) {
		ProgramDurationDetails details = null;
		try {
			details = this.programDurationDetailsPersistence.findByProgramIdAndAYApplicableFrom(programId,
					ayApplicableForm);
		} catch (NoSuchProgramDurationDetailsException e) {
			_logger.error(e);
		}
		return details;
	}

	public List<ProgramCohortDTO> getProgramAndCohortsFromProgramDuration(List<Long> programIds, List<String> yearRange,
			String languageCode) {
		return omsbTmsFinderFinder.getProgramAndCohortsFromProgramDuration(programIds, yearRange, languageCode);
	}

	private static final Log _logger = LogFactoryUtil.getLog(ProgramDurationDetailsLocalServiceImpl.class.getName());
}