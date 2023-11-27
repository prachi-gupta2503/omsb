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

import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.custom.dto.RotationDTO;
import gov.omsb.tms.custom.dto.RotationListDTO;
import gov.omsb.tms.custom.dto.RotationStructureDTO;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.service.base.RotationMasterLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.RotationMaster", service = AopService.class)
public class RotationMasterLocalServiceImpl extends RotationMasterLocalServiceBaseImpl {

	public List<RotationMaster> findByRotationStatus(Boolean rotationStatus) {
		return this.rotationMasterPersistence.findByRotationStatus(rotationStatus);
	}

	public List<RotationStructureDTO> getRotationStructure(long rotationId, String languageCode) {
		return this.omsbTmsFinderFinder.getRotationStructure(rotationId, languageCode);
	}

	public List<RotationListDTO> getRotationsByTraineeLevelId(long traineeLevelId, String languageCode) {
		return omsbTmsFinderFinder.getRotationsByTraineeLevelId(traineeLevelId, languageCode);
	}
	
	public List<RotationListDTO> getRotationsByTraineeLevelIdAndProgramDurationId(long traineeLevelId, long programDurationId, String languageCode) {
		return omsbTmsFinderFinder.getRotationsByTraineeLevelIdAndProgramDurationId(traineeLevelId, programDurationId, languageCode);
	}
	
	public List<RotationMaster> findByRotationNameByLike(String rotationName) {
		return this.rotationMasterPersistence.findByRotationNameByLike(rotationName);
	}

	public List<RotationMaster> findByRotationCodeByLike(String rotationCode) {
		return this.rotationMasterPersistence.findByRotationCodeByLike(rotationCode);
	}
	
	public List<RotationDTO> getRotationsByTrainingSiteAndCohort(long trainingSiteId, long programDurationId, String languageCode) {
		return omsbTmsFinderFinder.getRotationsByTrainingSiteAndCohort(trainingSiteId, programDurationId, languageCode);
	}
	
	public List<RotationMaster> getRotationListByIdsAndStatus(List<Long> ids, Boolean status) {
		DynamicQuery query = rotationMasterLocalService.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("rotationStatus", status))
				.add(PropertyFactoryUtil.forName("rotationMasterId").in(ids));
		return rotationMasterLocalService.dynamicQuery(query);
	}
}