<%@page import="gov.omsb.view.procedures.supervisor.web.constants.OmsbViewProceduresSupervisorWebPortletKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="gov.omsb.tms.model.TraineeLoggedProcedureDetails"%>
<%@ include file="/init.jsp"%>

<%
	TraineeLoggedProcedureDetails patientDetails = (TraineeLoggedProcedureDetails)renderRequest.getAttribute(OmsbViewProceduresSupervisorWebPortletKeys.TRAINEE_LOGGED_PROCEDURE_DETAIL);
	SimpleDateFormat sdf = (SimpleDateFormat)renderRequest.getAttribute(OmsbViewProceduresSupervisorWebPortletKeys.SDF);
	String patientDOB = sdf.format(patientDetails.getPatientDOB());
	String procedurePerformedDate = sdf.format(patientDetails.getProcedurePerformedDate());
%>

<div id="wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="omsb-card">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="logged-procedure-detail" />
					</h4>

					<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
						<h5 class="omsb-card-title">
							<liferay-ui:message key="patient-info" />
						</h5>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="patient-id" />
									</div>
									<div class="label-content">${traineeLoggedProcedureDetail.patientId}</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="patient-gender" />
									</div>
									<div class="label-content">${genderMasterName}</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="patient-type" />
									</div>
									<div class="label-content">${patientTypeName}</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="visit-type" />
									</div>
									<div class="label-content">${visitTypeName}</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="date-of-birth" />
									</div>
									<div class="label-content"><%= patientDOB %></div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="date-performed" />
									</div>
									<div class="label-content"><%= procedurePerformedDate %></div>
								</div>
							</div>
						</div>
					</div>

					<h4 class="omsb-card-title">
						<liferay-ui:message key="log-procedures" />
					</h4>
					<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
						<h5 class="omsb-card-title">
							<liferay-ui:message key="procedure" />
						</h5>
						<div class="row">
							<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="cpt-code" />
									</div>
									<div class="label-content">${cptCodeName}</div>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="procedure-group" />
									</div>
									<div class="label-content">${procedureGroupName}</div>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="procedure" />
									</div>
									<div class="label-content">${procedureName}</div>
								</div>
							</div>
						</div>
					</div>

					<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
						<h5 class="omsb-card-title">
							<liferay-ui:message key="diagnosis" />
						</h5>
						<div class="row">
							<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-content">${traineeLoggedProcedureDetail.getDiagnosisDescription(themeDisplay.getLocale())}</div>
								</div>
							</div>
						</div>
					</div>

					<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
						<h5 class="omsb-card-title">
							<liferay-ui:message key="additional-info" />
						</h5>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="case-location" />
									</div>
									<div class="label-content">${trainingSiteName}</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="role-type" />
									</div>
									<div class="label-content">${roleTypeName}</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="supervisor" />
									</div>
									<div class="label-content">${supervisorName}</div>
								</div>
							</div>
							<div class="col-lg-12 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="comments" />
									</div>
									<div class="label-content">${traineeLoggedProcedureDetail.getTraineeComments(themeDisplay.getLocale())}</div>
								</div>
							</div>
						</div>
					</div>
					<div class="bottom-backbtn-wrap">
						<c:if
							test="${'UNCONFIRMED' == traineeLoggedProcedureDetail.procedureStatus}">
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, PASS_LOG_PROCEDURE)}">
								<a class="btn omsb-bc-red-button openPassModel"
									href="javascript:void(0)"
									id="${traineeLoggedProcedureDetail.traineeLoggedProcedureDetailsId}"
									data-id="${traineeLoggedProcedureDetail.traineeLoggedProcedureDetailsId}"
									data-target="#passModalCenter" data-toggle="modal"><liferay-ui:message
										key="pass" /></a>
							</c:if>
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NOT_PASS_LOG_PROCEDURE)}">
								<a class="btn omsb-bc-red-button openNotPassModel"
									href="javascript:void(0)"
									id="${traineeLoggedProcedureDetail.traineeLoggedProcedureDetailsId}"
									data-id="${traineeLoggedProcedureDetail.traineeLoggedProcedureDetailsId}"
									data-target="#notPassModalCenter" data-toggle="modal"><liferay-ui:message
										key="not-pass" /></a>
							</c:if>
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, REFUSE_LOG_PROCEDURE)}">
								<a class="btn omsb-bc-red-button openRefuseModel"
									href="javascript:void(0)"
									id="${traineeLoggedProcedureDetail.traineeLoggedProcedureDetailsId}"
									data-id="${traineeLoggedProcedureDetail.traineeLoggedProcedureDetailsId}"
									data-target="#refuseModalCenter" data-toggle="modal"><liferay-ui:message
										key="refuse" /></a>
							</c:if>
						</c:if>
					</div>
					<div class="bottom-backbtn-wrap">
						<liferay-portlet:renderURL var="viewProcedure">
							<liferay-portlet:param name="mvcRenderCommandName" value="/" />
							<liferay-portlet:param name="tab" value="${tab}" />
						</liferay-portlet:renderURL>

						<a class="btn omsb-btn btn-back" href="${viewProcedure}"> <i
							class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" />
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/model-popup.jsp" />

<script>

$(document).ready(function () {
	
	$(".label-content").each(function() {
	    var content = $(this).html().trim();
	    if (content.length == 0) {
	      $(this).html("-");
	    }
	});
	
});

$(document).on("click",".openPassModel", function(){
	$('#<portlet:namespace/>traineeLoggedProcedureDetailsIdsForPass').val(''+($(this).data('id')));
});

$(document).on("click",".openNotPassModel", function(){
	$('#<portlet:namespace/>traineeLoggedProcedureDetailsIdsForNotPass').val(''+($(this).data('id')));
});

$(document).on("click",".openRefuseModel", function(){
	$('#<portlet:namespace/>traineeLoggedProcedureDetailsIdsForRefuse').val(''+($(this).data('id')));
});
</script>