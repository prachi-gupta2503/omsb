<%@ include file="/init.jsp" %>

<p>
	<center><b><liferay-ui:message key="Processing Payment..., Please wait!"/></b></center>
</p>

<script>
$(document).ready(function () {
    	console.log("Loading view.jsp");
    	var paymentResponseStatus = "<%= renderRequest.getAttribute("paymentResponseStatus") %>";
    	if(themeDisplay.isSignedIn()){
    		var homePageUrl = "<%= renderRequest.getAttribute("homePageUrl") %>";
    		 	var redirectionType = localStorage.setItem('paymentResponseStatus', paymentResponseStatus);
                window.location.href = homePageUrl;
    	}else{
    		var loginUrl = "<%= renderRequest.getAttribute("loginUrl") %>";
            window.location.href = loginUrl;
    	}
    });
</script>