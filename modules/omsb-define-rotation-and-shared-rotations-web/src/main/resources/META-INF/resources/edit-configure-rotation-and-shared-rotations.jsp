<%@page import="gov.omsb.define.rotation.and.shared.rotations.web.constants.OmsbDefineRotationAndSharedRotationsWebPortletKeys"%>
<%@ include file="/init.jsp" %>

<portlet:resourceURL id="/getProgramDurationURL" var="getProgramDurationURL" />
<portlet:resourceURL id="/getPrograms" var="getProgramsURL" />

<portlet:actionURL name="<%= OmsbDefineRotationAndSharedRotationsWebPortletKeys.SAVE_DRASR_MVC_ACTION_COMMAND %>" var="updateDefineRotationAndSharedRotations" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<aui:form action="${updateDefineRotationAndSharedRotations}" name="fm">
<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<div class="omsb-page-top-info mb-4">
				<div class="pagetitle"><liferay-ui:message key="define-rotations-and-shared-rotations" /></div>
			</div>
			<div class="omsb-list-filter omsb-more-btn">
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<aui:select id="program" name="program" label="select-program" localized="true" cssClass="custom-select form-control"  onChange="setProgramAndProgramDuration()" value="${programMasterId}">
							<aui:option value="0" selected="true" cssClass="placeholder">
								<liferay-ui:message key="please-select-program" />
							</aui:option>
							<c:forEach items="${programMasterList}" var="program">
								<aui:option value="${program.programMasterId}">${program.getProgramName(locale)}</aui:option>
							</c:forEach>
							<aui:validator name="required" />
						</aui:select>
					</div>
					
					<div class="col-lg-6 col-md-6 col-sm-12">
						<aui:select id="progDurationId" name="progDurationId" label="cohort" localized="true" cssClass="custom-select form-control" value="${progdurationRotationTrainingsitesRel.programDurationId}">
							<aui:option value="0" selected="true" cssClass="placeholder">
								<liferay-ui:message key="please-select-cohort" />
							</aui:option>
							<c:forEach items="${programDurationDetailsList}" var="pogramDuration">
								<aui:option value="${pogramDuration.progDurationId}">${pogramDuration.ayApplicableForm}</aui:option>
							</c:forEach>
							<aui:validator name="required" />
						</aui:select>
					</div>
					
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select id="rotationMasterId" name="rotationMasterId" label="select-rotation" localized="true" cssClass="custom-select form-control" value="${progdurationRotationTrainingsitesRel.rotationId}">
								<aui:option value="0" selected="true" cssClass="placeholder">
									<liferay-ui:message key="please-select-rotation" />
								</aui:option>
								<c:forEach items="${rotationMasterList}" var="rotation">
									<aui:option value="${rotation.rotationMasterId}">${rotation.getRotationName(locale)}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					
					<div class="col-lg-6 col-md-6 col-sm-12">
						<aui:select id="isSharedRotation" name="isSharedRotation" label="is-shared-rotation" localized="true" class="custom-select form-control" value="${progdurationRotationTrainingsitesRel.isSharedRotation}">
							<aui:option value="false" localized="true"><liferay-ui:message key="no" /></aui:option>
							<aui:option value="true" localized="true"><liferay-ui:message key="yes" /></aui:option>
							<aui:validator name="required" />
						</aui:select>
					</div>
					
					<div class="col-lg-6 col-md-6 col-sm-12" id="selectprogramWrap">
						<aui:select id="sharedProgramId" name="sharedProgramId" label="shared-program" localized="true" cssClass="custom-select form-control" value="${progdurationRotationTrainingsitesRel.rotationOwningProgramId}">
							<aui:option value="0" selected="true" cssClass="placeholder">
								<liferay-ui:message key="please-select-shared-program" />
							</aui:option>
							<c:forEach items="${programMasterList}" var="program">
								<aui:option value="${program.programMasterId}">${program.getProgramName(locale)}</aui:option>
							</c:forEach>
						</aui:select>
					</div>
					
					<div class="col-lg-6 col-md-6 col-sm-12" id="selecttrainingsiteWrap">
						<aui:select id="trainingSiteMasterId" name="trainingSiteMasterId" label="select-training-site" localized="true" cssClass="custom-select form-control" value="${progdurationRotationTrainingsitesRel.trainingSitesId}">
							<aui:option value="0" selected="true" cssClass="placeholder">
								<liferay-ui:message key="please-select-training-site" />
							</aui:option>
							<c:forEach items="${trainingSiteMasterList}" var="traningSite">
								<aui:option value="${traningSite.trainingSiteMasterId}">${traningSite.getTrainingSiteName(locale)}</aui:option>
							</c:forEach>
						</aui:select>
					</div>
					
					<div class="col-lg-6 col-md-6 col-sm-12" id="noofslotsWrap">
						<aui:input cssClass="form-control" label="no-of-slots" id="noOfSlots" type="number" name="noOfSlots" value="${progdurationRotationTrainingsitesRel.noOfSlots}"  >
						</aui:input>
					</div>
					
					<div class="col-lg-12 col-md-12">
						<div class="bottom-backbtn-wrap">
							<aui:input label="progdurationRotationTrainingsitesRelId" type="hidden" name="progdurationRotationTrainingsitesRelId"  value="${progdurationRotationTrainingsitesRel.progdurationRotationTsRelId}" />
							<button class="btn omsb-bc-red-button" type="submit" title="Update"> <liferay-ui:message key="update" /> </button>
							<a class="btn omsb-btn omsb-bg-red-button" href="${home}" title="Cancel"> <liferay-ui:message key="cancel" /> </a>
						</div>
					</div>
				</div>
			</div>

			<jsp:include page="/configure-rotation-and-shared-rotations-list.jsp" />
	
		</div>
	</div>
</div>
</aui:form>

<script type="text/javascript">

$(document).ready(function () {
	
	let selectedValue = $("#<portlet:namespace/>isSharedRotation").val();
	if (selectedValue == "true") {
		$("#selecttrainingsiteWrap").hide();
		$("#noofslotsWrap").hide();
		$("#selectprogramWrap").show();
	} else {
		$("#selecttrainingsiteWrap").show();
		$("#noofslotsWrap").show();
		$("#selectprogramWrap").hide();
	}
	
	$("#<portlet:namespace/>isSharedRotation").click(function () {
		let selectedValue = $(this).val();
		if (selectedValue == "true") {
			$("#selecttrainingsiteWrap").hide();
			$("#noofslotsWrap").hide();
			$("#selectprogramWrap").show();
		}

		if (selectedValue == "false") {
			$("#selecttrainingsiteWrap").show();
			$("#noofslotsWrap").show();
			$("#selectprogramWrap").hide();
		}
	})
})

function setProgramAndProgramDuration(){
	getProgramDuration();
	getPrograms();
}

function getProgramDuration(){
	let program = $("#<portlet:namespace/>program").val();
	$.ajax({
		url: '${getProgramDurationURL}',
		type: 'POST',
		data:
			{
				<portlet:namespace/>program: program
			},
		success: function(data)	
		{
			let jsondata = JSON.parse(data);
			$("#<portlet:namespace/>progDurationId").empty();
			$("#<portlet:namespace/>progDurationId").append('<option class="placeholder" selected="" value="0"> <liferay-ui:message key="please-select-cohort" /> </option>');
			for(let i=0; i<jsondata.length; i++){
				$("#<portlet:namespace/>progDurationId").append("<option value='"+jsondata[i].progDurationId+"'>" + jsondata[i].ayApplicableForm + "</option>");
			}
		}
	});
}

function getPrograms(){
	let program = $("#<portlet:namespace/>program").val();
	$.ajax({
		url: '${getProgramsURL}',
		type: 'POST',
		data:
			{
				<portlet:namespace/>program: program
			},
		success: function(data)	
		{
			let jsondata = JSON.parse(data);
			$("#<portlet:namespace/>sharedProgramId").empty();
			$("#<portlet:namespace/>sharedProgramId").append('<option class="placeholder" selected="" value="0"> <liferay-ui:message key=" please-select-program" /> </option>');
			for(let i=0; i<jsondata.length; i++){
				$("#<portlet:namespace/>sharedProgramId").append("<option value='"+jsondata[i].programMasterId+"'>" + jsondata[i].ProgramName + "</option>");
			}
		}
	});
}
</script>