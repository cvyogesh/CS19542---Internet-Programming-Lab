

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertComment")
public class InsertComment extends HttpServlet {
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
			PreparedStatement ps = conn.prepareStatement("insert into comments values(?,?,?)");
			String username = request.getParameter("uname");
			String comment = request.getParameter("comm");
			String watch_id = request.getParameter("wid");
			
			ps.setString(1, username);
			ps.setString(2, comment);
			ps.setString(3, watch_id);
			
			int rs = ps.executeUpdate();
			if (rs > 0) {
                out.println("Comment inserted successfully!");
            } else {
                out.println("Failed to insert Comment.");
            }
		}catch(Exception e) {
			out.println(e);
		
	}
	}

}