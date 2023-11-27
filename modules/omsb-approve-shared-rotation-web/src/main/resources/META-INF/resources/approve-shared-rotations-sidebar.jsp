<%@ include file="/init.jsp"%>

<%
	long groupId = themeDisplay.getScopeGroupId();	
	String name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	
	String ACCEPT_REQUEST = "ACCEPT_REQUEST";
	String REJECT_REQUEST = "REJECT_REQUEST";
%>


<!-- Notification Sidebar -->

		<div class="omsb-notification-sidebar" id="omsb-notification-sidebar">
			<div class="omsb-card">
				<div class="omsb-card-header">
					<h5 class="omsb-card-title"><liferay-ui:message key="approve-request-shared-rotation" /></h5>
					<button  id="sidebar-close-btn" type="button" class="close" >
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="omsb-card-body">
					<div class="omsb-comment-box omsb-BorderRadius-4">
						<div class="omsb-comment-box-header">
							<h3><liferay-ui:message key="status" /></h3>
							<span class="omsb-reappeal-bg">${sharedRotationRequest.status}</span>
						</div>
					</div>
					<div class="omsb-comment-box pb-0 omsb-BorderRadius-4">
						<div class="omsb-notification-row">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-12">
									<div class="form-group-view">
										<div class="label-name"><liferay-ui:message key="program-structure" /></div>
										<div class="label-content">${sharedRotationRequest.programStructure}</div>
									</div>
									
								</div>
								<div class="col-lg-6 col-md-6 col-sm-12">
									<div class="form-group-view">
										<div class="label-name"><liferay-ui:message key="rotation" /></div>
										<div class="label-content">${sharedRotationRequest.rotation}</div>
									</div>
								</div>
							</div>
						</div>
						<div class="omsb-notification-row">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-12">
									<div class="form-group-view">
										<div class="label-name"><liferay-ui:message key="no-of-trainees-requested" /></div>
										<div class="label-content">${sharedRotationRequest.noOfTraineesRequested}</div>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-12">
									<div class="form-group-view">
										<div class="label-name"><liferay-ui:message key="request-raised-by" /></div>
										<div class="label-content">${sharedRotationRequest.requestRaisedBy}</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<aui:form action="${reviewSharedRotations}" name="sidebsrfm">
					<div class="row pt-4">
						<div class="col-lg-12 col-md-12 col-sm-12">
							<div class="form-group">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12">
										<label class="radio-field-title"><liferay-ui:message key="approve-or-reject-shared-rotation" /></label>
									</div>									
									<div class="col-lg-6 col-md-6 col-sm-12">
										<div class="custom-control custom-radio ">
										<c:if test="<%=permissionChecker.hasPermission(groupId, name, primKey, ACCEPT_REQUEST)%>">
											<input type="radio" name="<portlet:namespace/>status" class="custom-control-input" id="approve" value="Approved">
											<label class="custom-control-label m-0" for="approve"><liferay-ui:message key="approve" /></label>
										</c:if>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12">
										<div class="custom-control custom-radio ">
										<c:if test="<%=permissionChecker.hasPermission(groupId, name, primKey, REJECT_REQUEST)%>">
											<input type="radio" name="<portlet:namespace/>status" class="custom-control-input" id="rejected" value="Rejected">
											<label class="custom-control-label m-0" for="rejected"><liferay-ui:message key="reject" /></label>
										</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">						
							<div class="form-group">
							<aui:input id="sidebarsharedRotationRequestId"
								name="sharedRotationRequestId" value="${sharedRotationRequest.sharedRotationRequestId}" type="hidden" />
								<aui:input label="no-of-trainee-allowed" type="number" min="0" value="" max="${sharedRotationRequest.noOfTraineesRequested}" id="allowedTraineesCount" name="allowedTrainees">
										<aui:validator name="required" />
										<aui:validator name="number" />
								</aui:input>
							</div>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<div class="form-group">
								<aui:input label="comment" name="comment" type="textarea" >
										<aui:validator name="required" />
								</aui:input>
							</div>
						</div>
					</div>
					<div class="bottom-backbtn-wrap">
						<button class="btn omsb-bc-red-button" type="submit"><liferay-ui:message key="save-and-continue" /></button>
					</div>
					</aui:form>
				</div>
			</div>
		</div>

		<!-- Notification Sidebar -->