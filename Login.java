package newpack;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.DataSourceConnectionFactory;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			PrintWriter out=response.getWriter();
			
			String uph=request.getParameter("uph");
			String upass=request.getParameter("upass");
			
			Connection cn=DataConnect.getCn();
			
			String sql="select uid from user_table where uph=? and upass=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			
			ps.setString(1, uph);
			ps.setString(2, upass);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				RequestDispatcher rd=request.getRequestDispatcher("loggedin.html");
				rd.include(request, response);
				
				
			}else {
				out.print("<h3>Please enter correct details</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
			
			
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
