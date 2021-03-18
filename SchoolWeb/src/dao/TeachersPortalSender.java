package dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/TeachersPortalSender")
public class TeachersPortalSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TeachersPortalSender() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("i m do get");
		try{  	  
	        response.setContentType("text/html");  
	        HttpSession session=request.getSession(false); 
	        if(session!=null) {
	        	response.sendRedirect("TeachersPortal.html");
	        	RequestDispatcher rd = request.getRequestDispatcher("TeachersPortal.html");
	        	rd.forward(request, response);
	        }
	        else {
	        	response.sendRedirect("teacherLogin.html");
	        	RequestDispatcher rd = request.getRequestDispatcher("teacherLogin.html");
	        	rd.forward(request, response);
	        }
	        out.close();  
	  
	                }catch(Exception e){System.out.println(e);}  
	    }  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		out.println("i m do post");
	}

}
