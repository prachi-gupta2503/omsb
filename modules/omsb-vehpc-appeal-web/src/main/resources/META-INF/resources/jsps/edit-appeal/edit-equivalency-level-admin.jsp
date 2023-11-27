<%@ include file="../../init.jsp" %>


<portlet:actionURL name="<%=AppealConstants.SAVE_EQUIVALENCY_RESPONSE %>" var="saveCommitteeResponseURL" >
	<portlet:param name="<%= Constants.CMD %>" value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW %>" />
</portlet:actionURL>


<portlet:actionURL name="<%=AppealConstants.SAVE_EQUIVALENCY_RESPONSE%>" var="saveAdminResponseURL" >
	<portlet:param name="<%= Constants.CMD %>" value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW %>" />
</portlet:actionURL>

<portlet:renderURL var="viewEquivalencyAppealListAdminURL">
<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>


<div  class="container" id="wrapper">
		
	
		<div class="omsb-card">
		<div class="omsb-page-top-info">
			<div class="pagetitle"><liferay-ui:message key="edit-equivalency-appeal" /></div>
			<div class="information"><span class="${appealStatusColur.get(appeallantStatus)}">${appeallantStatus}</span></div>
		</div>
		<div class="omsb-list-view table-responsive">
			<table class="display omsb-tableview" width="100%">
				<thead>
					<tr>
						<th><liferay-ui:message key="name-of-certificate-to-be-evaluated" /></th>
						<th><liferay-ui:message key="equivalency-level" /></th>
						<th><liferay-ui:message key="comments" /></th>
					</tr>
				</thead>
				<tbody>
					<tr class="odd">
						<td>
							<c:if test="${not empty certificatefileurl}">
						      <a href="${certificatefileurl}" target="_blank">
						      <c:out value="${certificateName}" /></a>
						    </c:if>
						</td>
						<td><c:out value="${equivalencylevelkey}" /></td>
						<td>${comments}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="omsb-card ">
		<div class="omsb-card omsb-card-graybg">
	    	<h4 class="omsb-card-title"><liferay-ui:message key="request-details" /></h4>
		      <div class="row">
				<div class="col-md-12 label-box">
				<label class="label-name"> <span>${appeallantUserRole}</span> <liferay-ui:message key="comments"/></label>
				<label class="label-content">${appealComments}</label>
			 </div>
		</div>
		<div class="row">
				<div class="col-md-12 label-box">
					<label class="label-name"><liferay-ui:message key="documents"></liferay-ui:message></label>
				</div>

			<div class="col-md-12">
				<div class="form-group omsb-view-file">
				<c:forEach items="${docsList}" var="info">
					<!-- Access filename, fileEntryID, and docsfileurl for each DocumentInfo object -->
						<c:set var="filename" value="${info.dFFileName}" />
						<c:set var="fileEntryID" value="${info.fileEntryID}" />
						<c:set var="docsfileurl" value="${info.docsfileurl}" />
						
						<label><c:out value="${info.dFFileName}" />
						<span class="">
						<button class="btn btn-label view-download" data-toggle="modal" data-edd="${supportingDoc}" 
						data-State="${docsfileurl}" data-target="#supporting-document"> <liferay-ui:message key="view-file" /></button>
						<a href="${docsfileurl}" class="btn btn-label view-download"  download><liferay-ui:message key="download-file" /></a></span></label></a>
					</c:forEach>
				</div>
			</div>

		</div>
	</div>
	
	<%-- <div class="omsb-card omsb-card-graybg">
		<h4 class="omsb-card-title"><liferay-ui:message key="president-response" /></h4>
		<div class="row">
			<div class="col-md-12 label-box">
				<label class="label-name"><liferay-ui:message key="comments"></liferay-ui:message></label>
				<c:forEach var="status" items="${statusList}">
					<c:if test="${status.isPresident}">
						<label class="label-content">${status.message}</label>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div> --%>
	
	<aui:form action="${saveCommitteeResponseURL}" name="edit_eq_appeal_fm" method="post">
		<aui:input name="equivalencyDecisionLevelId" type="hidden" value="${equivalencyDecisionId}"></aui:input>
		<aui:input name="equivalencyRequestId" type="hidden" value="${equivalencyRequestId }"></aui:input>
		<aui:input name="decisiondocinfo" type="hidden" value="${decisiondocinfo}"></aui:input>
		<aui:input name="appealId" type="hidden" value="${appealId}"></aui:input>
		<aui:input name="transitionName" type="hidden" value="${transitionName }"></aui:input>
		<aui:input name="workflowInstanceId" type="hidden" value="${workflowInstanceId}"></aui:input>
		<aui:input name="workflowTaskId" type="hidden" value="${workflowTaskId}"></aui:input>
		<c:if test="${hasVehpcCommitteeRole}">
			<aui:input name="roleName" type="hidden" value="<%=RoleNameConstants.VEHPC_COMMITTEE %>"></aui:input>	
			<div class="omsb-card">
					<div class="omsb-card-title"><liferay-ui:message key="committee-response" /></div>
					<div class="row">
						<div class="col-md-6 label-box">
								<label class="label-name"><liferay-ui:message key="old-level"></liferay-ui:message></label>
								<label class="label-content"><c:out	value="${level}" /></label>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<aui:select name="committeeNewLevel" label="new-level"><aui:validator name="required"></aui:validator>
									<aui:option value=""><liferay-ui:message key="select" /></aui:option>
									<c:forEach var="equivalencyLevelvalues" items="${equivalencyLevelList}"> 
										<aui:option value="${equivalencyLevelvalues.getListTypeEntryId()}" selected="${equivalencyLevelvalues.getName(themeDisplay.getLocale()) eq equivalencylevelkey ? 'selected' : ''}">
											<liferay-ui:message key="${equivalencyLevelvalues.getName(themeDisplay.getLocale())}" />
										</aui:option>
									</c:forEach>
								</aui:select>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="comments" /><span class="counter"><span
										class="countered_points"><liferay-ui:message key="500" /></span><liferay-ui:message key="/500-remaining" /></span></label>
								<textarea onkeyup="countChar(this)" name="<portlet:namespace/>committeeComments"
									class="committeeComments" rows="1" required="required" id="committee-comments"></textarea>
									<p id="comment-error" class="error-message text-danger d-none">
										<liferay-ui:message key="this-field-is-required"></liferay-ui:message>
									</p>
							</div>
						</div>
					</div>
				
				
			</div>
	</c:if>

			<c:if test="${hasVehpcCAdminRole}">
			<aui:input name="roleName" type="hidden" value="<%=RoleNameConstants.VEHPC_ADMIN %>"></aui:input>
				<div class="omsb-card omsb-card-graybg">
					<div class="omsb-card-title"><liferay-ui:message key="committee-response"></liferay-ui:message> </div>
					<div class="row">
						<div class="col-md-6 label-box">
							<label class="label-name"><liferay-ui:message key="old-level"></liferay-ui:message></label>
							<label class="label-content"><c:out	value="${equivalencylevelkey}" /></label>
						</div>
						<c:forEach var="status" items="${statusList}">
							<c:if test="${status.iscommitte }">
								<c:set var="committeLevel" value="${status.eqLevel}" />	
								<c:set var="committeLevelId" value="${status.eqLevelId}" />	
							</c:if>
						</c:forEach>
						<div class="col-md-6 label-box">
							<label class="label-name"><liferay-ui:message key="new-level"></liferay-ui:message></label>
							<label class="label-content"><c:out	value="${committeLevel}" /></label>
						</div>
						

						<%-- <div class="col-md-12 label-box">
								<label  class="label-name"><liferay-ui:message key="comments" /> </label>
								<label class="label-content">
									<c:forEach var="status" items="${statusList}">
										<c:if test="${status.iscommitte}">
											${status.message}
										</c:if>
									</c:forEach>
								</label>
						</div> --%>
					</div>
				</div>




				<div class="col-lg-12 col-md-12">
					<h4 class="omsb-card-title"><liferay-ui:message key="admin-response" /></h4>
					<div class="row">
						<div class="col-md-6 label-box">
							<label class="label-name"><liferay-ui:message key="old-level"></liferay-ui:message></label>
							<label class="label-content"><c:out	value="${equivalencylevelkey}" /></label>
						</div>
						<div class="col-md-6">
							<div class="form-group-not">
								<aui:select name="adminNewLevel" label="new-level"
									cssClass="omsb-input-select"> <aui:validator name="required"></aui:validator>
									<aui:option value=""><liferay-ui:message key="select"></liferay-ui:message> </aui:option>
									<c:forEach var="equivalencyLevelvalues"
										items="${equivalencyLevelList}">
											<c:set var="selected" value="false"></c:set>
										<c:if test="${equivalencyLevelvalues.getListTypeEntryId() == committeLevelId }">
											<c:set var="selected" value="true"></c:set>
										</c:if>
										<aui:option value="${equivalencyLevelvalues.getListTypeEntryId()}" selected="${selected}">
											<liferay-ui:message key="${equivalencyLevelvalues.getName(themeDisplay.getLocale())}" />
										</aui:option>
									</c:forEach>
								</aui:select>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="comments" /> <span class="counter"><span
										class="countered_points"><liferay-ui:message key="500" /></span><liferay-ui:message key="/500-remaining" /></span></label>
								<textarea onkeyup="countChar(this)" class="adminComments form-control" id="admin-comments"
									rows="1" name="<portlet:namespace/>adminComments" required="required"></textarea>
									
									<p id="comment-error-admin" class="error-message text-danger d-none">
										<liferay-ui:message key="this-field-is-required"></liferay-ui:message>
									</p>
							</div>
						</div>
					</div>
				</div>
			</c:if>
	
<div class="omsb-card">
		<h4 class="omsb-card-title"><liferay-ui:message key="comments" /> </h4>
		<ul class="omsb-comments-list">
			<li>
				<div class="omsb-comment-box">
					<div class="omsb-comment-box-header">
						<h3 class="comment-title">
							<span class="comment-author-name">${appeallantUserName}
							</span>${appeallantUserRole}
						</h3>
						<span class="posted-date">${createdDate}</span>
					</div>
					<div class="omsb-comment-body">
						<p>
							${appealComments}
						</p>
					</div>
				</div>
				<div class="colspan-child"><liferay-ui:message key="expand" /></div>
				<ul>
					<c:forEach var="status" items="${statusList}">
						<li>
							<div class="omsb-comment-box">
								<div class="omsb-comment-box-header">
									<h3 class="comment-title">
										<span class="comment-author-name">${status.fullName} </span>${status.roleType}
									</h3>
									<span class="posted-date">${status.dateCreated}</span>
								</div>
								<div class="omsb-comment-body">
									<p>${status.message}</p>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</li>
		</ul>
	</div>

			<div class="omsb-card bottom-backbtn-wrap">
			<c:if test="${hasVehpcCommitteeRole}">
				<button type="button" class="btn omsb-btn omsb-bc-red-button" onclick="validate()"
					href="#"><liferay-ui:message key="save" /></button>
			</c:if>
			
			<c:if test="${hasVehpcCAdminRole}">
				<button type="button" class="btn omsb-btn omsb-bc-red-button" onclick="validateAdmin()"
					href="#"><liferay-ui:message key="save" /></button>
			</c:if>
				<a class="btn omsb-btn btn-back" href="<%=viewEquivalencyAppealListAdminURL%>"><i
					class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
			</div>
		</aui:form>
	</div>
	</div>
	
	
	<div class="modal fade" id="supporting-document" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog information-box" role="document">
		<div class="modal-content">
			<div class="modal-header d-none">
				<h5 class="modal-title" id="exampleModalLabel"><liferay-ui:message key="supporting-document" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"> 
					<span aria-hidden="true">&times;</span> 
				</button>
			</div>
			<div class="modal-body">
				<div class="omsb-label-view ">
					<div class="label-group-header row">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
						<div class="row">
							<div class="col-md-12 label-box">
								<iframe class="custom-iframe" id="documentFrame" src="${docsfileurl}" ></iframe>
								<label class="label-name"><liferay-ui:message key="supporting-document" /></label> 
								<label class="label-content"><a download href="${docsfileurl}" ><liferay-ui:message key="download-supporting-document" /></a></label>
							</div>
						</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal"><liferay-ui:message key="close" /></button>
			</div>
		</div>
	</div>
</div>




<style>
.omsb-tableview {
    text-align: left;!important
}
.custom-iframe {
  height: 400px; /* Adjust the height value as desired */
}

</style>

<script>
$(document).ready(function() {
	$('.committeeComments').richText();
	$('.adminComments').richText();
});

function validate() {
    var Appealformvalid = 0;
    var app_textarea = $('#committee-comments').siblings('.richText-editor').text(); // Use trim() to remove whitespace
    console.log('app_textarea ' + app_textarea + ' Appealformvalid ' + Appealformvalid);

    if (app_textarea !== '' && app_textarea !== undefined) {
        Appealformvalid = 1;
        $('#comment-error').addClass('d-none');
        console.log('app_textarea if ' + app_textarea + ' Appealformvalid ' + Appealformvalid);
    } else {
        $('#comment-error').removeClass('d-none');
    }

    console.log('Appealformvalid ' + Appealformvalid);
    if (Appealformvalid) {
    	submitForm(document.<portlet:namespace />edit_eq_appeal_fm);
    } else {
        return false;
    }
}

function validateAdmin() {
    var Appealformvalid = 0;
    var app_textarea = $('#admin-comments').siblings('.richText-editor').text(); // Use trim() to remove whitespace
    console.log('app_textarea--admin ' + app_textarea + ' Appealformvalid ' + Appealformvalid);

    if (app_textarea !== '' && app_textarea !== undefined) {
        Appealformvalid = 1;
        $('#comment-error-admin').addClass('d-none');
        console.log('app_textarea if ' + app_textarea + ' Appealformvalid ' + Appealformvalid);
    } else {
        $('#comment-error-admin').removeClass('d-none');
    }
    console.log('Appealformvalid ' + Appealformvalid);
    if (Appealformvalid) {
    	submitForm(document.<portlet:namespace />edit_eq_appeal_fm);
    } else {
        return false;
    }
}

</script>
