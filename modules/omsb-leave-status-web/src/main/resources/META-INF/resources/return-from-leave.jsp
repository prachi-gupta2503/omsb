
<%@ include file="init.jsp" %>

<portlet:actionURL name="<%= OmsbLeaveStatusConstants.ADD_EDIT_RETURN_FROM_LEAVE_ACTION_COMMAND %>" var="editReturnFromLeaveActionURL" />

<portlet:renderURL var="backToPrevious">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<aui:form name="returnFromLeaveForm" action="${editReturnFromLeaveActionURL}" method="POST">
	<div class="omsb-card">
		<div class="omsb-page-top-info mb-3">
			<div class="pagetitle"><liferay-ui:message key="return.from.leave" /></div>
		</div>

		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
				<div class="form-group">
					<label class="label-name"><liferay-ui:message key="date.of.expected.return" /></label>
					<div class="label-content">${dateOFExpectedReturn}</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
				<div class="form-group">
					<aui:input name="dateOfReturn" class="form-control" id="dateOfReturn" type="text" label="date.of.return"
						value="${dateOfReturn}" placeholder="<%= OmsbLeaveStatusConstants.DD_MM_YYYY_PLACE_HOLDER %>" required="true" />
				</div>
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="form-group">
					<c:choose>
						<c:when test="${dateOfReturn > dateOFExpectedReturn}">
				      		<c:set var = "required" value = "true"/>
						</c:when>
						<c:otherwise>
							<c:set var = "required" value = "false"/>
						</c:otherwise>
					</c:choose>
					
					<aui:input name="reasonForDelay" class="form-control" placeholder="enter-reason-for-delay"
						 id="reasonForDelayTextArea" type="textarea" label="reason.for.delay"
						 value="${reasonForDelay}" localized="true" required="${required}" />
				</div>
			</div>
		</div>

		<div class="bottom-backbtn-wrap">
			
			<aui:input name="leaveMasterId" value="${leaveMasterId}" type="hidden" />

			<aui:button cssClass="btn omsb-bc-red-button" name="submitButton" type="submit" value="submit" ></aui:button>
			<a class="btn omsb-btn btn-back" href="${backToPrevious}">
			<i class="fi fi-sr-arrow-left"></i>
				<liferay-ui:message key="back" /></a>
		</div>
	</div>

</aui:form>

<script>
	$('#<portlet:namespace />dateOfReturn').datepicker({
		format : 'dd/mm/yyyy',
		autoclose : true
	});
</script>


