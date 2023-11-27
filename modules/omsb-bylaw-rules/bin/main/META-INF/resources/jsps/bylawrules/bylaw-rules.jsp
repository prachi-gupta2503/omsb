<%@page import="gov.omsb.bylaw.rules.constants.MVCCommands"%>
<%@ include file="../../init.jsp"%>	
<portlet:resourceURL id="<%=MVCCommands.GET_BYLAW_CONDITION%>" var="getByLawCondition" />	
<portlet:actionURL name="<%=MVCCommands.SAVE_BYLAW_RULE%>" var="saveByLawRule" />
<portlet:resourceURL id="<%=MVCCommands.DELETE_BYLAW_RULE%>" var="deleteByLawRule" />	


<portlet:renderURL var="ViewandAddlistofNewCondition">
<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.BY_LAW_CONDITION%>" />
</portlet:renderURL>

<div id="wrapper">
				<div class="container">
					<div class="omsb-card">
						<div class="omsb-page-top-info">
							
							
							<div class="information">
								<a href="${ViewandAddlistofNewCondition }" class="btn omsb-bc-red-button">Add New Condition</a>
							</div>
						</div>
                        
                        <div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 omsb-card-graybg-title">
						<form action="${saveByLawRule}" method="post"  enctype="multipart/form-data">
			
                            <div class="row">
							
                                <div class="col-lg-4 col-md-6">
									<div class="form-group">
                                        <label>Select Value</label>
                                         <input hidden name='<portlet:namespace/>moduleName' id="moduleName" class="form-control"></input> 
                                        
                                      <select name='<portlet:namespace/>ruleEngineModuleParameterId' id="moduleValue"  class="custom-select form-control" onclick="setlevel()">
                                            <option value=""><liferay-ui:message key="select" /> </option>
                                            <c:forEach var="engineModuleParamter" items="${ruleEngineModuleParamters}">
										<option value="${engineModuleParamter.id}">
											<liferay-ui:message
												key="${engineModuleParamter.moduleName}" /></option>
									</c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label>Select</label>
                                        <select name="<portlet:namespace/>matchAll" id="selectIsandIn"  class="custom-select form-control">
                                            <option value="matchAll">Match all</option>
											<option value="matchAny">Match any</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label>Select condition</label>
                                        <select name="<portlet:namespace/>byLawCondition" id="condition"  class="custom-select form-control">                                            
                                          			
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="col-lg-4 col-md-6 d-none" id="byLawLevelValue">
                                    <div class="form-group">
                                    	<label><liferay-ui:message key="equivalency-level" /></label>
		                                        <input name='<portlet:namespace/>byLawLevel' id="level" class="form-control"></input> 
                                    </div>
                                </div>
                            </div>
                            <div class="bottom-backbtn-wrap m-0">
                                <button type="submit" class="btn omsb-bc-red-button m-0" id="Add"><liferay-ui:message key="add-rule" /></button>
                            </div>
                            </form>
                        </div>

						<div class="pagetitle">List of Rules</div>


						<div class="omsb-list-view table-responsive hide_dt_filter">
							<table class="display omsb-datatables" id="exam_list">
								<thead>
									<tr>
										<th>Module Name</th>
										<th>Rule</th>
										<th>Level</th>
										<th>ACTIONS</th>

									</tr>
								</thead>
								<tbody>
								 <c:forEach var="byLawRule" items="${byLawRules}">
									<tr>
										<td>${byLawRule.moduleName}</td>
										<td>${byLawRule.byLawCondition}</td>
										<td>${byLawRule.equivalencyLevel}</td>
										<td width="229">
											<div class="dropdown ">
												<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
													data-bs-toggle="dropdown" aria-expanded="false">
													<i class=""></i>
												</button>
												<ul class="dropdown-menu">												
													
													<li><a href="#" class="dropdown-item" onclick="deleteRule(${byLawRule.id})"><img src="../images/svg/fi-rr-delete.svg" > Delete</a></li>
                                                </ul>
											</div>
										</td>
									</tr>
									</c:forEach>
								
								</tbody>
							</table>
						</div>
					</div>



				</div>
			</div>
			
			
			
<script>
$(document).ready(function(){
	$('#condition').prop('multiple', 'multiple');
	$('#condition').multiselect({includeSelectAllOption: true});
})

$('#moduleValue').change(function() {
	
	var ruleEngineModuleParameterId=$(this).val();
	var moduleName=$("#moduleValue option:selected").text();
	$("#moduleName").val(moduleName);
	console.log("moduleValue   :::")
	console.log(ruleEngineModuleParameterId);
	console.log(moduleName);
	$.ajax({
		url: '${getByLawCondition}',
		async : false,
		dataType:"json",
		data : {
			'<portlet:namespace />ruleEngineModuleParameterId' : ruleEngineModuleParameterId,
			'<portlet:namespace />moduleName' : moduleName,
		},
		type : 'GET',
		success : function(data) {
			
			console.log(data);
			$('#condition option').remove();
           
             $.each(data, function (i, item) {
            	   $("#condition").append("<option value='" + item.conditionId + "'>" + item.conditionValue + "</option> ");

            })
            $("#condition").multiselect('rebuild');
             
             
            },
	})
})

function deleteRule(id){
	$.ajax({
		url: '${deleteByLawRule}',
		async : false,
		dataType:"json",
		data : {
			'<portlet:namespace />ByLawRuleId' : id,
		
		},
		type : 'GET',
		success : function(data) {
			console.log("rule deleted")
			location.reload();
 		},
	}) 
	
}


function setlevel() {
	  var selectElement = document.getElementById("moduleValue");
	  var selectedOption = selectElement.options[selectElement.selectedIndex];
	  var innerHTMLValue = selectedOption.innerHTML.trim();
	  console.log("Inner HTML Value: " + innerHTMLValue);
	  if (innerHTMLValue === 'Equivalency') {
        $('#byLawLevelValue').removeClass('d-none');
        console.log("inside the if condition")
  	  } else{
    	 $('#byLawLevelValue').addClass('d-none');
     }
	
 }



</script>			