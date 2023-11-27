package gov.omsb.programs.web.mvccommands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.programs.web.portlet.util.OmsbProgramUtil;
import gov.omsb.tms.model.CompetenciesMaster;
import gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel;
import gov.omsb.tms.model.ProgdurationObjectivesRel;
import gov.omsb.tms.service.CompetenciesMasterLocalService;
import gov.omsb.tms.service.CompetenciesMasterLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=/get/objectiveDetails" }, service = MVCResourceCommand.class)
public class OmsbObjectivesMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("doServeResource Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programCohortId = ParamUtil.getLong(resourceRequest, OmsbProgramConstants.PROGRAM_COHORT_ID, 0l);
		
		_logger.info("programCohortId :::"+programCohortId);
		
		List<ProgdurationCompetenciesRequirementsRel> competenciesRequirementsRels = OmsbProgramUtil
				.getCompetenciesRequirementsListByProgDurationIdAndCompetencyType(programCohortId);
		List<ProgdurationObjectivesRel> progdurationObjectivesRels = OmsbProgramUtil
				.getProgdurationObjectivesListByProgDurationIdAndObjetiveType(programCohortId);
		List<CompetenciesMaster> competenciesMasters = competenciesMasterLocalService
				.getCompetenciesMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		boolean isTrainee = CommonUtil.isTraineeUser(themeDisplay.getUser());
		boolean isFaculty = CommonUtil.isFacultyUser(themeDisplay.getUser());
		
		_logger.info("progdurationObjectivesRels :::"+progdurationObjectivesRels);
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray objectiveDetailsArray = JSONFactoryUtil.createJSONArray();
		JSONObject objectivesJson = JSONFactoryUtil.createJSONObject();

		objectivesJson.put(OmsbProgramConstants.COMPETENCIESN_MASTER, competenciesMasters);
		objectivesJson.put(OmsbProgramConstants.PROGDURARATION_COMPETENCIES_REQUIREMENTS_REL,
				competenciesRequirementsRels);
		objectivesJson.put(OmsbProgramConstants.PROGDURATION_OBJECTIVE_REL, progdurationObjectivesRels);
		objectivesJson.put(OmsbProgramConstants.IS_TRAINEE, isTrainee);
		objectivesJson.put(OmsbProgramConstants.IS_FACULTY, isFaculty);

		if (isFaculty) {
			objectivesJson.put(OmsbProgramConstants.PROG_DURATION_OBJECTIVES_REL, getProgramObjectivesByProgramDurationId(programCohortId, progdurationObjectivesRels, themeDisplay.getLocale()));
			objectivesJson.put(OmsbProgramConstants.COMPETENCIES_REQUIRMENTS_REL, getSpecificObjectivesByProgramDurationId(programCohortId, competenciesRequirementsRels, themeDisplay.getLocale()));
		}
		
		objectiveDetailsArray.put(objectivesJson);
		resultJson.put("objectiveDetailsArray", objectiveDetailsArray);
		resultJson.put(CommonConstants.SUCCESS, true);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		resourceResponse.getWriter().write(resultJson.toString());
		_logger.debug("doServeResource ::: Response ::: " + resultJson.toString());

		_logger.info("doServeResource Exit ::: ");
	}

	public static List<String> getProgramObjectivesByProgramDurationId(long progDurationId, List<ProgdurationObjectivesRel> progdurationObjectivesRels, Locale locale) {
		
		if (Validator.isNull(progdurationObjectivesRels)) {
			progdurationObjectivesRels = OmsbProgramUtil.getProgdurationObjectivesListByProgDurationIdAndObjetiveType(progDurationId);			
		}
		
		return progdurationObjectivesRels.stream()
	            .map(progdurationObjectivesRel -> progdurationObjectivesRel.getObjectives(locale))
	            .collect(Collectors.toList());

	}
	
	public static Map<Long, List<String>> getSpecificObjectivesByProgramDurationId(long progDurationId, List<ProgdurationCompetenciesRequirementsRel> competenciesRequirementsRels, Locale locale) {
	    Map<Long, List<String>> competenciesRequirementsRelsMap = new LinkedHashMap<>();
	    
		if (Validator.isNull(competenciesRequirementsRels)) {
			competenciesRequirementsRels = OmsbProgramUtil.getCompetenciesRequirementsListByProgDurationIdAndCompetencyType(progDurationId);
		}
		
	    for (ProgdurationCompetenciesRequirementsRel rel : competenciesRequirementsRels) {
	        try {
	            CompetenciesMaster competenciesMaster = CompetenciesMasterLocalServiceUtil.getCompetenciesMaster(rel.getCompetenciesMasterId());
	            
	            long competencyId = competenciesMaster.getCompetenciesMasterId();
	            String requirement = rel.getRequirements(locale);
	            
	            competenciesRequirementsRelsMap.computeIfAbsent(competencyId, k -> new ArrayList<>()).add(requirement);
	        } catch (Exception e) {
	            _logger.error(e);
	        }
	    }
	    return competenciesRequirementsRelsMap;
	}	

	@Reference
	private CompetenciesMasterLocalService competenciesMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbObjectivesMVCResourceCommand.class.getName());
}
