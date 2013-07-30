package application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectivity.LoginCheck;
import javax.servlet.RequestDispatcher;

import connectivity.Delobj;
import java.sql.SQLException;

public class Delete_Object extends HttpServlet {

  public delete_object() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String uid=request.getParameter("uid");
		String oid=request.getParameter("oid");
		//
		Delobj d = new Delobj();
		boolean e=false;
		try {
			e=d.delete_obj(uid,oid);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//if(e)
		//{
			//RequestDispatcher rd=request.getRequestDispatcher("verify");
			//rd.forward(request, response);
		//}
		/*else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ConfirmDel");
			rd.forward(request, response);
	
		}*/
		
		if(retval)
		{
			out.println("<html>");
			out.println("<body bgcolor=floralwhite>");
			out.println("Object"+oid+" deleted succescfully<br><br>");
			out.println("</body>");
			out.println("</html>");
		}
		else
		{
			out.println("<html>");
			out.println("<body bgcolor=floralwhite>");
			out.println("Object"+oid+" is not deleted<br><br>");
			out.println("</body>");
			out.println("</html>");
		}
	}		

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
