<%@ include file="../../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-ui:error key="setCertificationMasterFormError"
	message="certification-master-error" />

<portlet:actionURL
	name="<%=MVCCommandNames.SAVE_CERTIFICATION_MASTER_MVC_ACTION_COMMAND%>"
	var="saveCertificationMasterActionURL">
</portlet:actionURL>

<div class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card ">
				
				<aui:form action="${saveCertificationMasterActionURL}" name="fm"
					method="post">
					<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control"
								label="certificate-category" id="certificateCategory"
								name="certificateCategory">
								<aui:option value="" selected="true" disabled="true"
									cssClass="placeholder">
									<liferay-ui:message key="please-select-category" />
								</aui:option>
								<c:forEach items="${listCategories}" var="category">
									<c:choose>
										<c:when test="${themeDisplay.getLocale() =='en_US'}">
											<aui:option value="${category.id}">${category.nameEnglish}</aui:option>
										</c:when>
										<c:otherwise>
											<aui:option value="${category.id}">${category.nameArabic}</aui:option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>

					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:input label="certificate-title" id="certificateTitle"
								name="certificateTitle" type="text">
								<aui:validator name="required" />
							</aui:input>
						</div>
					</div>

					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:input label="certificate-description"
								name="certificateDescription" type="textarea">
								<aui:validator name="required" />
							</aui:input>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<div class="bottom-backbtn-wrap m-0">
								<button class="btn omsb-bc-red-button" type="submit"
									title="Save">
									<liferay-ui:message key="save" />
								</button>
								<portlet:renderURL var="OCTHomeURL">
										<portlet:param name="mvcRenderCommandName" value="/" />
									</portlet:renderURL>
									<a class="btn omsb-btn btn-back" href="${OCTHomeURL }"><i
										class="fi fi-sr-arrow-left"></i>
									<liferay-ui:message key="back" /></a>
							</div>
						</div>
					</div>
				</div>
				
				</aui:form>
			</div>
		</div>
	</div>
</div>
