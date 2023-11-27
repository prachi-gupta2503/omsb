<%@ include file="../../init.jsp"%>

<portlet:resourceURL id="<%=AppealConstants.SAVE_COMMITTEE_COMMENTS%>" var="saveCommitteeCommentsURL" />	
<!--Modal -->
<div class="modal fade omsb-modal" id="committeeCommentsModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="add-comments" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<aui:form name="asccFM" onSubmit="event.preventDefault();">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group  mb-0">
								<aui:input type="hidden" name="appealId" id="appealId" value="${appealId}" />
								<aui:input type="hidden" name="statusId" id="statusId" value="${appealStatusId}" />
								<textarea onkeyup="countChar(this)" class="comments appeal-committee-comments" required="required"
                                  		name="<portlet:namespace />committeeComments" rows="5" id="committeeComments">
								</textarea>
							</div>
							<p id="errorContainer-committeeComments" class="error-container"></p>
						</div>
						<div class="modal-footer">
							<button class="btn omsb-bc-red-button"  title="save-comments" onclick="validateAndSaveCommitteeComments()">
								<liferay-ui:message key="save" />
							</button>
							<button type="button" class="btn omsb-btn omsb-bg-red-button"
								data-dismiss="modal">
								<liferay-ui:message key="cancel" />
							</button>
						</div>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>
<!--Modal -->
<script>
	$(document).ready(function(){
		$('.appeal-committee-comments').richText();
	});
	
	function validateAndSaveCommitteeComments() {
		  
		var error = false;
		var committeeComments = document.getElementById("committeeComments").value.trim();
		if (!committeeComments) {
			error = true;
		}
			
		if (error) {
			document.getElementById("errorContainer-committeeComments").textContent = "<liferay-ui:message key='please-add-valid-comments' />";
		}else{
			var classPK = document.getElementById("<portlet:namespace />appealId").value.trim();
			var statusId = document.getElementById("<portlet:namespace />statusId").value.trim();
			
			$.ajax({
				url: '${saveCommitteeCommentsURL}',
				async : false,
				data : {
					<portlet:namespace />comments : committeeComments,
					<portlet:namespace />classPK : classPK,
					<portlet:namespace />statusId : statusId
				},
				type : 'POST',
				success : function(data) {
					location.reload()
				}
			})
		}
	}
</script>