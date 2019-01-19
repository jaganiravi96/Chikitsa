<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
</head>
<body>
Hii   &nbsp;&nbsp;&nbsp; 
<%-- <%= request.getAttribute("name") %> --%>
<a href=""> Logout </a>  
<hr>
<p align="center"><a href="appointment.jsp">New Appointment</a><p>
<hr>
<a href="Service?reqflag=getAptdetail">Manage Appointment</a><br>
<a href="Service?reqflag=getProdetail">Modify profile</a><br>
<a href="status.jsp">Status of ticket</a><br>
<a href="getusers.jsp">Search Users(shows doctor and user profile)</a>
</body>
</html>