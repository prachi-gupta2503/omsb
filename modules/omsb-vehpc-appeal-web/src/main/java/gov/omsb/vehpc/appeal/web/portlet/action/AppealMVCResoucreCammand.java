package gov.omsb.vehpc.appeal.web.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppeal;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyCertificate;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyDecisionLevel;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyDecisionLevelItems;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyRequest;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyRequestItems;
import gov.omsb.vehpc.appeal.dto.web.SearchDto;
import gov.omsb.vehpc.appeal.util.AppealUtil;
import gov.omsb.vehpc.appeal.web.constants.AppealConstants;
import gov.omsb.vehpc.appeal.web.constants.OmsbVehpcAppealWebPortletKeys;

@org.osgi.service.component.annotations.Component

(immediate = true, property = { "javax.portlet.name=" + OmsbVehpcAppealWebPortletKeys.OMSBVEHPCAPPEALWEB,
		"mvc.command.name=" + AppealConstants.VIEW_APPEAL_PERSON_LIST }, service = MVCResourceCommand.class)
public class AppealMVCResoucreCammand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_log.info("AppealMVCResoucreCammand doServeResource method started !");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String employer = ParamUtil.getString(resourceRequest, "employer");
			String level = ParamUtil.getString(resourceRequest, "level");
			String employee = ParamUtil.getString(resourceRequest, "employee");
			boolean hasEmployeeRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(), RoleNameConstants.EMPLOYEE);
			boolean hasEmployerRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(), RoleNameConstants.EMPLOYER);
			List<SearchDto> searchDtos = new ArrayList<>();
			_log.info("<<< EMPLOYER >>>>> " + employer + " <<<<< LEVEL >>>>> " + level + " <<<< EMPLOYEE >>>>> " + employee);
			if (employer.isEmpty() && level.isEmpty() && employee.isEmpty()) {
				searchDtos =appealUtil.getAllDecisionLevelData(themeDisplay, hasEmployerRole);  
			} else if (employer.isEmpty() && !level.isEmpty() && employee.isEmpty()) {
				searchDtos = getPersonDetailsByLevel(level, themeDisplay);
			} else if (!employer.isEmpty() && level.isEmpty()) {
				searchDtos = getPersonDetailsByEmployer(employer, themeDisplay, resourceRequest);
			} else if (!employer.isEmpty() && !level.isEmpty()) {
				searchDtos = searchByEmployerAndLevel(level, employer, themeDisplay, resourceRequest);
			} else if (level.isEmpty() && !employee.isEmpty()) {
				searchDtos = getPersonDetailsByEmployee(employee, themeDisplay);
			} else if (!level.isEmpty() && !employee.isEmpty()) {
				searchDtos = searchByEmployeeAndLevel(level, employee, themeDisplay);
			}
			
            searchDtos.sort(Comparator.comparing(SearchDto::getEquivalencyDecisionId).reversed());
			
			resourceRequest.setAttribute("searchDtos", searchDtos);
			resourceRequest.setAttribute("hasEmployeeRole", hasEmployeeRole);
			resourceRequest.setAttribute("hasEmployerRole", hasEmployerRole);
			resourceRequest.setAttribute("appealStatusColur", appealUtil.getColorMap() );
			PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
					.getRequestDispatcher("/jsps/appeal/search-employer-data.jsp");
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}
	
	public List<SearchDto> searchByEmployeeAndLevel(String level, String employee, ThemeDisplay themeDisplay) {
		Set<SearchDto> list = new HashSet<>();
		list.addAll(getPersonDetailsByLevelFromEmployeeList(getPersonDetailsByEmployee(employee, themeDisplay), level, themeDisplay));
		return new ArrayList<>(list);
	}
	
	/**
	 * 
	 * @param level
	 * @param themeDisplay
	 * @param request
	 * @param response
	 * @return this method return the json response of the person details.
	 */
	public List<SearchDto> getPersonDetailsByLevelFromEmployeeList(List<SearchDto> employeeList, String requestLevel, ThemeDisplay themeDisplay) {
		_log.info("get DetailsByLevel method started");
		List<SearchDto> searchDtos = new ArrayList<>();
		for(SearchDto searchDto : employeeList) {
			try {
				String equivalencyDecisionLevelURL = themeDisplay.getPortalURL()
						+ AppealConstants.DECISION_URL.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(themeDisplay.getScopeGroupId()))
						+ StringPool.QUESTION + "filter=equivalencyLevelId"
						+ URLEncoder.encode(AppealConstants.EQUALS + "'" + requestLevel + "' and eqRequestId eq "+searchDto.geteQRequestedId(), AppealConstants.UTF_8);
				String equivalencyLevelResponse = commonApi.getData(equivalencyDecisionLevelURL);
				_log.info("equivalencyLevelResponse ??" + equivalencyLevelResponse);
				//searchDtos = getEmployerDecisionLevelItems(equivalencyLevelResponse, themeDisplay, null);
				
				EquivalencyDecisionLevelItems decisionLevelItems = CustomObjectMapperUtil.readValue(equivalencyLevelResponse, EquivalencyDecisionLevelItems.class);
				if (Validator.isNotNull(decisionLevelItems) && Validator.isNotNull(decisionLevelItems.getItems()) && !decisionLevelItems.getItems().isEmpty()) {
					_log.info("decisionLevelItems size ?? " + decisionLevelItems.getItems().size());
					for (EquivalencyDecisionLevel level : decisionLevelItems.getItems()) {
						EquivalencyRequest eRequest = appealUtil.getEquivalencyRequestById(level.getEqRequestId(), themeDisplay);
						String fileName = appealUtil.getDocumentfileName(themeDisplay, level.getDocumentInfoId());
						String employerName = appealUtil.getEmployerNameByEqRequest(eRequest, themeDisplay);
						String employeeName = appealUtil.getEmployeeNameByEqRequest(eRequest, themeDisplay);
						_log.info("employeeName is ?? " + employeeName + "  Employer Name is ?? " + employerName );
						boolean isExist = appealUtil.isAppealExist(level.getId(), themeDisplay);
						EquivalencyAppeal appeal = appealUtil.getAppealByEqDecisionLevelId(themeDisplay, level.getId());
						String status = "";
						if (Validator.isNotNull(appeal)) {
							status = appealUtil.getStatus(appeal.getStatusID(), themeDisplay);
						}
						EquivalencyCertificate certificate = appealUtil.getEquivalencyCertificateByEqRequest(themeDisplay, eRequest);
						SearchDto search = appealUtil.addDetails(fileName, employerName, level, employeeName, isExist, certificate, status, searchDto.geteQRequestedId());
						searchDtos.add(search);
					}
				}
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}
		return searchDtos;
	}
	
	public List<SearchDto> searchByEmployerAndLevel(String level, String employer, ThemeDisplay themeDisplay, ResourceRequest request) {
		List<SearchDto> levelList = getPersonDetailsByLevel(level, themeDisplay);
		List<SearchDto> employerList = getPersonDetailsByEmployer(employer, themeDisplay, request);
		Set<SearchDto> list = new HashSet<>();
		list.addAll(levelList);
		list.addAll(employerList);
		return new ArrayList<>(list);
	}
	/**
	 * 
	 * @param level
	 * @param themeDisplay
	 * @param request
	 * @param response
	 * @return this method return the json response of the person details.
	 */
	public List<SearchDto> getPersonDetailsByLevel(String requestLevel, ThemeDisplay themeDisplay) {
		_log.info("get DetailsByLevel method started");
		List<SearchDto> searchDtos = new ArrayList<>();
		String groupId = String.valueOf(themeDisplay.getScopeGroupId());
		try {
			String equivalencyDecisionLevelURL = themeDisplay.getPortalURL()
					+ AppealConstants.DECISION_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId)
					+ StringPool.QUESTION + "filter=equivalencyLevelId"
					+ URLEncoder.encode(AppealConstants.EQUALS + "'" + requestLevel + "'", AppealConstants.UTF_8);
			String equivalencyLevelResponse = commonApi.getData(equivalencyDecisionLevelURL);
			_log.info("equivalencyLevelResponse ??" + equivalencyLevelResponse);
			//searchDtos = getEmployerDecisionLevelItems(equivalencyLevelResponse, themeDisplay, null);
			
			EquivalencyDecisionLevelItems decisionLevelItems = CustomObjectMapperUtil.readValue(equivalencyLevelResponse, EquivalencyDecisionLevelItems.class);
			if (Validator.isNotNull(decisionLevelItems) && Validator.isNotNull(decisionLevelItems.getItems()) && !decisionLevelItems.getItems().isEmpty()) {
				_log.info("decisionLevelItems size ?? " + decisionLevelItems.getItems().size());
				for (EquivalencyDecisionLevel level : decisionLevelItems.getItems()) {
					EquivalencyRequest eRequest = appealUtil.getEquivalencyRequestById(level.getEqRequestId(), themeDisplay);
					String fileName = appealUtil.getDocumentfileName(themeDisplay, level.getDocumentInfoId());
					String employerName = appealUtil.getEmployerNameByEqRequest(eRequest, themeDisplay);
					String employeeName = appealUtil.getEmployeeNameByEqRequest(eRequest, themeDisplay);
					_log.info("employeeName is ?? " + employeeName + "  Employer Name is ?? " + employerName );
					boolean isExist = appealUtil.isAppealExist(level.getId(), themeDisplay);
					EquivalencyAppeal appeal = appealUtil.getAppealByEqDecisionLevelId(themeDisplay, level.getId());
					String status = "";
					if (Validator.isNotNull(appeal)) {
						status = appealUtil.getStatus(appeal.getStatusID(), themeDisplay);
					}
					EquivalencyCertificate certificate = appealUtil.getEquivalencyCertificateByEqRequest(themeDisplay, eRequest);
					SearchDto search = appealUtil.addDetails(fileName, employerName, level, employeeName, isExist, certificate, status, level.getEqRequestId());
					searchDtos.add(search);
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		return searchDtos;
	}


	/**
	 * 
	 * @param employer
	 * @param themeDisplay
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 * @throws PortalException
	 * @return this method return the json response of the person details(employer).
	 */
	public List<SearchDto> getPersonDetailsByEmployer(String employer, ThemeDisplay themeDisplay, ResourceRequest request){
		_log.info("getPersonDetailsByEmployer method started and employer value is ?? "  + employer);
		List<SearchDto> searchDtos = new ArrayList<>();
		String groupId = String.valueOf(themeDisplay.getScopeGroupId());
		try {
			List<User> userData = appealUtil.getUserByDynamicQuery(employer);
			for (User user : userData) {
				List<String> userRoleNames = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
				_log.info("user Id ?? " + user.getUserId());
				_log.info("user roleName ?? " + userRoleNames.toString());
				if (userRoleNames.contains(RoleNameConstants.EMPLOYER)) {
					String equivalencyRequestURL1 = themeDisplay.getPortalURL()
							+ AppealConstants.EQUIVALENCY_REQUESTS_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId)
							+ StringPool.QUESTION + "search=" + user.getUserId();
					String equivalencyRequestResponse = commonApi.getData(equivalencyRequestURL1);
					
					if (equivalencyRequestResponse.contains("employerUserID")) {
						_log.info("equivalencyRequestResponse ?? " + equivalencyRequestResponse);
						EquivalencyRequestItems equivalencyRequestItems = CustomObjectMapperUtil.readValue(equivalencyRequestResponse, EquivalencyRequestItems.class);
						if (Validator.isNotNull(equivalencyRequestItems) && Validator.isNotNull(equivalencyRequestItems.getItems()) && !equivalencyRequestItems.getItems().isEmpty()) {
							searchDtos.addAll(equivalencySearchDTO(themeDisplay, equivalencyRequestItems, groupId));
						}
					}
					
				}
			}
			request.setAttribute("searchDtos", searchDtos);
			_log.info("getPersonDetailsByEmployer method ended");
			
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		return searchDtos;
	}
	
	private List<SearchDto> equivalencySearchDTO(ThemeDisplay themeDisplay, EquivalencyRequestItems equivalencyRequestItems, String groupId) {
		List<SearchDto> searchDtos = new ArrayList<>();
		for (EquivalencyRequest eRequest :equivalencyRequestItems.getItems()) {
			_log.info("eRequest ID  ?? " + eRequest.getId());
			String equivalencyDecisionLevellURL = themeDisplay.getPortalURL()
					+ AppealConstants.DECISION_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId)
					+ StringPool.QUESTION + "search=" + eRequest.getId();
			String decisionLevelResponse = commonApi.getData(equivalencyDecisionLevellURL);
			_log.info("decisionLevelResponse ?? " + decisionLevelResponse);
			//searchDtos = getEmployerDecisionLevelItems(decisionLevelResponse, themeDisplay, eRequest);
			
			EquivalencyDecisionLevelItems decisionLevelItems = CustomObjectMapperUtil.readValue(decisionLevelResponse, EquivalencyDecisionLevelItems.class);
			if (Validator.isNotNull(decisionLevelItems) && Validator.isNotNull(decisionLevelItems.getItems()) && !decisionLevelItems.getItems().isEmpty()) {
				_log.info("decisionLevelItems size ?? " + decisionLevelItems.getItems().size());
				for (EquivalencyDecisionLevel level : decisionLevelItems.getItems()) {
					if (Validator.isNull(eRequest)) {
						eRequest = appealUtil.getEquivalencyRequestById(level.getEqRequestId(), themeDisplay);
					}
					String fileName = appealUtil.getDocumentfileName(themeDisplay, level.getDocumentInfoId());
					String employerName = appealUtil.getEmployerNameByEqRequest(eRequest, themeDisplay);
					String employeeName = appealUtil.getEmployeeNameByEqRequest(eRequest, themeDisplay);
					_log.info("employeeName is ?? " + employeeName + "  Employer Name is ?? " + employerName );
					boolean isExist = appealUtil.isAppealExist(level.getId(), themeDisplay);
					EquivalencyAppeal appeal = appealUtil.getAppealByEqDecisionLevelId(themeDisplay, level.getId());
					String status = "";
					if (Validator.isNotNull(appeal)) {
						status = appealUtil.getStatus(appeal.getStatusID(), themeDisplay);
					}
					EquivalencyCertificate certificate = appealUtil.getEquivalencyCertificateByEqRequest(themeDisplay, eRequest);
					SearchDto search = appealUtil.addDetails(fileName, employerName, level, employeeName, isExist, certificate, status, eRequest.getId());
					searchDtos.add(search);
				}
			}
		}
		return searchDtos;
	}
	
	private List<SearchDto> getEmployerDecisionLevelItems(String decisionLevelResponse, ThemeDisplay themeDisplay, EquivalencyRequest eRequest) {
		List<SearchDto> searchDtos = new ArrayList<>();
		EquivalencyDecisionLevelItems decisionLevelItems = CustomObjectMapperUtil.readValue(decisionLevelResponse, EquivalencyDecisionLevelItems.class);
		if (Validator.isNotNull(decisionLevelItems) && Validator.isNotNull(decisionLevelItems.getItems()) && !decisionLevelItems.getItems().isEmpty()) {
			_log.info("decisionLevelItems size ?? " + decisionLevelItems.getItems().size());
			for (EquivalencyDecisionLevel level : decisionLevelItems.getItems()) {
				if (Validator.isNull(eRequest)) {
					eRequest = appealUtil.getEquivalencyRequestById(level.getEqRequestId(), themeDisplay);
				}
				String fileName = appealUtil.getDocumentfileName(themeDisplay, level.getDocumentInfoId());
				String employerName = appealUtil.getEmployerNameByEqRequest(eRequest, themeDisplay);
				String employeeName = appealUtil.getEmployeeNameByEqRequest(eRequest, themeDisplay);
				_log.info("employeeName is ?? " + employeeName + "  Employer Name is ?? " + employerName );
				boolean isExist = appealUtil.isAppealExist(level.getId(), themeDisplay);
				EquivalencyAppeal appeal = appealUtil.getAppealByEqDecisionLevelId(themeDisplay, level.getId());
				String status = "";
				if (Validator.isNotNull(appeal)) {
					status = appealUtil.getStatus(appeal.getStatusID(), themeDisplay);
				}
				EquivalencyCertificate certificate = appealUtil.getEquivalencyCertificateByEqRequest(themeDisplay, eRequest);
				SearchDto search = appealUtil.addDetails(fileName, employerName, level, employeeName, isExist, certificate, status, eRequest.getId());
				searchDtos.add(search);
			}
		}
		return searchDtos;
	}
		
	public List<SearchDto> getPersonDetailsByEmployee(String employee, ThemeDisplay themeDisplay) {
		_log.info("getPersonDetailsByEmployee method started getPersonDetailsByEmployee");
		_log.info("employee "+employee);
		List<SearchDto> searchDtos = new ArrayList<>();
		String groupId = String.valueOf(themeDisplay.getScopeGroupId());
		try {
			String personalURL = themeDisplay.getPortalURL() + LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL2 + groupId + StringPool.QUESTION + "search="+ employee; 
			String personalResponse = commonApi.getData(personalURL);
			_log.info("personalResponse ?? " + personalResponse);
			PersonalDetailItem personalItems = CustomObjectMapperUtil.readValue(personalResponse, PersonalDetailItem.class);
			if (Validator.isNotNull(personalItems) && Validator.isNotNull(personalItems.getItems()) && personalItems.getItems().size()>0) {
				String equivalencyRequestURL = themeDisplay.getPortalURL()
						+ AppealConstants.EQUIVALENCY_REQUESTS_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId)
						+ StringPool.QUESTION + "search="+personalItems.getItems().get(0).getPersonId();
				String equivalencyResponse = commonApi.getData(equivalencyRequestURL);
				EquivalencyRequestItems equivalencyItems = CustomObjectMapperUtil.readValue(equivalencyResponse, EquivalencyRequestItems.class);
				if (Validator.isNotNull(equivalencyItems) && Validator.isNotNull(equivalencyItems.getItems()) && !equivalencyItems.getItems().isEmpty()) {
					searchDtos.addAll(equivalencySearchDTO(themeDisplay, equivalencyItems, groupId));
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		return searchDtos;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(AppealMVCResoucreCammand.class);
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
	
	@Reference(unbind = "_")
	private UserLocalService userLocalService;
	
	@Reference(unbind = "_")
	private AppealUtil appealUtil;
}