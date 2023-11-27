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

package gov.omsb.tms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProcedureGroupProceduresCPTCodeRelService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupProceduresCPTCodeRelService
 * @generated
 */
public class ProcedureGroupProceduresCPTCodeRelServiceWrapper
	implements ProcedureGroupProceduresCPTCodeRelService,
			   ServiceWrapper<ProcedureGroupProceduresCPTCodeRelService> {

	public ProcedureGroupProceduresCPTCodeRelServiceWrapper() {
		this(null);
	}

	public ProcedureGroupProceduresCPTCodeRelServiceWrapper(
		ProcedureGroupProceduresCPTCodeRelService
			procedureGroupProceduresCPTCodeRelService) {

		_procedureGroupProceduresCPTCodeRelService =
			procedureGroupProceduresCPTCodeRelService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _procedureGroupProceduresCPTCodeRelService.
			getOSGiServiceIdentifier();
	}

	@Override
	public ProcedureGroupProceduresCPTCodeRelService getWrappedService() {
		return _procedureGroupProceduresCPTCodeRelService;
	}

	@Override
	public void setWrappedService(
		ProcedureGroupProceduresCPTCodeRelService
			procedureGroupProceduresCPTCodeRelService) {

		_procedureGroupProceduresCPTCodeRelService =
			procedureGroupProceduresCPTCodeRelService;
	}

	private ProcedureGroupProceduresCPTCodeRelService
		_procedureGroupProceduresCPTCodeRelService;

}