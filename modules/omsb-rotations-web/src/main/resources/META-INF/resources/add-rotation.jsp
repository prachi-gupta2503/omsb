<%@ include file="init.jsp"%>

<liferay-ui:error key="rotationNameError" message="rotation-name-error" />
<liferay-ui:error key="rotationCodeError" message="rotation-code-error" />
<liferay-ui:error key="rotationObjectivesError" message="rotation-objective-error" />
<liferay-ui:error key="rotationRequirementError" message="rotation-requirement-error" />

<portlet:actionURL name="<%=OmsbRotationsWebPortletKeys.ROTATION_SAVE_MVC_ACTION_COMMAND%>" var="saveRotationURL">
	<portlet:param name="redirect" value="${currentURL}"/>
	<portlet:param name="redirectCommand" value="<%= OmsbRotationsWebPortletKeys.ROTATION_ADD_MVC_RENDER_COMMAND %>"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<div class="omsb-page-top-info badge-default-main">
				<div class="pagetitle"><liferay-ui:message key="add-rotation" /></div>
				<div class="information">
					<span class="badge-default-program">
                        <liferay-ui:message key="program-cohort" />: ${programNameWithCohort}
                    </span>
				</div>
			</div>
			<aui:form action="${saveRotationURL}" name="addRotationForm">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:input label="rotation-name" name="rotationName" type="text" localized="true" cssClass="form-control required-field" placeholder="enter-rotation-name" data-name="rotation name">
							<aui:validator name="required" />
							<aui:validator name="maxLength">200</aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:input label="rotation-short-name" name="rotationShortName" type="text" localized="true" 
							cssClass="form-control required-field" placeholder="enter-rotation-short-name" data-name="rotation short name">
							<aui:validator name="required" />
							<aui:validator name="maxLength">200</aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:input label="rotation-code" name="rotationCode" type="text" localized="true" cssClass="form-control required-field" placeholder="enter-rotation-code" data-name="rotation code">
							<aui:validator name="required" />
							<aui:validator name="maxLength">75</aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:select id="rotationStatus" name="rotationStatus" label="rotation-status" localized="true" cssClass="custom-select form-control required-field" data-name="rotation status">
							<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation-status" /></aui:option>
							<aui:option value="true"><liferay-ui:message key="active" /></aui:option>
							<aui:option value="false"><liferay-ui:message key="inactive" /></aui:option>
							<aui:validator name="required" />
						</aui:select>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<input type="hidden" id="hiddenCohortId" name="<portlet:namespace/>progDurationId" value="${progDurationId}" />
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<aui:input name="type" type="hidden" value="add" />
				</div>
				<jsp:include page="/rotation-objective.jsp" />
			</div>
			<div class="bottom-backbtn-wrap">
				<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ADD_ROTATION)}">
					<button class="btn omsb-bc-red-button validate-form-button" type="button" title="Save" ><liferay-ui:message key="save" /></button>
				</c:if>
				<a class="btn omsb-btn omsb-bg-red-button" href="${currentURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
			</div>
			</aui:form>
		</div>
	</div>
</div>

<jsp:include page="/rotations-table-listing.jsp" />
