<%@ include file="../../init.jsp"%>

<portlet:resourceURL id="<%=MVCCommandNames.DOWNLOAD_TRAINEE_RESULT%>" var="downloadTraineeResultURL">
	<portlet:param name="cmd" value="downloadTraineeResult" />
	<portlet:param name="referenceNumber" value="${examResult.oCExamScheduleId}" />
	<portlet:param name="omsbId" value="${examResult.lrUserId}" />
	<portlet:param name="percentage" value="${examResult.percentage}" />
	<portlet:param name="finalResult" value="${examResult.result}" />
	<portlet:param name="examTitle" value="${examResult.examtitle}" />
</portlet:resourceURL>


<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>


<div id="wrapper">
	<div class="container">
		<div class="omsb-card ">
				<div class="reg_step1" id="reg_step1">
					<div class="omsb-card m-0 p-0">
						<div class="omsb-page-top-info mb-4">
							<div class="pagetitle"><liferay-ui:message key="applicant-view-result" /></div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 label-box">
							<div class="label-name">
								<liferay-ui:message key="exam-title" />
							</div>
							<div class="label-content">${examResult.examtitle}</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 label-box">
							<div class="label-name">
								<liferay-ui:message key="exam-reference-number" />
							</div>
							<div class="label-content">${examResult.oCExamScheduleId}</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 label-box">
							<div class="label-name">
								<liferay-ui:message key="omsb-id" />
							</div>
							<div class="label-content">${examResult.lrUserId}</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 label-box">
							<div class="label-name">
								<liferay-ui:message key="final-result" />
							</div>
							<div class="label-content">${examResult.result}</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 label-box">
							<div class="label-name">
								<liferay-ui:message key="percentage" />
							</div>
							<div class="label-content">${examResult.percentage}</div>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap">
					<a href="<%=downloadTraineeResultURL%>">
						<button class="btn omsb-bc-red-button">
							<liferay-ui:message key="download-result" />
						</button>
					</a>
					
					<portlet:renderURL var="backURL">
					<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_OCT_RESULTS_LIST%>" />
				    </portlet:renderURL> 
					
					<a class="btn omsb-btn btn-back" href="${backURL}">
						<i class="fi fi-sr-arrow-left"></i>
						<liferay-ui:message key="back" />
				    </a>
				</div>
		</div>
	</div>
</div>