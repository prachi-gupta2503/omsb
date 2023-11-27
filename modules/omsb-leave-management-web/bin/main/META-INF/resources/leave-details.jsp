<%@ include file="/init.jsp" %>

<portlet:renderURL var="viewLeavesURL">
    <portlet:param name="jspPage" value="<%= OmsbLeaveManagementWebConstants.VIEW_TRAINEE_LEAVE_REQUEST_JSP_PATH %>"/>
</portlet:renderURL>

<%
LeaveMaster leave = (LeaveMaster) request.getAttribute("leaveMaster");
%>

<div id="wrapper">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="omsb-card">
                    <div class="omsb-page-top-info mb-3">
                        <div class="pagetitle"><liferay-ui:message key="view-leave-heading" /></div>							
                    </div>
            
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name"><liferay-ui:message key="trainee-name" /></div>
                                <div class="label-content"><%= UserLocalServiceUtil.getUser(leave.getTraineeId()).getFullName()%></div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name"><liferay-ui:message key="date-of-application" /></div>
                                <div class="label-content">${sdf.format(leaveMaster.getApplicationDate())}</div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name"><liferay-ui:message key="leave-type" /></div>
                                <div class="label-content">${leaveType}</div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name"><liferay-ui:message key="leave-from" /></div>
                                <div class="label-content">${sdf.format(leaveMaster.getLeaveFrom())}</div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name"><liferay-ui:message key="leave-to" /></div>
                                <div class="label-content">${sdf.format(leaveMaster.getLeaveTo())}</div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name"><liferay-ui:message key="no-of-days" /></div>
                                <div class="label-content">${leaveMaster.noOfDays}</div>
                            </div>
                        </div>
                        <c:choose>
                            <c:when test="${leaveMaster.returnFromLeave != null}">									    	                                
                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                    <div class="form-group-view">
                                        <div class="label-name"><liferay-ui:message key="date-of-return-from-leave" /></div>
                                        <div class="label-content">${sdf.format(leaveMaster.getReturnFromLeave())}</div>
                                    </div>
                                </div>
                            </c:when>
                        </c:choose>                       

                    </div>

                    <div class="bottom-backbtn-wrap">
                        <a class="btn omsb-btn btn-back" href="${viewLeavesURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>