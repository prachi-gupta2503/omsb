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

import gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException;
import gov.omsb.tms.model.ProgramProgramTypeRel;
import gov.omsb.tms.service.base.ProgramProgramTypeRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ProgramProgramTypeRel", service = AopService.class)
public class ProgramProgramTypeRelLocalServiceImpl extends ProgramProgramTypeRelLocalServiceBaseImpl {

	public ProgramProgramTypeRel findByProgramAndProgramTypeId(long programMasterId, long programTypeMasterId) {
		ProgramProgramTypeRel programProgramTypeRel = null;
		try {
			programProgramTypeRel = this.programProgramTypeRelPersistence.findByProgramProgramType(programMasterId,
					programTypeMasterId);
		} catch (NoSuchProgramProgramTypeRelException e) {
			_logger.error(e);
		}
		return programProgramTypeRel;
	}

	public ProgramProgramTypeRel findByProgramId(long programMasterId) {
		ProgramProgramTypeRel programProgramTypeRel = null;
		try {
			programProgramTypeRel = this.programProgramTypeRelPersistence.findByProgramId(programMasterId);
		} catch (NoSuchProgramProgramTypeRelException e) {
			_logger.error(e);
		}
		return programProgramTypeRel;
	}
	public List<ProgramProgramTypeRel> findProgramMasterByPerogramTypeId(long programTypeId) {
		return programProgramTypeRelPersistence.findByprogramTypeId(programTypeId);
	}

	private static final Log _logger = LogFactoryUtil.getLog(ProgramProgramTypeRelLocalServiceImpl.class.getName());
}