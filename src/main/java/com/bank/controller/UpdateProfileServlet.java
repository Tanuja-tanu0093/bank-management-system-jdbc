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

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {

	private CustomerService service = new CustomerService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");

		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("user");

		service.updateProfile(customer.getId(), name, email);

		response.sendRedirect("dashboard.jsp");
	}
}
