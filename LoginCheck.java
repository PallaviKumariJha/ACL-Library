package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginCheck {
  public boolean check(String uid,String pasword) throws ClassNotFoundException, SQLException
	{
		boolean retval=false;
		Statement stmt=Connect.connct();		
		String query="select uid,passwd from users";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
			if(rs.getString("uid").equalsIgnoreCase(uid) && rs.getString("passwd").equalsIgnoreCase(pasword))
			{
				retval= true;
				break;
			}
			else retval=false;
		}
		return retval;
	}
	public static void main(String[] args) throws Exception {
		Class.forName("org.postgresql.Driver");
		String cs="jdbc:postgresql://localhost:5432/postgres";
		Connection con=DriverManager.getConnection(cs,"postgres","viddu");
		Statement stmt=con.createStatement();
		String query="select * from users";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
			{
				System.out.println(rs.getString(1));
				
			}
		
		
	}

}
