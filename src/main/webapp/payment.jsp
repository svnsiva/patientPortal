<%@page import="com.patient.portal.repository.PRepository"%>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  	body { margin-top:20px; }
.panel-title {display: inline;font-weight: bold;}
.checkbox.pull-right { margin: 0; }
.pl-ziro { padding-left: 0px; }
  </style>
  
  
</head>

<body>

<div class="container">

<div class="panel panel-default span12">
    <div class="panel-heading"><h1 class="text-center">Welcome to patient portal at Childrens National - Payment</h1></div>
    <div class="panel-body text-center">
	
	<form action="pay.do" method="post">
    <div class="row">
    	<div class="col-sm-12 col-sm-offset-3">
        <div class="col-xs-12 col-md-4">
            <div class="panel panel-primary ">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Payment Details
                    </h3>
                    
                </div>
                <% 
                	PRepository pr= new PRepository();
                int diagFee = pr.getDiagFee();
                int regFee = pr.getRegfee();
                
                		
                %>
                <div class="panel-body">
                   <div class="form-group form-inline">
            	<label for="price">Select Bill :</label>
      			<select class="form-control" id="sel1" name="Price" >
        			<option>Registration Fee - $<%out.print(regFee); %></option>
        			<option>Diagnosis Fee - $<%out.print(diagFee); %></option>
        		</select>
            </div>
                    <div class="form-group">
                        <label for="cardNumber">
                            CARD NUMBER</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="cardNumber" placeholder="Valid Card Number"
                                required autofocus name="Number"/>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                      <!-- Name -->
          <div class="control-group">
            <label class="control-label"  for="username">CARD HOLDER'S NAME</label>
            <div class="controls">
                 <input type="text" class="form-control" id="cardNumber" placeholder="Enter your name"
                                required name="Name" />
            </div>
          </div>
                    <div class="row">
                        <div class="col-xs-7 col-md-7">
                            <div class="form-group">
                                <label for="expityMonth">
                                    EXPIRY DATE</label>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityMonth" placeholder="MM" required name="Month"/>
                                </div>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityYear" placeholder="YY" required name="Year"/></div>
                            </div>
                        </div>
                        <div class="col-xs-5 col-md-5 pull-right">
                            <div class="form-group">
                                <label for="cvCode">
                                    CVV2 CODE</label>
                                <input type="password" class="form-control" id="cvCode" placeholder="CVV2" required name="Cvv"/>
                            </div>
                        </div>
                    </div>
                   
                </div>
            </div>
            
            
            <br/>
            <Button type="submit" class="btn btn-success btn-lg btn-block" role="button">Pay</Button>
        </div></div></div>
        </form></div>
	
	</div>
	</div>

</body>
</html>
