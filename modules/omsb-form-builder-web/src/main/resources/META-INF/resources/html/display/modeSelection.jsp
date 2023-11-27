<%@ include file="../init.jsp" %>

<portlet:actionURL name="<%= MVCCommandNames.SAVE_SELECTED_MODE_ACTION %>" var="addFormModeSelectionUrl"></portlet:actionURL>

<aui:form action="${addFormModeSelectionUrl}" method="post">
    
	<div class="form-heading">
		<p><em><liferay-ui:message key="form-mode-selection-heading" /></em></p>
	</div>
	
  	<div class="row">
  		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6" id="form_names_section">
  			<aui:select name="formMode" label="select-mode-label" id="form_modes" required="true">
  		  		<aui:option value=""><liferay-ui:message key="default-select-option" /></aui:option>
  		  		<aui:option value="config"><liferay-ui:message key="config-mode" /></aui:option>
  		  		<aui:option value="view"><liferay-ui:message key="view-mode" /></aui:option>		    	
			</aui:select>
  		</div>    	
  	</div>
  
 	<aui:button-row>
		<aui:button type="submit" value="save" />
	</aui:button-row>

 </aui:form>