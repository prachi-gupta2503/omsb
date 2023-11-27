<%@ include file="../../init.jsp"%>

<div class="omsb-list-view table-responsive" id="registrationHomeTable">
	<table class="display omsb-datatables" id="registration-list">
		<thead>
			<tr>
				<th><liferay-ui:message key="name" /></th>
				<th><liferay-ui:message key="created-on" /></th>
				<th><liferay-ui:message key="passport-no" /></th>
				<th><liferay-ui:message key="civil-id" /></th>
				<th><liferay-ui:message key="status" /></th>
				<th><liferay-ui:message key="action" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${registrationList}"
				var="registration">

				<portlet:renderURL var="editRegistrationDetailsURL">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommands.VIEW_ADMIN_EDIT_ROLE_SERVICE%>" />
					<portlet:param name="RegistrationId"
						value="${registration.getPersonId()}" />
				</portlet:renderURL>

				<portlet:renderURL var="viewRegistrationDetailsURL">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommands.ADMIN_VIEW_REGISTRATION%>" />
					<portlet:param name="personID"
						value="${registration.getPersonId()}" />
				</portlet:renderURL>

				<tr>
					<td>${registration.getPersonName()}</td>
					<td>${registration.getDateCreated()}</td>
					<td>${registration.getPassportNo()}</td>
					<td>${registration.getCivilId()}</td>
					<td><span class="${registration.getRegistrationStatusColor()}">${registration.getRegistrationStatus()}</span></td>
					<td>

						<div class="dropdown ">
							<button class="btn fa fa-ellipsis-v dropdown-toggle"
								type="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								<i class=""></i>
							</button>
							<ul class="dropdown-menu">
								<%-- <li><a href="${editRegistrationDetailsURL}"
									class="dropdown-item"><img
										src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-eye.svg">
										<liferay-ui:message key="edit" /></a></li> --%>
								<li><a href="${viewRegistrationDetailsURL}"
									class="dropdown-item"><img
										src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-eye.svg">
										<liferay-ui:message key="view" /></a></li>
								<li><a href="#" class="dropdown-item"><img
										src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-eye.svg">
										<liferay-ui:message key="approve-role" /></a></li>
								<li><a href="#" class="dropdown-item"><img
										src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-eye.svg">
										<liferay-ui:message key="verify-profile" /></a></li>
							</ul>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>

	$('#registration-list').DataTable({
		"bLengthChange" : false,
		"bFilter" : false,
		"order": []
	});
</script>