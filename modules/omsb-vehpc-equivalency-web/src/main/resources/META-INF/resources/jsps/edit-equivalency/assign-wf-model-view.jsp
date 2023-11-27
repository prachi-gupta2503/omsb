<!-- Modal -->
<div class="modal fade omsb-modal" id="assignToMeModal"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="attach-case-report" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div class="form-group  mb-0">
							<aui:form action="${quivalencyWorkflowURL}" name="assignEqWf"
								enctype="multipart/form-data">
								<aui:input type="hidden" name="assignWfTransitionName"
									id="assignWfTransitionName" value="" />
								<aui:input type="hidden" name="assignEqId" value="" />

								<input type="button" name="btn" class="btn btn-primary mx-2"
									onClick="setTransition()"
									value='<liferay-ui:message key="assignToMe"/>'></input>

							</aui:form>


						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal">
					<liferay-ui:message key="cancel" />
				</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function setTransition() {
		$("#<portlet:namespace />assignEqWf").submit();
	}
</script>