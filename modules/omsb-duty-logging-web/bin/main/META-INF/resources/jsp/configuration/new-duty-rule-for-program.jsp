<%@page import="gov.omsb.duty.logging.web.constants.MVCCommandNames"%>
<%@ include file="../../init.jsp"%>

<portlet:resourceURL id="<%=MVCCommandNames.ADD_PROGRAM_DUTY_RULE%>"
	var="addProgramDutyRulesResourceURL" />
<portlet:resourceURL id="getMasterData" var="getProgramCohortURL">
	<portlet:param name="cmd" value="Cohort" />
</portlet:resourceURL>
<portlet:resourceURL id="getMasterData"
	var="getDutyRuleMVCResourceCommandURL">
	<portlet:param name="cmd" value="DutyRules" />
</portlet:resourceURL>

<style>
.duty-type-rule {
	font-weight: 600;
	font-size: 14px;
	line-height: 20px;
	
}
.duty-rule-radio{
	text-indent: 12px;
}
.duty-type-rule input[type="checkbox"], .duty-type-rule input[type="radio"] {
  margin-right: 10px; 
  vertical-align: middle; 
  width: 17px;
  height:17px;
}
.duty-type-rule input{
	margin:5px;
}

</style>

<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info">
				<div class="pagetitle">
					<!-- Add Program Duty Rules -->
				</div>
			</div>
			<aui:form action="#" name="programDutyTypeRules" method="post">
				<div class="omsb-list-filter pb-2">
					<div class="row">
						<div class="col-lg-6 col-md-6">
							<div class="form-group">
								<aui:select type="text" name="programMasterId"
									id="programMasterId" class="form-control"
									label="duty-logging-configuration-program">
									<aui:option value="">
										<liferay-ui:message key="duty-logging-configuration-select" />
									</aui:option>
									<c:forEach var="programMaster" items="${programMasterList}">
										<aui:option value="${programMaster.id}">${programMaster.name}</aui:option>
									</c:forEach>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</div>
						<div class="col-lg-6 col-md-6">
							<div class="form-group">
								<aui:select type="text" name="cohortId" id="cohortId"
									class="form-control" label="duty-logging-configuration-cohort">
									<aui:option>
										<liferay-ui:message key="duty-logging-configuration-select" />
									</aui:option>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</div>
						<div class=" col-lg-6 col-md-6" style="padding-left: 29px;">
							<div class="row duty-type-rule form-group">
								<c:forEach items="${dutyRuleList}" var="dutyRule">
									<c:choose>
										<c:when test="${empty dutyRule.options}">
											<aui:input id="${dutyRule.id}" type="checkbox"
												name="programDutyRules" label="${dutyRule.name}"
												value="${dutyRule.id}" />

										</c:when>
										<c:otherwise>
											<aui:input id="${dutyRule.id}" type="checkbox"
												name="programDutyRules" label="${dutyRule.name}"
												value="${dutyRule.id}" disabled ="true"/>
											<div class = "duty-rule-radio">
												<c:forEach items="${dutyRule.options}" var="cDutyRule">
													<aui:input id="${cDutyRule.name }" name="programDutyRules"
														type="radio" label="${cDutyRule.name}"
														value="${cDutyRule.id}"></aui:input>
												</c:forEach>
											</div>
									</c:otherwise>
									</c:choose>
								</c:forEach>
							</div>
								<small id="check-box-error-msg" style="display: none; color: red;"><liferay-ui:message
											key="duty-logging-configuration-atleast-one-checkbox" /></small>
						</div>						
					</div>
				</div>
				<div class="bottom-backbtn-wrap mt-2 mb-4">
					<button class="btn omsb-bc-red-button" type="button"
						title="Announce" onclick="submitProgramDutyRules()">
						<liferay-ui:message key="duty-logging-configuration-submit" />
					</button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						onclick="resetForm('programDutyTypeRules')" data-dismiss="modal">
						<liferay-ui:message key="duty-logging-configuration-cancel-button" />
					</button>
				</div>
			</aui:form>
<script type="text/javascript">
	function submitProgramDutyRules(){
		if(validateForm('<portlet:namespace/>programDutyTypeRules')){
	        var form= $('#<portlet:namespace/>programDutyTypeRules')[0];
			var formdata = new FormData(form);
	        var url = '<%=addProgramDutyRulesResourceURL.toString()%>';
	        console.log("url"+url);
			$.ajax({
				type : "post",
				url : url,
				data : formdata,
				contentType : false,
				cache : false,
				processData : false,
			}).done(function(response) {
				/* $("#<portlet:namespace/>programDutyTypeRules").trigger("reset"); */
				 location.reload();
					}).fail(function(error) {
						console.log("Error in saving program duty rules");
			})
			}
			else {
				return false;	
			}	
			
		}
//function for validate form 
function validateForm(programDutyTypeRules){
	var programDutyTypeRule= Liferay.Form.get(programDutyTypeRules);
		if(programDutyTypeRule){
			var validator = programDutyTypeRule.formValidator;
			 validator.validate();
			 var hasErrors = validator.hasErrors();
			 if(hasErrors){
				 validator.focusInvalidField();
				 return false;
				 }
			 else if(!validate_form()){
				 return false;
			 }	 
		}
		return true;
	}
	
function validate_form(){
	valid = true;
	var checkBox= $('input[type=checkbox]:checked').length ;
	var radio= $('input[type=radio]:checked').length ;
	if(checkBox == 0 && radio==0)
	{
		$("#check-box-error-msg").css("display", "block");
	    valid = false;
	}
	return valid;
}
var programMasterId ;
/* master data of cohort*/
$('#<portlet:namespace/>programMasterId').change(function(){
	 programMasterId=$('#<portlet:namespace/>programMasterId').val();
	$("#<portlet:namespace />cohortId").empty();
	var url = '<%=getProgramCohortURL.toString()%>';
	$.ajax({
		type : "GET",
		url : url+"&<portlet:namespace/>programMasterId="+programMasterId,
		contentType: "application/json",
		success: function(cohorts) {
			$("#<portlet:namespace/>cohortId").append(new Option("Select",""));
               $.each(JSON.parse(cohorts), function( index, cohort ){
               	$("#<portlet:namespace/>cohortId").append(new Option(cohort.ayApplicableForm,cohort.progDurationId));
               });
               
           },
	});
});
	
$("#<portlet:namespace/>cohortId").change(function(){
	var cohortId = $('#<portlet:namespace/>cohortId').val();
	var ruleIds = [];
	var url = '<%=getDutyRuleMVCResourceCommandURL.toString()%>';
	$.ajax({
		type : "GET",
		url : url+ "&<portlet:namespace/>programMasterId="+ programMasterId+ "&<portlet:namespace/>cohortId="+ cohortId,
		contentType : "application/json",
		success : function(response) {
				$.each(JSON.parse(response),function(index,dutyRule) {
					ruleIds.push(dutyRule.dutyRuleId);
				});
				selectedDutyRules(ruleIds);
				},
	});
})

function selectedDutyRules(ruleIds) {
	var checkboxName = "<portlet:namespace/>programDutyRules";
	var checkboxes = $("input[name='" + checkboxName + "']");
	for (var i = 0; i < checkboxes.length; i++) {
		var checkbox = checkboxes[i];
		checkbox.checked = false;
		var value = checkbox.value;
		if (ruleIds.includes(value)) {
			checkbox.checked = true;
		}
	}
}
/* var radioButtonName = "<portlet:namespace/>programDutyRules";
var radioButtons = $("input[name='" + radioButtonName + "']");
for (var i = 0; i < radioButtons.length; i++) {
	console.log("radioButtons"+radioButtons);
	radioButtons.each(function() {
		  $(this).click(function() {
		    if ($(this).prop('checked')) {
		      $(this).prop('checked', false);
		    }
		  });

});
} */

/* For reset duty Types  */
function resetForm(form) {
	$("#<portlet:namespace/>" + form).trigger("reset");
}
</script>