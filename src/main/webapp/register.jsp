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
    <div class="panel-heading"><h1 class="text-center">Welcome to patient portal at childrens National - Registration</h1></div>
    <div class="panel-body">
     <form action="reg.do" method="post">
    <div class="form-group form-inline">
      <label for="name">Name:    </label>
      <input type="text" class="form-control" placeholder="Enter name" name="FullName" required>
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="Email" required>
    </div>
    <div class="form-group form-inline">
      <label for="age">Age:</label>
      <input type="text" class="form-control" id="age" placeholder="Enter Age" name="Age" required>
      <label for="weight">Weight:</label>
      <input type="text" class="form-control" id="weight" placeholder="Enter Weight" name="Weight" required>
    </div>
    <div class="form-group form-inline">
    	
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="Password" required>
    </div>
    <div class="form-group form-inline">
    	
     <label for="problem">Please select your problem :</label>
      <select class="form-control" id="sel1" name="Problem" >
        <option>Ortho</option>
        <option>Kidney</option>
        <option>Cancer</option>
        <option>Liver</option>
        <option>General</option>
        <option>ENT</option>
      </select>
      
    </div>
 	 <div class="form-group form-inline">
    	
     <div><label for="security">Please select the question :</label></div>
      <select class="form-control" id="sel1" name="Security">
        <option>1.What is the name of your elementary / primary school?</option>
        <option>2.What is the name of your first boy/girl friend?</option>
        <option>3.What is your hometown?</option>
        <option>4.In what city or town does your nearest sibling live?</option>
        
      </select>
      <label for="security">Answer :</label>
      <input type="text" class="form-control" id="answer" placeholder="Enter answer" name="Answer" required>
 	 </div>
 	 
    <div class="form-group from-inline">
    <label for="gender">Gender :</label>
    <label class="radio-inline"><input type="radio" name="Gender" value="male" required>Male</label>
    <label class="radio-inline"><input type="radio" name="Gender" value="female" required>Female</label>
    </div>
    <div class="form-group from-inline">
    <label for="insurance">Do you have insurance :</label>
    <label class="radio-inline"><input type="radio" name="Insurance" value="yes" required>Yes</label>
    <label class="radio-inline"><input type="radio" name="Insurance" value="no" required>No</label>
    </div>
    <div class="form-group from-inline">
    <label for="special">Information :</label>
    	<label class="checkbox-inline"><input type="checkbox" value="Disabled" name="Options" >Disabled</label>
    	<label class="checkbox-inline"><input type="checkbox" value="Veterans" name="Options">Veterans</label>
    	<label class="checkbox-inline"><input type="checkbox" value="Senior" name="Options">Senior Citizen</label>
    	
    </div>
    <button type="submit" class="btn btn-default" name="Submit">Submit</button>
  </form>
</div>
</div>
  </div>

</body>
</html>
		