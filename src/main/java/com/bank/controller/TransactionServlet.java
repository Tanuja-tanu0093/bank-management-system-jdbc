package com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dto.Customer;
import com.bank.service.CustomerService;

@WebServlet("/transactions")
public class TransactionServlet extends HttpServlet {

	private CustomerService service = new CustomerService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("user");

		request.setAttribute("transactions", service.getTransactions(customer.getId()));

		RequestDispatcher rd = request.getRequestDispatcher("transactions.jsp");
		rd.forward(request, response);
	}
}
