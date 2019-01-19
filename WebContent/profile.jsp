<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Profile</title>
</head>
<body>
<h3>USERS DEATAIL</h3>
<br>
<%
@SuppressWarnings("unchecked")
ArrayList<User> list = (ArrayList<User>)request.getAttribute("list");

if(list != null)
{
	int count = 0; 
	for(User a : list)
	{
%>
User Id: <%= a.getUsertype() %><br>
User Type  <%=a.getAadhar() %><br>
Name : <%=a.getName()%><br>
Contact: <%=a.getContact() %><br>
Employee Id: <%=a.getEmpid() %><br>
Experience: <%=a.getExperience() %><br>
Status: <%=a.getStatus() %>
<br>
<input type="button" name="update" value="Update">
<input type="button" name="update" value="Delete">

<hr>
<%
		}
	}
%>
</body>
</html>