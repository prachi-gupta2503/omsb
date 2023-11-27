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

import gov.omsb.tms.model.PatientTypeMaster;
import gov.omsb.tms.service.base.PatientTypeMasterLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.PatientTypeMaster", service = AopService.class)
public class PatientTypeMasterLocalServiceImpl extends PatientTypeMasterLocalServiceBaseImpl {

	public List<PatientTypeMaster> findByPatientTypeNameByLike(String patientTypeName) {
		return this.patientTypeMasterPersistence.findByPatientTypeNameByLike(patientTypeName);
	}

	public PatientTypeMaster addUpdatePatientTypeMaster(PatientTypeMaster patientTypeMaster,
			List<String> patientTypeNames, boolean isCreate) {
		if (validatePatientTypeNames(patientTypeNames, isCreate ? null : patientTypeMaster)) {
			return super.updatePatientTypeMaster(patientTypeMaster);
		} else {
			return null;
		}
	}

	public boolean validatePatientTypeNames(List<String> patientTypeNames, PatientTypeMaster patientTypeMaster) {
		for (String patientTypeName : patientTypeNames) {
			String likePatientTypeMaster = StringPool.PERCENT + StringPool.GREATER_THAN + patientTypeName
					+ StringPool.LESS_THAN + StringPool.PERCENT;
			// Find patient type
			List<PatientTypeMaster> patientTypeMasters = findByPatientTypeNameByLike(likePatientTypeMaster);
			if (!patientTypeMasters.isEmpty()) {
				if (Validator.isNull(patientTypeMaster)) {
					return false;
				} else {
					if (!patientTypeMasters.stream().map(PatientTypeMaster::getPatientTypeMasterId)
							.collect(Collectors.toList()).contains(patientTypeMaster.getPatientTypeMasterId())) {
						return false;
					}
				}
			}
		}
		return true;
	}

}