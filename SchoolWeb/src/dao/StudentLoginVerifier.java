package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class StudentLoginVerifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StudentLoginVerifier() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		doGet(request, response);
		
		String uname=request.getParameter("userName");
		String paswd = request.getParameter("userPassword");
		
		
		   // Initialize all the information regarding 
	        // Database Connection 
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:MySQL://localhost/student","root","Ankit@1234");	
				
			    	String query =  "SELECT * FROM  `student_userid`  WHERE `id`= ? AND `password`=?";	  
		            PreparedStatement ps = con.prepareStatement(query);
	        	
		            ps.setString(1, uname);
		            ps.setString(2, paswd);
		    
		           ResultSet rs = ps.executeQuery();
		           if(rs.next()){
		        	   if(request.getParameter("chkbox")!=null) {
		        		   Cookie ck = new Cookie("username",uname);
		        		   response.addCookie(ck);
		        	   }
         		    RequestDispatcher rd = request.getRequestDispatcher("StudentPortal.jsp");
        		    rd.include(request, response);   
		           }	   
		          else{
		    	    out.println("<font color='red'><b>Invalid Email or Password</b></font>");
		    	    RequestDispatcher rd = request.getRequestDispatcher("StudentLogin.html");
		    	    rd.include(request, response);
		          }
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch(SQLException e){
		   e.printStackTrace();
	   }
	}
}
