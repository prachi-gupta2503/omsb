<%@ include file="../../init.jsp"%>

<div class="main-content id-box" style="margin-top: 0px;">
	<div class="omsb-main-wrapper" id="omsb-main-wrapper">
		<div class=" row bg-white">
			<div class="col-12 login-right">
				<div class="omsb-card reg_page_center">
				<div class="omsb-pre-login header">
					<div>
							<img alt="" src="<%=themeDisplay.getPathThemeImages() %>/svg/logo.svg">
						</div>
						<div>
							<p class="logo-text-arabic"><liferay-ui:message key="oman-medical-specialty-board-arabic"/>
							</p>
							<p class="logo-text-english"><liferay-ui:message key="oman-medical-specialty-board" /></p>
						</div>
				</div>
					<div class="thankyou-info">
					
						<div class="omsb-card m-0">
						<c:if test="${!userAlreadyExist}">
							<div class="omsb-page-top-info mb-4">
								<div class="pagetitle m-0"><liferay-ui:message key="thank-you-for-registering" /></div>
							</div>
								</c:if>
							<div class="page-information">
								<label class="reg-form-section-title"><liferay-ui:message key="${!userAlreadyExist?'thank-you-message':'user-already-exist-message'}" /></label>
							</div>
						</div>
					
						<div class="page-links">
							<a href="/login" class="download-link" title="<liferay-ui:message key="click-here-for-login-page" />"><liferay-ui:message key="click-here-for-login-page" /></a>
							<%-- <a href="/" class="download-link" title="<liferay-ui:message key="click-here-to-go-back-to-home-page" />"><liferay-ui:message key="click-here-to-go-back-to-home-page" /></a> --%>
						</div> 
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<liferay-ui:success key="success-role-service" message="role-service-successfully-added" />