package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectivity.Connect;


public class Object_content extends HttpServlet {

  /**
	 * Constructor of the object.
	 */
	public ObjectContent() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println(" Hi, in this page you can view and modify and manipulate the contents of the objects on which you have appropriate permissions<br><br>");
		out.println("Objects that are owned (by the user - uid)<br>");
		Connect con=new Connect();
		try {
			Statement stmt=con.connct();
			ResultSet rs=stmt.executeQuery("select oid from owner where uid='u028'");
			
			while(rs.next())
			{
				
				out.println(rs.getString(1)+"\t\t\t   <a id=\""+rs.getString(1)+"\"href=\"./read\">  r </a>   <a href=\"./write\">  w  </a>    <a href=\"./execute\">  x  </a><br>");
				
				System.out.println(rs.getString(1)+" \tr w x ");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	out.println();
		//out.println();
//		out.println();
		out.println(" </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println(" Hi, in this page you can view and modify and manipulate the contents of the objects on which you have appropriate permissions<br><br>");
		out.println("Objects that are owned (by the user - uid)");
		Connect con=new Connect();
		try {
			Statement stmt=con.connct();
			ResultSet rs=stmt.executeQuery("select uid from owner");
			
			while(rs.next())
			{
				out.println(rs.getString(1)+"r w x <br");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	out.println();
		//out.println();
//		out.println();
		out.println(" </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
