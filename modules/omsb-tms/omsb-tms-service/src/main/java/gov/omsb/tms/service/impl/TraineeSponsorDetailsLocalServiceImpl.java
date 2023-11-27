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
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException;
import gov.omsb.tms.model.TraineeSponsorDetails;
import gov.omsb.tms.service.base.TraineeSponsorDetailsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.TraineeSponsorDetails",
	service = AopService.class
)
public class TraineeSponsorDetailsLocalServiceImpl
	extends TraineeSponsorDetailsLocalServiceBaseImpl {
	
	public TraineeSponsorDetails getTraineeSponsorDetailsByTraineeId(long traineeId){
		try {
			return this.traineeSponsorDetailsPersistence.findBytraineeId(traineeId);
		} catch (NoSuchTraineeSponsorDetailsException e) {

			return null;
		}
	}
}