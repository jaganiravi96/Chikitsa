package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Appointment;
import model.Appointment_Status;
import service.dao.AppointmentDao;
import service.daoImpl.AppointmentDaoImpl;

@WebServlet("/appointment")
public class AppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reqflag = request.getParameter("reqflag");
		AppointmentDao r1 = new AppointmentDaoImpl();
		System.out.println(reqflag + "hiii");
		
		//=============================== create appointment =============================================
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
			
			String taskid= r1.generateId();
			Appointment a = new Appointment(taskid, aadhar, illness, symptoms, duration, medication, mHistory, gHistory, severity);
			
			String flag = r1.createAppointment(a);
			r1.assigne_Doctor(taskid);
			System.out.println(flag);
			
			if(taskid != null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				request.setAttribute("taskid", taskid);
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
		}
		
		//=============================== get all appointment detail =============================================
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
		
		//=============================== update/delete appointment detail =============================================
		if(reqflag.equalsIgnoreCase("getApt"))
		{	
			int count = Integer.parseInt(request.getParameter("count"));
			ArrayList<String> id_list = new ArrayList<>();
			String btn = request.getParameter("btn");
			//
			System.out.println(count+ btn + "hiiiiiiii");
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
		
		//=============================== get appointment status =============================================
		if(reqflag.equalsIgnoreCase("getStatus"))
		{			
			ArrayList<Appointment_Status> list = r1.getAppointmentStatus();	
			if(list != null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("status.jsp");
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
