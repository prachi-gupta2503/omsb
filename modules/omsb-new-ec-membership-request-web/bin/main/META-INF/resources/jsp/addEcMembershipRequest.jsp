<%@ include file="../init.jsp"%>

<portlet:resourceURL id="/get/persons-data"
	var="getPersonsDataResourceURL" />
<portlet:resourceURL id="/get/dependent-data"
	var="getDependentDataResourceURLJEL" />	

<portlet:actionURL var="addEcMembershipRequestActionURL"  
	name="/save/ec-membership-request" />
	
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>



<!-- Inner Wrapper Contents -->

		<div class="omsb-card">
			<div class="omsb-page-top-info mb-4">
				<div class="pagetitle">
					<liferay-ui:message key="new-ec-membership-request" />
				</div>
			</div>
			<h4 class="omsb-card-title">
				<liferay-ui:message key="search-for-potential-ec-member" />
			</h4>
			<aui:form action="${addEcMembershipRequestActionURL}" method="post" name="addNewEcMemberRequest" 
				id="addNewEcMemberRequest" enctype="multipart/form-data">
				<div class="omsb-list-filter ">
					<aui:input type="hidden" id="<portlet:namespace />redirectURL"
						name="<portlet:namespace />redirectURL" value="${redirectURL}"></aui:input>
					<div class="row">
						<div class="col-lg-8 col-md-12 col-sm-12">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-12">
									<div class="form-group">
										<aui:input type="text" name="civilId" label="civil-id"
											id="civilId" class="form-control" />
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-12">
									<div class="form-group">
										<aui:input type="text" name="passportNo" label="passport-no"
											id="passportNo" class="form-control" />
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12">
									<p class="error" id="<portlet:namespace />civilIdPassportError"
										style="color: red; position: relative; margin-top: -10px;"><liferay-ui:message key="civilid-passport-number-required"/></p>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-12 col-sm-12">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12">
									<div class="form-group">
										<aui:input type="text" name="dateofbirth"
											label="date-of-birth" id="dateofbirth"
											placeholder="DD/MM/YYYY" class="form-control"
											readonly="readonly" />
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12">
									<p class="error" id="<portlet:namespace />dobError"
										style="color: red; position: relative; margin-top: -10px;"><liferay-ui:message key="date-of-birth-required"/></p>
								</div>
							</div>
						</div>
					</div>

					<div class="filter-button-wrap">
						<button class="btn omsb-bc-red-button m-0" type="button"
							id="<portlet:namespace />searchPersonsBtn">
							<liferay-ui:message key="search" />
						</button>
					</div>
				</div>
				<div class="omsb-list-view table-responsive">
					<table class="display omsb-datatables" id="personsDatatable">
						<thead>
							<tr>
								<th><liferay-ui:message key="name" /></th>
								<th><liferay-ui:message key="dob" /></th>
								<th><liferay-ui:message key="email" /></th>
								<th class="no_sorting"><liferay-ui:message key="action" />
								</th>
							</tr>
						</thead>
						<tbody id="personsDatatableBody">
							
						</tbody>
					</table>
				</div>
				<div class="row mt-4">
					<aui:input type="hidden" name="personId" id="personId"/>
					<div class="col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:select name="programName" id="programName" class="form-control" label="program-name">
								<aui:validator name="required"></aui:validator>
								<option value="">select</option>
								<c:forEach items="${programList}" var="program">
									<option value="${program.programMasterId}">${program.programName}</option>
								</c:forEach>
							</aui:select>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:select name="trainingSite" id="trainingSite" class="form-control" label="training-site-detail">
								<aui:validator name="required"></aui:validator>
							</aui:select>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 col-xs-12">
						<div class="form-group">
							<aui:select name="rotation" id="rotation" class="form-control" label="rotation">
							<aui:validator name="required"></aui:validator>
							</aui:select>
						</div>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="form-group">
							<aui:select name="membershipRole" id="membershipRole" class="form-control" label="membership-role">
							<aui:validator name="required"></aui:validator>
								<option value="">select</option>
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
							<div class="custom-file mb-3">
								<aui:input id="coveringLetter" label="covering-letter" name="coveringLetter" type="file">
									<aui:validator name="required"></aui:validator>
									<aui:validator name="acceptFiles">'pdf,docx,doc'</aui:validator>
								</aui:input>
								<label class="custom-file-label" for="<portlet:namespace/>coveringLetter"></label>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="form-group">
							<div class="custom-file mb-3">
								<aui:input id="curriculamVitae" label="curriculam-vitae" name="curriculamVitae" type="file">
									<aui:validator name="required"></aui:validator>
									<aui:validator name="acceptFiles">'pdf,docx,doc'</aui:validator>
								</aui:input>
								<label class="custom-file-label" for="<portlet:namespace/>curriculamVitae"></label>
							</div>
						</div>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="form-group">
							<label> <liferay-ui:message key="comments" />
							</label>
							<textarea name="<portlet:namespace />comments" class="form-control" id="comments"></textarea>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap mt-4">
					<button class="btn omsb-bc-red-button" type="submit"
						title="Create Request" id="submitBtn">
						<liferay-ui:message key="create-request" />
					</button>
					<a class="btn omsb-btn btn-back" href="#"> <i
						class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="cancel" />
					</a>
				</div>
			</aui:form>
			<!-- ignore code -->
			<!-- <div class="bottom-backbtn-wrap mt-4">
				<button class="btn omsb-bc-red-button" type="button"
					title="Create Request " data-toggle="modal"
					data-target="#adj_ec_mem_detail">Popup- Adjudicate EC
					Membership Request</button>
				<button class="btn omsb-bc-red-button" type="button"
					title="Create Request " data-toggle="modal"
					data-target="#adj_ec_mem_gme_detail">Popup- Adjudicate EC
					Membership Request : GME</button>
			</div> -->
			<!-- ignore code -->
		</div>
<!--// Inner Wrapper Contents -->

<script type="text/javascript">
$(document).ready(function () {
 var config = new Object({}),
	namespace = '<portlet:namespace />',
	civilIdJEL = '#' + namespace + 'civilId',
	passportNoJEL = '#' + namespace + 'passportNo',
	dateofbirthJEL = '#' + namespace + 'dateofbirth',
	personIdJEL = '#' + namespace + 'personId',
	personsDatatableJEL = '#personsDatatable',
	searchPersonsBtnJEL = '#' + namespace + 'searchPersonsBtn',
	programNameJEL = '#' + namespace + 'programName',
	trainingSiteJEL = '#' + namespace + 'trainingSite',
	rotationJEL = '#' + namespace + 'rotation',
	membershipRoleJEL = '#' + namespace + 'membershipRole',
	coveringLetterJEL = '#' + namespace + 'coveringLetter',
	curriculamVitaeJEL = '#' + namespace + 'curriculamVitae',
	civilIdPassportErrorJEL = '#' + namespace + 'civilIdPassportError',
	dobErrorJEL = '#' + namespace + 'dobError';
	addNewEcMemberRequestJEL = '#' + namespace + 'addNewEcMemberRequest',
	getPersonsDataResourceURLJEL = '${getPersonsDataResourceURL}',
	submitBtnJEL = '#' + 'submitBtn',
	getDependentDataResourceURLJEL = '${getDependentDataResourceURLJEL}';
	
	config.namespace = namespace;
	config.civilIdJEL = civilIdJEL;
	config.passportNoJEL = passportNoJEL;
	config.dateofbirthJEL = dateofbirthJEL;
	config.personIdJEL = personIdJEL;
	config.personsDatatableJEL = personsDatatableJEL;
	config.searchPersonsBtnJEL = searchPersonsBtnJEL;
	config.programNameJEL = programNameJEL;
	config.trainingSiteJEL = trainingSiteJEL;
	config.rotationJEL = rotationJEL;
	config.membershipRoleJEL = membershipRoleJEL;
	config.coveringLetterJEL = coveringLetterJEL;
	config.curriculamVitaeJEL = curriculamVitaeJEL;
	config.civilIdPassportErrorJEL = civilIdPassportErrorJEL;
	config.dobErrorJEL = dobErrorJEL;
	config.getPersonsDataResourceURLJEL = getPersonsDataResourceURLJEL;
	config.addNewEcMemberRequestJEL = addNewEcMemberRequestJEL;
	config.getDependentDataResourceURLJEL = getDependentDataResourceURLJEL;
	config.submitBtnJEL = submitBtnJEL;
	
	ecmrPortlet.renderECMR(config);

});
</script>