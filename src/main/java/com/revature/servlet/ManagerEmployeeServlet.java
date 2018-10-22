package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.revature.model.Employee;
import com.revature.model.Reimbursements;
import com.revature.repository.EmployeeDao;
import com.revature.repository.PositionDao;
import com.revature.repository.ReimbursementDao;
import com.revature.service.EmployeeService;
import com.revature.service.ReimbursementService;

/**
 * Servlet implementation class ManagerEmployeeServlet
 */
@WebServlet("/ManagerEmployeeServlet")
public class ManagerEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao dao = new EmployeeDao();
	PositionDao pdao = new PositionDao();
	ReimbursementDao rdao = new ReimbursementDao();
	EmployeeService eService = new EmployeeService(dao);
	ReimbursementService rService = new ReimbursementService(rdao);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text");
		String path = req.getPathInfo();
		PrintWriter pw = resp.getWriter();

		List<Employee> employees = eService.getEmployees();
		ObjectMapper om = new XmlMapper();

		if (path == null || path.equals("/")) {
			String obj = om.writeValueAsString(employees);
			pw.println(obj + " ");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text");
		String path = req.getPathInfo();
		PrintWriter pw = resp.getWriter();
		int eID = Integer.parseInt(req.getParameter("eID"));

		List<Reimbursements> reimbursements = rService.getReimbursements(eID);
		ObjectMapper om = new XmlMapper();

		if (path == null || path.equals("/")) {
			String obj = om.writeValueAsString(reimbursements);
			pw.println(obj + " ");
			return;
		}
	}

}
