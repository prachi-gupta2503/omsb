<%@ include file="../init.jsp" %>

<portlet:actionURL name="<%=MVCCommandNames.WORKFLOW_UPDATE %>" var="quivalencyWorkflowURL" />

<script type="text/javascript">
	function setTransition(transitionName) {
		$("#<portlet:namespace />transitionName").val(transitionName);
		$("#<portlet:namespace />equivalencyUpdate").submit();
	}
</script>

<aui:form action="${quivalencyWorkflowURL}" name="equivalencyUpdate">
	<aui:input type="hidden" name="transitionName" id="transitionName" value="" />
	<aui:input type="hidden" name="programId" value="2" />
	<c:if test="${not empty transitionNames}">
		<aui:input name="comments" type="textarea" />
	</c:if>

	<c:forEach items="${transitionNames}" var="transition">
		<c:choose>
				<c:when test="${transition eq'assignToMe'}">
	        		<input type="button" name="btn" class="btn btn-primary mx-2" onClick="setTransition('assignToMe')" value='<liferay-ui:message key="assign-to-me"/>' />
				</c:when>
				<c:when test="${transition eq'insuffiient'}">
	        			<input type="button" name="btn" class="btn btn-primary mx-2" onClick="setTransition('${transition}')" value='<liferay-ui:message key="${transition}"/>'>
	        			</input>
					
				</c:when>
				<c:when test="${transition eq'completed'}">
	        			<input type="button" name="btn" class="btn btn-primary mx-2" onClick="setTransition('${transition}')" value='<liferay-ui:message key="${transition}"/>'></input>
				</c:when>
				<c:otherwise>
	       			<input type="button" name="btn" class="btn btn-primary mx-2" onClick="setTransition('${transition}')" value='<liferay-ui:message key="${transition}"/>'></input>	
				</c:otherwise>
		</c:choose>
	</c:forEach>
</aui:form>