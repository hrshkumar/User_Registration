package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	PrintWriter pw = res.getWriter();
	res.setContentType("text/html");
	ProductBean pb = new ProductBean();
	pb.setCode(req.getParameter("code"));
	pb.setName(req.getParameter("name"));
	pb.setPrice(Float.parseFloat(req.getParameter("price")));
	pb.setQty(Integer.parseInt(req.getParameter("qty")));
	int k = new AddtProductDAO().insert(pb);
	if(k>0) {
		pw.println("Production Added Successfully..<br>");
		RequestDispatcher rd =

				req.getRequestDispatcher("input.html");

				rd.include(req, res);	
	}
	}

}
