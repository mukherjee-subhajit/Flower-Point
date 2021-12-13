package newpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			PrintWriter out=response.getWriter();
			
			int uid=(int)(Math.random()*100000);
			String uname=request.getParameter("uname");
			String uph=request.getParameter("uph");
			String uemail=request.getParameter("uemail");
			String upass=request.getParameter("upass");
			
			Connection cn=DataConnect.getCn();
			
			String sql="insert into user_table values(?,?,?,?,?)";
			PreparedStatement ps=cn.prepareStatement(sql);
			
			ps.setInt(1, uid);
			ps.setString(2, uname);
			ps.setString(3, uph);
			ps.setString(4, uemail);
			ps.setString(5, upass);
			
			ps.execute();
			
			//out.print("");
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.include(request, response);
			
						
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
