package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductServlet extends HttpServlet  {
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
	PrintWriter pw = res.getWriter();
	res.setContentType("text/html");
	Cookie c[]= req.getCookies();
	if(c==null) {
		pw.println("Session Expired...<br>");
		RequestDispatcher rd = req.getRequestDispatcher("login.html");
		rd.include(req, res);
	}else {
		String fName = c[0].getValue();
		pw.println("page of "+fName+"<br>");
		RequestDispatcher rd = req.getRequestDispatcher("input.html");
		rd.include(req, res);
		ArrayList<ProductBean> al = new RetrieveDAO().retrieve();
		if(al.size()==0) {
			pw.println("<br>Product Not Available ...<br>");
		}else {
			Iterator<ProductBean> it = al.iterator();
			pw.println("<br/>=====Show Product====");
			while(it.hasNext()) {
				ProductBean pb = (ProductBean) it.next();
				pw.println("<div style='display:grid; grid-template-columns:100px 100px 100px 100px;'><label>"+pb.getCode()+
						"</label><label>"+pb.getName()+"</label><label>"+pb.getPrice()+"</label><label>"+pb.getQty()+"</label></div>");				
				
			}
		}
	}
	
	}
}
