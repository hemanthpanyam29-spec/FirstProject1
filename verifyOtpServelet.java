package zom;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verifyOtpServelet")
public class verifyOtpServelet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public verifyOtpServelet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        String uotp = request.getParameter("userInput");
        HttpSession session = request.getSession(false);

        if (session == null) {
            response.getWriter().println("Error: No active session");
            return;
        }

        Integer gotp = (Integer) session.getAttribute("otp2");

        if (gotp == null) {
            response.getWriter().println("OTP expired or not generated");
            return;
        }

        if (uotp != null && uotp.equals(String.valueOf(gotp))) {
            response.getWriter().println("Success: OTP verified");
            session.removeAttribute("otp2");
            out.println("<br><a href='Final.html'><h1>Continue<h1></a>");
        } else {
            response.getWriter().println("Invalid OTP. Please try again");
        }
    }
}