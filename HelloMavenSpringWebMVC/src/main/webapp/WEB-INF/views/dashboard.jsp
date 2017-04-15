<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type"
	content="text/html; accept-charset=utf-8" />
<link rel="icon" type="image/png" href="assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Light Bootstrap Dashboard by Creative Tim</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<spring:url value="/resources/core/jquery/jquery.canvasjs.min.js"
	var="jqueryJs" />
<spring:url value="/resources/core/jquery/jquery.js" var="coreJs" />

<script src="${coreJs}"></script>
<script src="${jqueryJs}"></script>
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<script type="text/javascript">
/* window.onload = function () {
	pchart();
} */
function pchart (vegetables, grocery, bakery, medecine, entertainment, bills, otherExpenses) {
	var veg = vegetables
	var groc = grocery
	var baker = bakery
	var mede = medecine
	var entertain = entertainment
	var bill = bills
	var otherExpense = otherExpenses
	var chart = new CanvasJS.Chart("chartContainer",
	{
		title:{
			text: "Statistics"
		},
		exportFileName: "Pie Chart",
		exportEnabled: true,
                animationEnabled: true,
		legend:{
			verticalAlign: "bottom",
			horizontalAlign: "center"
		},
		data: [
		{       
			type: "pie",
			showInLegend: true,
			toolTipContent: "{name}: <strong>{y}%</strong>",
			indexLabel: "{name} {y}%",
			dataPoints: [
				{  y: veg, name: "Vegetables", exploded: true},
				{  y: groc, name: "Grocery"},
				{  y: baker, name: "Bakery"},
				{  y: mede, name: "Medecine"},
				{  y: entertain,  name: "Entertainment"},
				{  y: bill,  name: "Bills"},
				{  y: otherExpense,  name: "Other Expenses"}
			]
	}
	]
	});
	chart.render();
}
function stat() {
	alert("submit2");
	$("#helloForm").attr('action', '${pageContext.request.contextPath}/statcalc');
	$("#helloForm").submit();
}
</script>
<script type="text/javascript" src="/resources/core/js/canvasjs.min.js"></script>
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
}
</style>
</head>
<body class="bg">
	<form:form commandName="helloForm" name="helloForm" method="post"
		id="helloForm" action="/dash">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container container-fluid">
				<div class="navbar-header">
					<div class="row">
						<a class="navbar-brand"
							href=${pageContext.request.contextPath}/test>DAILY EXPENSE
							TRACKER</a>
						<ul class="nav navbar-nav navbar-right">
							<li><a class="navbar-brand" href=${pageContext.request.contextPath}/search>Search</a></li>
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
		<p>
			<br>
		<div class="container">
			<div class="btn btn-default" title="Click here"
				onclick="pchart(${helloForm.categoryPercentVO.vegetables},${helloForm.categoryPercentVO.grocery},${helloForm.categoryPercentVO.bakery},${helloForm.categoryPercentVO.medecine},${helloForm.categoryPercentVO.entertainment},${helloForm.categoryPercentVO.bills},${helloForm.categoryPercentVO.otherExpenses}
);">
				<h5>
					<b>Show me the stat <i class="fa fa-pie-chart"
						aria-hidden="true"></i><b></b>
				</h5>
			</div>
		</div>
		<br>
		<c:if test="${helloForm.categoryPercentVO ne null }">
			<div id="chartContainer" style="height: 450px; width: 100%;"></div>
		</c:if>
	</form:form>
</body>
</html>
