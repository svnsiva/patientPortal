<%@page import="com.patient.portal.PatientRegistrationServlet"%>
<%@page import="com.patient.portal.modal.PatientBills"%>
<%@page import="com.patient.portal.repository.PRepository"%>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<% PRepository pr =new PRepository();
	PatientBills data= pr.billsData();
	int reg=data.getReg(),diag=data.getDiagnosis(),regP=0,diagP=0;
	if(data.isRegPaid())
		regP=1;
	if(data.isDiagnosisPaid())
		diagP=1;
	int paid=0,pend=0;
	if(regP==0&&diagP==0)
		paid=1;
	if(regP==1&&diagP==1)
		pend=1;
	String problem = pr.problemData();
	PatientRegistrationServlet prs = new PatientRegistrationServlet();
	diag=prs.fee(problem);	
	
%>
<div class="container">

<div class="panel panel-default">
    <div class="panel-heading"><h1 class="text-center">Welcome to patient portal at Childrens National - Bills</h1></div>
    <div class="panel-body ">
    <div class="row">
    <div class="col-md-6 col-md-offset-3">
    <div class="panel panel-success">
    <div class="panel-heading"><h2 class="text-center">Paid Bills</h2></div>
    <div class="panel-body ">
	<% if( !(paid==1) ) { %>
	<div>
	<% if( regP==1) { %>
	<div ><dl class="text-center">
    <dt class="bg-primary text-center"><h4>Registration Fee</h4></dt>
    
    <dt>Fee - $20</dt>
    <dd>**Applicable for every patient**</dd>
  	</dl></div>
  	<% } %>
  <% if( diagP==1) { %>
  <div ><dl class="text-center">
    <dt class="bg-primary text-center"><h4>Daignosis Fee</h4></dt>
    
    <dt>Fee - <%out.print(diag); %></dt>
    <dd>**Applicable for <%out.print(problem); %> diagnosis**</dd>
  </dl></div>
  <% } %>
  </div>
  
  <% } %>
  <% if( paid==1 ) { %>
  	<div>
	
	<div ><dl class="text-center">
    <dt class="bg-primary text-center"><h4>No bills paid</h4></dt>
    
  </dl></div>
  <% } %>
  
</div></div></div></div>
    <div class="col-md-6 col-md-offset-3">
    <div class="panel panel-danger">
    <div class="panel-heading"><h2 class="text-center">Pending Bills</h2></div>
    <div class="panel-body ">
    <% if( !(pend ==1)) { %>
	<div>
	<% if( !(regP==1)) { %>
	<div ><dl class="text-center">
    <dt class="bg-primary text-center"><h4>Registration Fee</h4></dt>
    
    <dt>Fee - $20</dt>
    <dd>**Applicable for every patient**</dd>
  </dl></div>
  <% } %>
  <% if( !(diagP==1)) { %>
  <div ><dl class="text-center">
    <dt class="bg-primary text-center"><h4>Daignosis Fee</h4></dt>
    
    <dt>Fee - <%out.print(diag); %></dt>
    <dd>**Applicable for <%out.print(problem); %> diagnosis**</dd>
  </dl></div>
  <% } %>
  </div>
  <% } %>
  
  <% if( pend==1 ) { %>
  	<div>
	
	<div ><dl class="text-center">
    <dt class="bg-primary text-center"><h4>No pending bills</h4></dt>
    
  </dl></div>
  <% } %>
  
</div></div></div></div>

	</div>

<div class="text-center">
    <label for="name"><h3>To pay for unpaid bills:</h3></label>
	<div><a href="payment.jsp"><button type="button" class="btn btn-primary btn-lg">Payment</button></a>
	</div></div>
</div></div></div>
</body>
</html>
