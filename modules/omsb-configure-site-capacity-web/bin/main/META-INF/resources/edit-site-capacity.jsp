<%@ include file="init.jsp" %>

<portlet:renderURL var="addSiteCapacityURL">
    <portlet:param name="mvcPath" value="<%=OmsbConfigureSiteCapacityWebPortletKeys.ADD_SITE_CAPACITY_JSP%>" />
</portlet:renderURL>

<portlet:actionURL name="<%= OmsbConfigureSiteCapacityWebPortletKeys.SAVE_SITE_CAPACITY_MVC_COMMAND_NAME %>" var="editSiteCapacity" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="edit-site-capacity" /></h4>
			<aui:form action="${editSiteCapacity}" name="fm">
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="select-program" id="selectProgram" name="selectProgram"  value="${editPrograms.programMasterId}" onChange="getCohort()">
								<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program" /></aui:option>
								<c:forEach items="${allprograms}" var="selectProgramList">
									<aui:option value="${selectProgramList.programMasterId}">${selectProgramList.getProgramName(locale)}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="cohort" id="cohort" name="cohort" value="${editCohort.progDurationId}" onChange="getTrainingSite()">
								<c:forEach items="${programDurationDetailList}" var="programDurationDetailListValue">
									<aui:option value="${programDurationDetailListValue.progDurationId}">${programDurationDetailListValue.ayApplicableForm}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="training-site" id="trainingSite" name="trainingSite" value="${editSiteCapacityDetails.trainingSitesId}" onChange="getRotation()">
								<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-training-site" /></aui:option>
								<c:forEach items="${allTrainingSites}" var="selectTrainingSites">
									<aui:option value="${selectTrainingSites.trainingSiteId}">${selectTrainingSites.trainingSiteName}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="rotation" id="rotation" name="rotation" value="${editSiteCapacityDetails.rotationId}">
								<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation" /></aui:option>
								<c:forEach items="${allRotations}" var="allRotationsList">
									<aui:option value="${allRotationsList.rotationMasterId}">${allRotationsList.rotationName}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:input label="no-of-slots"
								class="custom-select form-control" type="number"
								name="noOfSlots" min="1" step="1" max="" value="${editSiteCapacityDetails.noOfSlots}">
								<aui:validator name="required" />
							</aui:input>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<aui:input label="site-capacity-id" name="progdurationRotationTsRelId" type="hidden" value="${editSiteCapacityDetails.progdurationRotationTsRelId}" class="form-control"  />
					<button class="btn omsb-bc-red-button" type="submit" title="Update" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${addSiteCapacityURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div class="row">
	<jsp:include page="/site-capacity-table-listing.jsp" />
</div>
