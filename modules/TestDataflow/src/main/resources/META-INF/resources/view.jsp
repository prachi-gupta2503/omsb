<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="testdataflow.caption"/></b>
</p>

<portlet:actionURL name="caseNumber" var="caseNumberURL" />
<portlet:actionURL name="caseReport" var="caseReportURL" />
<h4>To Get the Case Request Details. Proceed only if stage Id equals 1 and 5 </h4>
<aui:form action="<%= caseNumberURL%>" method="post" name="fm" >
	<aui:input id="caseNumber" name="caseNumber" type="text" class="form-control" label="Case Number"/>
	<button class="btn omsb-bc-red-button btn-primary"  type="submit" name="submit">submit</button>
</aui:form>
<br>
<h4>To Get the Case Report. Proceed only if stage Id equals 5 </h4>
<aui:form action="<%= caseReportURL%>" method="post" name="fm_report" >
	<aui:input id="caseNumber" name="caseNumber" type="text" class="form-control" label="Case Number" />
	<button class="btn omsb-bc-red-button btn-primary" type="submit" name="submit">submit</button>
</aui:form>
