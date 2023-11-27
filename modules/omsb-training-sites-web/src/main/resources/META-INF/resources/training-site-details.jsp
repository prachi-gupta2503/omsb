<%@ include file="init.jsp"%>
<liferay-ui:error key="trainingSiteNameError"
	message="training-site-name-error" />
<liferay-ui:error key="trainingSiteCodeError"
	message="training-site-code-error" />
<liferay-ui:error key="trainingSiteDescriptionError"
	message="training-site-Description-error" />


<portlet:actionURL
	name="<%=OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_SAVE_MVC_ACTION_COMMAND%>"
	var="saveTrainingSiteURL">
	<portlet:param name="progDurationId" value="${progDurationId}" />
	<portlet:param name="redirect" value="${currentURL}" />
	<portlet:param name="redirectCommand"
		value="<%=OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_DETAILS_MVC_RENDER_COMMAND%>" />
</portlet:actionURL>

<portlet:renderURL var="addTrainingSite">
	<portlet:param name="mvcRenderCommandName"
		value="<%=OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_ADD_MVC_RENDER_COMMAND%>" />
	<portlet:param name="progDurationId" value="${progDurationId}" />
</portlet:renderURL>


<div class="row">
	<div class="col-md-8">
		<div class="omsb-card">
			<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ADD_TRAINING_SITE)}">
				<div class="badge-default-main justify-content-between align-items-baseline omsb-page-top-info training-title-wrap">
					<div class="leftbar">
		   				<div class="pagetitle"><liferay-ui:message key="training-site-details" />- ${trainingSite.getTrainingSiteName(locale)}</div>
	   					<div class="information mt-2">
	   						<span class="badge-default-program">
	   	                        <liferay-ui:message key="program-cohort" />: ${programNameWithCohort}
	   	                    </span>
	   					</div>
					</div>
					<a class="btn omsb-bg-red-button" href="${addTrainingSite}"> 
						<img src="${themeDisplay.getPathThemeImages()}/svg/plus_img.svg" alt="plus icon">
						<liferay-ui:message key="add-training-site" />
					</a>
				</div>
			</c:if>
			<c:if test="${!permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ADD_TRAINING_SITE)}">
				<div class="omsb-page-top-info badge-default-main">
					<div class="pagetitle"><liferay-ui:message key="training-site-details" />- ${trainingSite.getTrainingSiteName(locale)}</div>
					<div class="information">
						<span class="badge-default-program">
	                        <liferay-ui:message key="program-cohort" />: ${programNameWithCohort}
	                    </span>
					</div>
				</div>
			</c:if>
			
			<aui:form action="${saveTrainingSiteURL}" name="fm">
				<input type="hidden" id="hiddenCohortId" name="<portlet:namespace/>progDurationId" value="${progDurationId}" />
					<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_TRAINING_SITE_VIEW)}">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-12">
								<aui:input label="training-site-name" name="trainingSiteName"
									type="text" class="form-control" disabled="false"
									value="${trainingSite.trainingSiteName}" localized="true">
									<aui:validator name="required" />
									<aui:validator name="maxLength">200</aui:validator>
								</aui:input>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<aui:input label="training-site-address"
									name="trainingSiteAddress" type="text" class="form-control"
									disabled="false" value="${trainingSite.trainingSiteAddress}"
									localized="true">
									<aui:validator name="required" />
									<aui:validator name="maxLength">5000</aui:validator>
								</aui:input>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<aui:input label="training-site-code" name="trainingSiteCode"
									type="text" class="form-control" disabled="false"
									value="${trainingSite.trainingSiteCode}" localized="true">
									<aui:validator name="required" />
									<aui:validator name="maxLength">200</aui:validator>
								</aui:input>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<aui:select id="trainingSiteStatus" name="trainingSiteStatus"
									label="training-site-status"
									value="${trainingSite.trainingSiteStatus}" disabled="false"
									class="custom-select form-control">
									<aui:option value="" selected="true" disabled="true"
										cssClass="placeholder">
										<liferay-ui:message key="please-select-training-site-status" />
									</aui:option>
									<aui:option value="true">
										<liferay-ui:message key="active" />
									</aui:option>
									<aui:option value="false">
										<liferay-ui:message key="inactive" />
									</aui:option>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</div>
					</c:if>
					<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_TRAINING_SITE_VIEW) && !permissionChecker.isOmniadmin()}">
						<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="training-site-name" />
										</div>
										<div class="label-content">${trainingSite.getTrainingSiteName(locale)}</div>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="training-site-address" />
										</div>
										<div class="label-content">${trainingSite.getTrainingSiteAddress(locale)}</div>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="training-site-code" />
										</div>
										<div class="label-content">${trainingSite.getTrainingSiteCode(locale)}</div>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="training-site-status" />
										</div>
										<c:choose>
											<c:when test="${trainingSite.trainingSiteStatus}">
												<label class="label-content"><liferay-ui:message
														key="active" /></label>
											</c:when>
											<c:otherwise>
												<label class="label-content"><liferay-ui:message
														key="inactive" /></label>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_TRAINING_SITE_VIEW)}">
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12">
								<label for="trainingSiteDescription"><liferay-ui:message
										key="training-site-description" /><span style="color: red">*</span></label>
								<liferay-ui:input-localized name="trainingSiteDescription"
									xml="${trainingSite.trainingSiteDescription}" type="editor"
									class="form-control" />
							</div>
						</div>
					</c:if>
					<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_TRAINING_SITE_VIEW) && !permissionChecker.isOmniadmin()}">
						<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
							<div class="row">										
								<div class="col-lg-12 col-md-12 col-sm-12">
									<div class="form-group">
										<label><liferay-ui:message
										key="training-site-description" /></label>
										<div class="form-control">
											<p>${trainingSite.getTrainingSiteDescription(locale)}</p>
										</div>
									</div>
								</div>						
							</div>
						</div>
					</c:if>
				<div class="bottom-backbtn-wrap">
					<aui:input label="training-site-master-id"
						name="trainingSiteMasterId" type="hidden"
						value="${trainingSite.trainingSiteMasterId}" class="form-control" />
				<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_UPDATE_TRAINING_SITE)}">
						<button class="btn omsb-bc-red-button" type="submit" title="Save">
							<liferay-ui:message key="update" />
						</button>
					</c:if>
					<a class="btn omsb-btn omsb-bg-red-button"
						href="${programListRenderUrl}" title="Back"><i class="fi fi-sr-arrow-left"></i> <liferay-ui:message
							key="back" /></a>
				</div>
			</aui:form>
		</div>
	</div>
	<div class="col-md-4">
		<jsp:include page="/other-training-sites.jsp" />
	</div>
</div>
<div class="row">
	<jsp:include page="/training-structure.jsp" />
</div>

