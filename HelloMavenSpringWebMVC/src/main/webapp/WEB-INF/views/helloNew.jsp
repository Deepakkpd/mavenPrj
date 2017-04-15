<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type"
	content="text/html; accept-charset=utf-8" />
<title>Maven + Spring MVC + @JavaConfig</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<style>
.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}

.checkbox label:after, .radio label:after {
	content: '';
	display: table;
	clear: both;
}

.checkbox .cr, .radio .cr {
	position: relative;
	display: inline-block;
	border: 1px solid #a9a9a9;
	border-radius: .25em;
	width: 1.3em;
	height: 1.3em;
	float: left;
	margin-right: .5em;
}

.radio .cr {
	border-radius: 50%;
}

.checkbox .cr .cr-icon, .radio .cr .cr-icon {
	position: absolute;
	font-size: .8em;
	line-height: 0;
	top: 50%;
	left: 20%;
}

.radio .cr .cr-icon {
	margin-left: 0.04em;
}

.checkbox label input[type="checkbox"], .radio label input[type="radio"]
	{
	display: none;
}

.checkbox label input[type="checkbox"]+.cr>.cr-icon, .radio label input[type="radio"]+.cr>.cr-icon
	{
	transform: scale(3) rotateZ(-20deg);
	opacity: 0;
	transition: all .3s ease-in;
}

.checkbox label input[type="checkbox"]:checked+.cr>.cr-icon, .radio label input[type="radio"]:checked+.cr>.cr-icon
	{
	transform: scale(1) rotateZ(0deg);
	opacity: 1;
}

.checkbox label input[type="checkbox"]:disabled+.cr, .radio label input[type="radio"]:disabled+.cr
	{
	opacity: .5;
}

</style>

</head>
<body>
	<form:form commandName="helloForm" name="helloForm" method="post"
		id="helloForm" action="/test">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container container-fluid">
				<div class="navbar-header">
					<div class="row">
						<a class="navbar-brand" href="#">DAILY EXPENSE TRACKER</a>
						<ul class="nav navbar-nav navbar-right">
							<li><a class="navbar-brand" href=${pageContext.request.contextPath}/search>Search</a></li>
							<li><a class="navbar-brand" href=${pageContext.request.contextPath}/dash>Statistics</a></li> 
							<li><a class="navbar-brand" href=${pageContext.request.contextPath}/team>Team</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
		<br><br><br>
<div>
		<div class="container">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<div style="text-align: left;">
						<span class="icon-bar"><b><font size="5px">Date:
									<form:input path="dateOfExpend" id="datepicker"
										cssStyle="color:#000000" readonly="true" />
							</font></b></span>
										<font style=" color:white; size: 5">
<c:out value="${helloForm.errorMsgDt}"></c:out> </font>
					</div>
				</div>
			</div>
			
			<font style="font: italic; font: bold; color: red; size: 2">
<c:out value="${helloForm.errorMsg}"></c:out> </font>
			<table class="table table-hover"
				style="width: 100%; border-style: solid; border-width: 4px;"
				border="12px;">
				<thead>
					<tr align="center">
						<th>
							<div class="panel panel-primary">
								<div class="panel-heading">
									<div style="text-align: center;">
										<span class="icon-bar"><font size="5px">Sel No.</font>
										</span>
									</div>
								</div>
							</div>
						</th>
						<th>
							<div class="panel panel-primary">
								<div class="panel-heading">
									<div style="text-align: center;">
										<span class="icon-bar"><font size="5px">Item
												Name</font> </span>
									</div>
								</div>
							</div>
						</th>
						<th>
							<div class="panel panel-primary">
								<div class="panel-heading">
									<div style="text-align: center;">
										<span class="icon-bar"><font size="5px">Price</font></span>
									</div>
								</div>
							</div>
						</th>
						<th>
							<div class="panel panel-primary">
								<div class="panel-heading">
									<div style="text-align: center;">
										<span class="icon-bar"><font size="5px">Category</font>
										</span>
									</div>
								</div>
							</div>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr class="active" align=center>
						<td>

							<div class="checkbox">
								<label> <input type="checkbox"
									name="helloVO[0].checkIndicator"> <span
									class="cr"><i class="cr-icon glyphicon glyphicon-ok"></i></span>
									<b>1.</b>
								</label>
							</div>

						</td>
						<td><form:input path="helloVO[0].name" class="alphaonly" size="70px" /></td>
						<td><form:input path="helloVO[0].price" class="nmbronly" size="35px" /></td>
						<td>
							<div class="btn-group">
								<form:select path="helloVO[0].category" class="btn btn-danger">
									<form:option value="">-Select-</form:option>
									<form:option value="Vegetables">Vegetables</form:option>
									<form:option value="Grocery">Grocery</form:option>
									<form:option value="Bakery">Bakery</form:option>
									<form:option value="Medecine">Medecine</form:option>
									<form:option value="Entertainment">Entertainment</form:option>
									<form:option value="Bills">Bills</form:option>
									<form:option value="Other Expenses">Other Expenses</form:option>
								</form:select>
							</div>
						</td>
					</tr>
					<tr class="success" align="center">
						<td>
							<div class="checkbox">
								<label> <input type="checkbox"
									name="helloVO[1].checkIndicator" > <span
									class="cr"><i class="cr-icon glyphicon glyphicon-ok"></i></span>
									<b>2.</b>
								</label>
							</div>
						</td>
						<td><form:input path="helloVO[1].name" class="alphaonly" size="70px" /></td>
						<td><form:input path="helloVO[1].price" size="35px" class="nmbronly"/></td>
						<td><form:select path="helloVO[1].category"
								class="btn btn-danger">
								<form:option value="">-Select-</form:option>
									<form:option value="Vegetables">Vegetables</form:option>
									<form:option value="Grocery">Grocery</form:option>
									<form:option value="Bakery">Bakery</form:option>
									<form:option value="Medecine">Medecine</form:option>
									<form:option value="Entertainment">Entertainment</form:option>
									<form:option value="Bills">Bills</form:option>
									<form:option value="Other Expenses">Other Expenses</form:option>
							</form:select></td>
					</tr>
					<tr class="danger" align="center">
						<td>
							<div class="checkbox">
								<label> <input type="checkbox"
									name="helloVO[2].checkIndicator" > <span
									class="cr"><i class="cr-icon glyphicon glyphicon-ok"></i></span>
									<b>3.</b>
								</label>
							</div>
						</td>
						<td><form:input path="helloVO[2].name" class="alphaonly" size="70px" /></td>
						<td><form:input path="helloVO[2].price" size="35px" class="nmbronly"/></td>
						<td><form:select path="helloVO[2].category"
								class="btn btn-danger">
								<form:option value="">-Select-</form:option>
									<form:option value="Vegetables">Vegetables</form:option>
									<form:option value="Grocery">Grocery</form:option>
									<form:option value="Bakery">Bakery</form:option>
									<form:option value="Medecine">Medecine</form:option>
									<form:option value="Entertainment">Entertainment</form:option>
									<form:option value="Bills">Bills</form:option>
									<form:option value="Other Expenses">Other Expenses</form:option>ion>
							</form:select></td>
					</tr>
					<tr class="info" align="center">
						<td>
							<div class="checkbox">
								<label> <input type="checkbox"
									name="helloVO[3].checkIndicator" > <span
									class="cr"><i class="cr-icon glyphicon glyphicon-ok"></i></span>
									<b>4.</b>
								</label>
							</div>
						</td>
						<td><form:input path="helloVO[3].name" class="alphaonly" size="70px" /></td>
						<td><form:input path="helloVO[3].price" size="35px" class="nmbronly"/></td>
						<td><form:select path="helloVO[3].category"
								class="btn btn-danger" >
								<form:option value="">-Select-</form:option>
									<form:option value="Vegetables">Vegetables</form:option>
									<form:option value="Grocery">Grocery</form:option>
									<form:option value="Bakery">Bakery</form:option>
									<form:option value="Medecine">Medecine</form:option>
									<form:option value="Entertainment">Entertainment</form:option>
									<form:option value="Bills">Bills</form:option>
									<form:option value="Other Expenses">Other Expenses</form:option>
							</form:select></td>
					</tr>
					<tr class="warning" align="center">
						<td>
							<div class="checkbox">
								<label> <input type="checkbox"
									name="helloVO[4].checkIndicator" > <span
									class="cr"><i class="cr-icon glyphicon glyphicon-ok"></i></span>
									<b>5.</b>
								</label>
							</div>
						</td>
						<td><form:input path="helloVO[4].name" class="alphaonly" size="70px" /></td>
						<td><form:input path="helloVO[4].price" size="35px" class="nmbronly"/></td>
						<td><form:select path="helloVO[4].category"
								class="btn btn-danger" >
								<form:option value="">-Select-</form:option>
									<form:option value="Vegetables">Vegetables</form:option>
									<form:option value="Grocery">Grocery</form:option>
									<form:option value="Bakery">Bakery</form:option>
									<form:option value="Medecine">Medecine</form:option>
									<form:option value="Entertainment">Entertainment</form:option>
									<form:option value="Bills">Bills</form:option>
									<form:option value="Other Expenses">Other Expenses</form:option>
							</form:select></td>
					</tr>
					<tr class="active" align="center">
						<td>
							<div class="checkbox">
								<label> <input type="checkbox"
									name="helloVO[5].checkIndicator" > <span
									class="cr"><i class="cr-icon glyphicon glyphicon-ok"></i></span>
									<b>6.</b>
								</label>
							</div>
						</td>
						<td><form:input path="helloVO[5].name" class="alphaonly" size="70px" /></td>
						<td><form:input path="helloVO[5].price" size="35px" class="nmbronly"/></td>
						<td><form:select path="helloVO[5].category"
								class="btn btn-danger">
								<form:option value="">-Select-</form:option>
									<form:option value="Vegetables">Vegetables</form:option>
									<form:option value="Grocery">Grocery</form:option>
									<form:option value="Bakery">Bakery</form:option>
									<form:option value="Medecine">Medecine</form:option>
									<form:option value="Entertainment">Entertainment</form:option>
									<form:option value="Bills">Bills</form:option>
									<form:option value="Other Expenses">Other Expenses</form:option>
							</form:select></td>
					</tr>
					<tr class="info" align="center">
						<td></td>
						<td>
								<button class="btn btn-info btn-md" onclick="insert();">
									<b>Insert</b>
								</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<button class="btn btn-info btn-md" onclick="sbmt();">
									<i class="fa fa-calculator" aria-hidden="true"></i>
									<b>Calculate</b>
								</button>
						</td>
						<td>
							<div class="panel panel-danger">
								<div data-toggle="tooltip" title="Yup tat's the Total!"
									class="panel-heading">
									<font style="size: 1;"><b><c:out
												value="${helloForm.totalAmt}"></c:out></b></font>
								</div>
							</div>
						</td>
						<td><a href="#" onClick="mail();"><img
							src="${pageContext.request.contextPath}/resources/core/images/mail.jpg" style="height: 30px"/>
								<b><u><font
											style="color: black;">Send Mail </font></u></b></a></td>
					</tr>
				</tbody>
			</table>
			<hr>
			<footer>
				<p>&copy; Deepak.com 2017</p>
			</footer>
		</div>
		
		
		</div>
		<spring:url value="/resources/core/css/hello.js" var="coreJs" />
		<spring:url value="/resources/core/css/bootstrap.min.js"
			var="bootstrapJs" />
		<spring:url value="/resources/core/jquery/jquery.js" var="jqueryJs" />

		<script src="${coreJs}"></script>
		<script src="${bootstrapJs}"></script>
		<script src="${jqueryJs}"></script>
		<script src="${datetimepickerJs}"></script>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

		<link rel="stylesheet"
			href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<link rel="stylesheet" href="/resources/demos/style.css">
		<link
			href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
			rel="stylesheet">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script
			src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.12.0/jquery.validate.min.js"
type="text/javascript"></script>
<spring:url value="/resources/core/jquery/jquery.validate.min.js" var="jqueryValJs" />
		<script src="${jqueryValJs}"></script>
		<!-- <script>
		$("#helloForm").validate(
				{
				rules: 
				{
					dateOfExpend: 
				{
				/* required: true */
				},
				messages: 
				{
					dateOfExpend: 
				{
				required: "Please enter your name"
				}
				}
				}
				}); 
		</script> -->
		<script type="text/javascript">
$('.alphaonly').bind('keyup blur',function(){ 
    var node = $(this);
    node.val(node.val().replace(/[^a-zA-Z ]/g,'') ); }
);
</script>
<script type="text/javascript">
$('.nmbronly').bind('keyup blur',function(){ 
    var node = $(this);
    node.val(node.val().replace(/[^0-9.]/g,'') ); }
);
</script>

		<script type="text/javascript" >
			function sbmt() {
				$("#helloForm").attr('action', '${pageContext.request.contextPath}/result');
				$("#helloForm").submit();

			}
			function insert() {
				alert("Checked Rows will be inserted");
				$("#helloForm").attr('action', '${pageContext.request.contextPath}/itemDtlInsert');
				$("#helloForm").submit();

			}
			function mail() {
				$("#helloForm").attr('action', '${pageContext.request.contextPath}/email');
				$("#helloForm").submit();
			}
		</script>
		<script>
			$(document).ready(function() {
				$('[data-toggle="tooltip"]').tooltip();
			});
		</script>
		<script>
			$(function() {
				$("#datepicker").datepicker();
			});
		</script>

	</form:form>
</body>
</html>