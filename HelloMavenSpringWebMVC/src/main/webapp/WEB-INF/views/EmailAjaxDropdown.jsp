<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html  lang="en">
  <head>
    <title>SearchAjax</title>
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
 	function doSearch(){
 		//make a request to the server
 		
 		$.getJSON("emailSearch",
 					{EMAIL: $('#searchBox').val()}, /* EMAIL is the Requestparam used in controller */
 					
 					function(data){
 						//the CALLBACK
 						/* alert("response received "+data);  */
 					
 						 $("#ch_user1").empty(); /* to clear the id */
 						 $("<option value=--Select-->--Select--</option>").appendTo('#ch_user1');
 						 
 						$.each(data, function (i, data) {
 					        var div_data = "<option value=" + data.id + ">" + data.emailId + "</option>";
 					        /* alert(div_data); */
 					        $(div_data).appendTo('#ch_user1');

 					    });
 						
 					} );
 	}	
 
 </script>   
 <style>
.bg {
	background:
		url('${pageContext.request.contextPath}/resources/core/images/teamBg1.jpg')
		no-repeat;
	background-size: 100%;
	height: 140px;
	display: block;
	padding: 0 !important;
	margin: 0;
	text-align: center;
}
</style>   
  </head>
  <body class="bg" >
<%-- <form:form commandName="helloForm2" name="helloForm2" method="post" id="helloForm2" action="/search">  --%> 
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container container-fluid">
				<div class="navbar-header">
					<div class="row">
						<a class="navbar-brand"
							href=${pageContext.request.contextPath}/admin/test>DAILY EXPENSE
							TRACKER</a>
						<ul class="nav navbar-nav navbar-right">
							<li><a class="navbar-brand" href="#services">Report</a></li>
							<li><a class="navbar-brand"
								href=${pageContext.request.contextPath}/admin/dash>Statistics</a></li>
							<li><a class="navbar-brand"
								href=${pageContext.request.contextPath}/admin/team>Team</a></li>
							<li><a class="navbar-brand"
								href=${pageContext.request.contextPath}/logout.jsp>Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
		<br>
		<br>
  <h1 style="color: white; font-weight: bold; font-family: cursive;"><u>Email</u></h1><br>
  
<div align="center">
<h3 style="color: white; font-weight: bold; font-family: cursive;">To whom do you want to send the Email ?</h3>
<select id="searchBox" class="form-control" style="width: 200px;" onchange="doSearch();">
        <option value="select">--Select--</option>
        <option value="Dad">Dad</option>
        <option value="Mom">Mom</option>
    </select>
<p>
<h3 style="color: white; font-weight: bold; font-family: cursive;">Oh great!! Please select the email</h3>
<div id="div_source1">
    <select id="ch_user1" class="form-control" style="width: 200px;">
        <option value="select">--Select--</option>
    </select>
</div>

<!-- <table><tbody style="width: 100%;">
</tbody>
</table> -->


<%-- <c:forEach var="row" items="${rs.rows}">
    Foo ${row.name}<br/>
    Bar ${row.role}<br/>
</c:forEach> --%>
<%-- </form:form>  --%>
</div>
  </body>
</html>