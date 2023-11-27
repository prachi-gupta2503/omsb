<%@ include file="../../init.jsp"%>


<%-- <portlet:renderURL var="octExamSetup">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.OCT_NEW__EXAM_SETUP%>" />
	<portlet:param name="cmd" value="addExam" />
</portlet:renderURL>

<portlet:renderURL var="viewOCTScheduledExams">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER%>" />
		
<portlet:renderURL var="viewApplicantRequests">
			<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.VIEW_APPLICANT_REQUESTS%>" />
	<portlet:param name="octExamId" value="${octExamDetail.getId()}" />
</portlet:renderURL>
</portlet:renderURL> --%>
<portlet:resourceURL id="<%=MVCCommandNames.GET_REGISTRATION_DETAIL%>"
		var="getRegistrationDetail" />
<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<div class="omsb-page-top-info">
					<div class="pagetitle">
						<liferay-ui:message key="view-all-oc-scheduled-exams" />
					</div>
				</div>
			</div>
			<div class="master-rotation_tab">
				<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="pills-trainees-tab" data-toggle="pill"
								data-target="#pills-trainees" type="button" role="tab"
								aria-controls="pills-trainees" aria-selected="true" onclick="openGridView()">
								<span></span>
						<liferay-ui:message key="grid-view" /></button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-rotation-tab" data-toggle="pill"
								data-target="#pills-rotation" type="button" role="tab"
								aria-controls="pills-rotation" aria-selected="false" onclick="openCalenderView()">
								<span></span>
							<liferay-ui:message key="calendar-view" /></button>
						</li>
											
					</ul>
				</div>
				
			 <div id="grid-view">
   				 <%@ include file="/jsps/schedule/view-oct-exam-schedule-list.jsp" %>
 			 </div>
 			  <div id="calender-view" class="d-none">
 			  		
   				   <%@ include file="/jsps/exam/calender-view.jsp" %>
 			 </div>	
		</div>
		
	</div>
</div>	
<script>
function openCalenderView(){
	
	$('#grid-view').addClass('d-none');
	$('#calender-view').removeClass('d-none');
	
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
			droppable: false,
			forceEventDuration: true,
			selectable: true,
			selectOverlap: false,
			allDaySlot: false,
			dayMaxEventRows: true,// for all non-TimeGrid views  
			views: {    
				timeGrid: {      
					dayMaxEventRows: 1 // adjust to 6 only for timeGridWeek/timeGridDay    
					}
			},
			moreLinkText: "More Event",
			eventClick: function(event, element) {
				$("#clicked-event-id").val(event._id+"##"+event.id);
				$("#modal-title").text(event.title);
				$("#scheduleId").val(event.id);
				var dateString = new Date(event.start);
				$("#when-detail").text(dateString.toDateString());
				$('#btn').trigger( "click" );
				console.log(event.status);
				
				if(event.status=='cancelled'){
					$("#modal-title").text(event.title+"("+event.status+")");
					$('#blockEventBtn').attr('disabled', 'disabled');
					$('#cencelEventBtn').attr('disabled', 'disabled');
					$('#rescheduleEventBtn').attr('disabled', 'disabled');
					$('#cancelForWholeDayBtn').attr('disabled', 'disabled');
					$('#blockForWholeDayBtn').attr('disabled', 'disabled');
					$('#rescheduleForWholeDayBtn').attr('disabled', 'disabled');
				}else{
					$('#blockEventBtn').removeAttr('disabled');
					$('#cencelEventBtn').removeAttr('disabled');
					$('#rescheduleEventBtn').removeAttr('disabled');
					$('#cancelForWholeDayBtn').removeAttr('disabled');
					$('#blockForWholeDayBtn').removeAttr('disabled');
					$('#rescheduleForWholeDayBtn').removeAttr('disabled');
				}
			},
			
			events: events
		}; 
		$("#calendar").fullCalendar(calendarOptions);
		$("#calendar .fc-button-group .fc-prev-button").click(() => {$("#datepicker .prev").click()})
		$("#calendar .fc-button-group .fc-next-button").click(() => {$("#datepicker .next").click()})
	console.log("caledar created");
}
  
 function openGridView() {
	 $('#calender-view').addClass('d-none');
	 $('#grid-view').removeClass('d-none');
  }
 
 



</script>
