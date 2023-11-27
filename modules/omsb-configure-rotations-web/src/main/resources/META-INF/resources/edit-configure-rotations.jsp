<%@ include file="init.jsp" %>

<liferay-ui:error key="duplicateRotation" message="same-rotation" />

<portlet:renderURL var="addConfigureRotationPageURL">
    <portlet:param name="mvcPath" value="<%=OmsbConfigureRotationsWebPortletKeys.ADD_CONFIGURE_ROTATIONS_JSP %>" />
</portlet:renderURL>

<portlet:actionURL name="<%=OmsbConfigureRotationsWebPortletKeys.EDIT_CONFIGURE_ROTATIONS_MVC_ACTION_COMMAND %>" var="updateConfigureRotationActionURL" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<aui:form action="${updateConfigureRotationActionURL}" name="fm">
<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<div class="omsb-page-top-info mb-4">
				<div class="pagetitle"><liferay-ui:message key="edit-configure-elective-and-core-rotation" /></div>
			</div>
			<div class="omsb-list-filter omsb-more-btn">
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-12">
						<div class="form-group">
						<aui:input id="programMasterId" name="programMasterId" value="${programMaster.getProgramMasterId()}" type="hidden" /> 
						<label class="label-name"><liferay-ui:message key="program" /></label>
						<label class="label-content">${programMaster.getProgramName(locale)}</label>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12">
						<div class="form-group">
						<aui:input id="programDuration" name="programDuration" value="${programDurationMaster.getProgDurationId()}" type="hidden" />
						<label class="label-name"><liferay-ui:message key="program-cohort" /></label>
						<label class="label-content">${programDurationMaster.getAyApplicableForm()}</label>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12">
						<div class="form-group">
						<aui:input id="traineeLevel" name="traineeLevel" value="${traineeLevelMaster.getTraineeLevelMasterId()}" type="hidden" />
						<label class="label-name"><liferay-ui:message key="trainee-level" /></label>
						<label class="label-content">${traineeLevelMaster.getTraineeLevelName(locale)}</label>
						</div>
					</div>
				</div>
			</div>
			<c:forEach items="${configureRotationLists}" var="configureRotationList" varStatus="theCount"> 
			<c:if test="${theCount.first}">
				<div id="mainDiv" class="omsb-card omsb-card-graybg omsb-BorderRadius-4 padding-cohort">
			</c:if>
		    <c:if test="${!theCount.first}">
		    	<div id="childDiv${theCount.index}" class="omsb-card omsb-card-graybg omsb-BorderRadius-4 padding-cohort">
			</c:if>
				<div class="omsb-list-filter pb-0">
					<div class="row">
						<div class="col-lg-4 col-md-6">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control" label="rotation" id="rotation${theCount.index}" name="rotation${theCount.index}" value="${configureRotationList.rotationId}">
								<c:forEach items="${rotationMasters}" var="rotation">
								<aui:option value="${rotation.rotationMasterId}">${rotation.getRotationName(locale)}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
								</aui:select>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control" label="rotation-type" id="rotationType${theCount.index}" name="rotationType${theCount.index}" value="${configureRotationList.rotationTypeId}">
								<c:forEach items="${rotationTypes}" var="rotationType">
									<aui:option value="${rotationType.rotationTypeMasterId}">${rotationType.getRotationTypeName(locale)}</aui:option>
								</c:forEach>
								<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation-type" /></aui:option>
								<aui:validator name="required" />
								</aui:select>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="form-group">
								<label><liferay-ui:message key="blocks" /></label>
							<input class="custom-select form-control" type="number" id="blocks${theCount.index}" value="${configureRotationList.noOfBlocks}" name="<portlet:namespace/>blocks${theCount.index}" min="0" step="1" required />
							</div>
						</div>

					</div>
					<div class="filter-button-wrap flex">
						<c:if test="${theCount.first}">
						<button class="btn omsb-bc-red-button" onClick="addBlock()">Add</button>
						<button class="btn omsb-bg-red-button">Discard</button>					    
						</c:if>
					    <c:if test="${!theCount.first}">
						<button class="btn omsb-bg-red-button" onClick="removeBlock(${theCount.index})">Discard</button>
					</c:if>
						
					</div>

				</div>
			</div>	
			</c:forEach>				
			<div class="bottom-backbtn-wrap mt-0 mb-5">
					<aui:input label="count" type="hidden" name="configureRotationCount" value="${totalrecord}" />
					<aui:input label="configure-master-rotation-id" name="configureRotationsMasterId" type="hidden" value="${configureRotations.progdurationRotationTlBlocksRelId}" class="form-control"  />
					<button class="btn omsb-bc-red-button" type="submit" title="Update" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${addConfigureRotationPageURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
			</div>
		</div>
	</div>
</aui:form>

<script type="text/javascript">
function addBlock() {
	var rotationCount = $("#<portlet:namespace/>configureRotationCount").val();
	var count = parseInt(rotationCount)+1;
	$("#<portlet:namespace/>configureRotationCount").val(count);
	var pohortCardDiv = `<div id="childDiv\${count}" class="omsb-card omsb-card-graybg omsb-BorderRadius-4 padding-cohort">
		<div class="omsb-list-filter pb-0">
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="form-group">
						<aui:select cssClass="custom-select form-control" label="rotation" id="rotation\${count}" name="rotation\${count}" >
						<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation" /></aui:option>
						<aui:validator name="required" />
						</aui:select>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group">
						<aui:select cssClass="custom-select form-control" label="rotation-type" id="rotationType\${count}" name="rotationType\${count}" >
						<c:forEach items="${rotationTypes}" var="rotationType">
							<aui:option value="${rotationType.rotationTypeMasterId}">${rotationType.getRotationTypeName(locale)}</aui:option>
						</c:forEach>
						<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation-type" /></aui:option>
						<aui:validator name="required" />
						</aui:select>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group">
						<label><liferay-ui:message key="blocks" /></label>
						<input class="custom-select form-control" type="number" id="blocks\${count}" name="<portlet:namespace/>blocks\${count}" min="0" step="1" required />
					</div>
				</div>

			</div>
			<div class="filter-button-wrap flex">
			<button class="btn omsb-bg-red-button" id="\${count}" onClick="removeBlock(this.id)"><liferay-ui:message key="discard" /></button>
			</div>

		</div>
	</div>`;
$("#mainDiv").after(pohortCardDiv);
$('#<portlet:namespace/>rotation0 option').clone().appendTo('#<portlet:namespace/>rotation'+count);

}

function removeBlock(id){
	$("#childDiv" + id ).remove();
}


