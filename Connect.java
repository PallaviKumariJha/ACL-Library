package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
public static Statement connct() throws ClassNotFoundException, SQLException
{
  Class.forName("org.postgresql.Driver");
	String cs="jdbc:postgresql://localhost:5432/postgres";
	Connection con=DriverManager.getConnection(cs,"postgres","viddu");
	Statement stmt=con.createStatement();
	return stmt;
}
