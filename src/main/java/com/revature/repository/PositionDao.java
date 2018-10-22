package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.model.Position;
import com.revature.util.ConnectionUtil;

public class PositionDao {
	@SuppressWarnings("unchecked")
	public Position findPosition(String position) {
		Position found = null;
		List<Position> positions = new ArrayList<>();
		Session session = ConnectionUtil.getSession();

		positions = session.createQuery("from Position where position = :position").setString("position", position)
				.list();
		if (!positions.isEmpty()) {
			found = positions.get(0);
		}
		return found;
	}
}
