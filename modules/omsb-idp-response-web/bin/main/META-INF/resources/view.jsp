<%@ include file="/init.jsp" %>

<script>
    window.addEventListener("load", function() {
    	var loginUrl = '${loginUrl}';
        var registrationUrl = '${registrationUrl}';
        
        var loginType = localStorage.getItem('redirectionType');
        localStorage.removeItem('redirectionType');
       
        if (loginType === 'login') {
        	window.location.href = loginUrl;
        }else if(loginType === 'signup'){
        	window.location.href = registrationUrl;
        } else {
        	window.location.href = window.location.origin;
        }
    });
</script>