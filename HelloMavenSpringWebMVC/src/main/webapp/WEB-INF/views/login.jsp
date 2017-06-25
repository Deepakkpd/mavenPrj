<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html  lang="en">
  <head>
    <title>Login</title>
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
  </head>
  <body >

<div class="container">
    <div class="row">
        <div class="form_bg">
            <form name='loginForm'
		  action="<c:url value='j_spring_security_check' />" method='POST'>
                 <h2 class="text-center">Login Page</h2>
                <br/>
                <c:if test="${not empty error}">
                <div class="alert alert-danger">
			<div class="error">${error}</div>
		</div></c:if>
                <div class="form-group">
                    <input  class="form-control" id="userid" placeholder="User id" name="j_username"><!-- type="email" -->
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="pwd" placeholder="Password" name="j_password">
                
                    </div>
                    <br/>
                   <div class="align-center">
                <button type="submit" class="btn btn-default" id="login">Login</button>
                    </div>
            </form>
        </div>
    </div>
</div>
        

  </body>
</html>