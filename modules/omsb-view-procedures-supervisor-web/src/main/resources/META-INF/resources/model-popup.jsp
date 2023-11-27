<%@page import="gov.omsb.view.procedures.supervisor.web.constants.OmsbViewProceduresSupervisorWebPortletKeys"%>
<%@ include file="/init.jsp" %>

<!-- Comment Modal -->
<portlet:actionURL name="<%= OmsbViewProceduresSupervisorWebPortletKeys.PASS_PRODCEDURE %>" var="passProcedure">
	<portlet:param name="redirect" value="${allLoggedProcedures}"/>
</portlet:actionURL>

	<div class="modal fade omsb-modal" id="passModalCenter" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="confirm-section" /></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<aui:form action="${passProcedure}" name="passfm">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<aui:input id="traineeLoggedProcedureDetailsIdsForPass" name="traineeLoggedProcedureDetailsIdsForPass" value="" type="hidden" />
							<aui:input name="tab" value="" type="hidden" /> 
							<div class="form-group">
								<aui:input label="comment" rows="5" id="passComment" name="passComment" type="textarea" localized="true" cssClass="form-control">
									<aui:validator name="required" />
								</aui:input>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button" type="submit" title="Pass"><liferay-ui:message key="pass" /></button>
					<button type="button" class="btn omsb-btn omsb-bc-red-button" onclick="this.form.reset()"><liferay-ui:message key="discard" /></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" id="closeButton"><liferay-ui:message key="close" /></button>
				</div>
				</aui:form>
			</div>
		</div>
	</div>
	
<!-- Refuse Modal -->
<portlet:actionURL name="<%= OmsbViewProceduresSupervisorWebPortletKeys.REFUSE_PRODCEDURE %>" var="refuseProcedure">
	<portlet:param name="redirect" value="${allLoggedProcedures}"/>
</portlet:actionURL>

	<div class="modal fade omsb-modal" id="refuseModalCenter" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="confirm-section" /></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<aui:form action="${refuseProcedure}" name="refusefm">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<aui:input id="traineeLoggedProcedureDetailsIdsForRefuse" name="traineeLoggedProcedureDetailsIdsForRefuse" value="" type="hidden" />
							<aui:input name="tab" value="" type="hidden" />
							
							<div class="form-group">
								<aui:input label="comment" rows="5" id="refuseComment" name="refuseComment" type="textarea" localized="true" cssClass="form-control">
									<aui:validator name="required" />
									<aui:validator name="maxLength">5000</aui:validator>
								</aui:input>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button" type="submit" title="Refuse"><liferay-ui:message key="refuse" /></button>
					<button type="button" class="btn omsb-btn omsb-bc-red-button" onclick="this.form.reset()"><liferay-ui:message key="discard" /></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal"><liferay-ui:message key="close" /></button>
				</div>
				</aui:form>
			</div>
		</div>
	</div>

<!-- Not Pass Modal -->
<portlet:actionURL name="<%= OmsbViewProceduresSupervisorWebPortletKeys.NOT_PASS_PRODCEDURE %>" var="notPassProcedure">
	<portlet:param name="redirect" value="${allLoggedProcedures}"/>
</portlet:actionURL>

	<div class="modal fade omsb-modal" id="notPassModalCenter" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="confirm-section" /></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<aui:form action="${notPassProcedure}" name="`notpassfm">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<aui:input id="traineeLoggedProcedureDetailsIdsForNotPass" name="traineeLoggedProcedureDetailsIdsForNotPass" value="" type="hidden" />
							<aui:input name="tab" value="" type="hidden" />
							
							<div class="form-group">
								<aui:input label="comment" rows="5" id="notPassComment" name="notPassComment" type="textarea" localized="true" cssClass="form-control">
									<aui:validator name="required" />
									<aui:validator name="maxLength">5000</aui:validator>
								</aui:input>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button" type="submit" title="NotPass"><liferay-ui:message key="not-pass" /></button>
					<button type="button" class="btn omsb-btn omsb-bc-red-button" onclick="this.form.reset()"><liferay-ui:message key="discard" /></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal"><liferay-ui:message key="close" /></button>
				</div>
				</aui:form>
			</div>
		</div>
	</div>
