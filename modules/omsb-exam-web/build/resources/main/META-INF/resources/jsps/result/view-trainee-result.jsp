<%@ include file="../../init.jsp"%>

<portlet:resourceURL id="<%=MVCCommands.DOWNLOAD_RESULT%>" var="downloadExamResultExcelURL">
	<portlet:param name="cmd" value="downloadResultExcel" />
	
	<portlet:param name="examReferenceId" value="${examResult.examScheduleId}" />
	<portlet:param name="omsbId" value="${examResult.lrUserId}" />
	<portlet:param name="programName" value="${examResult.programName}" />
	<portlet:param name="examType" value="${examResult.examType}" />
	<portlet:param name="result" value="${examResult.result}" />
	<portlet:param name="percentage" value="${examResult.percentage}" />
</portlet:resourceURL>

<div class="omsb-card">
	<div class="omsb-page-top-info m-0">
		<div class="pagetitle">
			<liferay-ui:message key="applicant-view-result" />
		</div>
	</div>
	<div class="row m-0">
		<div class="col-lg-6 col-md-6 col-sm-12 label-box">
			<label class="label-name"><liferay-ui:message
					key="exam-refrence-number" /> </label> <label class="label-content">${examResult.examScheduleId}</label>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12 label-box">
			<label class="label-name"><liferay-ui:message key="omsb-id" />
			</label> <label class="label-content">${examResult.lrUserId}</label>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12 label-box">
			<label class="label-name"><liferay-ui:message
					key="program-name" /> </label> <label class="label-content">${examResult.programName}</label>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12 label-box">
			<label class="label-name"><liferay-ui:message key="exam-type" />
			</label> <label class="label-content">${examResult.examType}</label>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12 label-box">
			<label class="label-name"><liferay-ui:message
					key="final-result" /> </label> <label class="label-content">${examResult.result}</label>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12 label-box">
			<label class="label-name"><liferay-ui:message
					key="percentage" /> </label> <label class="label-content">${examResult.percentage}</label>
		</div>
	</div>
	<portlet:renderURL var="backURL">
		<portlet:param name="mvcRenderCommandName" value="/" />
	</portlet:renderURL>
	<div class="bottom-backbtn-wrap">
				<a class="btn omsb-btn btn-back" href="${backURL}"><i
					class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
		<a href="<%=downloadExamResultExcelURL%>"><button
				class="btn omsb-bc-red-button">
				<liferay-ui:message key="download-result" />
			</button></a>
	</div>
</div>