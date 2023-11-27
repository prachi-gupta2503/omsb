<%@ include file="init.jsp" %>

<portlet:actionURL name="<%= OmsbLeaveManagementWebConstants.ADD_EDIT_LEAVE_TYPES %>" var="addEditLeaveTypeActionCommand" >
	<c:if test="${isAdd}">
		<portlet:param name="actionStatus" value="<%= OmsbLeaveManagementWebConstants.ADD %>" />
	</c:if>
	<c:if test="${isEdit}">
		<portlet:param name="actionStatus" value="<%= OmsbLeaveManagementWebConstants.EDIT %>" />
	</c:if>
</portlet:actionURL>


<portlet:renderURL var="viewLeaveManagementTabURL">
    <portlet:param name="jspPage" value="<%= OmsbLeaveManagementWebConstants.LEAVE_MANAGEMENT_TAB %>"/>
</portlet:renderURL>


<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<div class="omsb-page-top-info mb-3">
					<div class="pagetitle"><liferay-ui:message key="configure-leave-rules" /></div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<ul class="nav nav-pills omsb-nav-pills justify-content-center" id="myTab" role="tablist">
						<li class="nav-item">
						  <a class="nav-link active" id="leaves-tab" data-toggle="tab" href="#leaves" role="tab" aria-controls="leaves" aria-selected="true"><liferay-ui:message key="leave-rules" /></a>
						</li>
					</ul>
				</div>

				<div class="col-lg-12 mt-4">
					<div class="tab-content" id="v-pills-tabContent">
						<div class="tab-pane fade show active" id="leaves" role="tabpanel" aria-labelledby="leaves-tab">
						<aui:form name="configureLeaveRuleForm" action="${addEditLeaveTypeActionCommand}" method="POST">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										
										<c:if test="${isEdit}">
											<aui:input name="programName" disabled="true" label="program" id="programName" type="text" value="${program.getProgramName(themeDisplay.getLocale())}"></aui:input>
											<aui:input name="programMasterId" type="hidden" value="${program.getProgramMasterId()}"></aui:input>
										</c:if>
										
										<c:if test="${isAdd}">
											<aui:select required="true" cssClass="js-basic-single" name="programs" label="program" class="form-control" id="program">
												<aui:validator name="required"  ></aui:validator>
												<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="select-program" /></aui:option>
												<c:forEach var="programMaster" items="${programMasterList}">
													<aui:option value="${programMaster.getProgramMasterId()}">
														${programMaster.getProgramName(themeDisplay.getLanguageId())}
													</aui:option>
												</c:forEach>
											</aui:select>
										</c:if>
										
										<c:if test="${isView}">
											<div class="form-group-view">
				                            	<div class="label-name"><liferay-ui:message key="program" /></div>
				                              	<div class="label-content">${program.getProgramName(themeDisplay.getLocale())}</div>
				                         	</div>
										</c:if>
										
									</div>
								</div>
								<div class="col-md-12">
									<div class="omsb-list-view table-responsive">
										<table class="display omsb-datatables configure-leave-datatable">
											<caption></caption>
											<thead>
												<tr>
													<th><liferay-ui:message key="leave-type" /></th>
													<th><liferay-ui:message key="max-number-of-leaves-allowed" /></th>
												</tr>
											</thead>
											
											<tbody>
												<c:choose>
														<c:when test="${!isAdd}">
														<c:forEach var="leaveTypeObj" items="${leaveTypeMap}">
															<c:set var="leaveType" value="${leaveTypeObj.key}"/>
															<c:set var="noOfLeaves" value="${leaveTypeObj.value}"></c:set>
															<tr>
																<td>${leaveType.getLeaveTypes(themeDisplay.getLocale())}</td>
																
																<td>
																	<div class="form-group">
																		
																		<c:if test="${isEdit}">
																			<aui:input disabled="${isView}" min="0" label="" name="noOfLeaves" type="number" value="${noOfLeaves}" >
																				<aui:validator name="min" >0</aui:validator>
																				<aui:validator name="max" >364</aui:validator>
																			</aui:input>
																			<aui:input type="hidden" label=""  name="leaveTypeId" value="${leaveType.getLeaveTypesId()}" />
																		</c:if>
																		<c:if test="${isView}">
																			${noOfLeaves}
																		</c:if>
																		
																	</div>
																</td>
															</tr>
														</c:forEach>
														
													</c:when>
													<c:otherwise>
														<c:forEach var="leaveType" items="${allLeaveTypeList}">
																<tr>
																	<td>${leaveType.getLeaveTypes(themeDisplay.getLocale())}</td>
																	<td>
																		<div class="form-group">
																			<aui:input name="noOfLeaves" label=""  min="0" type="number" value="0" >
																				<aui:validator name="min" >0</aui:validator>
																				<aui:validator name="max" >364</aui:validator>
																			</aui:input>
																			<aui:input type="hidden" label="" name="leaveTypeId" value="${leaveType.getLeaveTypesId()}" />
																		</div>
																	</td>
																</tr>
														</c:forEach>
													</c:otherwise>
												</c:choose>
											</tbody>
										</table>
									</div>
								</div>
								</div>
							
								<div class="bottom-backbtn-wrap">
									
									
									<c:if test="${isEdit || isAdd}">
										<aui:button cssClass="btn omsb-bc-red-button" name="submitButton" type="submit" value="Submit" />
									</c:if>
									
									<a class="btn omsb-btn btn-back" href="${viewLeaveManagementTabURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
								</div>
							
								
							</aui:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>

$(document).ready(function(){
	$(".js-basic-single").select2();
});

</script>
