<%@ include file="init.jsp"%>
<style>
.container {
	margin: 25px;
}

/* .field {
	margin: 20px;
} */
</style>

<div class="container">
	<div class="field">
 		<aui:input label="Subject" type="text"
			name="subject" value="<%=(String) request.getAttribute("subject")%>" localized="true">
		</aui:input>
	</div>
	<div class="field">
		<label for="<portlet:namespace/>body">Body</label>
		<liferay-ui:input-localized name="body" xml="<%=(String)request.getAttribute("body")%>" type="editor" />
	</div>
	
</div>
