<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<input type="hidden" name="baseUrl" id="baseUrl" value="${baseUrl}" />
<input type="hidden" name="loginUrl" id="loginUrl" value="${loginUrl}" />
<input type="hidden" name="guestTokenUrl" id="guestTokenUrl" value="${guestTokenUrl}" />

<input type="hidden" name="username" id="username" value="${username}" />
<input type="hidden" name="password" id="password" value="${password}" />
<input type="hidden" name="provider" id="provider" value="${provider}" />
<input type="hidden" name="refresh" id="refresh" value="${refresh}" />

<input type="hidden" name="dashboardId" id="dashboardId" value="${dashboardId}" />

<input type="hidden" name="user_id" id="user_id" value="${userId}" />
<input type="hidden" name="program_duration_id" id="program_duration_id" value="${programDurationId}" />
<input type="hidden" name="worksector_id" id="worksector_id" value="${workSectorId}" />

<input type="hidden" name="isVehpcUser" id="isVehpcUser" value="${isVehpcUser}" />


<liferay-theme:defineObjects />

<portlet:defineObjects />