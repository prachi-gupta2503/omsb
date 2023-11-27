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
 * Provides a wrapper for {@link DutyTypesService}.
 *
 * @author Brian Wing Shun Chan
 * @see DutyTypesService
 * @generated
 */
public class DutyTypesServiceWrapper
	implements DutyTypesService, ServiceWrapper<DutyTypesService> {

	public DutyTypesServiceWrapper() {
		this(null);
	}

	public DutyTypesServiceWrapper(DutyTypesService dutyTypesService) {
		_dutyTypesService = dutyTypesService;
	}

	@Override
	public gov.omsb.tms.model.DutyTypes deleteDutyTypes(long dutyTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyTypesService.deleteDutyTypes(dutyTypeId);
	}

	@Override
	public String getDutyTypesByDutyType(String dutyType) {
		return _dutyTypesService.getDutyTypesByDutyType(dutyType);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dutyTypesService.getOSGiServiceIdentifier();
	}

	@Override
	public DutyTypesService getWrappedService() {
		return _dutyTypesService;
	}

	@Override
	public void setWrappedService(DutyTypesService dutyTypesService) {
		_dutyTypesService = dutyTypesService;
	}

	private DutyTypesService _dutyTypesService;

}