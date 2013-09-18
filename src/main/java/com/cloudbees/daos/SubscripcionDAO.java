package com.cloudbees.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cloudbees.connection.DbConnection;
import com.cloudbees.models.Subscripcion;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SubscripcionDAO {

	/**
	 * Permite registrar una subscripcion
	 * 
	 * @param subscripcion
	 * @throws SQLException 
	 */
	public void registrarSubscripcion(Subscripcion subscripcion) throws SQLException {
		DbConnection conex = new DbConnection();
		Statement estatuto = (Statement) conex.getConnection()
				.createStatement();
		if (subscripcion.getSubcripcionId() != null){
			estatuto.executeUpdate("UPDATE subscripcion SET URL='"+
					subscripcion.getUrl() + "' WHERE id="+
					subscripcion.getSubcripcionId().toString());
		} else{
			estatuto.executeUpdate("INSERT INTO subscripcion VALUES ('"
				+ subscripcion.getUrl() + "')");
		}
		estatuto.close();
		conex.desconectar(); 
	}

	/**
	 * Permite consultar subcripcion a partir de id como parametro
	 * 
	 * @param subscripcionId
	 * @return
	 * @throws SQLException 
	 */
	public List<Subscripcion> consultarSubscripion(Long subscripcionId) throws SQLException {
		List<Subscripcion> subscripciones = new ArrayList<Subscripcion>();
		DbConnection conex = new DbConnection();

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
		return subscripciones;
	}

	public List<Subscripcion> listarSubcripciones() throws SQLException {
		List<Subscripcion> subscripciones = new ArrayList<Subscripcion>();
		DbConnection conex = new DbConnection();

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
		return subscripciones;
	}

}
