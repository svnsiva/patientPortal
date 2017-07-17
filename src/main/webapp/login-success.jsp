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
    <div class="panel-heading"><h1 class="text-center">Welcome to patient portal at Childrens National - Account Details</h1></div>
    <div class="panel-body">
	<div><h2><p class=" bg-success text-center"><%String info=request.getAttribute("status").toString();
	out.print(info); %></p></h2></div>
	 <div>
	 <div class="media">
    <div class="media-left">
      <img style="margin-left: 50px;" src="process-login.png" class="media-object" >
    </div>
    <div class="media-body text-center">
      <div><br><div>
    <label for="name">To view the bills you paid and pending:</label>
	<div><a href="bills.jsp"><button type="button" class="btn btn-primary btn-lg">Bills History</button></a>
	</div></div><br><br>
	<div>
    <label for="name">Payment processing:</label>
	<div><a href="payment.jsp"><button type="button" class="btn btn-primary btn-lg">Payment</button></a>
	</div></div>
      
      </div>
    </div>
    </div>
  </div> 
</div></div></div>
</body>
</html>
