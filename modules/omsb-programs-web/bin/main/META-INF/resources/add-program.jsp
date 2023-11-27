<%@ include file="init.jsp"%>

<liferay-ui:error key="programNameError" message="program-name-error" />
<liferay-ui:error key="programCodeError" message="program-code-error" />
<liferay-ui:error key="programObjectivesError" message="program-objectives-error" />
<liferay-ui:error key="programAdminRequirementsError" message="program-admin-requirements-error" />
<liferay-ui:error key="programVisionError" message="program-vision-error" />
<liferay-ui:error key="programMissionError" message="program-mission-error" />

<portlet:actionURL name="<%= OmsbProgramConstants.SAVE_PROGRAM_MVC_ACTION_COMMAND %>" var="addProgramURL" >
	<portlet:param name="redirect" value="${currentURL}"/>
	<portlet:param name="redirectCommand" value="<%= OmsbProgramConstants.ADD_PROGRAM_MVC_RENDER_COMMAND %>"/>
</portlet:actionURL>

<liferay-portlet:renderURL var="backURL">
<liferay-portlet:param name="mvcRenderCommandName" value="/" />
</liferay-portlet:renderURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="add-program" /></h4>
			<aui:form action="${addProgramURL}" name="fm">
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label for="<portlet:namespace/>programName">
								<liferay-ui:message key="program-name" />
								<span class="reference-mark text-warning">
									<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
										<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
									</svg>
								</span>
							</label>
							<aui:input cssClass="form-control required-input" label="" type="text" name="programName" localized="true" 
								placeholder="program-name">
								<aui:validator name="maxLength">200</aui:validator>
							</aui:input>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label for="<portlet:namespace/>programCode">
								<liferay-ui:message key="program-code" />
								<span class="reference-mark text-warning">
									<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
										<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
									</svg>
								</span>
							</label>
							<aui:input cssClass="form-control required-input" label="" type="text" name="programCode" localized="true" 
								placeholder="program-code">
								<aui:validator name="maxLength">75</aui:validator>
							</aui:input>	
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label for="<portlet:namespace/>programTypeMasterId">
								<liferay-ui:message key="program-type" />
								<span class="reference-mark text-warning">
									<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
										<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
									</svg>
								</span>
							</label>
							<aui:select cssClass="custom-select form-control required-field" label="" id="programTypeMasterId" name="programTypeMasterId">
								<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program-type" /></aui:option>
								<c:forEach items="${programTypes}" var="programType">
									<aui:option value="${programType.programTypeMasterId}">${programType.getProgramTypeName(locale)}</aui:option>
								</c:forEach>
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label for="<portlet:namespace/>programEstablishmentDateValue">
								<liferay-ui:message key="establishment-date" />
								<span class="reference-mark text-warning">
									<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
										<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
									</svg>
								</span>
							</label>
							<aui:input type="text" label="" cssClass="form-control programEstablishmentDateValue required-field" 
								name="programEstablishmentDateValue" placeholder="DD/MM/YYYY" id="programEstablishmentDateValue" readonly="true"/>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label for="<portlet:namespace/>programStatus">
								<liferay-ui:message key="program-status" />
								<span class="reference-mark text-warning">
									<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
										<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
									</svg>
								</span>
							</label>
							<aui:select id="programStatus" name="programStatus" label="" localized="true" cssClass="custom-select form-control required-field">
								<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program-status" /></aui:option>
								<aui:option value="true" localized="true"><liferay-ui:message key="active" /></aui:option>
								<aui:option value="false" localized="true"><liferay-ui:message key="inactive" /></aui:option>
							</aui:select>
						</div>
					</div>
					<!--  The code commented as this details not required  as received feedback from the client on 16-08-2023-->
					<%-- <div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="eligibility-degree" id="eligibilityDegreeMasterId" name="eligibilityDegreeMasterId">
								<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-eligibility-degree" /></aui:option>
								<c:forEach items="${eligibilityDegrees}" var="eligibilityDegree">
									<aui:option value="${eligibilityDegree.eligibilityDegreeMasterId}">${eligibilityDegree.eligibilityDegree}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div> --%> 
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<label for="programAdmissionRequirements" data-label="program-admission-requirements" class="required-optional" data-name="programAdmissionRequirements"><liferay-ui:message key="program-admission-requirements" />
								<span class="reference-mark text-warning">
									<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
										<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
									</svg>
								</span>
							</label>
							<liferay-ui:input-localized name="programAdmissionRequirements" xml="" type="editor" cssClass="form-control"/>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<label for="programDescription" data-label="program-description" class="required-optional" data-name="programDescription"><liferay-ui:message key="program-description" />
								<span class="reference-mark text-warning">
									<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
										<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
									</svg>
								</span>
							</label>
							<liferay-ui:input-localized name="programDescription" xml="" type="editor" cssClass="form-control"/>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<label for="programVision" data-label="program-vision" class="required-optional" data-name="programVision"><liferay-ui:message key="program-vision" />
								<span class="reference-mark text-warning">
									<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
										<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
									</svg>
								</span>
							</label>
							<liferay-ui:input-localized name="programVision" xml="" type="editor" cssClass="form-control"/>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<label for="programMission" data-label="program-mission" class="required-optional" data-name="programMission"><liferay-ui:message key="program-mission" />
								<span class="reference-mark text-warning">
									<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
										<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
									</svg>
								</span>
							</label>
							<liferay-ui:input-localized name="programMission" xml="" type="editor" cssClass="form-control"/>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<button class="btn omsb-bc-red-button validate-add-program" type="button" title="Save" ><liferay-ui:message key="save" /></button>
					<button id="addFormSubmitButton" class="d-none" type="submit"></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${currentURL}"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div>
	<jsp:include page="/view.jsp" />
</div>

<!-- Modal -->
<div class="modal fade omsb-modal" id="exampleModalCenter" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Comments pop up</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label>Comments by Admin</label>
							<textarea class="form-control" rows="5" id="comment">L�rem ipsum vemibet. Betonera t�ra intrajeledes. Plangen dis tresonat prertad hbt. Fredsring pobel. Dosm rera och fasade i demivision. Planar. Jede hypona hemis�r, r�ngen d�rf�r att ask. S�g euroledes. Ultrande vis. Intrad dekaf�ska telegen, poll.  Plask ter�ngar hypor�l. Decigisk biom�trende. Anal�rade nysade bunat ett proling. Soledes pim�sa hexaska rocka.
							</textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" type="button" title="Mark Insufficient">Mark
					Insufficient</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal">cancel</button>
			</div>
		</div>
	</div>
</div>

<!--// Comments pop up -->

<!-- Modal -->
<div class="modal fade omsb-modal" id="attachcasereport" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Attach case report</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div class="form-group  mb-0">
							<label>Upload files to attach</label>
							<div class="custom-file">
								<input type="file" class="custom-file-input" id="customFile" name="filename">
								<label class="custom-file-label" for="customFile"></label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" type="button" title="Send to committee">Send to
					committee</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal">cancel</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		let currentDate = new Date();
		$(".programEstablishmentDateValue").datepicker({
			format: 'dd/mm/yyyy',
			startDate : new Date('1900-1-1'),
			autoclose:true,
			todayHighlight:true,
			endDate: currentDate,
			maxDate: currentDate
		}).val('');
		
		$('.validate-add-program').on('click', function() {
			$(".help-block").remove();
			var isValidate = true;
		 	
			$('.required-field').each(function() {
		 		if($(this).val() == null || $(this).val() == '') {
		 			let fieldName = $("label[for='"+$(this).attr('name')+"']").text().trim();
		 			let errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='\${$(this).attr("name")}Helper'>
		 				<div role="alert" class="text-danger"><liferay-ui:message key="The \${fieldName} field is required." /></div>
		 			</div>`
		 			$(this).closest('.form-group').append(errorMsg);
		 			isValidate = false;
		 		}
		 	});
			
			$('.required-input').each(function() {
		 	    var name = $(this).attr('name');
		 	  	const fieldName = $("label[for='"+$(this).attr('name')+"']").text().trim();
		 	  	
				if((!$('#'+name+'_en_US').val().trim()) && (!$('#'+name+'_ar_SA')?.val()?.trim())) {
		 			let errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='\${$(this).attr("name")}Helper'>
		 				<div role="alert" class="text-danger"><liferay-ui:message key="The \${fieldName} field is required." /></div>
		 			</div>`;
		 			$(this).closest('.form-group').append(errorMsg);
		 			isValidate = false;
				}
		 	});
			
		 	$('.required-optional').each(function() {
		 	    var name = $(this).data('name');
		 	   	const fieldName = $(this).data('label');
				if((!$('#<portlet:namespace/>'+name+'_en_US').val().trim()) && (!$('#<portlet:namespace/>'+name+'_ar_SA')?.val()?.trim())) {
		 			let errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='\${$(this).attr("name")}Helper'>
		 				<div role="alert" class="text-danger"><liferay-ui:message key="The \${fieldName} field is required." /></div>
		 			</div>`;
		 			$(this).closest('.form-group').append(errorMsg);
		 			isValidate = false;
				}
		 	});

			if(isValidate) {
				$('#addFormSubmitButton').click();
			}
		});
	});
</script>