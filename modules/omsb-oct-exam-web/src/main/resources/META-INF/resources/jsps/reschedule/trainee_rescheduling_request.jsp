
<%@ include file="../../init.jsp"%>
<portlet:actionURL var="rescheduleRequestURL"
	name="<%=MVCCommandNames.SAVE_RESCHEDULE_REQUEST_ACTION%>"></portlet:actionURL>
<form action="${rescheduleRequestURL }" method="post" name="">
	<input type="hidden" value="${examDefinitionId }" name="<portlet:namespace/>examDefinitionId">
	<input	type="hidden" name="<portlet:namespace/>supportingDocJson" id="<portlet:namespace/>supportingDocJson" >
	<input type="hidden" value="${examScheduleId }"	name="<portlet:namespace/>examScheduleId">
	<input type="hidden" value="${newExamScheduleId }"	name="<portlet:namespace/>newExamScheduleId">
	<input type="hidden" value="${examTitleId }"	name="<portlet:namespace/>examTitleId"> 
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
				<div class="omsb-page-top-info">
					<div class="pagetitle"><liferay-ui:message key="rescheduling-request"/></div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label><liferay-ui:message key="reason"/><span>*</span></label>
							<textarea class="textEditor1" name="<portlet:namespace/>comments"></textarea>
							<span class="d-none reschedule-reason"></span>
						</div>
					</div>
				</div>
				<div
					class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">
					<h4 class="omsb-card-title pb-3">
						<liferay-ui:message key="add-supporting-document"/>
						
						<!-- <button class="btn omsb-bg-red-button" data-toggle="modal"
						data-target="#adddocument" type="button">
						<img src="../images/svg/plus_img.svg" alt=""> Add Document
					</button> -->
						<button class="btn omsb-bg-red-button" data-toggle="modal"
							data-target="#addsupportingdocument" type="button">
							<img src="../images/svg/plus_img.svg" alt="">
							<liferay-ui:message key="add-row" />
						</button>
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables supporting-docs-add-row"
							id="supporting-documents-table">
							<thead>
								<tr>

									<th data-name="docTitle"><liferay-ui:message
											key="document-title" /></th>
									<th data-name="fileName"><liferay-ui:message
											key="supporting-document" /></th>
									<th data-name="file" class="d-none"><liferay-ui:message key="document-file"/></th>
									<th data-name="rowNumber" class="d-none"><liferay-ui:message key="row-number"/></th>
									<th data-name="actions"><liferay-ui:message key="action"/></th>
								</tr>
							</thead>
							<tbody>

							</tbody>
						</table>
					</div>
				</div>
				<div class="bottom-backbtn-wrap">
					<button class="btn omsb-bc-red-button" title="Save" onclick="saveSupportingDocs();"><liferay-ui:message key="save"/></button>
					<button class="btn omsb-bc-red-button" title="Discard"><liferay-ui:message key="discard"/></button>
					<a class="btn omsb-btn btn-back" href="#"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
				</div>

			</div>
		</div>
	</div>

	<%@include file="/jsps/supporting-docs-popup.jsp"%>
</form>	