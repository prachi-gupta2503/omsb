<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="gov.omsb.trainee.elective.rotations.web.constants.OmsbTraineeElectiveRotationsWebPortletKeys"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:renderURL var="addTraineeElectiveRotations">
	<portlet:param name="mvcRenderCommandName"
		value="<%=OmsbTraineeElectiveRotationsWebPortletKeys.ADD_TRAINEE_ELECTIVE_ROTATIONS_JSP%>" />
</portlet:renderURL>