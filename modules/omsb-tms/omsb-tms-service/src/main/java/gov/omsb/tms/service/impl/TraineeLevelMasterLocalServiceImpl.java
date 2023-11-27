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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
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

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.ProgramStructureDTO;
import gov.omsb.tms.custom.dto.TraineeLevelListDTO;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.base.TraineeLevelMasterLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.TraineeLevelMaster", service = AopService.class)
public class TraineeLevelMasterLocalServiceImpl extends TraineeLevelMasterLocalServiceBaseImpl {

	public List<TraineeLevelListDTO> getTraineeLevelListByDurationId(long durationId) {
		return omsbTmsFinderFinder.getTraineeLevelListByDurationId(durationId);
	}

	public List<ProgramStructureDTO> getTraineeLevelMasterByProgramId(long programId) {
		logger.info("getTraineeLevelMasterByProgramId () started");
		return omsbTmsFinderFinder.getTraineeLevel(programId);
	}

	public List<TraineeLevelMaster> findByTraineeLevelName(String traineeLevelName) {
		return traineeLevelMasterPersistence.findBytraineeLevelNameByLike(traineeLevelName);
	}

	public boolean createTraineeLevelMaster(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		try {
			if (!validateTraineeLevel(actionRequest, null)) {
				return false;
			}
			long traineeLevelMasterId = counterLocalService.increment(getClass().getName(), 1);
			TraineeLevelMaster traineeLevelMaster = traineeLevelMasterLocalService
					.createTraineeLevelMaster(traineeLevelMasterId);
			Map<Locale, String> traineeLevelName = LocalizationUtil.getLocalizationMap(actionRequest,
					OmsbTmsCommonConstants.RENDER_TRAINEE_LEVEL_NAME);
			traineeLevelMaster.setCreatedBy(themeDisplay.getUserId());
			traineeLevelMaster.setModifiedBy(themeDisplay.getUserId());
			traineeLevelMaster.setTraineeLevelNameMap(traineeLevelName);
			traineeLevelMaster.setGroupId(themeDisplay.getScopeGroupId());
			traineeLevelMasterLocalService.addTraineeLevelMaster(traineeLevelMaster);
			logger.info("createTraineeLevelMaster ::: Trainee Level Master Record Created");
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
		return true;
	}

	public boolean updateTraineeLevelMaster(ActionRequest actionRequest, long traineeLevelMasterId,
			ThemeDisplay themeDisplay) throws PortalException {
		TraineeLevelMaster traineeLevelMaster = traineeLevelMasterLocalService
				.getTraineeLevelMaster(traineeLevelMasterId);
		if (Validator.isNotNull(traineeLevelMaster)) {
			if (!validateTraineeLevel(actionRequest, traineeLevelMaster)) {
				return false;
			}
			Map<Locale, String> traineeLevelName = LocalizationUtil.getLocalizationMap(actionRequest,
					OmsbTmsCommonConstants.RENDER_TRAINEE_LEVEL_NAME);
			traineeLevelMaster.setModifiedBy(themeDisplay.getUserId());
			traineeLevelMaster.setTraineeLevelNameMap(traineeLevelName);
			traineeLevelMaster.setGroupId(themeDisplay.getScopeGroupId());
			traineeLevelMasterLocalService.updateTraineeLevelMaster(traineeLevelMaster);
			logger.info("updateTraineeLevelMaster ::: Trainee Level Master Record Updated");
		} else {
			logger.info("updateTraineeLevelMaster ::: Trainee Level Record Updated Not Found " + traineeLevelMasterId);
			return false;
		}
		return true;
	}

	public boolean validateTraineeLevel(ActionRequest actionRequest, TraineeLevelMaster traineeLevelMaster) {
		List<String> traineeLevelName = new ArrayList<>();
		boolean isValid = true;
		Map<Locale, String> traineeLevelNameMap = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbTmsCommonConstants.RENDER_TRAINEE_LEVEL_NAME);

		addLocalizedValue(traineeLevelNameMap, traineeLevelName, OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(traineeLevelNameMap, traineeLevelName, OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC);

		if (checkTraineeLevel(traineeLevelName, actionRequest, traineeLevelMaster)) {
			isValid = false;
		}

		return isValid;
	}

	public boolean checkTraineeLevel(List<String> traineeLevelNames, ActionRequest actionRequest,
			TraineeLevelMaster traineeLevelMaster) {
		List<TraineeLevelMaster> traineeLevelMasters;
		for (String traineeLevelName : traineeLevelNames) {
			String likeTraineeLevelName = StringPool.PERCENT + StringPool.GREATER_THAN + traineeLevelName
					+ StringPool.LESS_THAN + StringPool.PERCENT;
			traineeLevelMasters = new ArrayList<>(
					traineeLevelMasterLocalService.findByTraineeLevelName(likeTraineeLevelName));
			if (Validator.isNotNull(traineeLevelMaster) && traineeLevelMasters.contains(traineeLevelMaster)) {
				traineeLevelMasters.remove(traineeLevelMaster);
			}
			if (!traineeLevelMasters.isEmpty()) {
				SessionErrors.add(actionRequest, OmsbTmsCommonConstants.TRAINEE_LEVEL_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}

	public void addLocalizedValue(Map<Locale, String> localizationMap, List<String> values, String languageCode) {
		Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
		String localizedValue = localizationMap.get(languageLocale);
		if (Validator.isNotNull(localizedValue)) {
			values.add(localizedValue);
		}
	}
	
	public List<TraineeLevelMaster> findByTraineeLevelIds(List<Long> traineeLevelIds) {
		DynamicQuery query = traineeLevelMasterLocalService.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("traineeLevelMasterId").in(traineeLevelIds));
		return traineeLevelMasterLocalService.dynamicQuery(query);
	}
	
	Log logger = LogFactoryUtil.getLog(TraineeLevelMasterLocalServiceImpl.class);
}