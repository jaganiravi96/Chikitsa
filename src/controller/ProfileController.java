package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import service.dao.UserDao;
import service.daoImpl.UserDaoImpl;
import util.JsonUtil;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reqflag = request.getParameter("reqflag");
		UserDao r1 = new UserDaoImpl();
		System.out.println(reqflag + "hiii");
		
		//=============================== sign up =============================================
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
		
		//=============================== login =============================================
		if(reqflag.equalsIgnoreCase("loginform"))
		{
			String aadhar = request.getParameter("id");
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
		
		//=============================== find user profile detail =============================================
		if(reqflag.equals("getprofile"))
		{
			//String name = request.getParameter("name");
			//String aadhar = request.getParameter("name");
			
		}
		
		//=============================== find all user profile detail =============================================
		if(reqflag.equalsIgnoreCase("getProDetail"))
		{	
			ArrayList<User> list = r1.getAllUser();	
			String jsonlist = JsonUtil.convertToJson(list);
			if(list != null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				request.setAttribute("jsonlist", jsonlist);
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
