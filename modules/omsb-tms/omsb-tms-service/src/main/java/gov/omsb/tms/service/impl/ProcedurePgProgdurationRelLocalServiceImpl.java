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

import gov.omsb.tms.exception.NoSuchProcedurePgProgdurationRelException;
import gov.omsb.tms.model.ProcedurePgProgdurationRel;
import gov.omsb.tms.service.base.ProcedurePgProgdurationRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ProcedurePgProgdurationRel", service = AopService.class)
public class ProcedurePgProgdurationRelLocalServiceImpl extends ProcedurePgProgdurationRelLocalServiceBaseImpl {

	public List<ProcedurePgProgdurationRel> findByProgramDurationId(long programDurationId) {
		return procedurePgProgdurationRelPersistence.findByProgramDurationId(programDurationId);
	}

	public List<ProcedurePgProgdurationRel> findByProcedureGroupMasterId(long procedureGroupMasterId) {
		return procedurePgProgdurationRelPersistence.findByProcedureGroupMasterId(procedureGroupMasterId);
	}

	public List<ProcedurePgProgdurationRel> findByProcedureMasterId(long procedureMasterId) {
		return procedurePgProgdurationRelPersistence.findByProcedureMasterId(procedureMasterId);
	}

	public ProcedurePgProgdurationRel findByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
			long programDurationId, long procedureGroupMasterId, long procedureMasterId) {
		try {
			return procedurePgProgdurationRelPersistence
					.findByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(programDurationId,
							procedureGroupMasterId, procedureMasterId);			
		} catch (NoSuchProcedurePgProgdurationRelException e) {
			return null;
		}
	}
}