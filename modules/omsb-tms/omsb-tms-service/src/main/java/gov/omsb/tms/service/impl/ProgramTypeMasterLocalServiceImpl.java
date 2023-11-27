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
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.service.base.ProgramTypeMasterLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.ProgramTypeMaster",
	service = AopService.class
)
public class ProgramTypeMasterLocalServiceImpl
	extends ProgramTypeMasterLocalServiceBaseImpl {
	
	public List<ProgramTypeMaster> findByProgramTypeNameByLike(String programTypeName) {
		return this.programTypeMasterPersistence.findByProgramTypeNameByLike(programTypeName);
	}
	
	public boolean createProgramTypeMaster(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		try {
			if (!validateProgramType(actionRequest, null)) {
				return false;
			}
			long programTypeMasterId = counterLocalService.increment(getClass().getName(), 1);
			ProgramTypeMaster programTypeMaster = programTypeMasterLocalService
					.createProgramTypeMaster(programTypeMasterId);
			Map<Locale, String> programTypeName = LocalizationUtil.getLocalizationMap(actionRequest,
					OmsbTmsCommonConstants.RENDER_PROGRAM_TYPE_NAME);
			programTypeMaster.setCreateDate(new Date());
			programTypeMaster.setProgramTypeNameMap(programTypeName);
			programTypeMaster.setGroupId(themeDisplay.getScopeGroupId());
			programTypeMasterLocalService.addProgramTypeMaster(programTypeMaster);
			logger.info("createProgramTypeMaster ::: Program Type Master Record Created");
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
		return true;
	}

	public boolean updateProgramTypeMaster(ActionRequest actionRequest, long programTypeMasterId,
			ThemeDisplay themeDisplay) throws PortalException {
		ProgramTypeMaster programTypeMaster = programTypeMasterLocalService
				.getProgramTypeMaster(programTypeMasterId);
		if (Validator.isNotNull(programTypeMaster)) {
			if (!validateProgramType(actionRequest, programTypeMaster)) {
				return false;
			}
			Map<Locale, String> programTypeName = LocalizationUtil.getLocalizationMap(actionRequest,
					OmsbTmsCommonConstants.RENDER_PROGRAM_TYPE_NAME);
			programTypeMaster.setModifiedDate(new Date());
			programTypeMaster.setProgramTypeNameMap(programTypeName);
			programTypeMaster.setGroupId(themeDisplay.getScopeGroupId());
			programTypeMasterLocalService.updateProgramTypeMaster(programTypeMaster);
			logger.info("updateprogramTypeMasterMaster ::: program Type Master Record Updated");
		} else {
			logger.info("updateprogramTypeMasterMaster ::: program Type Master Record Updated Not Found " + programTypeMasterId);
			return false;
		}
		return true;
	}
	
	public boolean validateProgramType(ActionRequest actionRequest, ProgramTypeMaster programTypeMaster) {
		List<String> programTypeNames = new ArrayList<>();

		Map<Locale, String> programTypeNameMap = LocalizationUtil.getLocalizationMap(actionRequest, "programTypeName");

		addLocalizedValue(programTypeNameMap, programTypeNames, OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(programTypeNameMap, programTypeNames, OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC);

		if (checkprogramTypeNames(programTypeNames, actionRequest, programTypeMaster)) {
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

	public boolean checkprogramTypeNames(List<String> programTypeNames, ActionRequest actionRequest,
			ProgramTypeMaster programTypeMaster) {
		List<ProgramTypeMaster> programTypeMasters;
		for (String pgName : programTypeNames) {
			String likeProgramTypeName = StringPool.PERCENT + StringPool.GREATER_THAN + pgName + StringPool.LESS_THAN
					+ StringPool.PERCENT;
			programTypeMasters = new ArrayList<>(
					programTypeMasterLocalService.findByProgramTypeNameByLike(likeProgramTypeName));
			if (Validator.isNotNull(programTypeMaster) && programTypeMasters.contains(programTypeMaster)) {
				programTypeMasters.remove(programTypeMaster);
			}
			if (!programTypeMasters.isEmpty()) {
				SessionErrors.add(actionRequest, OmsbTmsCommonConstants.PROGRAM_TYPE_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}
	
	Log logger = LogFactoryUtil.getLog(ProgramTypeMasterLocalServiceImpl.class);
}