<%@ include file="../init.jsp"%>
<!-- Modal -->
<portlet:resourceURL id="<%=MVCCommandNames.ADD_MULTIPLE_FILES_TABLE_DATA_RESOURCE%>" var="addMultipleFilesURL">
</portlet:resourceURL>
		<div class="modal fade omsb-modal" id="adminInProgress" tabindex="-1" role="dialog"
			aria-labelledby="adminInProgressModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<aui:form action="${adminInProgressURL}" name="adminInProgress_fm" >
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="adminInProgressModalLongTitle"><liferay-ui:message key="comments"/></h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="resetStatusType();">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<aui:input type="hidden" name="equivalencyRequestId" value="${equivalencyRequest.getEquivalencyRequestId()}" />
										<textarea onkeyup="countChar(this)" class="comments admin-in-progress-comment" required="required"
	                                    			name="<portlet:namespace />comments" rows="8" id="admin-initiate-comment">
										</textarea>
									</div>
								</div>
								<div class="col-md-10">
									<div class="form-group">
										<label><liferay-ui:message key="attachment"></liferay-ui:message></label>
										<div class="custom-file">
											<aui:input id="additionalAttachment1" name="additionalAttachment" type="file" label=""
												cssClass="attachment form-control"  /> 
											<div class="d-none">
												<aui:input id="multiFile" name="adminInProgressAttachment" type="file" label=""
												cssClass="attachment form-control"  />
											</div>	
											<label class="custom-file-label" for='<portlet:namespace />additionalAttachment1'></label>
											<p class="d-none file" style="color:red;">
													<liferay-ui:message key="please-select-a-file" />
											</p>
										</div>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label></label> <!-- Adding empty for managing space -->
										<button type="button" class="omsb-bc-red-button add-files"><liferay-ui:message key="add" /></button>
									</div>
								</div>
								<div class="col-md-12 file-table d-none">
									<table class="display omsb-datatables" id="add-multiple-files-table">
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
							<button class="btn omsb-bc-red-button" type="submit" onclick="closeModal();" title="Admin(In Progress)">
								<liferay-ui:message key="inprogress-admin" />
							</button>
							<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" onclick="resetStatusType();">
								<liferay-ui:message key="cancel" />
							</button>
						</div>
					</div>
				</aui:form>
			</div>
		</div>
		<!--// Comments pop up -->
		
<script>
	$('.add-files').on('click', function(){
		const selectedFileName = '<portlet:namespace />additionalAttachment1';
		const finalFileName = '<portlet:namespace />multiFile';
		const input = document.getElementById(finalFileName);
		const tableId = 'add-multiple-files-table';
		addMultiFiles(selectedFileName,tableId ,input, finalFileName);
	});
	
</script>