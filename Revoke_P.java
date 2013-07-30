package connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Revoke_P {
  public int rev(String oid,String uid, String p) throws ClassNotFoundException, SQLException
	{
		int r=0;
		boolean retval=false;
		Statement stmt=Connect.connct();		
		String query="select * from owner where uid='u028'";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
			if(rs.getString("oid").equalsIgnoreCase(oid))
			{
				retval= true;
			}
			else retval=false;
		}
		if(retval)
		{
		String q="update permission set"+p+"=false where uid="+uid+";";
		 r=stmt.executeUpdate(q);
		
		}
		return r;
	}
}
