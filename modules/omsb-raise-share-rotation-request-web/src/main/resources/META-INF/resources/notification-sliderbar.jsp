<%@ include file="init.jsp"%>

<!-- Notification Sidebar -->
<div class="omsb-notification-sidebar" id="omsb-notification-sidebar">
	<div class="omsb-card">
		<div class="omsb-card-header">
			<h5 class="omsb-card-title"><liferay-ui:message key="request-details" /></h5>
			<button type="button" class="close sidebar-close-btn" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<div class="omsb-card-body">
			<div class="omsb-comment-box omsb-BorderRadius-4">
				<div class="omsb-comment-box-header">
					<h3><liferay-ui:message key="status" /></h3>
					<c:if test="${sharedRotationRequestDetails.status == 'Approved'}">
						<span class="omsb-complete-bg">${sharedRotationRequestDetails.status}</span>
					</c:if>
					<c:if
						test="${sharedRotationRequestDetails.status == 'Approved & Partially Alloted'}">
						<span class="omsb-appeal-bg">${sharedRotationRequestDetails.status}</span>
					</c:if>
					<c:if test="${sharedRotationRequestDetails.status == 'Rejected'}">
						<span class="omsb-insufficient-bg">${sharedRotationRequestDetails.status}</span>
					</c:if>
					<c:if test="${sharedRotationRequestDetails.status == 'Pending'}">
						<span class="omsb-reappeal-bg">${sharedRotationRequestDetails.status}</span>
					</c:if>
				</div>
			</div>
			<div class="omsb-comment-box pb-0 omsb-BorderRadius-4">
				<div class="omsb-notification-row">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group-view">
								<div class="label-name"><liferay-ui:message key="rotation" /></div>
								<div class="label-content">${rotationMap.get(sharedRotationRequestDetails.rotationId)}</div>
							</div>

						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 ">
							<div class="form-group-view">
								<div class="label-name"><liferay-ui:message key="cohort" /></div>
								<div class="label-content">${cohortMap.get(sharedRotationRequestDetails.programDurationId)}</div>
							</div>

						</div>
					</div>
				</div>
				<div class="omsb-notification-row">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group-view">
								<div class="label-name"><liferay-ui:message key="no-of-trainees" /></div>
								<div class="label-content">${sharedRotationRequestDetails.noOfTraineesRequested}</div>
							</div>

						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group-view">
								<div class="label-name"><liferay-ui:message key="approved" /></div>
								<div class="label-content">${sharedRotationRequestDetails.approvedCount}</div>
							</div>

						</div>
					</div>
				</div>
				<div class="omsb-notification-row">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group-view">
								<div class="label-name"><liferay-ui:message key="rejected" /></div>
								<div class="label-content">${sharedRotationRequestDetails.rejectedCount}</div>
							</div>

						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group-view">
								<div class="label-name"><liferay-ui:message key="request-raised-to" /></div>
								<div class="label-content">${raisedRequestToUserMap.get(sharedRotationRequestDetails.sharedRotationRequestDetailsId)}</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="bottom-backbtn-wrap">
			<c:if
				test="${(sharedRotationRequestDetails.status == 'Approved & Partially Alloted') || (sharedRotationRequestDetails.status == 'Rejected')}">
				<button class="btn omsb-bc-red-button request-again" type="button" data-target="#notifyagainauthorizeduser" data-toggle="modal"
					data-value="${sharedRotationRequestDetails.sharedRotationRequestDetailsId}"
					data-programdurationid="${sharedRotationRequestDetails.programDurationId}"
					data-estimatenooftraineesrequested="${sharedRotationRequestDetails.rejectedCount}"><liferay-ui:message key="request-again" /></button>
			</c:if>
			<button type="button" class="btn omsb-btn omsb-bg-red-button sidebar-close-btn" data-dismiss="modal"><liferay-ui:message key="cancel" /></button>
		</div>
	</div>
</div>
<!-- Notification Sidebar -->