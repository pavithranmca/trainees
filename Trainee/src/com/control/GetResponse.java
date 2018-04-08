package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetResponse
 */
@WebServlet("/GetResponse")
public class GetResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetResponse() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		
		p.write("<h1 style='color:green'>test</h1>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		PrintWriter p = response.getWriter();
		//select * from trainee where uname = 'admin' and password ='admin'
		
		response.setContentType("text/html");
		if(uname.equals("admin") && pass.equals("admin")){
			
			response.sendRedirect("success.html");
			//p.write("<h1 style='color:green'>Authentication Success</h1>");
			
			
		}else{
			p.write("<h1 style='color:red'>Login Failed!!!!!</h1>");
			
		}
		
	}

}
