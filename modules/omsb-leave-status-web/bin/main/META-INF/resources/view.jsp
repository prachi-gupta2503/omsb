<%@ include file="/init.jsp" %>

<liferay-ui:error key="leaves-not-remaining" message="leave.not.remaining" />

<liferay-ui:error key="less-days-configured" message="less.days.configured" />

<liferay-ui:error key="leaves-available-at-block-level" message="leaves.available.at.block.level" />

<liferay-ui:error key="leaves-available-at-block-week-level" message="leaves.available.at.block.week.level" />

<liferay-ui:error key="maximum-trainees-already-applied" message="maximum.trainees.already.applied" />

<liferay-ui:error key="violating-attendance-criteria" message="violating.attendance.criteria" />

<liferay-ui:error key="not-allowed-to-take-leaves" message="not.allowed.to.take.leaves" />

<portlet:renderURL var="addLeave">
	<portlet:param name="mvcRenderCommandName" value="<%= OmsbLeaveStatusConstants.ADD_LEAVE_JSP %>"/>
</portlet:renderURL>

<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info mb-3">
				<div class="pagetitle"><liferay-ui:message key="leave-application-heading" /></div>
				<div class="information">
					<a href="${addLeave}" type="button" class="btn omsb-bc-red-button"> <liferay-ui:message key="apply-leave" /> </a>
				</div>
			</div>
			
			<div class="omsb-list-view table-responsive">
				<table class="display omsb-datatables" id="leaveStatusTable">
					<caption></caption>
					<thead>
						<tr>
							<th><liferay-ui:message key="leave-type-table-heading" /></th>
							<th><liferay-ui:message key="from-date-table-heading" /></th>
							<th><liferay-ui:message key="to-date-table-heading" /></th>
							<th><liferay-ui:message key="no-of-days-table-heading" /></th>
							<th><liferay-ui:message key="leave-status-table-heading" /></th>
							<th><liferay-ui:message key="action-table-heading" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${leaveMasters}" var="leaveMaster">
						<%
			            LeaveMaster leave = (LeaveMaster)pageContext.getAttribute("leaveMaster");
						String programName = StringPool.BLANK;
						if(Validator.isNotNull(leave.getProgramId())) {
							programName = ProgramMasterLocalServiceUtil.getProgramMaster(leave.getProgramId()).getProgramName(locale); 
						}
						Date curDate = new Date();
			            %>
							<tr>
								<td><%= LeaveTypesLocalServiceUtil.getLeaveTypes(leave.getLeaveTypeId()).getLeaveTypes(themeDisplay.getLocale()) %></td>
								<td>${sdf.format(leaveMaster.getLeaveFrom())}</td>
								<td>${sdf.format(leaveMaster.getLeaveTo())}</td>
								<td>${leaveMaster.noOfDays}</td>
								<td>
									<aui:workflow-status markupView="lexicon" showIcon="<%= false %>" showLabel="<%= false %>" status="${leaveMaster.status}" />
								</td>
								<td>
									<portlet:renderURL var="viewLeaveDetails">
										<portlet:param name="mvcRenderCommandName" value="<%= OmsbLeaveStatusConstants.VIEW_LEAVE_DETAILS_RENDER_COMMAND %>"/>
										<portlet:param name="leaveMasterId" value="${leaveMaster.leaveMasterId}" />
									</portlet:renderURL>
									<portlet:renderURL var="returnFromLeaveRenderURL">
										<portlet:param name="mvcRenderCommandName" value="<%=OmsbLeaveStatusConstants.RETURN_FROM_LEAVE_RENDER_COMMAND%>" />
										<portlet:param name="leaveMasterId" value="${leaveMaster.leaveMasterId}" />
									</portlet:renderURL>
									<portlet:actionURL name="<%= OmsbLeaveStatusConstants.CANCEL_LEAVE_ACTION_COMMAND %>" var="cancelLeaveURL" >
										<portlet:param name="leaveMasterId" value="${leaveMaster.leaveMasterId}"/>
									</portlet:actionURL>
									<div class="dropdown ">
										<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
											data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
										<ul class="dropdown-menu">
											<li>
												<a href="${viewLeaveDetails}" class="dropdown-item">
													<img src="<%= themeDisplay.getPathThemeImages() %>/svg/fi-rr-eye.svg" alt="View"><liferay-ui:message key="view" />
												</a>
											</li>
											
											<c:choose>
												<c:when test="${leaveMaster.status == 0 && leaveMaster.returnFromLeave == null}">									    	
													<li>
														<portlet:renderURL var="returnFromLeaveRenderURL">
															<portlet:param name="mvcRenderCommandName" value="<%=OmsbLeaveStatusConstants.RETURN_FROM_LEAVE_RENDER_COMMAND%>" />
															<portlet:param name="leaveMasterId" value="${leaveMaster.getLeaveMasterId()}" />
														</portlet:renderURL>
														
														<a href="${returnFromLeaveRenderURL}" class="dropdown-item"><i
															class="fa fa-pencil"></i><liferay-ui:message key="submit-return" />
														</a>
													</li>
													
													<fmt:formatDate var="date_to_comare" value="${leaveMaster.leaveFrom}" pattern="yyyy-MM-dd HH:mm:ss"/>
													<c:set var="today_date" value="<%=new java.util.Date()%>"/>
													<fmt:formatDate var="today_formated_date" value="${today_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
													
													<c:if test="${date_to_comare gt today_formated_date}">
														<li>
															<a href="${cancelLeaveURL}" class="dropdown-item"><i
																class="fa fa-pencil"></i><liferay-ui:message key="cancel-leave" />
															</a>
														</li>
													</c:if>
												</c:when>
												<c:when test="${leaveMaster.status == 4 && leaveMaster.returnFromLeave == null}">
													<jsp:useBean id="now" class="java.util.Date" />
													<portlet:actionURL name="<%= OmsbLeaveStatusConstants.ADD_LEAVE_ACTION_COMMAND %>" var="addLeaveURL" >
														<portlet:param name="isReSubmit" value="true"/>
														<portlet:param name="programId" value="${leaveMaster.programId}"/>
														<portlet:param name="dateOfApplication" value="${sdf.format(now)}"/>
														<portlet:param name="leaveFrom" value="${sdf.format(leaveMaster.getLeaveFrom())}"/>
														<portlet:param name="leaveTo" value="${sdf.format(leaveMaster.getLeaveTo())}"/>
														<portlet:param name="contactName" value="${leaveMaster.contactName}"/>
														<portlet:param name="contactEmail" value="${leaveMaster.contactEmail}"/>
														<portlet:param name="contactNumber" value="${leaveMaster.contactNo}"/>
														<portlet:param name="reasonForLeave" value="${leaveMaster.reasonForLeave}"/>
														<portlet:param name="programName" value="<%=programName%>"/>
														<portlet:param name="leaveType" value="${leaveMaster.leaveTypeId}"/>
														<portlet:param name="noOfDays" value="${leaveMaster.noOfDays}"/>
													</portlet:actionURL>

													<li>
														<a href="${addLeaveURL}" class="dropdown-item"><i
															class="fa fa-pencil"></i><liferay-ui:message key="re-submit" />
														</a>
													</li>													
												</c:when>
												<c:when test="${leaveMaster.status == 1 && leaveMaster.returnFromLeave == null}">
													
													<fmt:formatDate var="date_to_comare" value="${leaveMaster.leaveFrom}" pattern="yyyy-MM-dd HH:mm:ss"/>
													<c:set var="today_date" value="<%=new java.util.Date()%>"/>
													<fmt:formatDate var="today_formated_date" value="${today_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
													
													<c:if test="${date_to_comare gt today_formated_date}">
														<li>
															<a href="${cancelLeaveURL}" class="dropdown-item"><i
																class="fa fa-pencil"></i><liferay-ui:message key="cancel-leave" />
															</a>
														</li>
													</c:if>
													
												</c:when>
											</c:choose>
										</ul>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<script>
$(document).ready(function() {
	$('#leaveStatusTable').DataTable({
		"order": [],
		"lengthChange": false,
		dom: 'Bfrtip',
		buttons: [
            {
              extend: 'colvis',
              text: '<liferay-ui:message key="column-visibility" />',
              columns: ":not(':last')"
            },
            {
                extend: 'collection',
                text: '<liferay-ui:message key="export-as" />',
                buttons: [
                    {
                        extend: 'csv',
                        exportOptions: {
                            columns: ':visible',
                            columns: ":not(':last')"
                        }
                    },
                    {
                        extend: 'pdf',
                        exportOptions: {
                            columns: ':visible',
                            columns: ":not(':last')"
                        }
                    },
                    {
                        extend: 'excel',
                        exportOptions: {
                            columns: ':visible',
                            columns: ":not(':last')"
                        }
                    },
                    {
                        extend: 'print',
                        exportOptions: {
                            columns: ':visible',
                            columns: ":not(':last')"
                        }
                    }
                ]
            }
        ]
	});
});
</script>
