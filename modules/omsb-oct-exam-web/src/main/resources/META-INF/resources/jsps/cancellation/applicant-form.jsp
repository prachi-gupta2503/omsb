<%@include file = "../../init.jsp" %>
<portlet:actionURL var="applicantCancellationURL" name="<%=MVCCommandNames.SAVE_CANCELLATION_ACTION%>"></portlet:actionURL>


<portlet:renderURL var="cancelBackURL">
<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<form action="${applicantCancellationURL }" method="post" name="">
	<input type="hidden" value="${examScheduleId }" name="<portlet:namespace/>scheduleId" >
	<input type="hidden" value="${examTitleId }" name="<portlet:namespace/>examTitleId" > 
	<input type="hidden" name="<portlet:namespace/>supportingDocJson" id="<portlet:namespace/>supportingDocJson" class="d-none">
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
				<div class="omsb-page-top-info">
					<div class="pagetitle"> <liferay-ui:message key="cancellation-request"/></div>							
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label><liferay-ui:message key="reason"/><span>*</span></label>
							<textarea class="textEditor1" name="<portlet:namespace/>comments"></textarea>
							<span class="d-none cancellation-reason"></span>
						</div>
					</div>
					
				</div>
				<div class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">
					<h4 class="omsb-card-title"><liferay-ui:message key="add-supporting-document"/>
						<button class="btn omsb-bg-red-button" data-toggle="modal" data-target="#addsupportingdocument" type="button">
							<img src="../images/svg/plus_img.svg" alt="">
							<liferay-ui:message key="add-row"/>
						</button>
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables supporting-docs-add-row" id="supporting-documents-table">
							<thead>
								<tr>
									<th data-name="docTitle"><liferay-ui:message key="document-title"/></th>
									<th data-name="fileName"><liferay-ui:message key="supporting-document"/></th>
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
					<a class="btn omsb-btn btn-back" href="${cancelBackURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
				</div>
	
			</div>
		</div>
	</div>
		
	<!-- Supporting Document Popup -->
	
		<%@include file="/jsps/supporting-docs-popup.jsp" %>
		
	<!-- Supporting Document Popup Ends -->
		
</form>