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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.service.base.ProcedureMasterLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ProcedureMaster", service = AopService.class)
public class ProcedureMasterLocalServiceImpl extends ProcedureMasterLocalServiceBaseImpl {

	public List<ProcedureMaster> findByProcedureNameByLike(String procedureName) {
		return this.procedureMasterPersistence.findByProcedureNameByLike(procedureName);
	}

	public List<ProcedureMaster> findByProcedureNameByLikeAndProcedureGroupMasterId(String procedureName, long procedureGroupMasterId) {
		return this.procedureMasterPersistence.findByProcedureNameByLikeAndProcedureGroupMasterId(procedureName, procedureGroupMasterId);
	}

	public List<ProcedureMaster> findByProcedureGroupMasterId(long procedureGroupMasterId) {
		return this.procedureMasterPersistence.findByProcedureGroupMasterId(procedureGroupMasterId);
	}

	public boolean createProcedureMaster(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		try {
			if (!validateProcedure(actionRequest, null)) {
				return false;
			}

			long procedureMasterId = counterLocalService.increment(getClass().getName(), 1);
			ProcedureMaster procedureMaster = procedureMasterLocalService.createProcedureMaster(procedureMasterId);
			Map<Locale, String> procedureName = LocalizationUtil.getLocalizationMap(actionRequest,
					OmsbTmsCommonConstants.RENDER_PROCEDURE_NAME);
			procedureMaster.setCreatedBy(themeDisplay.getUserId());
			procedureMaster.setModifiedBy(themeDisplay.getUserId());
			procedureMaster.setProcedureNameMap(procedureName);
			procedureMaster.setGroupId(themeDisplay.getScopeGroupId());
			procedureMasterLocalService.addProcedureMaster(procedureMaster);
			logger.debug("createProcedureMaster ::: Procedure Master Record Created");
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
		return true;
	}

	public boolean updateProcedureMaster(ActionRequest actionRequest, long procedureMasterId, ThemeDisplay themeDisplay)
			throws PortalException {
		ProcedureMaster procedureMaster = procedureMasterLocalService.getProcedureMaster(procedureMasterId);
		if (Validator.isNotNull(procedureMaster)) {
			if (!validateProcedure(actionRequest, procedureMaster)) {
				return false;
			}
			Map<Locale, String> procedureName = LocalizationUtil.getLocalizationMap(actionRequest,
					OmsbTmsCommonConstants.RENDER_PROCEDURE_NAME);
			procedureMaster.setModifiedBy(themeDisplay.getUserId());
			procedureMaster.setProcedureNameMap(procedureName);
			procedureMaster.setGroupId(themeDisplay.getScopeGroupId());
			procedureMasterLocalService.updateProcedureMaster(procedureMaster);
			logger.debug("updateProcedureMaster ::: Procedure Master Record Updated");
		} else {
			logger.debug("updateProcedureMaster ::: Procedure Master Record Updated Not Found " + procedureMasterId);
			return false;
		}
		return true;
	}

	public boolean validateProcedure(ActionRequest actionRequest, ProcedureMaster procedureMaster) {
		List<String> procedureNames = new ArrayList<>();

		Map<Locale, String> procedureNameMap = LocalizationUtil.getLocalizationMap(actionRequest, "procedureName");

		addLocalizedValue(procedureNameMap, procedureNames, OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(procedureNameMap, procedureNames, OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC);

		if (checkProcedureNames(procedureNames, actionRequest, procedureMaster)) {
			return false;
		}

		return true;
	}

	public void addLocalizedValue(Map<Locale, String> localizationMap, List<String> values, String languageCode) {
		Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
		String localizedValue = localizationMap.get(languageLocale);
		if (Validator.isNotNull(localizedValue)) {
			values.add(localizedValue);
		}
	}

	public boolean checkProcedureNames(List<String> procedureNames, ActionRequest actionRequest,
			ProcedureMaster procedureMaster) {
		List<ProcedureMaster> procedureMasters;
		for (String pgName : procedureNames) {
			String likeProcedureName = StringPool.PERCENT + StringPool.GREATER_THAN + pgName + StringPool.LESS_THAN
					+ StringPool.PERCENT;
			procedureMasters = new ArrayList<>(
					procedureMasterLocalService.findByProcedureNameByLike(likeProcedureName));
			if (Validator.isNotNull(procedureMaster) && procedureMasters.contains(procedureMaster)) {
				procedureMasters.remove(procedureMaster);
			}
			if (!procedureMasters.isEmpty()) {
				SessionErrors.add(actionRequest, OmsbTmsCommonConstants.PROCEDURE_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}

	public ProcedureMaster addUpdateProcedureMaster(ProcedureMaster procedureMaster, List<String> procedureNames, boolean isCreate) {
		if (validateProcedureNames(procedureNames, isCreate ? null : procedureMaster, procedureMaster.getProcedureGroupMasterId())) {
			return super.updateProcedureMaster(procedureMaster);
		} else {
			return null;
		}
	}

	public boolean validateProcedureNames(List<String> procedureNames, ProcedureMaster procedureMaster, long procedureGroupMasterId) {
		for (String procedureName : procedureNames) {
			String likeProcedureName = StringPool.PERCENT + StringPool.GREATER_THAN + procedureName
					+ StringPool.LESS_THAN + StringPool.PERCENT;
			// Find procedure name
			List<ProcedureMaster> procedureMasters = findByProcedureNameByLikeAndProcedureGroupMasterId(likeProcedureName, procedureGroupMasterId);
			if (!procedureMasters.isEmpty()) {
				if (Validator.isNull(procedureMaster)) {
					return false;
				} else {
					if (!procedureMasters.stream().map(ProcedureMaster::getProcedureMasterId)
							.collect(Collectors.toList()).contains(procedureMaster.getProcedureMasterId())) {
						return false;
					}
				}
			}
		}
		return true;
	}

	Log logger = LogFactoryUtil.getLog(ProcedureMasterLocalServiceImpl.class);
}