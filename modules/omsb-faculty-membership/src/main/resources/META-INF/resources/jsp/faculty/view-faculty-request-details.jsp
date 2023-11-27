
<%@ include file="../../init.jsp" %>

<portlet:renderURL var="myFacultyRequestsURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>


<portlet:actionURL name="submitReviewMemberDetailRequest"
        var="submitReviewMemberDetailRequestActionURL" />

<div  class="container" id="wrapper">

	<div class="omsb-card">
		<div class="omsb-page-top-info">
			<div class="pagetitle"><liferay-ui:message key="view.faculty.request.details.heading" /></div>
		</div>	
		
		<div class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">
			<div class="omsb-page-top-info">
				<div class="pagetitle"><liferay-ui:message key="view.faculty.request.details" /></div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.program"/></div>						
						<c:if test="${empty facultyMembershipDetails.programName}">
							<div class="label-content">
								<liferay-ui:message key="faculty.request.data.not.available"/>
							</div>
						</c:if>
						<c:if test="${not empty facultyMembershipDetails.programName}">
							<div class="label-content">${facultyMembershipDetails.programName}</div>
						</c:if>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.training.site"/></div>						
						<c:if test="${empty facultyMembershipDetails.trainingSiteName}">
							<div class="label-content">
								<liferay-ui:message key="faculty.request.data.not.available"/>
							</div>
						</c:if>
						<c:if test="${not empty facultyMembershipDetails.trainingSiteName}">
							<div class="label-content">${facultyMembershipDetails.trainingSiteName}</div>
						</c:if>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.rotation"/></div>						
						<c:if test="${empty facultyMembershipDetails.rotationName}">
							<div class="label-content">
								<liferay-ui:message key="faculty.request.data.not.available"/>
							</div>
						</c:if>
						<c:if test="${not empty facultyMembershipDetails.rotationName}">
							<div class="label-content">${facultyMembershipDetails.rotationName}</div>
						</c:if>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.faculty.name"/></div>						
						<c:if test="${empty facultyMembershipDetails.facultyName}">
							<div class="label-content">
								<liferay-ui:message key="faculty.request.data.not.available"/>
							</div>
						</c:if>
						<c:if test="${not empty facultyMembershipDetails.facultyName}">
							<div class="label-content">${facultyMembershipDetails.facultyName}</div>
						</c:if>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.faculty.role"/></div>						
						<c:if test="${empty facultyMembershipDetails.facultyRole}">
							<div class="label-content">
								<liferay-ui:message key="faculty.request.data.not.available"/>
							</div>
						</c:if>
						<c:if test="${not empty facultyMembershipDetails.facultyRole}">
							<div class="label-content">${facultyMembershipDetails.facultyRole}</div>
						</c:if>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.cv"/></div>
						<div class="label-content">
							<c:if test="${empty facultyMembershipDetails.cvFileName}">								
								<liferay-ui:message key="faculty.request.data.not.available"/>								
							</c:if>
							<c:if test="${not empty facultyMembershipDetails.cvFileName}">
								${facultyMembershipDetails.cvFileName}
								<a href="${facultyMembershipDetails.cvFileUrl}" target="_blank">
									<button class="btn view_btn" title="View">
										<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""><liferay-ui:message key="ec-member-request-view-document"/>
									</button>
								</a>
							</c:if>					
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.civil.id"/></div>						
						<c:if test="${empty facultyMembershipDetails.civilId}">
							<div class="label-content">
								<liferay-ui:message key="faculty.request.data.not.available"/>
							</div>
						</c:if>
						<c:if test="${not empty facultyMembershipDetails.civilId}">
							<div class="label-content">${facultyMembershipDetails.civilId}</div>
						</c:if>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.passport.number"/></div>						
						<c:if test="${empty facultyMembershipDetails.passportNumber}">
							<div class="label-content">
								<liferay-ui:message key="faculty.request.data.not.available"/>
							</div>
						</c:if>
						<c:if test="${not empty facultyMembershipDetails.passportNumber}">
							<div class="label-content">${facultyMembershipDetails.passportNumber}</div>
						</c:if>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.dob"/></div>						
						<c:if test="${empty facultyMembershipDetails.dateOfBirth}">
							<div class="label-content">
								<liferay-ui:message key="faculty.request.data.not.available"/>
							</div>
						</c:if>
						<c:if test="${not empty facultyMembershipDetails.dateOfBirth}">
							<div class="label-content">${facultyMembershipDetails.dateOfBirth}</div>
						</c:if>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.email.id"/></div>						
						<c:if test="${empty facultyMembershipDetails.emailId}">
							<div class="label-content">
								<liferay-ui:message key="faculty.request.data.not.available"/>
							</div>
						</c:if>
						<c:if test="${not empty facultyMembershipDetails.emailId}">
							<div class="label-content">${facultyMembershipDetails.emailId}</div>
						</c:if>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.mobile.number"/></div>
						<c:if test="${empty personalDetails.mobile}">
							<liferay-ui:message key="faculty.request.data.not.available"/>
						</c:if>
						<c:if test="${not empty personalDetails.mobile}">
							<div class="label-content">${personalDetails.mobile}</div>
						</c:if>						
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.covering.letter"/></div>
						<div class="label-content">							
							<c:if test="${empty facultyMembershipDetails.coveringLetterFileName}">								
								<liferay-ui:message key="faculty.request.data.not.available"/>								
							</c:if>
							<c:if test="${not empty facultyMembershipDetails.coveringLetterFileName}">
								${facultyMembershipDetails.coveringLetterFileName}
								<a href="${facultyMembershipDetails.coveringLetterFileUrl}" target="_blank">
									<button class="btn view_btn" title="View">
										<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""><liferay-ui:message key="ec-member-request-view-document"/>
									</button>
								</a>
							</c:if>	
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">
			<div class="omsb-page-top-info">
				<div class="pagetitle"><liferay-ui:message key="faculty.request.bank.details.heading"/></div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.bank.name"/></div>						
						<c:if test="${empty facultyMembershipDetails.bankName}">
							<liferay-ui:message key="faculty.request.data.not.available"/>
						</c:if>
						<c:if test="${not empty facultyMembershipDetails.bankName}">
							<div class="label-content">${facultyMembershipDetails.bankName}</div>
						</c:if>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.account.number"/></div>						
						<c:if test="${empty facultyMembershipDetails.accountNumber}">
							<liferay-ui:message key="faculty.request.data.not.available"/>
						</c:if>
						<c:if test="${not empty facultyMembershipDetails.accountNumber}">
							<div class="label-content">${facultyMembershipDetails.accountNumber}</div>
						</c:if>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.branch.name"/></div>						
						<c:if test="${empty facultyMembershipDetails.bankBranchName}">
							<liferay-ui:message key="faculty.request.data.not.available"/>
						</c:if>
						<c:if test="${not empty facultyMembershipDetails.bankBranchName}">
							<div class="label-content">${facultyMembershipDetails.bankBranchName}</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
        
		<div class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">
			<div class="omsb-page-top-info">
				<div class="pagetitle"><liferay-ui:message key="faculty.request.id.details.heading"/></div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.passport.id"/></div>
						<div class="label-content">							
							<c:if test="${empty facultyMembershipDetails.passportCopyFileName}">								
								<liferay-ui:message key="faculty.request.data.not.available"/>								
							</c:if>
							<c:if test="${not empty facultyMembershipDetails.passportCopyFileName}">
								${facultyMembershipDetails.passportCopyFileName}
								<a href="${facultyMembershipDetails.passportCopyFileUrl}" target="_blank">
									<button class="btn view_btn" title="View">
										<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""><liferay-ui:message key="ec-member-request-view-document"/>
									</button>
								</a>
							</c:if>	
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="faculty.request.national.id.proof"/></div>
						<div class="label-content">							
							<c:if test="${empty facultyMembershipDetails.nationalIdProofFileName}">								
								<liferay-ui:message key="faculty.request.data.not.available"/>								
							</c:if>
							<c:if test="${not empty facultyMembershipDetails.nationalIdProofFileName}">
								${facultyMembershipDetails.nationalIdProofFileName}
								<a href="${facultyMembershipDetails.nationalIdProofFileUrl}" target="_blank">
									<button class="btn view_btn" title="View">
										<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""><liferay-ui:message key="ec-member-request-view-document"/>
									</button>
								</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap mb-1">
			<div class="omsb-page-top-info">
				<div class="pagetitle"><liferay-ui:message key="faculty.request.education.details.heading"/></div>
			</div>
			<div class="omsb-card px-0 pt-0 pb-0 other-documents-wrap">
				<div class="omsb-list-view table-responsive">
					<table class="display omsb-datatables" id="other-documentss-table">
						<caption></caption>
						<thead>
							<tr>
								<th><liferay-ui:message key="faculty.request.education.title"/></th>
								<th><liferay-ui:message key="faculty.request.education.institution"/></th>
								<th><liferay-ui:message key="faculty.request.education.institution.country"/></th>
								<th><liferay-ui:message key="faculty.request.education.gpa"/></th>
								<th><liferay-ui:message key="faculty.request.education.year"/></th>
								<th><liferay-ui:message key="faculty.request.education.qualification.documents"/></th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty educationDetails}">
								<c:forEach items="${educationDetails}" var="educationDetail">
									<tr>
										<td>
											<c:if test="${empty educationDetail.title}">
												<liferay-ui:message key="faculty.request.data.not.available"/>
											</c:if>
											<c:if test="${not empty educationDetail.title}">
												${educationDetail.title}
											</c:if>
										</td>
										<td>											
											<c:if test="${empty educationDetail.institution}">
												<liferay-ui:message key="faculty.request.data.not.available"/>
											</c:if>
											<c:if test="${not empty educationDetail.institution}">
												${educationDetail.institution}
											</c:if>
										</td>
										<td>											
											<c:if test="${empty educationDetail.country}">
												<liferay-ui:message key="faculty.request.data.not.available"/>
											</c:if>
											<c:if test="${not empty educationDetail.country}">
												${educationDetail.country}
											</c:if>
										</td>
										<td>
											<c:if test="${empty educationDetail.gpa}">
												<liferay-ui:message key="faculty.request.data.not.available"/>
											</c:if>
											<c:if test="${not empty educationDetail.gpa}">
												${educationDetail.gpa}
											</c:if>
										</td>
										<td>
											<c:if test="${empty educationDetail.year}">
												<liferay-ui:message key="faculty.request.data.not.available"/>
											</c:if>
											<c:if test="${not empty educationDetail.year}">
												${educationDetail.year}
											</c:if>
										</td>
										<td>											
											<c:if test="${empty educationDetail.docName}">								
												<liferay-ui:message key="faculty.request.data.not.available"/>								
											</c:if>
											<c:if test="${not empty educationDetail.docName}">
												<a href="${educationDetail.docUrl}" target="_blank" class="btn upload_btn">
													${educationDetail.docName}
												</a>
											</c:if>
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
		</div>		

		<div class="omsb-card omsb-noBorderRadius other-documents-wrap mb-1">
			<div class="omsb-page-top-info">
				<div class="pagetitle"><liferay-ui:message key="faculty.request.existing.affiliations.heading"/></div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="omsb-list-view table-responsive table-input">
						<table class="display omsb-datatables">
							<caption></caption>
							<thead>
								<tr>
									<th><liferay-ui:message key="faculty.request.program"/></th>
									<th><liferay-ui:message key="faculty.request.faculty.role"/></th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${not empty existingAffliationsDetails}">
									<c:forEach items="${existingAffliationsDetails}" var="existingAffliation">
										<tr>
											<td>
												<c:if test="${empty existingAffliation.programName}">
													<liferay-ui:message key="faculty.request.data.not.available"/>
												</c:if>
												<c:if test="${not empty existingAffliation.programName}">
													${existingAffliation.programName}
												</c:if>
											</td>
											<td>
												<c:if test="${empty existingAffliation.roleName}">
													<liferay-ui:message key="faculty.request.data.not.available"/>
												</c:if>
												<c:if test="${not empty existingAffliation.roleName}">
													${existingAffliation.roleName}
												</c:if>
											</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div class="omsb-card px-0 mb-0">
			<h4 class="omsb-card-title"><liferay-ui:message key="faculty.request.comments.heading"/></h4>
            <ul class="omsb-comments-list">
                <li>
					<c:if test="${not empty commentDetails}">
						<div class="omsb-comment-box">
							<div class="omsb-comment-box-header">
								<h3 class="comment-title"><span class="comment-author-name" >${commentDetails[0].commentBy} </span>(${commentDetails[0].role})</h3>
								<span class="posted-date">${commentDetails[0].date}</span>
							</div>
							<div class="omsb-comment-body">
								<p>
									<c:if test="${empty commentDetails[0].comment}">
										<liferay-ui:message key="faculty.request.data.not.available"/>
									</c:if>
									<c:if test="${not empty commentDetails[0].comment}">
										${commentDetails[0].comment}
									</c:if>
								</p>
							</div>
						</div>
						<c:if test="${commentDetails.size() gt 1}">
							<div class="colspan-child"><liferay-ui:message key="faculty.request.expand.comments"/></div>
							<ul>
								<c:forEach items="${commentDetails}" var="commentDetail" begin="1">
									<li>
										<div class="omsb-comment-box">
											<div class="omsb-comment-box-header">
												<h3 class="comment-title"><span class="comment-author-name" >${commentDetail.commentBy} </span>(${commentDetail.role})</h3>
												<span class="posted-date">${commentDetail.date}</span>
											</div>
											<div class="omsb-comment-body">
												<p>
													<c:if test="${empty commentDetail.comment}">
														<liferay-ui:message key="faculty.request.data.not.available"/>
													</c:if>
													<c:if test="${not empty commentDetail.comment}">
														${commentDetail.comment}
													</c:if>
												</p>
											</div>
										</div>
									</li>
								</c:forEach>
							</ul>
						</c:if>
					</c:if>
                </li>
            </ul>
		</div>

        <div class="bottom-backbtn-wrap mt-0">
            <a class="btn omsb-btn btn-back" href="${myFacultyRequestsURL}">Back</a>
            <%@ include file="../workflow-actions.jsp"%>
        </div>
	</div>
</div>

<!-- Modal popup -->
        <div class="modal fade omsb-modal" id="ec_mem_detail_view"
                tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
                aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                        <form action="<%=submitReviewMemberDetailRequestActionURL%>"
                                class="popup-form" method="post">
                                <div class="modal-content">
                                        <div class="modal-header">
                                                <input name="<portlet:namespace />workflow-details"
                                                        id="<portlet:namespace />workflow-details" type="hidden" />
                                                <h5 class="modal-title" id="exampleModalLongTitle">
                                                        <liferay-ui:message key="ec-member-request-adjudicate" />
                                                </h5>
                                                <button type="button" class="close popup-reset"
                                                        data-dismiss="modal" onClick="closePopup()" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                </button>
                                        </div>
                                        <div class="modal-body">
                                                <div class="row">
                                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                                                <div class="form-group">
                                                                        <label><liferay-ui:message
                                                                                        key="ec-member-request-comments" /></label>
                                                                        <textarea name="<portlet:namespace />popup_adjudicate_comment"
                                                                                oninput="handleInput(this)" class="form-control comment"
                                                                                id="<portlet:namespace />popup_adjudicate_comment"></textarea>
                                                                        <span class="errorCommentMsg" style="color: red;"></span>
                                                                </div>
                                                        </div>
                                                </div>
                                        </div>
                                        <div class="modal-footer ec-mem-detail-view-action"></div>
                                </div>
                        </form>
                </div>
        </div>
        <!-- Modal popup -->
        
<script type="text/javascript">

function reviewMemberDetails(requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
        const transitionList = transitionNames.split(",");
        const transitionLevelsList = transitionLevels.split(",");
        
         $(".ec-mem-detail-view-action").empty();
        
         $.each( transitionList, function(index, tName ){
                         let details ="{requestId:"+requestId+", workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+tName+"}";
                         var tNameSplit = tName.split("_").pop();
                        $(".ec-mem-detail-view-action").append('<button class="btn omsb-bc-red-button" id="transitionbutton" type="submit" onClick="return submitReviewDetails(\'' + details + '\', \'<portlet:namespace/>workflow-details\', \'' +tNameSplit+ '\');" >'+transitionLevelsList[index]+'</button>');
                
           });
         $(".ec-mem-detail-view-action").append('<button type="button" class="btn omsb-btn omsb-bg-red-button popup-reset" onClick="closePopup()" data-dismiss="modal">Close</button>');
        
        
        $("#actions").attr("data-target","#ec_mem_detail_view");
        $("#ec_mem_detail_view").modal("show");
}

function submitReviewDetails(details, fieldId,tNameSplit) {
        $("#"+fieldId).val(details);
        if(tNameSplit.toUpperCase() === 'REJECT')
        {
                return rejectECRequestResource();
        }
         else{        
                $("#ec_mem_detail_view").modal("hide");        
        }
        return true;
}

</script>