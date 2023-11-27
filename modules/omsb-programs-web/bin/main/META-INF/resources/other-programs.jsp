<%@ include file="init.jsp"%>
<c:if test="${otherProgramList.size() > 1}">
	<div class="omsb-card">
		<h4 class="omsb-card-title"><liferay-ui:message key="other-programs" /></h4>
		<ul class="omsb-programdetails-list" >
			<c:forEach var="otherProgram" items="${otherProgramList}">
				<c:if test = "${otherProgram.programMasterId != program.programMasterId}">
					<portlet:renderURL var="programDetails">
					    <portlet:param name="mvcRenderCommandName" value="<%= CommonConstants.PROGRAM_DETAILS_MVC_COMMAND %>" />
					     <portlet:param name="programMasterId" value="${otherProgram.programMasterId}" />
					</portlet:renderURL>
					<li><a href="${programDetails}" class="trans" title="${otherProgram.getProgramName(locale)}">${otherProgram.getProgramName(locale)}</a></li>
				</c:if>
		   </c:forEach>
		</ul>
	</div>
</c:if>