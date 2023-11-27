<%@ include file="../init.jsp"%>

	<!-- Modal -->
		<div class="modal fade omsb-modal" id="initiateModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<aui:form action="${quivalencyWorkflowURL}" name="initiateEqWf" enctype="multipart/form-data">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="comments"/></h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="resetStatusType();">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<aui:input type="hidden" name="initiationWfTransitionName" value="<%=EquivalencyWorkflowStatusEnum.INITIATE.getText() %>" />
										<aui:input type="hidden" name="initiateEqId" value="${equivalencyRequest.getEquivalencyRequestId()}" />
										<aui:input type="hidden" name="initiatePersonId" value="${equivalencyRequest.personId}" />
										<textarea class="comments admin-initiate-comment" required="required"
                                    			name="<portlet:namespace />comments" rows="5" id="admin-initiate-comment">
										</textarea>
									</div>
									<p id="errorContainer-initiateText" class="error-container"></p>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label><liferay-ui:message key="case-report-attachment" /></label>
										<div class="custom-file">
											<aui:input id="customFile" name="caseReportFile" type="file" label=""
												cssClass="attachment form-control" required="" multiple="true"  /> 
											<label class="custom-file-label" for='<portlet:namespace/>customFile'></label>
											<p class="d-none file" style="color:red;">
													<liferay-ui:message key="please-select-a-file" />
											</p>
										</div>
									</div>
								</div>
								<div class="col-md-10">
									<div class="form-group">
										<label><liferay-ui:message key="attachment"></liferay-ui:message></label>
										<div class="initiate-multi-file d-none">
											<aui:input name="initiateMultiFile" type="file" label=""
												cssClass="attachment form-control" required="" multiple="true"  /> 
										</div>
										<div class="custom-file">
											<aui:input id="additionalAttachment" name="additionalAttachment" type="file" label=""
												cssClass="attachment form-control" required="" multiple="true"  /> 
											<label class="custom-file-label" for='<portlet:namespace/>additionalAttachment'></label>
											<p class="d-none file" style="color:red;">
													<liferay-ui:message key="please-select-a-file" />
											</p>
										</div>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label></label> <!-- Adding empty for managing space -->
										<button type="button" class="omsb-bc-red-button add-init-files"><liferay-ui:message key="add" /></button>
									</div>
								</div>
								<div class="col-md-12 file-table d-none">
									<table class="display omsb-datatables" id="add-multiple-files-init-table">
										<thead>
											<tr>
												<th><liferay-ui:message key="file" /></th>
												<th><liferay-ui:message key="action" /></th>
											</tr>
										</thead>
										<tbody class="add-files-body">
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button class="btn omsb-bc-red-button" type="button" title="send-to-committee" onclick="validateInitiateDocument()">
								<liferay-ui:message key="send-to-committee" />
							</button>
							<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" onclick="resetStatusType();">
								<liferay-ui:message key="cancel" />
							</button>
						</div>
					</div>
				</aui:form>
			</div>
		</div>
<script>
	$('.add-init-files').on('click', function(){
		const selectedFileName = '<portlet:namespace />additionalAttachment';
		const finalFileName = '<portlet:namespace />initiateMultiFile';
		const input = document.getElementById(finalFileName);
		const tableId = 'add-multiple-files-init-table';
		addMultiFiles(selectedFileName,tableId ,input, finalFileName);
	});
	
	function validateInitiateDocument(){
		var error = false;
		
		var A = AUI();
		var intiateText = $('#admin-initiate-comment').siblings('.richText-editor').text(); // Use trim() to remove whitespacex
		var intiateText=String(intiateText).replaceAll('\t','');
		if (!intiateText) {
			document.getElementById('errorContainer-initiateText').textContent = "<liferay-ui:message key='please-enter-text-in-text-field' />";
			error = true;
		}else{
			document.getElementById('errorContainer-initiateText').textContent = "";
		}
		if (!error) {
			 $('#<portlet:namespace />initiateEqWf').submit();
			 closeModal();
		}
	}
	
</script>