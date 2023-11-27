<%@ include file="../init.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<portlet:renderURL  var="backURL" >
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<!-- Inner Wrapper Contents -->
		<div class="omsb-card">
			<div class="omsb-page-top-info mb-4">
				<div class="pagetitle"><liferay-ui:message key="view-ec-membership-request"/></div>
				<div class="righbar">${ecMemberRequestDetails.latestStatus}</div>
			</div>


			<h4 class="omsb-card-title pt-4">Request Details</h4>
			<div class="row">
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Program</div>
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
						<div class="label-name">Potential Member name</div>
						<div class="label-content">
							<c:if test="${empty ecMemberRequestDetails.givenNameAsPassport}">NA</c:if>
							<c:if test="${not empty ecMemberRequestDetails.givenNameAsPassport}">${ecMemberRequestDetails.givenNameAsPassport}</c:if>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Membership role</div>
						<div class="label-content">
							<c:if test="${empty ecMemberRequestDetails.membershipRoleName}">NA</c:if>
							<c:if test="${not empty ecMemberRequestDetails.membershipRoleName}">${ecMemberRequestDetails.membershipRoleName}</c:if>
						</div>
					</div>
				</div>
				
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="form-group-view">					
				    <div class="label-name">CV</div>
				    	<c:if test="${empty ecMemberRequestDetails.cvUrl}"><div class="label-content">NA</div></c:if>
						<c:if test="${not empty ecMemberRequestDetails.cvUrl}">
							<div class="omsb-card-caserport ">
								<div class="leftbar">
									<h4 class="casereport-title">CV<%-- ${ecMemberRequestDetails.cvName} --%></h4>
								</div>
								<div class="righbar">
									<a href="${ecMemberRequestDetails.cvUrl}" target="_blank">
										<button class="btn view_btn" title="View">
											<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt="">View Document
										</button>
									</a>
								</div>
							</div>
						</c:if>
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
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Civil ID</div>
						<div class="label-content">
							<c:if test="${empty ecMemberRequestDetails.civilId}">NA</c:if>
							<c:if test="${not empty ecMemberRequestDetails.civilId}">${ecMemberRequestDetails.civilId}</c:if>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Passport No</div>
						<div class="label-content">
							<c:if test="${empty ecMemberRequestDetails.passportNumber}">NA</c:if>
							<c:if test="${not empty ecMemberRequestDetails.passportNumber}">${ecMemberRequestDetails.passportNumber}</c:if>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Date of birth</div>
						<div class="label-content">
							<c:if test="${empty ecMemberRequestDetails.dateOfBirth}">NA</c:if>
							<c:if test="${not empty ecMemberRequestDetails.dateOfBirth}">${ecMemberRequestDetails.dateOfBirth}</c:if>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Qarar</div>
						<div class="label-content">
							<c:if test="${empty ecMemberRequestDetails.qarar}">NA</c:if>
							<c:if test="${not empty ecMemberRequestDetails.qarar}">${ecMemberRequestDetails.qarar}</c:if>
						</div>
					</div>
				</div>
				
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="form-group-view">					
				    <div class="label-name">Covering letter</div>
				    	<c:if test="${empty ecMemberRequestDetails.coveringLetterUrl}"><div class="label-content">NA</div></c:if>
						<c:if test="${not empty ecMemberRequestDetails.coveringLetterUrl}">
							<div class="omsb-card-caserport ">
								<div class="leftbar">
									<h4 class="casereport-title">Covering letter<%-- ${ecMemberRequestDetails.coveringLetterName} --%></h4>
								</div>
								<div class="righbar">
									<a href="${ecMemberRequestDetails.coveringLetterUrl}" target="_blank">
										<button class="btn view_btn" title="View">
											<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt="">View Document
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
				    <div class="label-name">No objection letter</div>
				    	<c:if test="${empty ecMemberRequestDetails.noObjectionLetterUrl}"><div class="label-content">NA</div></c:if>
						<c:if test="${not empty ecMemberRequestDetails.noObjectionLetterUrl}">
							<div class="omsb-card-caserport ">
								<div class="leftbar">
									<h4 class="casereport-title">No objection letter<%-- ${ecMemberRequestDetails.noObjectionLetterName} --%></h4>
								</div>
								<div class="righbar">
									<a href="${ecMemberRequestDetails.noObjectionLetterUrl}" target="_blank">
										<button class="btn view_btn" title="View">
											<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt="">View Document
										</button>
									</a>
								</div>
							</div>
						</c:if>
					</div>
				</div>
				<!-- <div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">No objection letter</div>
						<div class="label-content"></div>
					</div>
				</div> -->


			</div>
			<h4 class="omsb-card-title pt-3">Potential Member Bank Details</h4>
			<c:if test="${empty ecMemberRequestDetails.bankName and empty ecMemberRequestDetails.accountNo and empty ecMemberRequestDetails.bankBranch}">
				NA
			</c:if>
			<c:if test="${not empty ecMemberRequestDetails.bankName or not empty ecMemberRequestDetails.accountNo or not empty ecMemberRequestDetails.bankBranch}">
				<div class="row">
					<div class="col-md-4 col-sm-6 col-xs-6">
						<div class="form-group-view">
							<div class="label-name">Bank name</div>
							<div class="label-content">
								<c:if test="${empty ecMemberRequestDetails.bankName}">NA</c:if>
								<c:if test="${not empty ecMemberRequestDetails.bankName}">${ecMemberRequestDetails.bankName}</c:if>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 col-xs-6">
						<div class="form-group-view">
							<div class="label-name">Account No</div>
							<div class="label-content">
								<c:if test="${empty ecMemberRequestDetails.accountNo}">NA</c:if>
								<c:if test="${not empty ecMemberRequestDetails.accountNo}">${ecMemberRequestDetails.accountNo}</c:if>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 col-xs-6">
						<div class="form-group-view">
							<div class="label-name">Bank Branch</div>
							<div class="label-content">
								<c:if test="${not empty ecMemberRequestDetails.bankBranch}">${ecMemberRequestDetails.bankBranch}</c:if>
								<c:if test="${empty ecMemberRequestDetails.bankBranch}">NA</c:if>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			
			<h4 class="omsb-card-title pt-3">Potential Member ID Details</h4>
			
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12 pt-3">
					<div class="label-name pb-3">Passport</div>
					<c:if test="${empty ecMemberRequestDetails.passportUrl}">NA</c:if>
					<c:if test="${not empty ecMemberRequestDetails.passportUrl}">
						<div class="omsb-card-caserport ">
							<div class="leftbar">
								<h4 class="casereport-title">Passport<%-- ${ecMemberRequestDetails.passportName} --%></h4>
							</div>
							<div class="righbar">
								<a href="${ecMemberRequestDetails.passportUrl}" target="_blank">
									<button class="btn view_btn" title="View">
										<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""/>View Document
									</button>
								</a>
							</div>
						</div>
					</c:if>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12 pt-3">
					<div class="label-name pb-3">Nationality</div>
					<c:if test="${empty ecMemberRequestDetails.nationalIdUrl}">NA</c:if>
					<c:if test="${not empty ecMemberRequestDetails.nationalIdUrl}">
						<div class="omsb-card-caserport ">
							<div class="leftbar">
								<h4 class="casereport-title">Nationality<%-- ${ecMemberRequestDetails.nationalIdName} --%></h4>
							</div>
							<div class="righbar">
								<a href="${ecMemberRequestDetails.nationalIdUrl}" target="_blank">
									<button class="btn view_btn" title="View">
										<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""/>View Document
									</button>
								</a>
							</div>
						</div>
					</c:if>
				</div>
			</div>
			
			<h4 class="omsb-card-title pt-3">Potential Member Education
				Details</h4>
			<c:if test="${empty ecMemberRequestDetails.title and empty ecMemberRequestDetails.institution and 
				empty ecMemberRequestDetails.countryOfInstitution and empty ecMemberRequestDetails.gpa and empty ecMemberRequestDetails.yearOfGraduation}">
				NA
			</c:if>
			<c:if test="${not empty ecMemberRequestDetails.title or not empty ecMemberRequestDetails.institution or 
				not empty ecMemberRequestDetails.countryOfInstitution or not empty ecMemberRequestDetails.gpa or not empty ecMemberRequestDetails.yearOfGraduation}">
				<div class="omsb-card-graybg omsb-card omsb-BorderRadius-4 pb-0">
					<div class="row">
						<div class="col-md-4 col-sm-6 col-xs-6">
							<div class="form-group-view">
								<div class="label-name">Title</div>
								<div class="label-content">
									<c:if test="${empty ecMemberRequestDetails.title}">NA</c:if>
									<c:if test="${not empty ecMemberRequestDetails.title}">${ecMemberRequestDetails.title}</c:if>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6 col-xs-6">
							<div class="form-group-view">
								<div class="label-name">Instituion</div>
								<div class="label-content">
									<c:if test="${empty ecMemberRequestDetails.institution}">NA</c:if>
									<c:if test="${not empty ecMemberRequestDetails.institution}">${ecMemberRequestDetails.institution}</c:if>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6 col-xs-6">
							<div class="form-group-view">
								<div class="label-name">Country of Instituion</div>
								<div class="label-content">
									<c:if test="${empty ecMemberRequestDetails.countryOfInstitution}">NA</c:if>
									<c:if test="${not empty ecMemberRequestDetails.countryOfInstitution}">${ecMemberRequestDetails.countryOfInstitution}</c:if>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6 col-xs-6">
							<div class="form-group-view">
								<div class="label-name">GPA</div>
								<div class="label-content">
									<c:if test="${empty ecMemberRequestDetails.gpa}">NA</c:if>
									<c:if test="${not empty ecMemberRequestDetails.gpa}">${ecMemberRequestDetails.gpa}</c:if>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-sm-6 col-xs-6">
							<div class="form-group-view">
								<div class="label-name">Year Of graduation</div>
								<div class="label-content">
									<c:if test="${empty ecMemberRequestDetails.yearOfGraduation}">NA</c:if>
									<c:if test="${not empty ecMemberRequestDetails.yearOfGraduation}">${ecMemberRequestDetails.yearOfGraduation}</c:if>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12 pt-3">
								<div class="form-group-view">
									<div class="label-name">Qualification Document</div>
									<c:if test="${empty ecMemberRequestDetails.qualificationDocumentUrl}"><div class="label-content">NA</div></c:if>
									<c:if test="${not empty ecMemberRequestDetails.qualificationDocumentUrl}">
										<div class="omsb-card-caserport ">
											<div class="leftbar">
												<h4 class="casereport-title">${ecMemberRequestDetails.qualificationDocumentName}</h4>
											</div>
											<div class="righbar">
												<a href="${ecMemberRequestDetails.qualificationDocumentUrl}" target="_blank">
													<button class="btn view_btn" title="View">
														<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""/>View Document
													</button>
												</a>
											</div>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			
			<h4 class="omsb-card-title pt-3">Potential Member Existing Affiliations</h4>
			<c:if test="${fn:length(ecMemberRequestDetails.potentialMemberAffiliationDTOs) gt 0}">
				<div class="omsb-list-view table-responsive">
					<table class="display omsb-datatables">
						<thead>
							<tr>
								<th>Program</th>
								<th>Role</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pmAffiliation" items="${ecMemberRequestDetails.potentialMemberAffiliationDTOs}">
								<tr>
									<td>${pmAffiliation.program}</td>
									<td>${pmAffiliation.role}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
			<c:if test="${fn:length(ecMemberRequestDetails.potentialMemberAffiliationDTOs) le 0}" >
				NA
			</c:if>
			
						<h4 class="omsb-card-title"><liferay-ui:message key="comments"/></h4>
			<ul class="omsb-comments-list pb-3">
				<li>
					<div class="omsb-comment-box">
						<div class="omsb-comment-box-header">
							<h3 class="comment-title">
								<span class="comment-author-name">${ecMemberRequestDetails.latestCommentSection.commenterUserName}</span>${ecMemberRequestDetails.latestCommentSection.roleName}
							</h3>
							<span class="posted-date">${ecMemberRequestDetails.latestCommentSection.createDate}</span>
						</div>
						<div >
							<p>${ecMemberRequestDetails.latestCommentSection.comment}</p>
						</div>
					</div>
					<div class="colspan-child"><liferay-ui:message key="expand"/></div>
					<ul>
						<c:forEach var="commentsSection" items="${ecMemberRequestDetails.commentsSections}">
							<li>
								<div class="omsb-comment-box">
									<div class="omsb-comment-box-header">
										<h3 class="comment-title">
											<span class="comment-author-name">${commentsSection.commenterUserName}</span>${commentsSection.roleName}
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


