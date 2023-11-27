<%@ include file="init.jsp"%>

<!-- Modal -->
<div class="modal fade omsb-modal" id="addProcedureGroupMasterModal"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document"
		style="max-width: 715px;">
		<aui:form name="fm-procedure-group"
			onSubmit="event.preventDefault(); saveProcedureGroupMaster();" >
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addMasterModalLongTitle">
						<liferay-ui:message key="add-procedure-group" />
					</h5>
					<button type="button" id="procedureGroupCloseBtn" class="close"
						data-dismiss="modal" aria-label="Close" onclick="this.form.reset()">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row form-group-procedure-group">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group-view form-group-view-program">
								<div class="label-name">
									<liferay-ui:message key="program" />
								</div>
								<div class="label-content"></div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group-view form-group-view-cohort">
								<div class="label-name">
									<liferay-ui:message key="program-cohort" />
								</div>
								<div class="label-content"></div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<aui:input localized="true" label="procedure-group-name"
									type="text" name="procedureGroupName"
									placeholder="enter-procedure-group-name"
									ignoreRequestValue="true">
									<aui:validator name="required" />
								</aui:input>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button
						class="btn omsb-btn omsb-bc-red-button save-procedure-group-btn"
						type="submit" title="save">
						<liferay-ui:message key="save" />
					</button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal" onclick="this.form.reset()">
						<liferay-ui:message key="cancel" />
					</button>
				</div>
		</aui:form>
	</div>
	</div>
</div>
