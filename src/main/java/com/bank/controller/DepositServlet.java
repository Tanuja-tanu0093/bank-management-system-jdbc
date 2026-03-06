package com.bank.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DepositServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        double amount =
                Double.parseDouble(request.getParameter("amount"));

        HttpSession session = request.getSession();

        if (amount <= 0) {

            response.sendRedirect("jsp/deposit.jsp?error=invalid");

            return;
        }

        response.sendRedirect("jsp/dashboard.jsp?success=deposit");

    }
}