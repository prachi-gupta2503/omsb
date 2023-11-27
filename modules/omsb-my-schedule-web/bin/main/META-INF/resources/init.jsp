<%@page
	import="gov.omsb.my.schedule.web.constants.OmsbMyScheduleWebPortletKeys"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:resourceURL
	id="<%=OmsbMyScheduleWebPortletKeys.GET_COHORT_LIST_MVC_RESOURCE_COMMAND%>"
	var="getCohortListMVCResourceURL" />
	
<portlet:resourceURL
	id="<%=OmsbMyScheduleWebPortletKeys.GET_TRAINEE_LIST_MVC_RESOURCE_COMMAND%>"
	var="getTraineeListMVCResourceURL" />
	
<portlet:resourceURL
	id="<%=OmsbMyScheduleWebPortletKeys.GET_ROTATION_DETAIL_MVC_RESOURCE_COMMAND%>"
	var="getRotationDetailResourceURL" />
	
<portlet:resourceURL
	id="<%=OmsbMyScheduleWebPortletKeys.GET_TRAINEE_ROTATION_DETAIL_MVC_RESOURCE_COMMAND%>"
	var="getTraineeRotationDetailResourceURL" />

<portlet:resourceURL
	id="<%=OmsbMyScheduleWebPortletKeys.GET_FACULTY_SCHEDULE_VIEW_MVC_RESOURCE_COMMAND%>"
	var="getFacultyScheduleViewMVCResourceURL" />
	
<portlet:resourceURL
	id="<%=OmsbMyScheduleWebPortletKeys.GET_TRAINEE_SCHEDULE_VIEW_MVC_RESOURCE_COMMAND%>"
	var="getTraineeScheduleViewMVCResourceURL" />