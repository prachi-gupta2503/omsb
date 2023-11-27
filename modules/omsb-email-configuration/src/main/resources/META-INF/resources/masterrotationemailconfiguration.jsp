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
<label>TraineeMasterRotationSchedule</label>
	<div class="field">
		<aui:input label="Subject" type="text"
			name="subjectForTraineeMasterRotationSchedule" value="<%=(String)request.getAttribute("subjectForTraineeMasterRotationSchedule")%>" localized="true">
		</aui:input>
	</div>
	<div class="field">
		<label for="<portlet:namespace/>bodyForTraineeMasterRotationSchedule">Body</label>
		<liferay-ui:input-localized name="bodyForTraineeMasterRotationSchedule" xml="<%=(String)request.getAttribute("bodyForTraineeMasterRotationSchedule")%>" type="editor" />
	</div>
	<label>FacultyMasterRotationSchedule</label>
	<div class="field">
		<aui:input label="Subject" type="text"
			name="subjectForFacultyMasterRotationSchedule" value="<%=(String)request.getAttribute("subjectForFacultyMasterRotationSchedule")%>" localized="true">
		</aui:input>
	</div>
	<div class="field">
		<label for="<portlet:namespace/>bodyForFacultyMasterRotationSchedule">Body</label>
		<liferay-ui:input-localized name="bodyForFacultyMasterRotationSchedule" xml="<%=(String)request.getAttribute("bodyForFacultyMasterRotationSchedule")%>" type="editor" />
	</div>
	<label>PAUserMasterRotationSchedule</label>
	<div class="field">
		<aui:input label="Subject" type="text"
			name="subjectForPAUserMasterRotationSchedule" value="<%=(String)request.getAttribute("subjectForPAUserMasterRotationSchedule")%>" localized="true">
		</aui:input>
	</div>
	<div class="field">
		<label for="<portlet:namespace/>bodyForPAUserMasterRotationSchedule">Body</label>
		<liferay-ui:input-localized name="bodyForPAUserMasterRotationSchedule" xml="<%=(String)request.getAttribute("bodyForPAUserMasterRotationSchedule")%>" type="editor" />
	</div>
	<label>ECMemberMasterRotationSchedule</label>
	<div class="field">
		<aui:input label="Subject" type="text"
			name="subjectForECMemberMasterRotationSchedule" value="<%=(String)request.getAttribute("subjectForECMemberMasterRotationSchedule")%>" localized="true">
		</aui:input>
	</div>
	<div class="field">
		<label for="<portlet:namespace/>bodyForECMemberMasterRotationSchedule">Body</label>
		<liferay-ui:input-localized name="bodyForECMemberMasterRotationSchedule" xml="<%=(String)request.getAttribute("bodyForECMemberMasterRotationSchedule")%>" type="editor" />
	</div>
	
</div>