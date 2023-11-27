<%@ include file="init.jsp" %>

<%
	long groupId = themeDisplay.getScopeGroupId();	
	String name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	
	String EDIT_REQUEST = "EDIT_REQUEST";
%>

<c:if
	test="<%=!SessionErrors.isEmpty(renderRequest) && !SessionMessages.isEmpty(renderRequest)%>">
	<div class="alert alert-light alert-danger-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/reject.svg"
				alt="Reject"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span id="showError"><liferay-ui:message
							key="<%=SessionErrors.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>
<c:if
	test="<%=!SessionMessages.isEmpty(renderRequest) && SessionErrors.isEmpty(renderRequest)%>">
	<div class="alert alert-light alert-success-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/Right.svg"
				alt="Right"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span>
					<liferay-ui:message
							key="<%=SessionMessages.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>

<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<div class="omsb-page-top-info">
					<div class="pagetitle"><liferay-ui:message key="raise-share-rotations-request-to-pd" /></div>
				</div>
			</div>
			<aui:form action="${saveShareRotationRequestActionURL}" method="post" name="fm">
				<div class="omsb-list-filter">
					<div class="row">
						<div class="col-lg-6 col-md-6">
						<aui:input name="sharedRotationRequestId" type="hidden" value="${sharedRotationRequestDetail.sharedRotationRequestDetailsId}" />
							<div class="form-group">
								<label for="<portlet:namespace/>rotationId">
									<liferay-ui:message key="rotation" />
									<span class="reference-mark text-warning">
										<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
											<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
										</svg>
									</span>
								</label>
								<select class="custom-select form-control js-basic-single required-field" id="<portlet:namespace/>rotationId"
									name="<portlet:namespace/>rotationId" onchange="getProgramMasterId(this.value); validateField($(this))" >
									<c:forEach items="${rotationMasterList}" var="rotationMaster">
										<c:choose>
											<c:when test="${rotationMaster.rotationMasterId eq sharedRotationRequestDetail.rotationId}">
												<aui:option value="${rotationMaster.rotationMasterId}" selected="true">${rotationMap.get(rotationMaster.rotationMasterId)}</aui:option>
											</c:when>
											<c:otherwise>
												<aui:option value="${rotationMaster.rotationMasterId}">${rotationMap.get(rotationMaster.rotationMasterId)}</aui:option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-lg-6 col-md-6">
							<div class="form-group">
								<label for="<portlet:namespace/>programId">
									<liferay-ui:message key="program" />
									<span class="reference-mark text-warning">
										<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
											<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
										</svg>
									</span>
								</label>
								<select class="custom-select form-control js-basic-single required-field" id="<portlet:namespace/>programId"
									name="<portlet:namespace/>programId" onchange="getProgramDurationId(this.value); validateField($(this))" >
									<aui:option value="" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program" /></aui:option>
									<aui:option value="${programMaster.programMasterId}" selected="true" cssClass="placeholder" >${programMap.get(programMaster.programMasterId)}</aui:option>
								</select>
							</div>
						</div>
						<div class="col-lg-6 col-md-6">
							<div class="form-group">
								<label for="<portlet:namespace/>programDurationId">
									<liferay-ui:message key="program-duration" />
									<span class="reference-mark text-warning">
										<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
											<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
										</svg>
									</span>
								</label>
								<select class="custom-select form-control js-basic-single required-field" id="<portlet:namespace/>programDurationId"
									name="<portlet:namespace/>programDurationId" onchange="getProgramUserDetail(this.value, false); validateField($(this))" >
									<aui:option value="" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program-duration" /></aui:option>
									<aui:option value="${programDurationDetails.progDurationId}" selected="true" cssClass="placeholder" >${programDurationDetails.ayApplicableForm}</aui:option>
								</select>
							</div>
						</div>
						<div class="col-lg-6 col-md-6">
							<div class="form-group">
								<label for="<portlet:namespace/>noOfTraineesRequested">
									<liferay-ui:message key="no-of-trainees" />
									<span class="reference-mark text-warning">
										<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
											<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
										</svg>
									</span>
								</label>
								<input class="form-control required-field" type="number" 
									placeholder='<liferay-ui:message key="no-of-trainees" />'
									id="<portlet:namespace/>esimateNoOfTraineesRequested" name="<portlet:namespace/>esimateNoOfTraineesRequested" 
									ignoreRequestValue="true" onchange="setCurrentCapacity(this.value); validateField($(this));" 
									min="0" step="1"  value="${sharedRotationRequestDetail.noOfTraineesRequested}" />
							</div>
						</div>
						<div class="col-lg-12 col-md-12">
							<div class="form-group">
								<label for="<portlet:namespace/>requesterComment">
									<liferay-ui:message key="comments" />
									<span class="reference-mark text-warning">
										<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
											<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
										</svg>
									</span>
								</label>
								<aui:input name="comment" type="textarea" label="comments" cssClass="form-control required-field" localized="true" value="${sharedRotationRequestDetail.requesterComment}">
									<aui:validator name="maxLength">5000</aui:validator>
								</aui:input>
							</div>
						</div>
						<div>
							<jsp:include page="/notify-user-modal-popup.jsp" />
						</div>
						<div class="col-lg-12 col-md-12">
							<div class="bottom-backbtn-wrap">
								<c:if test="<%=permissionChecker.hasPermission(groupId, name, primKey, EDIT_REQUEST)%>">
									<button id="validate-form-button" class="btn omsb-bc-red-button edit-notify-model" type="button" data-target="#notifyauthorizeduser" data-toggle="modal" data-value="${programDurationDetails.progDurationId}"><liferay-ui:message key="raise-a-request" /></button>
								</c:if>
								<a class="btn omsb-btn omsb-bg-red-button" href="<%=backURL%>"><liferay-ui:message key="cancel" /></a>
							</div>
						</div>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div>
<jsp:include page="/share-rotation-request-list.jsp" />
</div>
