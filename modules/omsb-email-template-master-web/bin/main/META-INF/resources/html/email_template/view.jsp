<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="init.jsp" %>
<%
	String currentURL=PortalUtil.getCurrentURL(renderRequest);
%>
<portlet:resourceURL id="/view/emailTemplate" var="viewEmailTemplateURL">
</portlet:resourceURL>

<portlet:renderURL var="addEmailTemplateURL">
	<portlet:param name="redirectURL" value="<%= currentURL %>" />
    <portlet:param name="action" value="add" />
</portlet:renderURL>

<portlet:actionURL  name="deleteEmailTemplate" var="deleteEmailTemplateURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>

<portlet:renderURL var="editEmailTemplateURL">
	<portlet:param name="templateId" value="TEMPLATE_ID" />
	<portlet:param name="redirectURL" value="<%= currentURL %>" />
	<portlet:param name="action" value="edit" />
</portlet:renderURL>

<div class="text-right pt-4">
    <a href="${addEmailTemplateURL}" id="createNewConfigBtn" class="btn btn-primary"><liferay-ui:message key="add" /></a>
</div>
<div class="alert-message-container">
	 <liferay-ui:success key="email-template-create-success" message="email-template-create-success-msg"></liferay-ui:success>
	 <liferay-ui:success key="email-template-update-success" message="email-template-update-success-msg"></liferay-ui:success>
	 <liferay-ui:success key="email-template-delete-success" message="email-template-delete-success-msg"></liferay-ui:success>
	 <liferay-ui:error key="email-template-delete-error" message="email-template-delete-error-msg"></liferay-ui:error>
</div>
<div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 mt-2 pl-0 pr-0">
         <table id="<portlet:namespace />emailTemplateDataTable" 
		   	class="display dataTable no-footer" style="width:100%">
				<thead class="table-columns">
					<tr  align="center">
						<th><liferay-ui:message key="id"/></th>
						<th><liferay-ui:message key="template-name"/></th>
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
<div class="modal fade text-left delete-modal" id="<portlet:namespace />deleteConformationModal" 
	aria-labelledby="deleteConformationModalLabel" tabindex="-1" role="dialog"  aria-hidden="true" style="display: none;">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="deleteConformationModalLabel"><liferay-ui:message key="delete" /></h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
			</div>
			<form action="${deleteEmailTemplateURL}" name="<portlet:namespace />confirmForm" id="<portlet:namespace />confirmForm"  method="post">	
				<div class="modal-body">
					<p><liferay-ui:message key="are-you-sure-you-want-to-delete-this-email-template"/></p>
					<input type="hidden" name="<portlet:namespace />templateId" id="<portlet:namespace />templateId" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn grey btn-outline-primary" data-dismiss="modal">
						<liferay-ui:message key="close" />
					</button>
					<button type="submit" class="btn btn-primary" name="<portlet:namespace />deleteButton" 
						id="<portlet:namespace />deleteButton"><liferay-ui:message key="delete" />
					</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function () {
	var config = new Object({}),
		namespace = '<portlet:namespace />',
		contextPath = '<%= request.getContextPath()%>',
		viewEmailTemplateURL = '${viewEmailTemplateURL}',
		editEmailTemplateURL = '${editEmailTemplateURL}',
		templateIdJEl = '#' + namespace + 'templateId',
		emailTemplateDataTableJEl = '#' + namespace + 'emailTemplateDataTable',
		deleteConformationModalJEl = '#' + namespace + 'deleteConformationModal';
	
	config.namespace = namespace;
	config.contextPath = contextPath;
	config.viewEmailTemplateURL = viewEmailTemplateURL;
	config.editEmailTemplateURL = editEmailTemplateURL;
	config.templateIdJEl = templateIdJEl;
	config.emailTemplateDataTableJEl = emailTemplateDataTableJEl;
	config.deleteConformationModalJEl = deleteConformationModalJEl;
	
	omsbPortlet.viewEmailTemplateFc(config);
});
</script>