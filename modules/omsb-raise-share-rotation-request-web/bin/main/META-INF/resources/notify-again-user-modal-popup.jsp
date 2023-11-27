<%@ include file="init.jsp"%>

<div class="modal fade omsb-modal" id="notifyagainauthorizeduser"
	tabindex="-1" role="dialog" aria-labelledby="notifyauthorizeduserTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<aui:form action="${saveShareRotationRequestActionURL}" method="post"
				name="refm">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						<liferay-ui:message key="notify-site-authorized-user" />
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<aui:input name="reSharedRotationRequestId" type="hidden" value="" />
						<aui:input name="isRaisedAgain" type="hidden" value="false" />
						<ul class="omsb-notification-lists" id="reUserList">
							<li class="omsb-comment-box mb-1">
								<div class="omsb-notification-box">
									<c:forEach items="${programUserDetailsMap}" var="userDetails">
										<c:choose>
											<c:when
												test="${requestRaisedToUserMap.get(userDetails.key) == true}">
												<div class="custom-control custom-checkbox">
													<input type="checkbox" class="custom-control-input user-re-checkbox-control"
														name="<portlet:namespace/>requestRaisedTo"
														id="<portlet:namespace/>requestRaisedTo"
														value="${userDetails.key}" checked="checked" onclick='validateRaiseRequestBtn(this,true)'> <label
														class="custom-control-label"
														for="<portlet:namespace/>requestRaisedTo"></label>
												</div>
											</c:when>
											<c:otherwise>
												<input type="checkbox" class="custom-control-input user-re-checkbox-control"
													name="<portlet:namespace/>requestRaisedTo"
													id="<portlet:namespace/>requestRaisedTo"
													value="${userDetails.key}" onclick='validateRaiseRequestBtn(this,true)' >
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
								id="reCurrentCapacity"></label>
						</div>
						<div class="col-lg-6 col-md-6">
							<div class="form-group">
								<aui:input label="no-of-trainees"
									class="custom-select form-control" type="number"
									name="reNoOfTraineesRequested" min="1" step="1" max="">
									<aui:validator name="required" />
								</aui:input>

							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button id="form-re-submit-btn" class="btn omsb-bc-red-button" type="submit">
						<liferay-ui:message key="raise-a-request" />
					</button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal">
						<liferay-ui:message key="cancel" />
					</button>
				</div>
			</aui:form>
		</div>
	</div>
</div>
