<%@ include file="../../init.jsp"%>

<div class="main-content id-box" >
	<div class="omsb-main-wrapper" id="omsb-main-wrapper">
		<div class=" row bg-white">
			<div class="col-12 login-right">
				<div class="omsb-card ">
				<div class="omsb-pre-login header">
					<div>
						 <img alt="" src="<%=themeDisplay.getPathThemeImages() %>/svg/logo.svg">
				    </div>
				    <div>
						 <p class="logo-text-arabic"><liferay-ui:message key="oman-medical-specialty-board-arabic"/></p>
						 <p class="logo-text-english"><liferay-ui:message key="oman-medical-specialty-board" /></p>
				    </div>
				</div>
					<div class="Id-forms">
						<div class="omsb-page-top-info m-4">
							<div class="pagetitle"><liferay-ui:message key="new-password" /></div>
						</div>
						<liferay-portlet:actionURL name="<%=MVCCommands.SAVE_REGISTRATION_NEW_PASSWORD%>" var="saveNPURL" />
						<form action="${saveNPURL}" method="post" 
							name="<portlet:namespace/>npFM" id="npFM" autocomplete="off" >
							<div class="omsb-card" >
								<liferay-ui:error key="new-password-can-not-be-same-as-current-password" message="new-password-can-not-be-same-as-current-password" />
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="password" /></label>
									<input class="form-control" placeholder="<liferay-ui:message key="password" />" type="password" name="<portlet:namespace/>password" id="password" >
								</div>
								<p id="errorContainer-password" class="error-container"></p>
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="confirm-password" /></label>
									<input class="form-control" placeholder="<liferay-ui:message key="confirm-password" />" type="password" name="<portlet:namespace/>confirmPassword" id="confirmPassword" >
								</div>
								<p id="errorContainer-confirmPassword" class="error-container"></p>
							</div>
							<input type="hidden" name="<portlet:namespace/>userId" value="${userId}" >
							<div class="bottom-backbtn-wrap">
								<button type="button" onClick="validateAndSaveNewPassword()" class="btn omsb-bc-red-button" title="<liferay-ui:message key="save" />"><liferay-ui:message key="save" /></button>
								<a class="btn omsb-btn btn-back" href="#"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="Back" /></a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
function validateAndSaveNewPassword() {
	
	var errorMessages = [];
	var password = document.getElementById("password").value;
	if (!password) {
		errorMessages.push("<liferay-ui:message key='please-enter-password' />");
		document.getElementById("errorContainer-password").textContent = "<liferay-ui:message key='please-enter-password' />";
	} else {
		document.getElementById("errorContainer-password").textContent = "";
	}
	
	var confirmPassword = document.getElementById("confirmPassword").value;
	if (!confirmPassword) {
		errorMessages.push("<liferay-ui:message key='please-enter-confirm-password' />");
		document.getElementById("errorContainer-confirmPassword").textContent = "<liferay-ui:message key='please-enter-confirm-password' />";
	} else {
		document.getElementById("errorContainer-confirmPassword").textContent = "";
		if (password === confirmPassword) {
			document.getElementById("errorContainer-confirmPassword").textContent = "";
		} else {
			errorMessages.push("<liferay-ui:message key='confirm-password-does-not-match-with-password' />");
			document.getElementById("errorContainer-confirmPassword").textContent = "<liferay-ui:message key='confirm-password-does-not-match-with-password' />";
		}
	}
	
	if (errorMessages.length > 0) {
		event.preventDefault();
	} else {
		document.getElementById("npFM").submit();
	}
}
</script>