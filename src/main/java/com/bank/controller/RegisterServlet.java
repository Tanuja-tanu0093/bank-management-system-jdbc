package com.bank.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.bank.dto.Customer;
import com.bank.service.CustomerService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private CustomerService service = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pin = request.getParameter("pin");

        String accountNumber = "ACC" + (100000 + new Random().nextInt(900000));

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPin(pin);
        customer.setAccountNumber(accountNumber);
        customer.setBalance(0.0);

        boolean result = service.register(customer);

        if (result) {
            response.sendRedirect("jsp/login.jsp");
        } else {
            response.getWriter().println("Email already exists!");
        }
    }
}