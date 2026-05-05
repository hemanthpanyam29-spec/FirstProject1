package zom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Final
 */
@WebServlet("/Final")
public class Final extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Final() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");

		    Connection con = DriverManager.getConnection(
		        "jdbc:mysql://localhost:3306/spring", "root", "hemanth@124");

		    String user = (String) request.getSession().getAttribute("user");
		    Integer total = (Integer) request.getSession().getAttribute("total");

		    if (user == null || total == null) {
		        out.println("Session data missing");
		        return;
		    }

		    String sql = "INSERT INTO orders(username, paidamt) VALUES (?, ?)";
		    PreparedStatement ps = con.prepareStatement(sql);

		    ps.setString(1, user);
		    ps.setInt(2, total);

		    ps.executeUpdate();
            out.println(" Payment Success- Order will be delivered soon"+"-");
            out.println(user+" "+"paid "+total);
		    out.println("<h2>Grand Success - THANK YOU AND VISIT AGAIN</h2>");

		    con.close();

		} catch (Exception e) {
		    e.printStackTrace(out);
		     
		}
		}
	}
