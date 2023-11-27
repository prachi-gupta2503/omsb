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

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.custom.dto.TrainingSiteByRotationsDTO;
import gov.omsb.tms.exception.NoSuchTraineeRotationTsBlockDetailsRelException;
import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel;
import gov.omsb.tms.service.base.TraineeRotationTsBlockDetailsRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel", service = AopService.class)
public class TraineeRotationTsBlockDetailsRelLocalServiceImpl
		extends TraineeRotationTsBlockDetailsRelLocalServiceBaseImpl {

	public List<TraineeRotationTsBlockDetailsRel> findByTraineeId(long traineeId) {
		return this.traineeRotationTsBlockDetailsRelPersistence.findByTraineeId(traineeId);
	}

	public List<TraineeRotationTsBlockDetailsRel> findByTraineeIdAndStatus(long traineeId, String status) {
		return this.traineeRotationTsBlockDetailsRelPersistence.findByTraineeIdAndStatus(traineeId, status);
	}

	public List<TraineeRotationTsBlockDetailsRel> findByProgDurationRotationTsRelId(long progDurationRotationTsRelId) {
		return this.traineeRotationTsBlockDetailsRelPersistence
				.findByProgDurationRotationTsRelId(progDurationRotationTsRelId);
	}

	public List<TrainingSiteByRotationsDTO> getTrainingSiteByRotation(List<Long> programIds, String languageCode,
			long progDurationId) {
		return omsbTmsFinderFinder.getTrainingSiteByRotation(programIds, languageCode, progDurationId);
	}

	public List<TraineeRotationTsBlockDetailsRel> findByBlocksMetadataDetailsRelId(long blocksMetadataDetailsRelId) {

		return traineeRotationTsBlockDetailsRelPersistence.findByBlocksMetadataDetailsRelId(blocksMetadataDetailsRelId);
	}

	public TraineeRotationTsBlockDetailsRel findByTraineeIdAndBlocksMetadataDetailsRelId(long traineeId,
			long blocksMetadataDetailsRelId) {
		try {
			return traineeRotationTsBlockDetailsRelPersistence.findByTraineeIdAndBlocksMetadataDetailsRelId(traineeId,
					blocksMetadataDetailsRelId);
		} catch (NoSuchTraineeRotationTsBlockDetailsRelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}