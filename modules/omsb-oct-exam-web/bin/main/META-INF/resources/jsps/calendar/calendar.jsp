<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ include file="../../init.jsp" %>

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
					<h5 class="modal-title" id="modal-title">
						
					</h5>
				</div>
				<div class="modal-body">
					<input type="hidden" id="scheduleId">
					<div class="scheduler-event-recorder-body">
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


							
							<td>
								<button type="button"
									class="btn omsb-bc-red-button omsb-bc-red-button-calendar"
									id="blockEventBtn" onclick="getDuratrion('block')">
									<liferay-ui:message key="block" />
								</button>
							</td>
							<td>
								<button type="button"
									class="btn omsb-bc-red-button omsb-bc-red-button-calendar"
									id="cencelEventBtn" onclick="getDuratrion('cancel')">
									<liferay-ui:message key="cancel" />
								</button>
							</td>
							<td>
								<button type="button"
									class="btn omsb-bc-red-button omsb-bc-red-button-calendar"
									id="rescheduleEventBtn" onclick="getDuratrion('reschedule')">
									<liferay-ui:message key="reschedule" />
								</button>
							</td>
							<tr>
								<td colspan="3">
									<button type="button"
										class="btn omsb-bc-red-button omsb-bc-red-button-calendar"
										id="cancelForWholeDayBtn"
										onclick="getDuratrion('cancelForWholeDay')">
										<liferay-ui:message key="cancel-for-whole-day" />
									</button>
								</td>


							</tr>
							<tr>
								<td colspan="3">
									<button type="button"
										class="btn omsb-bc-red-button omsb-bc-red-button-calendar"
										id="blockForWholeDayBtn"
										onclick="getDuratrion('blockForWholeDay')">
										<liferay-ui:message key="block-for-whole-day" />
									</button>
								</td>
							</tr>

							<tr>
								<td colspan="3">
									<button type="button"
										class="btn omsb-bc-red-button omsb-bc-red-button-calendar"
										id="rescheduleForWholeDayBtn"
										onclick="getDuratrion('rescheduleForWholeDay')">
										<liferay-ui:message key="reschedule-for-whole-day" />
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
	function registration(){
		var oldOcExamScheduleId=$("#oldOcExamScheduleId").val();
		console.log("Event Record"+oldOcExamScheduleId);
		var portalURL="<%=themeDisplay.getPortalURL()%>";
		var scheduleId= $('#scheduleId').val();
		window.location.href = portalURL+"/group/guest/oct?p_p_id=gov_omsb_oct_exam_web_OmsbOctExamWebPortlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_gov_omsb_oct_exam_web_OmsbOctExamWebPortlet_mvcRenderCommandName=registration-form&_gov_omsb_oct_exam_web_OmsbOctExamWebPortlet_oCExamScheduleId="+scheduleId+"&_gov_omsb_oct_exam_web_OmsbOctExamWebPortlet_oldOcExamScheduleId="+oldOcExamScheduleId;
	 }
	 function viewDetails(){
			var scheduleId= $('#scheduleId').val();
			var portalURL="<%=themeDisplay.getPortalURL()%>";
			window.location.href = portalURL+"/group/guest/oct?p_p_id=gov_omsb_oct_exam_web_OmsbOctExamWebPortlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_gov_omsb_oct_exam_web_OmsbOctExamWebPortlet_mvcRenderCommandName=view-oct-exam-schedule-render&_gov_omsb_oct_exam_web_OmsbOctExamWebPortlet_role=admin&_gov_omsb_oct_exam_web_OmsbOctExamWebPortlet_octExamScheduleId="+scheduleId;
	}
	 
	 function getDuratrion(action) {
			
			console.log("TEST");
			var scheduleId= $('#scheduleId').val();
			var date =$('#when-detail').html();
			console.log(content)
			var portalURL="<%=themeDisplay.getPortalURL()%>";
			var groupId="<%=themeDisplay.getScopeGroupId()%>";
			var companyId="<%=themeDisplay.getCompanyId()%>";
			
		     console.log(scheduleId);
		     if(scheduleId==""){
		    	 scheduleId=0;
		     }
			console.log("content"+content+"PortalURL"+portalURL+"groupId"+groupId+"companyId"+companyId);
			var url="${themeDisplay.getPortalURL()}/o/oct-calendar-events-api/event-action";
			console.log(url);
			
			$.ajax({
				url: url,
				data: {
					"action" :action,
					"content" :scheduleId,
					"date" :date,
					"portalURL":portalURL,
					"groupId":groupId,
					"companyId":companyId,
					"scheduleId":scheduleId
				},
				type : 'GET',
				success : function(data) {
					console.log("called success");
					console.log(data);
					window.location.reload();
				}
			});
			
		}
</script>
	