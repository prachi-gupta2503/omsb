<!-- Supporting Document Popup -->
	<div class="modal fade omsb-modal" id="addsupportingdocument" tabindex="-1" role="dialog"
			aria-labelledby="addsupportingdocumentTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="add-supporting-document"/></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label><liferay-ui:message key="document-title"/></label>
									<input type="text" name="Document Title" id="documentTitle" class="form-control">
									<input type="hidden" name="SuppDocAction" id="supp_doc_action" value="add" class="form-control">
									<input type="hidden" name="SuppRowClass" id="supp_doc_row_class" value="" class="form-control">
									<span class="text-danger d-none" id="title-error" ><liferay-ui:message key="this-field-is-required"/></span>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label><liferay-ui:message key="supporting-document"/></label>
									<div class="custom-file mb-3">
										<div>
											<input type="file" class="custom-file-input" id="supportingFile" name="supportingFile">
										</div>
										<label class="custom-file-label" id="popup_sd_file_label" for="supportingFile">
											<%-- <span class="uploader-value"></span>
											<span class="uploader-title"><liferay-ui:message key="select-file"/></span> --%>
										</label>
										<span class="text-danger d-none" id="file-error" ><liferay-ui:message key="this-field-is-required"/></span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" title="Add" onclick="addSupportingDocs();"><liferay-ui:message key="add"/></button>
						<button class="btn omsb-bc-red-button" type="button" title="Discard" onclick="discardSupportingDocChanges()"><liferay-ui:message key="discard"/></button>						
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal"><liferay-ui:message key="close"/></button>
					</div>
				</div>
			</div>
		</div>
		<!-- Supporting Document Popup Ends -->
		
		<!--delete popup  -->
		<div class="modal fade omsb-modal" id="delete_row" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						<liferay-ui:message key="delete-confirmation" />
					</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="omsb-card omsb-card-graybg row">
							<div>
								<liferay-ui:message key="are-you-want-to-delete" />
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteRow()" title="ok" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Delete Popup End -->s
		<script>
			function discardSupportingDocChanges() {
				$('#supportingFile').val('');
				$('#popup_sd_file_label').text('');
				$("#addsupportingdocument").modal("hide");
			}
		</script>