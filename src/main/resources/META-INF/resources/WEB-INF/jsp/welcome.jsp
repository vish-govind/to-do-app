<html>
	<head>
		<title>Welcome Page</title>
	</head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	<body>
			<%@ include file="common/navigation.jspf" %>
		<div class="container">	
			<div><h1>Hi ${name}!</h1></div>
			<div><h1>Welcome to ToDo App</h1></div>
			<div><a href = "list-todos">Manage your Todo's</a></div>
		</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>