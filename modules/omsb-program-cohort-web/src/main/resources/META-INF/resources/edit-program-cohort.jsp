<%@page import="gov.omsb.program.cohort.web.constants.OmsbProgramCohortWebPortletKeys"%>
<%@ include file="/init.jsp" %>

<portlet:actionURL name="<%= OmsbProgramCohortWebPortletKeys.SAVE_PROGRAM_COHORT_MVC_ACTION_COMMAND %>" var="saveProgramCohort" >
	<portlet:param name="redirect" value="${home}"/>
</portlet:actionURL>

<liferay-ui:error key="invalid-blocks-numbers" message="All Trainee level must be have 13 blocks except last trainee level" />
<div class="loader-container loaded d-none" id="block-creation-loader" >
     <div class="loader"><img src="${themeDisplay.getPathThemeImages()}/svg/loader.svg" alt="loader"></div>
     <p><liferay-ui:message key="block-creation-message" /></p>
 </div>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<div class="omsb-page-top-info mb-4">
				<div class="pagetitle"> <liferay-ui:message key="edit-program-cohort" /> </div>									
			</div>
			<aui:form action="${saveProgramCohort}" name="updatefm">
			<aui:input type="hidden" name="programId" value="${programId}" />
			<aui:input label="programMasterId" type="hidden" name="programMasterId"  value="${programMaster.programMasterId}" />
			<aui:input label="programDurationId" type="hidden" name="programDurationId"  value="${programDuration.progDurationId}" />
			
			<div class="omsb-list-filter omsb-more-btn">
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message key="program" /></label>
						<label class="label-content">${programMaster.getProgramName(locale)}</label>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message key="cohort" /></label>
						<label class="label-content">${programDuration.getAyApplicableForm()}</label>
					</div>
				</div>
			</div>
		
			<!-- Cohort Board Start -->
			<c:forEach items="${progdurationTraineelevelBlocksLevelTypeRelList}" var="progDuratoinRel" varStatus="theCount"> 
			<div id="mainDiv" class="omsb-card omsb-card-graybg omsb-BorderRadius-4 padding-cohort">
				<div class="omsb-list-filter pb-0">
					<div class="row">
						<aui:input label="progdurationTlBlocksLtId" type="hidden" name="progdurationTlBlocksLtId${theCount.index}"  value="${traineeLevel.progdurationTlBlocksLtId}" />
						<div class="col-lg-4 col-md-6">
							<aui:select id="traineeLevel${theCount.index}" name="traineeLevel${theCount.index}" label="trainee-level" localized="true" cssClass="custom-select form-control" value="${progDuratoinRel.traineeLevelId}">
								<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-trainee-level" /></aui:option>
								<c:forEach items="${traineeLevelMasters}" var="traineeLevel">
									<aui:option value="${traineeLevel.traineeLevelMasterId}">${traineeLevel.getTraineeLevelName(locale)}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
						<div class="col-lg-4 col-md-6">
							<aui:input cssClass="form-control" label="no-of-blocks" type="number" name="noOfBlocks${theCount.index}" value="${progDuratoinRel.noOfBlocks}" >
								<aui:validator name="required" />
								<aui:validator name="range">[1,13]</aui:validator>
							</aui:input>
						</div>
						<div class="col-lg-4 col-md-6">
							<aui:select id="level-type${theCount.index}" name="levelType${theCount.index}" label="level-type" localized="true" cssClass="custom-select form-control" value="${progDuratoinRel.levelTypeId}">
								<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-trainee-level" /></aui:option>
								<c:forEach items="${levelTypeMasters}" var="levelType">
									<aui:option value="${levelType.levelTypeMasterId}">${levelType.getLevelTypeName(locale)}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					
					</div>
					<!-- <div class="filter-button-wrap flex">
						<button class="btn omsb-bc-red-button" onClick="addBlock()"><liferay-ui:message key="add" /></button>
						<button class="btn omsb-bg-red-button" onClick="removeBlock()"><liferay-ui:message key="discard" /></button>
					</div> -->
					
				</div>
			</div>
			</c:forEach>		
			<!-- Cohort Board End -->
			
			<div class="bottom-backbtn-wrap mt-0 mb-5">
				<aui:input label="count" type="hidden" name="count"  value="${progdurationTraineelevelBlocksLevelTypeRelList.size()-1}" />
				<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_EDIT_COHORT)}">
					<button class="btn omsb-bc-red-button" type="submit" onClick="loader(true)" title="Update"><liferay-ui:message key="update" /></button>
				</c:if>
				<a class="btn omsb-btn omsb-bg-red-button" href="${redirectCommand}" title="Cancel"><liferay-ui:message key="cancel" /></a>
			</div>
			</aui:form>
			
			<!--  Program Cohort Table -->
			<jsp:include page="/program-cohort-list.jsp" />
		</div>
	</div>
</div>
<script>
function loader(show) {
	if(show == true) {
		$('#block-creation-loader').addClass('d-flex').removeClass('d-none');
	} else {
		$('#block-creation-loader').addClass('d-none').removeClass('d-flex');
	}
}
</script>