package com.cloudbees.daos;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.cloudbees.models.Subscripcion;

public class SubscripcionDAOTest {

	public void testRegistrarSubscripcion() throws SQLException {
		Subscripcion subscripcion = new Subscripcion(new Long(1),
				"www.algo.com");
		SubscripcionDAO subscripcionDAO = new SubscripcionDAO();
		subscripcionDAO.registrarSubscripcion(subscripcion);

		List<Subscripcion> listarSubcripciones = subscripcionDAO
				.listarSubcripciones();
		//assert(listarSubcripciones.size() > 0);
	}
}
