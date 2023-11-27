<%@ include file="init.jsp"%>
<liferay-ui:error key="rotationNameError" message="rotation-name-error" />
<liferay-ui:error key="rotationCodeError" message="rotation-code-error" />
<liferay-ui:error key="rotationObjectivesError" message="rotation-objective-error" />
<liferay-ui:error key="rotationRequirementError" message="rotation-requirement-error" />

<portlet:renderURL var="addRotation">
    <portlet:param name="mvcRenderCommandName" value="<%=OmsbRotationsWebPortletKeys.ROTATION_ADD_MVC_RENDER_COMMAND%>" />
</portlet:renderURL>

<portlet:actionURL name="<%=OmsbRotationsWebPortletKeys.ROTATION_SAVE_MVC_ACTION_COMMAND%>" var="saveRotationURL">
	<portlet:param name="redirect" value="${currentURL}"/>
	<portlet:param name="redirectCommand" value="<%= OmsbTmsCommonConstants.ROTATION_DETAILS_MVC_RENDER_COMMAND %>"/>
</portlet:actionURL>

<aui:form action="${saveRotationURL}" name="addRotationForm">
<div class="omsb-card">
<div class="row pb-4">
	<div class="col-md-8">
			<div class="omsb-page-top-info badge-default-main">
				<div class="pagetitle"><liferay-ui:message key="rotation-details" /> - ${rotation.getRotationName(locale)}</div>
				<div class="information">
					<span class="badge-default-program">
                        <liferay-ui:message key="program-cohort" />: ${programNameWithCohort}
                    </span>
				</div>
			</div>
				<c:if test="${!isTraineeUser}">
					<%-- <a class="btn omsb-bg-red-button"  href="${addRotation}" >
						 <img src="${themeDisplay.getPathThemeImages()}/svg/plus_img.svg" alt=""> <liferay-ui:message key="add-rotation" />
					</a> --%>
				</c:if>
			</h4>
			<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4">
			<div class="row">
					<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ROTATION_VIEW)}">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:input label="rotation-name" name="rotationName" type="text" localized="true"  value="${rotation.rotationName}" cssClass="form-control required-field" placeholder="enter-rotation-name" data-name="rotation name">
									<aui:validator name="required" />
									<aui:validator name="maxLength">200</aui:validator>
								</aui:input>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:input label="rotation-short-name" name="rotationShortName" type="text" localized="true" value="${rotation.rotationShortName}" cssClass="form-control required-field" placeholder="enter-rotation-short-name" data-name="rotation short name">
									<aui:validator name="required" />
									<aui:validator name="maxLength">200</aui:validator>
								</aui:input>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:input label="rotation-code" name="rotationCode" type="text" localized="true" value="${rotation.rotationCode}" cssClass="form-control required-field" placeholder="enter-rotation-code" data-name="rotation code">
									<aui:validator name="required" />
									<aui:validator name="maxLength">75</aui:validator>
								</aui:input>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:select id="rotationStatus" name="rotationStatus" label="rotation-status" localized="true"  value="${rotation.rotationStatus}" cssClass="custom-select form-control required-field" data-name="rotation status">
									<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation-status" /></aui:option>
									<aui:option value="true"><liferay-ui:message key="active" /></aui:option>
									<aui:option value="false"><liferay-ui:message key="inactive" /></aui:option>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</div>
					</c:if>
					<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_ROTATION_VIEW) && !permissionChecker.isOmniadmin()}">
						<div class="col-lg-6 col-md-6 col-sm-12 label-box">
							<label class="label-name"><liferay-ui:message key="rotation-name" /></label>
							<label class="label-content">${rotation.getRotationName(locale)}</label>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 label-box">
							<label class="label-name"><liferay-ui:message key="rotation-short-name" /></label>
							<label class="label-content">${rotation.getRotationShortName(locale)}</label>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 label-box">
							<label class="label-name"><liferay-ui:message key="rotation-code" /></label>
							<label class="label-content">${rotation.getRotationCode(locale)}</label>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 label-box">
							<label class="label-name"><liferay-ui:message key="rotation-status" /></label>
							<c:choose>       
								<c:when test = "${rotation.rotationStatus}">
									<label class="label-content"><liferay-ui:message key="active" /></label>
								</c:when>
								<c:otherwise>
									<label class="label-content"><liferay-ui:message key="inactive" /></label>
								</c:otherwise>
							</c:choose>
						</div>
					</c:if>
				<%-- <c:choose>       
					<c:when test = "${!isTraineeUser}">
						<div class="col-lg-12 col-md-12 col-sm-12">
						<label for="rotationObjectives"><liferay-ui:message key="goal-and-objectives" /><span style="color:red">*</span></label>
						<liferay-ui:input-localized name="rotationObjectives" xml="${rotation.rotationObjectives}" type="editor" class="form-control"/>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col-lg-12 col-md-12 col-sm-12 label-box">
							<label class="label-name"><liferay-ui:message key="goal-and-objectives" /></label>
							<label class="label-content">${rotation.getRotationObjectives(locale)}</label>
						</div>
					</c:otherwise>
				</c:choose> --%>
				<input type="hidden" id="hiddenCohortId" name="<portlet:namespace/>progDurationId" value="${progDurationId}" />
				<aui:input name="type" type="hidden" value="edit" />
			</div>
			</div>
	</div>
	<div class="col-md-4">
		<jsp:include page="/other-rotations.jsp" />
	</div>
</div>

	<div class="row">
		<div class="col-md-12">
			<jsp:include page="/rotation-objective.jsp" /> 
		</div>
		<div class="bottom-backbtn-wrap omsb-card">
			<aui:input label="rotation-master-id" name="rotationMasterId" type="hidden" value="${rotation.rotationMasterId}" class="form-control"  />
			<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_UPDATE_ROTATION)}">
					<button class="btn omsb-bc-red-button validate-form-button" type="button" title="Save" ><liferay-ui:message key="update" /></button>
			</c:if>
			<a class="btn omsb-btn btn-back" href="${programListRenderUrl}" title="Back"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
		</div>
	</div>
</div>
</aui:form>
<jsp:include page="/rotation-structure.jsp" /> 