

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateComment")
public class UpdateComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String URL="jdbc:mysql://localhost:3307/watch";
			Connection conn = DriverManager.getConnection(URL,"root","");
			PreparedStatement ps = conn.prepareStatement("update comments set comment = ?, watch_id = ? where username=?");
			String uname = request.getParameter("uname");
			String comment = request.getParameter("comm");
			String wid = request.getParameter("wid");
			
			
			ps.setString(1, comment);
			ps.setString(2, wid);
			ps.setString(3, uname);
			
			int rs = ps.executeUpdate();
			if (rs > 0) {
                out.println("Book updated successfully!");
            } else {
                out.println("Failed to updated book.");
            }
		}catch(Exception e) {
			out.println(e);
		
	}
	}


}