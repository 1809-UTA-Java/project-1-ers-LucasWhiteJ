package com.revature.service;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Position;
import com.revature.repository.EmployeeDao;
import com.revature.repository.PositionDao;

public class EmployeeService {
	EmployeeDao dao;
	PositionDao pDao;
	
	public EmployeeService(EmployeeDao dao) {
		this.dao = dao;
	}

	public void updateEmployee(int eID, String userName, String password, String fName, String lName, String email, int positionID) {
		dao.updateEmployeeInformation(eID, userName, password, fName, lName, email, positionID);
	}
	
	public Employee viewEmployeeInfo(int eID) {
		return dao.getEmployeeInformation(eID);
	}
	
	public Position findPosition(String position) {
		return pDao.findPosition(position);
	}
	
	public List<Employee> getEmployees() {
		return dao.getEmployees();
	}

}
