<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@page import="gov.omsb.duty.logging.web.constants.MVCCommandNames"%>
<%@page import="gov.omsb.duty.logging.web.util.DutyLoggingUtil"%>
<%@page import="gov.omsb.tms.model.DutyAssignment"%>
<%@page import="gov.omsb.tms.service.DutyAssignmentLocalServiceUtil"%>
<%@page import="gov.omsb.tms.service.DutyTypesLocalServiceUtil"%>
<%@page import="gov.omsb.tms.model.DutyAssignmentModel"%>
<%@page import="gov.omsb.tms.model.DutyTypes"%>
<%@page import="gov.omsb.tms.model.ProgramDutyAssignment"%>

<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.petra.string.StringPool"%>