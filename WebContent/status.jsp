<%@page import="java.util.ArrayList"%>
<%@page import="model.Appointment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Status</title>
</head>
<body>
<h3 align="center">APPOINTMENT DEATAIL</h3>
<hr>
<br>
<%
@SuppressWarnings("unchecked")
ArrayList<Appointment> list = (ArrayList<Appointment>)request.getAttribute("list");
%>
<table border="1" align="center">
<tr>
<th></th>
<th>Ticket No.</th>
<th>Patient Aadhar Id</th>
<th>illness</th>
</tr>
<tr>
<%
	if(list != null){
	int count = 0; 
	for(Appointment a : list)
	{
%>
<td><input type="checkbox" name="check" value=<%= a.getAadhar() %>></td>
<td><%= a %></td>
<td><%= a.getAadhar()%></td>
<td><%= a.getIllness() %></td>
</tr>
<%
		}
	}
%>
</table>
<br></br>
<div class="a" align="center">
<input type="button" name="update" value="Update">
<input type="button" name="update" value="Delete">
</div>
</body>
</html>