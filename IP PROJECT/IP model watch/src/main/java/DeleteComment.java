

import java.sql.*;
import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteComment")
public class DeleteComment extends HttpServlet {
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
			PreparedStatement ps = conn.prepareStatement("delete from comments where username=?");
			String username = request.getParameter("uname");
			ps.setString(1, username);
			int rs = ps.executeUpdate();
			if(rs>0) {
				out.println("Book Deleted Sucessfully !");
			}else {
				out.println("Unable to Delete Book...");
			}
		}catch(Exception e) {
			out.println(e);
		}
	}

}