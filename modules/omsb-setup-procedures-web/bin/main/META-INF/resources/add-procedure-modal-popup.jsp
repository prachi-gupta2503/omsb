<%@ include file="init.jsp"%>

<!-- Modal -->
<div class="modal fade omsb-modal" id="addProcedureMasterModal"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document"
		style="max-width: 715px;">
		<aui:form name="fm-procedure"
			onSubmit="event.preventDefault(); saveProcedureMaster();">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addMasterModalLongTitle">
						<liferay-ui:message key="add-procedure" />
					</h5>
					<button type="button" id="procedureCloseBtn" class="close"
						data-dismiss="modal" aria-label="Close" onclick="this.form.reset()">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row form-group-procedure">
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
								<aui:select cssClass="custom-select form-control col-11 js-basic-single"
									label="procedure-group" name="procedureGroupModal">
									<aui:option value="0" selected="true">
										<liferay-ui:message key="please-select-procedure-group" />
									</aui:option>
									<c:forEach items="${allProcedureGroups}" var="procedureGroup">
										<aui:option value="${procedureGroup.procedureGroupMasterId}">${procedureGroup.getProcedureGroupName(locale)}</aui:option>
									</c:forEach>
								</aui:select>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<aui:input localized="true" label="procedure-name" type="text"
									name="procedureName" placeholder="enter-procedure-name"
									ignoreRequestValue="true">
									<aui:validator name="required" />
									<aui:validator name="maxLength">500</aui:validator>
								</aui:input>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<aui:input localized="true" label="cpt-code" type="text"
									name="cptCodeName" placeholder="enter-cpt-code-name"
									ignoreRequestValue="true" />
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button" type="submit"
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

<script type="text/javascript">
	$('.js-basic-single').select2();
</script>
