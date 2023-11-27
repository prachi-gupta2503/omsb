<%@ include file="init.jsp" %>

<liferay-ui:error key="leaves-already-applied-for-these-days" message="leave.already.applied.for.these.days" />

<liferay-ui:error key="leaves-not-remaining" message="leave.not.remaining" />

<liferay-ui:error key="less-days-configured" message="less.days.configured" />

<liferay-ui:error key="leaves-available-at-block-level" message="leaves.available.at.block.level" />

<liferay-ui:error key="leaves-available-at-block-week-level" message="leaves.available.at.block.week.level" />

<liferay-ui:error key="maximum-trainees-already-applied" message="maximum.trainees.already.applied" />

<liferay-ui:error key="violating-attendance-criteria" message="violating.attendance.criteria" />

<liferay-ui:error key="not-allowed-to-take-leaves" message="not.allowed.to.take.leaves" />

<portlet:renderURL var="viewLeavesURL">
    <portlet:param name="jspPage" value="<%= OmsbLeaveStatusConstants.VIEW_LEAVE_JSP %>"/>
</portlet:renderURL>

<portlet:actionURL name="<%= OmsbLeaveStatusConstants.ADD_LEAVE_ACTION_COMMAND %>" var="addLeaveURL" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<%
	String isLeaveCreated = ParamUtil.getString(request, "isLeaveCreated");
	String programId = StringPool.BLANK, programName = StringPool.BLANK, dateOfApplicationValue = StringPool.BLANK;
	String leaveTypeValue = StringPool.BLANK, leaveFromValue = StringPool.BLANK, leaveToValue = StringPool.BLANK, numberOfDaysValue = StringPool.BLANK;
	String contactNameValue = StringPool.BLANK, contactEmailValue = StringPool.BLANK, contactNumberValue = StringPool.BLANK, reasonForLeaveValue = StringPool.BLANK;
	List<LeaveTypes> leaveTypes = LeaveTypesLocalServiceUtil.getLeaveTypeses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	if(Validator.isNotNull(isLeaveCreated)) {
		programId = ParamUtil.getString(request, "programId");		
		programName = ParamUtil.getString(request, "programName");
		dateOfApplicationValue = ParamUtil.getString(request, "dateOfApplicationValue");
		leaveTypeValue = ParamUtil.getString(request, "leaveTypeData");
		leaveFromValue = ParamUtil.getString(request, "leaveFromData");
		leaveToValue = ParamUtil.getString(request, "leaveToData");
		numberOfDaysValue = ParamUtil.getString(request, "numberOfDays");
		contactNameValue = ParamUtil.getString(request, "contactNameData");
		contactEmailValue = ParamUtil.getString(request, "contactEmailData");
		contactNumberValue = ParamUtil.getString(request, "contactNumberData");
		reasonForLeaveValue = ParamUtil.getString(request, "reasonForLeaveData");
	} else {
		programId = String.valueOf((Long)request.getAttribute("programId"));
		programName = (String)request.getAttribute("programName");
		dateOfApplicationValue = (String)request.getAttribute("dateOfApplicationValue");
	}
%>

<aui:form action="${addLeaveURL}" name="fm">

	<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
				<div class="omsb-page-top-info mb-3">
					<div class="pagetitle"><liferay-ui:message key="apply-leave-heading" /></div>							
				</div>

				<aui:input type="hidden" name="programId" value="<%=programId %>" id="programId" />
				
				<div class="row">
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="name-of-trainee" type="text" name="traineeName" 
								value="${themeDisplay.getUser().getFullName()}" readonly="true">
							</aui:input>
						</div>
					</div>
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="omsb-number" type="text" name="omsbNumber" 
								value="${omsbNumber}" localized="false" readOnly="true">
							</aui:input>
						</div>
					</div>
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="program-name" type="text" name="programName" localized="false" 
								value="${programName}" readOnly="true">
							</aui:input>
						</div>
					</div>
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="training-level" value="${traineeLevel}"  type="text" name="trainingLevel" localized="false" readOnly="true" >
							</aui:input>
						</div>
					</div>

					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="training-site" type="text" value="${trainingSiteName}" name="trainingSite" localized="false" readOnly="true" >
							</aui:input>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="sponsor" type="text" value="${sponsor}" name="sponsor" localized="false" readOnly="true" >
							</aui:input>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="address" type="text" value="${traineeAddress}" name="address" readOnly="true" >
							</aui:input>
						</div>
					</div>

					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="email" type="text" name="email"
								value="${themeDisplay.getUser().getEmailAddress()}" readonly="true">
							</aui:input>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="date-of-application" type="text" name="dateOfApplication"
								value="<%=dateOfApplicationValue %>" readonly="true">
							</aui:input>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control js-basic-single" label="leave-type" id="leaveType" name="leaveType" value="<%=leaveTypeValue%>">
	                        	<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="select-leave-type" /></aui:option>
	                        	<c:forEach items="<%=leaveTypes %>" var="leaveType">
									<aui:option value="${leaveType.leaveTypesId}">
										${leaveType.getLeaveTypes(themeDisplay.getLocale())}
									</aui:option>									
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>

					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input name="leaveFrom" id="leaveFrom" value="<%=leaveFromValue%>" label="leave-from" placeholder="select-leave-from-date" type="text" cssClass="form-control datePicker" onChange="updateLeaveDuration()">
								<aui:validator name="required" />
							</aui:input>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input name="leaveTo" id="leaveTo" value="<%=leaveToValue%>" label="leave-to" type="text" placeholder="select-leave-to-date" cssClass="form-control datePicker" onChange="updateLeaveDuration()">
								<aui:validator name="required" />
							</aui:input>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input cssClass="form-control" value="<%=numberOfDaysValue%>" label="no-of-days" type="text" name="noOfDays" readonly="true"
								id="noOfDays">
							</aui:input>
						</div>
					</div>

				</div>

				<h4 class="omsb-card-title"><liferay-ui:message key="contact-while-on-leave-heading" /></h4>

				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input cssClass="form-control" placeholder="enter-contact-name" value="<%=contactNameValue%>" label="contact-name" type="text" name="contactName" localized="false" >
								<aui:validator name="required" />
							</aui:input>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="conatct-email" placeholder="enter-contact-email-address" value="<%=contactEmailValue%>" type="text" name="contactEmail" localized="false" >
								<aui:validator name="required" />
								<aui:validator name="email" errorMessage="please-enter-valid-contact-email"/>
							</aui:input>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="contact-number" placeholder="enter-contact-number" value="<%=contactNumberValue%>" type="text" name="contactNumber" localized="false" >
								<aui:validator name="required" />
								<aui:validator name="number" errorMessage="please-enter-valid-contact-number"/>
								<aui:validator name="maxLength" errorMessage="please-enter-valid-contact-number">8</aui:validator>
								<aui:validator name="minLength" errorMessage="please-enter-valid-contact-number">8</aui:validator>
							</aui:input>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<aui:input name="reasonForLeave" class="form-control" placeholder="enter-reason-for-leave" value="<%=reasonForLeaveValue%>" id="reasonForLeaveTextArea" type="textarea" label="reason.for.leave" localized="true">
							<aui:validator name="required" />
						</aui:input>
					</div>
				</div>
				
				<div class="bottom-backbtn-wrap">
					<button type="submit" class="btn omsb-bc-red-button"><liferay-ui:message key="submit" /></button>
					<a class="btn omsb-btn btn-back" href="${viewLeavesURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
				</div>
			</div>
		</div>
	</div>
</aui:form>

<script>
$(document).ready(function(){
	
	$(".js-basic-single").select2();
	
	$( "#<portlet:namespace/>leaveFrom" ).datepicker({
		format: 'dd-mm-yyyy',
		startDate: new Date(),
		autoclose: true,
		todayBtn: true,
		todayHighlight: true
	});
	
	$( "#<portlet:namespace/>leaveTo" ).datepicker({
		format: 'dd-mm-yyyy',
		startDate: new Date(),
		autoclose: true,
		todayBtn: true,
		todayHighlight: true
	});

	$( "#<portlet:namespace/>leaveFrom" ).change(function() {
		var fromDate = $( "#<portlet:namespace/>leaveFrom" ).val();		
		
		if(fromDate != ''){
			const dateArray = fromDate.split("-");
			
			var newToDate = new Date(dateArray[2], dateArray[1] - 1, dateArray[0]);
			
			newToDate.setDate(newToDate.getDate());
			
			$( "#<portlet:namespace/>leaveTo" ).datepicker('destroy');
			
			$( "#<portlet:namespace/>leaveTo" ).datepicker({
				format: 'dd-mm-yyyy',
				startDate: newToDate,
				autoclose: true,
				todayBtn: false,
				todayHighlight: false,
				//clearBtn: true
			});
		}
	});
	
	$('.alert .alert-indicator').css("display","none");
	$('.alert .lead').css("display","none");
});

function updateLeaveDuration() {
	var fromDate = $("#<portlet:namespace/>leaveFrom").datepicker("getDate");
	var toDate = $("#<portlet:namespace/>leaveTo").datepicker("getDate");
	if(fromDate != null && toDate != null) {
		var days = (toDate- fromDate) / (1000 * 60 * 60 * 24);
		days = Math.round(days) + 1;
		$("#<portlet:namespace/>noOfDays").val(days);
	}
}
</script>