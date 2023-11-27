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

import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.custom.dto.TraineeLoggedProcedureDetailsDTO;
import gov.omsb.tms.model.TraineeLoggedProcedureDetails;
import gov.omsb.tms.service.base.TraineeLoggedProcedureDetailsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.TraineeLoggedProcedureDetails", service = AopService.class)
public class TraineeLoggedProcedureDetailsLocalServiceImpl extends TraineeLoggedProcedureDetailsLocalServiceBaseImpl {

	public List<TraineeLoggedProcedureDetails> findTraineeLoggedProcedureDetailsByPatientId(String patientId) {
		return traineeLoggedProcedureDetailsPersistence.findByPatientId(patientId);
	}

	public List<TraineeLoggedProcedureDetailsDTO> getTraineeLoggedProcedureDetailsList(boolean isSuperVisor,
			boolean getByDedicatedProgram, long supervisorId, String programIds, String languageCode) {
		return this.omsbTmsFinderFinder.getTraineeLoggedProcedureDetailsList(isSuperVisor, getByDedicatedProgram,
				supervisorId, programIds, languageCode);
	}

	public TraineeLoggedProcedureDetailsDTO getTraineeLoggedProcedureDetail(long supervisorId,	long traineeLoggedProcedureDetailsId, String languageCode) {
		return this.omsbTmsFinderFinder.getTraineeLoggedProcedureDetail(supervisorId, traineeLoggedProcedureDetailsId, languageCode);
	}
	
	public List<TraineeLoggedProcedureDetails> findByPatientIdByLike(String patientId) {
		return this.traineeLoggedProcedureDetailsPersistence.findByPatientIdByLike(patientId);
	}

	public List<TraineeLoggedProcedureDetails> findByTraineeId(long traineeId) {
		return traineeLoggedProcedureDetailsPersistence.findByTraineeId(traineeId);
	}
	
	public long getRotationIdByDatePerformed(String datePerformed, long traineeId) {
		return this.omsbTmsFinderFinder.getRotationIdByDatePerformed(datePerformed, traineeId);
	}
}