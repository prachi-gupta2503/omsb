<%@ include file="/init.jsp" %>

<portlet:actionURL name="<%= OmsbEligibilityDegreeWebPortletKeys.SAVE_ELIGIBILITY_DEGREE_MVC_ACTION_COMMAND %>" var="saveEligibilityDegree" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="add-eligibility-degree" /></h4>
			<aui:form action="${saveEligibilityDegree}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="eligibility-qualification" type="text" name="eligibilityQualification" localized="true" placeholder="enter-eligibility-qualification" ignoreRequestValue="true">
								<aui:validator name="required" />
								<aui:validator name="maxLength">200</aui:validator>
							</aui:input>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<button class="btn omsb-bc-red-button" type="submit" title="Save" ><liferay-ui:message key="save" /></button>
					<button class="btn omsb-bc-red-button" type="reset" title="Cancel" ><liferay-ui:message key="cancel" /></button>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div class="row">
	<jsp:include page="/eligibility-degree-list.jsp" />
</div>