<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
<form action="Service" method="post">
  <div class="container">
  
    <h1>Login</h1>
    <hr>
    
    <input type="hidden" name="req" value="loginform">

	<label for="aadhar"><b>Aadhar ID</b></label>
    <input type="text" placeholder="Enter Aadhar no." name="id" required> 
    <br><br>
    
    <label for="password"><b>password </b></label>
    <input type="password" placeholder="Enter password" name="password" required>
	<br>
	
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
    <button type="submit" class="registerbtn">sign in</button>
 	</div>

	 <div class="container signin">
	   <p> <a href="index.jsp">Sign up</a></p>
	 </div>
  
</form>
</body>
</html>