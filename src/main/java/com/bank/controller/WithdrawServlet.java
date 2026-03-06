package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dto.Customer;
import com.bank.service.CustomerService;

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {

    private CustomerService service = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double amount = Double.parseDouble(request.getParameter("amount"));

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("user");

        boolean result = service.withdraw(customer.getId(), amount);

        response.sendRedirect("dashboard.jsp");
    }
}