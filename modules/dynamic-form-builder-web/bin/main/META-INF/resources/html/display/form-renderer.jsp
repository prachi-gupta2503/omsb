<%@ include file="../init.jsp" %>

<h2 style="text-align: center;">Form Name : ${ddmFormDefinition.getString("name")}</h2>

<div class="container" id="<portlet:namespace />dfFormRender"></div>

<script type="text/javascript">
$(document).ready(function () {
	var renderDDf = new Object({}),
	namespace = '<portlet:namespace />',
	contextPath = '<%= request.getContextPath()%>',
	jsonFieldsArray = '${jsonFieldsArray}',
	formName = '${ddmFormDefinition.getString("name")}',
	formLayoutColomn = '${ddmFormDefinition.getString("layout")}',
	
	formContainerJEL = '#' + namespace + 'dfFormRender';
	renderDDf.formName = formName;
	renderDDf.namespace = namespace;
	renderDDf.contextPath = contextPath;
	renderDDf.formLayoutColomn = formLayoutColomn;
	renderDDf.jsonFieldsArray = jsonFieldsArray;
	renderDDf.formContainerJEL = formContainerJEL;
	
	dfrPortlet.renderDDf(renderDDf);
	console.log("formLayoutColomn>>>>> : "+formLayoutColomn);
});
</script>
