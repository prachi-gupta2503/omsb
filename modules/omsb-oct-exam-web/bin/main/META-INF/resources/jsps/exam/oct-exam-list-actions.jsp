
<div class="dropdown ">
	<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
		data-toggle="dropdown" aria-expanded="false">
		<i class=""></i>
	</button>
	<ul class="dropdown-menu">
		<li><a href="${editOCTExam}" class="dropdown-item"><i
				class="fa fa-pencil"></i> <liferay-ui:message key="edit" /></a></li>
		<li><a href="${viewOCTExamDetails}" class="dropdown-item"><i
				class="fa fa-eye"></i> <liferay-ui:message key="view" /></a></li>
		<li><a href="${scheduleOCTExam}" class="dropdown-item schedule_${octExamDetails.getId()}"><i
				class="fa fa-calendar-o"></i> <liferay-ui:message key="schedule" /></a></li>
	</ul>
</div>