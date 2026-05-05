package zom;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class order
 */
@WebServlet("/order")
public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public order() {
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
		String user = (String) request.getSession().getAttribute("user");
		String[] foods = request.getParameterValues("food"); 
		Map<String, Integer> priceMap = new HashMap<>();
		priceMap.put("Pizza", 200);
		priceMap.put("Burger", 500);
		priceMap.put("Pasta", 1000);
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
		out.println("<html><body>");        
		out.println("<h2>Order Confirmation</h2>");        
		
		out.println("Customer: " + user + "<br>"); 
		int total=0;
		if (foods != null) { 
			
			out.println("Items Ordered:<br>");            
			for (String item : foods) {    int price = priceMap.get(item);
		    out.println(item + " - Rs." + price + "<br>"); 
		       total=total+price;
		    
				}  
				
			request.getSession().setAttribute("total", total);
				out.println("total :"+total);
				
				
			}
		else 
		{           
			out.println("No items selected."); 
			out.println("<br><a href='Order.html'><h1>Back<h1></a>");

			
			} 
		
		out.println("<br><a href='Confirm.html'><h1>Continue<h1></a>");
		out.println("<br><a href='Order.html'><h1>Back<h1></a>");
		out.println("</body></html>");    
		}
}
		
