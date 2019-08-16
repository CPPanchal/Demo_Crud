package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;
import com.royal.util.ValidationData;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		HttpSession session=request.getSession(); 
		StudentBean bean=null;
		StudentDao dao=null;
		
		String flag=request.getParameter("flag");
		 if(flag.equals("update"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			bean=new StudentBean();
			bean.setId(id);
			dao=new StudentDao();
			ArrayList<StudentBean>studentList1=dao.show(bean);
			session.setAttribute("list",studentList1);
			response.sendRedirect("Update.jsp");
			
		}
			else if (flag.equals("delete")) {
				
				int id=Integer.parseInt(request.getParameter("id"));
				bean=new StudentBean();
				bean.setId(id);
				dao=new StudentDao();
				dao.delete(bean);
				ArrayList<StudentBean> studentList2=dao.show();
				session.setAttribute("list",studentList2);
				response.sendRedirect("Display.jsp");
			}
		 
		 else if (flag.equals("edit")) {
			 
			 int id=Integer.parseInt(request.getParameter("id"));
			 String firstName=request.getParameter("fn");

				String lastName=request.getParameter("ln");

				String gender=request.getParameter("gender");

				String address=request.getParameter("add");

				String contactNo=request.getParameter("no");

				String userId=request.getParameter("uid");
				
				String password=request.getParameter("pass");
				
				bean=new StudentBean();
				bean.setId(id);
				bean.setFirstName(firstName);
				bean.setLastName(lastName);
				bean.setGender(gender);
				bean.setAddress(address);
				bean.setContactNo(contactNo);
				bean.setUserId(userId);
				bean.setPassword(password);
				
				dao=new StudentDao();
				dao.edit(bean);
				response.sendRedirect("Register.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flag=false;
		
	
	String firstName=request.getParameter("fn");

	String lastName=request.getParameter("ln");

	String gender=request.getParameter("gender");

	String address=request.getParameter("add");

	String contactNo=request.getParameter("no");

	String userId=request.getParameter("uid");
	
	String password=request.getParameter("pass");
	
	
	request.setAttribute("firstName", firstName);
	request.setAttribute("lastName",lastName);
	request.setAttribute("gender",gender);
	request.setAttribute("address",address);
	request.setAttribute("contactNo", contactNo);
	request.setAttribute("userId", userId);
	request.setAttribute("password", password);
	
	if(ValidationData.isFirstNameValidate(firstName))
	{
		
	}
	else
	{
		flag=true;
		request.setAttribute("fstErr","Please Enter a valid FirstName");
	}
	
	if(ValidationData.isLastNameValidate(lastName))
	{
		
	}
	else
	{
		flag=true;
		request.setAttribute("lstErr","Please Enter a valid LastName");
	}
	
	if(ValidationData.isaddValidate(address))
	{
		
	}
	else
	{
		flag=true;
		request.setAttribute("addErr","Please Enter a valid Address");
	}
	
	if(ValidationData.isUserIdValidate(userId))
	{
		
	}
	else
	{
		flag=true;
		request.setAttribute("IdErr","Please Enter a valid userId");
	}
	
	
	if(ValidationData.ispwdValidate(password))
	{
		
	}
	else
	{
		flag=true;
		request.setAttribute("pwdErr","Please Enter a Valid ContactNo");
	}
	
	
	if(ValidationData.isContactNoValidate(contactNo))
	{
		
	}
	else
	{
		flag=true;
		request.setAttribute("noErr","Please Enter a Valid ContactNo");
	}
	
	      RequestDispatcher requestDispatcher=null;
			if(flag)
			{
				requestDispatcher=request.getRequestDispatcher("Register.jsp");
				requestDispatcher.forward(request, response);
			}
				
	
	
			else {
	
	StudentBean bean=new StudentBean();
	bean.setFirstName(firstName);
	bean.setLastName(lastName);
	bean.setGender(gender);
	bean.setAddress(address);
	bean.setContactNo(contactNo);
	bean.setUserId(userId);
	bean.setPassword(password);
	
	StudentDao dao=new StudentDao();
	dao.insert(bean);
	
	response.sendRedirect("Register.jsp");
			}
	

	
	
	
	}

}
