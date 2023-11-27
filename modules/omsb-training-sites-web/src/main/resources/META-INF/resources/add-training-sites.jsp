<%@ include file="init.jsp"%>
<liferay-ui:error key="trainingSiteNameError" message="training-site-name-error" />
<liferay-ui:error key="trainingSiteCodeError" message="training-site-code-error" />
<liferay-ui:error key="trainingSiteDescriptionError" message="training-site-Description-error" />

<portlet:actionURL name="<%=OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_SAVE_MVC_ACTION_COMMAND%>" var="saveTrainingSiteURL">
	<portlet:param name="redirect" value="${currentURL}"/>
	<portlet:param name="redirectCommand" value="<%= OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_ADD_MVC_RENDER_COMMAND %>"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<div class="omsb-page-top-info badge-default-main">
				<div class="pagetitle"><liferay-ui:message key="add-training-site" /></div>
				<div class="information">
					<span class="badge-default-program">
                        <liferay-ui:message key="program-cohort" />: ${programNameWithCohort}
                    </span>
				</div>
			</div>
			<aui:form action="${saveTrainingSiteURL}" name="fm">
			<input type="hidden" id="hiddenCohortId" name="<portlet:namespace/>progDurationId" value="${progDurationId}" />
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:input label="training-site-name" name="trainingSiteName" type="text" localized="true" class="form-control" placeholder="enter-training-site-name">
							<aui:validator name="required" />
							<aui:validator name="maxLength">200</aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:input label="training-site-address" name="trainingSiteAddress" type="text" localized="true" class="form-control" placeholder="enter-training-site-address">
							<aui:validator name="required" />
							<aui:validator name="maxLength">5000</aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:input label="training-site-code" name="trainingSiteCode" type="text" localized="true" class="form-control" placeholder="enter-training-site-code">
							<aui:validator name="required" />
							<aui:validator name="maxLength">200</aui:validator>
						</aui:input>
						
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:select id="trainingSiteStatus" name="trainingSiteStatus" label="training-site-status" localized="true" class="custom-select form-control">
							<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-training-site-status" /></aui:option>
							<aui:option value="true"><liferay-ui:message key="active" /></aui:option>
							<aui:option value="false"><liferay-ui:message key="inactive" /></aui:option>
							<aui:validator name="required" />
						</aui:select>
					</div>
				</div>

				<div class="col-lg-12 col-md-12 col-sm-12">
					<div class="form-group">
					<label for="trainingSiteDescription"><liferay-ui:message key="training-site-description" /><span style="color:red">*</span></label>
						<liferay-ui:input-localized name="trainingSiteDescription" xml="" type="editor" class="form-control"/>
					</div>
				</div>

			</div>
			<div class="bottom-backbtn-wrap">
				<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ADD_TRAINING_SITE)}">
					<button class="btn omsb-bc-red-button" type="submit" title="Save" ><liferay-ui:message key="save" /></button>
				</c:if>
				<a class="btn omsb-btn omsb-bg-red-button" href="${currentURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
			</div>
			</aui:form>
		</div>
	</div>
</div>

<jsp:include page="/training-site-table-listing.jsp" />