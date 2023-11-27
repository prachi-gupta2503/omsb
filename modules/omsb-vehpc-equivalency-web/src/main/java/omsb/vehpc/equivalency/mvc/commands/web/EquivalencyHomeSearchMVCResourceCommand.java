package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.EquivalencyRequestStatusEnum;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import omsb.vehpc.equivalency.dto.web.EquivalencyDto;
import omsb.vehpc.equivalency.dto.web.EquivalencyDtoItem;
import omsb.vehpc.equivalency.dto.web.EquivalencyPassingData;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;
import omsb.vehpc.equivalency.workflow.web.JspTransitionWorkflowHandler;

/**
 * @author Shaik Ali
 */

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.EQUIVALENCY_SEARCH }, service = MVCResourceCommand.class)

public class EquivalencyHomeSearchMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest request, ResourceResponse response) throws Exception {

		searchEquivalency(request);

		PortletRequestDispatcher dispatcher = request.getPortletSession().getPortletContext()
				.getRequestDispatcher(OmsbVehpcEquivalencyWebPortletKeys.ADMIN_SEARCH_DATA_JSP);
		try {
			dispatcher.include(request, response);
		} catch (PortletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * To Search Equivalency requests by Employee name, Employer Name, Equivalency
	 * status and Creation Date
	 * 
	 * @param request
	 */
	private void searchEquivalency(ResourceRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		String employer = ParamUtil.getString(request, "employer");
		String employee = ParamUtil.getString(request, "employee");
		String status = ParamUtil.getString(request, "status");
		String createDate = ParamUtil.getString(request, "createDate");

		List<EquivalencyPassingData> equivalencyList = new ArrayList<>();

		try {
			String equivalencyRequestURL = themeDisplay.getPortalURL()
					+ LRObjectURL.EQUIVALENCY_REQUESTS_URL.replace(DataflowConstants.SCOPE_ID_VAR,
							String.valueOf(themeDisplay.getScopeGroupId()))
					+ StringPool.QUESTION + "sort=id:desc&" + "filter=";

			if (Validator.isNotNull(employer)) {
				equivalencyRequestURL = updateEquivalencyRequestURLWithEmployerFilter(employer, equivalencyRequestURL,
						themeDisplay, request);
			}

			if (Validator.isNotNull(employee)) {
				equivalencyRequestURL = updateEquivalencyRequestURLWithEmployeeFilter(employee, equivalencyRequestURL,
						themeDisplay, request);
			}
			if (Validator.isNotNull(status)) {
				equivalencyRequestURL = updateEquivalencyRequestURLWithStatusFilter(status, equivalencyRequestURL,
						themeDisplay, request);
			}

			if (equivalencyRequestURL.lastIndexOf("+and+") > 0) {
				equivalencyRequestURL = equivalencyRequestURL.substring(0, equivalencyRequestURL.lastIndexOf("+and+"));
			}
			LOGGER.info("equivalencyRequestURL:::::"+equivalencyRequestURL);
			String equivalencyRequestResponse = omsbCommonApi.getData(equivalencyRequestURL);
			LOGGER.info("equivalencyRequestResponse:::::"+equivalencyRequestResponse);
			EquivalencyDto equivalencyDto = CustomObjectMapperUtil.readValue(equivalencyRequestResponse,EquivalencyDto.class,new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT));
			
			if (Validator.isNotNull(equivalencyDto) && Validator.isNotNull(equivalencyDto.getItems())
					&& !(equivalencyDto.getItems().isEmpty())) {

				for (EquivalencyDtoItem equivalency : equivalencyDto.getItems()) {

					long personId = equivalency.getPersonId();

					// To Get Equivalency status
					String status2 = null;
					if (equivalency.getEquivalencyStatusId() > 0) {
						ListTypeEntry listTypeEntry = ListTypeEntryLocalServiceUtil
								.fetchListTypeEntry(equivalency.getEquivalencyStatusId());
						if(Validator.isNotNull(listTypeEntry)) {
							status2 = listTypeEntry.getName(themeDisplay.getLocale());
							status2 = status2.toLowerCase();
						}
					}

					// To get Employee Name
					String personDetailsURL = themeDisplay.getPortalURL()
							+ LRObjectURL.PERSONAL_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR,
									String.valueOf(themeDisplay.getScopeGroupId()))
							+ StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + personId,
									OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);

					String personDetailsResponse = omsbCommonApi.getData(personDetailsURL);
					EquivalencyDto personDetails = CustomObjectMapperUtil.readValue(personDetailsResponse,
							EquivalencyDto.class);
					String name = null;
					if (Validator.isNotNull(personDetails) && Validator.isNotNull(personDetails.getItems())
							&& !(personDetails.getItems().isEmpty())) {
						name = personDetails.getItems().get(0).getGivenNameAsPassport();
					}

					// To get Employer Name
					long employerUserID = equivalency.getEmployerUserID();
					User user;

					user = UserLocalServiceUtil.getUser(employerUserID);
					EquivalencyPassingData equivalencyPerson = null;

					equivalencyPerson = addHomeSearchDetails(themeDisplay, user.getFullName(), name, status2,
							equivalency.getDateCreated(), equivalency.getId());

					if (Validator.isNotNull(equivalencyPerson)) {
						equivalencyList.add(equivalencyPerson);
					}

				}

				if (Validator.isNotNull(createDate)) {
					equivalencyList = updateEquivalencyListByCreatedOnFilter(createDate, equivalencyList);
				}

			}
		} catch (PortalException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		request.setAttribute("equivalencyRequest", equivalencyList);
		boolean isEmployer = omsbCommonApi
				.checkLoggedInUserByRoleName(OmsbVehpcEquivalencyWebPortletKeys.EMPLOYER, themeDisplay.getUserId());
		request.setAttribute("isEmployer", isEmployer);
	}

	private List<EquivalencyPassingData> updateEquivalencyListByCreatedOnFilter(String createDate,
			List<EquivalencyPassingData> equivalencyList) {

		equivalencyList = equivalencyList.stream().filter(equivalency -> {
			try {
				String equivalencyCreatedOn = equivalency.getCreatedOn();
				String convertedDate = convertDate1(equivalencyCreatedOn);
				Date convertedDate1 = new SimpleDateFormat("dd-MM-yyyy").parse(convertedDate);

				String convertedSelDate = convertDate1(createDate);
				Date convertedSelDate1 = new SimpleDateFormat("dd-MM-yyyy").parse(convertedSelDate);

				int comparison = convertedSelDate1.compareTo(convertedDate1);
				if (comparison == 0) {
					return true;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

			return false;
		}).collect(Collectors.toList());

		return equivalencyList;

	}

	private String updateEquivalencyRequestURLWithStatusFilter(String status, String equivalencyRequestURL,
			ThemeDisplay themeDisplay, ResourceRequest request) {
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EQUIVALENCY_STATUS,
				status, themeDisplay.getCompanyId());
		long statusId = 0;

		if (Validator.isNotNull(entry)) {
			statusId = entry.getListTypeEntryId();
		}

		equivalencyRequestURL = equivalencyRequestURL + "(equivalencyStatusId" + "+eq+" + statusId;
		equivalencyRequestURL = equivalencyRequestURL + ")+and+";
		return equivalencyRequestURL;

	}

	private String updateEquivalencyRequestURLWithEmployeeFilter(String employee, String equivalencyRequestURL,
			ThemeDisplay themeDisplay, ResourceRequest request) {

		try {
			String personDetailsURL = themeDisplay.getPortalURL()
					+ LRObjectURL.PERSONAL_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR,
							String.valueOf(themeDisplay.getScopeGroupId()))
					+ StringPool.QUESTION + "filter=" + StringPool.OPEN_PARENTHESIS + "givenNameAsPassport"
					+ URLEncoder.encode(
							" eq " + "'" + employee + "'" + StringPool.CLOSE_PARENTHESIS + " or "
									+ StringPool.OPEN_PARENTHESIS + "applicantSurname eq " + "'" + employee + "'"
									+ StringPool.CLOSE_PARENTHESIS,
							OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);

			String personDetailsResponse = omsbCommonApi.getData(personDetailsURL);
			EquivalencyDto personDetails = CustomObjectMapperUtil.readValue(personDetailsResponse,
					EquivalencyDto.class);

			if (Validator.isNotNull(personDetails) && Validator.isNotNull(personDetails.getItems())
					&& !(personDetails.getItems().isEmpty())) {
				equivalencyRequestURL = equivalencyRequestURL + StringPool.OPEN_PARENTHESIS;
				for (EquivalencyDtoItem personDetail : personDetails.getItems()) {
					long personId = personDetail.getPersonId();
					equivalencyRequestURL = equivalencyRequestURL + "personId" + "+eq+" + personId + "+or+";
				}
			}
			if (equivalencyRequestURL.lastIndexOf("+or+") > 0) {
				equivalencyRequestURL = equivalencyRequestURL.substring(0, equivalencyRequestURL.lastIndexOf("+or+"));
			}
			equivalencyRequestURL = equivalencyRequestURL + ")+and+";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return equivalencyRequestURL;

	}

	private String updateEquivalencyRequestURLWithEmployerFilter(String employer, String equivalencyRequestURL,
			ThemeDisplay themeDisplay, ResourceRequest request) {
		String fullNameArray[] = employer.split(" ");

		DynamicQuery dynamicQuery = UserLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.like("firstName", "%" + fullNameArray[0] + "%"));
		dynamicQuery.add(RestrictionsFactoryUtil.like("lastName", "%" + fullNameArray[1] + "%"));
		List<User> userData = UserLocalServiceUtil.dynamicQuery(dynamicQuery);

		if (Validator.isNotNull(userData) && userData.size() > 0) {
			boolean isFirstUser = true;
			for (User user : userData) {

				long userId = user.getUserId();
				boolean isEmployer = omsbCommonApi
						.checkLoggedInUserByRoleName(OmsbVehpcEquivalencyWebPortletKeys.EMPLOYER, userId);
				if (isEmployer) {
					if (isFirstUser) {
						equivalencyRequestURL = equivalencyRequestURL + StringPool.OPEN_PARENTHESIS;
						isFirstUser = false;
					}
					equivalencyRequestURL = equivalencyRequestURL + "employerUserID" + "+eq+" + userId + "+or+";
				}

			}
		}
		if (equivalencyRequestURL.lastIndexOf("+or+") > 0) {
			equivalencyRequestURL = equivalencyRequestURL.substring(0, equivalencyRequestURL.lastIndexOf("+or+"));
		}

		equivalencyRequestURL = equivalencyRequestURL + ")+and+";
		return equivalencyRequestURL;
	}

	private String getObjectClassName(long companyId) {
		try {
			ObjectDefinition definition = objectDefinitionService
					.getObjectDefinitionByExternalReferenceCode("OB_EUIVALENCY_REQUEST_ERC", companyId);
			if (Validator.isNotNull(definition)) {
				return definition.getClassName();
			}
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	private String getFinalStatusValue(String key, ThemeDisplay themeDisplay) {
		ListTypeEntry statusListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey
				(LRPicklistConstants.PL_EQUIVALENCY_STATUS, key, themeDisplay.getCompanyId());
		if (Validator.isNotNull(statusListTypeEntry)) {
			LOGGER.info("Name ?? " + statusListTypeEntry.getName(themeDisplay.getLocale()));
			return statusListTypeEntry.getName(themeDisplay.getLocale());
		}
		return "";
	}
	
	private String getFinalStatus(boolean isEmployer, boolean isCommittee, boolean isAdmin, String status) {
        LOGGER.info("isEmployer ?? " + isEmployer + "  isCommittee  ?? " + isCommittee + "  is Admin ?? " + isAdmin + " status ?? " + status);
        StringBuilder finalStatus = new StringBuilder();
        if (isAdmin && (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.CREATED.getText()) || status.equalsIgnoreCase(EquivalencyRequestStatusEnum.EQUATED.getText()))) {
            finalStatus.append(EquivalencyRequestStatusEnum.RECEIVED.getText());
        } else if (isAdmin && !status.equalsIgnoreCase(EquivalencyRequestStatusEnum.CREATED.getText()) && !status.equalsIgnoreCase(EquivalencyRequestStatusEnum.COMPLETED.getText())) {
            finalStatus.append(EquivalencyRequestStatusEnum.INPROGRESS.getText());
        } else if (isCommittee && status.equalsIgnoreCase(EquivalencyRequestStatusEnum.INITIATED.getText())) {
            finalStatus.append(EquivalencyRequestStatusEnum.RECEIVED.getText());
        } else if (isCommittee && !status.equalsIgnoreCase(EquivalencyRequestStatusEnum.INITIATED.getText()) && !status.equalsIgnoreCase(EquivalencyRequestStatusEnum.COMPLETED.getText())) {
            finalStatus.append(EquivalencyRequestStatusEnum.INPROGRESS.getText());
        } else if (isEmployer && status.equalsIgnoreCase(EquivalencyRequestStatusEnum.INSUFFICIENT.getText())) {
            finalStatus.append(EquivalencyRequestStatusEnum.INSUFFICIENT.getText());
        } else if (isEmployer && !status.equalsIgnoreCase(EquivalencyRequestStatusEnum.COMPLETED.getText()) && !status.equalsIgnoreCase(EquivalencyRequestStatusEnum.INSUFFICIENT.getText())) {
            finalStatus.append(EquivalencyRequestStatusEnum.INPROGRESS.getText());
        } else {
        	finalStatus.append(EquivalencyRequestStatusEnum.getStatusByLabel(status).getText());
        }

        LOGGER.info("finalStatus ?? " + finalStatus);
        return finalStatus.toString();
    }

	public EquivalencyPassingData addHomeSearchDetails(ThemeDisplay themeDisplay, String employer, String employee,
			String status, Date createdOn, long id) {
		EquivalencyPassingData equivalencyDto = new EquivalencyPassingData();
		equivalencyDto.setEmployer(employer);
		equivalencyDto.setEmployee(employee);

		if (Validator.isNotNull(status)) {
			boolean isAdmin = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_ADMIN, themeDisplay.getUserId());
			boolean isEmployer = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.EMPLOYER, themeDisplay.getUserId());
			boolean isCommittee = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_COMMITTEE, themeDisplay.getUserId());
			
			String label = getFinalStatus(isEmployer, isCommittee, isAdmin, status);
			equivalencyDto.setStatus(getFinalStatusValue(label, themeDisplay));
			label = label.toLowerCase();
			LOGGER.info("addHomeSearchDetails>>> " + label);
			if(Validator.isNotNull(label) && Validator.isNotNull(EquivalencyRequestStatusEnum.getStatusByLabel(label))) {
				equivalencyDto.setStatusColorClass(EquivalencyRequestStatusEnum.getStatusByLabel(label).getColor());
			}
		}
		if (Validator.isNotNull(createdOn)) {
			SimpleDateFormat formatter = new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD);
			String strCreatedOn = formatter.format(createdOn);
			equivalencyDto.setCreatedOn(strCreatedOn);
		}
		equivalencyDto.setEquivalencyRequestId(id);
		equivalencyDto.setTransitions(JspTransitionWorkflowHandler.equivalencyRequestJspTransitionHandler(themeDisplay,
				getObjectClassName(themeDisplay.getCompanyId()), id));
		LOGGER.info("equivalencyDto.getTransitions::::::::::"+equivalencyDto.getTransitions());		
		return equivalencyDto;
	}

	public String convertDate1(String date) throws ParseException {
		LOGGER.info("date : " + date);
		DateFormat oldDF = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat newDF = new SimpleDateFormat("dd-MM-yyyy");
		Date oldDate = oldDF.parse(date);
		LOGGER.info("converted Date : " + newDF.format(oldDate));
		return newDF.format(oldDate);
	}

	public String convertDate(Date date) {
		// DateFormat df = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss.SSS");
		DateFormat newDF = new SimpleDateFormat("dd-MM-yyyy");
		LOGGER.info("converted Date : " + newDF.format(date));
		return newDF.format(date);
	}

	@Reference(unbind = "_")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private ObjectDefinitionLocalService objectDefinitionService;

	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyHomeSearchMVCResourceCommand.class);
}
