package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        try (PrintWriter out = response.getWriter()) {
            if ("admin".equals(user) && "1234".equals(pass)) {
                out.println("<h2>Welcome, " + escape(user) + "!</h2>");
            } else {
                out.println("<h2>Invalid credentials</h2><a href='login.html'>Try again</a>");
            }
        }
    }
    private String escape(String s) { return s==null? "": s.replace("&","&amp;").replace("<","&lt;"); }
}

