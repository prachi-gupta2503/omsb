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
									<p class="logo-text-arabic"><liferay-ui:message key="oman-medical-specialty-board-arabic"/>
							</p>
							<p class="logo-text-english"><liferay-ui:message key="oman-medical-specialty-board" /></p>
								</div>
							</div>
				
					<div class="Id-forms ">
						<div class="omsb-card m-0">
							<div class="omsb-page-top-info mb-4">
								<div class="pagetitle"><liferay-ui:message key="identification-confirmation" /></div>
							</div>
							<label class="control-label"><liferay-ui:message key="no-existing-record-for-you" /></label>
						</div>
						<form name="id-confrim-registrant" class="login-wup">
							<div class="omsb-card">
								<h3 class="reg-form-title"><liferay-ui:message key="confirm-with-following-details-to-continue" /></h3>
								<div class="row">
								<c:if test="${not empty civilId}">
									<%-- <h3 class="reg-form-sub-title "><liferay-ui:message key="your-civil-id" /></h3> --%>
									<div class="form-group col-md-6 col-sm-6">
										<label class="control-label"><liferay-ui:message key="omani-civil-id-or-omani-resident-id" /></label>
										<input class="form-control" placeholder="<liferay-ui:message key="omani-civil-id-or-omani-resident-id" />" type="text" value="${civilId}" id="civilId" name="civilId" readonly>
									</div>
								</c:if>
								<c:if test="${not empty passportNumber}">
									<%-- <h3 class="reg-form-sub-title "><liferay-ui:message key="your-passport-number" /></h3> --%>
									<div class="form-group col-md-6 col-sm-6">
										<label class="control-label"><liferay-ui:message key="passport-number" /></label>
										<input class="form-control" placeholder="<liferay-ui:message key="passport-number" />" type="text" value="${passportNumber}" id="passportnumber" name="passportnumber" readonly>
									</div>
								</c:if>
								<c:if test="${not empty dateOfBirth}">
									<div class="form-group col-lg-6 col-sm-6">
										<label class="control-label"><liferay-ui:message key="date-of-birth" /></label>
										<input class="form-control datePicker" placeholder="<liferay-ui:message key="DD-MM-YYYY" />" type="text" value="${dateOfBirth}" name="dob" id="dob" readonly>
									</div>
								</c:if>
								</div>
							</div>
							<div class="bottom-backbtn-wrap">
								<portlet:renderURL var="viewPersonalDetailsURL">
									<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_REGISTRATION_PERSONAL_DETAILS%>" />
									<portlet:param name="civilId" value="${civilId}" />
									<portlet:param name="passportNumber" value="${passportNumber}" />
									<portlet:param name="dateOfBirth" value="${dateOfBirth}" />
									<portlet:param name="personId" value="${personId}" />
									<portlet:param name="countryId" value="${countryId}" />
									<portlet:param name="genderId" value="${genderId}" />
									<portlet:param name="fullName" value="${fullName}" />
									<portlet:param name="fullNameAr" value="${fullNameAr}" />
									<portlet:param name="mobileNo" value="${mobileNo}" />
									<portlet:param name="isPkiIdentified" value="${isPkiIdentified}" />
									<portlet:param name="omaniCountryId" value="${omaniCountryId}" />
								</portlet:renderURL>
								<a href="${viewPersonalDetailsURL}"><button class="btn omsb-bc-red-button" title="registration"><liferay-ui:message key="proceed-with-new-registration" /></button></a>
								<a class="btn omsb-btn omsb-bg-red-button" href="/registration" ><liferay-ui:message key="previous" /></a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>