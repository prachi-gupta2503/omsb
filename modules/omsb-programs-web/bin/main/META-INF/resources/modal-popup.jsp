<%@ include file="init.jsp" %>

<portlet:actionURL name="<%=OmsbProgramConstants.DELETE_PROGRAM_MVC_COMMAND_NAME%>" var="deleteProgram" />
<portlet:resourceURL  id="/delete/rotation-from-training-site" var="deleteRotationFromTrainingSite" />
<portlet:resourceURL  id="/save/assigned-training-sites-to-program-cohort" var="saveTrainingSitesToProgramCohort" />
<portlet:resourceURL id="/save/rotations-and-slots-to-training-site" var="saveRotationsAndSlotsToTrainingSite" />
<portlet:actionURL name="<%= OmsbProgramConstants.DELETE_TRAINEE_ELECTIVE_ROTATIONS_MVC_ACTION_COMMAND%>" var="deleteTraineeElectiveRotationsType">
	<portlet:param name="redirect" value="${currentURL}" />
</portlet:actionURL>


<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="confirmation" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<aui:form action="${deleteProgram}" name="passfm">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<aui:input id="programMasterId" name="programMasterId" value="" type="hidden" /> 
							<div>
								<p><liferay-ui:message key="are-you-sure-you-want-to-delete?" /></p>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button" type="submit" title="Confirm"><liferay-ui:message key="confirm" /></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal">cancel</button>
				</div>
			</aui:form>
		</div>
	</div>
</div>


<div class="modal fade" id="openDeleteModalForRotationProgram" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="confirmation" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div>
								<p> <liferay-ui:message key="are-you-sure-you-want-to-delete?" /> </p>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button" type="button" id="deleteRotationFromProgramModalSubmitButton" onclick="deleteRotationFromProgram(this)" title="Confirm"><liferay-ui:message key="confirm" /></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button" id="deleteRotationFromProgramModalCancelButton" data-dismiss="modal">cancel</button>
				</div>
		</div>
	</div>
</div>


<div class="modal fade" id="openDeleteModalForRotationTrainingSite" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="confirmation" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div>
								<p> <liferay-ui:message key="are-you-sure-you-want-to-delete?" /> </p>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button" type="button" id="deleteRotationFromTrainingSiteModelSubmitButton" onclick="deleteRotationFromTrainingSite(this,'${deleteRotationFromTrainingSite}')" title="Confirm"><liferay-ui:message key="confirm" /></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button" id="deleteRotationFromTrainingSiteModelCancelButton" data-dismiss="modal">cancel</button>
				</div>
		</div>
	</div>
</div>

<!-- Manage Training Site Modal  -->
<div class="modal fade omsb-modal" id="manage-training-sites" tabindex="-1" role="dialog" aria-labelledby="manage-training-sitesTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"> <liferay-ui:message key="manage-training-sites" /> </h5>
				<button type="button" class="btn omsb-btn omsb-bg-red-button" onClick="showAddTrainingSiteForm()"><img src="${themeDisplay.getPathThemeImages()}/svg/plus_img.svg" alt="add"> <liferay-ui:message key="new-training-site" /></button>
			</div>
			<div class="modal-body">
				<div name="my_elective" >
					<div class="omsb-list-filter omsb-more-btn">
						<div class="row elective-rotation-row">
							<div class="col-lg-6 col-md-6 col-sm-12 leftbar">
								<div class="form-group">
									<label> <liferay-ui:message key="all-training-sites" /> </label>
									<div class="elective_rotation_list_wrap" id="allTrainingSites">
									</div>
								</div>
							</div>

							<div class="col-lg-6 col-md-6 col-sm-12 rightbar">
								<div class="form-group">												
									<div class="elective_rotation_selected_list_items">
										<ul id="trainingSitesSortlist">							
										  </ul>
									</div>
								</div>
							</div>
						</div>
						<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 padding-cohort d-none" id ="addTrainingSiteForm">
							<aui:form action="#" name="add-training-site-fm">
							<div class="row">
								<div class="col-lg-6">
									<div class="form-group">
										<label for="<portlet:namespace/>trainingSiteName"><liferay-ui:message key="training-site-name" />
											<span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
										</label>
										<aui:input label="" name="trainingSiteName" type="text" localized="true" class="form-control" placeholder="enter-training-site-name">
										</aui:input>
										<div class="form-feedback-item text-danger d-none" id="training-site-name-error"></div>
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label for="<portlet:namespace/>trainingSiteAddress"><liferay-ui:message key="training-site-address" />
											<span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
										</label>
										<aui:input label="" name="trainingSiteAddress" type="text" localized="true" class="form-control" placeholder="enter-training-site-address">
											<aui:validator name="maxLength">5000</aui:validator>
										</aui:input>
										<div class="form-feedback-item text-danger d-none" id="training-site-address-error"></div>
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label for="<portlet:namespace/>trainingSiteCode"><liferay-ui:message key="training-site-code" />
											<span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
										</label>
										<aui:input label="" name="trainingSiteCode" type="text" localized="true" class="form-control" placeholder="enter-training-site-code">
											<aui:validator name="maxLength">200</aui:validator>
										</aui:input>
										<div class="form-feedback-item text-danger d-none" id="training-site-code-error"></div>
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label for="<portlet:namespace/>trainingSiteStatus"><liferay-ui:message key="training-site-status" />
											<span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
										</label>
										<aui:select id="trainingSiteStatus" name="trainingSiteStatus" label="" localized="true" class="custom-select form-control">
											<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-training-site-status" /></aui:option>
											<aui:option value="true"><liferay-ui:message key="active" /></aui:option>
											<aui:option value="false"><liferay-ui:message key="inactive" /></aui:option>
										</aui:select>
										<div class="form-feedback-item text-danger d-none" id="training-site-status-error"></div>
									</div>
								</div>
								<div class="col-lg-12">
									<div class="form-group">
										<label for="trainingSiteDescription"><liferay-ui:message key="training-site-description" />
											<span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
										</label>
										<liferay-ui:input-localized name="trainingSiteDescription" xml="" type="editor" class="form-control"/>
										<div class="form-feedback-item text-danger d-none" id="training-site-description-error"></div>
									</div>
								</div>
								<div class="col-lg-12">
									<div class="bottom-backbtn-wrap">
										<button class="btn omsb-bc-red-button" type="button" title="Add" onclick="addTrainingSite()" > <liferay-ui:message key="add" /></button>
										<button type="button" class="btn omsb-btn omsb-bg-red-button" onClick="hideTrainingSiteForm()"> <liferay-ui:message key="cancel" /> </button>
									</div>
								</div>
							</div>
							</aui:form>
						</div>
					</div>
					</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" type="button" title="Save" onclick="assignedTrainingSiteToProgramCohort('${saveTrainingSitesToProgramCohort}')"> <liferay-ui:message key="save" /> </button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" onClick="hideTrainingSiteForm()" id="cancel-manage-training-sites" > <liferay-ui:message key="cancel" /> </button>
			</div>
		</div>
	</div>
</div>

<!-- Configure Rotation Modal -->

<div class="modal fade omsb-modal" id="configure-rotation" tabindex="-1" role="dialog"
	aria-labelledby="configure-rotationTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="configure-rotation-title"> </h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="removeChildConfigureRotationDiv()">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
                      <div id="mainConfigureRotationDiv" class="omsb-card omsb-card-graybg omsb-noBorderRadius">
                          <div class="row">
                              <div class="col-lg-6">
                                  <div class="form-group">
                                    <label><liferay-ui:message key="rotations" />
                                    	<span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
                                    </label>
                                     <select class="form-control custom-select js-basic-single" id="rotation0" name="configureRotations" >
                                         <%-- <c:forEach items="${rotationMasterList}" var="rotation">
											<option value="${rotation.rotationMasterId}">${rotation.getRotationName(locale)}</option>
										</c:forEach> --%>
                                      </select>
                                      <div class="form-feedback-item text-danger d-none" id="rotationerror0"><liferay-ui:message key="duplicate-rotation-found" /></div>
                                  </div>
                              </div>
                              <div class="col-lg-6">
                                  <div class="form-group">
	                                  <label><liferay-ui:message key="slots" />
	                                  	 <span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
	                                  </label>
                                      <input type="number" class="form-control" value="" step="1" min="1"  id="slots0" name="configureRotationsSlots" />
                                      <div class="form-feedback-item text-danger d-none" id="rotationsloterror0"></div>
                                  </div>
                              </div>
                              <div class="col-lg-12">
                              	<div class="bottom-backbtn-wrap">
                                  <button class="btn omsb-bc-red-button" type="button" title="add" onClick="addBlock()"><liferay-ui:message key="add" /></button>
                                 </div>
                              </div>
                          </div>
                      </div>
			</div>
			<div class="modal-footer">
				<aui:input label="count" type="hidden" name="configureRotationCount"  value="0" />
				<button class="btn omsb-bc-red-button" type="button" title="Save" onClick="assignRotationsToSelectedTrainingSite()">Save</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" onclick="removeChildConfigureRotationDiv()" id="assignRotationsToSelectedTrainingSiteCancelButton">cancel</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade omsb-modal" id="configure-single-rotation" tabindex="-1" role="dialog" aria-labelledby="configure-rotationTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="configure-single-rotation-dialog-title"></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
                          <div class="col-lg-6">
                              <div class="form-group-view">
                                    <div class="label-name"><liferay-ui:message key="rotation" /></div>
									<div class="label-content" id="configure-single-rotation-name"></div>
                              </div>
                          </div>
                          <div class="col-lg-6">
                              <div class="form-group">
                                   <label><liferay-ui:message key="slots" />
                                  	 <span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
                                  </label>
                                   <input type="number" class="form-control" step="1" min="1" value="" id="configure-single-rotation-slots" />
                                   <div class="form-feedback-item text-danger d-none" id="configure-single-rotation-slots-error"></div>
                              </div>
                          </div>
                      </div>
			</div>
			<div class="modal-footer">
				<input type="hidden" class="form-control" value="" id="configure-single-rotation-progDurationRotationTsRelId" />
				<button class="btn omsb-bc-red-button" type="button" title="Save" onclick="updateSlotsToRotationAndTrainingSite()" > <liferay-ui:message key="update" /> </button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" id="cancelSlotsToRotationAndTrainingSite"> <liferay-ui:message key="cancel" /> </button>
			</div>
		</div>
	</div>
</div>

<!-- Assign Rotation Modal -->

<div class="modal fade omsb-modal" id="assign_rotation" tabindex="-1" role="dialog" aria-labelledby="assign_rotationTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="assign-rotation" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-3" id="isSharedRotationDiv">
						<div class="form-group">
							<label><liferay-ui:message key="is-shared-rotation" /></label>
							<select class="form-control custom-select" id="isSharedRotation">
                               <option value="true"><liferay-ui:message key="yes" /></option>
                               <option value="false" selected="selected"><liferay-ui:message key="no" /></option>
                             </select>
						</div>
					</div>
					<div class="col-md-3" id="programsDiv">
						<div class="form-group" >
							<label><liferay-ui:message key="programs" />
								<span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
							</label>
							<select class="form-control custom-select js-basic-single" id="sharedProgramMasterId" onchange="getProgramDurations(this.value);">
                             </select>
                             <div class="form-feedback-item text-danger d-none" id="sharedProgramMasterError"></div>
						</div>
					</div>
					<div class="col-md-3" id="programDurationsDiv">
						<div class="form-group" >
							<label><liferay-ui:message key="programs-durations" />
								<span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
							</label>
							<select class="form-control custom-select js-basic-single" id="sharedProgramDurationId">
                             <option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program-duration" /></option>
                             </select>
                             <div class="form-feedback-item text-danger d-none" id="sharedProgramDurationError"></div>
						</div>
					</div>
                     <div class="col-md-3" id="rotationsDiv">
						<div class="form-group">
							<label><liferay-ui:message key="rotations" />
								<span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
							</label>
							<select class="form-control custom-select js-basic-single" id="all-rotations">
                             </select>
                             <div class="form-feedback-item text-danger d-none" id="allRotationsError"></div>
						</div>
					</div>
				</div>
                 <h5 class="modalheading">Assign Residency </h5>
                 <div id="traineeLevelBlocksDiv" >
				 </div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" type="button" title="Save" value="0" id="saveAssingedRotationAndBlocksToProgramCohort" onclick="assignedRotationAndTraineeBlocksToProgramCohort(this,'Add')"><liferay-ui:message key="save" /></button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" id="saveAssingedRotationAndBlocksToProgramCohortCancel" onclick="clearPopups()"><liferay-ui:message key="cancel" /></button>
			</div>
		</div>
	</div>
</div>

<!-- Edit Assign Rotation Modal -->

<div class="modal fade omsb-modal" id="edit_assign_rotation" tabindex="-1" role="dialog" aria-labelledby="assign_rotationTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="editAssignRotationName"></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
                 <div id="traineeLevelBlocksDivForEdit" >
				 </div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" type="button" title="Save" value="0" id="updateAssingedRotationAndBlocksToProgramCohort" onclick="assignedRotationAndTraineeBlocksToProgramCohort(this,'Edit')"><liferay-ui:message key="update" /></button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" id="updateAssingedRotationAndBlocksToProgramCohortCancel" onclick="clearPopups()"><liferay-ui:message key="cancel" /></button>
			</div>
		</div>
	</div>
</div>

<!-- Success Popup -->

<div class="modal fade" id="successModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="success" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div>
								<p id="successMessage"></p>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" ><liferay-ui:message key="ok" /></button>
				</div>
		</div>
	</div>
</div>

<!-- Error Popup -->

<div class="modal fade" id="errorModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="error" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div>
								<p id="errorMessage"></p>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" ><liferay-ui:message key="ok" /></button>
				</div>
		</div>
	</div>
</div>


<!-- DELETE ELECTIVE ROTATION MODAL -->
<div class="modal fade" id="deleteElectiveRotationModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="confirmation" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<aui:form action="${deleteTraineeElectiveRotationsType}" name="deleteElectiveRotationFm">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 deleteElectiveRotationDetails">
							<aui:input id="electiverotationPriorityDetailsId" name="electiverotationPriorityDetailsId" value="" type="hidden" /> 
							<div>
								<p><liferay-ui:message key="are-you-sure-you-want-to-delete?" /></p>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button" type="submit" title="Confirm"><liferay-ui:message key="confirm" /></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal"><liferay-ui:message key="cancel" /></button>
				</div>
			</aui:form>
		</div>
	</div>
</div>
<script>

$(document).ready(function() {
	let selectedValue = $("#isSharedRotation").val();
	if (selectedValue == "true") {
		$("#programsDiv").show();
		$("#programDurationsDiv").show();
	} else {
		$("#programsDiv").hide();
		$("#programDurationsDiv").hide();
	}

	$("#isSharedRotation").click(function() {
		let selectedValue = $(this).val();
		if (selectedValue == "true") {
			$("#programsDiv").show();
			$("#programDurationsDiv").show();
		}

		if (selectedValue == "false") {
			$("#programsDiv").hide();
			$("#programDurationsDiv").hide();
		}
	})
	
	$(".js-basic-single").each(function() {
	    var elementId = $(this).attr("id");
	    $("#"+elementId).select2();
	});
})

function addBlock() {
	var rotationCount = $("#<portlet:namespace/>configureRotationCount").val();
	var count = parseInt(rotationCount)+1;
	$("#<portlet:namespace/>configureRotationCount").val(count);
	var rotationCardDiv = `<div id="childConfigureRotationDiv\${count}" class="omsb-card omsb-card-graybg omsb-noBorderRadius childConfigureRotationDiv">
		        <div class="row">
		        <div class="col-lg-6">
		            <div class="form-group">
		                <label>Rotation</label>
		                <select class="form-control custom-select" id="rotation\${count}" name="configureRotations" >
		                </select>
		                <div class="form-feedback-item text-danger d-none" id="rotationerror\${count}"><liferay-ui:message key="duplicate-rotation-found" /></div>
		            </div>
		        </div>
		        <div class="col-lg-6">
		            <div class="form-group">
			            <label><liferay-ui:message key="slots" />
	                     	 <span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
	                     </label>
	                     <input type="number" class="form-control" step="1" min="1" id="slots\${count}" name="configureRotationsSlots" />
	                    <div class="form-feedback-item text-danger d-none" id="rotationsloterror\${count}"></div>
		               <!-- <label>Slots</label>
		                <input type="text" class="form-control" value="" id="slots\${count}" name="configureRotationsSlots" /> -->
		            </div>
		        </div>
		        <div class="col-lg-12">
			        <div class="bottom-backbtn-wrap">
						<button class="btn omsb-bg-red-button" id="\${count}" onClick="removeBlock(this.id)"><liferay-ui:message key="discard" /></button>
					</div>
				</div>
		    </div>
		</div>`;
	$("#mainConfigureRotationDiv").after(rotationCardDiv);
	showConfigureRotationModal('rotation'+count);
	$("#rotation"+count).select2();
	
//$('#<portlet:namespace/>rotation0 option').clone().appendTo('#<portlet:namespace/>rotation');
}

function removeBlock(id){
	$("#childConfigureRotationDiv" + id ).remove();
}

function showAddTrainingSiteForm(){
	$('#addTrainingSiteForm').removeClass("d-none");
}

</script>
											
