<html>
<body>

<h1>Children National Hospital</h1>

 

</body>

</html>

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
    <div class="panel-heading"><h1 class="text-center">Welcome to patient portal at Childrens National - Registration </h1></div>
    <div class="panel-body text-center">
    <br><br>
	<h3><%
	String info=request.getAttribute("status").toString();
	out.print(info);
%></h3>
	
</div></div></div>
</body>
</html>
