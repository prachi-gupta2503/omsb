<%@ include file="init.jsp"%>


<portlet:renderURL var="addConfigureLeaveRuleRenderCommand">
	<portlet:param name="mvcRenderCommandName"
		value="<%=OmsbLeaveManagementWebConstants.VIEW_CONFIGURELEAVE_PAGE%>" />
	<portlet:param name="isAddConfigureLeaveRule" value="true" />
</portlet:renderURL>

<portlet:renderURL var="addAnnualLeaveRuleRenderCommand">
	<portlet:param name="mvcRenderCommandName"
		value="<%=OmsbLeaveManagementWebConstants.ANNUAL_LEAVE_ADD_EDIT_VIEW_PAGE%>" />
	<portlet:param name="isAddConfigureAnnualLeaveRule" value="true" />
</portlet:renderURL>


<portlet:renderURL var="viewAnnualLeaveRuleRenderCommand">
	<portlet:param name="mvcRenderCommandName"
		value="<%=OmsbLeaveManagementWebConstants.ANNUAL_LEAVE_ADD_EDIT_VIEW_PAGE%>" />
</portlet:renderURL>


<%
	boolean isScheduleTab= ParamUtil.getBoolean(request, "isScheduleTab");
	boolean isAnnualLeaveTab = ParamUtil.getBoolean(request, "isAnnualLeaveTab");
%>


<c:if
	test="<%=!SessionErrors.isEmpty(renderRequest) && SessionMessages.isEmpty(renderRequest)%>">
	<div class="alert alert-light alert-danger-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/reject.svg"
				alt="Reject"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span id="showError"><liferay-ui:message
							key="<%=SessionErrors.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>
<c:if
	test="<%=!SessionMessages.isEmpty(renderRequest) && SessionErrors.isEmpty(renderRequest)%>">
	<div class="alert alert-light alert-success-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/Right.svg"
				alt="Right"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span>
					<liferay-ui:message
							key="<%=SessionMessages.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>



<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
		
			<div class="row">
				<div class="col-lg-12">
					<ul class="nav nav-pills omsb-nav-pills justify-content-center" id="myTab" role="tablist">
						<li class="nav-item">
							<a class="nav-link active" id="leaves-tab" data-toggle="tab" href="#leaves" role="tab" aria-controls="leaves" aria-selected="true"><liferay-ui:message key="leaves" /> </a>
						  </li>
						  <li class="nav-item">
							<a class="nav-link" id="annualleaves-tab" data-toggle="tab" href="#annualleaves" role="tab" aria-controls="annualleaves" aria-selected="false"><liferay-ui:message key="annual-leaves" /></a>
						  </li>
						  
					  </ul>
				</div>

				<div class="col-lg-12 mt-4">
					<div class="tab-content" id="v-pills-tabContent">
					
						<!-- Leave Tab -->
						
						<div class="tab-pane fade show active" id="leaves" role="tabpanel" aria-labelledby="leaves-tab">
							<div class="omsb-page-top-info mb-3">
								<div class="pagetitle"><liferay-ui:message key="view-leave-rules" /></div>
								<div class="information">
									<a href="${addConfigureLeaveRuleRenderCommand}" class="btn omsb-bc-red-button">
										<liferay-ui:message key="add-configure-leave" />
									</a>
								</div>
							</div>
							
							
							<div class="row">
								<div class="col-md-12">
									<div class="omsb-list-view table-responsive">
										<table class="display omsb-datatables" id="configureLeaveRulesDatatables">
											<caption></caption>
											<thead>
												<tr>
													<th><liferay-ui:message key="program-name" /></th>
													<th><liferay-ui:message key="added-by" /></th>
													<th><liferay-ui:message key="actions" /></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="program" items="${programList}">
													<c:set var="programMasterObj" value = "${program.key}"/>
													<tr>
														<td>${programMasterObj.getProgramName(themeDisplay.getLocale())}</td>
														<td>${program.value}</td>
			
														<portlet:renderURL var="editConfigureLeaveRule">
															<portlet:param name="mvcRenderCommandName"
																value="<%=OmsbLeaveManagementWebConstants.VIEW_CONFIGURELEAVE_PAGE%>" />
															<portlet:param name="programMasterId"
																value="${programMasterObj.programMasterId}" />
															<portlet:param name="isEditConfigureLeaveRule" value="true" />
														</portlet:renderURL>
			
														<portlet:renderURL var="viewConfigureLeaveRule">
															<portlet:param name="mvcRenderCommandName"
																value="<%=OmsbLeaveManagementWebConstants.VIEW_CONFIGURELEAVE_PAGE%>" />
															<portlet:param name="programMasterId"
																value="${programMasterObj.programMasterId}" />
															<portlet:param name="isViewConfigureLeaveRule"
																value="true" />
														</portlet:renderURL>
			
														<td>
															<div class="dropdown ">
																<button class="btn fa fa-ellipsis-v dropdown-toggle"
																	type="button" data-bs-toggle="dropdown"
																	aria-expanded="false">
																	<i class=""></i>
																</button>
																<ul class="dropdown-menu">
																	<li>
																		<a href="${editConfigureLeaveRule}" class="dropdown-item">
																			<img src="<%= themeDisplay.getPathThemeImages() %>/svg/fi-rr-edit.svg" alt="EDIT"><liferay-ui:message key="edit" />
																		</a>
																	</li>
																	<li>
																		<a href="${viewConfigureLeaveRule}" class="dropdown-item">
																			<img src="<%= themeDisplay.getPathThemeImages() %>/svg/fi-rr-eye.svg" alt="VIEW"><liferay-ui:message key="view" />
																		</a>
																	</li>
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
							
							<!-- Leave Tab -->
							
							<!-- Annual Leave Tab -->
							
							<div class="tab-pane fade" id="annualleaves" role="tabpanel" aria-labelledby="annualleaves-tab">
								<div class="omsb-page-top-info mb-3">
									<div class="pagetitle"><liferay-ui:message key="view-annual-leave-rules" /></div>
									<div class="information">
										<a href="${addAnnualLeaveRuleRenderCommand}" class="btn omsb-bc-red-button"> 
											<liferay-ui:message key="add-annual-rule" />
										</a>
									</div>
								</div>
								<div class="row">
							
									<div class="col-md-12">
										<div class="omsb-list-view table-responsive">
											<table class="display omsb-datatables" id="configureAnnualLeaveRulesDatatables">
												<caption></caption>
												<thead>
													<tr>
														<th><liferay-ui:message key="program-name" /></th>
														<th><liferay-ui:message key="added-by" /></th>
														<th><liferay-ui:message key="actions" /></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="leaveAnnualRule" items="${leaveAnnualMasterList}">
														<%
														LeaveAnnualRule lar = (LeaveAnnualRule)pageContext.getAttribute("leaveAnnualRule");														
														%>
														<tr>
															<% User addedBy = UserLocalServiceUtil.getUser(lar.getCreatedBy()); %>
															<td><%= ProgramMasterLocalServiceUtil.getProgramMaster(lar.getProgramMasterId()).getProgramName(themeDisplay.getLocale()) %></td>
															<td><%= addedBy.getFullName() %></td>
															
															<portlet:renderURL var="editAnnualLeaveRule">
																<portlet:param name="mvcRenderCommandName"
																	value="<%=OmsbLeaveManagementWebConstants.ANNUAL_LEAVE_ADD_EDIT_VIEW_PAGE%>" />
																<portlet:param name="leaveAnnualRuleId"
																	value="${leaveAnnualRule.getLeaveAnnualRuleId()}" />
																<portlet:param name="isEditConfigureAnnualLeaveRule"
																	value="true" />
															</portlet:renderURL>
				
															<portlet:renderURL var="viewAnnualLeaveRule">
																<portlet:param name="mvcRenderCommandName"
																	value="<%=OmsbLeaveManagementWebConstants.VIEW_ANNUAL_LEAVE_RULE%>" />
																<portlet:param name="leaveAnnualRuleId"
																	value="${leaveAnnualRule.getLeaveAnnualRuleId()}" />
															</portlet:renderURL>
															
															<td>
																<div class="dropdown ">
																	<button class="btn fa fa-ellipsis-v dropdown-toggle"
																		type="button" data-bs-toggle="dropdown"
																		aria-expanded="false">
																		<i class=""></i>
																	</button>
																	<ul class="dropdown-menu">
																		<li>
																			<a href="${editAnnualLeaveRule}" class="dropdown-item">
																				<img src="<%= themeDisplay.getPathThemeImages() %>/svg/fi-rr-edit.svg" alt="EDIT"><liferay-ui:message key="edit" />
																			</a>
																		</li>
																		<li>
																			<a href="${viewAnnualLeaveRule}" class="dropdown-item">
																				<img src="<%= themeDisplay.getPathThemeImages() %>/svg/fi-rr-eye.svg" alt="VIEW"><liferay-ui:message key="view" />
																			</a>
																		</li>
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
							
							<!-- Annual Leave Tab -->
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

	$(document).ready(function() {
		$('#configureLeaveRulesDatatables').DataTable({
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
		$('#configureAnnualLeaveRulesDatatables').DataTable({
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
		
		var isAnnualLeaveTab = '<%= isAnnualLeaveTab%>';
		if(isAnnualLeaveTab == 'true'){
			$('#annualleaves-tab')[0].click();
		}
		
	});

</script>