<%@ include file="init.jsp" %>
<portlet:resourceURL id="/clone/programcohort" var="cloneProgramCohortCommand" />

<!-- Modal -->
<div class="modal fade" id="allTraineeTakenLeaveForCurrentYearInformationModel" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="warning" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div>
							<p><liferay-ui:message key="error-all-trainee-needs-to-book-annual-leave" /></p>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-btn omsb-bc-red-button" type="button" title="Confirm" data-dismiss="modal"><liferay-ui:message key="ok" /></button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="cloneProgramCohort" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="clone-program-cohort" /></h5>
			</div>
			<aui:form action="#" name="cloneProgramCohortFm">
				<div class="modal-body">
					<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-12">
								<aui:select id="clone-program-id" name="clone-program" onchange = "getDistinctCohort()" label="select-a-program" localized="true" cssClass="custom-select form-control" ignoreRequestValue="false" value="${programMasterId}">
									<aui:validator name="required" />
								</aui:select>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<aui:select id="clone-cohort" name="clone-cohort" label="cohort" localized="true" cssClass="custom-select form-control" ignoreRequestValue="false">
									<aui:validator name="required" />
								</aui:select>
							</div>
					</div>
				</div>
				<div class="modal-footer">
					<aui:input label="old-program-duration-id" type="hidden" name="oldProgramDurationId"  value="0" />
					<button class="btn omsb-btn omsb-bc-red-button" type="button" title="clone" onclick="cloneProgramCohort()"><liferay-ui:message key="clone" /></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" id="cancelCloneCohort"><liferay-ui:message key="cancel" /></button>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div class="modal fade" id="successModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="success" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div>
								<p id="successMessage"></p>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" ><liferay-ui:message key="ok" /></button>
				</div>
		</div>
	</div>
</div>

<script>
function cloneProgramCohort(){
	$('#block-creation-loader').addClass('d-flex').removeClass('d-none');
	$.ajax({
		url : '${cloneProgramCohortCommand}',
		type : 'POST',
		data : {
			<portlet:namespace/>newProgramMasterId : $("#<portlet:namespace/>clone-program-id").val(),
			<portlet:namespace/>oldProgramDurationId : $("#<portlet:namespace/>oldProgramDurationId").val(),
			<portlet:namespace/>cohort : $("#<portlet:namespace/>clone-cohort").val()
		},
		success : function(payload) {

			$('#block-creation-loader').addClass('d-none').removeClass('d-flex');
			if(payload.success) {
				$("#cancelCloneCohort").click();
				$("#successMessage").html(`<liferay-ui:message key="program-cohort-cloned-successfully" />`);
				$("#successModal").modal("show");
			} else {
				/* Error Popup */
			}
		}
	});
}
</script>