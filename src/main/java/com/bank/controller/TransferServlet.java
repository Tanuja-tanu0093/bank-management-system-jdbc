package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.bank.dto.Customer;
import com.bank.service.CustomerService;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CustomerService service = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String receiverAccount = request.getParameter("receiverAccount");
        double amount = Double.parseDouble(request.getParameter("amount"));

        HttpSession session = request.getSession();
        Customer sender = (Customer) session.getAttribute("user");

        // check if user is logged in
        if (sender == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // check balance
        if (sender.getBalance() < amount) {
            response.sendRedirect("transfer.jsp?error=insufficient");
            return;
        }

        boolean result = service.transfer(sender.getId(), receiverAccount, amount);

        if (result) {
            response.sendRedirect("dashboard.jsp?success=transfer");
        } else {
            response.sendRedirect("transfer.jsp?error=failed");
        }
    }
}