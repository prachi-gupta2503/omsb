<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="../init.jsp" %>

<%
String currentURL = PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:renderURL var="addConfigurationURL">
		<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.FORM_CONFIGURATION_ADD %>"/>
		<portlet:param name="selectedFormDefinitionId" value="SELECTED_FORM_DEFINITION_ID"/>
</portlet:renderURL>

<portlet:renderURL var="previewFormURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
	<portlet:param name="previewFormMode" value="preview" />
	<portlet:param name="selectedFormDefinitionId" value="SELECTED_FORM_DEFINITION_ID"/>
</portlet:renderURL>

<portlet:resourceURL id="<%= MVCCommandNames.GET_FORM_VERSIONS %>" var="fetchFormVersionsUrl"></portlet:resourceURL>

<portlet:resourceURL id="<%=MVCCommandNames.NEW_VERSION_FORM_DEFINITION%>" var="newVersionFormDefinitionURL" />

<portlet:actionURL name="<%= MVCCommandNames.SAVE_RANGE_OPTION %>" var="saveRangeOptionURL">
	<portlet:param name="redirectURL" value="<%= currentURL %>"/>
</portlet:actionURL>

<portlet:resourceURL id="<%=MVCCommandNames.GET_RANGE_OPTIONS%>" var="getRangeOptionsURL" />

<!-- <div class="modal" id="permission">
  <div class="modal-dialog">
    <div class="modal-content">

      Modal Header
      <div class="modal-header">
        <h4 class="modal-title">Role Permission</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      Modal body
      <div class="modal-body">
        <div  class="table-responsive permissionTable">
	<table class="table table-hover">
    <thead>
      <tr>
		<th>Firstname</th>
        <th>Add</th>
        <th>Edit</th>
        <th>View</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Admin</td>
        <td>
		  <div class="custom-control custom-checkbox">
			<input type="checkbox" class="custom-control-input" id="admin_add" name="admin">
			<label class="custom-control-label" for="admin_add"></label>
		  </div>
		</td>
        <td>
		  <div class="custom-control custom-checkbox">
			<input type="checkbox" class="custom-control-input" id="admin_edit" name="admin">
			<label class="custom-control-label" for="admin_edit"></label>
		  </div>
		</td>
		<td>
			<div class="custom-control custom-checkbox">
			<input type="checkbox" class="custom-control-input" id="admin_view" name="admin">
			<label class="custom-control-label" for="admin_view"></label>
		  </div>
		</td>
      </tr>
      
    </tbody>
  </table>
</div>
      </div>

      Modal footer
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>


Button to Open the Modal
<button type="button" class="btn btn-primary" hidden="true" data-toggle="modal" data-target="#permission">
  Open modal
</button> -->


<!-- Range Option Modal Popup -->
<div class="modal fade" id="<portlet:namespace />rangeOptionModal" aria-hidden="true" aria-labelledby="rangeOptionModal" tabindex="-1" role="dialog"  
 	aria-hidden="true" style="display: none;" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-xl range-option-modal-dialog form-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><liferay-ui:message key="config-range-option" /></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body range-option-modal-body" id="<portlet:namespace />rangeOptionModalBody">
      	<div class="mb-3 alert alert-dismissible alert-danger d-none" id="<portlet:namespace />rangeOptionNameErr">
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
						<div class="errorBasicAlert" id="<portlet:namespace />rangeOptionNameerrorBasicAlert"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="mb-2">
		   <button type="button" class="btn btn-primary" id="<portlet:namespace />addRangeOptionBtn">
				<liferay-ui:message key="add-range-option" />
		   </button>
		</div>
      	<form name="<portlet:namespace />rangeOptionForm" 
      		id="<portlet:namespace />rangeOptionForm"  method="post" action="${saveRangeOptionURL}">
      		<input type="hidden" id="<portlet:namespace />encryptedRangeOptionsData" name="<portlet:namespace />encryptedRangeOptionsData" />
      		<input type="hidden" id="<portlet:namespace />rangeOptionNamesData" name="<portlet:namespace />rangeOptionNamesData">
      		<input type="hidden" id="<portlet:namespace />rangeOptionId" name="<portlet:namespace />rangeOptionId">		
		</form>
		<div class="row mt-2">
		    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 mt-2">
		         <table id="<portlet:namespace />rangeOptionsDataTable" 
				   	class="display dataTable no-footer" style="width:100%">
						<thead class="table-columns">
							<tr  align="center">
								<th><liferay-ui:message key="sr-no"/></th>
								<th><liferay-ui:message key="range-option-name"/></th>
								<th><liferay-ui:message key="created-by" /></th>
								<th><liferay-ui:message key="created-date-time" /></th>
								<th><liferay-ui:message key="modified-by" /></th>
								<th><liferay-ui:message key="modified-date-time" /></th>
								<th><liferay-ui:message key="action" /></th>
							</tr>
						</thead>
				   </table>
		    </div>
		</div>
      </div>
      <div class="modal-footer" id="<portlet:namespace />rangeOptionModalFooter"> 
        <button type="button" class="btn btn-secondary" id="<portlet:namespace />rangeOptionSaveBtn"><span id="<portlet:namespace />rangeOptionSaveBtnSpan"><liferay-ui:message key="save" /></span></button>  
      	<button type="button" class="btn btn-secondary" id="<portlet:namespace />rangeOptionResetBtn"><liferay-ui:message key="reset" /></button>
      </div>
    </div>
  </div>
</div>

<!-- Add Range Option -->
<div class="mt-2">
   <button type="button" class="btn btn-primary" id="<portlet:namespace />configRangeOptionBtn">
		<liferay-ui:message key="config-range-option" />
   </button>
</div>

<div class="modal fade" id="<portlet:namespace />previewVersionSelectionModal" aria-hidden="true" aria-hidden="true" aria-labelledby="formVersionModal" tabindex="-1" role="dialog"  
 	aria-hidden="true" style="display: none;" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-xl form-field-modal-dialog form-dialog " role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><liferay-ui:message key="select-version-popup-data"/></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<div class="form-group">
			<label for="<portlet:namespace/>previewFormVersion" class="field-type-label field-setting-label">Form Version<em style="color: red;">*</em></label> 
			<select class="form-control field-type-dropdown-el" id="<portlet:namespace/>previewFormVersion" name="<portlet:namespace/>previewFormVersion">
				
			</select>
		</div>
	  </div>
      <div class="modal-footer" id="<portlet:namespace />previewVersionSelectionModalFooter">
        <button type="button" class="btn btn-primary" id="<portlet:namespace />previewFormBtn"><liferay-ui:message key="preview" /></button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="<portlet:namespace />noVersionModal" aria-hidden="true" aria-hidden="true" aria-labelledby="formVersionModal" tabindex="-1" role="dialog"  
 	aria-hidden="true" style="display: none;" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-xl form-field-modal-dialog form-dialog " role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true" style="position: absolute; right: 30px;">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <liferay-ui:message key="no-version-popup-data"/>
      </div>
      <div class="modal-footer" id="<portlet:namespace />noVersionModalFooter">
        <button type="button" class="btn btn-primary" id="<portlet:namespace />noVersionModalBtn"><liferay-ui:message key="ok" /></button>
      </div>
    </div>
  </div>
</div>

<div class="text-right pt-4">
    <a href="#" id="createNewConfigBtn" class="btn btn-primary"><liferay-ui:message key="add-form" /></a>
</div>

<!--Form Listing Table -->
<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 mt-2 pl-0 pr-0">
        <table id="<portlet:namespace />dfFormDataTable" class="display dataTable" style="width:100%">
            <thead class="table-columns">
                <tr align="center">
                    <th><liferay-ui:message key="sr-no" /></th>
                    <th><liferay-ui:message key="form-name" /></th>
                    <th><liferay-ui:message key="form-version" /></th>
                    <th><liferay-ui:message key="form-status" /></th>
                    <th><liferay-ui:message key="action" /></th>
                </tr>
            </thead>
            <tbody id="<portlet:namespace />dfFormDataTableBody">
                
            </tbody>
          </table>
          <div id="<portlet:namespace />dfLoader" class="df-process-loader loading-animation"></div>
    </div>
</div>

<script>

$(document).ready(function() {
    var viewDFConfig = new Object({}),
    namespace = '<portlet:namespace />',
	contextPath = '<%= request.getContextPath()%>',
    createNewConfigBtnJEL = '#createNewConfigBtn',
    dataTableJEl = "#" + namespace + "dfFormDataTable",
    dataTableBodyJEL = "#" + namespace + "dfFormDataTableBody",
    dfLoaderJEL = "#" + namespace + "dfLoader",
    previewVersionSelectionModalJEL = "#" + namespace + "previewVersionSelectionModal",
    previewFormBtnJEl = "#" + namespace + "previewFormBtn",
    noVersionModalJEl = "#" + namespace + "noVersionModal",
    noVersionModalBtnJEl = "#" + namespace + "noVersionModalBtn",
    previewFormVersionJEl = "#" + namespace + "previewFormVersion";
	
	
    viewDFConfig.namespace = namespace;
    viewDFConfig.contextPath = contextPath;
    viewDFConfig.createNewConfigBtnJEL = createNewConfigBtnJEL;
    viewDFConfig.dataTableJEl = dataTableJEl;
    viewDFConfig.dataTableBodyJEL = dataTableBodyJEL;
    viewDFConfig.dfLoaderJEL = dfLoaderJEL;
    viewDFConfig.addConfigurationRenderURL = '${addConfigurationURL}';
    viewDFConfig.formsDataJson = '${formsDataJson}';
    viewDFConfig.newVersionFormDefinitionURL = '${newVersionFormDefinitionURL}';
    viewDFConfig.previewFormURL = '${previewFormURL}';
    viewDFConfig.fetchFormVersionsResourceURL = '${fetchFormVersionsUrl}';
    viewDFConfig.previewFormVersionJEl = previewFormVersionJEl;
    viewDFConfig.previewFormBtnJEl = previewFormBtnJEl;
    viewDFConfig.noVersionModalJEl = noVersionModalJEl;
    viewDFConfig.noVersionModalBtnJEl = noVersionModalBtnJEl;
    viewDFConfig.previewVersionSelectionModalJEL = previewVersionSelectionModalJEL;

    dfrPortlet.formConfigActions(viewDFConfig);
    
    var rangeOptionConfig = new Object({}),
    namespace = '<portlet:namespace />',
	contextPath = '<%= request.getContextPath()%>',
	configRangeOptionBtnJEl = '#' + namespace + 'configRangeOptionBtn',
	rangeOptionModalJEl = '#' + namespace + 'rangeOptionModal',
	rangeOptionModalBodyJEL = '#' + namespace + 'rangeOptionModalBody',
	rangeOptionNameValidator = namespace + 'rangeOptionName',
	rangeOptionFormJEl = '#' + namespace + 'rangeOptionForm',
	rangeOptionSaveBtnJEl = '#' + namespace + 'rangeOptionSaveBtn',
	rangeOptionsJSGridJEl = '#' + namespace + 'rangeOptionsJSGrid',
	encryptedRangeOptionsDataJEl = '#' + namespace + 'encryptedRangeOptionsData',
	secretPassphrase = '${secretPassphrase}',
	rangeOptionNames = '${rangeOptionNames}' ? '${rangeOptionNames}' : "",
	rangeOptionNamesDataJEl = '#' + namespace + 'rangeOptionNamesData',
	rangeOptionNameErrJEl = '#' + namespace + 'rangeOptionNameErr',
	rangeOptionNameerrorBasicAlertJEl = '#' + namespace + 'rangeOptionNameerrorBasicAlert',
	rangeOptionNameJEl = '#' + namespace + 'rangeOptionName',
	addRangeOptionBtnJEl = '#' + namespace +'addRangeOptionBtn',
	rangeOptionsDataTableJEl = '#' + namespace + 'rangeOptionsDataTable',
	getRangeOptionsURL = '${getRangeOptionsURL}',
	rangeOptionIdJEl = '#' + namespace + 'rangeOptionId',
	rangeOptionResetBtnJEl = '#' + namespace + 'rangeOptionResetBtn';
	
	rangeOptionConfig.namespace = namespace;
	rangeOptionConfig.contextPath = contextPath;
	rangeOptionConfig.configRangeOptionBtnJEl = configRangeOptionBtnJEl;
	rangeOptionConfig.rangeOptionModalJEl = rangeOptionModalJEl;
	rangeOptionConfig.rangeOptionModalBodyJEL = rangeOptionModalBodyJEL;
	rangeOptionConfig.rangeOptionNameValidator = rangeOptionNameValidator;
	rangeOptionConfig.rangeOptionFormJEl = rangeOptionFormJEl;
	rangeOptionConfig.rangeOptionSaveBtnJEl = rangeOptionSaveBtnJEl;
	rangeOptionConfig.rangeOptionsJSGridJEl = rangeOptionsJSGridJEl;
	rangeOptionConfig.encryptedRangeOptionsDataJEl = encryptedRangeOptionsDataJEl;
	rangeOptionConfig.secretPassphrase = secretPassphrase;
	rangeOptionConfig.rangeOptionNames = rangeOptionNames;
	rangeOptionConfig.rangeOptionNamesDataJEl = rangeOptionNamesDataJEl;
	rangeOptionConfig.rangeOptionNameErrJEl = rangeOptionNameErrJEl;
	rangeOptionConfig.rangeOptionNameerrorBasicAlertJEl = rangeOptionNameerrorBasicAlertJEl;
	rangeOptionConfig.rangeOptionNameJEl = rangeOptionNameJEl;
	rangeOptionConfig.addRangeOptionBtnJEl = addRangeOptionBtnJEl;
	rangeOptionConfig.rangeOptionsDataTableJEl = rangeOptionsDataTableJEl;
	rangeOptionConfig.getRangeOptionsURL = getRangeOptionsURL;
	rangeOptionConfig.rangeOptionIdJEl = rangeOptionIdJEl;
	rangeOptionConfig.rangeOptionResetBtnJEl = rangeOptionResetBtnJEl;
	
 	dfPortlet.addRangeOption(rangeOptionConfig);

});

</script>