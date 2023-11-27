<%@ include file="../init.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<!-- Inner Wrapper Contents -->
<div class="omsb-card">
	<div class="omsb-page-top-info mb-4">
		<div class="pagetitle">
			<liferay-ui:message key="ec-member-request-view-request" />
		</div>
		<div class="righbar ${ecMemberRequestDetails.latestStatusCode}">
			<Strong>${ecMemberRequestDetails.latestStatus}</Strong>
		</div>
	</div>


	<h4 class="omsb-card-title pt-4">
		<liferay-ui:message key="ec-member-request-request-details" />
	</h4>
	<div class="row">
		<div class="col-md-4 col-sm-6 col-xs-6">
			<div class="form-group-view">
				<div class="label-name">
					<liferay-ui:message key="ec-member-request-program" />
				</div>
				<div class="label-content">
					<c:if test="${empty ecMemberRequestDetails.programName}">NA</c:if>
					<c:if test="${not empty ecMemberRequestDetails.programName}">${ecMemberRequestDetails.programName}</c:if>
				</div>
			</div>
		</div>
		<%-- <div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Training Site</div>
						<div class="label-content">
							<c:if test="${empty ecMemberRequestDetails.trainingSiteName}">NA</c:if>
							<c:if test="${not empty ecMemberRequestDetails.trainingSiteName}">${ecMemberRequestDetails.trainingSiteName}</c:if>
						</div>
					</div>
				</div> --%>
		<div class="col-md-4 col-sm-6 col-xs-6">
			<div class="form-group-view">
				<%-- <div class="label-name">Rotation</div>
						<div class="label-content">
							<c:if test="${empty ecMemberRequestDetails.rotationName}">NA</c:if>
							<c:if test="${not empty ecMemberRequestDetails.rotationName}">${ecMemberRequestDetails.rotationName}</c:if>
						</div> --%>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 col-xs-6">
			<div class="form-group-view">
				<div class="label-name">
					<liferay-ui:message key="ec-member-request-potential-member-name" />
				</div>
				<div class="label-content">
					<c:if test="${empty ecMemberRequestDetails.personName}">NA</c:if>
					<c:if test="${not empty ecMemberRequestDetails.personName}">${ecMemberRequestDetails.personName}</c:if>
				</div>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 col-xs-6">
			<div class="form-group-view">
				<div class="label-name">
					<liferay-ui:message key="ec-member-request-membership-role" />
				</div>
				<div class="label-content">
					<c:if test="${empty ecMemberRequestDetails.membershipRoleName}">NA</c:if>
					<c:if test="${not empty ecMemberRequestDetails.membershipRoleName}">${ecMemberRequestDetails.membershipRoleName}</c:if>
				</div>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 col-xs-6">
			<div class="form-group-view"></div>
		</div>
		<div class="col-md-4 col-sm-6 col-xs-6">
			<div class="form-group-view">
				<div class="label-name">
					<liferay-ui:message key="ec-member-request-dob" />
				</div>
				<div class="label-content">
					<c:if test="${empty ecMemberRequestDetails.dateOfBirth}">NA</c:if>
					<c:if test="${not empty ecMemberRequestDetails.dateOfBirth}">${ecMemberRequestDetails.dateOfBirth}</c:if>
				</div>
			</div>
		</div>

		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="form-group-view">
				<div class="label-name">
					<liferay-ui:message key="ec-member-request-civil-id" />
				</div>
				<div class="label-content">
					<c:if test="${empty ecMemberRequestDetails.civilId}">NA</c:if>
					<%-- <c:if test="${not empty ecMemberRequestDetails.civilId}">${ecMemberRequestDetails.civilId}</c:if> --%>
					<c:if test="${not empty civilCardFrontPhotoUrl}">
						<div class="omsb-card-caserport row">

							<div class=" righbar col-4 casereport-title">
								<div class="casereport-title">
									${ecMemberRequestDetails.civilId}</div>
							</div>
							<div class="righbar col-4 ">
								<a href="${civilCardFrontPhotoUrl}" target="_blank">
									<button class="btn view_btn" title="View">
										<img
											src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
											alt="" />
										<liferay-ui:message key="civil-card-front-photo" />
									</button>
								</a>
							</div>
							<div class="righbar col-4">
								<a href="${civilCardFrontPhotoUrl}" target="_blank">
									<button class="btn view_btn" title="View">
										<img
											src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
											alt="" />
										<liferay-ui:message key="civil-card-back-photo" />
									</button>
								</a>
							</div>
						</div>
					</c:if>

				</div>
			</div>

		</div>

		<%-- <div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12 pt-3">
						<div class="label-name pb-3">CV</div>
						<div class="omsb-card-caserport ">
							<div class="leftbar">
								<h4 class="casereport-title">${ecMemberRequestDetails.cvName}</h4>
							</div>
							<div class="righbar">
								<a href="${ecMemberRequestDetails.cvUrl}" target="_blank">
									<button class="btn view_btn" title="View">
										<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""/>View
									</button>
								</a>
							</div>
						</div>
					</div>
				</div> --%>
		<%-- <div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">CV</div>
						<div class="label-content">${ecMemberRequestDetails.cvName}</div>
					</div>
				</div> --%>
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="form-group-view">
				<div class="label-name">
					<liferay-ui:message key="ec-member-request-passport" />
				</div>
				<div class="label-content">
					<c:if test="${empty ecMemberRequestDetails.passportNumber}">NA</c:if>
					<c:if test="${not empty ecMemberRequestDetails.passportUrl}">
						<div class="omsb-card-caserport ">
							<div class="leftbar">
								<h4 class="casereport-title">
									<liferay-ui:message key="ec-member-request-passport" />
									${ecMemberRequestDetails.passportNumber}
								</h4>
							</div>
							<div class="righbar">
								<a href="${ecMemberRequestDetails.passportUrl}" target="_blank">
									<button class="btn view_btn" title="View">
										<img
											src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
											alt="" />
										<liferay-ui:message key="ec-member-request-view-document" />
									</button>
								</a>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>


		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="form-group-view">
				<div class="label-name">
					<liferay-ui:message key="ec-member-request-cv" />
				</div>
				<c:if test="${empty ecMemberRequestDetails.cvUrl}">
					<div class="label-content">NA</div>
				</c:if>
				<c:if test="${not empty ecMemberRequestDetails.cvUrl}">
					<div class="omsb-card-caserport ">
						<div class="leftbar">
							<h4 class="casereport-title">
								<liferay-ui:message key="ec-member-request-cv" />
								<%-- ${ecMemberRequestDetails.cvName} --%>
							</h4>
						</div>
						<div class="righbar">
							<a href="${ecMemberRequestDetails.cvUrl}" target="_blank">
								<button class="btn view_btn" title="View">
									<img
										src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
										alt="">
									<liferay-ui:message key="ec-member-request-view-document" />
								</button>
							</a>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		<%-- <div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="ec-member-request-dob"/></div>
						<div class="label-content">
							<c:if test="${empty ecMemberRequestDetails.dateOfBirth}">NA</c:if>
							<c:if test="${not empty ecMemberRequestDetails.dateOfBirth}">${ecMemberRequestDetails.dateOfBirth}</c:if>
						</div>
					</div>
				</div> --%>
		
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="form-group-view">
				<div class="label-name">
					<liferay-ui:message key="ec-member-request-covering-letter" />
				</div>
				<c:if test="${empty ecMemberRequestDetails.coveringLetterUrl}">
					<div class="label-content">NA</div>
				</c:if>
				<c:if test="${not empty ecMemberRequestDetails.coveringLetterUrl}">
					<div class="omsb-card-caserport ">
						<div class="leftbar">
							<h4 class="casereport-title">
								<liferay-ui:message key="ec-member-request-covering-letter" />
								<%-- ${ecMemberRequestDetails.coveringLetterName} --%>
							</h4>
						</div>
						<div class="righbar">
							<a href="${ecMemberRequestDetails.coveringLetterUrl}"
								target="_blank">
								<button class="btn view_btn" title="View">
									<img
										src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
										alt="">
									<liferay-ui:message key="ec-member-request-view-document" />
								</button>
							</a>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		
		
		<%-- <div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Covering letter</div>
						<div class="label-content">${ecMemberRequestDetails.coveringLetterName}</div>
					</div>
				</div> --%>

		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="form-group-view">
				<div class="label-name">
					<liferay-ui:message key="ec-member-request-no-objection-letter" />
				</div>
				<c:if test="${empty ecMemberRequestDetails.noObjectionLetterUrl}">
					<div class="label-content">NA</div>
				</c:if>
				<c:if
					test="${not empty ecMemberRequestDetails.noObjectionLetterUrl}">
					<div class="omsb-card-caserport ">
						<div class="leftbar">
							<h4 class="casereport-title">
								<liferay-ui:message key="ec-member-request-no-objection-letter" />
								<%-- ${ecMemberRequestDetails.noObjectionLetterName} --%>
							</h4>
						</div>
						<div class="righbar">
							<a href="${ecMemberRequestDetails.noObjectionLetterUrl}"
								target="_blank">
								<button class="btn view_btn" title="View">
									<img
										src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
										alt="">
									<liferay-ui:message key="ec-member-request-view-document" />
								</button>
							</a>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="form-group-view">
				<div class="label-name">
					<liferay-ui:message key="ec-member-request-qarar" />
				</div>
				<div class="label-content">
					<c:if test="${empty ecMemberRequestDetails.qarar}">NA</c:if>
					<c:if test="${not empty ecMemberRequestDetails.qarar}">
						<div class="omsb-card-caserport ">
							<div class="leftbar">
								<h4 class="casereport-title">
									<liferay-ui:message key="ec-member-request-qarar" />
								</h4>
							</div>
							<div class="righbar">
								<a href="${ecMemberRequestDetails.qarar}" target="_blank">
									<button class="btn view_btn" title="View">
										<img
											src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
											alt="">
										<liferay-ui:message key="ec-member-request-view-document" />
									</button>
								</a>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		<!-- <div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">No objection letter</div>
						<div class="label-content"></div>
					</div>
				</div> -->


	</div>
	<h4 class="omsb-card-title pt-3">
		<liferay-ui:message
			key="ec-member-request-potential-member-bank-details" />
	</h4>
	<c:if
		test="${empty ecMemberRequestDetails.bankName and empty ecMemberRequestDetails.accountNo and empty ecMemberRequestDetails.bankBranch}">
				NA
			</c:if>
	<c:if
		test="${not empty ecMemberRequestDetails.bankName or not empty ecMemberRequestDetails.accountNo or not empty ecMemberRequestDetails.bankBranch}">
		<div class="row">
			<div class="col-md-4 col-sm-6 col-xs-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="ec-member-request-bank-name" />
					</div>
					<div class="label-content">
						<c:if test="${empty ecMemberRequestDetails.bankName}">NA</c:if>
						<c:if test="${not empty ecMemberRequestDetails.bankName}">${ecMemberRequestDetails.bankName}</c:if>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="ec-member-request-account-no" />
					</div>
					<div class="label-content">
						<c:if test="${empty ecMemberRequestDetails.accountNo}">NA</c:if>
						<c:if test="${not empty ecMemberRequestDetails.accountNo}">${ecMemberRequestDetails.accountNo}</c:if>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="ec-member-request-bank-branch" />
					</div>
					<div class="label-content">
						<c:if test="${not empty ecMemberRequestDetails.bankBranch}">${ecMemberRequestDetails.bankBranch}</c:if>
						<c:if test="${empty ecMemberRequestDetails.bankBranch}">NA</c:if>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<%-- <div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12 pt-3">
			<div class="label-name pb-3">
				<liferay-ui:message key="ec-member-request-passport" />
			</div>
			<c:if test="${empty ecMemberRequestDetails.passportUrl}">NA</c:if>
			<c:if test="${not empty ecMemberRequestDetails.passportUrl}">
				<div class="omsb-card-caserport ">
					<div class="leftbar">
						<h4 class="casereport-title">
							<liferay-ui:message key="ec-member-request-passport" />
							${ecMemberRequestDetails.passportName}
						</h4>
					</div>
					<div class="righbar">
						<a href="${ecMemberRequestDetails.passportUrl}" target="_blank">
							<button class="btn view_btn" title="View">
								<img
									src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
									alt="" />
								<liferay-ui:message key="ec-member-request-view-document" />
							</button>
						</a>
					</div>
				</div>
			</c:if>
		</div>
	</div> --%>

	<%-- <div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12 pt-3">
			<div class="label-name pb-3">
				<liferay-ui:message key="ec-member-request-nationality" />
			</div>
			<c:if test="${empty ecMemberRequestDetails.nationalIdUrl}">NA</c:if>
			<c:if test="${not empty ecMemberRequestDetails.nationalIdUrl}">
				<div class="omsb-card-caserport ">
					<div class="leftbar">
						<h4 class="casereport-title">
							<liferay-ui:message key="ec-member-request-nationality" />
							${ecMemberRequestDetails.nationalIdName}
						</h4>
					</div>
					<div class="righbar">
						<a href="${ecMemberRequestDetails.nationalIdUrl}" target="_blank">
							<button class="btn view_btn" title="View">
								<img
									src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
									alt="" />
								<liferay-ui:message key="ec-member-request-view-document" />
							</button>
						</a>
					</div>
				</div>
			</c:if>
		</div>
	</div>
 --%>
	<h4 class="omsb-card-title pt-3">
		<liferay-ui:message
			key="ec-member-request-potential-member-education-details" />
	</h4>
	<c:if test="${empty ecMemberRequestDetails.educationalDetailsViewList}">
				NA
			</c:if>
	<c:if
		test="${not empty ecMemberRequestDetails.educationalDetailsViewList}">
		<div class="omsb-list-view table-responsive">
			<table id="educationDetailTable" class="display omsb-datatables">
				<thead>
					<tr>
						<th><liferay-ui:message key="ec-member-request-title" /></th>
						<th><liferay-ui:message key="ec-member-request-institution" /></th>
						<th><liferay-ui:message
								key="ec-member-request-country-of-institution" /></th>
						
						<th><liferay-ui:message
								key="ec-member-request-year-of-graduation" /></th>
						<th><liferay-ui:message key="ec-member-request-document" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach
						items="${ecMemberRequestDetails.educationalDetailsViewList}"
						var="ed">
						<tr>
							<td>${ed.title}</td>
							<td>${ed.institution}</td>
							<td>${ed.country}</td>
							<td>${ed.year}</td>
							<td><a href="${ed.docUrl}" target="_blank"
								class="dropdown-item">
									<button class="btn view_btn" title="View">
										<img
											src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
											alt="" />
										<liferay-ui:message key="ec-member-request-view-document" />
									</button>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>

	<h4 class="omsb-card-title pt-3">
		<liferay-ui:message
			key="ec-member-request-potential-member-existing-affiliations" />
	</h4>
	<c:if
		test="${fn:length(ecMemberRequestDetails.potentialMemberAffiliationDTOs) gt 0}">
		<div class="omsb-list-view table-responsive">
			<table class="display omsb-datatables">
				<thead>
					<tr>
						<th><liferay-ui:message key="ec-member-request-program" /></th>
						<th><liferay-ui:message key="ec-member-request-role" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pmAffiliation"
						items="${ecMemberRequestDetails.potentialMemberAffiliationDTOs}">
						<tr>
							<td>${pmAffiliation.program}</td>
							<td>${pmAffiliation.role}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<c:if
		test="${fn:length(ecMemberRequestDetails.potentialMemberAffiliationDTOs) le 0}">
				NA
			</c:if>

	<h4 class="omsb-card-title">
		<liferay-ui:message key="comments" />
	</h4>
	<ul class="omsb-comments-list pb-3">
		<li>
			<div class="omsb-comment-box">
				<div class="omsb-comment-box-header">
					<h3 class="comment-title">
						<span class="comment-author-name">${ecMemberRequestDetails.latestCommentSection.commenterUserName}</span>
						<c:set var="ecMemberRole"
							value="(${ecMemberRequestDetails.latestCommentSection.roleName})"></c:set>
						<span>${ecMemberRequestDetails.latestCommentSection.roleName eq '' ? '' : ecMemberRole }</span>
					</h3>
					<span class="posted-date">${ecMemberRequestDetails.latestCommentSection.createDate}</span>
				</div>
				<div>
					<p>${ecMemberRequestDetails.latestCommentSection.comment}</p>
				</div>
			</div> <c:if test="${not empty ecMemberRequestDetails.commentsSections}">
				<div class="colspan-child">
					<liferay-ui:message key="ec-member-request-expand" />
				</div>
			</c:if>
			<ul>
				<c:forEach var="commentsSection"
					items="${ecMemberRequestDetails.commentsSections}">
					<li>
						<div class="omsb-comment-box">
							<div class="omsb-comment-box-header">
								<h3 class="comment-title">
									<span class="comment-author-name">${commentsSection.commenterUserName}</span>
									<c:set var="ecMemberRole" value="(${commentsSection.roleName})"></c:set>
									<span>${commentsSection.roleName eq '' ? '' : ecMemberRole }</span>
								</h3>
								<span class="posted-date">${commentsSection.createDate}</span>
							</div>
							<div>
								<p>${commentsSection.comment}</p>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
		</li>
	</ul>

	<div class="row">
		<div class="col-md-12">
			<div class="bottom-backbtn-wrap mt-0">
				<a class="btn omsb-btn btn-back" href="${backURL}"><i
					class="fi fi-sr-arrow-left"></i>Back</a>
				<%@ include file="./workflow-actions.jsp"%>
			</div>
		</div>
	</div>
</div>


<!--// Inner Wrapper Contents -->
