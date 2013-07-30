package connectivity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delobj {
  
	public boolean delete_obj(String uid,String oid) throws ClassNotFoundException, SQLException
	{
		boolean val1=false;
		Statement stmt=Connect.connct();		
		String query="select uid,oid from owner";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
			if(rs.getString("uid").equalsIgnoreCase(uid) && rs.getString("oid").equalsIgnoreCase(oid))
			{
				val1= true;
			}
			else val1=false;
		}
		return val1;
	}
	
	public boolean del()
	{
		boolean val=false;
		return val;
	}
	public static void main(String[] args) throws Exception 
	{
				
		
	}
}
