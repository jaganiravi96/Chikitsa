<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment</title>
</head>
<body>
<form action="Service" method="get">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an appointment.</p>
    <hr>
    
    <input type="hidden" name="reqflag" value="appointment">

    <label for="aadhar"><b>Aadhar Id</b></label>
    <input type="text" placeholder="Enter Aadhar Id" name="aadhar" required>
	<br>
	
	<label for="illness"><b>Type of illness</b></label>
    <input type="text" placeholder="Enter illness" name="illness" required> 
    <br>
    
    <label for="symptoms"><b>symptoms</b></label>
    <input type="text" placeholder="Enter symptoms" name="symptoms" required> 
    <br>
    
    <label for="Duration"><b>Duration</b></label>
    <input type="text" placeholder="Enter Duration" name="duration" required> 
    <br>
  
 	<label for="med"><b>Any Medication</b></label>
    <input type="text" placeholder="Any Medication" name="medication" required> 
    <br>
    
    <label for="history"><b>Medication History</b></label>
    <input type="text" placeholder="Medication History" name="mhistory" required> 
    <br>
    
    <label for="History"><b>Generic History</b></label>
    <input type="text" placeholder="Generic History" name="ghistory" required> 
    <br>
    
    <label for="severity"><b>Severity</b></label>
    <input type="text" placeholder="Severity" name="severity" required> 
    <br>
      
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
    <button type="submit" class="registerbtn">Register</button>
 	</div>

</form>
<hr>
</body>
</html>