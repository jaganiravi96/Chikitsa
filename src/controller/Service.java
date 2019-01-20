package controller;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.beans.editors.BooleanEditor;

import Dao.Resource;
import model.Appointment;
import model.User;

@WebServlet("/Service")
public class Service extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reqflag = request.getParameter("reqflag");
		Resource r1 = new Resource();
		System.out.println(reqflag + "hiii");
		
		if(reqflag.equalsIgnoreCase("signup"))
		{
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String contact = request.getParameter("phone");
			String aadhar= request.getParameter("aadhar");
			String password = request.getParameter("password");
			String usertype = request.getParameter("usertype");
			
			User u = new User();
			u.setAadhar(aadhar);
			u.setContact(contact);
			u.setPassword(password);
			u.setName(firstName+" "+lastName);
			u.setUsertype(usertype);
						
			String name1 = r1.createUser(u);
			if(name1 != null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				request.setAttribute("name", name1);
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
		}
		
		if(reqflag.equalsIgnoreCase("loginform"))
		{
			String aadhar= request.getParameter("id");
			String password = request.getParameter("password");
			String contact = request.getParameter("id");
			
			User u = new User();
			
			u.setAadhar(aadhar);
			u.setPassword(password);
			u.setContact(contact);
						
			User u1 = r1.userLogin(u);
			
			if(u1.getName() != null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				request.setAttribute("name", u1.getName());
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		
		if(reqflag.equalsIgnoreCase("getProDetail"))
		{	
			ArrayList<User> list = r1.getAllUser();	
			if(list != null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				request.setAttribute("list", list);
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}	
		}
		
		if(reqflag.equalsIgnoreCase("appointment"))
		{
			String aadhar = request.getParameter("aadhar");
			String illness = request.getParameter("illness");     
			String symptoms = request.getParameter("symptoms");
			String duration= request.getParameter("duration");
			String medication = request.getParameter("medication");
			String mHistory = request.getParameter("mhistory");
			String gHistory= request.getParameter("ghistory");
			String severity= request.getParameter("severity");
			
			Appointment a = new Appointment(aadhar, illness, symptoms, duration, medication, mHistory, gHistory, severity);
			
			String name1 = r1.createAppointment(a);
			if(name1 != null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				request.setAttribute("name", name1);
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
		}
		
		if(reqflag.equalsIgnoreCase("getAptDetail"))
		{			
			ArrayList<Appointment> list = r1.getAllAppointment();	
			if(list != null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("manageApointment.jsp");
				request.setAttribute("list", list);
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}	
		}
		
		if(reqflag.equalsIgnoreCase("getApt"))
		{	
			int count = Integer.parseInt(request.getParameter("count"));
			ArrayList<String> id_list = new ArrayList<>();
			String btn = request.getParameter("btn");
			System.out.println(count+ btn);
			for(int i=0; i<count; i++)
			{
				String l1 = request.getParameter("check"+i);
				System.out.println(l1);
				if(l1 != null)
				id_list.add(l1);
			}
			
			Boolean a = r1.manageAppointment(id_list,btn);
			System.out.println(a);
			ArrayList<Appointment> list = r1.getAllAppointment();
			if(list != null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("manageApointment.jsp");
				request.setAttribute("list", list);
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		
		
		
	}
}
