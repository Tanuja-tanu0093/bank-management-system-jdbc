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

@WebServlet("/updatePin")
public class UpdatePinServlet extends HttpServlet {

    private CustomerService service = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String newPin = request.getParameter("newPin");

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("user");

        service.updatePin(customer.getId(), newPin);

        response.sendRedirect("dashboard.jsp");
    }
}
