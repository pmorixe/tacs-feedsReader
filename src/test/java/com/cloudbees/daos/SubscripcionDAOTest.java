package com.cloudbees.daos;

import java.util.List;

import org.junit.Test;

import com.cloudbees.models.Subscripcion;

public class SubscripcionDAOTest {

	@Test
	public void testRegistrarSubscripcion() {
		Subscripcion subscripcion = new Subscripcion(new Long(1),
				"www.tuvieja.com");
		SubscripcionDAO subscripcionDAO = new SubscripcionDAO();
		subscripcionDAO.registrarSubscripcion(subscripcion);

		List<Subscripcion> listarSubcripciones = subscripcionDAO
				.listarSubcripciones();

		for (Subscripcion subs : listarSubcripciones) {
			System.out.println("ID:" + subs.getSubcripcionId() + "\n" + "URL:"
					+ subs.getUrl());

		}

	}
}
