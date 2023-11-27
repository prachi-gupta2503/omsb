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
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProcedureGroupMaster;
import gov.omsb.tms.service.base.ProcedureGroupMasterLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ProcedureGroupMaster", service = AopService.class)
public class ProcedureGroupMasterLocalServiceImpl extends ProcedureGroupMasterLocalServiceBaseImpl {

	public List<ProcedureGroupMaster> findByprocedureGroupNameByLike(String procedureGroupName) {
		return this.procedureGroupMasterPersistence.findByprocedureGroupNameByLike(procedureGroupName);
	}

	public boolean createProcedureGroupMaster(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		try {
			if (!validateProcedureGroup(actionRequest, null)) {
				return false;
			}
			long procedureGroupMasterId = counterLocalService.increment(getClass().getName(), 1);
			ProcedureGroupMaster procedureGroupMaster = procedureGroupMasterLocalService
					.createProcedureGroupMaster(procedureGroupMasterId);
			Map<Locale, String> procedureGroupName = LocalizationUtil.getLocalizationMap(actionRequest,
					OmsbTmsCommonConstants.RENDER_PROCEDURE_GROUP_NAME);
			procedureGroupMaster.setCreatedBy(themeDisplay.getUserId());
			procedureGroupMaster.setModifiedBy(themeDisplay.getUserId());
			procedureGroupMaster.setProcedureGroupNameMap(procedureGroupName);
			procedureGroupMaster.setGroupId(themeDisplay.getScopeGroupId());
			procedureGroupMasterLocalService.addProcedureGroupMaster(procedureGroupMaster);
			logger.info("createProcedureGroupMaster ::: Procedure Group Master Record Created");
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
		return true;
	}

	public boolean updateProcedureGroupMaster(ActionRequest actionRequest, long procedureGroupMasterId,
			ThemeDisplay themeDisplay) throws PortalException {
		ProcedureGroupMaster procedureGroupMaster = procedureGroupMasterLocalService
				.getProcedureGroupMaster(procedureGroupMasterId);
		if (Validator.isNotNull(procedureGroupMaster)) {
			if (!validateProcedureGroup(actionRequest, procedureGroupMaster)) {
				return false;
			}
			Map<Locale, String> procedureGroupName = LocalizationUtil.getLocalizationMap(actionRequest,
					OmsbTmsCommonConstants.RENDER_PROCEDURE_GROUP_NAME);
			procedureGroupMaster.setModifiedBy(themeDisplay.getUserId());
			procedureGroupMaster.setProcedureGroupNameMap(procedureGroupName);
			procedureGroupMaster.setGroupId(themeDisplay.getScopeGroupId());
			procedureGroupMasterLocalService.updateProcedureGroupMaster(procedureGroupMaster);
			logger.info("updateProcedureGroupMaster ::: Procedure Group Master Record Updated");
		} else {
			logger.info("updateProcedureGroupMaster ::: Procedure Master Record Updated Not Found "
					+ procedureGroupMasterId);
			return false;
		}
		return true;
	}

	public boolean validateProcedureGroup(ActionRequest actionRequest, ProcedureGroupMaster procedureGroupMaster) {
		List<String> procedureGroupNames = new ArrayList<>();

		Map<Locale, String> procedureGroupNameMap = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbTmsCommonConstants.RENDER_PROCEDURE_GROUP_NAME);

		addLocalizedValue(procedureGroupNameMap, procedureGroupNames, OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(procedureGroupNameMap, procedureGroupNames, OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC);

		if (checkProcedureGroupNames(procedureGroupNames, actionRequest, procedureGroupMaster)) {
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

	public boolean checkProcedureGroupNames(List<String> procedureGroupNames, ActionRequest actionRequest,
			ProcedureGroupMaster procedureGroupMaster) {
		List<ProcedureGroupMaster> procedureGroupMasters;
		for (String pgName : procedureGroupNames) {
			String likeProcedureGroupName = StringPool.PERCENT + StringPool.GREATER_THAN + pgName + StringPool.LESS_THAN
					+ StringPool.PERCENT;
			procedureGroupMasters = new ArrayList<>(
					procedureGroupMasterLocalService.findByprocedureGroupNameByLike(likeProcedureGroupName));
			if (Validator.isNotNull(procedureGroupMaster) && procedureGroupMasters.contains(procedureGroupMaster)) {
				procedureGroupMasters.remove(procedureGroupMaster);
			}
			if (!procedureGroupMasters.isEmpty()) {
				SessionErrors.add(actionRequest, OmsbTmsCommonConstants.PROCEDURE_GROUP_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}

	public boolean createProcedureGroupMaster(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		createProcedureGroupMaster((ActionRequest) request, themeDisplay);
		return false;
	}

	public ProcedureGroupMaster addUpdateProcedureGroupMaster(ProcedureGroupMaster procedureGroupMaster, List<String> procedureGroupNames, boolean isCreate) {
		if (validateProcedureGroupNames(procedureGroupNames, isCreate ? null : procedureGroupMaster)) {
			return super.updateProcedureGroupMaster(procedureGroupMaster);
		} else {
			return null;
		}
	}

	public boolean validateProcedureGroupNames(List<String> procedureGroupNames, ProcedureGroupMaster procedureGroupMaster) {
		for (String procedureGroupName : procedureGroupNames) {
			String likeProcedureGroupName = StringPool.PERCENT + StringPool.GREATER_THAN + procedureGroupName
					+ StringPool.LESS_THAN + StringPool.PERCENT;
			// Find procedure group name
			List<ProcedureGroupMaster> procedureGroupMasters = findByprocedureGroupNameByLike(likeProcedureGroupName);
			if (!procedureGroupMasters.isEmpty()) {
				if (Validator.isNull(procedureGroupMaster)) {
					return false;
				} else {
					if (!procedureGroupMasters.stream().map(ProcedureGroupMaster::getProcedureGroupMasterId)
							.collect(Collectors.toList()).contains(procedureGroupMaster.getProcedureGroupMasterId())) {
						return false;
					}
				}
			}
		}
		return true;
	}

	Log logger = LogFactoryUtil.getLog(TraineeLevelMasterLocalServiceImpl.class);
}