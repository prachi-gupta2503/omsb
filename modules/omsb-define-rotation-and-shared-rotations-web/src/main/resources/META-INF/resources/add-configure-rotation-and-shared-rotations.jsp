<%@page
	import="gov.omsb.define.rotation.and.shared.rotations.web.constants.OmsbDefineRotationAndSharedRotationsWebPortletKeys"%>
<%@ include file="/init.jsp"%>

<portlet:resourceURL id="/getProgramDurationURL"
	var="getProgramDurationURL" />
<portlet:resourceURL id="/getPrograms" var="getProgramsURL" />

<liferay-ui:error key="programNameError" message="duplicate-entry-found-define-rotation-for-shared-rotation" />
<liferay-ui:error key="programNameError" message="duplicate-entry-found-define-rotation-for-not-shared-rotation" />

<portlet:actionURL
	name="<%=OmsbDefineRotationAndSharedRotationsWebPortletKeys.SAVE_DRASR_MVC_ACTION_COMMAND%>"
	var="addDefineRotationAndSharedRotations">
	<portlet:param name="redirect" value="${currentURL}" />
</portlet:actionURL>

<portlet:renderURL var="editrender">
	<portlet:param name="mvcRenderCommandName" value="${}" />
	<portlet:param name="progdurationRotationTrainingsitesRelId" value="2" />
</portlet:renderURL>

<aui:form action="${addDefineRotationAndSharedRotations}" name="fm">
	<div class="row">
		<div class="col-md-12">
			<div class="omsb-card">
				<div class="omsb-page-top-info mb-4">
					<div class="pagetitle">
						<liferay-ui:message key="define-rotations-and-shared-rotations" />
					</div>
				</div>
				<div class="omsb-list-filter omsb-more-btn">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<aui:select id="program" name="program" label="select-program"
								localized="true" cssClass="custom-select form-control"
								onChange="setProgramAndProgramDuration()">
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
							<aui:select id="progDurationId" name="progDurationId"
								label="cohort" localized="true"
								cssClass="custom-select form-control">
								<aui:option value="0" selected="true" cssClass="placeholder">
									<liferay-ui:message key="please-select-cohort" />
								</aui:option>
								<aui:validator name="required" />
							</aui:select>
						</div>

						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:select id="rotationMasterId" name="rotationMasterId"
									label="select-rotation" localized="true"
									cssClass="custom-select form-control">
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
							<aui:select id="isSharedRotation" name="isSharedRotation"
								label="is-shared-rotation" localized="true"
								class="custom-select form-control">
								<aui:option value="false" localized="true">
									<liferay-ui:message key="no" />
								</aui:option>
								<aui:option value="true" localized="true">
									<liferay-ui:message key="yes" />
								</aui:option>
								<aui:validator name="required" />
							</aui:select>
						</div>

						<div class="col-lg-6 col-md-6 col-sm-12" id="selectprogramWrap">
							<aui:select id="sharedProgramId" name="sharedProgramId"
								label="shared-program" localized="true"
								cssClass="custom-select form-control">
								<aui:option value="0" selected="true" cssClass="placeholder">
									<liferay-ui:message key="please-select-shared-program" />
								</aui:option>
							</aui:select>
						</div>

						<div class="col-lg-6 col-md-6 col-sm-12"
							id="selecttrainingsiteWrap">
							<aui:select id="trainingSiteMasterId" name="trainingSiteMasterId"
								label="select-training-site" localized="true"
								cssClass="custom-select form-control">
								<aui:option value="0" selected="true" cssClass="placeholder">
									<liferay-ui:message key="please-select-training-site" />
								</aui:option>
								<c:forEach items="${trainingSiteMasterList}" var="traningSite">
									<aui:option value="${traningSite.trainingSiteMasterId}">${traningSite.getTrainingSiteName(locale)}</aui:option>
								</c:forEach>
							</aui:select>
						</div>

						<div class="col-lg-6 col-md-6 col-sm-12" id="noofslotsWrap">
							<aui:input cssClass="form-control" label="no-of-slots"
								id="noOfSlots" type="number" name="noOfSlots">
							</aui:input>
						</div>

						<div class="col-lg-12 col-md-12">
							<div class="bottom-backbtn-wrap">
								<button class="btn omsb-bc-red-button" type="submit"
									title="Save">
									<liferay-ui:message key="save" />
								</button>
								<a class="btn omsb-btn omsb-bg-red-button" href="${home}"
									title="Cancel"> <liferay-ui:message key="cancel" />
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</aui:form>
<jsp:include page="/configure-rotation-and-shared-rotations-list.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
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

		$("#<portlet:namespace/>isSharedRotation").click(function() {
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

	function setProgramAndProgramDuration() {
		getProgramDuration();
		getPrograms();
	}

	function getProgramDuration() {
		let program = $("#<portlet:namespace/>program").val();
		$
				.ajax({
					url : '${getProgramDurationURL}',
					type : 'POST',
					data : {
						<portlet:namespace/>program : program
					},
					success : function(data) {
						let jsondata = JSON.parse(data);
						$("#<portlet:namespace/>progDurationId").empty();
						$("#<portlet:namespace/>progDurationId")
								.append(
										'<option class="placeholder" selected="" value="0"> <liferay-ui:message key="please-select-cohort" /> </option>');
						for (let i = 0; i < jsondata.length; i++) {
							$("#<portlet:namespace/>progDurationId").append(
									"<option value='"+jsondata[i].progDurationId+"'>"
											+ jsondata[i].ayApplicableForm
											+ "</option>");
						}
					}
				});
	}

	function getPrograms() {
		let program = $("#<portlet:namespace/>program").val();
		$
				.ajax({
					url : '${getProgramsURL}',
					type : 'POST',
					data : {
						<portlet:namespace/>program : program
					},
					success : function(data) {
						let jsondata = JSON.parse(data);
						$("#<portlet:namespace/>sharedProgramId").empty();
						$("#<portlet:namespace/>sharedProgramId")
								.append(
										'<option class="placeholder" selected="" value="0"> <liferay-ui:message key="please-select-program" /> </option>');
						for (let i = 0; i < jsondata.length; i++) {
							$("#<portlet:namespace/>sharedProgramId").append(
									"<option value='"+jsondata[i].programMasterId+"'>"
											+ jsondata[i].ProgramName
											+ "</option>");
						}
					}
				});
	}
</script>