package gov.omsb.setup.procedures.web.portlet.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;

import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;

/**
 * 
 * @author Aditya Meghnathi
 *
 */
public class OmsbSetupProcedureUtil {
	private OmsbSetupProcedureUtil() {
	}

	public static ProgdurationRotationTlPgProcedurePtRel createSetupProcedureObject(ActionRequest actionRequest,
			ProgdurationRotationTlPgProcedurePtRel progdurationRotationTlPgProcedurePtRel, ThemeDisplay themeDisplay) {
		_logger.info("createSetupProcedureObject Invoked ::: ");
		long programDurationId = ParamUtil.getLong(actionRequest,
				OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_FOR_CONFIG, GetterUtil.DEFAULT_LONG);
		long procedureGroupId = ParamUtil.getLong(actionRequest, OmsbSetupProceduresWebPortletKeys.PROCEDURE_GROUP,
				GetterUtil.DEFAULT_LONG);
		long procedureId = ParamUtil.getLong(actionRequest, OmsbSetupProceduresWebPortletKeys.PROCEDURES,
				GetterUtil.DEFAULT_LONG);

		progdurationRotationTlPgProcedurePtRel.setGroupId(themeDisplay.getScopeGroupId());
		progdurationRotationTlPgProcedurePtRel.setProgramDurationId(programDurationId);
		progdurationRotationTlPgProcedurePtRel.setProcedureGroupId(procedureGroupId);
		progdurationRotationTlPgProcedurePtRel.setProcedureId(procedureId);
		progdurationRotationTlPgProcedurePtRel.setCreatedBy(themeDisplay.getUserId());
		progdurationRotationTlPgProcedurePtRel.setModifiedBy(themeDisplay.getUserId());
		progdurationRotationTlPgProcedurePtRel.setCreateDate(new Date());
		progdurationRotationTlPgProcedurePtRel.setModifiedDate(new Date());

		_logger.info("createSetupProcedureObject Exit ::: ");
		return progdurationRotationTlPgProcedurePtRel;
	}

	public static ProgdurationRotationTlPgProcedurePtRel createSetupProcedureObject(ActionRequest actionRequest,
			ProgdurationRotationTlPgProcedurePtRel progdurationRotationTlPgProcedurePtRel, Integer procedureNum,
			Integer rotationNum, ThemeDisplay themeDisplay) {
		_logger.info("createSetupProcedureObject Invoked ::: ");
		long programDurationId = ParamUtil.getLong(actionRequest,
				OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_FOR_CONFIG, GetterUtil.DEFAULT_LONG);
		long procedureGroupId = ParamUtil.getLong(actionRequest,
				OmsbSetupProceduresWebPortletKeys.PROCEDURE_GROUP + StringPool.DASH + procedureNum,
				GetterUtil.DEFAULT_LONG);
		long procedureId = ParamUtil.getLong(actionRequest,
				OmsbSetupProceduresWebPortletKeys.PROCEDURES + StringPool.DASH + procedureNum, GetterUtil.DEFAULT_LONG);
		long rotationId = ParamUtil.getLong(actionRequest, OmsbSetupProceduresWebPortletKeys.ROTATION + StringPool.DASH
				+ procedureNum + StringPool.DASH + rotationNum, GetterUtil.DEFAULT_LONG);
		long traineeLevelId = ParamUtil.getLong(actionRequest, OmsbSetupProceduresWebPortletKeys.TRAINEE_LEVEL
				+ StringPool.DASH + procedureNum + StringPool.DASH + rotationNum, GetterUtil.DEFAULT_LONG);
		int minimumProcedures = ParamUtil.getInteger(actionRequest, OmsbSetupProceduresWebPortletKeys.MINIMUM_PROCEDURES
				+ StringPool.DASH + procedureNum + StringPool.DASH + rotationNum, GetterUtil.DEFAULT_INTEGER);

		progdurationRotationTlPgProcedurePtRel.setGroupId(themeDisplay.getScopeGroupId());
		progdurationRotationTlPgProcedurePtRel.setProgramDurationId(programDurationId);
		progdurationRotationTlPgProcedurePtRel.setRotationId(rotationId);
		progdurationRotationTlPgProcedurePtRel.setTraineeLevelId(traineeLevelId);
		if(traineeLevelId!=0) {
			progdurationRotationTlPgProcedurePtRel.setTraineelevelMinimumProcedures(minimumProcedures);
		}else {
			progdurationRotationTlPgProcedurePtRel.setMinimumProcedures(minimumProcedures);
		}
		progdurationRotationTlPgProcedurePtRel.setProcedureGroupId(procedureGroupId);
		progdurationRotationTlPgProcedurePtRel.setProcedureId(procedureId);
		progdurationRotationTlPgProcedurePtRel.setCreatedBy(themeDisplay.getUserId());
		progdurationRotationTlPgProcedurePtRel.setModifiedBy(themeDisplay.getUserId());

		_logger.info("createSetupProcedureObject Exit ::: ");
		return progdurationRotationTlPgProcedurePtRel;
	}
	
	public static Map<Long, String> sortMapByValues(Map<Long, String> unsortedMap) {
        List<Entry<Long, String>> list = new LinkedList<>(unsortedMap.entrySet());

        // Sort the list of map entries by values
        list.sort(Entry.comparingByValue());

        // Create a LinkedHashMap to preserve the order
        Map<Long, String> sortedMap = new LinkedHashMap<>();

        // Populate the sorted map
        for (Entry<Long, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSetupProcedureUtil.class.getName());
}