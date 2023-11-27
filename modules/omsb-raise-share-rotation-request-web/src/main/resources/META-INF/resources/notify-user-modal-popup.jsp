<%@ include file="init.jsp"%>

<div class="modal fade omsb-modal" id="notifyauthorizeduser"
	tabindex="-1" role="dialog" aria-labelledby="notifyauthorizeduserTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="raise-a-share-request-rotation" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<ul class="omsb-notification-lists" id="userList">
						<li class="omsb-comment-box mb-1">
							<div class="omsb-notification-box">
								<c:forEach items="${programUserDetailsMap}" var="userDetails">
									<c:choose>
										<c:when
											test="${requestRaisedToUserMap.get(userDetails.key) == true}">
											<div class="custom-control custom-checkbox">
												<input type="checkbox" class="custom-control-input user-checkbox-control"
													name="<portlet:namespace/>requestRaisedTo"
													id="<portlet:namespace/>requestRaisedTo"
													value="${userDetails.key}" checked="checked" /> <label
													class="custom-control-label"
													onclick='validateRaiseRequestBtn(this, false)'
													for="<portlet:namespace/>requestRaisedTo"></label>
											</div>
										</c:when>
										<c:otherwise>
											<input type="checkbox" class="custom-control-input user-checkbox-control"
												name="<portlet:namespace/>requestRaisedTo"
												id="<portlet:namespace/>requestRaisedTo"
												value="${userDetails.key}" onclick='validateRaiseRequestBtn(this, false)' />
										</c:otherwise>
									</c:choose>
									<div class="omsb-notification-img">
										<img src="${programUserImageMap.get(userDetails.key)}"
											alt="<liferay-ui:message key="user-logo" />">
									</div>
									<div class="omsb-notification-dtls">
										<h6>${userDetails.value}</h6>
									</div>
								</c:forEach>
							</div>
						</li>
					</ul>
				</div>
				<div class="row pt-3">
					<div class="col-lg-6 col-md-6 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message
								key="current-capacity" /></label> <label class="label-content"
							id="currentCapacity"></label>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="form-group">
							<aui:input label="no-of-trainees"
								class="custom-select form-control" type="number"
								name="noOfTraineesRequested" min="1" step="1" max="" value="${sharedRotationRequestDetail.noOfTraineesRequested}">
								<aui:validator name="required" />
							</aui:input>

						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="form-submit-btn" class="btn omsb-bg-red-button" type="submit">
					<liferay-ui:message key="raise-a-request" />
				</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal">
					<liferay-ui:message key="cancel" />
				</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	$("#form-submit-btn").attr("disabled","true");
	$("#form-re-submit-btn").attr("disabled","true");
})

function validateRaiseRequestBtn(element, isReRequest){
	if(isReRequest) {
		if($('.user-re-checkbox-control:checked').length > 0){
			$("#form-re-submit-btn").removeAttr("disabled");
		} else {
			$("#form-re-submit-btn").attr("disabled","true");
		}
	} else {
		if($('.user-checkbox-control:checked').length > 0){
			$("#form-submit-btn").removeAttr("disabled");
		} else {
			$("#form-submit-btn").attr("disabled","true");
		}
	}
}
</script>
