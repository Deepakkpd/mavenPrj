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
 		
 		$.getJSON("searchItem",
 					{CHARS: $('#searchBox').val()},
 					
 					function(data){
 						//the CALLBACK
 						/* alert("response received "+data); */
 						$('#results').text('');
 						
 						for(var index in data){
 							$('#results').append('<table class="table table-hover" style="width: 75%;"><tbody><tr class="active" style="width: 100;" align=center><td>'+data[index].name+'</td><td>'+data[index].price+'</td><td>'+data[index].category+'</td><td>'+data[index].purchaseDate+'</td><tr></tbody></table>');
 						}
 					});
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
<form:form commandName="helloForm2" name="helloForm2" method="post" id="helloForm2" action="/search">  
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container container-fluid">
				<div class="navbar-header">
					<div class="row">
						<a class="navbar-brand"
							href=${pageContext.request.contextPath}/test>DAILY EXPENSE
							TRACKER</a>
						<ul class="nav navbar-nav navbar-right">
							<li><a class="navbar-brand" href="#services">Report</a></li>
							<li><a class="navbar-brand"
								href=${pageContext.request.contextPath}/dash>Statistics</a></li>
							<li><a class="navbar-brand"
								href=${pageContext.request.contextPath}/team>Team</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
		<br>
		<br>
  <h1 style="color: white; font-weight: bold; font-family: cursive;"><u>Search by Item Name</u></h1><br>
  
<div align="center">
<input class="form-control" id="searchBox" style="width: 1000px;" type="text" onkeyup="doSearch();" placeholder="Enter the Item Name to search"/><p>
<table   style="width: 75%;"><thead> 					<tr align="center"> 						<th> 							<div class="panel panel-primary"> 								<div class="panel-heading"> 									<div style="text-align: center;"> 										<span class="icon-bar"><font size="3">Item 												Name</font> </span> 									</div> 								</div> 							</div> 						</th> 						<th> 							<div class="panel panel-primary"> 								<div class="panel-heading"> 									<div style="text-align: center;"> 										<span class="icon-bar"><font size="3">Price</font></span> 									</div> 								</div> 							</div> 						</th> 						<th> 							<div class="panel panel-primary"> 								<div class="panel-heading"> 									<div style="text-align: center;"> 										<span class="icon-bar"><font size="3">Category</font> 										</span> 									</div> 								</div> 							</div> 						</th> 		<th> 							<div class="panel panel-primary"> 								<div class="panel-heading"> 									<div style="text-align: center;"> 										<span class="icon-bar"><font size="3">Item 												Spend Date</font> </span> 									</div> 								</div> 							</div> 						</th>			</tr> 				</thead></table>
<div id="results" class="table">
	<h4 style="color: white; font-weight: bold; font-family: cursive;">
	Results will appear here....</h4>
</div>
<!-- <table><tbody style="width: 100%;">
</tbody>
</table> -->


<%-- <c:forEach var="row" items="${rs.rows}">
    Foo ${row.name}<br/>
    Bar ${row.role}<br/>
</c:forEach> --%>
</form:form> 
</div>
  </body>
</html>