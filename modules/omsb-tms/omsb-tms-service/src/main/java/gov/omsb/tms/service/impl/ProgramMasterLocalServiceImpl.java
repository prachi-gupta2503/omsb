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
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.custom.dto.ProgramDTO;
import gov.omsb.tms.custom.dto.ProgramStructureDTO;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.base.ProgramMasterLocalServiceBaseImpl;

/**
 * @author Aditya Meghnathi
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ProgramMaster", service = AopService.class)
public class ProgramMasterLocalServiceImpl extends ProgramMasterLocalServiceBaseImpl {

	public List<ProgramMaster> findByProgramStatus(Boolean programStatus) {
		return this.programMasterPersistence.findByProgramStatus(programStatus);
	}

	public List<ProgramDTO> getAllProgramList(String languageCode) {
		return omsbTmsFinderFinder.getAllPrograms(languageCode);
	}

	public ProgramDTO getProgramDetails(long programId, String languageCode) {
		return omsbTmsFinderFinder.getProgramDetails(programId, languageCode);
	}

	public List<ProgramStructureDTO> getProgramStructure(long programDurationId, String languageCode) {
		return omsbTmsFinderFinder.getProgramStructure(programDurationId, languageCode);
	}

	public List<ProgramMaster> findByProgramNameByLike(String programName) {
		return this.programMasterPersistence.findByProgramNameByLike(programName);
	}

	public List<ProgramMaster> findByProgramCodeByLike(String programCode) {
		return this.programMasterPersistence.findByProgramCodeByLike(programCode);
	}

	public List<ProgramMaster> findProgramByPorgramType(long programTypeId) {
		return this.programMasterPersistence.findByprogramTypeId(programTypeId);
	}

	public List<ProgramMaster> findByProgramMasterId(List<Long> programIds) {
		List<ProgramMaster> programMasterList = new ArrayList<>();
		try {
			DynamicQuery savedSearch = ProgramMasterLocalServiceUtil.dynamicQuery();
			savedSearch.add(RestrictionsFactoryUtil.in("programMasterId", programIds));
			programMasterList = ProgramMasterLocalServiceUtil.dynamicQuery(savedSearch);
		} catch (Exception e) {
			_logger.info("findByProgramMasterId ::: " + e);
		}
		return programMasterList;
	}

	public List<ProgramMaster> getProgramListByIdsAndStatus(List<Long> ids, Boolean status) {
		DynamicQuery query = programMasterLocalService.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("programStatus", status))
				.add(PropertyFactoryUtil.forName("programMasterId").in(ids));
		return programMasterLocalService.dynamicQuery(query);
	}

	public List<ProgramMaster> getProgramListByIds(List<Long> ids) {
		DynamicQuery query = programMasterLocalService.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("programMasterId").in(ids));
		return programMasterLocalService.dynamicQuery(query);
	}

	public List<ProgramDTO> getProgramDTOListByIds(List<Long> ids, String languageCode) {
		List<ProgramDTO> programDTOList = new ArrayList<>();
		for (ProgramDTO programDTO : getAllProgramList(languageCode)) {
			if (ids.contains(programDTO.getProgramMasterId())) {
				programDTOList.add(programDTO);
			}
		}
		return programDTOList;
	}

	private static final Log _logger = LogFactoryUtil.getLog(ProgramMasterLocalServiceImpl.class.getName());
}