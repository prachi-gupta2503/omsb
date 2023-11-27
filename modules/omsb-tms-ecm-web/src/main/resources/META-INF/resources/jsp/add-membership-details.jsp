<%@page import="gov.omsb.tms.ecm.web.dto.CustomCountryItems"%>
<%@page import="gov.omsb.tms.ecm.web.util.AddEditMemberDetailsUtil"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.google.gson.Gson"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<style>
.required-asterisk .control-label:after {
	content: " *";
	color: #DC143C !important;
	font-size: 20px;
}
</style>
<c:if
	test="<%=!SessionErrors.isEmpty(renderRequest) && SessionMessages.isEmpty(renderRequest)%>">
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
					<span> <liferay-ui:message
							key="<%=SessionMessages.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>

<portlet:actionURL
	name="<%=MVCCommandNames.ADD_MEMBERSHIP_DETAILS_ACTIONS%>"
	var="addMemberDetailsActionURL">
	<portlet:param name="ecMemberRequestId" value="${ecMemberRequestId}" />
</portlet:actionURL>

<portlet:resourceURL
	id="<%=MVCCommandNames.ADD_EC_MEMBER_EDUCATION_DETAILS%>"
	var="addMemberEducationResourceUrl">
	<portlet:param name="ecMemberRequestId" value="${ecMemberRequestId}" />
</portlet:resourceURL>

<portlet:resourceURL id="/educationDetails/data"
	var="getEducationDetailsData">
	<portlet:param name="ecMemberRequestId" value="${ecMemberRequestId}" />
</portlet:resourceURL>

<portlet:resourceURL id="edit/educationDetails/"
	var="editEducationDetailsData">
	<portlet:param name="ecMemberRequestId" value="${ecMemberRequestId}" />
</portlet:resourceURL>
<portlet:resourceURL id="<%=MVCCommandNames.GET_UNIVERSITY_DETAILS%>"
	var="getUniversityDetailsURL" />
<portlet:resourceURL
	id="<%=MVCCommandNames.DELETE_EDUCATION_DETAILS_URL%>"
	var="deleteEducationDetailURL" />
<div class="main-content">
	<!--- Start Main Content Section Here --->
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">
		<!-- breadcrumbs -->
		<div class="omsb-breadcrumbs">
			<div class="container ">
				<div class="omsb-breadcrumbs-wrap">
					<div class="leftbar">
						<div class="breadcrumb-link">
							<ul>
								<li><a href="#" class="trans" title="Home"><liferay-ui:message
											key="ec-member-request-home" /></a></li>
								<li><liferay-ui:message key="ec-member-request-membership" /></li>
							</ul>
						</div>

					</div>

				</div>
			</div>
		</div>
		<!-- breadcrumbs -->

		<!-- Inner Wrapper Contents -->
		<div id="wrapper">
			<div class="container">
				<div class="omsb-card">
					<div class="omsb-page-top-info mb-4">
						<div class="pagetitle">
							<liferay-ui:message
								key="ec-member-request-add-edit-member-details"></liferay-ui:message>
						</div>
					</div>
					<aui:form action="${addMemberDetailsActionURL}" method="post"
						name="addMemberDetails" enctype="multipart/form-data">
						<aui:input type="hidden" name="workflowTaskDetails" />
						<div class="row">
							<div class="col-md-4 col-sm-6 col-xs-6">
								<div class="form-group">
									<aui:input type="text" name="bankName" class="form-control"
										label="ec-member-request-bank-name">
										<aui:validator name="required" />
									</aui:input>
								</div>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6">
								<div class="form-group">
									<aui:input type="text" name="accountNumber"
										class="form-control" label="ec-member-request-account-number">
										<aui:validator name="required" />
									</aui:input>
								</div>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-6">
								<div class="form-group">
									<aui:input type="text" name="bankBranch" class="form-control"
										label="ec-member-request-branch-name">
										<aui:validator name="required" />
									</aui:input>
								</div>
							</div>
						</div>
						<h4 class="omsb-card-title pt-3">
							<liferay-ui:message
								key="ec-member-request-potential-member-id-details"></liferay-ui:message>
						</h4>
						<div class="omsb-card-graybg omsb-card omsb-BorderRadius-4 pb-0">
							<div class="row">
								<div class="col-md-12 col-sm-12 col-xs-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="ec-member-request-civil-id" />
										</div>
										<div class="label-content">
											<c:if test="${empty civilId}">NA</c:if>
											<%-- <c:if test="${not empty ecMemberRequestDetails.civilId}">${ecMemberRequestDetails.civilId}</c:if> --%>
											<c:if test="${not empty civilCardFrontPhotoUrl}">
												<div class="omsb-card-caserport row">

													<div class=" righbar col-4 casereport-title">
														<div class="casereport-title">${civilId}</div>
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

							</div>
							<div class="row">
								<div class="col-md-6 col-sm-6 col-xs-6 pt-3">
									<div class="label-name pb-3">
										<liferay-ui:message key="ec-member-request-national-id" />
									</div>
									<c:if test="${empty civilCardFrontPhotoUrl}">
										<liferay-ui:message key="not-available" />
									</c:if>
									<c:if test="${not empty civilCardFrontPhotoUrl}">
										<div class="label-content">
											<div class="omsb-card-caserport ">
												<div class="leftbar">
													<h4 class="casereport-title">${civilId}</h4>
												</div>
												<div class="righbar">
													<a href="${civilCardFrontPhotoUrl}" target="_blank">
														<button class="btn view_btn" title="View" type="button">
															<img
																src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
																alt="">
															<liferay-ui:message key="view" />
														</button>
													</a> <a href="${civilCardBackPhotoUrl}" target="_blank">
														<button class="btn view_btn" title="View" type="button">
															<img
																src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
																alt="">
															<liferay-ui:message key="view" />
														</button>
													</a>
												</div>
											</div>
										</div>
									</c:if>

								</div>
							</div>
						</div>
						<div class="omsb-card-graybg omsb-card omsb-BorderRadius-4">
							<h4 class="omsb-card-title pt-3">
								<liferay-ui:message
									key="ec-member-request-potential-member-education-details"></liferay-ui:message>
								<button class="btn omsb-bc-red-button" data-toggle="modal"
									data-target="#addmem_edu_detail" type="button">
									<liferay-ui:message
										key="ec-member-request-add-education-details" />
								</button>
							</h4>
							<div class="omsb-list-view table-responsive">
								<table id="educationDetailTable" class="display omsb-datatables">
									<thead>
										<tr>
											<th><liferay-ui:message key="ec-member-request-title" /></th>
											<th><liferay-ui:message
													key="ec-member-request-institution" /></th>
											<th><liferay-ui:message
													key="ec-member-request-country-of-institution" /></th>
											<th><liferay-ui:message key="ec-member-request-gpa" /></th>
											<th><liferay-ui:message
													key="ec-member-request-year-of-graduation" /></th>
											<th><liferay-ui:message key="ec-member-request-document" /></th>
											<th><liferay-ui:message key="ec-member-request-action" /></th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
						<div class="bottom-backbtn-wrap mt-4">
							<c:choose>
								<c:when test="${not empty workflowTaskDetail.actionList }">
									<button class="btn omsb-bc-red-button" type="submit"
										title="Resend Request" id="submitBtn"
										onClick="return saveAndSubmit(`${workflowTaskDetail.taskId }`,
																		`${workflowTaskDetail.firstTransitionName}`,`${workflowTaskDetail.workflowInstanceId }`)">
										<liferay-ui:message key="ec-member-request-submit" />
									</button>
								</c:when>
								<c:otherwise>
									<button class="btn omsb-bc-red-button" type="submit"
										title="Resend Request" id="submitBtn">
										<liferay-ui:message key="ec-member-request-save" />
									</button>

								</c:otherwise>
							</c:choose>

							<a class="btn omsb-btn omsb-bg-red-button" href="#"
								title="Cancel"><liferay-ui:message
									key="ec-member-request-cancel" /> </a>
						</div>
					</aui:form>
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
									<c:set var="ecMemberRole"
										value="(${memberDetails.latestCommentSection.roleName})"></c:set>
									<span>${memberDetails.latestCommentSection.roleName eq '' ? '' : ecMemberRole }</span>
								</h3>

								<span class="posted-date">${memberDetails.latestCommentSection.createDate}</span>
							</div>
							<div>
								<p>${memberDetails.latestCommentSection.comment}</p>
							</div>
						</div> <c:if test="${not empty memberDetails.commentsSections}">
							<div class="colspan-child">
								<liferay-ui:message key="ec-member-request-expand" />
							</div>
						</c:if>
						<ul>
							<c:forEach var="commentsSection"
								items="${memberDetails.commentsSections}">
								<li>
									<div class="omsb-comment-box">
										<div class="omsb-comment-box-header">
											<h3 class="comment-title">
												<span class="comment-author-name">
													${memberDetails.latestCommentSection.commenterUserName}</span>
												<c:set var="ecMemberRole"
													value="(${memberDetails.latestCommentSection.roleName})"></c:set>
												<span>${memberDetails.latestCommentSection.roleName eq '' ? '' : ecMemberRole }</span>
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
			</div>
		</div>
	</section>
</div>

<!-- Modal -->
<div class="modal fade omsb-modal" id="addmem_edu_detail" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">

			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="ec-member-request-add-education-details" />
				</h5>
				<button type="button" class="close reset-on-cancel"
					data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

			</div>
			<aui:form action="#" name="ec_member_education_details" method="post"
				enctype="multipart/form-data">
				<aui:input cssClass="form-control" type="hidden"
					name="educationDetailId" id="educationDetailId"></aui:input>
				<aui:input cssClass="form-control" type="hidden"
					name="qualificationDocumentId" id="qualificationDocumentId">
				</aui:input>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-4 col-sm-4 col-xs-12">
							<div class="form-group">
								<aui:select class="form-select form-control" id="title"
									name="title" label="ec-member-request-title">
									<option value=""><liferay-ui:message
											key="ec-member-request-select" /></option>
									<c:forEach var="qualification" items="${qualificationList }">
										<option value="${ qualification.getKey()}">${qualification.getName(themeDisplay.getLocale()) }</option>
									</c:forEach>
									<aui:validator name="required"></aui:validator>
								</aui:select>

							</div>
						</div>
						<div class="col-md-4 col-sm-4 col-xs-12">
							<div class="form-group">
								<aui:select class="form-select form-control"
									name="issuingAuthorityCountryName"
									label="ec-member-request-country-of-institution"
									onchange="getInstitutionDetails(this.value);">
									<option value=""><liferay-ui:message
											key="ec-member-request-select" /></option>
									<c:forEach var="country" items="${countryList}">
										<option value="${country.getCountryId()}">
											<liferay-ui:message
												key="${country.getName(themeDisplay.getLocale())}" />
										</option>
									</c:forEach>
									<aui:validator name="required"></aui:validator>
								</aui:select>

							</div>
						</div>
						<div class="col-md-4 col-sm-4 col-xs-12">
							<div class="form-group">
								<aui:select class="form-select form-control"
									name="issuingAuthorityName" id="issuingAuthorityName"
									label="ec-member-request-institution">
									<option value=""><liferay-ui:message
											key="ec-member-request-select" /></option>
									<aui:validator name="required"></aui:validator>
								</aui:select>
							</div>
						</div>

						<div class="col-md-6 col-sm-6 col-xs-12">
							<div class="form-group">
								<aui:input cssClass="form-control" type="text"
									placeholder="Enter GPA" name="gpa" id="gpa"
									label="ec-member-request-gpa">
									<aui:validator name="required"></aui:validator>
								</aui:input>

							</div>
						</div>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<div class="form-group">
								<aui:select class="form-select form-control"
									name="yearOfGraduation" id="yearOfGraduation"
									label="ec-member-request-year-of-graduation">
									<option value=""><liferay-ui:message
											key="ec-member-request-select" /></option>
									<aui:validator name="required"></aui:validator>
								</aui:select>
							</div>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="form-group">
								<div class="custom-file required-asterisk mb-3">
									<aui:input class="custom-file-input" type="file"
										id="qualificationDocument"
										onChange="validateFile(this,'qualificationdetailsId')"
										name="qualificationDocument"
										label="ec-member-request-qualification-document">

									</aui:input>
									<label class="custom-file-label"
										id="qualificationDocumentLabel"
										for="<portlet:namespace/>qualificationDocument"> </label> <small
										id="qualificationdetailsId" style="color: #dc3545;"></small>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<aui:button class="btn omsb-bc-red-button" type="button"
						value="ec-member-request-save"
						onClick="addMemberEducationDetails()"></aui:button>
					<a class="btn omsb-btn omsb-bg-red-button reset-on-cancel"
						data-dismiss="modal" value="label-submit-cancel"><liferay-ui:message
							key="ec-member-request-cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>
<script type="text/javascript">

$(document).ready(function() {
		  let dateDropdown = document.getElementById('<portlet:namespace/>yearOfGraduation'); 
		  let currentYear = new Date().getFullYear();    
		  let earliestYear = 1970;     
		  while (currentYear >= earliestYear) {      
		    let dateOption = document.createElement('option');          
		    dateOption.text = currentYear;      
		    dateOption.value = currentYear;        
		    dateDropdown.add(dateOption);      
		    currentYear -= 1;    
		  }
	 getEducationDetails();
});

$(".reset-on-cancel").click(function() {
	$("#<portlet:namespace/>ec_member_education_details").trigger("reset");
	$("#qualificationDocumentLabel").empty();
 
});
	 
function validateForm(ec_member_education_details){
	var educationDetailForm = Liferay.Form.get(ec_member_education_details);
	if(educationDetailForm){
			var validator = educationDetailForm.formValidator;
			 validator.validate();
			 var hasErrors = validator.hasErrors();
			 if(hasErrors){
					validator.focusInvalidField();
					return false;
			 }else if(hasErrors && $('#<portlet:namespace/>qualificationDocument').val()==''){
				 console.log("inside if condition");
					validator.focusInvalidField();
					$('#qualificationdetailsId').text('Qualification document is required');
					return false;
					}
			 else if($('#<portlet:namespace/>qualificationDocument').val() === '' && $('#<portlet:namespace/>educationDetailId').val() === ''){
					validator.focusInvalidField();
					validator.focusInvalidField();
					$('#qualificationdetailsId').text('Qualification document is required');
					return false;
				}
			 else {
					$('#qualificationdetailsId').remove();
					return true;
				}
	}
	return null;
}
	function bindFormDataJson(formObj){
		 var formdata = new FormData(formObj);
		 var portletnamespace = '<portlet:namespace/>';
		 var object = {};
		 formdata.forEach(function(value, key){
		 var keySpace = key.trim();
		 var splitnamespace = keySpace.split(portletnamespace)[1];
		 var data = splitnamespace;
		  if (data=="formDate" || data == ""){
			   delete object[data] ;   
		   }
		  else{
			 object[data] = value;
		   } 	  
		 });
		  return object;   
	}
		function addMemberEducationDetails(){
		if(validateForm('<portlet:namespace/>ec_member_education_details')){
		        var form= $('#<portlet:namespace/>ec_member_education_details')[0];
		        var jsonData = bindFormDataJson(form);
				var formdata = new FormData(form);
		        var url = '<%=addMemberEducationResourceUrl.toString()%>';	
					$.ajax({
		    			type: "post",
					    url: url,
					    data: formdata,
					    contentType: false,
					    cache : false,
					    processData: false,
		    		}).done(function(response) {
		    			$("#<portlet:namespace/>ec_member_education_details").trigger("reset");
		    			$("#qualificationDocumentLabel").empty();
		    			$('#addmem_edu_detail').modal('hide');
						 let table = $('#educationDetailTable').DataTable();
						 table.clear().rows.add(getEducationDetails()).draw();
		    			
		    		}).fail(function(error){
		    		})
			}else {	
			return false; 
				}
		}
		 let columns = [
			    {
			      data: 'qualificationAttained',
			      title: "<liferay-ui:message key='ec-member-request-title'/>" 
			    },
			    {
			      data: 'issuingAuthorityName',
			      title:"<liferay-ui:message key='ec-member-request-institution'/>" 
			    },
			    {
			      data: 'issuingAuthorityCountryName',
			      title: "<liferay-ui:message key='ec-member-request-country-of-institution'/>" 
				 },
			    {
			      data: 'gpa',
			      title: "<liferay-ui:message key='ec-member-request-gpa'/>" 
			    },
			    {
			      data: 'yearOfGraduation',
			      title: "<liferay-ui:message key='ec-member-request-year-of-graduation'/>" 
			    },
			    {
			    	 data: 'documentUrl',
				     title:"<liferay-ui:message key='ec-member-request-document'/>" , 
				      render: function(data, type, row) {
				    	      
				    	  render: function(data, type, row) {
						    	if(data==="" || data==null){
						    		return `<liferay-ui:message key='not-available'/>`;
						    	}else{
						    		return `
							    	
						    	      <div class="righbar">
										<a href="`+data+`" target="_blank">
										<button class="btn view_btn" title="View" type="button">
											<img
												src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
												alt="">
											<liferay-ui:message key="view" />
										</button>
									</a>
								</div>`;
						    		
						    	}
						    } 
			    },
			    {
			      render: function(data, type, row) {
			    	  return  `<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">
										<li><a href="javascript:void(0)" data-id="\${row.id}" class="dropdown-item edit-button">
										<i class="fa fa-check-square"></i>  <liferay-ui:message key='ec-member-request-edit'/> </a></li>
											<li><a href="javascript:void(0)" data-id="\${row.id}"  class="dropdown-item delete-button">
											<i class="fa fa-trash-o"></i>  <liferay-ui:message key='ec-member-request-delete'/></a></li>
									</ul>    
								</div>`;
			      }
			    }    
			  ];
			  // Initialize the DataTable
			  let table = $('#educationDetailTable').DataTable({
			    columns: columns,
			    searching: false,
			    paging:false,
			    info:false
			    // You can add other DataTable options here as needed
			  });
			    function getEducationDetails(){
			    	console.log("<%=getEducationDetailsData.toString()%>");
			    	$.ajax({
				          type: "GET",
				          url: "<%=getEducationDetailsData.toString()%>",
				          contentType: "application/json; charset=utf-8",
				          success: function(response) {
				            console.log(response);
				            // Clear the existing data in the table
				            table.clear().draw();
				            // Add the new data to the table
				            table.rows.add(response).draw();
				          },
				          error: function() {
				        	  console.log("If fetching fails, resolve with an empty string"); // If fetching fails, resolve with an empty string
				          }
				        })  	
			    }	  
			  // Add click event listeners to the Edit and Delete buttons
		 $('#educationDetailTable').on('click', '.edit-button', function() {	
			    var educationDetailId = $(this).data('id');
			    $("#<portlet:namespace/>qualificationDocument").removeAttr('required');
			    $("#<portlet:namespace/>qualificationDocument").attr('required', false);
			    $("#<portlet:namespace />issuingAuthorityName").empty();
			    $.ajax({
			          type: "GET",
			          url: "<%=editEducationDetailsData.toString()%>",
			          data:{id: educationDetailId},
			          contentType: "application/json; charset=utf-8",
			          success: function(response) {
			        	if (response) {
			                $("#<portlet:namespace/>title").val(response.qualificationAttained);
			                
			                $("#<portlet:namespace/>gpa").val(response.gpa);
			                $("#<portlet:namespace/>yearOfGraduation").val(response.yearOfGraduation);
			                $("#<portlet:namespace/>educationDetailId").val(response.id);
			                $("#<portlet:namespace/>qualificationDocumentId").val(response.qualificationDocumentId);
			                
			                $("#<portlet:namespace/>qualificationDocument").text(response.qualificationDocument);
			                $("#qualificationDocumentLabel").text(response.qualificationDocument);
			            	$("#<portlet:namespace/>issuingAuthorityCountryName").val(response.issuingAuthorityCountryName);
			                $("#<portlet:namespace/>issuingAuthorityName").append(new Option(response.universityName,response.issuingAuthorityName));
			            }
			            
			          },
			          error: function() {
			        	  console.log("If fetching fails, resolve with an empty string"); // If fetching fails, resolve with an empty string
			          }
			  });
			    $('#addmem_edu_detail').modal('show');
		 });
		 $('#educationDetailTable').on('click', '.delete-button', function() {
			    let id = $(this).data('id');
			    let table = $('#educationDetailTable').DataTable();
			    $.ajax({
		  		    type: "POST",
		  		    url: "<%=deleteEducationDetailURL%>",
		  		    data:{<portlet:namespace />id:id},
		  		  }).done(function(response) {
		  			location.reload();
		  		  });
			    
			 	});
			
			// for validation of file //
			 function validateFile(fileInput,errorId) {
				    const maxSize = 1024 * 1024; // 1 MB in bytes
				    const validTypes = ['application/pdf',  'image/png', 'image/jpeg', 'image/jpg'];
				    const errorElement = document.getElementById(errorId);
				    if (fileInput.files.length > 0) {
				    	checkFile(fileInput,validTypes,errorElement,maxSize);
				    }
				    return true;
				}
			 // For checking File size and format  
			    function checkFile(fileInput,validTypes,errorElement,maxSize){
				     const file = fileInput.files[0];
				        const fileSize = file.size;
				        const fileType = file.type;
				        if (!validTypes.includes(fileType)) {
				        	errorElement.textContent = 'File type must be .pdf, .png, .jpeg, or .jpg.';
				            fileInput.value = ''; // Reset the file input field
				            return false;
				        }else {
				        	errorElement.textContent = '';
				        }
				        if (fileSize > maxSize) {
				        	errorElement.textContent = 'File size must be less than 1 MB';
				            fileInput.value = ''; // Reset the file input field
				            return false;
				        }
				        else {
				        	errorElement.textContent = '';
				        }
			 	  }
			 
			    function saveAndSubmit(workflowTaskId,transitionName,workflowInstanceId ){
			    	validatefiles();
			    	let details ="{workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+transitionName+"}"; 
			    	$("#<portlet:namespace />workflowTaskDetails").val(details);
			    	return true;
			    }
			 
			    function validatefiles(){
					 const passportFileInput = $("#<portlet:namespace />passportId");
					 const passportErrorElement = document.getElementById("passportdetailsId");
					 const nationalFileInput = $("#<portlet:namespace />nationalId");
					 const nationalErrorElement = document.getElementById("nationaldetailsId");
					 validatePassport(passportFileInput,passportErrorElement);
					 validateNationalFile(nationalFileInput,nationalErrorElement);
					  
				 }
			    
			    function validatePassport(passportFileInput,passportErrorElement){
			    	 if(passportFileInput[0].files.length === 0){
			    		 passportErrorElement.textContent = 'This field is required.';
					        return false;
					    }else {
					    	passportErrorElement.textContent = '';
					    }
				    }
			    
			    function validateNationalFile(nationalFileInput,nationalErrorElement){
			    	 if(nationalFileInput[0].files.length === 0){
			    		 nationalErrorElement.textContent = 'This field is required.';
					        return false;
					    }else {
					    	nationalErrorElement.textContent = '';
					    }
			    	}
			    function getInstitutionDetails(issuingAuthorityCountryName){
			    	 $("#<portlet:namespace />issuingAuthorityName").empty(); 
					$.ajax({
						url: '<%=getUniversityDetailsURL%>',
						type : 'GET',
						data : {
							"<portlet:namespace />issuingAuthorityCountryName" : issuingAuthorityCountryName,
						},
						success : function(response) {
							console.log(response);
							var data = response;
							var subSpecialityArray = response.university;
							console.log(subSpecialityArray);
							var obj = JSON.parse(response);
							console.log("in if ==> obj :",obj);
							$("#<portlet:namespace/>issuingAuthorityName").append(new Option('Select',""));
							if(obj != null){
								for (var i = 0; i < obj.length; i++) {
									var item = obj[i];
									var id = item.id;
									console.log(id + "--------"+ item);
									if (themeDisplay.getLanguageId() == 'en_US') {
										 $("#<portlet:namespace/>issuingAuthorityName").append(new Option(item.englishName,id));
									} else {
										 $("#<portlet:namespace/>issuingAuthorityName").append(new Option(item.arabicName, id));
									}
								}
							}
							
						}
					});
				}
	
	</script>
