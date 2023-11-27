<%@ include file="../../init.jsp"%>


<portlet:actionURL
	name="<%=AppealConstants.ADD_APPEAL_DECISIONS_ACTION%>"
	var="saveCommitteeResponseURL">
	<portlet:param name="<%=Constants.CMD%>"
		value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW%>" />
</portlet:actionURL>

<portlet:renderURL var="viewEquivalencyAppealListAdminURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<portlet:resourceURL id="<%=MVCCommandNames.ADD_MULTIPLE_FILES_TABLE_DATA_RESOURCE%>" var="addMultipleFilesURL">
</portlet:resourceURL>

<div class="container" id="wrapper">


	<div class="omsb-card">
		<div class="omsb-page-top-info">
			<div class="pagetitle">
				<liferay-ui:message key="edit-equivalency-appeal" />
			</div>
			<div class="information">
				<span class="${appealStatusColur.get(appeallantStatus)}">${appeallantStatus}</span>
			</div>
		</div>
		<c:if test="${!hasVehpcEmployerRole}">
			<h4 class="omsb-card-title">
				<liferay-ui:message key="focal-point" />
			</h4>
			<div class="row">
					<div class="col-lg-4 col-md-3 col-sm-12 label-box">
						<div class="label-name"><liferay-ui:message
								key="full-name" /></div> <div class="label-content">${focalPoint.name}</div>
					</div>

					<div class="col-lg-4 col-md-3 col-sm-12 label-box">
						<div class="label-name"><liferay-ui:message key="email" /></div>
						<div class="label-content">${focalPoint.email}</div>
					</div>

					<div class="col-lg-4 col-md-3 col-sm-12 label-box">
						<div class="label-name"><liferay-ui:message
								key="mobile" /></div> <div class="label-content">${focalPoint.mobileNumber}</div>
					</div>
				</div>
		</c:if>

		<h4 class="omsb-card-title">
			<liferay-ui:message key="request-details" />
		</h4>
		<div class="row">
			<div class="col-lg-4 col-md-3 col-sm-12 label-box">
				<div class="label-name"><liferay-ui:message
						key="full-name" /></div> <div class="label-content">${personalDetail.givenNameAsPassport}</div>
			</div>

			<div class="col-lg-4 col-md-3 col-sm-12 label-box">
				<div class="label-name"><liferay-ui:message
						key="nationality" /></div> <div class="label-content">${personNatinality}</div>
			</div>

			<div class="col-lg-4 col-md-3 col-sm-12 label-box">
				<div class="label-name"><liferay-ui:message
						key="passport-number" /></div> <div class="label-content">${passportNumber}</div>
			</div>

			<div class="col-lg-4 col-md-3 col-sm-12 label-box">
				<div class="label-name"><liferay-ui:message
						key="date-of-birth" /></div> <div class="label-content">${dateOfBirth}</div>
			</div>

			<div class="col-lg-4 col-md-3 col-sm-12 label-box">
				<div class="label-name"><liferay-ui:message key="email" /></div>
				<div class="label-content">${personalDetail.email}</div>
			</div>

			<div class="col-lg-4 col-md-3 col-sm-12 label-box">
				<div class="label-name"><liferay-ui:message
						key="mobile" /></div> <div class="label-content">${personalDetail.mobileNumber}</div>
			</div>

			<div class="col-lg-4 col-md-3 col-sm-12 label-box">
				<div class="label-name"><liferay-ui:message
						key="profession" /></div> <div class="label-content">${personalDetail.profession}</div>
			</div>
			<div class="col-lg-4 col-md-3 col-sm-12 label-box">
				<div class="label-name"><liferay-ui:message
						key="primary-specialty" /></div> <div class="label-content">${primarySpecialty}</div>
			</div>
			
			
			<div class="col-lg-4 col-md-3 col-sm-12 label-box">
				<div class="label-name"><liferay-ui:message
						key="equivalency-request-id" /></div> <div class="label-content">EQ-${equivalencyRequestId}</div>
			</div>
		</div>
		<input type=hidden id="evaluatedDocCount" value="${certificatesList.size()}"/>
		<div class="omsb-list-view table-responsive">
			<table class="display omsb-tableview" width="100%">
				<thead>
					<tr>
						<th><liferay-ui:message
								key="name-of-certificate-to-be-evaluated" /></th>
						<th><liferay-ui:message key="equivalency-level" /></th>
						<th><liferay-ui:message key="comments" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${certificatesList}" var="certificatesList">
						<tr class="odd">
							<td><c:if
									test="${not empty certificatesList.certificatefileurl }">
									<a href="${certificatesList.certificatefileurl}" target="_blank" view><c:out
											value="${certificatesList.certificateName}" /></a>
								</c:if></td>
							<td><c:out
									value="${certificatesList.getEquivalencyLevel().getName()}" /></td>
							<td>${certificatesList.comments}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="omsb-card ">
		<div class="omsb-card omsb-card-graybg">
			<h4 class="omsb-card-title">
				<liferay-ui:message key="request-details" />
			</h4>
			<div class="row">
				<div class="col-md-12 label-box">
					<label class="label-name"> <span>${appeallantUserRole}</span>
						<liferay-ui:message key="comments" /></label> <label
						class="label-content">${appealComments}</label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 label-box">
					<label class="label-name"><liferay-ui:message
							key="documents"></liferay-ui:message></label>
				</div>

				<div class="col-md-12">
					<div class="form-group omsb-view-file">
						<c:forEach items="${docsList}" var="info">
							<!-- Access filename, fileEntryID, and docsfileurl for each DocumentInfo object -->
							<c:set var="filename" value="${info.dFFileName}" />
							<c:set var="fileEntryID" value="${info.fileEntryID}" />
							<c:set var="docsfileurl" value="${info.docsfileurl}" />

							<label><c:out value="${info.documentTypeName}" /> <span
								class="">
									<button class="btn btn-label view-download" data-toggle="modal"
										data-edd="${supportingDoc}" data-State="${docsfileurl}"
										data-target="#supporting-document">
										<liferay-ui:message key="view-file" />
									</button> <a href="${docsfileurl}" class="btn btn-label view-download"
									download><liferay-ui:message key="download-file" /></a>
							</span></label>
							</a>
						</c:forEach>
					</div>
				</div>

			</div>
		</div>
		<aui:form action="${saveCommitteeResponseURL}"
			name="edit_eq_appeal_fm">
			<aui:input name="personId" type="hidden"
				value="${personId}"></aui:input>
			<aui:input name="equivalencyRequestId" type="hidden"
				value="${equivalencyRequestId }"></aui:input>
			<aui:input name="decisiondocinfo" type="hidden"
				value="${decisiondocinfo}"></aui:input>
			<aui:input name="appealId" type="hidden" value="${appealId}"></aui:input>
			<aui:input name="transitionName" type="hidden"
				value="${transitionName }"></aui:input>
			<aui:input name="workflowInstanceId" type="hidden"
				value="${workflowInstanceId}"></aui:input>
			<aui:input name="workflowTaskId" type="hidden"
				value="${workflowTaskId}"></aui:input>
			<c:if test="${hasRapporteurRole}">
				<aui:input name="roleName" type="hidden"
					value="<%=RoleNameConstants.VEHPC_RAPPORTEUR%>"></aui:input>
				<div class="omsb-card">
					<div class="omsb-card-title">
						<liferay-ui:message key="committee-response" />
					</div>
					<c:forEach items="${certificatesList}" var="certificatesList"
						varStatus="theCount">
						<aui:input name="equivalencyDecisionLevelId${theCount.count}"
							type="hidden" value="${certificatesList.equivalencyLevelId}"></aui:input>
						<div class="row">

							<div class="col-md-12 label-box">
								<label class="label-name"><liferay-ui:message
										key="certificate"></liferay-ui:message></label> <label
									class="label-content"><c:out
										value="${certificatesList.getCertificateName()}" /></label>
							</div>
							
							<div class="col-md-12 label-box">
								<label class="label-name"><liferay-ui:message
										key="old-equivalency-level"></liferay-ui:message></label> <label
									class="label-content"><c:out
										value="${certificatesList.getEquivalencyLevel().getName()}" /></label>
							</div>
							<%-- <div class="col-md-6">
								<div class="form-group">
									<aui:select name="committeeNewLevel${theCount.count}"
										label="new-level">
										<aui:validator name="required"></aui:validator>
										<aui:option value="">
											<liferay-ui:message key="select" />
										</aui:option>
										<c:forEach var="equivalencyLevelvalues"
											items="${equivalencyLevelList}">
											<aui:option
												value="${equivalencyLevelvalues.getKey()}"
												selected="${equivalencyLevelvalues.getName(themeDisplay.getLocale()) eq equivalencylevelkey ? 'selected' : ''}">
												<liferay-ui:message
													key="${equivalencyLevelvalues.getName(themeDisplay.getLocale())}" />
											</aui:option>
										</c:forEach>
									</aui:select>
								</div>
							</div> --%>
							<div class="col-md-6">
								<div class="form-group">
									<label><liferay-ui:message key="new-level" /></label> <select
										name="<portlet:namespace />committeeNewLevel${theCount.count}"
										id="committeeLevel${theCount.count}"
										class="custom-select form-control" onchange="onSelectLevelByCommittee(${theCount.count})">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach items="${equivalencyLevelList}" var="eqLevel">
											<option value="${eqLevel.getKey()}">
												<liferay-ui:message
													key="${eqLevel.getName(themeDisplay.getLocale())}" />
											</option>
										</c:forEach>
									</select>
									<p id="level-error${theCount.count}" class="error-message text-danger d-none">
										<liferay-ui:message key="this-field-is-required"></liferay-ui:message>
									</p>
								</div>
							</div>
							<div class="col-md-6 d-none eq-level-reason">
								<div class="form-group">
									<label><liferay-ui:message key="appeal-level-reason" /></label>
									<select
										name="<portlet:namespace />equivalencyLevelReason${theCount.count}"
										id="committeeLevelReason${theCount.count}"
										class="custom-select form-control">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach items="${eqLevelReasonList}" var="eqLevelReason">
											<option value="${eqLevelReason.getKey()}">
												<liferay-ui:message
													key="${eqLevelReason.getName(themeDisplay.getLocale())}" />
											</option>
										</c:forEach>
									</select>
									<p id="level-reason-error${theCount.count}" class="error-message text-danger d-none">
										<liferay-ui:message key="this-field-is-required"></liferay-ui:message>
									</p>
								</div>
							</div>
							<div class="col-md-10">
								<div class="form-group">
									<label><liferay-ui:message key="attachment"></liferay-ui:message></label>
									<div class="custom-file">
										<aui:input id="additionalDecisionAttachment${theCount.count}" name="additionalDecisionAttachment${theCount.count}" type="file" label=""
												cssClass="attachment form-control"  /> 
											<div class="d-none">
												<aui:input id="multiFile${theCount.count}" name="decisionAdditionalAttachment${theCount.count}" type="file" label=""
												cssClass="attachment form-control"  />
											</div>	
											<label class="custom-file-label" for='<portlet:namespace />additionalDecisionAttachment${theCount.count}'></label>
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
									<button type="button" class="omsb-bc-red-button add-files" onclick="addFiletoTable(${theCount.count})">
										<liferay-ui:message key="add" />
									</button>
								</div>
							</div>
							<div class="col-md-12 file-table d-none">
								<table class="display omsb-datatables"
									id="add-multiple-files-table${theCount.count}">
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
								<div class="form-group">
									<label><liferay-ui:message key="comments" /> <!-- <span class="counter"><span
										class="countered_points"><liferay-ui:message key="500" /></span><liferay-ui:message key="/500-remaining" /></span> -->
									</label>
									<textarea
										name="<portlet:namespace/>committeeComments${theCount.count}"
										class="committeeComments" rows="1" required="required"
										id="committee-comments${theCount.count}"></textarea>
									<p id="comment-error${theCount.count}" class="error-message text-danger d-none">
										<liferay-ui:message key="this-field-is-required"></liferay-ui:message>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
					<input type="hidden" id="size" name="<portlet:namespace/>size"
						value=${size }>
				</div>
			</c:if>

			<c:if test="${hasVehpcAdminRole}">
				<aui:input name="roleName" type="hidden"
					value="<%=RoleNameConstants.VEHPC_ADMIN%>"></aui:input>
				<div class="col-lg-12 col-md-12">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="admin-response" />
					</h4>

					<c:forEach items="${certificatesList}" var="certificatesList"
						varStatus="theCount">

						<aui:input name="equivalencyDecisionLevelId${theCount.count}"
							type="hidden" value="${certificatesList.equivalencyLevelId}"></aui:input>
						<div class="row">
							<div class="col-md-12 label-box">
								<label class="label-name"><liferay-ui:message
										key="certificate"></liferay-ui:message></label>
								<label
									class="label-content"><c:out
										value="${certificatesList.getCertificateName()}" /></label>
							</div>
							<div class="col-md-12 label-box">
								<label class="label-name"><liferay-ui:message
										key="old-equivalency-level"></liferay-ui:message></label> <label
									class="label-content"><c:out
										value="${certificatesList.getEquivalencyLevel().getName()}" /></label>
							</div>
							
							<%-- <div class="col-md-6">
								<div class="form-group-not">
									<aui:select name="adminNewLevel${theCount.count}"
										label="new-level" cssClass="omsb-input-select">
										<aui:validator name="required"></aui:validator>
										<aui:option value="">
											<liferay-ui:message key="select"></liferay-ui:message>
										</aui:option>
										<c:forEach var="equivalencyLevelvalues"
											items="${equivalencyLevelList}">
											<c:set var="selected" value="false"></c:set>
											<c:if
												test="${equivalencyLevelvalues.getListTypeEntryId() == committeLevelId }">
												<c:set var="selected" value="true"></c:set>
											</c:if>
											<aui:option
												value="${equivalencyLevelvalues.getListTypeEntryId()}"
												selected="${selected}">
												<liferay-ui:message
													key="${equivalencyLevelvalues.getName(themeDisplay.getLocale())}" />
											</aui:option>
										</c:forEach>
									</aui:select>
								</div>
							</div> --%>
							<div class="col-md-6">
								<div class="form-group">
									<label><liferay-ui:message key="new-level" /></label> <select
										name="<portlet:namespace />adminNewLevel${theCount.count}"
										id="adminAppealLevel${theCount.count}" class="custom-select form-control" onchange="onSelectLevelByAdmin(${theCount.count})">
										<option value=""><liferay-ui:message key="select"  /></option>
										<c:forEach items="${equivalencyLevelList}" var="eqLevel">
											<option value="${eqLevel.getKey()}">
												<liferay-ui:message
													key="${eqLevel.getName(themeDisplay.getLocale())}" />
											</option>
										</c:forEach>
									</select>
									<p id="admin-level-error${theCount.count}" class="error-message text-danger d-none">
										<liferay-ui:message key="this-field-is-required"></liferay-ui:message>
									</p>
								</div>
							</div>
							<div class="col-md-6 d-none eq-level-reason">
								<div class="form-group">
									<label><liferay-ui:message key="appeal-level-reason" /></label>
									<select
										name="<portlet:namespace />adminAppealLevelReason${theCount.count}"
										id="adminAppealLevelReason${theCount.count}" class="custom-select form-control">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach items="${eqLevelReasonList}" var="eqLevelReason">
											<option value="${eqLevelReason.getKey()}">
												<liferay-ui:message
													key="${eqLevelReason.getName(themeDisplay.getLocale())}" />
											</option>
										</c:forEach>
									</select>
									<p id="admin-level-reason-error${theCount.count}" class="error-message text-danger d-none">
										<liferay-ui:message key="this-field-is-required"></liferay-ui:message>
									</p>		
								</div>
							</div>
							<div class="col-md-10">
								<div class="form-group">
									<label><liferay-ui:message key="attachment"></liferay-ui:message></label>
									<div class="custom-file">
										<aui:input id="additionalDecisionAttachment${theCount.count}" name="additionalDecisionAttachment${theCount.count}" type="file" label=""
												cssClass="attachment form-control"  /> 
											<div class="d-none">
												<aui:input id="multiFile${theCount.count}" name="decisionAdditionalAttachment${theCount.count}" type="file" label=""
												cssClass="attachment form-control"  />
											</div>	
											<label class="custom-file-label" for='<portlet:namespace />additionalDecisionAttachment${theCount.count}'></label>
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
									<button type="button" class="omsb-bc-red-button add-files" onclick="addFiletoTable(${theCount.count})">
										<liferay-ui:message key="add" />
									</button>
								</div>
							</div>
							<div class="col-md-12 file-table d-none">
								<table class="display omsb-datatables"
									id="add-multiple-files-table${theCount.count}">
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
								<div class="form-group">
									<label><liferay-ui:message key="comments" /> <!-- <span class="counter"><span
										class="countered_points"><liferay-ui:message key="500" /></span><liferay-ui:message key="/500-remaining" /></span> -->
									</label>
									<textarea class="adminComments form-control"
										id="admin-comments${theCount.count}" rows="1"
										name="<portlet:namespace/>adminComments${theCount.count}"></textarea>
									<p id="admin-comment-error${theCount.count}" class="error-message text-danger d-none">
										<liferay-ui:message key="this-field-is-required"></liferay-ui:message>
									</p>	
								</div>
							</div>
						</div>
					</c:forEach>
					<input type="hidden" id="size" name="<portlet:namespace/>size"
						value=${size }>

				</div>
				<%@include file ="../../certificate/edit-certificate.jsp" %>
			</c:if>
			

			<div class="omsb-card">
				<h4 class="omsb-card-title">
					<liferay-ui:message key="comments" />
				</h4>
				<ul class="omsb-comments-list">
					<li>
						<div class="omsb-comment-box">
							<div class="omsb-comment-box-header">
								<h3 class="comment-title">
									<span class="comment-author-name">${statusList.get(0).fullName}
									</span>${statusList.get(0).roleType}
								</h3>
								<span class="posted-date">${statusList.get(0).dateCreated}</span>
							</div>
							<div class="omsb-comment-body">
								<div class="row">
									<c:if
										test="${not empty statusList.get(0).equivalencyLevelName}">
										<div class="col-md-6">
											<b><liferay-ui:message key="equivalency-level" /> </b>&nbsp;:
											${statusList.get(0).equivalencyLevelName}
										</div>
									</c:if>
									<div class="col-md-6">
										<b><liferay-ui:message key="comments" /> </b>&nbsp;:
										${statusList.get(0).message}
									</div>
								</div>
								<c:if test="${not empty statusList.get(0).documentList  }">
									<div class="row">
										<div class="col-md-12">
											<b><liferay-ui:message key="attachments" /> </b>&nbsp;:
											<c:forEach items="${statusList.get(0).documentList }"
												var="docs">
												<div>
													<a href="${docs.documentUrl}" target="_blank">${docs.dFFileName }</a>
												</div>

											</c:forEach>
										</div>
									</div>
								</c:if>
							</div>

						</div> <br></br> <c:if test="${statusList.size() gt 1}">
							<div class="colspan-child">
								<liferay-ui:message key="expand" />
							</div>
							<ul>
								<c:forEach var="status" items="${statusList}" varStatus="loop">
									<c:if test="${loop.index != 0}">
										<li>
											<div class="omsb-comment-box">
												<div class="omsb-comment-box-header">
													<h3 class="comment-title">
														<span class="comment-author-name">${status.fullName}
														</span> ${status.roleType}
													</h3>
													<span class="posted-date">${status.dateCreated}</span>
												</div>
												<div class="omsb-comment-body">
													<div class="row">
														<c:if test="${not empty status.equivalencyLevelName}">
															<div class="col-md-6">
																<b><liferay-ui:message key="equivalency-level" /> </b>&nbsp;:
																${status.equivalencyLevelName}
															</div>
														</c:if>
														<div class="col-md-6">
															<b><liferay-ui:message key="comments" /> </b>&nbsp;:
															${status.message}
														</div>
													</div>
													<c:if test="${not empty status.documentList  }">
														<div class="row">
															<div class="col-md-12">
																<b><liferay-ui:message key="attachments" /> </b>&nbsp;:
																<c:forEach items="${status.documentList }" var="docs">

																	<div>
																		<a href="${docs.docsfileurl}" target="_blank">${docs.dFFileName }</a>
																	</div>

																</c:forEach>
															</div>
														</div>
													</c:if>
												</div>

											</div>
										</li>
									</c:if>
								</c:forEach>
							</ul>
						</c:if>
					</li>
				</ul>
			</div>

			<div class="omsb-card bottom-backbtn-wrap">
				<c:if test="${hasRapporteurRole}">
					<button type="button" class="btn omsb-btn omsb-bc-red-button"
						onclick="validate()" href="#">
						<liferay-ui:message key="submit" />
					</button>
				</c:if>

				<c:if test="${hasVehpcAdminRole}">
					<button type="button" class="btn omsb-btn omsb-bc-red-button"
						onclick="validateAdmin()" href="#">
						<liferay-ui:message key="submit" />
					</button>
				</c:if>
				<a class="btn omsb-btn btn-back"
					href="<%=viewEquivalencyAppealListAdminURL%>"><i
					class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a>
			</div>
		</aui:form>
	</div>
</div>


<div class="modal fade" id="supporting-document" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog information-box" role="document">
		<div class="modal-content">
			<div class="modal-header d-none">
				<h5 class="modal-title" id="exampleModalLabel">
					<liferay-ui:message key="supporting-document" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="omsb-label-view ">
					<div class="label-group-header row">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="row">
						<div class="col-md-12 label-box">
							<iframe class="custom-iframe" id="documentFrame"
								src="${docsfileurl}"></iframe>
							<label class="label-name"><liferay-ui:message
									key="supporting-document" /></label> <label class="label-content"><a
								download href="${docsfileurl}"><liferay-ui:message
										key="download-supporting-document" /></a></label>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">
					<liferay-ui:message key="close" />
				</button>
			</div>
		</div>
	</div>
</div>


<%@include file ="../../add-multiple-files-delete-popup.jsp" %>

<style>
.omsb-tableview {
	text-align: "left" !important;
}

.custom-iframe {
	height: 400px; /* Adjust the height value as desired */
}
</style>

<script>

	console.log("Add Appeal Decision page");
	
	$(document).ready(function() {
		var size = $('#size').val();
		
		for (i = 1; i <= size; i++) {
			$('#committee-comments' + i).richText();
			$('#admin-comments' + i).richText();
		
		}
	});
	
	function onSelectLevelByCommittee(index){
		if ($('#committeeLevel' + index).val() == 'none') {
			$('#committeeLevelReason' + index).closest(
					'.eq-level-reason').removeClass('d-none');
		} else {
			$('#committeeLevelReason' + index).closest(
					'.eq-level-reason').addClass('d-none');
			document.getElementById("committeeLevelReason"+index).value = "";
			
			
		}
		
	}
	
	function onSelectLevelByAdmin(index){
		var decisionIndex= index-1;
		document.getElementById('certificateDecision'+decisionIndex).innerHTML = $('#adminAppealLevel'+index).find(":selected").text().trim();
		document.getElementById('certificateDecisionArabic'+decisionIndex).innerHTML = $('#adminAppealLevel'+index).find(":selected").text().trim();
		document.getElementById('saveCertificateDecision'+decisionIndex).innerHTML = $('#adminAppealLevel'+index).find(":selected").text().trim();
		document.getElementById('saveCertificateDecisionArabic'+decisionIndex).innerHTML = $('#adminAppealLevel'+index).find(":selected").text().trim();
		
		if ($('#adminAppealLevel' + index).val() == 'none') {
			$('#adminAppealLevelReason' + index).closest(
					'.eq-level-reason').removeClass('d-none');
		} else {
			$('#adminAppealLevelReason' + index).closest(
					'.eq-level-reason').addClass('d-none');
			document.getElementById("adminAppealLevelReason"+index).value = "";
		}
		
	}

	function validate() {
		var error=false;
		var certificateCount =$('#evaluatedDocCount').val();
		for(var i=1; i<= certificateCount;i++){
			 var committeeLevel = $('#committeeLevel'+i).val();
			 var app_textarea = $('#committee-comments'+i).siblings('.richText-editor').text(); // Use trim() to remove whitespacex
			 var app_textarea=String(app_textarea).replaceAll('\t','');
			 if (app_textarea !== '' && app_textarea !== undefined) {
			     $('#comment-error'+i).addClass('d-none');
			 } else {
				 error = true;
			     $('#comment-error'+i).removeClass('d-none');
			 }
			 if(committeeLevel !== '' && committeeLevel !== undefined){
				  $('#level-error'+i).addClass('d-none');
				  if(committeeLevel == 'none'){
					  var committeeLevelReason =$('#committeeLevelReason'+i).val();
					  if(committeeLevelReason !== '' && committeeLevelReason !== undefined){
							$('#level-reason-error'+i).addClass('d-none');
					  }else {
							error = true;
						    $('#level-reason-error'+i).removeClass('d-none');
					  }
				  }
			 } else {
				 error = true;
			     $('#level-error'+i).removeClass('d-none');
			 }
		}
		 if (!error) {
			submitForm(document.<portlet:namespace />edit_eq_appeal_fm);
		} else {
		    return false;
		}
	}

	function validateAdmin() {
		var error=false;
		var certificateCount =$('#evaluatedDocCount').val();
		for(var i=1; i<= certificateCount;i++){
			 var adminLevel = $('#adminAppealLevel'+i).val();
			 var app_textarea = $('#admin-comments'+i).siblings('.richText-editor').text(); // Use trim() to remove whitespacex
			 var app_textarea=String(app_textarea).replaceAll('\t','');
			 if (app_textarea !== '' && app_textarea !== undefined) {
			     $('#admin-comment-error'+i).addClass('d-none');
			 } else {
				 error = true;
			     $('#admin-comment-error'+i).removeClass('d-none');
			 }
			 if(adminLevel !== '' && adminLevel !== undefined){
				  $('#admin-level-error'+i).addClass('d-none');
				  if(adminLevel == 'none'){
					  var adminLevelReason =$('#adminAppealLevelReason'+i).val();
					  if(adminLevelReason !== '' && adminLevelReason !== undefined){
							$('#admin-level-reason-error'+i).addClass('d-none');
					  }else {
							error = true;
						    $('#admin-level-reason-error'+i).removeClass('d-none');
					  }
				  }
			 } else {
				 error = true;
			     $('#admin-level-error'+i).removeClass('d-none');
			 }
		}
		if (document.getElementById('certificateInEnglish').checked) {
			document.getElementById('htmlDivData').value = $('.saveCertificateInEnglish').html();
		}
		else if (document.getElementById('certificateInArabic').checked) {
			document.getElementById('htmlDivData').value = $('.saveCertificateInArabic').html();	
		}
		console.log(error);
		 if (!error) {
			 $('#<portlet:namespace />edit_eq_appeal_fm').submit();
		} else {
		    return false;
		}
	}
	
	
	function addFiletoTable(count){
		const additionalAttachmentId = '<portlet:namespace />additionalDecisionAttachment'+count;
		const multiFileId = '<portlet:namespace />multiFile'+count;
		const input = document.getElementById(multiFileId);
		const tableId = 'add-multiple-files-table'+count;
		addMultiFiles(additionalAttachmentId,tableId ,input, multiFileId);
	}
	function addMultiFiles(selectedFileId, tableId, finalFile, finalFileId){
		$('.file-table').removeClass('d-none');
		console.log('clicking this');
		var selectedFile = $('#'+ selectedFileId).prop('files')[0];
		var rowCount = $('#'+tableId+' tbody tr').length;
		$.ajax({
	        url: '<%=addMultipleFilesURL.toString()%>',
	        async : false,
	        data : {
				<portlet:namespace />fileName : selectedFile.name,
				<portlet:namespace />index : rowCount,
				<portlet:namespace />tableId : tableId,
				<portlet:namespace />finalFileId : finalFileId
	        },
	        type : 'POST',
	        success : function(data) {
	        	$('#' + tableId + ' tbody').append(data);
	        	$('#'+selectedFileId).val(''); 
	        	$('.custom-file-label').html('');
	        	
	        	var container = new DataTransfer();
	        	if (finalFile.files.length > 0 ){
		        	const fileListArr = Array.from(finalFile.files);
		        	for (let i = 0; i < fileListArr.length; i++) {
		        	    const oldFile = fileListArr[i]
		        	    container.items.add(oldFile); 
		        	}
	        	}
	        	container.items.add(selectedFile);
	        	finalFile.files = container.files;
	        },
	    });
	}
	
	
	function deleteMultiFile(finalFile, tableId, row){
		//var row = $(this).attr('row-data');
		console.log('row-data  attr is ?', row);
		$('#row-' + row).remove();
		var rowCount = $('#'+tableId+ ' tbody tr').length;
		if (rowCount == 0){
			$('.file-table').addClass('d-none');	
		}
		const fileListArr = Array.from(finalFile.files);
		fileListArr.splice(row,1);
		var container = new DataTransfer();
		for (let i = 0; i < fileListArr.length; i++) {
    	    const oldFile = fileListArr[i]
    	    container.items.add(oldFile); 
    	}
		finalFile.files = container.files;
		$('#delete-confirm').modal('hide');
	}
	

</script>
