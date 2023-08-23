package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//UserBean ub = new UserBean();
		//LoginDAO lg = new LoginDAO().login(req);
		

		UserBean ub = new LoginDAO().login(req);
		PrintWriter pw =res.getWriter();
		res.setContentType("text/html");
		if(ub==null) {
			
		  pw.println("Invalid Login Process...<br>");
		  RequestDispatcher rd = req.getRequestDispatcher("login.html");
		  rd.include(req, res);
		} else {
			Cookie ck = new Cookie("fName",ub.getfName());
			res.addCookie(ck);
			pw.println("Welcome User "+ub.getfName()+"<br>");
			RequestDispatcher rd = req.getRequestDispatcher("input.html");
			  rd.include(req, res);
		}
		
		
	}

}
