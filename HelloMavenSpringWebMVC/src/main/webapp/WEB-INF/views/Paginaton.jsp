<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html  lang="en">
  <head>
    <title>Pagination</title>
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
 
 	function selectedPageNo(row){
 		/* alert("row:"+row); */
 		$('#selectedPageNoId').val(row);
 		$("#pagingForm").attr('action', '${pageContext.request.contextPath}/selectedPage');
 		$("#pagingForm").submit(); 
 	}
 
 </script>   
 <style>
.bg {
	background:
		url('${pageContext.request.contextPath}/resources/core/images/teamBg1.jpg')
		no-repeat;
	background-size: 100%;
	height: 140px;
	padding: 0 !important;
	text-align: center;
}
</style>   
  </head>
  <body class="bg">
<form:form commandName="pagingForm" name="pagingForm" method="post" id="pagingForm" action="/userPagination">  
<form:hidden path="selectedPageNo" id="selectedPageNoId"/>
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
  <h1 style="color: white; font-weight: bold; font-family: cursive;"><u>Pagination</u></h1><br>
  

<div align="center">
<table class="table table-hover" style="width: 30%;"><thead>
<tr style="color: purple; background-color: aqua; font-family: cursive;"> 

   <th style="width: 50%;" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>User ID</u></th>
    <th style="width: 50%;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>User Name</u></th></tr></thead>
    <tbody>
<c:forEach var="row" items="${pagingForm.userList}">
   <tr class="active" align=center > 
   <td style="width: 50%;">${row.userid}</td>
    <td style="width: 50%;">${row.userName}</td></tr>
</c:forEach> 
</table>
   <h5 style="color: white; font-weight: bold; font-family: cursive;">
   <a href = "javascript:selectedPageNo(1);" data-toggle="tooltip" title="First Page">
   <i class="fa fa-angle-left" aria-hidden="true"></i>
   </a>
   <c:if test="${pagingForm.selectedPageNo ne 1 && pagingForm.selectedPageNo ne 0 }">
   <a href ="javascript:selectedPageNo(${pagingForm.selectedPageNo-1});" data-toggle="tooltip" title="Previous Page"><i class="fa fa-chevron-left" aria-hidden="true"></i></a>
   </c:if>
   <c:forEach var="row" items="${pagingForm.pageNoList}" varStatus="loop">
    <ul class="pagination">
    <c:if test="${pagingForm.selectedPageNo eq row }">
    <h4 style="color: white; font-weight: bold; font-family: cursive;">
   	 <b><i><a href="javascript:selectedPageNo(${row});" ><u>${row}</u>&nbsp;</a></i></b>
   	 <c:set var="selectedPg" value="${row}"></c:set>
   	 </h4>
   	 </c:if>
   	  <c:if test="${pagingForm.selectedPageNo ne row }">
   	  <a href="javascript:selectedPageNo(${row});">${row}&nbsp;</a>
   	 </c:if> 
   	 <c:set var="lastPage" value="${loop.index}"></c:set>
   	 </ul>
   </c:forEach>
   <c:if test="${pagingForm.selectedPageNo ne lastPage+1}">
   <a href ="javascript:selectedPageNo(${selectedPg+1});" data-toggle="tooltip" title="Next Page"><i class="fa fa-chevron-right" aria-hidden="true"></i></a>
   </c:if>
   <a href = "javascript:selectedPageNo(${lastPage+1});" data-toggle="tooltip" title="Last Page">
   <i class="fa fa-angle-right" aria-hidden="true"></i>
   </a>
</h5>  
</div>
</form:form> 

  </body>
</html>