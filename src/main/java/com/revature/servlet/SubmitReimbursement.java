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
import com.revature.model.Type;
import com.revature.repository.ReimbursementDao;
import com.revature.repository.TypeDao;
import com.revature.service.ReimbursementService;
import com.revature.service.TypeService;

/**
 * Servlet implementation class SubmitReimbursement
 */
@WebServlet("/SubmitReimbursement")
public class SubmitReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ReimbursementDao dao = new ReimbursementDao();
	ReimbursementService rService = new ReimbursementService(dao);
	TypeDao tdao = new TypeDao();
	TypeService tService = new TypeService(tdao);

	/*     
	*//**
		 * @see HttpServlet#HttpServlet()
		 */

	/*
	 * public SubmitReimbursement() { super(); // TODO Auto-generated constructor
	 * stub }
	 * 
	 *//**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text");
		String path = req.getPathInfo();
		PrintWriter pw = resp.getWriter();

		List<Reimbursements> reimbursements = rService.viewPendingReimbursement(
				Integer.parseInt((this.getServletConfig().getServletContext().getAttribute("currentUser")).toString()));
		ObjectMapper om = new XmlMapper();

		if (path == null || path.equals("/")) {
			String obj = om.writeValueAsString(reimbursements);
			pw.println(obj);
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double amt = Double.parseDouble(req.getParameter("amount"));
		String desc = req.getParameter("description");
		String reimbursementType = req.getParameter("type");
		Type type = tService.getTypeByTypeName(reimbursementType);
		int typeID = type.getRtID();

		rService.createReimbursement(
				Integer.parseInt((this.getServletConfig().getServletContext().getAttribute("currentUser")).toString()),
				amt, desc, typeID);
	}
}
