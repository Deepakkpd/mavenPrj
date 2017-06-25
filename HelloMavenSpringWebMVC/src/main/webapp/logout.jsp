<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html  lang="en">
  <head>
    <title>Logout</title>
    <spring:url value="/resources/core/jquery/jquery.min.js" var="coreJs" />
<script src="${coreJs}"></script>

<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<spring:url value="/resources/core/jquery/jquery.js" var="jqueryJs" />

<script src="${jqueryJs}"></script>
<link href="${bootstrapCss}" rel="stylesheet" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
 <script type="text/javascript">


 </script>   
 <style>
 .form_bg {
     background-color:#eee;
     color:#666;
     padding:20px;
     border-radius:10px;
     position: absolute;
     border:1px solid #fff;
     margin: auto;
     top: 0;
     right: 0;
     bottom: 0;
     left: 0;
     width: 320px;
     height: 280px;
 }

 .align-center {
     
     text-align:center;
 }
 body {
    
    
    background:#ff8080;
}
</style>   
 <script>
		function formSubmit() {
			setTimeout(function(){
			//alert("aaa");
			document.getElementById("logout").submit();
			//alert("bb");
			},2500);
		}
	</script>
  </head>
  <body >

<div class="container">
    <div class="row">
        <div class="form_bg">
            <form id="logout"
		  action="<c:url value='j_spring_security_logout' />" method='POST'>
                <br/>
                 <h2 class="text-center">You have successfully logged out</h2>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
			 <script>
			 	formSubmit()
			 </script>
		
	</c:if>
                    <br/>
            </form>
        </div>
    </div>
</div>
        

  </body>
</html>