<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title><!-- Latest compiled and minified CSS -->
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><style>
</style>
</head>
<!-- <body style="background-image:url(http://cdn.idigitaltimes.com/sites/idigitaltimes.com/files/2016/04/27/wolverinex-menapocalpse.jpg)"> -->
<body style="background-image:url(http://guidetoillawarra.com.au/wp-content/uploads/2015/08/Antiquies-in-Illawarra.jpg)">
<div align="center">
 <img src="http://cdn.idigitaltimes.com/sites/idigitaltimes.com/files/2016/04/27/wolverinex-menapocalpse.jpg" class="img-circle" alt="bg" width="304" height="236">
</div>
<center>
<h2>Student Information</h2>
<div class="container-fluid">
<form:form method="POST" action="/addStudent"> 
   <table class="table table-hover" style="width: 50%">
    <tr class="row">
        <td style="background-color: green;" align="center" width="50%"><form:label path="name"><font style="color: white; font-family: inherit; s"><b>Name</font><b></form:label></td>
        <td align="center" width="50%"><form:input path="name" /></td>
    </tr>
    <tr class="row">
        <td style="background-color:blue;" align="center" width="50%><form:label path="age"><font style="color: white;"><b>Age</font></form:label></td>
        <td align="center" width="50%"><form:input path="age" /></td>
    </tr>
    <tr class="row">
        <td style="background-color:orange;" align="center" width="50%><form:label path="id"><font style="color: white;"><b>id</font></form:label></td>
        <td align="center" width="50%"><form:input path="id" /></td>
    </tr>
    <div>
    <table>
           <tr> <input type="submit" value="Submit"/>
    </table>
   </div>
</table>  
</form:form>

</center>
</div>
</body>
</html>