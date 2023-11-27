<%@ include file="/init.jsp" %>

<portlet:renderURL var="addEligibilityDegreePageURL">
    <portlet:param name="mvcPath" value="<%=OmsbEligibilityDegreeWebPortletKeys.ADD_ELIGIBILITY_DEGREE_JSP %>" />
</portlet:renderURL>

<portlet:actionURL name="<%= OmsbEligibilityDegreeWebPortletKeys.SAVE_ELIGIBILITY_DEGREE_MVC_ACTION_COMMAND %>" var="saveEligibilityDegree" >
	<portlet:param name="redirect" value="${addEligibilityDegreePageURL}"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="edit-eligibility-degree" /></h4>
			<aui:form action="${saveEligibilityDegree}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="eligibility-qualification" type="text" name="eligibilityQualification" localized="true" value="${eligibilityDegree.eligibilityDegree}" placeholder="enter-eligibility-qualification">
								<aui:validator name="required" />
								<aui:validator name="maxLength">200</aui:validator>
							</aui:input>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<aui:input label="eligibility-degree-master-id" name="eligibilityDegreeMasterId" type="hidden" value="${eligibilityDegree.eligibilityDegreeMasterId}" class="form-control"  />
					<button class="btn omsb-bc-red-button" type="submit" title="Update" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${addEligibilityDegreePageURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div class="row">
	<jsp:include page="/eligibility-degree-list.jsp" />
</div>