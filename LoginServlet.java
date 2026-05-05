package zom;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, Ht
	 * tpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String pass = request.getParameter("password");

		if ("hemanth".equals(user) && "Hemanth@666".equals(pass)) {
		    response.getWriter().println("Login Successful");
		    request.getSession().setAttribute("user", user);

	        // redirect to next page
	        response.sendRedirect("Order.html");
		    
		} else {
		    response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("<h3>Invalid Username or Password</h3>");
	        out.println("<a href='Food.html'>Try Again</a>");
		}
	}
}


////