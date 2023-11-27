<%@ include file="../init.jsp"%>
<!-- Modal -->
		<div class="modal fade omsb-modal" id="markInsufficientModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<aui:form action="${quivalencyWorkflowURL}" name="markInsufficientEqWf" enctype="multipart/form-data">
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
										<aui:input type="hidden" name="markInsufficientWftransitionName" value="<%=EquivalencyWorkflowStatusEnum.INSUFFICENT.getText() %>" />
										<aui:input type="hidden" name="markInsufficientEqId" value="${equivalencyRequest.getEquivalencyRequestId()}" />
										<textarea class="comments admin-insuf-comment" required="required"
	                                    		name="<portlet:namespace />comments" rows="8" id="admin-insufficient-comment">
										</textarea>
									</div>
									<p id="errorContainer-insufficientText" class="error-container"></p>
								</div>
								<div class="col-md-10">
									<div class="form-group">
										<label><liferay-ui:message key="attachment"></liferay-ui:message></label>
										<div class="custom-file">
											<aui:input name="additionalInsufAttachment" type="file" label=""
												cssClass="attachment form-control"  /> 
											<div class="d-none">
												<aui:input name="insufMultiFile" type="file" label=""
												cssClass="attachment form-control"  />
											</div>	
											<label class="custom-file-label" for='<portlet:namespace />additionalInsufAttachment'></label>
											<p class="d-none file" style="color:red;">
													<liferay-ui:message key="please-select-a-file" />
											</p>
										</div>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label></label> <!-- Adding empty for managing space -->
										<button type="button" class="omsb-bc-red-button add-insuf-files"><liferay-ui:message key="add" /></button>
									</div>
								</div>
								<!-- <div class="col-md-12">
									<p id="errorContainer-insufMultiFile" class="error-container"></p>
								</div> -->
								<div class="col-md-12 file-table d-none">
									<table class="display omsb-datatables" id="add-insuf-multiple-files-table">
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
							<button class="btn omsb-bc-red-button" onclick="validateInsufficientDocument()" type="button" title="Mark Insufficient">
								<liferay-ui:message key="mark-insufficient" />
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
	$(document).ready(function(){
		$('.admin-insuf-comment').richText();
	});
	
	$('.add-insuf-files').on('click', function(){
		const selectedFileName = '<portlet:namespace />additionalInsufAttachment';
		const finalFileName = '<portlet:namespace />insufMultiFile';
		const input = document.getElementById(finalFileName);
		const tableId = 'add-insuf-multiple-files-table';
		addMultiFiles(selectedFileName,tableId ,input, finalFileName);
	});
	
	function validateInsufficientDocument(){
		var A = AUI();
		var insufficientText = A.one("#admin-insufficient-comment").val();
		/* var insufMultiFile = document.getElementById("<portlet:namespace />insufMultiFile").files[0]; */
		
		var error = false;
		insufficientText=String(insufficientText).replaceAll('\t','');
		if (!insufficientText) {
			document.getElementById('errorContainer-insufficientText').textContent = "<liferay-ui:message key='please-enter-text-in-text-field' />";
			error = true;
		}else{
			document.getElementById('errorContainer-insufficientText').textContent = "";
		}
		/* if (!insufMultiFile) {
			document.getElementById('errorContainer-insufMultiFile').textContent = "<liferay-ui:message key='please-select-a-file' />";
			error = true;
		}else{
			document.getElementById('errorContainer-insufMultiFile').textContent = "";
		} */
		if (!error) {
			 $('#<portlet:namespace />markInsufficientEqWf').submit();
			 closeModal();
		}
	}
</script>
