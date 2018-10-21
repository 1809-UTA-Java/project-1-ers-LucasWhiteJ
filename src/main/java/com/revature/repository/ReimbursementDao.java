package com.revature.repository;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.model.Reimbursements;
import com.revature.util.ConnectionUtil;

public class ReimbursementDao {
	public List<Reimbursements> getReimbursements() {
		Session session = ConnectionUtil.getSession();
		return session.createQuery("from Reimbursements").list();
	}

	public Reimbursements getReimbursementsByAuthorID(int uID) {
		Reimbursements found = null;
		List<Reimbursements> reimbursements = new ArrayList<>();
		Session session = ConnectionUtil.getSession();

		reimbursements = session.createQuery("from Reimbursements where uidauthor = :authorid")
				.setInteger("authorid", uID).list();
		if (!reimbursements.isEmpty()) {
			found = reimbursements.get(0);
		}
		return found;
	}

	public void createReimbursement(int uID, double amt, String desc, int type) {
		Session session = ConnectionUtil.getSession();
		Query ps = null;
		Timestamp subTime = new Timestamp(System.currentTimeMillis());

		ps = session.createSQLQuery(
				"insert into reimbursements (rid, ramount, rdescription, rsubmitted, uidauthor, rtype, rstatus)"
						+ " values (ridincrement.nextval,:amt,:desc,:subTime,:uID,:type,:status)");
		ps.setDouble("amt", amt);
		ps.setString("desc", desc);
		ps.setTimestamp("subTime", subTime);
		ps.setInteger("uID", uID);
		ps.setInteger("type", type);
		ps.setInteger("status", 1);
		ps.executeUpdate();
		ps = session.createSQLQuery("commit");
		ps.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Reimbursements> getPendingReimbursementByAuthorID(int uID) {
		Reimbursements found = null;
		List<Reimbursements> reimbursements = new ArrayList<>();
		Session session = ConnectionUtil.getSession();
		Query ps = null;
		ResultSet rs = null;
		ps = session.createQuery("select r.rID, r.ramount, r.rDescription, r.rSubmitted, t.rType "
				+ "from Reimbursements as r, Type as t where r.rStatus = 1 and r.uIDAuthor = :uID and r.rType = t.rtID");
		ps.setInteger("uID", uID);
		reimbursements = ps.list();
		return reimbursements;
	}
}
