<%@ include file="/init.jsp" %>

<portlet:renderURL var="viewLeavesURL">
    <portlet:param name="jspPage" value="<%= OmsbLeaveStatusConstants.VIEW_LEAVE_JSP %>"/>
</portlet:renderURL>

<%
LeaveMaster leave = (LeaveMaster) request.getAttribute("leaveMaster");
%>

<div id="wrapper">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="omsb-card">
                    <div class="omsb-page-top-info mb-3">
                        <div class="pagetitle"><liferay-ui:message key="view-leave-heading" /></div>							
                    </div>
            
                    <div class="row">
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

                    <h4 class="omsb-card-title mt-1 mb-3"><liferay-ui:message key="contact-while-on-leave-heading" /></h4>

                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name"><liferay-ui:message key="contact-name" /></div>
                                <div class="label-content">${leaveMaster.contactName}</div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name"><liferay-ui:message key="conatct-email" /></div>
                                <div class="label-content">${leaveMaster.contactEmail}</div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name"><liferay-ui:message key="contact-number" /></div>
                                <div class="label-content">${leaveMaster.contactNo}</div>
                            </div>
                        </div>
                    </div>

                    <div class="bottom-backbtn-wrap">
                        <a class="btn omsb-btn btn-back" href="${viewLeavesURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
                    </div>
                </div>
            </div>

            <div class="col-md-3">
                <div class="omsb-card">
                    <h4 class="omsb-card-title"><liferay-ui:message key="leave-status-heading" /></h4>

                    <div class="omsb-card border omsb-card-leave-status">
                        <h4 class="omsb-card-title text-danger"><liferay-ui:message key="trainee" /></h4>
                        <div class="row border-bottom mb-3">
                            <div class="col-md-12">
                                <div class="form-group-view">
                                    <div class="label-content"><liferay-ui:message key="name" /></div>
                                    <div class="label-name"><%= UserLocalServiceUtil.getUser(leave.getCreatedBy()).getFullName() %></div>
                                </div>
                            </div>
                            <div class="col-md-6 ">
                                <div class="form-group-view">
                                    <div class="label-content"><liferay-ui:message key="date" /></div>
                                    <div class="label-name">${viewStatusSDF.format(leaveMaster.getCreateDate())}</div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group-view">
                                    <div class="label-content"><liferay-ui:message key="time" /></div>
                                    <div class="label-name">${viewStatusTimeSDF.format(leaveMaster.getCreateDate())}</div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 text-center ">
                                <span class="omsb-btn omsb-initiated-bg w-100"><liferay-ui:message key="applied-for-leave" /></span>
                            </div>
                        </div>
                    </div>

                    <c:forEach var='item' items='${approvalStatus}'>
                        <div class="omsb-card border omsb-card-leave-status">
                            <h4 class="omsb-card-title text-danger">${item['roleName']}</h4>
                            <div class="row border-bottom mb-3">
                                <div class="col-md-12">
                                    <div class="form-group-view">
                                        <div class="label-content"><liferay-ui:message key="name" /></div>
                                        <div class="label-name">${item['userName']}</div>
                                    </div>
                                </div>
                                <div class="col-md-6 ">
                                    <div class="form-group-view">
                                        <div class="label-content"><liferay-ui:message key="date" /></div>
                                        <div class="label-name">${item['completionDate']}</div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group-view">
                                        <div class="label-content"><liferay-ui:message key="time" /></div>
                                        <div class="label-name">${item['completionTime']}</div>
                                    </div>
                                </div>
                                <c:if test="${item['comments'] != ''}">
                                    <div class="col-md-12">
                                        <div class="form-group-view">
                                            <div class="label-content"><liferay-ui:message key="comments" /></div>
                                            <div class="label-name">${item['comments']}</div>
                                        </div>
                                    </div>
                                </c:if>                                
                            </div>
                            <c:choose>
                                <c:when test="${item['status'] == 'Approved'}">
                                    <div class="row">
                                        <div class="col-md-12 text-center ">								    	
                                            <span class="omsb-btn omsb-complete-bg w-100"><liferay-ui:message key="approved" /></span>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test="${item['status'] == 'Pending'}">
                                    <div class="row">
                                        <div class="col-md-12 text-center ">								    	
                                            <span class="omsb-btn omsb-pending-bg w-100"><liferay-ui:message key="pending" /></span>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test="${item['status'] == 'Rejected'}">
                                    <div class="row">
                                        <div class="col-md-12 text-center ">								    	
                                            <span class="omsb-btn omsb-rejected-bg w-100"><liferay-ui:message key="rejected" /></span>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test="${item['status'] == 'Canceled'}">
                                    <div class="row">
                                        <div class="col-md-12 text-center ">								    	
                                            <span class="omsb-btn omsb-initiated-bg w-100"><liferay-ui:message key="canceled" /></span>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                        </div>
                    </c:forEach>

                    <c:if test="${leaveMaster.status == 8 && leaveMaster.returnFromLeave == null}">
                        <div class="omsb-card border omsb-card-leave-status">
                            <h4 class="omsb-card-title text-danger"><liferay-ui:message key="trainee" /></h4>
                            <div class="row border-bottom mb-3">
                                <div class="col-md-12">
                                    <div class="form-group-view">
                                        <div class="label-content"><liferay-ui:message key="name" /></div>
                                        <div class="label-name"><%= UserLocalServiceUtil.getUser(leave.getModifiedBy()).getFullName() %></div>
                                    </div>
                                </div>
                                <div class="col-md-6 ">
                                    <div class="form-group-view">
                                        <div class="label-content"><liferay-ui:message key="date" /></div>
                                        <div class="label-name">${viewStatusSDF.format(leaveMaster.getModifiedDate())}</div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group-view">
                                        <div class="label-content"><liferay-ui:message key="time" /></div>
                                        <div class="label-name">${viewStatusTimeSDF.format(leaveMaster.getModifiedDate())}</div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 text-center ">
                                    <span class="omsb-btn omsb-initiated-bg w-100"><liferay-ui:message key="cancel-leave" /></span>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>