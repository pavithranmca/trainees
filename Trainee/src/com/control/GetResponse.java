package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payilagam","root","");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from trainees where username='"+uname+"' and password ='"+pass+"'");  
			if(rs.next())  
			{
				String name = rs.getString("name");
				String email = rs.getString("email");
				
				/*
				 * Creating the sessoin for logined user
				 * set the value of name and email
				 */
				HttpSession hs = request.getSession();
				hs.setAttribute("loggedinName", name);
				hs.setAttribute("email", email);
				
				
				
				
				response.sendRedirect("welcome.jsp");
				
			}else{
				p.write("<h1 style='color:red'>Login Failed!!!!!</h1>");
			}
				
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			  
		
		
		/*
		response.setContentType("text/html");
		if(uname.equals("admin") && pass.equals("admin")){
			
			response.sendRedirect("welcome.jsp");
			//p.write("<h1 style='color:green'>Authentication Success</h1>");
			
			
		}else{
			p.write("<h1 style='color:red'>Login Failed!!!!!</h1>");
			
		}*/
		
	}

}
