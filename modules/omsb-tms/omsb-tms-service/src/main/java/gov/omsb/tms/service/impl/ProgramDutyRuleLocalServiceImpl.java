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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.exception.NoSuchProgramDutyRuleException;
import gov.omsb.tms.model.DutyRule;
import gov.omsb.tms.model.ProgramDutyRule;
import gov.omsb.tms.service.DutyRuleLocalService;
import gov.omsb.tms.service.base.ProgramDutyRuleLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ProgramDutyRule", service = AopService.class)
public class ProgramDutyRuleLocalServiceImpl extends ProgramDutyRuleLocalServiceBaseImpl {
	private static final Log LOGGER = LogFactoryUtil.getLog(DutyTypesLocalServiceImpl.class);

	public ProgramDutyRule addProgramDutyRules(long programId, long cohortId, long[] dutyRulesId,
			ServiceContext serviceContext) {
		LOGGER.info("ProgramDutyRuleLocalServiceImpl---------");
		List<ProgramDutyRule> programDutyRuleList = programDutyRulePersistence.findByProgramIdAndCohortId(programId,
				cohortId);
		ProgramDutyRule programDutyRule = null;
		long groupId = serviceContext.getScopeGroupId();
		long createdBy = serviceContext.getUserId();
		if (!programDutyRuleList.isEmpty()) {
			editProgramDutyRules(programId, cohortId, dutyRulesId, groupId, createdBy, programDutyRuleList);

		} else {
			saveProgramDutyRule(programId, cohortId, dutyRulesId, groupId, createdBy);
		}

		return programDutyRule;
	}

	private ProgramDutyRule editProgramDutyRules(long programId, long cohortId, long[] dutyRulesIds, long groupId,
			long userId, List<ProgramDutyRule> programDutyRuleList) {
		ProgramDutyRule programDutyRule = null;
		for (ProgramDutyRule programRule : programDutyRuleList) {
			if (!isInList(programRule, dutyRulesIds)) {
				// update - set inactive
				LOGGER.info("update - set inactive-------");
				programRule.setStatus("Inactive");
				programDutyRule = super.updateProgramDutyRule(programRule);
			}
		}
		List<Long> newRoleIds = new ArrayList<Long>();
		for (long dutyRuleId : dutyRulesIds) {
			if (!isInList(dutyRuleId, programDutyRuleList)) {
				newRoleIds.add(dutyRuleId);
			}

		}
		if (!newRoleIds.isEmpty()) {
			saveProgramDutyRule(programId, cohortId, newRoleIds.stream().mapToLong(Long::longValue).toArray(), groupId,
					userId);
		}
		return programDutyRule;
	}

	public List<DutyRule> getDutyRulesListByProgramAndCohort(long programId, long cohortId) {
		List<ProgramDutyRule> programDutyRuleList = programDutyRulePersistence.findByProgramIdAndCohortId(programId,
				cohortId);
		LOGGER.info("programDutyRuleList  :: "+programDutyRuleList);
		List<DutyRule> dutyRuleList = new ArrayList<>();
		DutyRule dutyRule = null;
		for (ProgramDutyRule programDutyRule : programDutyRuleList) {
			if (programDutyRule.getStatus().equalsIgnoreCase("Active")) {
				try {
					dutyRule = dutyRuleLocalService.getDutyRule(programDutyRule.getDutyRuleId());
					dutyRuleList.add(dutyRule);
				} catch (PortalException e) {
					LOGGER.info("Error duty rule not found ");
				}
			}
		}
		return dutyRuleList;
	}

	private boolean isInList(ProgramDutyRule programDutyRule, long[] dutyRulesId) {
		for (long dutyRuleId : dutyRulesId) {
			if (dutyRuleId == programDutyRule.getDutyRuleId()) {
				return true;
			}
		}
		return false;
	}

	private boolean isInList(long dutyRulesId, List<ProgramDutyRule> programDutyRuleList) {
		for (ProgramDutyRule programDutyRule : programDutyRuleList) {
			if (programDutyRule.getDutyRuleId() == dutyRulesId) {
				return true;
			}
		}
		return false;
	}

	private ProgramDutyRule saveProgramDutyRule(long programId, long cohortId, long[] dutyRulesId, long groupId,
			long createdBy) {
		ProgramDutyRule programDutyRule = null;
		for (Long dutyRuleId : dutyRulesId) {
			long programDutyRuleId = counterLocalService.increment(ProgramDutyRule.class.getName());
			programDutyRule = createProgramDutyRule(programDutyRuleId);
			programDutyRule.setProgramId(programId);
			programDutyRule.setCohortId(cohortId);
			programDutyRule.setGroupId(groupId);
			programDutyRule.setCreateDate(new Date());
			programDutyRule.setCreatedBy(createdBy);
			programDutyRule.setDutyRuleId(dutyRuleId);
			programDutyRule.setStatus("Active");
			programDutyRule = super.addProgramDutyRule(programDutyRule);
			LOGGER.info("saved-------------");
		}
		return programDutyRule;
	}

	

	@Reference
	private DutyRuleLocalService dutyRuleLocalService;

}