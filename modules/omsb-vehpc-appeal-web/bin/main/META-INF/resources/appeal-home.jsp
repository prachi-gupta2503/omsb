<%@ include file="./init.jsp" %>
  	
    	
    	<c:if test="${(hasVehpcCAdminRole) || (hasVehpcCommitteeRole) || (hasExecutePresidentRole)}">
     			<%@ include file="/jsps/appeal/equivalency-appeals-list-admin.jsp"%>
    	</c:if>
    	
    	<c:if test="${ (hasEmployerRole) || (hasEmployeeRole) }"  >
     			<%@ include file="/jsps/appeal/equivalency-decision-list-employee.jsp"%>
    	</c:if>
    	





 
	
	
	
	 
	 
	 