<%@ include file="init.jsp"%>

<!-- Modal -->
<div class="modal fade omsb-modal" id="addVisitTypeMasterModal"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document"
		style="max-width: 715px;">
		<aui:form action="${saveProcedureLoggingParameters}"
			name="master-form-visit" method="post" >
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addMasterModalLongTitle">
						<liferay-ui:message key="add-visit-type" />
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" onclick="this.form.reset()">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row form-group-procedure-group">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group-view" id="progName">
								<div class="label-name">
									<liferay-ui:message key="program" />
								</div>
								<div class="label-content"></div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group-view" id="progCohort">
								<div class="label-name">
									<liferay-ui:message key="program-cohort" />
								</div>
								<div class="label-content"></div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<aui:input type="hidden"
									name="<%=OmsbSetupProceduresWebPortletKeys.MASTER_VALUE%>"
									value="<%=OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_NAME%>" />
								<aui:input type="hidden"
									name="<%=OmsbSetupProceduresWebPortletKeys.IS_CREATE%>"
									value="<%=Boolean.TRUE%>" />
								<aui:input type="hidden"
									name="<%=OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_FOR_VISIT%>"
									value="" />
								<aui:input localized="true" label="visit-type-name" type="text"
									name="visitTypeName" placeholder="enter-visit-type-name"
									ignoreRequestValue="true">
									<aui:validator name="required" />
									<aui:validator name="maxLength">200</aui:validator>
								</aui:input>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button" type="submit"
						onclick='$(".loader-container").addClass("d-flex").removeClass("d-none");'
						title="save">
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
