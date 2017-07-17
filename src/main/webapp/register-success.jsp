<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">
<div class="panel panel-default">
    <div class="panel-heading"><h1 class="text-center">Welcome to patient portal at Childrens National - Registration</h1></div>
    <div class="panel-body">
    <br>
    <h3><%String info=request.getAttribute("status").toString();
	out.print(info); %></h3>
	<br>
	<div>
    <label for="name">For signing in and viewing your bills, please login in</label>
	<a href="login.jsp"><button type="button" class="btn btn-primary btn-lg">Login</button></a>
	</div>
	
</div></div></div>
</body>
</html>