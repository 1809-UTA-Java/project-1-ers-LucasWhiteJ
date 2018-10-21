package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.revature.model.Employee;
import com.revature.repository.EmployeeDao;
import com.revature.service.EmployeeService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeDao dao = new EmployeeDao();
	EmployeeService aService = new EmployeeService(dao);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();

		List<Employee> employees = aService.getEmployees();
		ObjectMapper om = new XmlMapper();
		String userName = req.getParameter("username");
		String password = req.getParameter("password");

		for (Employee a : employees) {
			if (path == null || path.equals("/")) {
				if (a.geteUserName().equals(userName)) {
					if (a.getePassword().equals(password)) {
						this.getServletConfig().getServletContext().setAttribute("currentUser", a.getEid());
						resp.sendRedirect("EmployeeHomePage.html");
					} else
						resp.sendRedirect("index.html");
				}
			}
		}

		/*
		 * String[] pathSplits = path.split("/");
		 * 
		 * if (pathSplits.length != 2) {
		 * resp.sendError(HttpServletResponse.SC_BAD_REQUEST); return; }
		 */ }
}