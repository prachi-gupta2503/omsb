<%@ include file="/init.jsp"%>
<div class="omsb-card border">
	<h4 class="omsb-card-title"><liferay-ui:message key="other-rotations" /></h4>
	<ul class="omsb-programdetails-list max-height-150">
		<c:forEach var="otherRotation" items="${otherRotationList}">
			<c:if test = "${otherRotation.rotationMasterId != rotation.rotationMasterId}">
				<portlet:renderURL var="rotationDetails">
				    <portlet:param name="mvcRenderCommandName" value="<%= OmsbTmsCommonConstants.ROTATION_DETAILS_MVC_RENDER_COMMAND %>" />
				    <portlet:param name="programDurationId" value="${progDurationId}" />
				    <portlet:param name="rotationMasterId" value="${otherRotation.rotationMasterId}" />
				</portlet:renderURL>
				<li><a href="${rotationDetails}" class="trans" title="${otherRotation.getRotationName(locale)}">${otherRotation.getRotationName(locale)}</a></li>
			</c:if>
	   </c:forEach>
	</ul>
</div>