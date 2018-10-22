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
import com.revature.model.Reimbursements;
import com.revature.repository.ReimbursementDao;
import com.revature.repository.TypeDao;
import com.revature.service.ReimbursementService;
import com.revature.service.TypeService;

/**
 * Servlet implementation class ManagerReimbursementServlet
 */
@WebServlet("/ManagerReimbursementServlet")
public class ManagerReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReimbursementDao dao = new ReimbursementDao();
	ReimbursementService rService = new ReimbursementService(dao);
	TypeDao tdao = new TypeDao();
	TypeService tService = new TypeService(tdao);

	public ManagerReimbursementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text");
		String path = req.getPathInfo();
		PrintWriter pw = resp.getWriter();
		String input = req.getParameter("input");

		if (input.equals("pending")) {
			List<Reimbursements> reimbursements = rService.viewAllPendingReimbursement();
			ObjectMapper om = new XmlMapper();

			if (path == null || path.equals("/")) {
				String obj = om.writeValueAsString(reimbursements);
				pw.println(obj + " ");
				return;
			}
		} else {
			List<Reimbursements> reimbursements = rService.viewAllApprovedReimbursement();
			ObjectMapper om = new XmlMapper();

			if (path == null || path.equals("/")) {
				String obj = om.writeValueAsString(reimbursements);
				pw.println(obj + " ");
				return;
			}
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int rID = Integer.parseInt(req.getParameter("rID"));
		String statusName = req.getParameter("status");
		int uID = Integer.parseInt((this.getServletConfig().getServletContext().getAttribute("currentUser")).toString());
		int status;
		
		if(statusName.equals("approved"))
			status = 2;
		else
			status = 3;
		
		rService.updateStatus(rID, status, uID);
	}

}
