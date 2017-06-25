<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type"
	content="text/html; accept-charset=utf-8" />
<title>Insert title here</title>
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
	<style >
	.bg{
	background:url('${pageContext.request.contextPath}/resources/core/images/teamBg1.jpg')no-repeat;
background-size:100%;
height: 140px;
display:block;
padding:0 !important;
margin:0;
	}
	</style>

</head>
<body class="bg">
	<form:form commandName="helloForm" name="helloForm" method="post"
		id="helloForm" action="/team">
				<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container container-fluid">
				<div class="navbar-header">
					<div class="row">
						<a class="navbar-brand" href=${pageContext.request.contextPath}/test>DAILY EXPENSE TRACKER</a>
						<ul class="nav navbar-nav navbar-right">
							<li><a class="navbar-brand" href=${pageContext.request.contextPath}/search>Search</a></li>
							<li><a class="navbar-brand" href=${pageContext.request.contextPath}/dash>Statistics</a></li> 
							<li><a class="navbar-brand" href=${pageContext.request.contextPath}/team>Team</a></li>
							<li><a class="navbar-brand"
								href=${pageContext.request.contextPath}/logout.jsp>Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
		<br><br><br><br><br><br><br><br>
		<div align="center">
<a href=${pageContext.request.contextPath}/userPagination><h3 style="color: white; font-weight: bold; font-family: cursive;">Pagination Implementation</h3></a>
</div>
		<div class="container">
<div class="col-sm-4" style="left:0%;">
                    <div class="team-member" ><center>
                        <img src="${pageContext.request.contextPath}/resources/core/images/2.jpg" class="img-responsive img-circle" alt="">
                        <div style=" background: white; width: 45%; ">
                        <font style="color:black; font: bold;">
                        <h4>Deepak Ramanan</h4>
                        <p class="text-muted">Designer/Developer</p></font>
                        <ul class="list-inline social-buttons">
                            <li><a href="#"><i class="fa fa-twitter"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-linkedin"></i></a>
                            </li>
                        </ul></div>
                        </center>
                    </div>
                </div>
</div>
    </form:form>
</body>
</html>