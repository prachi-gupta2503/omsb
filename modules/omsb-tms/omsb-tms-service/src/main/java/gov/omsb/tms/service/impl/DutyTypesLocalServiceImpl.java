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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.custom.dto.DutyTypeDTO;
import gov.omsb.tms.exception.NoSuchDutyTypesException;
import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.service.base.DutyTypesLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.DutyTypes", service = AopService.class)
public class DutyTypesLocalServiceImpl extends DutyTypesLocalServiceBaseImpl {

	public DutyTypes addDutyTypes(String dutyType, long groupId, long userId) throws PortalException {
		// Get Group(Site) and User Information
		DutyTypes dutytype = null;
		try {
			dutytype = dutyTypesPersistence.findByDutyType(dutyType);
			if (dutytype.getStatus().equalsIgnoreCase("Inactive")) {
				dutytype.setStatus("Active");
				dutytype.setModifiedDate(new Date());
				dutytype.setModifiedBy(userId);
				dutytype = super.updateDutyTypes(dutytype);
				return dutytype;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		if (dutytype == null) {
			long dutyTypeId = counterLocalService.increment(DutyTypes.class.getName());
			dutytype = createDutyTypes(dutyTypeId);
			dutytype.setDutyType(dutyType);
			dutytype.setCreatedBy(userId);
			dutytype.setCreateDate((new Date()));
			dutytype.setGroupId(groupId);
			dutytype.setStatus("Active");
			dutytype = super.addDutyTypes(dutytype);
			LOGGER.info("duty types added");
		}
		return dutytype;
	}

	// get dutyTypes List
	public List<DutyTypes> getDutyTypesList() {
		List<DutyTypes> dutyTypes = getDutyTypeses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<DutyTypes> dutyTypesList = new ArrayList<DutyTypes>();
		for (DutyTypes dutyTypesObj : dutyTypes) {
			if (dutyTypesObj.getStatus().equalsIgnoreCase("Active")) {
				dutyTypesList.add(dutyTypesObj);
			}
		}
		return dutyTypesList;
	}

	public DutyTypes editDutyTypes(long dutyTypeId, long userId, String dutyType) throws PortalException {
		DutyTypes dutyTypes = getDutyTypes(dutyTypeId);
		dutyTypes.setDutyType(dutyType);
		dutyTypes.setModifiedBy(userId);
		dutyTypes = super.updateDutyTypes(dutyTypes);
		return dutyTypes;
	}

	public DutyTypes deleteDutyType(long dutyTypeId) {
		DutyTypes dutyTypes = null;
		try {
			dutyTypes = getDutyTypes(dutyTypeId);
			dutyTypes.setStatus("Inactive");
			dutyTypes = updateDutyTypes(dutyTypes);
		} catch (PortalException e) {
			LOGGER.error("Error message" + e.getMessage());
		}
		return dutyTypes;
	}

	public String getDutyTypesListByDutyType(String dutyType) {
		DutyTypes dutyTypes = null;
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		try {
			dutyTypes = dutyTypesPersistence.findByDutyType(dutyType);
			if (dutyTypes.getStatus().equalsIgnoreCase("Active")) {
				jsonObject.put("status", "409");
				jsonObject.put("error", "Duty Type already exists*");
				return jsonObject.toString();
			}
		} catch (NoSuchDutyTypesException e) {
			LOGGER.error(e.getMessage());
		}
		jsonObject.put("status", "200");
		return jsonObject.toString();
	}

	public List<DutyTypeDTO> getAcgmeCallRule8Hour(long dutyTypeId, long traineeId, long blockId) {
		return omsbTmsFinderFinder.getAcgmeCallRule8Hour(dutyTypeId, traineeId, blockId);
	}

	public DutyTypes findByDutyTypeAndStatus(String dutyType,String status) {
		try {
			return dutyTypesPersistence.findByDutyTypeAndStatus(dutyType,status);
		} catch (NoSuchDutyTypesException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(DutyTypesLocalServiceImpl.class);
}