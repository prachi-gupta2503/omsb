<%@ include file="../init.jsp"%>
<style>
.ec-request-file .has-error .form-feedback-item {
	position: absolute !important;
	margin-top: 9% !important;
}
</style>
<portlet:resourceURL id="/get/persons-data"
	var="getPersonsDataResourceURL" />
<portlet:resourceURL id="/get/dependent-data"
	var="getDependentDataResourceURLJEL" />
<portlet:resourceURL id="/send/register-invite-email"
	var="sendRegisterInviteEmailResourceURL" />

<portlet:actionURL var="addEcMembershipRequestActionURL"
	name="/save/ec-membership-request" />

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<portlet:resourceURL id="getAffiliationData"
	var="getPersonsRelatedDataResourceURL" />
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>



<!-- Inner Wrapper Contents -->

<div class="omsb-card">
	<div class="omsb-page-top-info mb-4">
		<div class="pagetitle">
			<liferay-ui:message key="ec-member-request-new-membership-request" />
		</div>
	</div>
	<h4 class="omsb-card-title">
		<liferay-ui:message key="ec-member-request-search-for-potential-member" />
	</h4>
	<aui:input name="ecMemberRequestId" type="hidden" id=""></aui:input>
	<aui:form action="" method="post" name="searchPersonForm"
		id="searchPersonForm" enctype="multipart/form-data">
		<div class="omsb-list-filter p-0">
			<aui:input type="hidden" id="redirectURL" name="redirectURL"
				value="${redirectURL}"></aui:input>
			<div class="row">
				<div class="col-lg-4 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:input type="text" name="name" label="ec-member-request-name" id="name"
							class="form-control">
							<aui:validator name="required"></aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:input type="text" name="email" label="ec-member-request-email" id="email"
							class="form-control">
							<aui:validator name="required"></aui:validator>
							<aui:validator name="custom"
											errorMessage="Please enter valid Email ID">
											function(val){
											console.log("val---"+val);
												var regex=new RegExp(/^\w+@[a-zA-Z_]+?\.[a-zA-Z]+$/);
												return regex.test(val);
											}
							</aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:input type="text" name="civilId" label="ec-member-request-civil-id"
							id="civilId" class="form-control" />
					</div>
				</div>
			</div>
			<div class="filter-button-wrap">
				<button class="btn omsb-bc-red-button m-0" type="button"
					id="<portlet:namespace />searchPersonsBtn">
					<liferay-ui:message key="ec-member-request-search" />
				</button>
			</div>
		</div>
	</aui:form>
	
	<div class="row" id="<portlet:namespace />emailIdRecordMessage">
		<div class="col-md-12">
			<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
				<p class="m-0">
					<liferay-ui:message key="ec-member-request-record-found-with-mail" />
				</p>
			</div>
		</div>
	</div>
	<div class="row" id="<portlet:namespace />noRecordMessage">
		<div class="col-md-12">
			<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
				<p class="m-0 d-flex justify-content-between align-items-center">
					<liferay-ui:message key="ec-member-request-no-record-found" />
					<button class="btn omsb-bg-red-button m-0" type="button"
						id="<portlet:namespace/>invitePersonBtn"><liferay-ui:message key="ec-member-request-invite" /></button>
				</p>
			</div>
		</div>
	</div>
	<div class="omsb-list-view table-responsive" id="personsDatatableDiv">
		<table class="display omsb-datatables" id="personsDatatable">
			<thead>
				<tr>
					<th class="no_sorting"><liferay-ui:message key="ec-member-request-name" /></th>
					<th class="no_sorting"><liferay-ui:message key="ec-member-request-dob" /></th>
					<th class="no_sorting"><liferay-ui:message key="ec-member-request-email" /></th>
					<th class="no_sorting"><liferay-ui:message key="ec-member-request-action" /></th>
				</tr>
			</thead>
			<tbody id="personsDatatableBody">

			</tbody>
		</table>
	</div>
	<div class="bottom-backbtn-wrap mt-4" id="cancelButton">
				<a class="btn omsb-btn btn-back" href="${backURL}"> <i
					class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="ec-member-request-back" />
				</a>
			</div>
	
	<aui:form action="${addEcMembershipRequestActionURL}" method="post"
		name="addNewEcMemberRequest" id="addNewEcMemberRequest"
		enctype="multipart/form-data">
		<div id="ecRequestFormDiv">

			<div class="row">
				<div class="col-md-6 col-sm-12">
					<div class="omsb-list-view table-responsive"
						id="personsAffiliationDatatableDiv" style="display:none;">
						<h4 class="omsb-card-title pt-3"><liferay-ui:message key="ec-member-request-existing-affiliation"/></h4>
						<table class="display table table-bordered"
							id="personsAffiliationDatatable">
							<thead>
								<tr>
									<th style="text-align: center; background: #f0f8ff"><liferay-ui:message
											key="ec-member-request-program" /></th>
									<th style="text-align: center; background: #f0f8ff"><liferay-ui:message
											key="ec-member-request-role" /></th>
									<th style="text-align: center; background: #f0f8ff"><liferay-ui:message
											key="ec-member-request-status" /></th>
								</tr>
							</thead>
							<tbody id="personsAffiliationDatatableBody">

							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="row mt-4">
				<aui:input type="hidden" name="personId" id="personId" />
				<aui:input type="hidden" name="lrUserId" id="lrUserId" />
				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="form-group">
						<aui:select name="programName" id="programName"
							class="form-control" label="ec-member-request-program-name">
							<aui:validator name="required"></aui:validator>
							<option value=""><liferay-ui:message key="ec-member-request-select"/></option>
							<c:forEach items="${programList}" var="program">
								<option value="${program.programMasterId}">${program.programName}</option>
							</c:forEach>
						</aui:select>
					</div>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="form-group">
						<aui:select name="membershipRole" id="membershipRole"
							class="form-control" label="ec-member-request-membership-role">
							<aui:validator name="required"></aui:validator>
							<option value=""><liferay-ui:message key="ec-member-request-select"/></option>
							<c:forEach items="${roleList}" var="role">
								<option value="${role.roleId}">${role.name}</option>
							</c:forEach>
						</aui:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="form-group">
						<div class="custom-file ec-request-file">
							<aui:input id="coveringLetter" label="ec-member-request-covering-letter"
								name="coveringLetter" type="file">
								<aui:validator name="required"></aui:validator>
								<aui:validator name="acceptFiles">'pdf,docx,doc'</aui:validator>
							</aui:input>
							<label class="custom-file-label"
								for="<portlet:namespace/>coveringLetter"></label>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="form-group">
						<div class="custom-file ec-request-file mb-3">
							<aui:input id="curriculamVitae" label="ec-member-request-curriculam-vitae"
								name="curriculamVitae" type="file">
								<aui:validator name="required"></aui:validator>
								<aui:validator name="acceptFiles">'pdf,docx,doc'</aui:validator>
							</aui:input>
							<label class="custom-file-label"
								for="<portlet:namespace/>curriculamVitae"></label>
						</div>
					</div>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<%-- <label> <liferay-ui:message key="comments" />
									</label> --%>
					<aui:input name="comments" id="comments" type="textarea">
						<aui:validator name="maxLength">450</aui:validator>
					</aui:input>
					<%-- <textarea name="<portlet:namespace />" class="form-control" id="comments"></textarea> --%>
				</div>
			</div>
			<div class="bottom-backbtn-wrap mt-4">
				<button class="btn omsb-bc-red-button" type="submit" data-target="#personAlreadyMap"
					title="Create Request" id="submitBtn">
					<liferay-ui:message key="ec-member-request-create-request" />
				</button>
				<a class="btn omsb-btn btn-back" href="${backURL}"> <i
					class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="ec-member-request-back" />
				</a>
			</div>


		</div>
	</aui:form>
	
</div>


<button class="btn omsb-bg-red-button mb-5" data-toggle="modal"
	data-target="#inviteSent" id="inviteSentBtn" type="button"
	hidden="true"></button>

<div class="modal fade omsb-modal" id="inviteSent" tabindex="-1"
	role="dialog" aria-labelledby="inviteSentTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document"
		style="max-width: 480px;">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="ec-member-request-invite-pop-up-title"/></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p class="m-0"><liferay-ui:message key="ec-member-request-invitation-popup-for-register"/></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal"><liferay-ui:message key="ec-member-request-popup-ok-button"/></button>
			</div>
		</div>
	</div>
</div>
<!--// Inner Wrapper Contents -->

<div class="modal fade omsb-modal" id="personAlreadyMap" tabindex="-1"
	role="dialog" aria-labelledby="personAlreadyMapTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document"
		style="max-width: 480px;">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="ec-member-request-person-already-map-title"/></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p id="popupMessage"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal"><liferay-ui:message key="ec-member-request-popup-ok-button"/></button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						var config = new Object({}), namespace = '<portlet:namespace />', civilIdJEL = '#'
								+ namespace + 'civilId', emailJEL = '#'
								+ namespace + 'email', nameJEL = '#'
								+ namespace + 'name', personIdJEL = '#'
								+ namespace + 'personId', lrUserIdJEL = '#'
								+ namespace + 'lrUserId', personsDatatableJEL = '#personsDatatable', searchPersonsBtnJEL = '#'
								+ namespace + 'searchPersonsBtn', programNameJEL = '#'
								+ namespace + 'programName', trainingSiteJEL = '#'
								+ namespace + 'trainingSite', rotationJEL = '#'
								+ namespace + 'rotation', membershipRoleJEL = '#'
								+ namespace + 'membershipRole', coveringLetterJEL = '#'
								+ namespace + 'coveringLetter', curriculamVitaeJEL = '#'
								+ namespace + 'curriculamVitae', civilIdPassportErrorJEL = '#'
								+ namespace + 'civilIdPassportError', dobErrorJEL = '#'
								+ namespace + 'dobError';
								addNewEcMemberRequestJEL = '#' + namespace
										+ 'addNewEcMemberRequest',
								getPersonsDataResourceURLJEL = '${getPersonsDataResourceURL}',
								getPersonsRelatedDataResourceURL = '${getPersonsRelatedDataResourceURL}',
								submitBtnJEL = '#' + 'submitBtn',
								searchPersonFormJEL = '#' + namespace
										+ 'searchPersonForm',
								emailIdRecordMessageJEL = '#' + namespace
										+ 'emailIdRecordMessage',
								noRecordMessageJEL = '#' + namespace
										+ 'noRecordMessage',
								invitePersonBtnJEL = '#' + namespace
										+ 'invitePersonBtn',
								personsDatatableDivJEL = '#'
										+ 'personsDatatableDiv',
								ecRequestFormDivJEL = '#' + 'ecRequestFormDiv',
								sendRegisterInviteEmailResourceURLJEL = '${sendRegisterInviteEmailResourceURL}',
								getDependentDataResourceURLJEL = '${getDependentDataResourceURLJEL}',
								cancelButton = '#' + 'cancelButton';
								popupMessage = '#' + 'popupMessage';
								
						config.namespace = namespace;
						config.civilIdJEL = civilIdJEL;
						config.nameJEL = nameJEL;
						config.emailJEL = emailJEL;
						config.personIdJEL = personIdJEL;
						config.lrUserIdJEL = lrUserIdJEL;
						config.personsDatatableJEL = personsDatatableJEL;
						config.searchPersonsBtnJEL = searchPersonsBtnJEL;
						config.programNameJEL = programNameJEL;
						config.trainingSiteJEL = trainingSiteJEL;
						config.rotationJEL = rotationJEL;
						config.membershipRoleJEL = membershipRoleJEL;
						config.coveringLetterJEL = coveringLetterJEL;
						config.curriculamVitaeJEL = curriculamVitaeJEL;
						config.invitePersonBtnJEL = invitePersonBtnJEL;
						config.civilIdPassportErrorJEL = civilIdPassportErrorJEL;
						config.dobErrorJEL = dobErrorJEL;
						config.ecRequestFormDivJEL = ecRequestFormDivJEL;
						config.searchPersonFormJEL = searchPersonFormJEL;
						config.personsDatatableDivJEL = personsDatatableDivJEL;
						config.getPersonsDataResourceURLJEL = getPersonsDataResourceURLJEL;
						config.addNewEcMemberRequestJEL = addNewEcMemberRequestJEL;
						config.emailIdRecordMessageJEL = emailIdRecordMessageJEL;
						config.noRecordMessageJEL = noRecordMessageJEL;
						config.getDependentDataResourceURLJEL = getDependentDataResourceURLJEL;
						config.sendRegisterInviteEmailResourceURLJEL = sendRegisterInviteEmailResourceURLJEL;
						config.submitBtnJEL = submitBtnJEL;
						config.getPersonsRelatedDataResourceURL = getPersonsRelatedDataResourceURL;
						config.cancelButton = cancelButton;
						config.popupMessage = popupMessage;
						config.msgExistingEcRequestActiveStatus = '<liferay-ui:message key="ec-member-request-person-mapped-with-program" />';
						config.msgExistingEcRequestInProcessStatus = "<liferay-ui:message key="ec-member-request-person-request-inprocess" />";
						ecmrPortlet.renderECMR(config);

					});
</script>