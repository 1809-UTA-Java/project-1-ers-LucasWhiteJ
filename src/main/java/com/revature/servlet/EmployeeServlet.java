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
import com.revature.model.Position;
import com.revature.repository.EmployeeDao;
import com.revature.repository.PositionDao;
import com.revature.service.EmployeeService;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao dao = new EmployeeDao();
	PositionDao pdao = new PositionDao();
	EmployeeService eService = new EmployeeService(dao);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text");
		String path = req.getPathInfo();
		PrintWriter pw = resp.getWriter();

		Employee emp = eService.viewEmployeeInfo(
				Integer.parseInt((this.getServletConfig().getServletContext().getAttribute("currentUser")).toString()));
		
		ObjectMapper om = new XmlMapper();

		if (path == null || path.equals("/")) {
			String obj = om.writeValueAsString(emp);
			pw.println(emp.getEid() + " " + emp.geteUserName() + " " + emp.getePassword() + " " + emp.geteFirstName() + " " + emp.geteLastName() + " " + emp.getEmail());
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String fName = req.getParameter("fName");
		String lName = req.getParameter("lName");
		String email = req.getParameter("email");
		String position = req.getParameter("position");
		Position foundPosition = pdao.findPosition(position);
		int positionID = foundPosition.getPositionID();

		eService.updateEmployee(
				Integer.parseInt((this.getServletConfig().getServletContext().getAttribute("currentUser")).toString()),
				userName, password, fName, lName, email, positionID);
	}

}
