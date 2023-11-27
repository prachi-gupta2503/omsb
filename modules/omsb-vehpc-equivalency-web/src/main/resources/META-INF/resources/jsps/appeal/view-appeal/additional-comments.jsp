
<portlet:actionURL name="<%= MVCCommandNames.SAVE_APPEAL_COMMENTS%>" var="saveAppealCommentsURL" />	
<!--Modal -->
<aui:form name="additional_comments_fm" action="${saveAppealCommentsURL }" method="post" enctype="multipart/form-data">
	<div class="modal fade omsb-modal" id="additionalCommentsModal" tabindex="-1" role="dialog"
		aria-labelledby="additionalCommentsModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="additionalCommentsModalCenterTitle"><liferay-ui:message key="add-comments" /></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<aui:input type="hidden" name="classPK" id="classPK" value="${equivalencyRequestId}" />
						<aui:input type="hidden" name="appealId" id="appealId" value="${appealId}" />
						<aui:input type="hidden" name="statusId" id="eqStatusKey" value="${appealStatusId}" />
						<aui:input type="hidden" name="personId" id="personId" value="${personId}" />
						<aui:input type="hidden" name="commentType" id="commentType" value="<%=OmsbVehpcEquivalencyWebPortletKeys.ADDITIONAL_DOCUMENTS_TYPE%>" />
						<div class="col-md-12">
							<div class="form-group ">
								<textarea onkeyup="countChar(this)" class="comments additional-comments" required="required"
                                  		name="<portlet:namespace />additionalComments" rows="5" id="additionalComments">
								</textarea>
							</div>
							<p id="errorContainer-additionalComments" class="error-container"></p>
						</div>
						<%-- <div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="attachment"></liferay-ui:message></label>
								<div class="custom-file">
									<aui:input id="additionalCommentsFile" name="additionalCommentsFile" type="file" label=""
										cssClass="attachment form-control" required="" multiple="true"  /> 
									<label class="custom-file-label" for='<portlet:namespace/>additionalCommentsFile'></label>
									<p class="d-none file" style="color:red;">
										<liferay-ui:message key="please-select-a-file" />
									</p>
								</div>
							</div>
						</div> --%>
						<div class="col-md-10">
							<div class="form-group">
								<label><liferay-ui:message key="attachment"></liferay-ui:message></label>
								<div class="custom-file">
									<aui:input id="additionalAdminAttachment" name="additionalAdminAttachment" type="file" label=""
											cssClass="attachment form-control"  /> 
										<div class="d-none">
											<aui:input id="multiAdminFile" name="additionalCommentsFile" type="file" label=""
											cssClass="attachment form-control"  />
										</div>	
										<label class="custom-file-label" for='<portlet:namespace />additionalAdminAttachment'></label>
										<p class="d-none file" style="color:red;">
												<liferay-ui:message key="please-select-a-file" />
										</p>
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<label></label>
								<!-- Adding empty for managing space -->
								<button type="button" id="add-files-admin-comments" class="omsb-bc-red-button .add-files-admin-comments">
									<liferay-ui:message key="add" />
								</button>
							</div>
						</div>
						<div class="col-md-12 file-table d-none">
							<table class="display omsb-datatables"
								id="add-multiple-files-table-admin">
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
						<div class="col-md-12">
							<div class="custom-control custom-checkbox">
					    		<input type="checkbox" name ="<portlet:namespace />addCheckbox" checked="checked" id="addCheckbox" class="custom-control-input">
					    		<label class="custom-control-label m-3" for="addCheckbox"><liferay-ui:message key="notify-to-committee-members"/></label>
					    	</div>
				    	</div>
						<!-- <div class="col-md-12" >
							<div class="custom-file mb-3">
								<input type="file" name="additionalCommentsFile" class="custom-file-input" multiple="multiple">
								<label class="custom-file-label" id="add_comments_label" for="additionalCommentsFile"></label>
							</div>	
						</div> -->
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-bc-red-button"  title="save-comments" onclick="validateAdminCommentsAndSave()">
						<liferay-ui:message key="save" />
					</button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal">
						<liferay-ui:message key="cancel" />
					</button>
				</div>
			</div>
		</div>
	</div>
</aui:form>
<!--Modal -->
<script>
	$('.additional-comments').richText();
	function validateAdminCommentsAndSave() {
		  
		var error = false;
		var additionalComments = document.getElementById("additionalComments").value.trim();
		if (!additionalComments) {
			error = true;
		}
			
		if (error) {
			document.getElementById("errorContainer-additionalComments").textContent = "<liferay-ui:message key='please-add-valid-comments' />";
		}
		$("#additionalCommentsModal").modal('hide');
	}
	
	$('#add-files-admin-comments').on('click', function(){
		const additionalAdminAttachmentId = '<portlet:namespace />additionalAdminAttachment';
		const multiAdminFileId = '<portlet:namespace />multiAdminFile';
		const adminInput = document.getElementById(multiAdminFileId);
		const adminCommentTableId = 'add-multiple-files-table-admin';
		addMultiFiles(additionalAdminAttachmentId,adminCommentTableId ,adminInput, multiAdminFileId);
	});
</script>