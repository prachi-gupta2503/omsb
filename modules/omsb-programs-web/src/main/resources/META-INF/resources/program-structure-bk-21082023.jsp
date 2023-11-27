<%@ include file="/init.jsp"%>

<%
	long groupId = themeDisplay.getScopeGroupId();
	Layout trainingSiteLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(groupId, true, OmsbTmsCommonConstants.TRAINING_SITES_PORTLET_FRAINDLY_URL);
	long trainingSitePlId = Validator.isNotNull(trainingSiteLayout) ? trainingSiteLayout.getPlid() : 0;
	
	Layout rotationLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(groupId, true, OmsbTmsCommonConstants.ROTATIONS_PORTLET_FRAINDLY_URL);
	long rotationPlId = Validator.isNotNull(rotationLayout) ? rotationLayout.getPlid() : 0;
%>

<c:if test="${trainingSiteList.size() >0 }">

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card pediatric-supported-training-site">
			<h4 class="omsb-card-title">${program.getProgramName(locale)} - <liferay-ui:message key="training-sites" /> </h4>
		<div class="omsb-cards-wrap row">
			<c:forEach items="${trainingSiteList}" var="trainingSite">
			<liferay-portlet:renderURL var="trainingSiteDetails"  copyCurrentRenderParameters="false" plid="<%= trainingSitePlId%>" portletName="<%= OmsbTmsCommonConstants.TRAINING_SITES_PORTLET_NAME %>" >
			    <liferay-portlet:param name="mvcRenderCommandName" value="<%= OmsbTmsCommonConstants.TRAINING_SITE_DETAILS_MVC_RENDER_COMMAND %>" />
			    <liferay-portlet:param name="trainingSiteMasterId" value="${trainingSite.key}" />
			</liferay-portlet:renderURL>
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-cst-5 m-0">
				<a href="${trainingSiteDetails}" class="trans pediatric-click-box" title="${trainingSite.value}">${trainingSite.value}</a> 
			</div>
			</c:forEach>
		</div>
		</div>
	</div>
</div>
</c:if>

<c:if test="${programStructureList.size() > 0}">

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card omsb-pediatrics-rotationdetails">
			<h4 class="omsb-card-title">${program.getProgramName(locale)}  - <liferay-ui:message key="rotations" /> </h4>
			
			<div class="row">
			<c:forEach items="${programStructureList}" var="rotation">
				<div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 mb-cst">
					<div class="omsb-pediatrics-box">
						<liferay-portlet:renderURL var="rotationDetails"  copyCurrentRenderParameters="false" plid="<%= rotationPlId%>" portletName="<%= OmsbTmsCommonConstants.ROTATIONS_PORTLET_NAME %>" >
						    <liferay-portlet:param name="mvcRenderCommandName" value="<%= OmsbTmsCommonConstants.ROTATION_DETAILS_MVC_RENDER_COMMAND %>" />
						    <liferay-portlet:param name="rotationMasterId" value="${rotation.key.split('-')[1]}" />
						</liferay-portlet:renderURL>
						<h3><a href="${rotationDetails}" class="trans" title="Pediatrics">${rotation.key.split("-")[0]}</a></h3>
						
							<ul>
								<c:forEach items="${rotation.value}" var="traineeLevel">
									<li>
										<div class="Program-dtls">
											<div class="title">${traineeLevel.key}</div>
											<div class="title-value">${traineeLevel.value == 0 ? "-" : traineeLevel.value}</div>
										</div>
									</li>
								</c:forEach>
							</ul>
					</div>
				</div>
			</c:forEach>
			</div>
		
		</div>
	</div>
</div>
</c:if>

