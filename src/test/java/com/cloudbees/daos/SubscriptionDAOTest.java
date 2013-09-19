package com.cloudbees.daos;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.cloudbees.models.Subscription;

public class SubscriptionDAOTest {

	public void testRegistrarSubscripcion() throws SQLException {
		Subscription subscripcion = new Subscription(new Long(1),
				"www.algo.com");
		SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
		subscriptionDAO.save(subscripcion);

		List<Subscription> listarSubcripciones = subscriptionDAO
				.listarSubcripciones();
		//assert(listarSubcripciones.size() > 0);
	}
}
