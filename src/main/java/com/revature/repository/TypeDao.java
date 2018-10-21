package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.model.Type;
import com.revature.util.ConnectionUtil;

public class TypeDao {
	public List<Type> getType() {
		// Hibernate version
		Session session = ConnectionUtil.getSession();
		return session.createQuery("from Type").list();
	}

	public Type getTypeByTypeName(String type) {
		Type found = null;
		List<Type> employees = new ArrayList<>();
		Session session = ConnectionUtil.getSession();

		employees = session.createQuery("from Type where rtype = :typename").setString("typename", type)
				.list();
		if (!employees.isEmpty()) {
			found = employees.get(0);
		}
		return found;
	}
}
