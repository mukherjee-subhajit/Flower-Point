package newpack;
import java.sql.*;

public class DataConnect {
	static Connection cn=null;
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/hetc";
	static String user="root";
	static String pass="arijit13@";
	
	public static Connection getCn() throws Exception {
		Class.forName(driver);
		cn=DriverManager.getConnection(url,user,pass);
		return cn;
	}

}
