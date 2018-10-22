package com.revature.service;

import java.util.List;

import com.revature.model.Reimbursements;
import com.revature.repository.ReimbursementDao;

public class ReimbursementService {
	ReimbursementDao dao;
	
	public ReimbursementService(ReimbursementDao dao) {
		this.dao = dao;
	}

	public List<Reimbursements> viewPendingReimbursement(int uID) {
		return dao.getPendingReimbursementByAuthorID(uID);
	}
	
	public List<Reimbursements> viewApprovedReimbursement(int uID) {
		return dao.getApprovedReimbursementByAuthorID(uID);
	}
	
	public List<Reimbursements> viewAllPendingReimbursement() {
		return dao.getAllPendingReimbursementByAuthorID();
	}
	
	public List<Reimbursements> viewAllApprovedReimbursement() {
		return dao.getAllApprovedReimbursementByAuthorID();
	}
	
	public void createReimbursement(int uID, double amt, String desc, int type) {
		dao.createReimbursement(uID, amt, desc, type);
	}
	
	public List<Reimbursements> getReimbursements(int uID) {
		return dao.getReimbursements();
	}
	
	public void updateStatus(int rID, int status, int uID) {
		dao.approveOrDenyReimbursement(rID, status, uID);
	}

}
