<%@include file="../init.jsp" %>
<portlet:actionURL name="<%=MVCCommandNames.ADDITIONAL_COMMENTS_RESOURCE%>" var="saveAdditionalCommentsURL" />	
<!--Modal -->
<aui:form name="additional_comments_fm" action="${saveAdditionalCommentsURL }" method="post" enctype="multipart/form-data">
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
						<div class="col-md-12">
							<div class="form-group ">
								<aui:input type="hidden" name="classPK" id="classPK" value="${equivalencyRequest.getEquivalencyRequestId()}" />
								<aui:input type="hidden" name="eqStatusKey" id="eqStatusKey" value="${equivalencyRequest.getStatusKey()}" />
								<aui:input type="hidden" name="eqStatusName" id="eqStatusName" value="${equivalencyRequest.getStatus()}" />
								<textarea onkeyup="countChar(this)" class="comments additional-comments" required="required"
                                  		name="<portlet:namespace />additionalComments" rows="5" id="additionalComments">
								</textarea>
							</div>
							<p id="errorContainer-additionalComments" class="error-container"></p>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="attachment"></liferay-ui:message></label>
								<div class="custom-file">
									<aui:input id="file" name="additionalCommentsFile" type="file" label=""
										cssClass="attachment form-control" required="" multiple="true"  /> 
										<label class="custom-file-label" for='<portlet:namespace/>file'></label>
											<p class="d-none file" style="color:red;">
													<liferay-ui:message key="please-select-a-file" />
											</p>
								</div>
							</div>
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
					<button class="btn omsb-bc-red-button"  title="save-comments" onclick="validateAddCommentsAndSave()">
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
	function validateAddCommentsAndSave() {
		  
		var error = false;
		var additionalComments = document.getElementById("additionalComments").value.trim();
		if (!additionalComments) {
			error = true;
		}
			
		if (error) {
			document.getElementById("errorContainer-additionalComments").textContent = "<liferay-ui:message key='please-add-valid-comments' />";
		}
		$("#additionalCommentsModal").modal('hide');
		/* else{
			var classPK = document.getElementById("<portlet:namespace />classPK").value.trim();
			var eqStatusKey = document.getElementById("<portlet:namespace />eqStatusKey").value.trim();
			var eqStatusName = document.getElementById("<portlet:namespace />eqStatusName").value.trim();
			var fm = document.getElementById("<portlet:namespace />additional_comments_fm");
			var fmData = new FormData(fm);		
			$.ajax({
				url: '${saveAdditionalCommentsURL}',
				async : false,
				data : fmData, {
					<portlet:namespace />comments : additionalComments,
					<portlet:namespace />classPK : classPK,
					<portlet:namespace />eqStatusKey : eqStatusKey,
					<portlet:namespace />eqStatusName : eqStatusName,
					
				},
				type : 'POST',
				success : function(data) {
					location.reload()
				}
			})
		} */
	}
</script>