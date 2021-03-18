package controller;
import java.io.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
    	req.getSession().invalidate();
    	res.sendRedirect("index.html");
    }
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		req.getSession().invalidate();
		res.sendRedirect("index.html");
	}
}
