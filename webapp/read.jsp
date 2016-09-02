<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.politician.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, shrink-to-fit=no, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Plutocracy</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/simple-sidebar.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
</head>
<body>

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="index.html"> Plutocracy
				</a></li>
				<li><a href="readdb.html">Read</a></li>
				<li><a href="addtodb.html">Add</a></li>
				<li><a href="updatedb.html">Update</a></li>
				<li><a href="deletefromdb.html">Delete</a></li>
			</ul>
		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
					
						<h1>Plutocracy - Read</h1>
						
						<table style="width: 80%;">
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>State</th>
								<th>Occupation</th>
								<th>Political Party</th>
								<th>Religion</th>
								<th>Alignment</th>
							</tr>
							
							<% DAO.readFromDB(); %>
							<% 
							CandidatesForum readToJSP = new CandidatesForum();
							for (int i=0; i < DAO.ourRulers.size(); i++) {
								readToJSP = DAO.ourRulers.get(i);
								%>
							<tr>
								<td><%= readToJSP.getFirst_name() %></td>
								<td><%= readToJSP.getLast_name() %> </td>
								<td><%= readToJSP.getState() %></td>
								<td><%= readToJSP.getOccupation() %></td>
								<td><%= readToJSP.getParty_affiliation() %></td>
								<td><%= readToJSP.getReligion() %></td>
								<td><%= readToJSP.getAlignment() %></td>
								
							</tr>
							<% }
							DAO.ourRulers.clear();
							%>
						</table>

					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>

</body>
</html>

