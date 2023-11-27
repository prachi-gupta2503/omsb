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

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.exception.NoSuchProgramEligibilityDegreeRelException;
import gov.omsb.tms.model.ProgramEligibilityDegreeRel;
import gov.omsb.tms.service.base.ProgramEligibilityDegreeRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ProgramEligibilityDegreeRel", service = AopService.class)
public class ProgramEligibilityDegreeRelLocalServiceImpl extends ProgramEligibilityDegreeRelLocalServiceBaseImpl {

	public ProgramEligibilityDegreeRel findByProgramAndEligibilityDegreeId(long programMasterId,
			long eligibilityDegreeMasterId) {
		ProgramEligibilityDegreeRel programEligibilityDegreeRel = null;
		try {
			programEligibilityDegreeRel = this.programEligibilityDegreeRelPersistence
					.findByProgramEligibilityDegreeId(programMasterId, eligibilityDegreeMasterId);
		} catch (NoSuchProgramEligibilityDegreeRelException e) {
			e.printStackTrace();
		}
		return programEligibilityDegreeRel;
	}

	public ProgramEligibilityDegreeRel findEligibilityRelByProgramId(long programMasterId) {
		ProgramEligibilityDegreeRel programEligibilityDegreeRel = null;
		try {
			programEligibilityDegreeRel = this.programEligibilityDegreeRelPersistence.findByProgramId(programMasterId);
		} catch (NoSuchProgramEligibilityDegreeRelException e) {
			_logger.error(e);
		}
		return programEligibilityDegreeRel;
	}

	private static final Log _logger = LogFactoryUtil
			.getLog(ProgramEligibilityDegreeRelLocalServiceImpl.class.getName());

}