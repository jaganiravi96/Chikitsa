<%@page import="model.Appointment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment</title>
</head>
<body>
<h3 align="center">APPOINTMENT DEATAIL</h3>
<hr>
<br>
<%
@SuppressWarnings("unchecked")
ArrayList<Appointment> list = (ArrayList<Appointment>)request.getAttribute("list");
%>
<form action="Service" method="get">
<table border="1" align="center">
<tr>
<th></th>
<th>Ticket No.</th>
<th>Patient Aadhar Id</th>
<th>illness</th>
</tr>
<tr>
<input type="hidden" name="reqflag" value="getApt">
<%
int count = 0; 
	if(list != null)
	{
		for(Appointment a : list)
		{	
%>
<td><input type="checkbox" name="check<%=count%>" value=<%= a.getAadhar() %>></td>
<td><%= a %></td>
<td><%= a.getAadhar()%></td>
<td><%= a.getIllness() %></td>
</tr>
<%
			count++;
		}
	}
%>
</table>
<br></br>
<div class="a" align="center">
<input type="hidden" name="count" value="<%=count%>">
<input type="submit" name="btn" value="Update">
<input type="submit" name="btn" value="Delete">
</div>
</form>
</body>
</html>