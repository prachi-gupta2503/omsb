package gov.omsb.common.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.template.StringTemplateResource;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateManager;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;

public class CommonUtil {

	private CommonUtil() {

	}

	public static long getDefaultGroupId() {
		long defaultGroupId = 0;
		try {
			defaultGroupId = Long.parseLong(PropsUtil.get("omsb.site.scope.groupId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultGroupId;
	}

	public static boolean isTraineeUser(User user) {
		boolean isTraineeUser = Boolean.FALSE;
		List<Role> userRole = user.getRoles();
		for (Role role : userRole) {
			if (role.getName().equalsIgnoreCase(CommonConstants.ROLE_TRAINEE)) {
				isTraineeUser = Boolean.TRUE;
				break;
			}
		}
		return isTraineeUser;
	}

	public static boolean isFacultyUser(User user) {
		boolean isFacultyUser = Boolean.FALSE;
		List<Role> userRole = user.getRoles();
		for (Role role : userRole) {
			if (role.getName().equalsIgnoreCase(CommonConstants.ROLE_FACULTY)) {
				isFacultyUser = Boolean.TRUE;
				break;
			}
		}
		return isFacultyUser;
	}

	public static boolean isChairmanUser(User user) {
		boolean isChairmanUser = Boolean.FALSE;
		List<Role> userRole = user.getRoles();
		for (Role role : userRole) {
			if (CommonConstants.ROLE_CHAIRMAN.equalsIgnoreCase(role.getName())) {
				isChairmanUser = Boolean.TRUE;
				break;
			}
		}
		return isChairmanUser;
	}

	public static Boolean isProgramDirector(User user) {
		boolean isProgramDirector = Boolean.TRUE;
		List<Role> userRoles = user.getRoles();
		for (Role role : userRoles) {
			if (CommonConstants.ROLE_PROGRAM_DIRECTOR.equalsIgnoreCase(role.getName())) {
				isProgramDirector = Boolean.FALSE;
				break;
			}
		}
		return isProgramDirector;
	}

	public static Boolean isProgramAdministrator(User user) {
		boolean isProgramAdministrator = Boolean.TRUE;
		List<Role> userRoles = user.getRoles();
		for (Role role : userRoles) {
			if (CommonConstants.ROLE_PROGRAM_ADMINISTRATOR.equalsIgnoreCase(role.getName())) {
				isProgramAdministrator = Boolean.FALSE;
				break;
			}
		}
		return isProgramAdministrator;
	}

	public static Boolean isSiteAuthorizedUser(User user) {
		boolean isSiteAuthorizedUser = Boolean.TRUE;
		List<Role> userRoles = user.getRoles();
		for (Role role : userRoles) {
			if (CommonConstants.ROLE_SITE_AUTHORIZED_USER.equalsIgnoreCase(role.getName())) {
				isSiteAuthorizedUser = Boolean.FALSE;
				break;
			}
		}
		return isSiteAuthorizedUser;
	}

	public static Boolean isSupeAdminUser(User user) {
		boolean isSuperAdmin = Boolean.TRUE;
		List<Role> userRoles = user.getRoles();
		for (Role role : userRoles) {
			if (CommonConstants.ROLE_PROGRAM_ADMINISTRATOR.equalsIgnoreCase(role.getName())
					|| CommonConstants.ROLE_PROGRAM_DIRECTOR.equalsIgnoreCase(role.getName())
					|| CommonConstants.ROLE_CHAIRMAN.equalsIgnoreCase(role.getName())
					|| CommonConstants.ROLE_FACULTY.equalsIgnoreCase(role.getName())
					|| CommonConstants.ROLE_TRAINEE.equalsIgnoreCase(role.getName())
					|| CommonConstants.ROLE_SITE_AUTHORIZED_USER.equalsIgnoreCase(role.getName())) {
				isSuperAdmin = Boolean.FALSE;
				break;
			}
		}
		return isSuperAdmin;
	}

	public static String getValueByLanguage(String xmlString, String attibuteName, String languageCode) {
		String value = StringPool.BLANK;
		try {
			Document programName = SAXReaderUtil.read(xmlString);
			Node node = programName.selectSingleNode("/root/" + attibuteName + "[@language-id='" + languageCode + "']");
			value = node.getText();
		} catch (Exception e) {
			value = xmlString;
			_logger.error(e.getMessage() + xmlString);
		}
		return value;
	}

	public static List<String> getYearRangeList(long currentYear, long totalNumberOfYear) {
		List<String> yearRange = new ArrayList<>();
		for (long i = 0; i < totalNumberOfYear; i++)
			yearRange.add(currentYear + StringPool.DASH + (++currentYear));
		return yearRange;
	}

	public static Template getTemplate(String message) {
		Template template = null;
		try {
			StringTemplateResource templateResource = new StringTemplateResource("0", message);
			TemplateManager templateManager = TemplateManagerUtil.getTemplateManager(TemplateConstants.LANG_TYPE_FTL);
			template = templateManager.getTemplate(templateResource, Boolean.FALSE);
		} catch (Exception e) {
			_logger.error(e);
		}
		return template;
	}

	public static String generateRenderURL(HttpServletRequest httpServletRequest, long groupId, String portletId,
			Map<String, String> otherParameter) {
		String renderURL = StringPool.BLANK;
		try {
			long plId = PortalUtil.getPlidFromPortletId(groupId, portletId);
			PortletURL portletURL = PortletURLFactoryUtil.create(httpServletRequest, portletId, plId,
					PortletRequest.RENDER_PHASE);

			portletURL.setWindowState(LiferayWindowState.NORMAL);
			portletURL.setPortletMode(LiferayPortletMode.VIEW);
			if (Validator.isNotNull(otherParameter)) {
				otherParameter.forEach((k, v) -> {
					portletURL.setParameter(k, v);
				});
			}
			renderURL = portletURL.toString();
		} catch (Exception e) {
			_logger.error(e);
		}

		return renderURL;
	}

	public static Calendar nextSaturdayDateAfterAddingNoOfDays(Calendar startDate, int noOfDays) {
		startDate.add(Calendar.DAY_OF_MONTH, noOfDays);
		int nxtcounter = 0;
		int prvcounter = 0;
		Calendar nxtcal1 = (Calendar) startDate.clone();
		Calendar prvcal1 = (Calendar) startDate.clone();

		while (nxtcal1.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
			nxtcal1.add(Calendar.DATE, 1);
			nxtcounter += 1;
		}

		while (prvcal1.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
			prvcal1.add(Calendar.DAY_OF_MONTH, -1);
			prvcounter += 1;
		}
		if (nxtcounter < prvcounter) {
			return nxtcal1;
		}
		return prvcal1;
	}

	public static List<Long> getProgramIdsFromUsermetadataItems(UserMetadataItem userMetadataItem) {
		List<Long> programMasterIds = new ArrayList<>();
		if (Validator.isNotNull(userMetadataItem) && userMetadataItem.getItems() != null) {
			programMasterIds = (userMetadataItem.getItems()).stream().map(UserMetadata::getProgramId)
					.collect(Collectors.toList());
		}
		_logger.debug("getProgramIdsFromUsermetadataItems ::: programMasterIds ::: " + programMasterIds.toString());
		return programMasterIds;
	}
	
	public static List<Long> removeDuplicateIds(List<Long> ids) {
		if(Validator.isNotNull(ids) && !ids.isEmpty()) {
			Set<Long> set = new LinkedHashSet<>();
	        set.addAll(ids);
	        ids.clear();
	        ids.addAll(set);	
		}
        return ids;
	}

	private static final Log _logger = LogFactoryUtil.getLog(CommonUtil.class);
}
