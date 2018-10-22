package com.revature.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.util.ConnectionUtil;
import com.revature.model.Employee;
import com.revature.model.Reimbursements;

public class EmployeeDao {

	public List<Employee> getEmployees() {
		Session session = ConnectionUtil.getSession();
		return session.createQuery("from Employee").list();
	}

	public Employee getEmployeeByUserName(String uName) {
		Employee found = null;
		List<Employee> employees = new ArrayList<>();
		Session session = ConnectionUtil.getSession();

		employees = session.createQuery("from Employee where eusername = :username").setString("username", uName)
				.list();
		if (!employees.isEmpty()) {
			found = employees.get(0);
		}
		return found;
	}

	@SuppressWarnings("unchecked")
	public Employee getEmployeeInformation(int eID) {
		Employee found = null;
		List<Employee> employees = new ArrayList<>();
		Session session = ConnectionUtil.getSession();

		employees = session.createQuery("from Employee where eid = :eID").setInteger("eID", eID)
				.list();
		if (!employees.isEmpty()) {
			found = employees.get(0);
		}
		return found;
	}

	public void updateEmployeeInformation(int eID, String userName, String password, String fName, String lName, String email, int positionID) {
		Session session = ConnectionUtil.getSession();
		Query ps = null;

		ps = session.createSQLQuery(
				"update Employee  set eusername = :userName, epassword = :pw, efirstname = :fName, elastname = :lName, email = :email, positionid = :positionID where eid = :eID");
		ps.setInteger("eID", eID);
		ps.setString("userName", userName);
		ps.setString("pw", password);
		ps.setString("fName", fName);
		ps.setString("lName", lName);
		ps.setString("email", email);
		ps.setInteger("positionID", positionID);
		ps.executeUpdate();
		ps = session.createSQLQuery("commit");
		ps.executeUpdate();
	}
}
