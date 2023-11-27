<%@ include file="../init.jsp"%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<div class="omsb-card">
	<div class="omsb-page-top-info mb-4">
		<div class="pagetitle">
			<liferay-ui:message key="ec-member-request-view-member-details" />
		</div>
	</div>

	<h4 class="omsb-card-title pt-4">
		<liferay-ui:message
			key="ec-member-request-potential-member-bank-details" />
	</h4>
	<div class="row">
		<div class="col-md-4 col-sm-6 col-xs-6 label-box">
			<label class="label-name"><liferay-ui:message
					key="ec-member-request-bank-name" /></label> <label class="label-content">
				<c:if test="${empty memberDetails.bankName}">NA</c:if> <c:if
					test="${not empty memberDetails.bankName}">${memberDetails.bankName}</c:if>
			</label>
		</div>
		<div class="col-md-4 col-sm-6 col-xs-6 label-box">
			<label class="label-name"> <liferay-ui:message
					key="ec-member-request-account-number" />
			</label> <label class="label-content"> <c:if
					test="${empty memberDetails.accountNo}">NA</c:if> <c:if
					test="${not empty memberDetails.accountNo}">${memberDetails.accountNo}</c:if>
			</label>
		</div>
		<div class="col-md-4 col-sm-6 col-xs-6 label-box">
			<label class="label-name"><liferay-ui:message
					key="ec-member-request-branch-name" /></label> <label
				class="label-content"> <c:if
					test="${empty memberDetails.bankBranch}">NA</c:if> <c:if
					test="${not empty memberDetails.bankBranch}">${memberDetails.bankBranch}</c:if>
			</label>
		</div>
	</div>


	<h4 class="omsb-card-title pt-3">
		<liferay-ui:message
			key="ec-member-request-potential-member-id-details" />
	</h4>
	<div class="omsb-card-graybg omsb-card omsb-BorderRadius-4 pb-0">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12 pt-3">
				<div class="label-name">
					<liferay-ui:message key="ec-member-request-passport" />
				</div>
				<c:if test="${empty memberDetails.passportUrl}">
					<div class="label-content">NA</div>
				</c:if>
				<c:if test="${not empty memberDetails.passportUrl}">
					<div class="omsb-card-caserport ">
						<div class="leftbar">
							<h4 class="casereport-title">
								<liferay-ui:message key="ec-member-request-passport" />
								<%-- ${memberDetails.passportName} --%>
							</h4>
						</div>
						<div class="righbar">
							<a href="${memberDetails.passportUrl}" target="blank">
								<button class="btn view_btn" title="View">
									<img
										src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
										alt="" />View
								</button>
							</a>
						</div>
					</div>
				</c:if>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12 pt-3">
				<div class="label-name pb-3">
					<liferay-ui:message key="ec-member-request-nationality" />
				</div>
				<c:if test="${empty memberDetails.nationalIdUrl}">
					<div class="label-content">NA</div>
				</c:if>
				<c:if test="${not empty memberDetails.nationalIdUrl}">
					<div class="omsb-card-caserport ">
						<div class="leftbar">
							<h4 class="casereport-title">
								<liferay-ui:message key="ec-member-request-nationality" />
								<%-- ${memberDetails.nationalIdName} --%>
							</h4>
						</div>
						<div class="righbar">
							<a href="${memberDetails.nationalIdUrl}" target="blank">
								<button class="btn view_btn" title="View">
									<img
										src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
										alt="" />View
								</button>
							</a>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>

	<h4 class="omsb-card-title pt-3">
		<liferay-ui:message
			key="ec-member-request-potential-member-education-details" />
	</h4>
	<div class="omsb-card-graybg omsb-card omsb-BorderRadius-4 pb-0">
		<div class="row">
			<div class="col-md-4 col-sm-6 col-xs-6 label-box">
				<label class="label-name"><liferay-ui:message
						key="ec-member-request-title" /></label> <label class="label-content">
					<c:if test="${empty memberDetails.title}">NA</c:if> <c:if
						test="${not empty memberDetails.title}">${memberDetails.title}</c:if>
				</label>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-6 label-box">
				<label class="label-name"><liferay-ui:message
						key="ec-member-request-institution" /></label> <label
					class="label-content"> <c:if
						test="${empty memberDetails.institution}">NA</c:if> <c:if
						test="${not empty memberDetails.institution}">${memberDetails.institution}</c:if>
				</label>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-6 label-box">
				<label class="label-name"><liferay-ui:message
						key="ec-member-request-country-of-institution" /></label> <label
					class="label-content"> <c:if
						test="${empty memberDetails.countryOfInstitution}">NA</c:if> <c:if
						test="${not empty memberDetails.countryOfInstitution}">${memberDetails.countryOfInstitution}</c:if>
				</label>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-6 label-box">
				<label class="label-name"> <liferay-ui:message
						key="ec-member-request-gpa" />
				</label> <label class="label-content"> <c:if
						test="${empty memberDetails.gpa}">NA</c:if> <c:if
						test="${not empty memberDetails.gpa}">${memberDetails.gpa}</c:if>
				</label>
			</div>
			<div class="col-md-4 col-sm-6 col-xs-6 label-box">
				<label class="label-name"> <liferay-ui:message
						key="ec-member-request-year-of-graduation" />
				</label> <label class="label-content"> <c:if
						test="${empty memberDetails.yearOfGraduation}">NA</c:if> <c:if
						test="${not empty memberDetails.yearOfGraduation}">${memberDetails.yearOfGraduation}</c:if>
				</label>
			</div>
			<!-- <div class="col-md-4 col-sm-6 col-xs-6 label-box">
				<label class="label-name">Qualification Document</label> <label
					class="label-content">Qualificati_document.pdf <span
					class="status-buttons"><a href="#"
						class="view-download-link">view</a> <a href="#"
						class="view-download-link" download>Download</a></span></label>
			</div> -->
		</div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12 pt-3">
				<div class="label-name pb-3">
					<liferay-ui:message key="ec-member-request-qualification-document" />
				</div>
				<c:if test="${empty memberDetails.qualificationDocumentUrl}">-</c:if>
				<c:if test="${not empty memberDetails.qualificationDocumentUrl}">
					<div class="omsb-card-caserport ">
						<div class="leftbar">
							<h4 class="casereport-title">${memberDetails.qualificationDocumentName}</h4>
						</div>
						<div class="righbar">
							<a href="${memberDetails.qualificationDocumentUrl}"
								target="blank">
								<button class="btn view_btn" title="View">
									<img
										src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
										alt="" />View
								</button>
							</a>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>

	<h4 class="omsb-card-title">
		<liferay-ui:message key="ec-member-request-comments" />
	</h4>
	<ul class="omsb-comments-list pb-3">
		<li>
			<div class="omsb-comment-box">
				<div class="omsb-comment-box-header">
					<h3 class="comment-title">
						<span class="comment-author-name">
							${memberDetails.latestCommentSection.commenterUserName}</span>
						${memberDetails.latestCommentSection.roleName}
					</h3>
					<span class="posted-date">${memberDetails.latestCommentSection.createDate}</span>
				</div>
				<div>
					<p>${memberDetails.latestCommentSection.comment}</p>
				</div>
			</div>
			<div class="colspan-child">
			<liferay-ui:message key="ec-member-request-expand" />
			</div>
			<ul>
				<c:forEach var="commentsSection"
					items="${memberDetails.commentsSections}">
					<li>
						<div class="omsb-comment-box">
							<div class="omsb-comment-box-header">
								<h3 class="comment-title">
									<span class="comment-author-name">
										${memberDetails.latestCommentSection.commenterUserName}</span>
									${memberDetails.latestCommentSection.roleName}
								</h3>
								<span class="posted-date">${memberDetails.latestCommentSection.createDate}</span>
							</div>
							<div>
								<p>${memberDetails.latestCommentSection.comment}</p>
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
					class="fi fi-sr-arrow-left"></i><liferay-ui:message key="ec-member-request-back" /></a>
			</div>
		</div>
	</div>

</div>
