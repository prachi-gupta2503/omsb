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

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.exception.NoSuchViolationUpdateStatusException;
import gov.omsb.tms.model.ViolationUpdateStatus;
import gov.omsb.tms.service.base.ViolationUpdateStatusLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.ViolationUpdateStatus",
	service = AopService.class
)
public class ViolationUpdateStatusLocalServiceImpl
	extends ViolationUpdateStatusLocalServiceBaseImpl {

	public ViolationUpdateStatus getByBlocksMetadataDetailRelId(long blocksMetadataDetailRelId) {
		try {
			return violationUpdateStatusPersistence.findByBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
		} catch (NoSuchViolationUpdateStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}