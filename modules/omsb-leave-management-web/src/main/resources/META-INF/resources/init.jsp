<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@page import="gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants"%>

<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.petra.string.StringPool"%>

<%@page import="gov.omsb.tms.model.LeaveMaster"%>
<%@page import="gov.omsb.tms.service.LeaveMasterLocalServiceUtil"%>
<%@page import="gov.omsb.tms.service.LeaveTypesLocalServiceUtil"%>
<%@page import="gov.omsb.tms.model.LeaveProgramMaster"%>
<%@page import="gov.omsb.tms.service.LeaveProgramMasterLocalService"%>
<%@page import="gov.omsb.tms.service.LeaveProgramMasterLocalServiceUtil"%>
<%@page import="gov.omsb.tms.model.LeaveAnnualMaster"%>
<%@page import="gov.omsb.tms.service.TraineeLevelMasterLocalServiceUtil"%>
<%@page import="gov.omsb.tms.model.TraineeLevelMaster"%>
<%@page import="gov.omsb.tms.service.ProgramMasterLocalServiceUtil"%>
<%@page import="gov.omsb.tms.model.LeaveAnnualRule"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<%@page import="java.text.SimpleDateFormat"%>