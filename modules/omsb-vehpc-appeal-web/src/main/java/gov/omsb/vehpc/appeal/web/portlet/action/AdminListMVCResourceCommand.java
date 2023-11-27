package gov.omsb.vehpc.appeal.web.portlet.action;
import com.liferay.petra.string.StringPool;
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

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
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
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppeal;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealItems;
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
		"mvc.command.name=" + AppealConstants.VIEW_APPEAL_ADMIN_LIST }, service = MVCResourceCommand.class)

public class AdminListMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_log.info("DO SERVE RESOURCE METHOD GETS CALLED 1111111111111111111111111 :::::::::::::::::::::::::::");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String employer = ParamUtil.getString(resourceRequest, "employer");
		String employee = ParamUtil.getString(resourceRequest, "employee");
		String level = ParamUtil.getString(resourceRequest, "level");
		_log.info(" EMPLOYER   :::  " + employer + " EMPLOYEE   :::  " + employee	+ " LEVEL  :::  " + level);
		Set<SearchDto> adminSearchDtos = new HashSet<>();
		if (!employee.isEmpty() && employer.isEmpty() && level.isEmpty()) {
			adminSearchDtos = searchEmployee(employee, themeDisplay);
		} else if (employee.isEmpty() && !employer.isEmpty() && level.isEmpty()) {
			adminSearchDtos = searchEmployer(employer, themeDisplay);
		} else if (employee.isEmpty() && employer.isEmpty() && !level.isEmpty()) {
			adminSearchDtos = getPersonDetailsByLevel(level, themeDisplay);
		} else if (!employee.isEmpty() && employer.isEmpty() && !level.isEmpty()) {
			adminSearchDtos = searchDetailsByEmployeeAndLevel(employee, themeDisplay, level);
		} else if (!employee.isEmpty() && !employer.isEmpty() && !level.isEmpty()) {
			adminSearchDtos = searchDetailsByEmployeeEmployerAndLevel(employee, employer, themeDisplay, level);
		}  else if (!employee.isEmpty() && !employer.isEmpty() && level.isEmpty()) {
			adminSearchDtos = searchDetailsByEmployeeAndEmployer(employee, employer, themeDisplay);
		}  else if (employee.isEmpty() && !employer.isEmpty() && !level.isEmpty()) {
			adminSearchDtos = searchDetailsByEmployerAndLevel(employer, themeDisplay, level);
		}  else if (employee.isEmpty() && employer.isEmpty() && level.isEmpty()) {
			adminSearchDtos = appealUtil.getAllData(themeDisplay);
		}
		List<SearchDto> searchList = new ArrayList<>(adminSearchDtos);
		Comparator<SearchDto> comparator = (c1, c2) -> { 
        	return Long.compare(c1.getId(),c1.getId()); 
		};
		searchList.sort(Comparator.comparing(SearchDto::getId).reversed());
		boolean hasVehpcEmployerRole = commonApi.checkLoggedInUserByRoleName(RoleNameConstants.EMPLOYER, themeDisplay.getUserId());
		boolean hasVehpcEmployeeRole = commonApi.checkLoggedInUserByRoleName(RoleNameConstants.EMPLOYEE, themeDisplay.getUserId());
		boolean hasVehpcCommitteeRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),RoleNameConstants.VEHPC_COMMITTEE);
		boolean hasExecutePresidentRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),RoleNameConstants.EXECUTIVE_PRESIDENT);
		boolean hasVehpcCAdminRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(), RoleNameConstants.VEHPC_ADMIN);
		resourceRequest.setAttribute("hasVehpcCommitteeRole", hasVehpcCommitteeRole);
		resourceRequest.setAttribute("hasExecutePresidentRole", hasExecutePresidentRole);
		resourceRequest.setAttribute("hasVehpcCAdminRole", hasVehpcCAdminRole);
		resourceRequest.setAttribute("hasVehpcEmployerRole", hasVehpcEmployerRole);
		resourceRequest.setAttribute("hasVehpcEmployeeRole", hasVehpcEmployeeRole);
		resourceRequest.setAttribute("adminSearchDtos", searchList);
		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
				.getRequestDispatcher("/jsps/appeal/admin-list.jsp");
		dispatcher.include(resourceRequest, resourceResponse);
		_log.info("doServeResource method ended !");
	}
	
//	public Set<SearchDto> getAllData(ThemeDisplay themeDisplay) {
//		String response = commonApi.getData(themeDisplay.getPortalURL() + AppealConstants.EQ_APPEAL_URL
//				+ "scopes/" + themeDisplay.getScopeGroupId());
//		EquivalencyAppealItems appealItems = CustomObjectMapperUtil.readValue(response, EquivalencyAppealItems.class);
//		_log.info("descisionItem size ??" + appealItems.getItems().size());
//		Set<SearchDto> searchDTO = new HashSet<>();
//		if (Validator.isNotNull(appealItems) && Validator.isNotNull(appealItems.getItems()) && !appealItems.getItems().isEmpty()) {
//			for (EquivalencyAppeal appeal : appealItems.getItems()) {
//				EquivalencyRequest eqRequest = appealUtil.getEquivalencyRequestById(appeal.geteQRequestedId(), themeDisplay);
//				if (Validator.isNotNull(eqRequest)) {
//					String employeeName = appealUtil.getEmployeeNameByEqRequest(eqRequest, themeDisplay);
//					String employerName = appealUtil.getEmployerNameByEqRequest(eqRequest, themeDisplay);
//					EquivalencyDecisionLevel level = appealUtil.getEqDecisionLevelByDecisionId(appeal.geteQDecisionId(), themeDisplay);
//					String fileName = appealUtil.getDocumentfileName(themeDisplay, level.getDocumentInfoId());
//					EquivalencyCertificate certificate = appealUtil.getEquivalencyCertificateByEqRequest(themeDisplay, eqRequest);
//					String status = "";
//					if (Validator.isNotNull(appeal)) {
//						status = appealUtil.getStatus(appeal.getStatusID(), themeDisplay);
//						appealUtil.getWorkflowTransitionNames(themeDisplay, Long.parseLong(appeal.getId()), appeal);
//					}
//					SearchDto dto = appealUtil.addDetails(fileName, employerName, level, employeeName, true, certificate, status);
//					dto = setAdditionalSearchData(dto, appeal);
//					searchDTO.add(dto);
//				}
//				
//			}
//		}
//		return searchDTO;
//	}
	
	
	
	public Set<SearchDto> searchDetailsByEmployeeAndEmployer(String employee, String employer, ThemeDisplay themeDisplay){
		Set<SearchDto> employerList = searchEmployer(employer, themeDisplay);
		Set<SearchDto> employeeList = searchEmployee(employee, themeDisplay);
		employeeList.addAll(employerList);
		return employeeList;
	}
	
	public Set<SearchDto> searchDetailsByEmployeeEmployerAndLevel(String employee, String employer, ThemeDisplay themeDisplay, String level) {
		Set<SearchDto> employeeAndLevelList = searchDetailsByEmployeeAndLevel(employee, themeDisplay, level);
		Set<SearchDto> employerList = searchEmployer(employer, themeDisplay);
		employeeAndLevelList.addAll(employerList);
		return employeeAndLevelList;
	}
	
	public Set<SearchDto> searchDetailsByEmployeeAndLevel(String employee, ThemeDisplay themeDisplay, String level){
		Set<SearchDto> employeeList = searchEmployee(employee, themeDisplay);
		Set<SearchDto> levelList = getPersonDetailsByLevel(level, themeDisplay);
		levelList.addAll(employeeList);
		return levelList;
	}
	
	public Set<SearchDto> searchDetailsByEmployerAndLevel(String employer, ThemeDisplay themeDisplay, String level){
		Set<SearchDto> employerList = searchEmployer(employer, themeDisplay);
		Set<SearchDto> levelList = getPersonDetailsByLevel(level, themeDisplay);
		employerList.addAll(levelList);
		return employerList;
		
	}
	

	public Set<SearchDto> searchEmployee(String employee, ThemeDisplay themeDisplay) {
		String groupId = String.valueOf(themeDisplay.getScopeGroupId());
		Set<SearchDto> adminSearchDtos = new HashSet<>();
		try {
			String personalDetailsURL = themeDisplay.getPortalURL()
					+ AppealConstants.PERSONAL_DETAILS_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId)
					+ StringPool.QUESTION + "search="+ employee; 
			String personalDetailsResponse = commonApi.getData(personalDetailsURL);
			adminSearchDtos = searchEquivalencyRequest(personalDetailsResponse, themeDisplay);
			
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return adminSearchDtos;
	}
	
	private Set<SearchDto> searchEquivalencyRequest(String personalDetailsResponse, ThemeDisplay themeDisplay) {
		Set<SearchDto> searchDto = new HashSet<>();
		PersonalDetailItem personalItems = CustomObjectMapperUtil.readValue(personalDetailsResponse, PersonalDetailItem.class);
		if (Validator.isNotNull(personalItems) && Validator.isNotNull(personalItems.getItems()) && !personalItems.getItems().isEmpty()) {
			for (PersonalDetail personal : personalItems.getItems()) {
				String equivalencyRequestURL = themeDisplay.getPortalURL()
						+ AppealConstants.EQUIVALENCY_REQUESTS_URL.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(themeDisplay.getScopeGroupId()))
						+ StringPool.QUESTION + "search="+ personal.getPersonId();
				String equivalencyResponse = commonApi.getData(equivalencyRequestURL);
				EquivalencyRequestItems equivalencyItems = CustomObjectMapperUtil.readValue(equivalencyResponse, EquivalencyRequestItems.class);
				if (Validator.isNotNull(equivalencyItems) && Validator.isNotNull(equivalencyItems.getItems()) && !equivalencyItems.getItems().isEmpty()) {
					for (EquivalencyRequest eqRequest: equivalencyItems.getItems()) {
						Set<SearchDto> adminSearchDto = searchAppealByEqRequestId(themeDisplay, eqRequest);
						searchDto.addAll(adminSearchDto);
					}
				}
			}
		}
		return searchDto;
	}
	
	private Set<SearchDto> searchAppealByEqRequestId(ThemeDisplay themeDisplay, EquivalencyRequest eqRequest)  {
		Set<SearchDto> searchDto = new HashSet<>();
		String equivalencyAppealURL = themeDisplay.getPortalURL()
				+ AppealConstants.EQUIVALENCY_APPEAL.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.QUESTION + "filter=eQRequestedId" 
				+ URLEncoder.encode(AppealConstants.EQUALS + eqRequest.getId(), StandardCharsets.UTF_8);
		String equivalencyLevelResponse = commonApi.getData(equivalencyAppealURL);
		EquivalencyAppealItems eqAppealItems = CustomObjectMapperUtil.readValue(equivalencyLevelResponse, EquivalencyAppealItems.class);
		if (Validator.isNotNull(eqAppealItems) && Validator.isNotNull(eqAppealItems.getItems()) && !eqAppealItems.getItems().isEmpty()) {
			for (EquivalencyAppeal appeal : eqAppealItems.getItems()) {
				EquivalencyDecisionLevel decisionLevel = appealUtil.getEqDecisionLevelByDecisionId(appeal.geteQDecisionId(), themeDisplay);
				appealUtil.getWorkflowTransitionNames(themeDisplay, Long.parseLong(appeal.getId()), appeal);
				SearchDto dto = setSearchData(eqRequest, themeDisplay, appeal, decisionLevel);
				dto = setAdditionalSearchData(dto, appeal);
				searchDto.add(dto);
			}
		}
		return searchDto;
	}
	
	
	

	private Set<SearchDto> searchEmployer(String employer, ThemeDisplay themeDisplay) {
		_log.info("searchEmployer Method Started");
		String groupId = String.valueOf(themeDisplay.getScopeGroupId());
		Set<SearchDto> adminSearchDtos = new HashSet<>();
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
					adminSearchDtos.addAll(searchEmployerAppeals(equivalencyRequestResponse, themeDisplay));
				}
			}
		_log.info("searchEmployer Method Ended");
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return adminSearchDtos;
	}
	
	private List<SearchDto> searchEmployerAppeals(String equivalencyRequestResponse, ThemeDisplay themeDisplay) {
		List<SearchDto> adminSearchDtos = new ArrayList<>();
		if (equivalencyRequestResponse.contains("employerUserID")) {
			_log.info("equivalencyRequestResponse ?? " + equivalencyRequestResponse);
			EquivalencyRequestItems eqRequestItems = CustomObjectMapperUtil.readValue(equivalencyRequestResponse, EquivalencyRequestItems.class);
			if (Validator.isNotNull(eqRequestItems) && Validator.isNotNull(eqRequestItems.getItems()) && !eqRequestItems.getItems().isEmpty()) {
				for (EquivalencyRequest eqRequest: eqRequestItems.getItems()) {
					adminSearchDtos.addAll(searchAppealByEqRequestId(themeDisplay, eqRequest));
				}
			}
		}
		return adminSearchDtos;
	}

	private Set<SearchDto> getPersonDetailsByLevel(String level, ThemeDisplay themeDisplay) {
		_log.info("getPersonDetailsByLevel Method Started");
		Set<SearchDto> searchDTO = new HashSet<>();
		String groupId = String.valueOf(themeDisplay.getScopeGroupId());
		try {
			String equivalencyDecisionURL = themeDisplay.getPortalURL()
					+ AppealConstants.DECISION_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId)
					+ StringPool.QUESTION + "filter=equivalencyLevelId"
					+ URLEncoder.encode(AppealConstants.EQUALS + "'" + level + "'", StandardCharsets.UTF_8);
			String equivalencyDecisionResponse = commonApi.getData(equivalencyDecisionURL);
			EquivalencyDecisionLevelItems eqDecisionLevelItems = CustomObjectMapperUtil
					.readValue(equivalencyDecisionResponse, EquivalencyDecisionLevelItems.class);
			
			if (Validator.isNotNull(eqDecisionLevelItems) && Validator.isNotNull(eqDecisionLevelItems.getItems()) && !eqDecisionLevelItems.getItems().isEmpty()) {
				for (EquivalencyDecisionLevel decisionLevel : eqDecisionLevelItems.getItems()) {
					EquivalencyRequest eqRequest =  appealUtil.getEquivalencyRequestById(decisionLevel.getEqRequestId(), themeDisplay);
					EquivalencyAppeal appeal = appealUtil.getAppealByEqDecisionLevelId(themeDisplay, decisionLevel.getId());
					appealUtil.getWorkflowTransitionNames(themeDisplay, Long.parseLong(appeal.getId()), appeal);
					SearchDto dto = setSearchData(eqRequest, themeDisplay, appeal, decisionLevel);
					dto = setAdditionalSearchData(dto, appeal);
					searchDTO.add(dto);
				}
			}
			_log.info("getPersonDetailsByLevel Method Ended ");
			
		} catch (Exception e) {
			_log.error(e.getMessage(),e );
		}
		_log.info("getPersonDetailsByLevel Method Ended size of dto ?? " + searchDTO.size());
		return searchDTO;
	}
	
	public SearchDto setSearchData(EquivalencyRequest eqRequest, ThemeDisplay themeDisplay, EquivalencyAppeal appeal, EquivalencyDecisionLevel  decisionLevel) {
		String employee = appealUtil.getEmployeeNameByEqRequest(eqRequest, themeDisplay);
		String employer = appealUtil.getEmployerNameByEqRequest(eqRequest, themeDisplay);
		String fileName = appealUtil.getDocumentfileName(themeDisplay, decisionLevel.getDocumentInfoId());
		EquivalencyCertificate certificate = appealUtil.getEquivalencyCertificateByEqRequest(themeDisplay, eqRequest);
		String status = "";
		
		if (Validator.isNotNull(appeal)) {
			status = appealUtil.getStatus(appeal.getStatusID(), themeDisplay);
		}
		return appealUtil.addDetails(fileName, employer, decisionLevel, employee, true, certificate, status, eqRequest.getId());
	}
	
	public SearchDto setAdditionalSearchData(SearchDto searchDTO, EquivalencyAppeal appeal) {
		_log.info("date ::::::::::: " + appeal.getDateCreated());
		searchDTO.setCreatedDate(commonApi.convertDate(appeal.getDateCreated(),new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT),
				new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD)));
		searchDTO.setWorkflowInstanceId(appeal.getWorkflowInstanceId());
		searchDTO.setWorkflowTaskId(appeal.getWorkflowTaskId());
		searchDTO.setTransitionNames(appeal.getTransitionNames());
		searchDTO.setAssignedToMe(appeal.isAssignedToMe());
		searchDTO.setId(Long.parseLong(appeal.getId()));
		return searchDTO;
	}

	private static final Log _log = LogFactoryUtil.getLog(AdminListMVCResourceCommand.class);
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
	@Reference(unbind = "_")
	private UserLocalService userLocalService;
	@Reference(unbind = "_")
	private AppealUtil appealUtil;
	

}
