<%@ include file="../init.jsp"%>

<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
		
			<div class="row">
				<div class="col-lg-12">
					<ul class="nav nav-pills omsb-nav-pills justify-content-center" id="myTab" role="tablist">
						  <li class="nav-item">
							  <a class="nav-link active" id="trainee-leave-requests-tab" data-toggle="tab" href="#schedule" role="tab" aria-controls="trainee-leave-requests" aria-selected="true"><liferay-ui:message key="leave-application-requests" /></a>
						  </li>
					</ul>
				</div>

				<div class="col-lg-12 mt-4">
					<div class="tab-content" id="v-pills-tabContent">
				
						<!-- Schedule Tab -->
							
							<div class="tab-pane fade show active" id="trainee-leave-requests" role="tabpanel" aria-labelledby="trainee-leave-requests-tab">
								<div class="omsb-page-top-info mb-3">
									<div class="pagetitle"><liferay-ui:message key="view-leave-request" /></div>
								</div>
								<div class="row">											
									<div class="col-md-12">
										<div class="omsb-list-view table-responsive">
											<table class="display omsb-datatables" id="allTraineeLeavesTable">
												<caption></caption>
												<thead>
													<tr>
														<th><liferay-ui:message key="program-name" /></th>
														<th><liferay-ui:message key="trainee-name" /></th>
														<th><liferay-ui:message key="leave-apply-date" /></th>
														<th><liferay-ui:message key="action" /></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="leaveMaster" items="${leaveMasterList}">
														<%
														LeaveMaster leave = (LeaveMaster)pageContext.getAttribute("leaveMaster");
														String programName = StringPool.BLANK;
														if(Validator.isNotNull(leave.getProgramId())) {
															programName = ProgramMasterLocalServiceUtil.getProgramMaster(leave.getProgramId()).getProgramName(locale); 
														}
														%>
														<tr>
															<td><%=programName %></td>
															<td><%= UserLocalServiceUtil.getUser(leave.getTraineeId()).getFullName()%></td>
															<td>${sdf.format(leaveMaster.getCreateDate())}</td>
															<td>
																<portlet:renderURL var="viewLeaveDetails">
																	<portlet:param name="mvcRenderCommandName" value="<%= OmsbLeaveManagementWebConstants.VIEW_LEAVE_DETAILS_RENDER_COMMAND %>"/>
																	<portlet:param name="leaveMasterId" value="${leaveMaster.leaveMasterId}" />																	
																</portlet:renderURL>
																<portlet:renderURL var="adminApproval">
																	<portlet:param name="mvcRenderCommandName" value="<%= OmsbLeaveManagementWebConstants.ADMIN_APPROVAL_RENDER_COMMAND %>"/>
																	<portlet:param name="leaveMasterId" value="${leaveMaster.leaveMasterId}" />																	
																</portlet:renderURL>
																<div class="dropdown ">
																	<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
																		data-toggle="dropdown" aria-expanded="false">
																		<i class=""></i>
																	</button>
																	<ul class="dropdown-menu">
																		<li>
																			<a href="${viewLeaveDetails}" class="dropdown-item">
																				<img src="<%= themeDisplay.getPathThemeImages() %>/svg/fi-rr-eye.svg" alt="VIEW"><liferay-ui:message key="view" />
																			</a>
																		</li>
																		<c:choose>
																			<c:when test="${leaveMaster.status != 0 && leaveMaster.status != 4}">									    	
																				<li>
																					<a href="${adminApproval}" class="dropdown-item"><i
																						class="fa fa-pencil"></i><liferay-ui:message key="approve-reject" />
																					</a>
																				</li>
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
							<!-- Schedule Tab -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

	$(document).ready(function() {
		
		$('#allTraineeLeavesTable').dataTable( {
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
		} );
		
		
		
	});

</script>