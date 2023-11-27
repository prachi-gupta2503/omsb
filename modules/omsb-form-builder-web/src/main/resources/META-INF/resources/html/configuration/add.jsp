<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="../init.jsp" %>

<%
	String currentURL = PortalUtil.getCurrentURL(renderRequest);
	int incompleteStatus = WorkflowConstants.STATUS_INCOMPLETE;
	pageContext.setAttribute("incompleteStatus", incompleteStatus);
%>

<portlet:resourceURL id="<%=MVCCommandNames.SAVE_FORM_CONFIGURATION%>" var="saveFormConfigurationResourceURL" />

<portlet:resourceURL id="<%=MVCCommandNames.GET_FORM_DATA%>" var="getFormDataResourceURL" />

<portlet:renderURL var="previewFormURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
	<portlet:param name="previewFormMode" value="preview" />
	<portlet:param name="selectedFormDefinitionId" value="SELECTED_FORM_DEFINITION_ID"/>
</portlet:renderURL>

<div class="container" id="<portlet:namespace />dfFormContainer">
	<div class="row">
		<div class="col-md-12">
			<div class="omsb-card">
				<div class="progessiv-buttons-wrap">
					<button class="btn omsb-bc-red-button" id="<portlet:namespace />formReorderSaveChangesBtn" type="button" style="display:none; right: auto; left: 0;">
						<liferay-ui:message key="save-changes" />
					</button>
					<ul>
						<li>
							<button class="progress-button" type="button" id="<portlet:namespace />formBasicSectionBtn">
                            	<span><img src="<%= themeDisplay.getPathThemeImages() %>/svg/create-form.svg" alt="" /></span> 
                            	<liferay-ui:message key="form-basic-section" />
                            </button>
						</li>
						<li>
							<button class="progress-button" type="button" id="<portlet:namespace />formFieldBtn">
								<span><img src="<%= themeDisplay.getPathThemeImages() %>/svg/added-field.svg" alt="" /></span> 
								<liferay-ui:message key="form-field" />
							</button>
						</li>
						<li>
							<button class="progress-button" type="button" id="<portlet:namespace />formSubmitBtn"> 
								<span><img src="<%= themeDisplay.getPathThemeImages() %>/svg/submit-form.svg" alt="" /></span> 
								<liferay-ui:message key="form-submit" />
							</button>
						</li>
					</ul>

					<button class="btn omsb-bc-red-button" id="<portlet:namespace />formPreviewURLBtn" type="button">
						<liferay-ui:message key="form-preview-link" />
					</button>
				</div>					
			</div>
		</div>
	</div>
	






	<%-- <div class="row mt-2">
		<div class="col-lg-4 col-md-4 col-s-12 col-xs-12"></div>
		<div class="col-lg-8 col-md-8 col-s-12 col-xs-12">
			<div class="float-right">
				<button type="button" class="btn btn-info" id="<portlet:namespace />formReorderSaveChangesBtn" 
					style="display:none;">
					<liferay-ui:message key="save-changes" />
				</button>
				<button type="button" class="btn btn-primary" id="<portlet:namespace />formBasicSectionBtn">
					<liferay-ui:message key="form-basic-section" />
				</button>
				<button type="button" class="btn btn-primary" id="<portlet:namespace />formFieldBtn">
					<liferay-ui:message key="form-field" />
				</button>
				<button type="button" class="btn btn-primary" id="<portlet:namespace />formSubmitBtn">
					<liferay-ui:message key="form-submit" />
				</button>
				<button type="button" class="btn btn-primary" id="<portlet:namespace />formPreviewURLBtn">
					<liferay-ui:message key="form-preview-link" />
				</button>
				<button type="button" class="btn btn-primary hide" id="<portlet:namespace />postAndPrepopulateFieldsDataBtn">
					<liferay-ui:message key="post-prepopulate-fields-data" />
				</button>
			</div>
		</div>
	</div> --%>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 mt-2 pl-0 pr-0">
			<table id="<portlet:namespace />dfFormDataTable" class="display dataTable" style="width:100%">
				<thead class="table-columns">
					<tr align="center">
						<th><liferay-ui:message key="sr-no" /></th>
						<th><liferay-ui:message key="field-label" /></th>
						<th><liferay-ui:message key="field-key" /></th>
						<th><liferay-ui:message key="field-type" /></th>
						<th><liferay-ui:message key="field-status" /></th>
						<th><liferay-ui:message key="disabled" /></th>
						<th><liferay-ui:message key="required" /></th>
						<th><liferay-ui:message key="readonly" /></th>
						<th><liferay-ui:message key="action" /></th>
					</tr>
				</thead>
				<tbody id="<portlet:namespace />dfFormDataTableBody">
				</tbody>
		  	</table>
		</div>
	</div>
	<div id="<portlet:namespace />dfLoaderContainer" class="df-process-loader loading-animation" style="display:none;"></div>
    <div class="alert-notifications alert-notifications-fixed d-none" id="<portlet:namespace />successAlert">
        <div class="lfr-tooltip-scope">
            <div class="mb-3 alert alert-dismissible alert-success">
                <div role="alert" class="alert-autofit-row autofit-row">
                    <div class="autofit-col">
                        <div class="autofit-section">
                            <span class="alert-indicator">
                                <svg class="lexicon-icon lexicon-icon-check-circle-full" role="presentation">
                                    <use xlink:href="http://localhost:8080/o/admin-theme/images/clay/icons.svg#check-circle-full"></use>
                                </svg>
                            </span>
                        </div>
                    </div>
                    <div class="autofit-col autofit-col-expand">
                        <div class="autofit-section">
                            <div>
                                <strong class="lead">Success:</strong>Your request completed successfully.
                            </div>
                        </div>
                    </div>
                </div>
                <button aria-label="Close" id="<portlet:namespace />alertCloseBtn" class="close" type="button">
                    <svg class="lexicon-icon lexicon-icon-times" role="presentation">
                        <use xlink:href="http://localhost:8080/o/admin-theme/images/clay/icons.svg#times"></use>
                    </svg>
                </button>
            </div>
        </div>
     	</div>
</div>

<!-- Button to Open the Modal -->

<button type="button" hidden="true" class="btn omsb-bg-red-button mb-5" data-toggle="modal" data-target="#permission" id="<portlet:namespace />openPermissionModal">
  Open modal
</button>

<div class="modal" id="permission" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Role Permission</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<input type="hidden" id="<portlet:namespace />permissionFieldId" name="<portlet:namespace />permissionFieldId" value="">
			</div>
			<div class="modal-body">
				<div class="table-responsive permissionTable">
					<table class="table table-hover">
						<thead>
							<tr>
								<th></th>
								<th>Add</th>
								<th>Edit</th>
								<th>View</th>
							</tr>
						</thead>
						<tbody id="permissionTableBody">
							

						</tbody>
					</table>
				</div>
			</div>
			<div class="modal-footer">
		    	<button type="button" class="btn btn-danger" id='<portlet:namespace />saveRolePermission'>Save</button>
		    	<button type="button" class="btn btn-danger" data-dismiss="modal" id='<portlet:namespace />rolePermissionCloseBtn'>Close</button>
		    </div>
		</div>
	</div>
</div>

<input type="hidden" id="<portlet:namespace />formEncryptedData" name="<portlet:namespace />formEncryptedData" value="">
<input type="hidden" id="<portlet:namespace />formDefinitionId" name="<portlet:namespace />formDefinitionId" value="${formDefinitionId}">
<input type="hidden" id="<portlet:namespace />formDefinitionWorkflowStatus" name="<portlet:namespace />formDefinitionWorkflowStatus" value="${formDefinitionWorkflowStatus}">

<!-- Form Basic Section Popup -->
 <div class="modal fade" id="<portlet:namespace />formBasicSectionModal" aria-hidden="true" aria-labelledby="formBasicSectionModal" tabindex="-1" role="dialog"  
 	aria-hidden="true" style="display: none;" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-xl form-basic-section-modal-dialog form-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><liferay-ui:message key="form-basic-section" /></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body form-basic-section-modal-body" id="<portlet:namespace />formBasicSectionModalBody">
      	<div class="mb-3 alert alert-dismissible alert-danger d-none" id="<portlet:namespace />formBasicErr">
			<div role="alert" class="alert-autofit-row autofit-row">
				<div class="autofit-col">
					<div class="autofit-section">
						<span class="alert-indicator">
	       					<liferay-ui:icon icon="exclamation-full" markupView="lexicon"/>
	       				</span>
					</div>
				</div>
				<div class="autofit-col autofit-col-expand">
					<div class="autofit-section">
						<div class="errorBasicAlert" id="<portlet:namespace />errorBasicAlert">
							<strong>Error:</strong>Please enter a valid title for the default language: en-US.
						</div>
					</div>
				</div>
			</div>
		</div>
      	<form name="<portlet:namespace />formBasicSection" 
      		id="<portlet:namespace />formBasicSection"  method="post" action="${saveFormBasicSectionResourceURL}">
      		<input type="hidden" id="<portlet:namespace />formNamesData" name="<portlet:namespace />formNamesData">	
		</form>
      </div>
      <div class="modal-footer" id="<portlet:namespace />formBasicSectionModalFooter">
      	 <c:choose>  
	        <c:when test="${formDefinitionWorkflowStatus == incompleteStatus}">  
        		<button type="button" class="btn btn-secondary" id="<portlet:namespace />formBasicSectionSaveBtn"><span id="<portlet:namespace />formBasicSectionSaveBtnSpan"><liferay-ui:message key="resubmit" /></span></button>  
	    	</c:when>   
	        <c:otherwise>  
        		<button type="button" class="btn btn-secondary" id="<portlet:namespace />formBasicSectionSaveBtn"><span id="<portlet:namespace />formBasicSectionSaveBtnSpan"><liferay-ui:message key="save" /></span></button>  
	        </c:otherwise>  
		</c:choose> 
      	<button type="button" class="btn btn-secondary" id="<portlet:namespace />formBasicSectionResetBtn"><liferay-ui:message key="reset" /></button>
      </div>
    </div>
  </div>
</div>

<!--Form Fields Popup -->
<div class="modal fade" id="<portlet:namespace />formFieldModal" aria-hidden="true" aria-hidden="true" aria-labelledby="formFieldModal" tabindex="-1" role="dialog"  
 	aria-hidden="true" style="display: none;" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-xl form-field-modal-dialog form-dialog " role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><liferay-ui:message key="form-field" /></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body form-field-modal-body" id="<portlet:namespace />formFieldModalBody">
	      <%-- <div class="d-none formLoadErr" id="<portlet:namespace />formFieldErr"></div> --%>
	      <div class="mb-3 alert alert-dismissible alert-danger d-none formLoadErr" id="<portlet:namespace />formFieldErr">
			<div role="alert" class="alert-autofit-row autofit-row">
				<div class="autofit-col">
					<div class="autofit-section">
						<span class="alert-indicator">
	       					<liferay-ui:icon icon="exclamation-full" markupView="lexicon"/>
	       				</span>
					</div>
				</div>
				<div class="autofit-col autofit-col-expand">
					<div class="autofit-section">
						<div class="errorAlert" id="<portlet:namespace />errorAlert">
							<strong class="lead">Error:</strong>Please enter a valid title for the default language: en-US.
						</div>
					</div>
				</div>
			</div>
			<button aria-label="Close" class="close" id="<portlet:namespace />errorAlertCloseBtn" type="button">
				<svg class="lexicon-icon lexicon-icon-times" role="presentation">
					<use xlink:href="http://localhost:8080/o/admin-theme/images/clay/icons.svg#times"></use>
				</svg>
			</button>
		  </div>
	      <div class="d-none formLoadErr" id="<portlet:namespace />formFieldErr"></div>
	      <input type="hidden" id="<portlet:namespace />columnNamesData" name="<portlet:namespace />columnNamesData">
	      <form name="<portlet:namespace />formField" id="<portlet:namespace />formField" method="post" action="${saveFormField}">
		  </form>
      </div>
      <div class="modal-footer" id="<portlet:namespace />formFieldModalFooter">
        <button type="button" class="btn btn-primary" id="<portlet:namespace />formFieldSaveBtn"><liferay-ui:message key="save" /></button>
      	<button type="button" class="btn btn-secondary" id="<portlet:namespace />formFieldResetBtn"><liferay-ui:message key="reset" /></button>
      </div>
    </div>
  </div>
</div>

<!--post/prepopulate data -->
<div class="modal fade" id="<portlet:namespace />postAndPrepopulateFieldsDataModal" aria-hidden="true" aria-hidden="true" aria-labelledby="postAndPrepopulateFieldsDataModal" tabindex="-1" role="dialog"  
 	aria-hidden="true" style="display: none;" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-xl post-and-prepopulate-fields-data-modal-dialog form-dialog " role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><liferay-ui:message key="post-prepopulate-fields-data" /></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body post-and-prepopulate-fields-data-modal-body" id="<portlet:namespace />postAndPrepopulateFieldsDataModalBody">
      </div>
      <div class="modal-footer" id="<portlet:namespace />postAndPrepopulateFieldsDataModalFooter">
      </div>
    </div>
  </div>
</div>

<!--Select Form Version Popup-->
<div class="modal fade" id="<portlet:namespace />formVersionModal" aria-hidden="true" aria-hidden="true" aria-labelledby="formVersionModal" tabindex="-1" role="dialog"  
 	aria-hidden="true" style="display: none;" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-xl form-field-modal-dialog form-dialog " role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><liferay-ui:message key="form-version" /></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="<portlet:namespace />formVersionModalBody">
          <input type="hidden" id="<portlet:namespace />isFieldEdit" name="<portlet:namespace />isFieldEdit" />
          <input type="hidden" id="<portlet:namespace />fieldEditSrNo" name="<portlet:namespace />fieldEditSrNo" />
          <input type="hidden" id="<portlet:namespace />isFieldDelete" name="<portlet:namespace />isFieldDelete" />
          <input type="hidden" id="<portlet:namespace />fieldDeleteSrNo" name="<portlet:namespace />fieldDeleteSrNo" />    
          <form name="<portlet:namespace />formVersion" id="<portlet:namespace />formVersion" method="post">
          </form>
      </div>
      <div class="modal-footer" id="<portlet:namespace />formVersionModalFooter">
        <button type="button" class="btn btn-primary" id="<portlet:namespace />formVersionSaveBtn"><liferay-ui:message key="save" /></button>
      </div>
    </div>
  </div>
</div>


<div class="modal fade" id="<portlet:namespace />formFieldConfirmationModal" aria-hidden="true" aria-hidden="true" aria-labelledby="formVersionModal" tabindex="-1" role="dialog"  
 	aria-hidden="true" style="display: none;" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-xl form-field-modal-dialog form-dialog " role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><liferay-ui:message key="confirmation-popup-heading"/></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <liferay-ui:message key="confirmation-popup-data"/>
      </div>
      <div class="modal-footer" id="<portlet:namespace />formFieldConfirmationModalFooter">
        <button type="button" class="btn btn-primary" id="<portlet:namespace />formFieldConfirmationYesBtn"><liferay-ui:message key="yes" /></button>
        <button type="button" class="btn btn-primary" id="<portlet:namespace />formFieldConfirmationNoBtn"><liferay-ui:message key="no" /></button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="<portlet:namespace />formSubmitConfirmationModal" aria-hidden="true" aria-hidden="true" aria-labelledby="formVersionModal" tabindex="-1" role="dialog"  
 	aria-hidden="true" style="display: none;" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-xl form-field-modal-dialog form-dialog " role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><liferay-ui:message key="confirmation-popup-heading"/></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <liferay-ui:message key="confirmation-submit-popup-data"/>
      </div>
      <div class="modal-footer" id="<portlet:namespace />formSubmitConfirmationModalFooter">
        <button type="button" class="btn btn-primary" id="<portlet:namespace />formSubmitConfirmationYesBtn"><liferay-ui:message key="yes" /></button>
        <button type="button" class="btn btn-primary" id="<portlet:namespace />formSubmitConfirmationNoBtn"><liferay-ui:message key="no" /></button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="<portlet:namespace />formBasicSectionConfirmationModal" aria-hidden="true" aria-hidden="true" aria-labelledby="formVersionModal" tabindex="-1" role="dialog"  
 	aria-hidden="true" style="display: none;" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-xl form-field-modal-dialog form-dialog " role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><liferay-ui:message key="confirmation-popup-heading"/></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <liferay-ui:message key="confirmation-basic-section-popup-data"/>
      </div>
      <div class="modal-footer" id="<portlet:namespace />formBasicSectionConfirmationModalFooter">
        <button type="button" class="btn btn-primary" id="<portlet:namespace />formBasicSectionConfirmationYesBtn"><liferay-ui:message key="yes" /></button>
        <button type="button" class="btn btn-primary" id="<portlet:namespace />formBasicSectionConfirmationNoBtn"><liferay-ui:message key="no" /></button>
      </div>
    </div>
  </div>
</div>

<!-- Form Field Reset Confirmation Popup -->
<div class="modal fade" id="<portlet:namespace />formFieldResetBtnConfirmationModal" aria-hidden="true" aria-hidden="true" aria-labelledby="formVersionModal" tabindex="-1" role="dialog"  
 	aria-hidden="true" style="display: none;" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-xl form-field-modal-dialog form-dialog " role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><liferay-ui:message key="confirmation-popup-heading"/></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <liferay-ui:message key="reset-confirmation-popup-data"/>
      </div>
      <div class="modal-footer" id="<portlet:namespace />formFieldResetBtnConfirmationModalFooter">
        <button type="button" class="btn btn-primary" id="<portlet:namespace />formFieldResetBtnConfirmationYesBtn"><liferay-ui:message key="yes" /></button>
        <button type="button" class="btn btn-primary" id="<portlet:namespace />formFieldResetBtnConfirmationNoBtn"><liferay-ui:message key="no" /></button>
      </div>
    </div>
  </div>
</div>



<!--Delete Form Field Popup -->
<div class="modal fade" id="<portlet:namespace />deleteFormFieldModal" aria-hidden="true" aria-labelledby="<portlet:namespace />deleteFormFieldModalLabel"   
 	tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" style="display: none;">
  <div class="modal-dialog modal-xl form-field-modal-dialog form-dialog " role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="<portlet:namespace />deleteFormFieldModalLabel"><liferay-ui:message key="delete-form-field" /></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="<portlet:namespace />deleteFormFieldModalBody">
	      <form name="<portlet:namespace />deleteFormField" id="<portlet:namespace />deleteFormField" method="post">
		  </form>
      </div>
      <div class="modal-footer justify-content-center" id="<portlet:namespace />deleteFormFieldModalFooter">
        <button type="button" class="btn btn-primary" id="<portlet:namespace />deleteFormFieldModalSaveBtn"><liferay-ui:message key="yes" /></button>		
		<button type="button" class="btn btn-secondary" data-dismiss="modal" id="<portlet:namespace />deleteFormFieldModalCancelBtn"><liferay-ui:message key="no" /></button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="<portlet:namespace />reOrderConfirmModal" aria-hidden="true" aria-labelledby="<portlet:namespace />reOrderConfirmModalLabel" 
	tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" style="display: none;">
  <div class="modal-dialog modal-xl form-field-modal-dialog form-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="<portlet:namespace />reOrderConfirmModalLabel"><liferay-ui:message key="reorder-fields" /></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="<portlet:namespace />reOrderConfirmModalBody">
	      <liferay-ui:message key="reorder-fields-confirm-mssg" />
      </div>
      <div class="modal-footer justify-content-center" id="<portlet:namespace />reOrderConfirmModalFooter">
        <button type="button" class="btn btn-primary" id="<portlet:namespace />reOrderConfirmModalSaveBtn"><liferay-ui:message key="yes" /></button>		
		<button type="button" class="btn btn-secondary" id="<portlet:namespace />reOrderConfirmModalCancelBtn"><liferay-ui:message key="no" /></button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
 $(document).ready(function () {
	var rangeOptionData = '${rangeOptionData}';
	var config = new Object({}),
	    namespace = '<portlet:namespace />',
		contextPath = '<%= request.getContextPath()%>',
		themeImagesPath = '<%= themeDisplay.getPathThemeImages()%>',
		secretPassphrase = '${secretPassphrase}',
		saveFormConfigurationResourceURL = '${saveFormConfigurationResourceURL}',
		getFormDataResourceURL = '${getFormDataResourceURL}',
		workflowDefinitionArr = '${workflowDefinitions}' ? encodeURI('${workflowDefinitions}') : "",
		formJEl = '#' + namespace + 'dfForm',
		formContainerJEl = '#' + namespace + 'dfFormContainer',
		formDataTableJEl = '#' + namespace + 'dfFormDataTable',
		formCardHeaderJEl = '#' + namespace + 'dfFormCardHeader',
		formCardBodyJEl = '#' + namespace + 'dfFormCardBody',
		formCardBodyLoadingRowJEl = '#' + namespace + 'dfFormCardBodyLoadingRow',
		formCardBodyLoadingJEl = '#' + namespace + 'dfFormCardBodyLoading',
		formBasicSectionModalBodyJEl = '#' + namespace + 'formBasicSectionModalBody',
		formBasicSectionErrAlertJEl = '#' + namespace + 'formBasicErr',
		formBasicSectionErrMsgJEl = '#' + namespace + 'errorBasicAlert',
		formBasicSectionModalFooterJEl = '#' + namespace + 'formBasicSectionModalFooter',
		formBasicSectionBtnJEl = '#' + namespace + 'formBasicSectionBtn',
		formFieldModalBodyJEl = '#' + namespace + 'formFieldModalBody',
		formFieldModalFooterJEl = '#' + namespace + 'formFieldModalFooter',
		formFieldBtnJEl = '#' + namespace + 'formFieldBtn',
		formSubmitBtnJEl = '#' + namespace + 'formSubmitBtn',
		formFieldConfirmationModal = '#' + namespace + 'formFieldConfirmationModal',
		formFieldConfirmationYesBtn = '#' + namespace + 'formFieldConfirmationYesBtn',
		formFieldConfirmationNoBtn = '#' + namespace + 'formFieldConfirmationNoBtn',
		formSubmitConfirmationModal = '#' + namespace + 'formSubmitConfirmationModal',
		formSubmitConfirmationYesBtn = '#' + namespace + 'formSubmitConfirmationYesBtn',
		formSubmitConfirmationNoBtn = '#' + namespace + 'formSubmitConfirmationNoBtn',
		formBasicSectionConfirmationModal = '#' + namespace + 'formBasicSectionConfirmationModal',
		formBasicSectionConfirmationYesBtn = '#' + namespace + 'formBasicSectionConfirmationYesBtn',
		formBasicSectionConfirmationNoBtn = '#' + namespace + 'formBasicSectionConfirmationNoBtn',
		formFieldResetBtnConfirmationModal = '#' + namespace + 'formFieldResetBtnConfirmationModal',
		formFieldResetBtnConfirmationYesBtn = '#' + namespace + 'formFieldResetBtnConfirmationYesBtn',
		formFieldResetBtnConfirmationNoBtn = '#' + namespace + 'formFieldResetBtnConfirmationNoBtn',
		formPostAndPrepopulateFieldsDataModalJEl = '#' + namespace + 'postAndPrepopulateFieldsDataModal',
		formPostAndPrepopulateFieldsDataModalBodyJEl = '#' + namespace + 'postAndPrepopulateFieldsDataModalBody',
		formPostAndPrepopulateFieldsDataModalFooterJEl = '#' + namespace + 'postAndPrepopulateFieldsDataModalFooter',
		formPostAndPrepopulateFieldsDataBtnJEl = '#' + namespace + 'postAndPrepopulateFieldsDataBtn',
        formBasicSectionSuccessAlertJEl = '#' + namespace + 'successAlert',
        formBasicSectionAlertCloseBtnJEl = '#' + namespace + 'alertCloseBtn',
		formLayoutName =  namespace + 'formLayout',
		fieldDisplayPlaceholderJEl = '#' + namespace + 'displayPlaceholder',
		fieldDisplayHTMLEditorJEl = '#' + namespace + 'displayHTMLEditor',
		fieldDisplayFormatPlaceholderJEl = '#' + namespace + 'displayFormatPlaceholder',
		fieldDisplayMinNumberPlaceholderJEl = '#' + namespace + 'displayMinNumberPlaceholder',
		fieldDisplayMaxNumberPlaceholderJEl = '#' + namespace + 'displayMaxNumberPlaceholder',
		fieldDisplayMultipleFileUploadJEl = '#' + namespace + 'displayMultipleFileUpload',
		fieldDisplayFileExtensionsInputTagJEl = '#' + namespace + 'displayFileExtensionsInputTag',
		fieldDisplayMinBoundaryJEl = '#' + namespace + 'displayMinBoundary',
		fieldDisplayMaxBoundaryJEl = '#' + namespace + 'displayMaxBoundary',
		fieldDisplayRangeOptionsJEl = '#' + namespace + 'displayRangeOptions',
		fieldDisplayAverageJEl = '#' + namespace + 'displayAverage',
		fieldDisplayTotalJEl = '#' + namespace + 'displayTotal',
		fieldDisplayRangeCommentJEl = '#' + namespace + 'displayRangeComment',
		fieldDisplayRangeTotalCharacterJEl = '#' + namespace + 'displayRangeTotalCharacter';
		fieldDisplayValuesInputTagJEl = '#' + namespace + 'displayValuesInputTag',
		fieldDisplayCheckboxRadioJSGridJEl = '#' + namespace + 'displayCheckboxRadioJSGrid',
		fieldDisplayDropdownStaticJSGridJEl = '#' + namespace + 'displayDropdownStaticJSGrid',
		fieldDisplayRangeJSGridJEl = '#' + namespace + 'displayRangeJSGrid',
		fieldDisplayDefaultSelectedJEl = '#' + namespace + 'displayDefaultSelected',
		fieldDisplayDropdownConfigCheckboxJEl = '#' + namespace + 'displayDropdownConfigCheckbox',
		fieldDisplayWhereToPopulateDropdownJEl = '#' + namespace + 'displayWhereToPopulateDropdown',
		fieldDisplayMasterTableRadioJEl = '#' + namespace + 'displayMasterTableRadio',
		fieldCreateMasterTableJEl = namespace + 'createMasterTable',
		fieldTogglePostDataFieldJEl = '#' + namespace + 'togglePostDataField',
		fieldDisplayVisibleOnSelectedDropdownJEl = '#' + namespace + 'displayVisibleOnSelectedDropdown',
		fieldToggleVisibleOnFieldJEl = '#' + namespace + 'toggleVisibleOnField',
		fieldTogglePopulateDataFieldJEl = '#' + namespace + 'togglePopulateDataField',
        fieldToggleVisibleOnDropdownFieldJEl = '#' + namespace + 'toggleVisibleOnDropdownField',
		fieldToggleReadFromReqParamFieldJEl = '#' + namespace + 'toggleReadFromReqParamField',
		fieldDataProviderRowJEl = '#' + namespace + 'dataProviderRow',
		fieldDisplayDataProviderURLJEl = '#' + namespace + 'displayDataProviderURL',
		fieldDisplayMethodTypesJEl = '#' + namespace + 'displayMethodTypes',
		fieldDisplayContentTypesJEl = '#' + namespace + 'displayContentTypes',
		fieldDisplayDataProviderURLPropertyJEl = '#' + namespace + 'displayDataProviderURLProperty',
		fieldDisplayDataPropsJEl = '#' + namespace + 'displayDataProps',
		fieldDisplaySourcePropsJEl = '#' + namespace + 'displaySourceProps',
		fieldStaticValuesRowJEl = '#' + namespace + 'staticValuesRow',
		fieldDisplayStaticValuesInputTagJEl = '#' + namespace + 'displayStaticValuesInputTag',
		fieldDependentFieldsRowJEl = '#' + namespace + 'dependentFieldsRow',
		fieldDisplayDependentFieldsNameDropdownJEl = '#' + namespace + 'displayDependentFieldsNameDropdown',
		fieldDisplayWhereToPopulateDependentFieldsJEl = '#' + namespace + 'displayWhereToPopulateDependentFields',
		fieldMasterTableRowJEl = '#' + namespace + 'masterTableRow',
		fieldMasterTableJEl = '#' + namespace + 'masterTable',
		fieldMasterTableTextColumnJEl = '#' + namespace + 'masterTableTextColumn',
		fieldMasterTableValueColumnJEl = '#' + namespace + 'masterTableValueColumn',
		fieldMasterTableColumnDropdownJEl = '#' + namespace + 'masterTableColumnDropdown',
		fieldMasterTableDropdownJEl = '#' + namespace + 'masterTableDropdown',
		fieldDisplayVisibleOnJEl = '#' + namespace + 'displayVisibleOn',
		fieldRangeOptionsConfigRowJEl = '#' + namespace + 'rangeOptionsConfigRow',
		fieldDisplayRangeOptionsConfigJEl = '#' + namespace + 'displayRangeOptionsConfig',
		fieldFileExtensionsInputTagJEl = '#' + namespace + 'fileExtensionsInputTag',
		fieldRangeOptionsJEl =  '#' + namespace + 'rangeOptions',
		formFieldConfigRowSettingsAccordianJEl = '#' + namespace + 'formFieldConfigRowSettingsAccordianBody',
		fieldRangeOptionsConfigTableJEl = '#' + namespace + 'rangOptionsConfigTable',
		fieldMultiselectDropdownCheckboxJEl = '#' + namespace + 'multiselectDropdownCheckbox',
		fieldSearchableDropdownCheckboxJEl = '#' + namespace + 'searchableDropdownCheckbox',
		fieldWhereToPopulateDropdownJEl = '#' + namespace + 'whereToPopulateDropdown',
		fieldStaticValuesInputTagJEl = '#' + namespace + 'staticValuesInputTag',
		fieldDFStaticValuesJSGridJEl = '#' + namespace + 'dfStaticValuesJSGrid_',
		fieldDisplayDFStaticValuesInputTagJEl = '#' + namespace + 'displayDFStaticValuesJSGrid_',
		fieldDependentFieldsNameJEl = '#' + namespace + 'dependentFieldsName',
		fieldWhereToPopulateDependentFieldsJEl = '#' + namespace + 'whereToPopulateDependentFields',
		fieldDataProviderURLJEl = '#' + namespace + 'dataProviderURL',
		fieldMethodTypesJEl = '#' + namespace + 'methodTypes',
		fieldContentTypesJEl = '#' + namespace + 'contentTypes',
		fieldDataPropsJEl = '#' + namespace + 'dataProps',
		fieldSourcePropsJEl = '#' + namespace + 'sourceProps',
		fieldDataProviderURLPropertyJEl = '#' + namespace + 'dataProviderURLProperty',
		addFormFieldRowButtonJEl = '#' + namespace + 'addFormFieldRow',
		deleteFormFieldRowButtonJEl = '#' + namespace + 'deleteFormFieldRow',
		formPostDataURLJEl = '#' + namespace + 'postDataURL',
		formPostDataContentTypeJEl = '#' + namespace + 'postDataContentType',
		formPostDataAcceptJEl = '#' + namespace + 'postDataAccept',
		formPostDataHeadersJEl = '#' + namespace + 'postDataHeaders',
		formPostDataParamsJEl = '#' + namespace + 'postDataParams',
		formPrepopulateDataURLJEl = '#' + namespace + 'prepopulateDataURL',
		formPrepopulateDataContentTypeJEl = '#' + namespace + 'prepopulateDataContentType',
		formPrepopulateDataAcceptJEl = '#' + namespace + 'prepopulateDataAccept',
		formPrepopulateDataHeadersJEl = '#' + namespace + 'prepopulateDataHeaders',
		formPrepopulateDataParamsJEl = '#' + namespace + 'prepopulateDataParams',
		dfConfigurationFormJEl = '#' + namespace + 'dfConfigurationForm',
		getFormConfigurationResourceURL = '${getFormConfigurationResourceURL}',
		formVersionModalJEl = '#' + namespace + 'formVersionModal',
		formVersionModalBodyJEl = '#' + namespace + 'formVersionModalBody',
		editFormFieldJEl = '#' + namespace + 'editFormField',
		getFormBasicSectionResourceURL = '${getFormBasicSectionResourceURL}',
        formFieldErrJEl = '#' + namespace + 'formFieldErr',
        formFieldErrorAlertJEl = '#' + namespace + 'errorAlert',
        formFieldErrorAlertCloseBtnJEl = '#' + namespace + 'errorAlertCloseBtn',
        groupsDivJEl = '#' + namespace + 'groupsDiv',
		fieldExtraValidationsJEl = '#' + namespace + 'extraValidations',
		formBasicSectionJEl = '#' + namespace + 'formBasicSection',
		formDescriptionJEl = '#' + namespace + 'formDescription',
		formEnUsDescriptionJEl = '#' + namespace + 'formDescription_en_US',
		formArSaDescriptionJEl = '#' + namespace + 'formDescription_ar_SA',
		formBasicSectionSaveBtnJEl = '#' + namespace + 'formBasicSectionSaveBtn',
		formBasicSectionResetBtnJEl = '#' + namespace +'formBasicSectionResetBtn',
	 	formNameValidator = namespace + 'formName',
	 	formTitleValidator = namespace + 'formTitle',
		formLayoutValidator = namespace + 'formLayout',
		formDescriptionValidator = namespace + 'formDescription',
		formBasicSectionEncryptedDataJEl = '#' + namespace + 'formBasicSectionEncryptedData',
	 	formVersionModalJEl = '#' + namespace + 'formVersionModal',
	 	formVersionValidator = namespace + 'formVersion',
	 	formNameErrJEl = '#' + namespace + 'formNameErr',
		formNameJEl = '#' + namespace + 'formName',
		formTitleJEl = '#' + namespace + 'formTitle',
		formEnUsTitleJEl = '#' + namespace + 'formTitle_en_US',
		formArSaTitleJEl = '#' + namespace + 'formTitle_ar_SA',
		formLayoutJEl = '#' + namespace + 'formLayout',
		formBasicSectionModalJEl = '#' + namespace + 'formBasicSectionModal',
		formEncryptedDataJEl = '#' + namespace + 'formEncryptedData',
		isFieldEditJEl = '#' + namespace + 'isFieldEdit',
        fieldEditSrNoJEl = '#' + namespace + 'fieldEditSrNo',
        isFieldDeleteJEl = '#' + namespace + 'isFieldDelete',
        fieldDeleteSrNoJEl = '#' + namespace + 'fieldDeleteSrNo',
        dfLoaderContainerJEl = '#' + namespace + 'dfLoaderContainer',
        deleteFormFieldModalJEl = '#' + namespace + 'deleteFormFieldModal',
        deleteFormFieldModalLabelJEl = '#' + namespace + 'deleteFormFieldModalLabel',
        deleteFormFieldModalSaveBtnJEl = '#' + namespace + 'deleteFormFieldModalSaveBtn',
        deleteFormFieldModalCancelBtnJEl = '#' + namespace + 'deleteFormFieldModalCancelBtn'
		formReorderSaveChangesBtnJEl = '#' + namespace + 'formReorderSaveChangesBtn',
        reOrderConfirmModalJEl = '#' + namespace + 'reOrderConfirmModal',
        reOrderConfirmModalLabelJEl = '#' + namespace + 'reOrderConfirmModalLabel',
        reOrderConfirmModalSaveBtnJEl = '#' + namespace + 'reOrderConfirmModalSaveBtn',
        reOrderConfirmModalCancelBtnJEl = '#' + namespace + 'reOrderConfirmModalCancelBtn',
		formVersionSaveBtnJEl = '#' + namespace + 'formVersionSaveBtn',
		formVersionDataJEl = '#' + namespace + 'formVersionData',
		formVersionJEl = '#' + namespace + 'formVersion',
		formDefinitionIdJEl = '#' + namespace + 'formDefinitionId',
		formNamesDataJEl = '#' + namespace + 'formNamesData',
		deleteFormFieldJEl = '#' + namespace + 'deleteFormField',
		groupsJEl = '#' + namespace + 'groups',
		formFieldJEl = '#' + namespace + 'formField',
		fieldLabelJEl = '#' + namespace + 'fieldLabel',
		fieldEnUsLabelJEl = '#' + namespace + 'fieldLabel_en_US',
		fieldArSaLabelJEl = '#' + namespace + 'fieldLabel_ar_SA',
		formFieldLabelSelectedLocaleJEl = '#' + namespace + 'fieldLabelSelectedLocale';
		fieldKeyJEl = '#' + namespace + 'fieldKey',
		fieldPostDataJEl = '#' + namespace + 'postData',
		fieldPostDataNameJEl = '#' + namespace + 'postDataName',
		fieldVisibleOnJEl = '#' + namespace + 'visibleOn',
		fieldNewLineJEl = '#' + namespace + 'newLine',
		fieldVisibleOnDropdownJEl = '#' + namespace + 'visibleOnDropdown',
		fieldVisibleOnNameJEl = '#' + namespace + 'visibleOnName',
		fieldPopulateDataJEl = '#' + namespace + 'populateData',
		fieldPopulateDataNameJEl = '#' + namespace + 'populateDataName',
		fieldReadFromReqParamJEl = '#' + namespace + 'readFromReqParam',
		fieldReadFromReqParamNameJEl = '#' + namespace + 'readFromReqParamName',
		fieldTypeJEl = '#' + namespace + 'fieldType',
		fieldPlaceholderJEl = '#' + namespace + 'placeholder',
		fieldEnUsPlaceholderJEl = '#' + namespace + 'placeholder_en_US',
		fieldArSaPlaceholderJEl = '#' + namespace + 'placeholder_ar_SA',
		fieldPlaceholderSelectedLocaleJEl = '#' + namespace + 'placeholderSelectedLocale',
		displayPlaceholderLocaleBtnJEl = '#' + namespace + 'displayPlaceholderLocaleBtn',
		fieldEnUsRangeCommentJEl = '#' + namespace + 'rangeComment_en_US',
		fieldArSaRangeCommentJEl = '#' + namespace + 'rangeComment_ar_SA',
		fieldDisplayRangeCommentLocaleBtnJEl = '#' + namespace + 'displayRangeCommentLocaleBtn',
		fieldRangeCommentSelectedLocaleJEl = '#' + namespace + 'rangeCommentSelectedLocale',
		fieldHTMLEditorPlaceholderJEl = '#' + namespace + 'htmlEditor',
		fieldEnUsHTMLEditorPlaceholderJEl = '#' + namespace + 'htmlEditor_en_US',
		fieldArSaHTMLEditorPlaceholderJEl = '#' + namespace + 'htmlEditor_ar_SA',
		fieldHTMLPlaceholderSelectedLocale = '#' + namespace + 'htmlEditorSelectedLocale',
		displayHTMLEditorLocaleBtnJEl = '#' + namespace + 'displayHTMLEditorLocaleBtn',
		fieldRangeCommentSelectedLocale = '#' + namespace + 'rangeCommentSelectedLocale',
		fieldFormatPlaceholderJEl = '#' + namespace + 'formatPlaceholder',
		fieldMinNumberPlaceholderJEl = '#' + namespace + 'minNumberPlaceholder',
		fieldMaxNumberPlaceholderJEl = '#' + namespace + 'maxNumberPlaceholder',
		fieldValuesInputTagJEl = '#' + namespace + 'valuesInputTag',
		fieldDefaultSelectedJEl = '#' + namespace + 'defaultSelected',
		fieldDataTypeJEl = '#' + namespace + 'fieldDataType',
		fieldStatusJEl = '#' + namespace + 'fieldStatus',
		fieldReadonlyJEl = '#' + namespace + 'fieldReadonly',
		fieldDisableJEl = '#' + namespace + 'fieldDisable',
		fieldRequiredJEl = '#' + namespace + 'fieldRequired',
		fieldMultipleFileUploadJEl = '#' + namespace + 'multipleFileUpload',
		formFieldModalJEl = '#' + namespace + 'formFieldModal',
		deleteFormFieldModalJEl = '#' + namespace + 'deleteFormFieldModal',
		groupJEl = '#' + namespace + 'group',
		fieldGroupAverageJEl = '#' + namespace + 'groupAverage',
		fieldOverallAverageJEl = '#' + namespace + 'overallAverage',
		groupTotalJEl = '#' + namespace + 'groupTotal',
		isRangeCommentJEl = '#' + namespace + 'isRangeComment',
		rangeCommentJEl = '#' + namespace + 'rangeComment',
		rangeTotalCharacterJEl = '#' + namespace + 'rangeTotalCharacter',
		rangeMaxCharacterJEl = '#' + namespace + 'rangeMaxCharacter',
		overallTotalJEl = '#' + namespace + 'overallTotal',
		fieldGroupOrderJEl = '#' + namespace + 'groupOrder',
		fieldMinBoundaryJEl =  '#' + namespace + 'minBoundary',
		fieldMaxBoundaryJEl =  '#' + namespace + 'maxBoundary',
		rangeOptionsDataJEl =  '#' + namespace + 'rangeOptionsData',
		fieldRangeOptionsConfigTbodyJEl = '#' + namespace + 'rangeOptionsConfigTbody',
		formFieldSaveBtnJEl = '#' + namespace + 'formFieldSaveBtn',
		formFieldResetBtnJEl = '#' + namespace + 'formFieldResetBtn',
		fieldLabelValidator = namespace + 'fieldLabel',
		fieldTypeValidator = namespace + 'fieldType',
        fieldKeyValidator = namespace + 'fieldKey',
		fieldDataTypeValidator = namespace + 'fieldDataType',
	 	fieldStatusValidator = namespace + 'fieldStatus',
	 	fieldLableErrJEl = '#' + namespace+ 'fieldLableErr',
	 	inputTagsErrJEl = '#' + namespace+ 'inputTagsErr',
		formVersionDataName = namespace + 'formVersionData',
		currentVersionRadioJEl = '#' + namespace + 'currentVersionRadio',
		newVersionRadioJEl = '#' + namespace + 'newVersionRadio',
		jsGridValidationJEl = '#' + namespace + 'jsGridValidation',
		columnNamesDataJEl = '#' + namespace + 'columnNamesData',
		displayGroupJEl = '#' + namespace + 'displayGroup',
        formFieldConfigRowSettingsAccordianJEl = '#' + namespace + 'formFieldConfigRowSettingsAccordian',
        dfStaticValuesRowJEl = '#' + namespace + 'dfStaticValuesRow_',
        dfStaticInputJEl = '#' + namespace + 'dfStaticInput_',
        displayDFStaticValuesInputTextJEl = '#' + namespace + 'displayDFStaticValuesInputText_',
        fieldDisplayDFStaticValuesInputTagJEl = '#' + namespace + 'displayDFStaticValuesInputTag_',
		formMasterBSJEl = '#' + namespace + 'formMasterBS';
        postDataBSJEl = '#' + namespace + 'postDataBS',
        populateDataBSJEl = '#' + namespace + 'populateDataBS',
        readFromReqParamBSJEl = '#' + namespace + 'readFromReqParamBS',
        displayPostDataJEl = '#' + namespace + 'displayPostData',
        displayPopulateDataJEl = '#' + namespace + 'displayPopulateData',
        displayReadFromReqParamJEl = '#' + namespace + 'displayReadFromReqParam',
        groupJSGridJEl = '#' + namespace + 'groupJSGrid';
        postDataAccordianJEl= '#' + namespace + 'postDataAccordian',
        populateDataAccordianJEl = '#' + namespace + 'populateDataAccordian',
        dataProviderAcceptJEl = '#' + namespace + 'dataProviderAccept',
        dataProviderHeadersJEl = '#' + namespace + 'dataProviderHeaders',
        dataProviderParamsJEl = '#' + namespace + 'dataProviderParams',
		formTitleSelectedLocaleJEl = '#' + namespace + 'formTitleSelectedLocale',
		formDescriptionSelectedLocaleJEl = '#' + namespace + 'formDescriptionSelectedLocale',
		workflowDefinitionJEl = '#' + namespace + 'workflowDefinitions',
		fieldDisplayCustomRangeJSGridJEl = '#' + namespace + 'displayCustomRangeJSGrid',
		fieldDisplayCustomRangeOptionsJEl = '#' + namespace + 'displayCustomRangeOptions',
		rolesJson = '${rolesJson}',
		permissionTableBodyJEL = '#' + 'permissionTableBody',
		permissionFieldIdJEL = '#' + namespace + 'permissionFieldId';
        formBasicSectionSaveBtnSpanJEl = '#' + namespace + 'formBasicSectionSaveBtnSpan',
		formPreviewURLBtnJEl = '#' + namespace + 'formPreviewURLBtn',
		//rangeOptionDataArr = rangeOptionData ? JSON.parse(atob(rangeOptionData)) : "",
		rangeOptionDataArr = rangeOptionData ? rangeOptionData : "",
		displayRangeOptionNameDrJEl = '#' + namespace + 'displayRangeOptionNameDr',
		openPermissionModalJEl = '#' + namespace + 'openPermissionModal',
		saveRolePermissionJEl = '#' + namespace + 'saveRolePermission',
		rolePermissionCloseBtnJEl = '#' + namespace + 'rolePermissionCloseBtn',
		rangeOptionNameDrJEl = '#' + namespace + 'rangeOptionNameDr';

	 config.namespace = namespace;
	 config.contextPath = contextPath;
	 config.themeImagesPath = themeImagesPath;
	 config.secretPassphrase = secretPassphrase;
	 config.saveFormConfigurationResourceURL = saveFormConfigurationResourceURL;
	 config.getFormDataResourceURL = getFormDataResourceURL;
	 config.workflowDefinitionArr = workflowDefinitionArr;
	 config.formBasicSectionJEl = formBasicSectionJEl;
	 config.formDescriptionJEl = formDescriptionJEl;
	 config.formEnUsDescriptionJEl = formEnUsDescriptionJEl;
	 config.formArSaDescriptionJEl = formArSaDescriptionJEl;
	 config.formNameJEl = formNameJEl;
	 config.formTitleJEl = formTitleJEl;
	 config.formEnUsTitleJEl = formEnUsTitleJEl;
	 config.formArSaTitleJEl = formArSaTitleJEl;
	 config.formLayoutJEl = formLayoutJEl;
	 config.formBasicSectionModalJEl = formBasicSectionModalJEl
	 config.formEncryptedDataJEl = formEncryptedDataJEl;
	 config.isFieldEditJEl = isFieldEditJEl;
	 config.fieldEditSrNoJEl = fieldEditSrNoJEl;
	 config.isFieldDeleteJEl = isFieldDeleteJEl;
	 config.fieldDeleteSrNoJEl = fieldDeleteSrNoJEl;
	 config.dfLoaderContainerJEl = dfLoaderContainerJEl;
	 config.deleteFormFieldModalJEl = deleteFormFieldModalJEl;
	 config.deleteFormFieldModalLabelJEl = deleteFormFieldModalLabelJEl;
	 config.deleteFormFieldModalSaveBtnJEl = deleteFormFieldModalSaveBtnJEl;
	 config.deleteFormFieldModalCancelBtnJEl = deleteFormFieldModalCancelBtnJEl;
	 config.formReorderSaveChangesBtnJEl = formReorderSaveChangesBtnJEl;
	 config.reOrderConfirmModalJEl = reOrderConfirmModalJEl;
	 config.reOrderConfirmModalLabelJEl = reOrderConfirmModalLabelJEl;
	 config.reOrderConfirmModalSaveBtnJEl = reOrderConfirmModalSaveBtnJEl;
	 config.reOrderConfirmModalCancelBtnJEl = reOrderConfirmModalCancelBtnJEl;
	 config.formVersionSaveBtnJEl = formVersionSaveBtnJEl;
	 config.formVersionDataJEl = formVersionDataJEl;
	 config.formFieldConfigRowSettingsAccordianJEl = formFieldConfigRowSettingsAccordianJEl;
	 config.formVersionJEl = formVersionJEl;
	 config.formDefinitionIdJEl = formDefinitionIdJEl;
	 config.formNamesDataJEl = formNamesDataJEl;
	 config.deleteFormFieldJEl = deleteFormFieldJEl;
	 config.groupsJEl = groupsJEl;
	 config.formFieldJEl = formFieldJEl;
     config.fieldLabelJEl = fieldLabelJEl;
	 config.fieldEnUsLabelJEl = fieldEnUsLabelJEl;
	 config.fieldArSaLabelJEl = fieldArSaLabelJEl;
	 config.formFieldLabelSelectedLocaleJEl = formFieldLabelSelectedLocaleJEl;
     config.fieldKeyJEl = fieldKeyJEl;
     config.dfStaticValuesRowJEl = dfStaticValuesRowJEl;
	 config.fieldPostDataJEl = fieldPostDataJEl;
	 config.fieldPostDataNameJEl = fieldPostDataNameJEl;
	 config.fieldVisibleOnJEl = fieldVisibleOnJEl;
	 config.fieldNewLineJEl = fieldNewLineJEl;
	 config.fieldVisibleOnDropdownJEl = fieldVisibleOnDropdownJEl;
	 config.fieldVisibleOnNameJEl = fieldVisibleOnNameJEl;
	 config.fieldPopulateDataJEl = fieldPopulateDataJEl;
	 config.fieldPopulateDataNameJEl = fieldPopulateDataNameJEl;
	 config.fieldReadFromReqParamJEl = fieldReadFromReqParamJEl;
	 config.fieldReadFromReqParamNameJEl = fieldReadFromReqParamNameJEl;
	 config.fieldTypeJEl = fieldTypeJEl;
	 config.fieldPlaceholderJEl = fieldPlaceholderJEl;
	 config.fieldEnUsPlaceholderJEl = fieldEnUsPlaceholderJEl;
	 config.fieldArSaPlaceholderJEl = fieldArSaPlaceholderJEl;
	 config.fieldPlaceholderSelectedLocaleJEl = fieldPlaceholderSelectedLocaleJEl;
	 config.displayPlaceholderLocaleBtnJEl = displayPlaceholderLocaleBtnJEl;
	 config.fieldEnUsRangeCommentJEl = fieldEnUsRangeCommentJEl;
	 config.fieldArSaRangeCommentJEl = fieldArSaRangeCommentJEl;
	 config.fieldRangeCommentSelectedLocale = fieldRangeCommentSelectedLocale;
	 config.fieldDisplayRangeCommentLocaleBtnJEl = fieldDisplayRangeCommentLocaleBtnJEl;
	 config.fieldRangeCommentSelectedLocaleJEl = fieldRangeCommentSelectedLocaleJEl;
	 config.fieldHTMLEditorPlaceholderJEl = fieldHTMLEditorPlaceholderJEl;
	 config.fieldEnUsHTMLEditorPlaceholderJEl = fieldEnUsHTMLEditorPlaceholderJEl;
	 config.fieldArSaHTMLEditorPlaceholderJEl = fieldArSaHTMLEditorPlaceholderJEl;
	 config.fieldHTMLPlaceholderSelectedLocale = fieldHTMLPlaceholderSelectedLocale;
	 config.displayHTMLEditorLocaleBtnJEl = displayHTMLEditorLocaleBtnJEl;
	 config.fieldFormatPlaceholderJEl = fieldFormatPlaceholderJEl;
	 config.fieldMinNumberPlaceholderJEl = fieldMinNumberPlaceholderJEl;
	 config.fieldMaxNumberPlaceholderJEl = fieldMaxNumberPlaceholderJEl;
	 config.fieldValuesInputTagJEl = fieldValuesInputTagJEl;
	 config.fieldDefaultSelectedJEl = fieldDefaultSelectedJEl;
	 config.fieldDataTypeJEl = fieldDataTypeJEl;
	 config.fieldStatusJEl = fieldStatusJEl;
	 config.fieldReadonlyJEl = fieldReadonlyJEl;
	 config.fieldDisableJEl = fieldDisableJEl;
	 config.fieldRequiredJEl = fieldRequiredJEl;	
	 config.fieldMultipleFileUploadJEl = fieldMultipleFileUploadJEl;
	 config.formFieldModalJEl = formFieldModalJEl;
	 config.deleteFormFieldModalJEl = deleteFormFieldModalJEl;
	 config.groupJEl = groupJEl;
	 config.fieldGroupAverageJEl = fieldGroupAverageJEl;
	 config.fieldOverallAverageJEl = fieldOverallAverageJEl;
	 config.groupTotalJEl = groupTotalJEl;
	 config.isRangeCommentJEl = isRangeCommentJEl;
	 config.rangeCommentJEl = rangeCommentJEl;
	 config.rangeTotalCharacterJEl = rangeTotalCharacterJEl;
	 config.rangeMaxCharacterJEl = rangeMaxCharacterJEl;
	 config.overallTotalJEl = overallTotalJEl;
	 config.fieldGroupOrderJEl = fieldGroupOrderJEl;
	 config.fieldMinBoundaryJEl = fieldMinBoundaryJEl;
	 config.fieldMaxBoundaryJEl = fieldMaxBoundaryJEl;
	 config.rangeOptionsDataJEl = rangeOptionsDataJEl;
	 config.fieldRangeOptionsConfigTbodyJEl = fieldRangeOptionsConfigTbodyJEl;
	 config.formJEl = formJEl;
	 config.formContainerJEl = formContainerJEl;
	 config.formDataTableJEl = formDataTableJEl;
	 config.formCardHeaderJEl = formCardHeaderJEl;
	 config.formCardBodyJEl = formCardBodyJEl;
	 config.formCardBodyLoadingRowJEl = formCardBodyLoadingRowJEl;
	 config.formCardBodyLoadingJEl = formCardBodyLoadingJEl;
	 config.formBasicSectionModalBodyJEl = formBasicSectionModalBodyJEl;
	 config.formBasicSectionErrMsgJEl = formBasicSectionErrMsgJEl;
	 config.formBasicSectionErrAlertJEl = formBasicSectionErrAlertJEl;
	 config.formBasicSectionModalFooterJEl = formBasicSectionModalFooterJEl;
	 config.formBasicSectionBtnJEl = formBasicSectionBtnJEl;
	 config.formPreviewURLBtnJEl = formPreviewURLBtnJEl;
	 config.formFieldModalBodyJEl = formFieldModalBodyJEl;
	 config.formFieldModalFooterJEl = formFieldModalFooterJEl;
	 config.formFieldBtnJEl = formFieldBtnJEl;
	 config.formSubmitBtnJEl = formSubmitBtnJEl;
	 config.formPostAndPrepopulateFieldsDataModalJEl = formPostAndPrepopulateFieldsDataModalJEl;
	 config.formPostAndPrepopulateFieldsDataModalBodyJEl = formPostAndPrepopulateFieldsDataModalBodyJEl;
	 config.formPostAndPrepopulateFieldsDataModalFooterJEl = formPostAndPrepopulateFieldsDataModalFooterJEl;
	 config.formPostAndPrepopulateFieldsDataBtnJEl = formPostAndPrepopulateFieldsDataBtnJEl;
	 config.formLayoutName = formLayoutName;
	 config.fieldDisplayPlaceholderJEl = fieldDisplayPlaceholderJEl;
	 config.fieldDisplayHTMLEditorJEl = fieldDisplayHTMLEditorJEl;
	 config.fieldDisplayFormatPlaceholderJEl = fieldDisplayFormatPlaceholderJEl;
	 config.fieldDisplayMinNumberPlaceholderJEl = fieldDisplayMinNumberPlaceholderJEl;
	 config.fieldDisplayMaxNumberPlaceholderJEl = fieldDisplayMaxNumberPlaceholderJEl;
	 config.fieldDisplayMultipleFileUploadJEl = fieldDisplayMultipleFileUploadJEl;
	 config.fieldDisplayFileExtensionsInputTagJEl = fieldDisplayFileExtensionsInputTagJEl;
	 config.fieldDisplayMinBoundaryJEl = fieldDisplayMinBoundaryJEl;
	 config.fieldDisplayMaxBoundaryJEl = fieldDisplayMaxBoundaryJEl;
	 config.fieldDisplayRangeOptionsJEl = fieldDisplayRangeOptionsJEl;
	 config.fieldDisplayAverageJEl = fieldDisplayAverageJEl;
	 config.fieldDisplayTotalJEl = fieldDisplayTotalJEl;
	 config.fieldDisplayRangeTotalCharacterJEl = fieldDisplayRangeTotalCharacterJEl;
	 config.fieldDisplayRangeCommentJEl = fieldDisplayRangeCommentJEl;
	 config.fieldDisplayValuesInputTagJEl = fieldDisplayValuesInputTagJEl;
	 config.fieldDisplayCheckboxRadioJSGridJEl = fieldDisplayCheckboxRadioJSGridJEl;
	 config.fieldDisplayDropdownStaticJSGridJEl = fieldDisplayDropdownStaticJSGridJEl;
	 config.fieldDisplayRangeJSGridJEl = fieldDisplayRangeJSGridJEl;
	 config.fieldDisplayDefaultSelectedJEl = fieldDisplayDefaultSelectedJEl;
	 config.fieldDisplayDropdownConfigCheckboxJEl = fieldDisplayDropdownConfigCheckboxJEl;
	 config.fieldDisplayWhereToPopulateDropdownJEl = fieldDisplayWhereToPopulateDropdownJEl;
	 config.fieldDisplayMasterTableRadioJEl = fieldDisplayMasterTableRadioJEl;
	 config.fieldCreateMasterTableJEl = fieldCreateMasterTableJEl;
	 config.fieldTogglePostDataFieldJEl = fieldTogglePostDataFieldJEl;
	 config.fieldDisplayVisibleOnSelectedDropdownJEl = fieldDisplayVisibleOnSelectedDropdownJEl;
	 config.fieldToggleVisibleOnFieldJEl = fieldToggleVisibleOnFieldJEl;
	 config.fieldTogglePopulateDataFieldJEl = fieldTogglePopulateDataFieldJEl;
	 config.fieldToggleVisibleOnDropdownFieldJEl = fieldToggleVisibleOnDropdownFieldJEl;
	 config.fieldToggleReadFromReqParamFieldJEl = fieldToggleReadFromReqParamFieldJEl;
	 config.fieldDataProviderRowJEl = fieldDataProviderRowJEl;
	 config.fieldDisplayDataProviderURLJEl = fieldDisplayDataProviderURLJEl;
	 config.fieldDisplayMethodTypesJEl = fieldDisplayMethodTypesJEl;
	 config.fieldDisplayContentTypesJEl = fieldDisplayContentTypesJEl;
	 config.fieldDisplayDataProviderURLPropertyJEl = fieldDisplayDataProviderURLPropertyJEl;
	 config.fieldDisplayDataPropsJEl = fieldDisplayDataPropsJEl;
	 config.fieldDisplaySourcePropsJEl = fieldDisplaySourcePropsJEl;
	 config.fieldStaticValuesRowJEl = fieldStaticValuesRowJEl;
	 config.fieldDisplayStaticValuesInputTagJEl = fieldDisplayStaticValuesInputTagJEl;
	 config.fieldDependentFieldsRowJEl = fieldDependentFieldsRowJEl;
	 config.fieldDisplayDependentFieldsNameDropdownJEl = fieldDisplayDependentFieldsNameDropdownJEl;
	 config.fieldDisplayWhereToPopulateDependentFieldsJEl = fieldDisplayWhereToPopulateDependentFieldsJEl;
	 config.fieldMasterTableRowJEl = fieldMasterTableRowJEl;
	 config.fieldMasterTableDropdownJEl = fieldMasterTableDropdownJEl;
	 config.fieldMasterTableColumnDropdownJEl = fieldMasterTableColumnDropdownJEl;
	 config.fieldDisplayVisibleOnJEl = fieldDisplayVisibleOnJEl;
	 config.fieldRangeOptionsConfigRowJEl = fieldRangeOptionsConfigRowJEl;
	 config.fieldDisplayRangeOptionsConfigJEl = fieldDisplayRangeOptionsConfigJEl;
	 config.fieldFileExtensionsInputTagJEl = fieldFileExtensionsInputTagJEl;
	 config.fieldRangeOptionsJEl = fieldRangeOptionsJEl;
	 config.fieldRangeOptionsConfigTableJEl = fieldRangeOptionsConfigTableJEl;
	 config.fieldMultiselectDropdownCheckboxJEl = fieldMultiselectDropdownCheckboxJEl;
	 config.fieldSearchableDropdownCheckboxJEl = fieldSearchableDropdownCheckboxJEl;
	 config.fieldWhereToPopulateDropdownJEl = fieldWhereToPopulateDropdownJEl;
	 config.fieldStaticValuesInputTagJEl = fieldStaticValuesInputTagJEl;
	 config.fieldDependentFieldsNameJEl = fieldDependentFieldsNameJEl;
	 config.fieldDFStaticValuesJSGridJEl = fieldDFStaticValuesJSGridJEl;
	 config.fieldDisplayDFStaticValuesInputTagJEl = fieldDisplayDFStaticValuesInputTagJEl;
	 config.fieldWhereToPopulateDependentFieldsJEl = fieldWhereToPopulateDependentFieldsJEl;
	 config.fieldDataProviderURLJEl = fieldDataProviderURLJEl;
	 config.fieldMethodTypesJEl = fieldMethodTypesJEl;
	 config.fieldContentTypesJEl = fieldContentTypesJEl;
	 config.fieldDataPropsJEl = fieldDataPropsJEl;
	 config.fieldSourcePropsJEl = fieldSourcePropsJEl;
	 config.fieldDataProviderURLPropertyJEl = fieldDataProviderURLPropertyJEl;
	 config.addFormFieldRowButtonJEl = addFormFieldRowButtonJEl;
	 config.deleteFormFieldRowButtonJEl = deleteFormFieldRowButtonJEl;
	 config.formPostDataURLJEl = formPostDataURLJEl;
	 config.formPostDataContentTypeJEl = formPostDataContentTypeJEl;
	 config.formPostDataAcceptJEl = formPostDataAcceptJEl;
	 config.formPostDataHeadersJEl = formPostDataHeadersJEl;
	 config.formPostDataParamsJEl = formPostDataParamsJEl;
	 config.formPrepopulateDataURLJEl = formPrepopulateDataURLJEl;
	 config.formPrepopulateDataContentTypeJEl = formPrepopulateDataContentTypeJEl;
	 config.formPrepopulateDataAcceptJEl = formPrepopulateDataAcceptJEl;
	 config.formPrepopulateDataHeadersJEl = formPrepopulateDataHeadersJEl;
	 config.formPrepopulateDataParamsJEl =	formPrepopulateDataParamsJEl;
	 config.dfConfigurationFormJEl = dfConfigurationFormJEl;
	 config.getFormConfigurationResourceURL = getFormConfigurationResourceURL;
	 config.formVersionModalJEl = formVersionModalJEl;
	 config.formVersionModalBodyJEl = formVersionModalBodyJEl;
	 config.editFormFieldJEl = editFormFieldJEl;
	 config.getFormBasicSectionResourceURL = getFormBasicSectionResourceURL;
	 config.formFieldErrJEl = formFieldErrJEl;
	 config.formFieldErrorAlertJEl = formFieldErrorAlertJEl;
	 config.formFieldErrorAlertCloseBtnJEl = formFieldErrorAlertCloseBtnJEl;
	 config.groupsDivJEl = groupsDivJEl;
	 config.fieldExtraValidationsJEl = fieldExtraValidationsJEl;
	 config.formBasicSectionSaveBtnJEl = formBasicSectionSaveBtnJEl;
	 config.formBasicSectionResetBtnJEl = formBasicSectionResetBtnJEl;
	 config.formNameValidator = formNameValidator;
	 config.formTitleValidator = formTitleValidator;
	 config.formLayoutValidator = formLayoutValidator;
	 config.formDescriptionValidator = formDescriptionValidator;
	 config.formVersionModalJEl = formVersionModalJEl;
	 config.formVersionValidator = formVersionValidator;
	 config.formNameErrJEl = formNameErrJEl;
	 config.formFieldSaveBtnJEl = formFieldSaveBtnJEl;
	 config.formFieldResetBtnJEl = formFieldResetBtnJEl;
	 config.fieldLabelValidator = fieldLabelValidator;
	 config.fieldTypeValidator = fieldTypeValidator;
     config.fieldKeyValidator = fieldKeyValidator;
	 config.fieldDataTypeValidator = fieldDataTypeValidator;
	 config.fieldStatusValidator = fieldStatusValidator;
	 config.fieldLableErrJEl = fieldLableErrJEl;
	 config.inputTagsErrJEl = inputTagsErrJEl; 
	 config.formVersionDataName = formVersionDataName;
	 config.currentVersionRadioJEl = currentVersionRadioJEl;
	 config.newVersionRadioJEl = newVersionRadioJEl;
	 config.jsGridValidationJEl = jsGridValidationJEl;
	 config.formFieldConfirmationModal = formFieldConfirmationModal;
	 config.formFieldConfirmationYesBtn = formFieldConfirmationYesBtn;
	 config.formFieldConfirmationNoBtn = formFieldConfirmationNoBtn;
	 config.formSubmitConfirmationModal = formSubmitConfirmationModal;
	 config.formSubmitConfirmationYesBtn = formSubmitConfirmationYesBtn;
	 config.formSubmitConfirmationNoBtn = formSubmitConfirmationNoBtn;
	 config.formBasicSectionConfirmationModal = formBasicSectionConfirmationModal;
	 config.formBasicSectionConfirmationYesBtn = formBasicSectionConfirmationYesBtn;
	 config.formBasicSectionConfirmationNoBtn = formBasicSectionConfirmationNoBtn;
	 config.formFieldResetBtnConfirmationModal = formFieldResetBtnConfirmationModal;
	 config.formFieldResetBtnConfirmationNoBtn = formFieldResetBtnConfirmationNoBtn;
	 config.formFieldResetBtnConfirmationYesBtn = formFieldResetBtnConfirmationYesBtn;
     config.formBasicSectionSuccessAlertJEl = formBasicSectionSuccessAlertJEl;
     config.formBasicSectionAlertCloseBtnJEl = formBasicSectionAlertCloseBtnJEl;
	 config.columnNamesDataJEl = columnNamesDataJEl;
	 config.displayGroupJEl = displayGroupJEl;
     config.dfStaticInputJEl = dfStaticInputJEl;
     config.fieldDFStaticValuesJSGridJEl = fieldDFStaticValuesJSGridJEl;
     config.displayDFStaticValuesInputTextJEl = displayDFStaticValuesInputTextJEl;
	 config.formMasterBSJEl = formMasterBSJEl;
     config.postDataBSJEl = postDataBSJEl;
     config.populateDataBSJEl = populateDataBSJEl;
     config.readFromReqParamBSJEl = readFromReqParamBSJEl;
     config.displayPostDataJEl = displayPostDataJEl;
     config.displayPopulateDataJEl = displayPopulateDataJEl;
     config.displayReadFromReqParamJEl = displayReadFromReqParamJEl;
	 config.fieldMasterTableJEl = fieldMasterTableJEl;
	 config.fieldMasterTableTextColumnJEl = fieldMasterTableTextColumnJEl;
	 config.fieldMasterTableValueColumnJEl = fieldMasterTableValueColumnJEl;
	 config.groupJSGridJEl = groupJSGridJEl;
     config.postDataAccordianJEl = postDataAccordianJEl;
     config.populateDataAccordianJEl = populateDataAccordianJEl;
     config.dataProviderAcceptJEl = dataProviderAcceptJEl;
     config.dataProviderHeadersJEl = dataProviderHeadersJEl;
     config.dataProviderParamsJEl = dataProviderParamsJEl;
	 config.formTitleSelectedLocaleJEl = formTitleSelectedLocaleJEl;
	 config.formDescriptionSelectedLocaleJEl = formDescriptionSelectedLocaleJEl;
	 config.workflowDefinitionJEl = workflowDefinitionJEl;
	 config.formBasicSectionSaveBtnSpanJEl = formBasicSectionSaveBtnSpanJEl;
	 config.selectedFormDefinitionId = '<%=formDefinitionId%>';
	 config.previewFormURL = '${previewFormURL}';
	 config.fieldDisplayCustomRangeJSGridJEl = fieldDisplayCustomRangeJSGridJEl;
	 config.fieldDisplayCustomRangeOptionsJEl = fieldDisplayCustomRangeOptionsJEl;
	 config.rolesJson = rolesJson;
	 config.permissionFieldIdJEL = permissionFieldIdJEL;
	 config.permissionTableBodyJEL = permissionTableBodyJEL;
	 config.rangeOptionDataArr = rangeOptionDataArr;
	 config.displayRangeOptionNameDrJEl = displayRangeOptionNameDrJEl;
	 config.openPermissionModalJEl = openPermissionModalJEl;
	 config.saveRolePermissionJEl = saveRolePermissionJEl;
	 config.rolePermissionCloseBtnJEl = rolePermissionCloseBtnJEl;
	 config.rangeOptionNameDrJEl = rangeOptionNameDrJEl;
	 
	 dfPortlet.initVars(config);
	 dfPortlet.viewDFConfig();
	 dfPortlet.addFormBasicSectionConfig();
	 dfPortlet.addFormFieldConfig();
	 dfPortlet.commonFormFc();
 });
 </script>