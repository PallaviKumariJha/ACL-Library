package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Manage_P;
import database.Revoke;


public class Revoke extends HttpServlet {

  /**
	 * Constructor of the object.
	 */
	public Revoke() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String oid=request.getParameter("oid");
		String uid=request.getParameter("uid");
		String p=request.getParameter("p");
		
		Revoke mp= new Revoke();
		int i=0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			i=mp.rev(oid,uid,p);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<HTML>");
		out.println("  <BODY>");
		if(i>0)
		{
			out.println("permission"+p+"is revoked from"+uid+"");
			
		}
		out.println("  </BODY>");
		out.println("</HTML>");
	}

	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
