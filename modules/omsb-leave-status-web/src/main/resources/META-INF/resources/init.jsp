<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> --%>
<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@page import="gov.omsb.leave.status.web.constants.OmsbLeaveStatusConstants"%>

<%@page import="gov.omsb.tms.model.LeaveMaster"%>
<%@page import="gov.omsb.tms.model.LeaveTypes"%>
<%@page import="gov.omsb.tms.service.LeaveTypesLocalServiceUtil"%>
<%@page import="gov.omsb.tms.service.ProgramMasterLocalServiceUtil"%>

<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>

<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>