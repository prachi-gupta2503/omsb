<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<portlet:resourceURL id="oct/schedule/calendar" var="calendarResUrl" />
<%
String activeView = ParamUtil.getString(request, "activeView", sessionClicksDefaultView);
long date = ParamUtil.getLong(request, "date", System.currentTimeMillis());

JSONArray groupCalendarsJSONArray = CalendarUtil.toCalendarsJSONArray(themeDisplay, groupCalendars);
JSONArray userCalendarsJSONArray = CalendarUtil.toCalendarsJSONArray(themeDisplay, userCalendars);
JSONArray otherCalendarsJSONArray = CalendarUtil.toCalendarsJSONArray(themeDisplay, otherCalendars);

boolean columnOptionsVisible = GetterUtil.getBoolean(SessionClicks.get(request, "com.liferay.calendar.web_columnOptionsVisible", "true"));

long roleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "OCT Applicant").getRoleId();

boolean isValidRole=UserLocalServiceUtil.hasRoleUser(roleId, themeDisplay.getUserId());
%>
<style>

.schedule_event{
position: absolute;
    top: 3px;
    left: 20%;
    z-index: 99;
}


</style>
<aui:script use="liferay-calendar-container,liferay-calendar-remote-services,liferay-component">
	Liferay.component('<portlet:namespace />calendarContainer', () => {
		var calendarContainer = new Liferay.CalendarContainer({
			groupCalendarResourceId: <%= groupCalendarResource.getCalendarResourceId() %>,

			<c:if test="<%= userCalendarResource != null %>">
				userCalendarResourceId: <%= userCalendarResource.getCalendarResourceId() %>,
			</c:if>

			namespace: '<portlet:namespace />',
		});

		var destroyInstance = function (event) {
			if (event.portletId === '<%= portletDisplay.getId() %>') {
				calendarContainer.destroy();

				Liferay.component('<portlet:namespace />calendarContainer', null);

				Liferay.detach('destroyPortlet', destroyInstance);
			}
		};

		Liferay.on('destroyPortlet', destroyInstance);

		return calendarContainer;
	});

	Liferay.component('<portlet:namespace />remoteServices', () => {
		var remoteServices = new Liferay.CalendarRemoteServices({
			baseActionURL:
				'<%= PortletURLFactoryUtil.create(request, portletDisplay.getId(), PortletRequest.ACTION_PHASE) %>',
			baseResourceURL:
				'<%= PortletURLFactoryUtil.create(request, portletDisplay.getId(), PortletRequest.RESOURCE_PHASE) %>',
			invokerURL: themeDisplay.getPathContext() + '/api/jsonws/invoke',
			namespace: '<portlet:namespace />',
			userId: themeDisplay.getUserId(),
		});

		var destroyInstance = function (event) {
			if (event.portletId === '<%= portletDisplay.getId() %>') {
				remoteServices.destroy();

				Liferay.component('<portlet:namespace />remoteServices', null);

				Liferay.detach('destroyPortlet', destroyInstance);
			}
		};

		Liferay.on('destroyPortlet', destroyInstance);

		return remoteServices;
	});
</aui:script>

<clay:container-fluid
	cssClass="calendar-portlet-column-parent"
>
	<clay:row>
		<c:if test="<%= !displaySchedulerOnly %>">
			<clay:col
				cssClass='<%= "calendar-portlet-column-options " + (columnOptionsVisible ? StringPool.BLANK : "hide") %>'
				id='<%= liferayPortletResponse.getNamespace() + "columnOptions" %>'
				md="3"
			>
				<div class="calendar-portlet-mini-calendar" id="<portlet:namespace />miniCalendarContainer"></div>

				<div id="<portlet:namespace />calendarListContainer">
					<div class="calendar-portlet-list  d-none">
						<c:if test="<%= themeDisplay.isSignedIn() && showUserEvents %>">
							<div class="calendar-portlet-list-header toggler-header-expanded">
								<span class="calendar-portlet-list-arrow"></span>

								<span class="calendar-portlet-list-text"><liferay-ui:message key="my-calendars" /></span>
							</div>

							<c:if test="<%= userCalendarResource != null %>">
								<span aria-controls="<portlet:namespace />calendarsMenu" aria-expanded="false" aria-label="<liferay-ui:message arguments='<%= LanguageUtil.get(request, "my-calendars") %>' key="manage-calendar-x" />" class="calendar-list-item-arrow calendar-resource-arrow" data-calendarResourceId="<%= userCalendarResource.getCalendarResourceId() %>" role="button" tabindex="0"><clay:icon symbol="caret-bottom" /></span>
							</c:if>
						</c:if>

						<div class="calendar-portlet-calendar-list" id="<portlet:namespace />myCalendarList"></div>
					</div>

					<div class="calendar-portlet-list  d-none">
						<c:if test="<%= showSiteCalendars %>">
							<div class="calendar-portlet-list-header toggler-header-expanded">
								<span class="calendar-portlet-list-arrow"></span>

								<span class="calendar-portlet-list-text"><liferay-ui:message arguments="<%= HtmlUtil.escape(groupCalendarResource.getName(locale)) %>" key="x-calendars" /></span>
							</div>

							<c:if test="<%= CalendarResourcePermission.contains(permissionChecker, groupCalendarResource, CalendarActionKeys.ADD_CALENDAR) %>">
								<span aria-expanded="false" aria-label="<liferay-ui:message arguments="<%= HtmlUtil.escape(groupCalendarResource.getName(locale)) %>" key="manage-calendar-x" />" class="calendar-list-item-arrow calendar-resource-arrow" data-calendarResourceId="<%= groupCalendarResource.getCalendarResourceId() %>" role="button" tabindex="0"><clay:icon symbol="caret-bottom" /></span>
							</c:if>

							<div class="calendar-portlet-calendar-list" id="<portlet:namespace />siteCalendarList"></div>
						</c:if>
					</div>

					<div class="calendar-portlet-list  d-none">
						<c:if test="<%= themeDisplay.isSignedIn() %>">
							<div class="calendar-portlet-list-header toggler-header-expanded">
								<span class="calendar-portlet-list-arrow"></span>

								<span class="calendar-portlet-list-text"><liferay-ui:message key="other-calendars" /></span>
							</div>

							<div class="calendar-portlet-calendar-list" id="<portlet:namespace />otherCalendarList">
								<input class="calendar-portlet-add-calendars-input" id="<portlet:namespace />addOtherCalendar" placeholder="<liferay-ui:message key="add-other-calendars" />" type="text" />
							</div>
						</c:if>
					</div>
				</div>
			</clay:col>
		</c:if>

		<clay:col
			cssClass="calendar-portlet-column-grid"
			id='<%= liferayPortletResponse.getNamespace() + "columnGrid" %>'
			md="<%= (columnOptionsVisible && !displaySchedulerOnly) ? String.valueOf(9) : String.valueOf(12) %>"
		>
			<c:if test="<%= !displaySchedulerOnly %>">
				<div class="calendar-portlet-column-toggler" id="<portlet:namespace />columnToggler">
					<clay:icon
						id='<%= liferayPortletResponse.getNamespace() + "columnTogglerIcon" %>'
						symbol='<%= columnOptionsVisible ? "caret-left" : "caret-right" %>'
					/>
				</div>
			</c:if>

			<liferay-util:include page="/scheduler.jsp" servletContext="<%= application %>">
				<liferay-util:param name="activeView" value="<%= activeView %>" />
				<liferay-util:param name="date" value="<%= String.valueOf(date) %>" />

				<portlet:renderURL var="editCalendarBookingURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="mvcPath" value="/edit_calendar_booking.jsp" />
					<portlet:param name="activeView" value="{activeView}" />
					<portlet:param name="allDay" value="{allDay}" />
					<portlet:param name="calendarBookingId" value="{calendarBookingId}" />
					<portlet:param name="calendarId" value="{calendarId}" />
					<portlet:param name="date" value="{date}" />
					<portlet:param name="endTimeDay" value="{endTimeDay}" />
					<portlet:param name="endTimeHour" value="{endTimeHour}" />
					<portlet:param name="endTimeMinute" value="{endTimeMinute}" />
					<portlet:param name="endTimeMonth" value="{endTimeMonth}" />
					<portlet:param name="endTimeYear" value="{endTimeYear}" />
					<portlet:param name="instanceIndex" value="{instanceIndex}" />
					<portlet:param name="startTimeDay" value="{startTimeDay}" />
					<portlet:param name="startTimeHour" value="{startTimeHour}" />
					<portlet:param name="startTimeMinute" value="{startTimeMinute}" />
					<portlet:param name="startTimeMonth" value="{startTimeMonth}" />
					<portlet:param name="startTimeYear" value="{startTimeYear}" />
					<portlet:param name="titleCurrentValue" value="{titleCurrentValue}" />
				</portlet:renderURL>

				<liferay-util:param name="editCalendarBookingURL" value="<%= editCalendarBookingURL %>" />

				<liferay-util:param name="hideAgendaView" value="<%= String.valueOf(!showAgendaView) %>" />
				<liferay-util:param name="hideDayView" value="<%= String.valueOf(!showDayView) %>" />
				<liferay-util:param name="hideWeekView" value="<%= String.valueOf(!showWeekView) %>" />
				<liferay-util:param name="hideMonthView" value="<%= String.valueOf(!showMonthView) %>" />
				<liferay-util:param name="readOnly" value="<%= Boolean.FALSE.toString() %>" />

				<liferay-security:permissionsURL
					modelResource="<%= CalendarBooking.class.getName() %>"
					modelResourceDescription="{modelResourceDescription}"
					resourceGroupId="{resourceGroupId}"
					resourcePrimKey="{resourcePrimKey}"
					var="permissionsCalendarBookingURL"
					windowState="<%= LiferayWindowState.POP_UP.toString() %>"
				/>

				<liferay-util:param name="permissionsCalendarBookingURL" value="<%= permissionsCalendarBookingURL %>" />

				<%-- <liferay-util:param name="showAddEventBtn" value="<%= String.valueOf((defaultCalendar != null) && CalendarPermission.contains(permissionChecker, defaultCalendar, CalendarActionKeys.MANAGE_BOOKINGS)) %>" />
				 --%>
				 <% if(!isValidRole){%>
				 
				<button class="btn omsb-bg-red-button schedule_event" onclick="getExamList()" data-toggle="modal" data-target="#addEvent" type="button">Schedule Event</button>
				
				<%} %>
				<liferay-util:param name="showSchedulerHeader" value="<%= String.valueOf(displaySchedulerHeader) %>" />

				<portlet:renderURL var="viewCalendarBookingURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="mvcPath" value="/view_calendar_booking.jsp" />
					<portlet:param name="calendarBookingId" value="{calendarBookingId}" />
					<portlet:param name="instanceIndex" value="{instanceIndex}" />
				</portlet:renderURL>

				<liferay-util:param name="viewCalendarBookingURL" value="<%= viewCalendarBookingURL %>" />
			</liferay-util:include>
		</clay:col>
	</clay:row>
</clay:container-fluid>

<div id="<portlet:namespace />message"></div>
<div >
<div class="modal fade omsb-modal" id="addEvent" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						Select your Exam to Schedule it.
					</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row">
						<label  class="required"><liferay-ui:message key="select-your-exam"/></label>	
							<select name="model" id="titleList" class="form-control">
							
							
							</select>
							  <span class="d-none text-danger" id="exam_selection_error"><liferay-ui:message key="the-select-exam-title-field-is-required"/></span>
						
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" title="ok" onclick="scheduleEvent()" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
</div>

<c:if test="<%= !displaySchedulerOnly %>">
	<%@ include file="/view_calendar_menus.jspf" %>
</c:if>

<aui:script use="liferay-calendar-list,liferay-calendar-util,liferay-scheduler">
	Liferay.CalendarUtil.USER_CLASS_NAME_ID = <%= PortalUtil.getClassNameId(User.class) %>;

	var calendarContainer = Liferay.component(
		'<portlet:namespace />calendarContainer'
	);

	var syncCalendarsMap = function () {
		var calendarLists = [];

		<c:if test="<%= themeDisplay.isSignedIn() || (groupCalendarResource != null) %>">
			calendarLists.push(window.<portlet:namespace />myCalendarList);
		</c:if>

		<c:if test="<%= themeDisplay.isSignedIn() %>">
			calendarLists.push(window.<portlet:namespace />otherCalendarList);
		</c:if>

		<c:if test="<%= showSiteCalendars %>">
			calendarLists.push(window.<portlet:namespace />siteCalendarList);
		</c:if>

		calendarContainer.syncCalendarsMap(calendarLists);
	};

	window.<portlet:namespace />syncCalendarsMap = syncCalendarsMap;

	window.<portlet:namespace />calendarLists = {};

	<c:if test="<%= themeDisplay.isSignedIn() || (groupCalendarResource != null) %>">
		window.<portlet:namespace />myCalendarList = new Liferay.CalendarList({
			after: {
				'calendarsChange': syncCalendarsMap,
				'scheduler-calendar:visibleChange': function (event) {
					syncCalendarsMap();

					<portlet:namespace />refreshVisibleCalendarRenderingRules();
				},
			},
			boundingBox: '#<portlet:namespace />myCalendarList',

			<%
			updateCalendarsJSONArray(userCalendarsJSONArray, enableRSS, request, false);
			%>

			calendars: <%= userCalendarsJSONArray %>,
			scheduler: <portlet:namespace />scheduler,
			showCalendarResourceName: false,
			simpleMenu: window.<portlet:namespace />calendarsMenu,
			visible: <%= !displaySchedulerOnly && themeDisplay.isSignedIn() %>,
		}).render();

		<c:if test="<%= userCalendarResource != null %>">
			window.<portlet:namespace />calendarLists[
				'<%= userCalendarResource.getCalendarResourceId() %>'
			] = window.<portlet:namespace />myCalendarList;
		</c:if>
	</c:if>

	<c:if test="<%= themeDisplay.isSignedIn() %>">
		window.<portlet:namespace />otherCalendarList = new Liferay.CalendarList({
			after: {
				'calendarsChange': function (event) {
					syncCalendarsMap();

					<portlet:namespace />scheduler.load();

					var calendarIds = A.Array.invoke(event.newVal, 'get', 'calendarId');

					Liferay.Util.Session.set(
						'com.liferay.calendar.web_otherCalendars',
						calendarIds.join()
					);
				},
				'scheduler-calendar:visibleChange': function (event) {
					syncCalendarsMap();

					<portlet:namespace />refreshVisibleCalendarRenderingRules();
				},
			},
			boundingBox: '#<portlet:namespace />otherCalendarList',

			<%
			updateCalendarsJSONArray(otherCalendarsJSONArray, enableRSS, request, true);
			%>

			calendars: <%= otherCalendarsJSONArray %>,
			scheduler: <portlet:namespace />scheduler,
			simpleMenu: window.<portlet:namespace />calendarsMenu,
			visible: <%= !displaySchedulerOnly %>,
		}).render();
	</c:if>

	<c:if test="<%= showSiteCalendars %>">
		window.<portlet:namespace />siteCalendarList = new Liferay.CalendarList({
			after: {
				'calendarsChange': syncCalendarsMap,
				'scheduler-calendar:visibleChange': function (event) {
					syncCalendarsMap();

					<portlet:namespace />refreshVisibleCalendarRenderingRules();
				},
			},
			boundingBox: '#<portlet:namespace />siteCalendarList',

			<%
			updateCalendarsJSONArray(groupCalendarsJSONArray, enableRSS, request, false);
			%>

			calendars: <%= groupCalendarsJSONArray %>,
			scheduler: <portlet:namespace />scheduler,
			showCalendarResourceName: false,
			simpleMenu: window.<portlet:namespace />calendarsMenu,
			visible: <%= !displaySchedulerOnly %>,
		}).render();

		window.<portlet:namespace />calendarLists[
			'<%= groupCalendarResource.getCalendarResourceId() %>'
		] = window.<portlet:namespace />siteCalendarList;
	</c:if>

	syncCalendarsMap();

	A.each(calendarContainer.get('availableCalendars'), (item, index) => {
		item.on({
			visibleChange: function (event) {
				var instance = this;

				var calendar = event.currentTarget;

				Liferay.Util.Session.set(
					'com.liferay.calendar.web_calendar' +
						calendar.get('calendarId') +
						'Visible',
					event.newVal
				);
			},
		});
	});
</aui:script>

<aui:script use="aui-base,aui-datatype,liferay-calendar-session-listener">
	window.<portlet:namespace />refreshSchedulerEventTooltipTitle = function (
		schedulerEvent
	) {
		schedulerEvent
			.get('node')
			.attr(
				'title',
				Liferay.Util.unescapeHTML(schedulerEvent.get('content'))
			);

		schedulerEvent
			.get('node')
			.attr(
				'calendarResourceName',
				Liferay.Util.unescapeHTML(
					schedulerEvent.get('calendarResourceName')
				)
			);
	};

	<portlet:namespace />scheduler.after(['scheduler-events:load'], (event) => {
		event.currentTarget.eachEvent(
			<portlet:namespace />refreshSchedulerEventTooltipTitle
		);
	});

	<portlet:namespace />scheduler.load();

	var calendarContainer = Liferay.component(
		'<portlet:namespace />calendarContainer'
	);

	new Liferay.CalendarSessionListener({
		calendars: calendarContainer.get('availableCalendars'),
		scheduler: <portlet:namespace />scheduler,
	});
</aui:script>

<aui:script>
	var destroyMenus = function (event) {
		if (window.<portlet:namespace />calendarListsMenu) {
			window.<portlet:namespace />calendarListsMenu.destroy();
		}

		if (window.<portlet:namespace />colorPicker) {
			window.<portlet:namespace />colorPicker.destroy();
		}

		var myCalendarList = window.<portlet:namespace />myCalendarList;
		var otherCalendarList = window.<portlet:namespace />otherCalendarList;
		var siteCalendarList = window.<portlet:namespace />siteCalendarList;

		if (myCalendarList && myCalendarList.simpleMenu) {
			myCalendarList.simpleMenu.destroy();
			myCalendarList.destroy();
		}

		if (otherCalendarList && otherCalendarList.simpleMenu) {
			otherCalendarList.simpleMenu.destroy();
			otherCalendarList.destroy();
		}

		if (siteCalendarList && siteCalendarList.simpleMenu) {
			siteCalendarList.simpleMenu.destroy();
			siteCalendarList.destroy();
		}

		Liferay.detach(
			'<%= portletDisplay.getId() %>:portletRefreshed',
			destroyMenus
		);
		Liferay.detach('destroyPortlet', destroyMenus);
	};
	Liferay.on('<%= portletDisplay.getId() %>:portletRefreshed', destroyMenus);
	Liferay.on('destroyPortlet', destroyMenus);
</aui:script>

<%!
protected boolean hasMenuItems(JSONObject calendarJSONObject, boolean enableRSS, boolean otherCalendar) {
	if (enableRSS || otherCalendar) {
		return true;
	}

	JSONObject permissionsJSONObject = calendarJSONObject.getJSONObject("permissions");

	if ((permissionsJSONObject.getBoolean(ActionKeys.DELETE) && !calendarJSONObject.getBoolean("defaultCalendar")) ||
		permissionsJSONObject.getBoolean(CalendarActionKeys.MANAGE_BOOKINGS) ||
		permissionsJSONObject.getBoolean(ActionKeys.PERMISSIONS) ||
		permissionsJSONObject.getBoolean(ActionKeys.UPDATE)) {

		return true;
	}

	return false;
}

protected void updateCalendarsJSONArray(JSONArray calendarsJSONArray, boolean enableRSS, HttpServletRequest request, boolean otherCalendar) {
	for (int i = 0; i < calendarsJSONArray.length(); i++) {
		JSONObject jsonObject = calendarsJSONArray.getJSONObject(i);

		long calendarId = jsonObject.getLong("calendarId");

		jsonObject.put("color", GetterUtil.getString(SessionClicks.get(request, "com.liferay.calendar.web_calendar" + calendarId + "Color", jsonObject.getString("color"))));
		jsonObject.put("hasMenuItems", hasMenuItems(jsonObject, enableRSS, otherCalendar));
		jsonObject.put("visible", GetterUtil.getBoolean(SessionClicks.get(request, "com.liferay.calendar.web_calendar" + calendarId + "Visible", "true")));
	}
}
%>

<script>

function getExamList() {
	var portalURL="<%=themeDisplay.getPortalURL()%>";
	var groupId="<%=themeDisplay.getScopeGroupId()%>";
	var companyId="<%=themeDisplay.getCompanyId()%>";
	var locale="<%=themeDisplay.getLocale()%>";
	
    
	var url="${themeDisplay.getPortalURL()}/o/oct-calendar-events-api/get-exam-list";
	
	$.ajax({
		<%-- url : '<%=calendarResUrl%>', --%>
		url: url,
		data: {
			
			"portalURL":portalURL,
			"groupId":groupId,
			"companyId":companyId,
			"locale":locale
			
		},
		type : 'GET',
		success : function(data) {
			var dataString=JSON.stringify(data);
			var dataArray=JSON.parse(dataString);
			  var sectionData = "<option value=''><liferay-ui:message key='select'/></option>";
			  for (var i = 0; i < dataArray.length; i++) {
	                sectionData += "<option value='" + dataArray[i].id + "'>" + dataArray[i].ocExamTitleName + "</option>";
	            }
			
			  $("#titleList").html(sectionData); 
		}
	});
}

function scheduleEvent(){
	var id=$('#titleList').val();
	if(id !=undefined && id != ""){
		$('#exam_selection_error').addClass('d-none');
		url="/group/guest/oct?eId="+id;
		window.location.href = url;
		
	}else{
		$('#exam_selection_error').removeClass('d-none');
	}
	
}

$('#titleList').on('change', function() {
	var id=$('#titleList').val();
	if(id !=undefined && id != ""){
		$('#exam_selection_error').addClass('d-none');
	}else{
		$('#exam_selection_error').removeClass('d-none');
	}
});

function clearValue(){
	$('#exam_selection_error').addClass('d-none');
	$('#titleList').val('');
}

$('#addEvent').on('hidden.bs.modal', function (e) {
	clearValue();
});
</script>
