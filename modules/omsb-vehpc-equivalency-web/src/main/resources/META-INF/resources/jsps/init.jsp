<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<link rel="stylesheet" type ="text/css" href = "https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
<link rel="stylesheet" type ="text/css" href = "https://cdn.datatables.net/buttons/2.4.1/css/buttons.dataTables.min.css">

<script type="text/javascript" src = "https://cdn.datatables.net/buttons/2.4.1/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
<script type="text/javascript" src = "https://cdn.datatables.net/buttons/2.4.1/js/buttons.html5.min.js"></script>


<%@page import="omsb.vehpc.equivalency.web.constants.MVCCommandNames"%>
<%@page import="omsb.vehpc.equivalency.web.constants.EquivalencyStatusConstants"%>
<%@page import="omsb.vehpc.equivalency.web.constants.AppealConstants"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="gov.omsb.common.constants.RoleNameConstants"%>
<%@page import="omsb.vehpc.appeal.preferences.AppealConfiguration"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@page import="omsb.vehpc.equivalency.web.constants.EquivalencyWorkflowStatusEnum"%>
<style>
.omsb-card-title {
	margin-bottom : 10px!important;
}
</style>

