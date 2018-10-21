package com.revature.service;

import java.util.List;

import com.revature.model.Type;
import com.revature.repository.ReimbursementDao;
import com.revature.repository.TypeDao;

public class TypeService {
	TypeDao dao;

	public TypeService(TypeDao dao) {
		this.dao = dao;
	}
	
	public List<Type> getType() {
		return dao.getType();
	}
	
	public Type getTypeByTypeName(String type) {
		return dao.getTypeByTypeName(type);
	}
}
