<%@ include file="init.jsp"%>
<div class="omsb-card">
	<h4 class="omsb-card-title"><liferay-ui:message key="other-training-sites" /></h4>
	<ul class="omsb-programdetails-list max-height-250">
		<c:forEach var="otherTrainingSite" items="${otherTrainingSitesList}">
			<c:if test = "${otherTrainingSite.trainingSiteMasterId != trainingSite.trainingSiteMasterId}">
				<portlet:renderURL var="trainingSiteDetails">
				    <portlet:param name="mvcRenderCommandName" value="<%= OmsbTmsCommonConstants.TRAINING_SITE_DETAILS_MVC_RENDER_COMMAND %>" />
				    <portlet:param name="progDurationId" value="${progDurationId}" />
				    <portlet:param name="trainingSiteMasterId" value="${otherTrainingSite.trainingSiteMasterId}" />
				</portlet:renderURL>
				<li><a href="${trainingSiteDetails}" class="trans" title="${otherTrainingSite.getTrainingSiteName(locale)}">${otherTrainingSite.getTrainingSiteName(locale)}</a></li>
			</c:if>
	   </c:forEach>
	</ul>
</div>