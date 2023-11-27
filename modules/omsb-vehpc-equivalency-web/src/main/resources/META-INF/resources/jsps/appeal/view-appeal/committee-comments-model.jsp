
<%@page import="omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys"%>
<portlet:actionURL name="<%= MVCCommandNames.SAVE_APPEAL_COMMENTS%>" var="saveAppealCommentsURL" />	
<!--Modal -->
<aui:form name="appeal_additional_comments_fm" action="${saveAppealCommentsURL }" method="post" enctype="multipart/form-data">
	<div class="modal fade omsb-modal" id="committeeCommentsModal" tabindex="-1" role="dialog"
		aria-labelledby="committeeCommentsModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<aui:input type="hidden" name="classPK" id="classPK" value="${equivalencyRequestId}" />
			<aui:input type="hidden" name="appealId" id="appealId" value="${appealId}" />
			<aui:input type="hidden" name="statusId" id="eqStatusKey" value="${appealStatusId}" />
			<aui:input type="hidden" name="personId" id="personId" value="${personId}" />
			<aui:input type="hidden" name="commentType" id="commentType" value="<%=OmsbVehpcEquivalencyWebPortletKeys.COMMITTEE_COMMENTS_DOCUMENTS_TYPE%>" />
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="committeeCommentsModalCenterTitle"><liferay-ui:message key="add-comments" /></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
	                            <div class="form-group">
	                                <label><liferay-ui:message key="equivalency-certificate" /></label>
	                                <select name="<portlet:namespace />equivalencyCertificate" id="equivalencyCertificate" class="custom-select form-control">
	                                    <option value=""><liferay-ui:message key="select" /></option>
	                                    <c:forEach items="${certificatesList}" var="certificate">
	                                        <option value="${certificate.decisionLevelId}">
	                                        	 ${certificate.certificateName}
	                                        </option>
	                                    </c:forEach>
	                                </select>
	                            </div>
	                        </div>
	                        <div class="col-md-12">
	                            <div class="form-group">
	                                <label><liferay-ui:message key="equivalency-level" /></label>
	                                <select name="<portlet:namespace />equivalencyLevel" id="equivalencyLevel" class="custom-select form-control">
	                                    <option value=""><liferay-ui:message key="select" /></option>
	                                    <c:forEach items="${eqLevelList}" var="eqLevel">
	                                        <option value="${eqLevel.getKey()}">
	                                            <liferay-ui:message key="${eqLevel.getName(themeDisplay.getLocale())}" />
	                                        </option>
	                                    </c:forEach>
	                                </select>
	                            </div>
	                        </div>
	                        <div class="col-md-12 d-none eq-level-reason">
                                <div class="form-group">
                                    <label><liferay-ui:message key="equivalency-level-reason" /></label>
                                    <select name="<portlet:namespace />equivalencyLevelReason" id="equivalencyLevelReason" class="custom-select form-control">
                                        <option value=""><liferay-ui:message key="select" /></option>
                                        <c:forEach items="${eqLevelReasonList}" var="eqLevelReason">
                                            <option value="${eqLevelReason.getKey()}">
                                                <liferay-ui:message key="${eqLevelReason.getName(themeDisplay.getLocale())}" />
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
						<div class="col-md-12">
							<div class="form-group ">
								<textarea onkeyup="countChar(this)" class="comments committee-comments" required="required"
                                  		name="<portlet:namespace />additionalComments" rows="5" id="additionalComments">
								</textarea>
							</div>
							<p id="errorContainer-additionalComments" class="error-container"></p>
						</div>
						<%-- <div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="attachment"></liferay-ui:message></label>
								<div class="custom-file">
									<aui:input id="committeeCommentsFile" name="committeeCommentsFile" type="file" label=""
										cssClass="attachment form-control" required="" multiple="true"  /> 
									<label class="custom-file-label" for='<portlet:namespace/>committeeCommentsFile'></label>
									<p class="d-none file" style="color:red;">
											<liferay-ui:message key="please-select-a-file" />
									</p>
								</div>
							</div>
						</div>  --%>
						<div class="col-md-10">
							<div class="form-group">
								<label><liferay-ui:message key="attachment"></liferay-ui:message></label>
								<div class="custom-file">
									<aui:input id="additionalCommitteeAttachment" name="additionalCommitteeAttachment" type="file" label=""
											cssClass="attachment form-control"  /> 
										<div class="d-none">
											<aui:input id="multiCommitteeCommentsFile" name="committeeCommentsFile" type="file" label=""
											cssClass="attachment form-control"  />
										</div>	
										<label class="custom-file-label" for='<portlet:namespace />additionalCommitteeAttachment'></label>
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
								<button type="button" id="add-files-committee-comments" class="omsb-bc-red-button add-files-committee-comments">
									<liferay-ui:message key="add" />
								</button>
							</div>
						</div>
						<div class="col-md-12 file-table d-none">
							<table class="display omsb-datatables"
								id="add-multiple-files-table-committee">
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
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-bc-red-button" title="save-comments" onclick="validateCommitteeCommentsAndSave()">
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
	$('.committee-comments').richText();
	function validateCommitteeCommentsAndSave() {
		  
		var error = false;
		var additionalComments = document.getElementById("additionalComments").value.trim();
		if (!additionalComments) {
			error = true;
		}
			
		if (error) {
			document.getElementById("errorContainer-additional-comments").textContent = "<liferay-ui:message key='please-add-valid-comments' />";
		}
		$("#committeeCommentsModal").modal('hide');
	}

	$('#equivalencyLevel').on('change', function() {
		if ($(this).val() == 'none') {
			$('#equivalencyLevelReason').closest('.eq-level-reason').removeClass('d-none');
		} else {
		    $('#equivalencyLevelReason').closest('.eq-level-reason').addClass('d-none');
		}
	});
	$('#add-files-committee-comments').on('click', function(){
		const additionalCommitteeAttachmentId = '<portlet:namespace />additionalCommitteeAttachment';
		const multiCommitteeFileId = '<portlet:namespace />multiCommitteeCommentsFile';
		const committeeInput = document.getElementById(multiCommitteeFileId);
		const committeeCommentTableId = 'add-multiple-files-table-committee';
		addMultiFiles(additionalCommitteeAttachmentId,committeeCommentTableId ,committeeInput, multiCommitteeFileId);
	});
	
</script>