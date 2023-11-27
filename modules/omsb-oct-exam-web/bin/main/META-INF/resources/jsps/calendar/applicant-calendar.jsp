<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ include file="../../init.jsp" %>


<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>


<style>

.omsb-bc-red-button-calendar, .oct-exam-calendar-table{
width:100%
}

.oct-exam-calendar-table td label {
    font-size: 16px;
    font-weight: 600;
}

.calendar-portlet .popover.scheduler-event-recorder-popover .popover-content .close {
    position: absolute;
    right: 12px;
    top: 9px;
    font-size: 30px;
}
.oct-exam-calendar-table {
    padding-top: 5px;
    display: inline-table;
}
.scheduler-event-recorder-header .scheduler-event-recorder-content {

background: #dc3545; border: 0; outline-width: 0;

padding:9px 7px;width: 90%; color: #fff;font-size: 16px;

}
#external-events .datepicker-inline {width: 100%;}

#external-events .table-condensed {width: 100%;border: 1px solid #dee2e6!important;}

#external-events .table-condensed .day:hover { border-radius:0 !important ; -webkit-border-radius:0 !important ; -moz-border-radius:0 !important ; -ms-border-radius:0 !important ; -o-border-radius:0 !important ; }

#external-events .table-condensed thead tr:nth-child(2) {background-color: #DC3545;color: #fff;}

#external-events .table-condensed thead tr:nth-child(2) th { border-radius:0 ; -webkit-border-radius:0 ; -moz-border-radius:0 ; -ms-border-radius:0 ; -o-border-radius:0 ; }

#external-events .table-condensed thead tr th:hover {background-color: #DC3545;color: #fff;}
</style>
<portlet:resourceURL id="<%=MVCCommandNames.GET_REGISTRATION_DETAIL%>"
		var="getRegistrationDetail" />
<section class="omsb-main-wrapper" id="omsb-main-wrapper">

	<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
				<div class="omsb-page-top-info">
					<div class="pagetitle">
						<liferay-ui:message key="Calendar" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div id="success-message" class="alert alert-success"
							style="display: none;"></div>
						<div id="error-message" class="alert alert-danger"
							style="display: none;"></div>
					</div>
					<div class="col-lg-8">
						<div class="omsb-card">
							<div id='calendar-container calendar-color'>
								<div id='calendar'></div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						
						<div id='external-events'>
							<div id="datepicker"></div>
						</div>
					</div>
					
					
					<div class="bottom-backbtn-wrap col-lg-12">
						<a class="btn omsb-btn btn-back" href="${backURL}"><i
							class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a>
					</div>
					
				</div>
			</div>
		</div>
	</div>

	<button type="button" class="btn btn-primary d-none"
		data-toggle="modal" id="btn"
		data-target="#duty-log-delete-confirmation-modal"></button>

	<div class="modal fade" id="duty-log-delete-confirmation-modal"
		tabindex="-1" role="dialog" aria-labelledby="Delete Duty Log"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title"  id="modal-title">
						
					</h5>
				</div>
				<div class="modal-body">
					
					<div class="scheduler-event-recorder-body">
						<input type="hidden" id="scheduleId">
						<table class="oct-exam-calendar-table">
							<tpl
								if="values.permissions.MANAGE_BOOKINGS && !values.hasWorkflowInstanceLink && (status != Liferay.CalendarWorkflow.STATUS_DRAFT)">
							<tr class="calendar-portlet-event-recorder-status-row">
								
							</tr>
							</tpl>

							<tr>
								<td><label><liferay-ui:message key="when-calendar-view" />:</label></td>
								<td><label class="scheduler-event-recorder-date" id="when-detail"></label>
								</td>

								<td>
									<button type="button"
										class="btn omsb-bc-red-button omsb-bc-red-button-calendar"
										id="viewDetailsBtn" onclick="viewDetails()">
										<liferay-ui:message key="view-details" />
									</button>
								</td>
							</tr>


							<tpl
								if="values.editing && values.permissions.VIEW_BOOKING_DETAILS">

							<tr>
								<td colspan="3">
									<button type="button"
										class="btn omsb-bc-red-button omsb-bc-red-button-calendar"
										id="registerNowBtn" onclick="registration()">
										<liferay-ui:message key="register-now" />
									</button>
								</td>
							</tr>
							</tpl>
						</table>
					</div>



				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>

</section>

<script>
$( function() {
	$( "#datepicker" ).datepicker();
} );
$(document).ready(function() {
	initiateCalendar();
});
function initiateCalendar(){
	/* var events = JSON.parse('${scheduleEvents}'); */
	var events="";
	if('${scheduleEvents}'!=''){
		var events=JSON.parse('${scheduleEvents}');
	}
	
	var calendarTitle = "<liferay-ui:message key='scheduled.exams'/>";
	var errorMessage = "<liferay-ui:message key='duty.logged.error.message'/>";
	var notAvailable = "<liferay-ui:message key='not-available'/>";
	console.log(events);
	errorMessage = errorMessage.replace("[0]", "<strong>").replace("[1]", "</strong>");

	var calendarOptions = {
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,basicWeek,basicDay'
			},
			/* defaultView: 'dayGridMonth', */
			plugins: [ 'dayGrid' ], // Load the dayGrid plugin for month view
			initialView: 'dayGridMonth',
			titleFormat: '[' + calendarTitle + ']',
			editable: false,
			droppable: false,
			defaultTimedEventDuration: '00:30:00',
			forceEventDuration: true,
			selectable: true,
			selectOverlap: false,
			allDaySlot: false,
			dayMaxEvents: true,
			views: {
				dayGridMonth: {
					dayMaxEvents: 0 // adjust to 6 only for timeGridWeek/timeGridDay
				}
			},
			eventClick: function(event, element) {
				$("#clicked-event-id").val(event._id+"##"+event.id);
				$("#modal-title").text(event.title);
				$("#scheduleId").val(event.id);
				var dateString = new Date(event.start);
				$("#when-detail").text(dateString.toDateString());
				$('#btn').trigger( "click" );
				var getRegistrationDetail = "${getRegistrationDetail}";
				 $.ajax({
						url: getRegistrationDetail,
						dataType : 'json',
						async : false,
						data : {
							<portlet:namespace />scheduleId : event.id,
						},
						type : 'GET',
						success : function(data) {
							console.log("data"+data.id);
							if(data.id!=0){
								/* $('#registerNowBtn').addClass('d-none'); */
								$('#registerNowBtn').attr('disabled', 'disabled');
				 				$('#registerNowBtn').attr('title','Already Registered');
							}else{
								/* $('#registerNowBtn').removeClass('d-none'); */
								$('#registerNowBtn').removeAttr('disabled');
								$('#registerNowBtn').removeAttr('title');
							}
						},
						complete : function(data) {
							console.log("data"+data.id);
							/* if(data.id!=0){
								$('#registerNowBtn').addClass('d-none');
							}else{
								$('#registerNowBtn').removeClass('d-none');
							} */
						}
			});
				
			},
			eventResize: function(event) {
				updateChangedAssignmentIds(event.id);
			},
			events: events
		}; 
		$("#calendar").fullCalendar(calendarOptions);
}


 
function viewDetails(){
	var scheduleId= $('#scheduleId').val();
	var portalURL="<%=themeDisplay.getPortalURL()%>";
	window.location.href = portalURL+"/group/guest/oct?p_p_id=gov_omsb_oct_exam_web_OmsbOctExamWebPortlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_gov_omsb_oct_exam_web_OmsbOctExamWebPortlet_mvcRenderCommandName=view-oct-exam-schedule-render&_gov_omsb_oct_exam_web_OmsbOctExamWebPortlet_role=applicant&_gov_omsb_oct_exam_web_OmsbOctExamWebPortlet_octExamScheduleId="+scheduleId;
}


function registration(){
	
	var oldOcExamScheduleId=$("#oldOcExamScheduleId").val();
	console.log("Event Record"+oldOcExamScheduleId);
	var portalURL="<%=themeDisplay.getPortalURL()%>";
	
	var scheduleId= $('#scheduleId').val();

	window.location.href = portalURL+"/group/guest/oct?p_p_id=gov_omsb_oct_exam_web_OmsbOctExamWebPortlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_gov_omsb_oct_exam_web_OmsbOctExamWebPortlet_mvcRenderCommandName=registration-form&_gov_omsb_oct_exam_web_OmsbOctExamWebPortlet_oCExamScheduleId="+scheduleId+"&_gov_omsb_oct_exam_web_OmsbOctExamWebPortlet_oldOcExamScheduleId="+oldOcExamScheduleId;
	 
}


</script>
