package com.cloudbees.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.cloudbees.connection.DbConnection;
import com.cloudbees.models.Subscripcion;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SubscripcionDAO {

	/**
	 * Permite registrar una subscripcion
	 * 
	 * @param subscripcion
	 */
	public void registrarPersona(Subscripcion subscripcion) {
		DbConnection conex = new DbConnection();
		try {
			Statement estatuto = (Statement) conex.getConnection()
					.createStatement();
			estatuto.executeUpdate("INSERT INTO subscripcion VALUES ('"
					+ subscripcion.getSubcripcionId() + "', '"
					+ subscripcion.getUrl() + "')");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro la persona");
		}
	}

	/**
	 * Permite consultar subcripcion a partir de id como parametro
	 * 
	 * @param subscripcionId
	 * @return
	 */
	public List<Subscripcion> consultarSubscripion(Long subscripcionId) {
		List<Subscripcion> subscripciones = new ArrayList<Subscripcion>();
		DbConnection conex = new DbConnection();

		try {
			PreparedStatement consulta = (PreparedStatement) conex
					.getConnection().prepareStatement(
							"SELECT * FROM subscripcion where id = ? ");
			consulta.setInt(1, subscripcionId.intValue());
			ResultSet res = consulta.executeQuery();

			if (res.next()) {
				Subscripcion subscripcion = new Subscripcion();
				subscripcion.setSubcripcionId(Long.parseLong(res
						.getString("id")));
				subscripcion.setUrl(res.getString("url"));

				subscripciones.add(subscripcion);
			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la Persona\n" + e);
		}
		return subscripciones;
	}

	public List<Subscripcion> listarSubcripciones() {
		List<Subscripcion> subscripciones = new ArrayList<Subscripcion>();
		DbConnection conex = new DbConnection();

		try {
			PreparedStatement consulta = (PreparedStatement) conex
					.getConnection().prepareStatement(
							"SELECT * FROM subscripcion");
			ResultSet res = consulta.executeQuery();

			while (res.next()) {
				Subscripcion subscripcion = new Subscripcion();
				subscripcion.setSubcripcionId(Long.parseLong(res
						.getString("id")));
				subscripcion.setUrl(res.getString("url"));

				subscripciones.add(subscripcion);
			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la Persona\n" + e);
		}
		return subscripciones;
	}

}
