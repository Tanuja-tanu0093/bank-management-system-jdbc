package com.bank.controller;

import com.bank.service.CustomerService;
import com.bank.dto.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private CustomerService service = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String pin = request.getParameter("pin");

        Customer customer = service.login(email, pin);

        if (customer != null) {

            HttpSession session = request.getSession(true);
            session.setAttribute("user", customer);

            response.sendRedirect("jsp/dashboard.jsp");

        } else {

            response.sendRedirect("jsp/login.jsp?error=invalid");

        }
    }
}