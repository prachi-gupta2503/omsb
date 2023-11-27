<%@ include file="../../init.jsp" %>

<portlet:renderURL var="myFacultyRequestsURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<portlet:actionURL name="<%= FacultyMembershipConstants.UPDATE_FACULTY_REQUEST_DETAILS_ACTION_COMMAND %>" var="updateFacultyRequestDetails" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<portlet:resourceURL id="<%= FacultyMembershipConstants.DELETE_EDUCATION_DETAILS_RESOURCE_COMMAND %>" var="deleteEducationDetailsURL">
</portlet:resourceURL>

<portlet:resourceURL id="<%= FacultyMembershipConstants.ADD_EDUCATION_DETAILS_RESOURCE_COMMAND %>" var="addEducationDetailsURL">
</portlet:resourceURL>


    <div class="container" id="wrapper">
        <aui:form action="${updateFacultyRequestDetails}" name="fm">
        <div class="omsb-card">
            <div class="omsb-page-top-info">
                <div class="pagetitle"><liferay-ui:message key="add.edit.faculty.request.details.heading" /></div>
            </div>
    
            <div class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">
                <div class="omsb-page-top-info">
                    <div class="pagetitle"><liferay-ui:message key="faculty.request.bank.details.heading"/></div>
                </div>
                
                <div class="row">
                    <div class="col-lg-4 col-md-6">
                        <div class="form-group">
                            <label><liferay-ui:message key="faculty.request.bank.name"/></label>			
                            <c:if test="${empty facultyMembershipDetails.bankName}">
                                <input type="text" value="" class="form-control" name="<portlet:namespace />bankName">
                            </c:if>
                            <c:if test="${not empty facultyMembershipDetails.bankName}">
                                <input type="text" value="${facultyMembershipDetails.bankName}" class="form-control" name="<portlet:namespace />bankName">
                            </c:if>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="form-group">
                            <label><liferay-ui:message key="faculty.request.account.number"/></label>				
                            <c:if test="${empty facultyMembershipDetails.accountNumber}">
                                <input type="text" value="" class="form-control" name="<portlet:namespace />accountNumber">
                            </c:if>
                            <c:if test="${not empty facultyMembershipDetails.accountNumber}">
                                <input type="text" value="${facultyMembershipDetails.accountNumber}" class="form-control" name="<portlet:namespace />accountNumber">
                            </c:if>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="form-group">
                            <label><liferay-ui:message key="faculty.request.branch.name"/></label>                   
                            <c:if test="${empty facultyMembershipDetails.bankBranchName}">
                                <input type="text" value="" class="form-control" name="<portlet:namespace />branchName">
                            </c:if>
                            <c:if test="${not empty facultyMembershipDetails.bankBranchName}">
                                <input type="text" value="${facultyMembershipDetails.bankBranchName}" class="form-control" name="<portlet:namespace />branchName">
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
                        <div class="form-group">
                            <label><liferay-ui:message key="faculty.request.passport.id"/></label>
                            <div class="custom-file mb-3">
                                <input type="file" class="custom-file-input" id="Passport" name="<portlet:namespace />passportCopy">                           
                                <label class="custom-file-label" for="Passport">${facultyMembershipDetails.passportCopyFileName}</label>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="form-group">
                            <label><liferay-ui:message key="faculty.request.national.id.proof"/></label>
                            <div class="custom-file mb-3">
                                <input type="file" class="custom-file-input" id="NationalID" name="<portlet:namespace />nationalID">
                                <label class="custom-file-label" for="NationalID">${facultyMembershipDetails.nationalIdProofFileName}</label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    
            <div class="omsb-card px-0 pt-0 pb-0 other-documents-wrap">
                <h4 class="omsb-card-title mb-2"><liferay-ui:message key="faculty.request.education.details.heading"/>
                    <button class="btn omsb-bc-red-button" data-toggle="modal"
                        data-target="#addeducationdetails" type="button">
                        Add Education Details
                    </button>
                </h4>
                <div class="omsb-list-view table-responsive">
                    <table class="display omsb-datatables" id="other-documentss-table">
                        <thead>
                            <tr>
                                <th><liferay-ui:message key="faculty.request.education.title"/></th>
                                <th><liferay-ui:message key="faculty.request.education.institution"/></th>
                                <th><liferay-ui:message key="faculty.request.education.institution.country"/></th>
                                <th><liferay-ui:message key="faculty.request.education.gpa"/></th>
                                <th><liferay-ui:message key="faculty.request.education.year"/></th>
                                <th><liferay-ui:message key="faculty.request.education.qualification.documents"/></th>
                                <th><liferay-ui:message key="faculty.request.action"/></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${not empty educationDetails}">
                                <c:forEach items="${educationDetails}" var="educationDetail">
                                    <tr id="${educationDetail.id}">
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
                                        <td>
                                            <div class="dropdown ">
                                                <button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
                                                    data-bs-toggle="dropdown" aria-expanded="false">
                                                    <i class=""></i>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a href="javascript:void(0)" data-toggle="modal"
                                                            data-target="#editeducationdetails" data-education-id="${educationDetail.id}"
                                                            class="dropdown-item"><img
                                                                src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"> Edit</a></li>
                                                    <li><a data-toggle="modal" class="delete-education-details"
                                                            data-target="#confirmation" data-education-id="${educationDetail.id}" class="dropdown-item"><img
                                                                src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-delete.svg"> Delete</a></li>
                                                </ul>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>                    
                        </tbody>
                    </table>
                </div>
    
            </div>
    
            <div class="omsb-card mb-0 p-0">
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

            <input type="hidden" name="<portlet:namespace />facultyRequestId" value="${facultyRequestId}" />
            <input type="hidden" name="<portlet:namespace />personId" id="person-id" value="${personId}" />
            <input type="hidden" name="<portlet:namespace />deleteEducationId" id="delete-education-id" value="" />
            <aui:input type="hidden" name="workflowTaskDetails" />
            <div class="bottom-backbtn-wrap">
              <c:choose>
               <c:when test="${not empty workflowTaskDetail.actionList }">
		     	<button class="btn omsb-bc-red-button" type="submit" title="Resend Request" id="submitBtn"
					onClick="saveAndSubmit(`${workflowTaskDetail.taskId }`,
												`${workflowTaskDetail.firstTransitionName}`,`${workflowTaskDetail.workflowInstanceId }`)">
						<liferay-ui:message key="faculty-request-add-membership-details" />
				</button>
		      </c:when>
		      </c:choose>
                        
                <a class="btn omsb-btn btn-back" href="${myFacultyRequestsURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
            </div>
        </div>
        </aui:form>
    </div>
    
    <div class="modal fade omsb-modal" id="addeducationdetails" tabindex="-1" role="dialog"
        aria-labelledby="addeducationdetailsTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Add Faculty education details</h5>
                    <button type="button" class="close cancel-add-education-details" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <aui:form action="#" id="faculty_education_details" name="faculty_education_details" method="post"
				    enctype="multipart/form-data">
                    <input type="hidden" name="<portlet:namespace />facultyRequestId" value="${facultyRequestId}" />
                    <input type="hidden" name="<portlet:namespace />personId" id="person-id" value="${personId}" />
                   	<aui:input type="hidden" name="workflowTaskDetails" />
                   
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="form-group">
                                    <label>Title</label>
                                    <input type="text" class="form-control" name="<portlet:namespace />addEducationTitle" id="add-education-title">
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="form-group">
                                    <aui:select cssClass="custom-select form-control js-basic-single" label="institution" id="add-education-institution"
                                        name="institution">
                                        <aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="select-leave-type" /></aui:option>
                                        <c:forEach items="${institutions}" var="institution">
                                            <aui:option value="${institution.getKey()}">
                                                ${institution.getName(themeDisplay.getLocale())}
                                            </aui:option>									
                                        </c:forEach>
                                    </aui:select>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="form-group">
                                    <aui:select cssClass="custom-select form-control js-basic-single" label="country-of-institutions" id="add-education-country" 
                                        name="country">
                                        <aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="select-leave-type" /></aui:option>
                                        <c:forEach items="${countries}" var="country">
                                            <aui:option value="${country.getCountryId()}">
                                                ${country.getName(themeDisplay.getLocale())}
                                            </aui:option>									
                                        </c:forEach>
                                    </aui:select>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label>GPA</label>
                                    <input type="text" class="form-control" name="<portlet:namespace />gpa" id="add-education-gpa">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <aui:select cssClass="custom-select form-control js-basic-single" label="year-of-graduation" id="add-education-year" 
                                        name="year">
                                        <aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="select-year" /></aui:option>
                                        <c:forEach items="${years}" var="year">
                                            <aui:option value="${year}">
                                                ${year}
                                            </aui:option>									
                                        </c:forEach>
                                    </aui:select>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label>Qualification Document</label>
                                    <div class="custom-file mb-3">
                                        <input type="file" class="custom-file-input"
                                            name="<portlet:namespace />qualificationDocument" id="add-education-qualificationDocument">
                                        <label class="custom-file-label" for="add-education-qualificationDocument"></label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn omsb-bc-red-button" type="button" title="Save" id="add-education-details">Save</button>
                        <button class="btn omsb-btn btn-back cancel-add-education-details" type="button" data-dismiss="modal"
                            aria-label="Close">Close</button>
                    </div>

                </aui:form>
            </div>
        </div>
    </div>
    

    <div class="modal fade omsb-modal" id="confirmation" tabindex="-1" role="dialog"
        aria-labelledby="confirmationTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-sm modal-dialog-centered" role="document" style="max-width: 500px;">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Delete</h5>
                    <button type="button" class="close cancel-delete-education-details" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Are you sure want to delete? </p>
                </div>
                <div class="modal-footer">
                    <button class="btn omsb-bc-red-button" type="button" id="confirm-delete-education"
                        title="Delete">Delete</button>
                    <button class="btn omsb-btn omsb-bg-red-button cancel-delete-education-details" type="button"
                        data-dismiss="modal">Cancel</button>
                </div>
            </div>
        </div>
    </div>

<script>
    $(document).ready(function() {
        var educationDetailsTable = $('#other-documentss-table').DataTable({});

        $(".delete-education-details").on('click', function(event) {
            event.preventDefault();
            var educationId = $(this).attr("data-education-id");
            console.log(" User Wants to Delete " + educationId + ".");
            $("#delete-education-id").val(educationId);
        });

        $("#confirm-delete-education").on('click', function(event) {
            var educationId = $("#delete-education-id").val();
            var personId = $("#person-id").val();
            console.log("Going To Delete " + educationId + ".");

            $.ajax({
				url: '${deleteEducationDetailsURL}',
				type: 'POST',
				dataType: 'json',
				data: {
					educationId: educationId,
					personId: personId
				},
				success: function (response) {
                    if (response.status == "success") {	
                        console.log("Data Deleted Successfully");
                        $(".cancel-delete-education-details").trigger("click");
                        educationDetailsTable.row("#"+educationId).remove().draw();
                    } else {
                        console.log("Unable To Delete Data");   
                    }					
				},
				error: function(xhr, status, error) {
					console.log("Error While Deleting Education Details");
				}
			});
        });

        $(".cancel-delete-education-details").on('click', function(event) {
            console.log("resetting the delete-education-id to empty");
            $("#delete-education-id").val('');
        });

        $("#add-education-details").on('click', function(event) {
            var personId = $("#person-id").val();
            console.log("Going To Add Education Details.");

            var form= $('#<portlet:namespace/>faculty_education_details')[0];
            var jsonData = bindFormDataJson(form);
            var formdata = new FormData(form);
            var url = '<%=addEducationDetailsURL.toString()%>';

            $.ajax({
				url: url,
				type: 'POST',
				// dataType: 'json',
				data: formdata,
                contentType: false,
                cache : false,
                processData: false,
				success: function (response) {
                    console.log("Response -> " + response);
                    if (response.status == "success") {
                        console.log("Data Added Successfully");                        
					    $(".cancel-delete-education-details").trigger("click");
                    } else {
                        console.log("Unable To Add Data, Status : " + response.status);
                    }
				},
				error: function(xhr, status, error) {
					console.log("Error While Deleting Education Details");
				}
			});
        });

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
                    return `<a href="`+data+`" class="dropdown-item" target="_blank">
                    <liferay-ui:message key='ec-member-request-view-document'/> </a>`;
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
        });

        <%-- function getEducationDetails(){
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
        } --%>

        $(".cancel-add-education-details").on('click', function(event) {
            console.log("resetting the delete-education-id to empty");
            $("#delete-education-id").val('');
            $("#add-education-title").val('');
            $("#add-education-institution").val('');
            $("#add-education-country").val('');
            $("#add-education-gpa").val('');
            $("#add-education-year").val('');
            $("#add-education-qualificationDocument").val('');
        });

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
    });
    
    function saveAndSubmit(workflowTaskId,transitionName,workflowInstanceId ){
		let details ="{workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+transitionName+"}"; 
		$("#<portlet:namespace />workflowTaskDetails").val(details);
		return true;
	}
</script>