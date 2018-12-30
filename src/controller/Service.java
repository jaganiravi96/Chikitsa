package controller;

import java.io.IOException;
import java.net.URI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Resource;
import model.User;

@WebServlet("/Service")
public class Service extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reqflag = request.getParameter("reqflag");
		Resource r1 = new Resource();
		System.out.println(reqflag);
		
		if(reqflag.equalsIgnoreCase("signup"))
		{
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String contact = request.getParameter("phone");
			String aadhar= request.getParameter("aadhar");
			String password = request.getParameter("password");
			System.out.println(firstName + lastName + aadhar );
			String usertype = request.getParameter("usertype");
			
			User u = new User(aadhar, password, firstName, contact, usertype);
			
			String name1 = r1.createUser(u);
			System.out.println(name1);
			if(name1 != null)
			{
				System.out.println("ravi");
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
						
			User u1 = r1.userlogin(u);
			
			if(u1.getName() != null)
			{
				System.out.println("hiiiiii");
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
	}
}
