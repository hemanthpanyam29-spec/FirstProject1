package zom;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pay
 */
@WebServlet("/pay")
public class pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pay() {
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
		PrintWriter out=response.getWriter();
		 response.setContentType("text/html");
		
		String pay = request.getParameter("pay");

		if ("Upi using GooglePay".equals(pay)) {
		    out.println("UPI using GooglePay selected");
		    out.println("<br><a href='Otpp.html'><h1>Continue<h1></a>");
		    }
		else if ("Upi using PhonePay".equals(pay)) {
		    out.println("UPI using PhonePay selected");
		    out.println("<br><a href='Otpp.html'><h1>Continue<h1></a>");
		} 
		else if ("Upi using Paytm".equals(pay)) {
		    out.println("UPI selected");
		    
		    out.println("<br><a href='Otpp.html'><h1>Continue<h1></a>");
		} 
	   else if ("Cash".equals(pay)) {
		    response.getWriter().println("Cash selected");
		    out.println("<br><a href='Final.html'><h1>Continue<h1></a>");
		} 
		else if ("Card".equals(pay)) {
		    response.getWriter().println("Cash selected");
		    response.sendRedirect("Final.html");
		} 
		else {
		    response.getWriter().println("No payment selected");
		    out.println(" Please confirm payment process");
			out.println("<br><a href='Payment.html'><h1>Continue<h1></a>");
		    
		}
		
		
	}
}
