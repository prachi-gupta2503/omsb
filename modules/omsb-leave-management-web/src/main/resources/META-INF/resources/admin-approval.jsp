<%@ include file="/init.jsp" %>

<liferay-ui:error key="leaves-not-remaining" message="leave.not.remaining" />

<%

String isValidLeave = ParamUtil.getString(request, "isValidLeave");
String leaveType = StringPool.BLANK;
LeaveMaster leave = null;
SimpleDateFormat sdf = null;
boolean isReturnFromLeave = false;

if(Validator.isNotNull(isValidLeave)) {
	String leaveMasterId = ParamUtil.getString(request, "leaveMasterId");	
	leave = LeaveMasterLocalServiceUtil.getLeaveMaster(Long.valueOf(leaveMasterId));
	leaveType = ParamUtil.getString(request, "leaveType");	
	sdf = new SimpleDateFormat(OmsbLeaveManagementWebConstants.VIEW_DATE_FORMAT);
	isReturnFromLeave = Validator.isNull(leave.getReturnFromLeave());
} else {
	leave = (LeaveMaster) request.getAttribute("leaveMaster");
	leaveType = (String)request.getAttribute("leaveType");
	sdf = (SimpleDateFormat)request.getAttribute("sdf");
	isReturnFromLeave = Validator.isNull(leave.getReturnFromLeave());
}

%>

<portlet:actionURL name="<%=OmsbLeaveManagementWebConstants.ADMIN_ACTION_PERFORMED_ACTION_COMMAND%>" var="adminActionPerformedUrl" >
</portlet:actionURL>

<aui:form action="${adminActionPerformedUrl}" name="addminApprovalForm" id="addminApprovalForm">
<div id="wrapper">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="omsb-card">
                    <div class="omsb-page-top-info mb-3">
                        <div class="pagetitle"><liferay-ui:message key="view-leave-heading" /></div>							
                    </div>
            
                    <aui:input name="leaveMasterId" id="leaveMasterId" value="<%= leave.getLeaveMasterId() %>" type="hidden"></aui:input>

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
                                <div class="label-content"><%=sdf.format(leave.getApplicationDate()) %></div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name"><liferay-ui:message key="leave-type" /></div>
                                <div class="label-content"><%=leaveType %></div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name"><liferay-ui:message key="leave-from" /></div>
                                <div class="label-content"><%=sdf.format(leave.getLeaveFrom()) %></div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name"><liferay-ui:message key="leave-to" /></div>
                                <div class="label-content"><%=sdf.format(leave.getLeaveTo()) %></div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                            <div class="form-group-view">
                                <div class="label-name"><liferay-ui:message key="no-of-days" /></div>
                                <div class="label-content"><%=leave.getNoOfDays() %></div>
                            </div>
                        </div>
                        <c:choose>
                            <c:when test="<%=leave.getReturnFromLeave() != null %>">									    	                                
                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                    <div class="form-group-view">
                                        <div class="label-name"><liferay-ui:message key="date-of-return-from-leave" /></div>
                                        <div class="label-content"><%=sdf.format(leave.getReturnFromLeave()) %></div>
                                    </div>
                                </div>
                            </c:when>
                        </c:choose> 
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
                            <div class="form-group-view">
                                <aui:input cssClass="form-control" label="reason-admin" type="textarea" name="reason" localized="false" />
                            </div>
                        </div>

                    </div>

                    <aui:input name="btnVal" id="btnVal" value="" type="hidden"></aui:input>

                    <div class="bottom-backbtn-wrap">
                        <a class="btn omsb-bc-red-button" href="" type="button" id="acceptBtn"><liferay-ui:message key="accept" /></a>
                        <c:if test="<%= isReturnFromLeave %>">                        	
                        	<a class="btn omsb-btn btn-back" href="#" id="rejectBtn"><liferay-ui:message key="reject" /></a>
                        </c:if>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</aui:form>

<script>
    $(document).ready(function () {
        $("#acceptBtn").click(function(){            
            $("#<portlet:namespace/>btnVal").val("approve");
            $("#<portlet:namespace/>addminApprovalForm").submit();
        });

        $("#rejectBtn").click(function(){
            $("#<portlet:namespace/>btnVal").val("reject");
            $("#<portlet:namespace/>addminApprovalForm").submit();
        });
    });
</script>