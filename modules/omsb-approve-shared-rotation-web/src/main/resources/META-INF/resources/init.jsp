<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 
    prefix="fn" %> 

<%@page import="gov.omsb.approve.shared.rotation.web.constants.OmsbApproveSharedRotationWebPortletKeys"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>

<portlet:actionURL
	name="<%=OmsbApproveSharedRotationWebPortletKeys.RIVIEW_SHARED_ROTATIONS_MVC_ATION_COMMAND%>"
	var="reviewSharedRotations" />


<liferay-theme:defineObjects />

<portlet:defineObjects />