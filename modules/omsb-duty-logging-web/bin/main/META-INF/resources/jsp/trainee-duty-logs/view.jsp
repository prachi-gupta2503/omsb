<%@ include file="../../init.jsp" %>

<portlet:resourceURL id="<%= MVCCommandNames.ADD_DUTY_LOGS_RESOURCE_COMMAND %>" var="addTraineeDutyLogsURL">
</portlet:resourceURL>

<portlet:renderURL var="viewDutyLogViolationForTraineeURL">
	<portlet:param name="mvcRenderCommandName"	value="<%=MVCCommandNames.TRAINEE_VIEW_DUTY_LOG_VIOLATION%>" />
	<portlet:param name="isTraineeCalendarView"	value="true" />
</portlet:renderURL>

<section class="omsb-main-wrapper" id="omsb-main-wrapper">

	<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
				<div class="omsb-page-top-info">
					<div class="pagetitle"><liferay-ui:message key="log.duty.hours.heading" /></div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div id="success-message" class="alert alert-success" style="display: none;"></div>
						<div id="error-message" class="alert alert-danger" style="display: none;"></div>
					</div>
					<div class="col-lg-8">
						<div class="omsb-card">
							<div id='calendar-container calendar-color'>
								<div id='calendar'></div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="omsb-card omsb-card-graybg calendar-sidebar mb-0">
							<h4 class="omsb-card-title">${programName} - ${cohortYear}</h4>
							<h5><liferay-ui:message key="choose-assignment-definition" /></h5>
							<div id='external-events' class="scroll-horizontal">
								<c:forEach items="${programDutyAssignments}" var="programDutyAssignment">
									<%
										ProgramDutyAssignment pgDutyAssignment = (ProgramDutyAssignment)pageContext.getAttribute("programDutyAssignment");
										String assignmentTitle = StringPool.BLANK, assignmentColorCode = StringPool.BLANK, className = StringPool.BLANK;
										assignmentTitle = DutyLoggingUtil.getAssignmentTitleFromPgDutyAssignmentId(pgDutyAssignment.getProgramDutyAssignmentId());
										assignmentColorCode = DutyLoggingUtil.getAssignmentColorCodeFromPgDutyAssignmentId(pgDutyAssignment.getProgramDutyAssignmentId());
										className = pgDutyAssignment.getStatus().equalsIgnoreCase("Active") ? "fc-event-main" : "fc-event-main disable-cst";
									%>
									<div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event'>
									 	<div class='<%=className %>' data-assignment-color-code='<%=assignmentColorCode %>'>
											<svg width="20" height="10" style=" border-radius: 10%">
												<rect width="300" height="100" style="fill:<%=assignmentColorCode %>;" />
											</svg>
											<%=assignmentTitle%>
										</div>
									</div>
								</c:forEach>
							</div>
							<h5 class="pt-3"><liferay-ui:message key="duty.log.current.selection" /></h5>
							<div class="current-selection">
								<div id="selected-assignment-name">
									<liferay-ui:message key="not-available" />
								</div>
							</div>
						</div>
						<div class="bottom-backbtn-wrap">
							<button class="btn omsb-bc-red-button" title="Save" id="saveLogsBtn"><liferay-ui:message key="save" /></button>
						    <a href="<%=viewDutyLogViolationForTraineeURL%>" class="btn omsb-bc-red-button" type="button"><liferay-ui:message key="duty-log-hour-show-violation" /></a>
						</div>

						<input type="hidden" id="program-id" value="${programId}" />
						<input type="hidden" id="selected-assignment" data-assignment-color-code="" value="" />
						<input type="hidden" id="deleted-assignment" value="" />
						<input type="hidden" id="updated-assignment" value="" />
						<input type="hidden" id="clicked-event-id" value="" />
					</div>
				</div>
			</div>
		</div>
	</div>

	<button type="button" class="btn btn-primary d-none" data-toggle="modal" id="btn" data-target="#duty-log-delete-confirmation-modal"></button>

	<div class="modal fade" id="duty-log-delete-confirmation-modal" tabindex="-1" role="dialog" aria-labelledby="Delete Duty Log" aria-hidden="true" >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title"><liferay-ui:message key="delete.duty.log.heading" /></h5>
				</div>
				<div class="modal-body">
					<p id="defaultMessage"><liferay-ui:message key="delete.duty.log.body" /></p>			  
				</div>
				<div class="modal-footer">
					<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" id="cancel-delete-assignment">
						<liferay-ui:message key="cancel" />
					</button>
					<button class="btn omsb-bc-red-button" data-dismiss="modal" type="button" id="confirm-delete-assignment">
						<liferay-ui:message key="yes" />
					</button>
				</div>
			</div>
		</div>
	</div>

</section>

<script type="text/javascript">

	$(document).ready(function() {

		var events = JSON.parse('${loggedEvents}');

		var calendarTitle = "<liferay-ui:message key='duty.log.calendar.title'/>";
		var errorMessage = "<liferay-ui:message key='duty.logged.error.message'/>";
		var notAvailable = "<liferay-ui:message key='not-available'/>";

		errorMessage = errorMessage.replace("[0]", "<strong>").replace("[1]", "</strong>");

		var calendarOptions = {
			header: {
				left: 'prev',
				center: 'title',
				right: 'next'
			},
			defaultView: 'agendaWeek',
			titleFormat: '[' + calendarTitle + ']',
			editable: false,
			droppable: false,
			// validRange: {
			// 	start: '2023-09-01',
			// 	end: '2023-09-10'
			// },
			defaultTimedEventDuration: '00:30:00',
    		forceEventDuration: true,
			selectable: true,
			selectOverlap: false,
			allDaySlot: false,
			select: function(start, end, allDay) {
				var titleVal = $("#selected-assignment").val();
				var colorCode = $("#selected-assignment").attr("data-assignment-color-code");
				if(titleVal != '') {
					var myEvent = {
						title: titleVal,
						allDay: false,
						start: start,
						end: end,
						overlap: false,
						color: colorCode,
						editable: true
					};
					$("#calendar").fullCalendar( 'renderEvent', myEvent );
				}
			},
			eventClick: function(event, element) {
				$("#clicked-event-id").val(event._id+"##"+event.id);
				$('#btn').trigger( "click" );
			},
			eventResize: function(event) {
				updateChangedAssignmentIds(event.id);
			},
			// eventDrop: function(event, delta, revertFunc, jsEvent, ui, view) {
			// 	updateChangedAssignmentIds(event.id);
			// },
			events: events
		};

		// Initializing the Calendar with the mentioned calendar options...
		$("#calendar").fullCalendar(calendarOptions);

		// This function will update the current selection data & hidden input selected-assignment field...
		$(".fc-event-main").on('click', function(event){
			event.stopPropagation();
			event.stopImmediatePropagation();

			var currentSelectedAssignmentVal = $("#selected-assignment").val();
			var assignmentVal = $(this).text().trim();
			var colorCode = $(this).attr("data-assignment-color-code");
			
			if(currentSelectedAssignmentVal == assignmentVal) {
				$("#selected-assignment").val('');
				$("#selected-assignment").attr('data-assignment-color-code', '');
				$(this).removeAttr("style");
				$("#selected-assignment-name").html(notAvailable);
			} else {
				$('div[class="fc-event-main"]').removeAttr("style");
				$("#selected-assignment").val(assignmentVal);
				$("#selected-assignment").attr('data-assignment-color-code', colorCode);
				$("#selected-assignment-name").html("<svg width='20' height='10' style='border-radius: 10%'><rect width='300' height='100' style='fill:" + colorCode + ";' /></svg> " + assignmentVal);
			}

		});

		// This function will delete the duty log from calendar and close the modal popup...
		$("#confirm-delete-assignment").on('click', function(event) {
			var _id = $("#clicked-event-id").val().split('##')[0];
			var id = $("#clicked-event-id").val().split('##')[1];

			$("#calendar").fullCalendar( 'removeEvents', _id );
			updateDeletedAssigmentIds(id);

			$("#clicked-event-id").val('');
		});

		// This function will close the modal popup...
		$("#cancel-delete-assignment").on('click', function(event) {
			$("#clicked-event-id").val('');
		});

		$("#saveLogsBtn").on('click', function(event) {
			console.log("save btn clicked....");
			var jsonObj = [];
			var loggedEvents = $("#calendar").fullCalendar('clientEvents');

			// Creating a JSONArray of all the Logged Assignments...
			$.each(loggedEvents, function(index, item) {
				var singleEventData = {};
				if(item.id) {
					singleEventData["id"] = item.id;
				}				
				singleEventData["title"] = item.title;
				singleEventData["start"] = item.start._d;
				singleEventData["end"] = item.end._d;

				jsonObj.push(singleEventData);
			});

			// Sorting the above created JSONArray in ascending order on the basis of start Date key...
			jsonObj = jsonObj.sort((firstObj, secondObj) => {
				if (firstObj.start < secondObj.start) {
					return -1;
				}
			});

			// Merging the consecutive duty assignments in the above sorted JSONArray...
			for(var i=jsonObj.length-1; i>= 0; i--) {
				var updatedAssignmentId = $("#updated-assignment").val();
				if(i != 0) {
					var isTitleSame = jsonObj[i].title == jsonObj[i-1].title;
					var isConsecutiveEvent = (jsonObj[i].start + "") === (jsonObj[i-1].end + "");
					if(isTitleSame && isConsecutiveEvent) {
						jsonObj[i-1].end = jsonObj[i].end;
						if(jsonObj[i].hasOwnProperty("id")) {
							if(jsonObj[i-1].hasOwnProperty("id")) {
								updateDeletedAssigmentIds(jsonObj[i].id);
							} else {
								updateChangedAssignmentIds(jsonObj[i].id);
								jsonObj[i-1]["id"] = jsonObj[i].id;
							}
						} else {
							if(jsonObj[i-1].hasOwnProperty("id")) {
								updateChangedAssignmentIds(jsonObj[i-1].id);
							}
						}
						jsonObj.splice(i,1);
					}
				}
			}

			// Removing the unchanged duty assignments from the above updated JSONArray...
			for(var i=jsonObj.length-1; i>= 0; i--) {
				var updatedAssignmentId = $("#updated-assignment").val();
				if(jsonObj[i].id) {
					if(updatedAssignmentId.indexOf(jsonObj[i].id) == -1) {
						jsonObj.splice(i,1);
					}
				}
			}

			$.ajax({
				url: '${addTraineeDutyLogsURL}',
				type: 'POST',
				dataType: 'json',
				data: {
					dutyLogsData: JSON.stringify(jsonObj),
					removedAssignmentIds: $("#deleted-assignment").val(),
					programId: $("#program-id").val()
				},
				success: function (response) {
					console.log("Data Added Successfully");
					if (response.status == "success") {						
						var responseData = response.data;
						calendarOptions.events = responseData;

						resetCalendar();

						$("#success-message").html(response.message).show();
						$("#error-message").hide();
					} else {
						resetCalendar();

						$("#error-message").html(response.message).show();
						$("#success-message").hide();
					}
					setTimeout(function() {
						$("#error-message").hide();
						$("#success-message").hide();
					}, 5000);										
				},
				error: function(xhr, status, error) {
					resetCalendar();

					$("#error-message").html(errorMessage).show();
        			$("#success-message").hide();
					setTimeout(function() {
						$("#error-message").hide();
						$("#success-message").hide();
					}, 5000);
				}
			});

			$("#deleted-assignment").val('');
			$("#updated-assignment").val('');
			$("#selected-assignment").val('');

		});

		// This function will reset the calendar with the mentioned calendar options...
		function resetCalendar() {
			$('#calendar').fullCalendar('destroy');
			$('#calendar').fullCalendar(calendarOptions);

			$("#selected-assignment-name").html(notAvailable);
		}

		// This function will update the hidden input deleted-assignment field...
		function updateDeletedAssigmentIds(id) {
			if(typeof id !== "undefined") {
				var assignmentIds = $("#deleted-assignment").val();
				if(assignmentIds == '') {
					assignmentIds = id;
				} else {
					assignmentIds = assignmentIds + "," + id;
				}
				$("#deleted-assignment").val(assignmentIds);
			}
		}

		// This function will update the hidden input updated-assignment field...
		function updateChangedAssignmentIds(id) {
			if(typeof id !== "undefined") {
				var updatedAssignmentId = $("#updated-assignment").val();
				if(updatedAssignmentId == '') {
					updatedAssignmentId = id;
				} else {
					updatedAssignmentId = updatedAssignmentId + "," + id;
				}
				$("#updated-assignment").val(updatedAssignmentId);
			}
		}
	});
	
</script>