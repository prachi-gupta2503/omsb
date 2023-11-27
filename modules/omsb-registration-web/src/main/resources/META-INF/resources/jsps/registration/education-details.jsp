<%@ include file="../../init.jsp"%>
	<div class="main-content id-box" style="margin-top: 0px;">
		<div class="omsb-main-wrapper" id="omsb-main-wrapper">
			<div class=" row bg-white">
				<div class="col-12 login-right">
					<div class="omsb-card ">
						<div class="omsb-pre-login header">
								<div>
									<img src="<%=themeDisplay.getPathThemeImages()%>/svg/logo.svg">
								</div>
								<div>
									<p class="logo-text-arabic"><liferay-ui:message key="oman-medical-specialty-board-arabic"/></p>
									<p class="logo-text-english"><liferay-ui:message key="oman-medical-specialty-board" /></p>
								</div>
							</div>
							<portlet:resourceURL id="<%=MVCCommands.GET_UNIVERSITY_DETAILS%>" var="getUniversityDetailsURL" />
							<portlet:actionURL name="<%=MVCCommands.EDUCATION_DETAILS_MVCACTION%>" var="educationalDetailMVCActionURL"/>
							<portlet:renderURL var="personalDetailRenderURL">
								<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_REGISTRATION_PERSONAL_DETAILS%>" />
								<portlet:param name="personId" value="${personId}" />
								<portlet:param name="lrUserId" value="${lrUserId}" />
							</portlet:renderURL>
							<form  class="" name="<portlet:namespace/>edFM"  id="edFM" action="${educationalDetailMVCActionURL}" method="post" enctype="multipart/form-data">
								<div class="reg_step2"  id="reg_step2">
									
									<div class="alert alert-light alert-success-text d-none" id="personalDetailSuccess" role="alert">
										<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
										<div class="alert-box">
											<span><img
												src="<%=themeDisplay.getPathThemeImages()%>/svg/Right.svg"
												alt="Right"></span>
											<div class="alert-text">
												<h4 class="alert-heading">
													<span> <liferay-ui:message
															key="personal-details-are-saved-successfully" /></span>
												</h4>
											</div>
										</div>
									</div>
									
									<div class="omsb-card m-0 p-0">
										<div class="omsb-page-top-info mb-4">
											<div class="pagetitle"><liferay-ui:message key="registration-education-details" /></div>
											<div class="information"><label class="reg-form-title"><liferay-ui:message key="step-two-of-four" /></label></div>
										</div>
									</div>
									<div class="omsb-page-top-info mb-4">
										<h3 class="reg-form-title"><liferay-ui:message key="education-details" /> </h3>
										<%-- <div class="information"><button type="button" class="btn omsb-bg-red-button" id="add_edu_detail"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg" alt=""><liferay-ui:message key="add-more"/></button></div> --%>
									</div>
									<div id="edu_detail_area">
										<div class=" edu_detail element " id="edu_detail" >
											<div class="row ">
												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="qualification-title" />  </label>
														<select  name="<portlet:namespace/>qualification" id="qualification" class="form-control"  onchange="showOtherField(this.id,'errorContainer-qualification','<liferay-ui:message key="please-select-qualification" />')">
															<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="qualification" items="${qualificationList}">
																<option value="${qualification.getKey()}">
																	<liferay-ui:message key="${qualification.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
														</select>
														<p id="errorContainer-qualification" class="error-container m-0"></p>
													</div>
												</div>
												
												<div class="col-lg-6 col-md-6 d-none" id="qualificationOtherDiv">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="qualification-other" /></label>
														<input  type="text" name="<portlet:namespace/>qualificationOther" id="qualificationOther" class="form-control" value="${qualificationOther}" >
													</div>
													<p id="errorContainer-qualification" class="error-container"></p>
												</div>
												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="country-of-institution" /></label>
														<select  name="<portlet:namespace/>country" id="country" class="form-control" onchange="getInstitutionDetails(this.value);">
															<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="country" items="${customCountries}">
																<option value="${country.getCountryId()}">
																	<liferay-ui:message key="${country.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
														</select>
														<p id="errorContainer-country" class="error-container m-0"></p>
													</div>
												</div>
												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="institution" /></label>
														<select  name="<portlet:namespace/>institution" id="institution" class="form-control">
															<option value=""><liferay-ui:message key="select" /></option>
															 <%-- <c:forEach var="institution" items="${institutionList}">
																<option value="${institution.getKey() }">
																	<liferay-ui:message key="${institution.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach> --%>
														</select>
														<p id="errorContainer-institution" class="error-container m-0"></p>
													</div>
												</div>
												<div class="col-lg-6 col-md-6 d-none" id="institutionOtherDiv">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="institution-other" /></label>
														<input  type="text" name="<portlet:namespace/>institutionOther" id="institutionOther" class="form-control" value="${institutionOther}" >
													</div>
													<p id="errorContainer-institution" class="error-container"></p>
												</div>
												<%-- <div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label"><liferay-ui:message key="gpa" /></label>
														<input type="text" name="<portlet:namespace/>gpa" id="gpa" value=" "
														class="form-control">
														<p id="errorContainer-gpa" class="error-container m-0"></p>
													</div>
												</div> --%>
												<input type="hidden" name="id" id="id">
												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="year-of-graduation" /></label>
														<select  name="<portlet:namespace/>year" id="year" class="form-control">
															<option value=""><liferay-ui:message key="select"/></option>
															<% int currentYear = Calendar.getInstance().get(Calendar.YEAR); %>
															<c:forEach  begin="1970"  end="${year}" step="1" var="age">
															    <c:set var="decr" value="${(year-age)+1970}"/>
															    <option value="${decr}"}>${decr}</option>
															</c:forEach>
														</select>
														<p id="errorContainer-year-of-graducation" class="error-container m-0"></p>
													</div>
												</div>

												<div class="col-lg-12 col-md-12">
													
													<div class="d-flex align-items-center">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="qualification-document" /></label>
														<div class="custom-file">
																<input type="file" name="qualificationdoc" id="qualificationdoc" value=""
																class="form-control custom-file-input">
															<label class="custom-file-label" for="qualificationdoc" id="qualificationdoclbl"></label>
														</div>
														 <p id="errorContainer-qualification-document" class="error-container m-0"></p> 
														 
													</div>
													<div style="width:140px" class="text-right">
														<a class="btn view_btn text-danger d-none"  id="view-file" title="<liferay-ui:message key="view" />" target="_blank" href="#">
																<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""> <liferay-ui:message key="view-file" />
														</a>
													</div>
													</div>
													
													
												</div>
												<%-- <div class="col-lg-12 col-md-12 d-none" id="view-div" >
												<div class="row">
												<div class="col-lg-8 col-md-8"></div>
												<div class="col-lg-4 col-md-4">
												  <div class="form-group">
														<label class="control-label"></label>
														<a class="btn view_btn text-danger"  id="view-file" title="<liferay-ui:message key="view" />" target="_blank" href="#">
															<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""> <liferay-ui:message key="view-file" />
														</a>
													</div>
												</div>
												</div>
												</div> --%>
												<div class="col-md-12">
													<div class="bottom-backbtn-wrap mb-4">
														<%-- <button class="btn omsb-bc-red-button" onClick="clearForm()" type="button" title="<liferay-ui:message key='clear'/>"><liferay-ui:message key="clear"/></button> --%>
														<%-- <button type="button" class="btn omsb-bg-red-button" onclick="saveEducationDetails()" id="add_edu_detail"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg" alt=""><liferay-ui:message key="add-more"/></button> --%>
														<button type="button" class="btn omsb-bg-red-button" onclick="saveEducationDetails()" id="add_edu_detail"><liferay-ui:message key="add-update"/></button>
													</div>
												</div>
											</div>
										<!-- </div> -->
										<h5 id="errorContainer-educational-detail" class="error-container m-0"></h5> 
										</div>
										<div id="educationDetailsList">
											<c:choose>
												<c:when test="${!empty educationalDetailItemList}">
													<table class="display omsb-datatables" id="work-detail-list"
														width="100%">
														<thead>
															<tr>
																<th><liferay-ui:message key="qualification-type" /></th>
																<th><liferay-ui:message key="country-of-institution" /></th>
																<th><liferay-ui:message key="institution" /></th>
																
																<%-- <th><liferay-ui:message key="gpa" /></th> --%>
																<th><liferay-ui:message key="year-of-graduation" /></th>
																<th><liferay-ui:message key="action" /></th>
															</tr>
														</thead>
														<tbody>
														<c:forEach var="educationalDetailItem" items="${educationalDetailItemList}">
															<tr>
																<td>${educationalDetailItem.qualificationAttained}</td>
																<td>${educationalDetailItem.issuingAuthorityCountry}</td>
																<td>${educationalDetailItem.issuingAuthorityName}</td>
																<%-- <td>${educationalDetailItem.gpa}</td> --%>
																<td>${educationalDetailItem.yearOfGraduation}</td>
																<td>
																	<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-education-confirm-modal" data-rowcount="addPopUpRow" onclick="setDeleteID('${educationalDetailItem.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
																	<button class="btn mx-2" value="view" type="button" onclick="setEditID('${educationalDetailItem.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
												</c:when>
												<c:otherwise>
													<liferay-ui:message key="no-records-found" />
												</c:otherwise>
											</c:choose>
										</div>
									</div>
									<div class="bottom-backbtn-wrap">
										<button class="btn omsb-bc-red-button" onClick="validateAndSaveFormData('save')" type="button" title="<liferay-ui:message key='save-at-this-stage'/>"><liferay-ui:message key="save-at-this-stage"/></button>
										<button class="go-next btn omsb-bc-red-button" onClick="validateAndSaveFormData('next')" type="button" title="<liferay-ui:message key='next'/>" id="edu_detail_nextbtn" data-next="reg_step3"><liferay-ui:message key="next"/></button>
										<%-- <button id="edu-back-button" class="go-pervious btn  omsb-btn omsb-bg-red-button"  data-toggle="modal" data-target="#conformationPopUp" type="button" title="<liferay-ui:message key='back'/>" data-pervious="reg_step1"><i class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back"/></button> --%>
										<%-- <button id="edu-back-button" data-toggle="modal" data-target="#back-educcation-confirm-modal" class="go-pervious btn  omsb-btn omsb-bg-red-button" type="button" title="<liferay-ui:message key='back'/>" data-pervious="reg_step1"><i class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back"/></button> --%>
									</div>
								</div>
								<input type="hidden" name="<portlet:namespace/>isNext" id="isNext" value="false">
								<input type="hidden" value="${personId}" name="<portlet:namespace/>personId" id="personId"/>
								<input type="hidden" value="${lrUserId}" name="<portlet:namespace/>lrUserId" id="lrUserId"/>
								<input type="hidden" value="" name="deleteID" id="deleteID"/>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		
		
		<!--delete popup for Education  Detail -->
		<div class="modal fade omsb-modal" id="delete-education-confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="delete-confirmation" /></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row">
							<div>
								<liferay-ui:message key="do-you-want-to-delete-this-record"/>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteEduSection()" title="<liferay-ui:message key='ok' />" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		
		
		
		<!--delete popup  -->
		<!-- back popup -->
				<div class="modal fade omsb-modal" id="back-educcation-confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="back-confirmation" /></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row">
							<div>
								<liferay-ui:message key="do-you-want-to-go-back"/>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="backPage()" title="<liferay-ui:message key='ok' />" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!-- end back popup -->
<div class="loader-container d-none">
	<div class="loaded">
		<img src="<%=themeDisplay.getPathThemeImages()%>/svg/loader.svg"
			alt="loader">
	</div>
</div>
		
		<%@ include file="confirmationPopUp.jsp"%>
		<portlet:resourceURL id="<%=MVCCommands.SAVE_REGISTRATION_EDUCATION_DETAILS_SR%>" var="saveEducationDetailsURL" />
		<portlet:resourceURL id="<%=MVCCommands.GET_REGISTRATION_EDUCATION_DETAILS_SR%>" var="getEducationDetailsURL" />
		<portlet:resourceURL id="<%=MVCCommands.DELETE_REGISTRATION_EDUCATION_DETAILS_SR%>" var="deleteEducationDetailsURL" />
		<liferay-ui:success key="success-education-detail" message="education-detail-successfully-added" />
		<liferay-ui:success key="success-personal-detail" message="personal-detail-successfully-added" />
<script type="text/javascript">
$(document).ready(function() {
	
	 $("#qualification").select2();
	 $("#institution").select2();
	 $("#country").select2();
	 $("#year").select2();
	
});

	
$("#qualification").change(function(){
	console.log("qualification clicked :::::::");
	var qualificationValue=$(this).val();
	console.log("qualificationValue:::",qualificationValue);
	if (!qualificationValue) {
		//errorMessages.push("<liferay-ui:message key='please-select-qualification' />");
		document.getElementById("errorContainer-qualification").textContent = "<liferay-ui:message key='please-select-qualification' />";
		return false;
	} else {
		document.getElementById("errorContainer-qualification").textContent = "";
	}
});
	
$("#country").change(function(){
	console.log("country clicked :::::::");
	var countryValue=$(this).val();
	console.log("countryValue:::",countryValue);
	if (!countryValue) {
		//errorMessages.push("<liferay-ui:message key='please-select-country' />");
		document.getElementById("errorContainer-country").textContent = "<liferay-ui:message key='please-select-country' />";
		return false;
	} else {
		document.getElementById("errorContainer-country").textContent = "";
	}
});
	
$("#institution").change(function(){
	console.log("institution clicked :::::::");
	var institutionValue=$(this).val();
	console.log("institutionValue:::",institutionValue);
	if (!institutionValue) {
		//errorMessages.push("<liferay-ui:message key='please-select-institute' />");
		document.getElementById("errorContainer-institution").textContent = "<liferay-ui:message key='please-select-institute' />";
		return false;
	} else {
		document.getElementById("errorContainer-institution").textContent = "";
	}
});
	
$("#year").change(function(){
	console.log("year clicked :::::::");
	var yearValue=$(this).val();
	console.log("year:::",yearValue);
	if (!yearValue) {
		//errorMessages.push("<liferay-ui:message key='please-select-year-of-graduation' />");
		document.getElementById("errorContainer-year-of-graducation").textContent = "<liferay-ui:message key='please-select-year-of-graduation' />";
		return false;
	} else {
		document.getElementById("errorContainer-year-of-graducation").textContent = "";
	}
});
	
 $(document).on("change","#qualificationdoc",function(){
	console.log("qualificationdoc clicked :::::::");
	var qualificationDoc = document.getElementById("qualificationdoc").files[0];
	console.log("qualificationDoc:::",qualificationDoc);
	if (!qualificationDoc) {
		if(!isEdit){
			//errorMessages.push("<liferay-ui:message key='please-select-year-of-graduation' />");
			document.getElementById("errorContainer-qualification-document").textContent = "<liferay-ui:message key='please-upload-qualification-document' />";
			return false;
		} else {
			isEdit=false;
			document.getElementById("errorContainer-qualification-document").textContent = "";
		}
	} else {
		isEdit=false;
		document.getElementById("errorContainer-qualification-document").textContent = "";
		 var filename = qualificationDoc.name;
		 
		 console.log("filename :::",filename);
	     var extension = filename.substr(filename.lastIndexOf("."));
		  var allowedExtensionsRegex = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
		  var isAllowed = allowedExtensionsRegex.test(extension);
		  if(isAllowed){
		    		const size = (qualificationDoc.size / 1024 / 1024).toFixed(2);
					console.log(size);
					if (size > 1) {
						//errorMessages.push("<liferay-ui:message key='filesize-must-be-less-than-1-mb' />");
						document.getElementById("errorContainer-qualification-document").textContent = "<liferay-ui:message key='filesize-must-be-less-than-1-mb' />";
						return false;
		            } else {
		            	document.getElementById("errorContainer-qualification-document").textContent = "";
		            }
		     }else{
		    	 document.getElementById("errorContainer-qualification-document").textContent ="<liferay-ui:message key='please-select-pdf-file' />";
		    	 //errorMessages.push("<liferay-ui:message key='lease-select-pdf-file' />");
		    	 return false;
		     }
	}
}); 
 
/*  $(document).on('click','#confirmExamButtonNext',function(){
	 
	 var taskComplete=nextPage();
	 if(taskComplete){
		 
		 setTimeout(openWorkDetails('true',"no"), 6000);
	 }else{
		 $('#examConformationPopUpBox').modal('hide');
	 }
	  openWorkDetails('true',"no"); 
 }); */

/* function nextPage(){
	 $('#examConformationPopUpBox').modal('hide');
	 return true;
	 
 }  */
function showOtherField(id,errorId,errorMessage){
	 console.log(id);
	 var substring=substring=id;
	
	 let selectedValue= $("#"+id).find('option:selected').val();
	 
	 console.log(selectedValue);
	 
	 if(selectedValue.trim() === 'other'){
		 console.log('#'+id+"otherDiv");
		 $('#'+id+"OtherDiv").removeClass('d-none');
	 }
	 else{
		 $('#'+id+"OtherDiv").addClass('d-none');
		}
	/*  validateField(id,errorId,errorMessage); */
	
	 
}
	
$('#work-detail-list').DataTable({	
    "bLengthChange": false,	
    "bFilter": false,
    "ordering": false
});

	
	var isEdit = false;

	function isValidVerificationField(){
		var errorMessages = [];
		var qualification = document.getElementById("qualification").value;
		if (!qualification) {
			errorMessages.push("<liferay-ui:message key='please-select-qualification' />");
			document.getElementById("errorContainer-qualification").textContent = "<liferay-ui:message key='please-select-qualification' />";
		} else {
			document.getElementById("errorContainer-qualification").textContent = "";
		}
		
		var institution = document.getElementById("institution").value;
		if (!institution) {
			errorMessages.push("<liferay-ui:message key='please-select-institute' />");
			document.getElementById("errorContainer-institution").textContent = "<liferay-ui:message key='please-select-institute' />";
		} else {
			document.getElementById("errorContainer-institution").textContent = "";
		}
		
		var country = document.getElementById("country").value;
		if (!country) {
			errorMessages.push("<liferay-ui:message key='please-select-country' />");
			document.getElementById("errorContainer-country").textContent = "<liferay-ui:message key='please-select-country' />";
		} else {
			document.getElementById("errorContainer-country").textContent = "";
		}
		
		/* var gpa = document.getElementById("gpa").value.trim();
		if (!gpa) {
			errorMessages.push("<liferay-ui:message key='please-enter-gpa' />");
			document.getElementById("errorContainer-gpa").textContent = "<liferay-ui:message key='please-enter-gpa' />";
		} else {
			document.getElementById("errorContainer-gpa").textContent = "";
		} */
		
		var year = document.getElementById("year").value;
		if (!year) {
			errorMessages.push("<liferay-ui:message key='please-select-year-of-graduation' />");
			document.getElementById("errorContainer-year-of-graducation").textContent = "<liferay-ui:message key='please-select-year-of-graduation' />";
		} else {
			document.getElementById("errorContainer-year-of-graducation").textContent = "";
		}
		
		var qualificationDoc = document.getElementById("qualificationdoc").files[0];
		if (!qualificationDoc) {
			if(!isEdit){
				errorMessages.push("<liferay-ui:message key='please-select-year-of-graduation' />");
				document.getElementById("errorContainer-qualification-document").textContent = "<liferay-ui:message key='please-upload-qualification-document' />";
			} else {
				isEdit=false;
				document.getElementById("errorContainer-qualification-document").textContent = "";
			}
		} else {
			isEdit=false;
			document.getElementById("errorContainer-qualification-document").textContent = "";
			 var filename = qualificationDoc.name;
		     var extension = filename.substr(filename.lastIndexOf("."));
			//  var allowedExtensionsRegex=new RegExp("(.*?)\.(pdf)$");
			  var allowedExtensionsRegex = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
			  var isAllowed = allowedExtensionsRegex.test(extension);
			  if(isAllowed){
			    		const size = (qualificationDoc.size / 1024 / 1024).toFixed(2);
						console.log(size);
						if (size > 1) {
							errorMessages.push("<liferay-ui:message key='filesize-must-be-less-than-1-mb' />");
							document.getElementById("errorContainer-qualification-document").textContent = "<liferay-ui:message key='filesize-must-be-less-than-1-mb' />";
			            } else {
			            	document.getElementById("errorContainer-qualification-document").textContent = "";
			            }
			     }else{
			    	 document.getElementById("errorContainer-qualification-document").textContent ="<liferay-ui:message key='please-select-pdf-file' />";
			    	 errorMessages.push("<liferay-ui:message key='lease-select-pdf-file' />");
			     }
		}
				
		let isValid = false;
		if (errorMessages.length == 0) {
			isValid = true;
		}
		
		
		console.log("errorMessages.length ::,",errorMessages.length);
		console.log("isValid ::,",isValid);
		return isValid;
	}

function saveEducationDetails(){
	addLoader();	
	setTimeout(function() {
		if(isValidVerificationField()){
			var qualification = $("#qualification").val().trim();
			var institution = $("#institution").val().trim();
			var country = $("#country").val().trim();
			//var gpa = $("#gpa").val().trim();
			var year = $("#year").val().trim();
			var id = $("#id").val().trim();
			var personId = $("#personId").val().trim();
			var lrUserId = $("#lrUserId").val().trim();
			var qualificationOther = $("#qualificationOther").val().trim();
			
			console.log("personId :::::",personId);
			
			var uploadFile = document.getElementById("qualificationdoc").files[0];
			var formData = new FormData();
			formData.append('<portlet:namespace />qualificationDoc', uploadFile);
			formData.append('<portlet:namespace />qualification', qualification);
			formData.append('<portlet:namespace />institution', institution);
			formData.append('<portlet:namespace />country', country);
			//formData.append('<portlet:namespace />gpa', gpa);
			formData.append('<portlet:namespace />year', year);
			formData.append('<portlet:namespace />id', id);
			formData.append('<portlet:namespace />personId', personId);
			formData.append('<portlet:namespace />lrUserId', lrUserId);
			formData.append('<portlet:namespace />qualificationOther', qualificationOther);
			
			$.ajax({
				url: '${saveEducationDetailsURL}',
				type:'POST',
		      	processData: false,
		      	contentType: false,
		      	async: false,
		      	cache: false,
		      	data : formData,
				success : function(data) {
					isEdit=false;
					document.getElementById("qualification").value = "";
					document.getElementById('select2-qualification-container').innerHTML="";
					document.getElementById("institution").value = "";
					document.getElementById('select2-institution-container').innerHTML="";
					document.getElementById("country").value = "";
					document.getElementById('select2-country-container').innerHTML="";
					//document.getElementById("gpa").value = "";
					document.getElementById("qualificationOther").value = "";
					document.getElementById('select2-year-container').innerHTML="";
					document.getElementById("year").value = "";
					document.getElementById('select2-year-container').innerHTML="";
					document.getElementById("id").value = '';
					document.getElementById("qualificationdoclbl").innerHTML = '';
					document.getElementById("view-file").setAttribute("href",'');
					$("#view-file").addClass("d-none");
					$("#educationDetailsList").html(data);
					$('#work-detail-list').DataTable({	
					    "bLengthChange": false,	
					    "bFilter": false,
					    "ordering": false
					});
				},
			})
			setTimeout(function() {
				removeLoader();
			}, 200);
		}
			setTimeout(function() {
				removeLoader();
			}, 200);
		//close  set time out
		}, 300);
}
	
	function deleteEduSection(){

		var deleteId = document.getElementById("deleteID").value;
		var personId = document.getElementById("personId").value;
		if(deleteId){
			$.ajax({
				url: '${deleteEducationDetailsURL}',
				async : false,
				data : {
					<portlet:namespace />id : deleteId,
					<portlet:namespace />personId : personId 
				},
				type : 'POST',
				success : function(data) {
					isEdit=false;
					$('#delete-education-confirm-modal').modal('hide');
					document.getElementById("qualification").value = "";
					document.getElementById('select2-qualification-container').innerHTML=""
					document.getElementById("institution").value = "";
					document.getElementById('select2-institution-container').innerHTML=""
					document.getElementById("country").value = "";
					document.getElementById("qualificationOther").value = "";
					document.getElementById('select2-country-container').innerHTML=""
					//document.getElementById("gpa").value = "";
					document.getElementById("year").value = "";
					document.getElementById('select2-year-container').innerHTML=""
					document.getElementById("id").value = '';
					document.getElementById("qualificationdoclbl").innerHTML = '';
					$("#educationDetailsList").html(data);
					$('#work-detail-list').DataTable({	
					    "bLengthChange": false,	
					    "bFilter": false,
					    "ordering": false
					});
				},
			})
		}
	}
		
	function setEditID(id){
		if(id){
			document.getElementById("qualification").value = '';
			document.getElementById('select2-qualification-container').innerHTML=""
			document.getElementById("institution").value = '';
			document.getElementById('select2-institution-container').innerHTML=""
			document.getElementById("country").value = '';
			document.getElementById("qualificationOther").value = '';
			document.getElementById('select2-country-container').innerHTML=""
			//document.getElementById("gpa").value = '';
			document.getElementById("year").value = '';
			document.getElementById('select2-year-container').innerHTML=""
			document.getElementById("id").value = '';
			document.getElementById("qualificationdoclbl").innerHTML = '';
			$("#view-file").removeClass("d-none");
			$.ajax({
				url: '${getEducationDetailsURL}',
				async : false,
				data : {
					<portlet:namespace />id : id,
				},
				type : 'POST',
				success : function(data) {
					const response = JSON.parse(data);
					console.log("response ::::",response);
					if(response.isValid){
						const obj = JSON.parse(response.instituteArray);
						console.log("instituteArray :::::",obj);
						var sectionData = "<option value=''><liferay-ui:message key='select'/></option>";
						for (var i = 0; i < obj.length; i++) {
							var item = obj[i];
							var id = item.id;
							if (themeDisplay.getLanguageId() == 'en_US') {
								sectionData += "<option value='" + id + "'>"
										+ item.englishName + "</option>";
							} else {
								sectionData += "<option value='" + id + "'>"
										+ item.arabicName + "</option>";
							}
						}
						$("#institution").html(sectionData);
						const educationDetails = JSON.parse(response.educationDetail);
						document.getElementById("qualification").value = educationDetails.qualificationAttained;
						var selectionQualification = $('option:selected', $('#qualification'));
						document.getElementById('select2-qualification-container').innerHTML=selectionQualification.text().trim();
						document.getElementById("institution").value = educationDetails.issuingAuthorityName;
						var selectionInstitution = $('option:selected', $('#institution'));
						document.getElementById('select2-institution-container').innerHTML=selectionInstitution.text().trim();
						document.getElementById("country").value = educationDetails.issuingAuthorityCountryId;
						var selectionCountry = $('option:selected', $('#country'));
						document.getElementById('select2-country-container').innerHTML=selectionCountry.text().trim();
						//document.getElementById("gpa").value = educationDetails.gpa;
						document.getElementById("year").value = educationDetails.yearOfGraduation;
						var selectionYear = $('option:selected', $('#year'));
						document.getElementById('select2-year-container').innerHTML=selectionYear.text().trim();
						document.getElementById("id").value = educationDetails.id;
						document.getElementById("qualificationOther").value = educationDetails.qualificationOther;
						document.getElementById("view-file").setAttribute("href",educationDetails.documentInfo.documentURL);
						if(educationDetails!=null){
							if(educationDetails.documentInfo!=null){
								if(educationDetails.documentInfo.dFFileName!=null){
									document.getElementById("qualificationdoclbl").innerHTML = educationDetails.documentInfo.dFFileName;
									isEdit=true;
								}
							}
						}
					}
				}
			})
		}
	}
	
/* 	function clearForm(){
		document.getElementById("qualification").value = '';
		document.getElementById('select2-qualification-container').innerHTML=""
		document.getElementById("institution").value = '';
		document.getElementById('select2-institution-container').innerHTML=""
		document.getElementById("country").value = '';
		document.getElementById("qualificationOther").value = '';
		document.getElementById('select2-country-container').innerHTML=""
		//document.getElementById("gpa").value = '';
		document.getElementById("year").value = '';
		document.getElementById('select2-year-container').innerHTML=""
		document.getElementById('qualificationdoclbl').innerHTML=""
		document.getElementById("id").value = '';
		document.getElementById("view-file").setAttribute("href",'');
		
		$("#view-file").addClass("d-none");
		isEdit=false;
	} */
	
	function setDeleteID(id){
		document.getElementById("deleteID").value = id;
	}
	
	function validateAndSaveFormData(button) {
		if(!${themeDisplay.isSignedIn()}){
			console.log("inside if: ");
			var table = $('#work-detail-list').DataTable();

		/* if ( !table.data().any() ) {
			event.preventDefault();
			console.log("Please insert atleast one education detail ::::");
			document.getElementById("errorContainer-educational-detail").textContent = "<liferay-ui:message key='please-insert-education-detail' />";
		}else{ */
			document.getElementById("errorContainer-educational-detail").textContent = "";
			if(button=='next'){
				console.log("inside next::::");
				document.getElementById("isNext").value = "true";
				$("[data-click=educationDetail]").removeClass('active');
				 $("[data-click=workDetail]").addClass('active');
				 //$("#openExamConformationPopUpBox").click();
				 openWorkDetails('true','no')
			}else{
				console.log("inside save at this stage ::::");
				document.getElementById("isNext").value = "false";
				openWorkDetails(document.getElementById("isNext").value,"no");
				//openEducationDetails('educationTab');
			}
			/* document.getElementById("edFM").submit(); */
			console.log(document.getElementById("isNext").value);
		/* } */
		}
		else{
			console.log("Inside another else::::");
			if(button=='next'){
				document.getElementById("isNext").value = "true";
				$("[data-click=educationDetail]").removeClass('active');
				 $("[data-click=workDetail]").addClass('active');
				 console.log(document.getElementById("isNext").value);
				 openWorkDetails(document.getElementById("isNext").value,"no");
				 //$("#openExamConformationPopUpBox").click();
			}else{
				openEducationDetails('educationTab');
			}
			/* document.getElementById("edFM").submit(); */
			
			
		}		
	}
	
	function getInstitutionDetails(country){
		$.ajax({
			url: '<%=getUniversityDetailsURL%>',
			type : 'GET',
			data : {
				"<portlet:namespace />country" : country,
			},
			success : function(response) {
				console.log(response);
				var data = response;
				var subSpecialityArray = response.university;
				console.log(response.university);
				var sectionData = "<option value=''><liferay-ui:message key='select'/></option>";
				// Iterating through the array using a for loop
				var obj = JSON.parse(response);
				console.log("in if ==> obj :",obj);
				if(obj != null){
					for (var i = 0; i < obj.length; i++) {
						var item = obj[i];
						var id = item.id;

						if (themeDisplay.getLanguageId() == 'en_US') {
							sectionData += "<option value='" + id + "'>"
									+ item.englishName + "</option>";
						} else {
							sectionData += "<option value='" + id + "'>"
									+ item.arabicName + "</option>";
						}
					}
				}
				$("#institution").html(sectionData);
				/* } else {
					$("#institution").empty().html(sectionData); 
				} */
			},
		});
	}
	 
	 function previousPage(){
		 window.location.href='${personalDetailRenderURL}';
	 }
	 
	 
	 function addLoader(){
			console.log("add loader called");
		    const loaderContainer = document.querySelector('.loader-container');
		    console.log("1");
		    loaderContainer.classList.remove('d-none');
		    console.log("2");
		    const loader = document.querySelector('.loaded');
		    console.log("3");
		    loader.classList.add('loader');
		    console.log("4");
		}

		function removeLoader(){
			console.log("remove called");
			const loaderContainer = document.querySelector('.loader-container');
			loaderContainer.classList.add('d-none');
			const loader = document.querySelector('.loaded');
			loader.classList.remove('loader');
			console.log("remove complete");
		}
</script>



