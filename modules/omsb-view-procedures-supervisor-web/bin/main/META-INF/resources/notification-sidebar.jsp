<%@page import="gov.omsb.tms.common.constants.OmsbTmsCommonConstants"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="gov.omsb.tms.custom.dto.TraineeLoggedProcedureDetailsDTO"%>
<%@ include file="/init.jsp"%>


<!-- Notification Sidebar -->

		<div class="omsb-notification-sidebar" id="omsb-notification-sidebar">
			<c:if test="${traineeLoggedProcedureDetailsDTO != null}">
				<div class="omsb-card">
					<div class="omsb-card-header">
						<h5 class="omsb-card-title"><liferay-ui:message key="logged-procedure" /></h5>
						<a href="${allLoggedProcedures}" id="sidebar-close-btn" type="button" class="close" >
							<span aria-hidden="true">&times;</span>
						</a>
					</div>
					<div class="omsb-card-body">
					<div class="omsb-comment-box omsb-BorderRadius-4">
							<div class="omsb-comment-box-header">
								<h3><liferay-ui:message key="status" /></h3>
				                <c:choose>
									<c:when test="${traineeLoggedProcedureDetailsDTO.procedureStatus == 'PASS'}">
										<span class="omsb-pass-bg">${traineeLoggedProcedureDetailsDTO.procedureStatus}</span>
									</c:when>
									<c:when test="${traineeLoggedProcedureDetailsDTO.procedureStatus == 'REFUSE'}">
										<span class="omsb-refuse-bg">${traineeLoggedProcedureDetailsDTO.procedureStatus}</span>
									</c:when>
									<c:when test="${traineeLoggedProcedureDetailsDTO.procedureStatus == 'NOT PASS'}">
										<span class="omsb-notpass-bg">${traineeLoggedProcedureDetailsDTO.procedureStatus}</span>
									</c:when>
									<c:otherwise>
										<span class="omsb-uncofirm-bg">${traineeLoggedProcedureDetailsDTO.procedureStatus}</span>
									</c:otherwise>
								</c:choose>
							</div>
					</div>
					<div class="omsb-comment-box pb-0 omsb-BorderRadius-4">
							<div class="omsb-notification-row">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12">
										<div class="form-group-view">
											<div class="label-name"><liferay-ui:message key="procedure-name" /></div>
											<div class="label-content">${traineeLoggedProcedureDetailsDTO.procedureName}</div>
										</div>
										
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12">
										<div class="form-group-view">
											<%-- <div class="label-name"><liferay-ui:message key="trainee-name" /></div>
											<%
												TraineeLoggedProcedureDetailsDTO traineeLoggedProcedureDetailObj = (TraineeLoggedProcedureDetailsDTO)pageContext.getAttribute("traineeLoggedProcedureDetailsDTO");
												String traineeNameStr = StringPool.BLANK;
												User traineeUser1 = UserLocalServiceUtil.fetchUser(traineeLoggedProcedureDetailObj.getTraineeId());
												if(Validator.isNotNull(traineeUser1)) {
													traineeNameStr = traineeUser1.getFullName();
												}
											%>
											<div class="label-content"><%=traineeNameStr%></div> --%>
										</div>
									</div>
								</div>
							</div>
							<div class="omsb-notification-row">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12">
										<div class="form-group-view">
											<div class="label-name"><liferay-ui:message key="patient-id" /></div>
											<div class="label-content">${traineeLoggedProcedureDetailsDTO.patientId}</div>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12">
										<div class="form-group-view">
											<div class="label-name"><liferay-ui:message key="training-site-name" /></div>
											<div class="label-content">${traineeLoggedProcedureDetailsDTO.trainingSiteName}</div>
										</div>
									</div>
								</div>
							</div>
							<div class="omsb-notification-row">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12">
										<div class="form-group-view">
											<div class="label-name"><liferay-ui:message key="procedure-date" /></div>
											<div class="label-content"><fmt:formatDate pattern= "<%= OmsbTmsCommonConstants.DATE_FORMAT_DD_MM_YYYY %>" value= "${traineeLoggedProcedureDetailsDTO.procedurePerformedDate}" /></div>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12">
										<div class="form-group-view">
											<div class="label-name"><liferay-ui:message key="role" /></div>
											<div class="label-content">${traineeLoggedProcedureDetailsDTO.roleTypeName}</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<c:if test="${traineeLoggedProcedureDetailsDTO.procedureStatus == 'UNCONFIRMED'}">
						<div class="bottom-backbtn-wrap">
							<a class="btn omsb-bc-red-button openPassModel" href="javascript:void(0)" id="${traineeLoggedProcedureDetailsDTO.traineeLoggedProcedureDetailsId}" data-id="${traineeLoggedProcedureDetailsDTO.traineeLoggedProcedureDetailsId}" data-target="#passModalCenter" data-toggle="modal"><liferay-ui:message key="pass" /></a>
							<a class="btn omsb-bc-red-button openNotPassModel" href="javascript:void(0)" id="${traineeLoggedProcedureDetailsDTO.traineeLoggedProcedureDetailsId}" data-id="${traineeLoggedProcedureDetailsDTO.traineeLoggedProcedureDetailsId}" data-target="#notPassModalCenter" data-toggle="modal"><liferay-ui:message key="not-pass" /></a>
							<a class="btn omsb-bc-red-button openRefuseModel" href="javascript:void(0)" id="${traineeLoggedProcedureDetailsDTO.traineeLoggedProcedureDetailsId}" data-id="${traineeLoggedProcedureDetailsDTO.traineeLoggedProcedureDetailsId}" data-target="#refuseModalCenter" data-toggle="modal"><liferay-ui:message key="refuse" /></a>
						</div>
						</c:if>
					</div>
				</div>
			</c:if>
			<c:if test="${traineeLoggedProcedureDetailsDTO == null}">
				<div class="omsb-card">
					<div class="omsb-card-header">
						<h5 class="omsb-card-title">Approve Request - Shared Rotation</h5>
						<a href="${allLoggedProcedures}" id="sidebar-close-btn" type="button" class="close" >
							<span aria-hidden="true">&times;</span>
						</a>
					</div>
					<div class="omsb-card-body">
	                    <div class="norecordfound">
	                        <img src="<%=themeDisplay.getPathThemeImages()%>/png/norecordfound.png" alt="">
						    <h3><liferay-ui:message key="no-record-found" /></h3>
	                    </div>
					</div>
				</div>
			</c:if>
		</div>
		
		<!-- Notification Sidebar -->