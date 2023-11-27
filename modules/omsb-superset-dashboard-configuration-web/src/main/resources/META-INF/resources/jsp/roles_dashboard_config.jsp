<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="init.jsp" %>

<style>
	.role-dashboard-config .select2-container .select2-selection--single{height: 35px !important;}
	.role-dashboard-config .select2-container--default .select2-selection--single .select2-selection__rendered{line-height: 34px !important;}
	.role-dashboard-config .select2-container--default .select2-selection--single .select2-selection__rendered .select2-selection__clear {display: none !important;}
	.role-dashboard-config .form-group .btn{width:80px !important; height:36px !important; margin-top: 25px !important;padding: 5px !important;}
</style>

<link rel="stylesheet" href="<%= themeDisplay.getPortalURL()%>/o/gov.omsb.superset.dashboard.configuration.web/css/lib/select2.min.css">
<script src="<%= themeDisplay.getPortalURL()%>/o/gov.omsb.superset.dashboard.configuration.web/js/lib/select2.full.min.js"></script>
<script src="<%= themeDisplay.getPortalURL()%>/o/gov.omsb.superset.dashboard.configuration.web/js/main.js"></script>

<%
	String currentURL = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-portlet:actionURL portletName="gov_omsb_superset_dashboard_configuration_OmsbSupersetDashboardConfigurationWebPortlet" 
	var="saveRolesDashboardConfigURL" name="saveRolesDashboardConfig" 
	plid="<%=themeDisplay.getPlid()%>" > 	
</liferay-portlet:actionURL>


<liferay-portlet:renderURL portletName="com_liferay_configuration_admin_web_portlet_SystemSettingsPortlet" 
	var="cancelBtnURL" plid="<%=themeDisplay.getPlid()%>" 
	windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
</liferay-portlet:renderURL>


<div class="sheet sheet-full role-dashboard-config">
	<liferay-ui:success key="role-dashboard-config-save-success" message="role-dashboard-config-save-success"></liferay-ui:success>
	<liferay-ui:error key="role-dashboard-config-save-error" message="role-dashboard-config-save-error"></liferay-ui:error>
	<form action="${saveRolesDashboardConfigURL}" class="form" method="post" id="rolesDashboardConfigForm" name="rolesDashboardConfigForm">
		<div class="row">
	    	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="rolesDashboardConfigCnt">
	    		<h2><liferay-ui:message key="role-dashboard-configuration" /></h2>
	    		<input type="hidden" id="rolesDashboardConfigRowLength" name="rolesDashboardConfigRowLength" /> 
	    		<input type="hidden" name="redirectURL" value="<%= currentURL %>"/> 
	    		<input type="hidden" id="deletedConfigIds" name="deletedConfigIds" /> 
	    		<c:forEach items="${rolesDashboardConfigList}" var="rolesDashboardConfig" varStatus="loop">
	    			<c:set value="${loop.index + 1}" var="currIndex"></c:set>
					<div class="row roles-dashboard-config-row" id="rolesDashboardConfigRow_${currIndex}">
	    				<input type="hidden" class="role-dashboard-config-id" id="rolesDashboardConfigId_${currIndex}" name="rolesDashboardConfigId_${currIndex}" value="${rolesDashboardConfig.configId}" /> 
						<div class="col-lg-5 col-md-5">
							<div class="form-group">
								<label for="role_${currIndex}" class="ddm-label roles-list"><liferay-ui:message key="roles" /></label>
								<select class="roles-list form-control select2 custom-select2" id="role_${currIndex}" name="role_${currIndex}">
								  <option value=""><liferay-ui:message key="default-select-option" /></option>
								  <c:if test="${roles.length() > 0}">
									  <c:forEach begin="0" end="${roles.length() -1}" var="index">
											<option value='${roles.getJSONObject(index).getString("value")}' ${ roles.getJSONObject(index).getString("value") == rolesDashboardConfig.roleId ? 'selected' : ''} >${roles.getJSONObject(index).getString("label")}</option>
									  </c:forEach>
								  </c:if>
								</select>
							</div>							
						</div>
						<div class="col-lg-5 col-md-5">
							<div class="form-group">
								<label for="dashboardId_${currIndex}" class="ddm-label dashboardId-list"><liferay-ui:message key="dashboard" /></label>
								<select class="dashboardId-list form-control select2 custom-select2" id="dashboardId_${currIndex}" name="dashboardId_${currIndex}">
								  <option value=""><liferay-ui:message key="default-select-option" /></option>
								  <c:if test="${dashboardIds.length() > 0}">
									  <c:forEach begin="0" end="${dashboardIds.length() -1}" var="index">
									  	<option value='${dashboardIds.getJSONObject(index).getString("value")}' ${ dashboardIds.getJSONObject(index).getString("value") == rolesDashboardConfig.dashboardId ? 'selected' : ''} >${dashboardIds.getJSONObject(index).getString("label")}</option>
									  </c:forEach>
								  </c:if>
								</select>
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
							<div class="form-group">
								<c:choose>
									<c:when test="${currIndex > 1}">
										<button type="button" id="deleteRoleDashboardConfig_${currIndex}" name="deleteRoleDashboardConfig_${currIndex}" class="btn btn-icon btn-secondary delete-roles-dashboardId-config-btn" 
											onclick="customSystemSettingPortlet.saveRolesDashboardConfig.deleteRoleDashboardConfig(${currIndex});">
											Delete<i class="fa fa-minus"></i>
										</button>
									</c:when>
									<c:otherwise>
										<button type="button" id="addRoleDashboardConfig_${currIndex}" name="addRoleDashboardConfig_${currIndex}" class="btn btn-icon btn-primary add-roles-dashboardId-config-btn" 
											onclick="customSystemSettingPortlet.saveRolesDashboardConfig.addRoleDashboardConfig();">
											Add<i class="fa fa-plus"></i> 
										</button>
										<button type="button" id="deleteRoleDashboardConfig_${currIndex}" name="deleteRoleDashboardConfig_${currIndex}" class="btn btn-icon btn-secondary delete-roles-dashboardId-config-btn" 
											onclick="customSystemSettingPortlet.saveRolesDashboardConfig.deleteRoleDashboardConfig(1);" style="display: none">
											Delete<i class="fa fa-minus"></i>
										</button>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
	    		</c:forEach>
			</div>
		</div>
		<div class="row btn-row">
			<div class="col-lg-12 col-md-12">
				<div class="form-group">
					<button type="button" class="btn btn-primary" id="saveBtn" name="saveBtn"><liferay-ui:message key="save" /></button>
					<a href="${cancelBtnURL}"><button type="button" class="btn btn-secondary" id="cancelBtn" name="cancelBtn"><liferay-ui:message key="cancel" /></button>
					</a>
				</div>
			</div>
		</div>
	</form>
</div>


<script type="text/javascript">
	$(document).ready(function () {
		var config = new Object({}),
			rolesDashboardConfigCntJEl = '#rolesDashboardConfigCnt',
			rolesDashboardConfigRow_1JEl = '#rolesDashboardConfigRow_1',
			rolesDashboardConfigRowLengthJEl = '#rolesDashboardConfigRowLength',
			saveBtnJEl = '#saveBtn',
			rolesDashboardConfigFormJEl = '#rolesDashboardConfigForm',
			deletedConfigIdsJEl='#deletedConfigIds';
		
		config.rolesDashboardConfigCntJEl = rolesDashboardConfigCntJEl;
		config.rolesDashboardConfigRow_1JEl = rolesDashboardConfigRow_1JEl;
		config.rolesDashboardConfigRowLengthJEl = rolesDashboardConfigRowLengthJEl;
		config.saveBtnJEl = saveBtnJEl;
		config.rolesDashboardConfigFormJEl = rolesDashboardConfigFormJEl;
		config.deletedConfigIdsJEl = deletedConfigIdsJEl;
		
		customSystemSettingPortlet.saveRolesDashboardConfig(config);
	 });
</script>