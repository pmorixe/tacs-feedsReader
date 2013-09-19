package com.cloudbees.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cloudbees.connection.DbConnection;
import com.cloudbees.models.Subscription;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SubscriptionDAO {

	/**
	 * @param subscription
	 * @throws Exception 
	 */
	public void save(Subscription subscription) throws Exception {
		DbConnection conex = new DbConnection();
		Statement statement = (Statement) conex.getConnection()
				.createStatement();
		if (subscription.getId() != null){
			statement.executeUpdate("UPDATE subscription SET URL='"+
					subscription.getUrl() + "' WHERE id="+
					subscription.getId().toString());
		} else{
			statement.executeUpdate("INSERT INTO subscription (url) VALUES ('"
				+ subscription.getUrl() + "')");
		}
		statement.close();
		conex.desconectar(); 
	}

	/**
	 * Permite consultar subcripcion a partir de id como parametro
	 * 
	 * @param subscripcionId
	 * @return
	 * @throws Exception 
	 */
	public List<Subscription> consultarSubscripion(Long subscripcionId) throws Exception {
		List<Subscription> subscripciones = new ArrayList<Subscription>();
		DbConnection conex = new DbConnection();

		PreparedStatement consulta = (PreparedStatement) conex
				.getConnection().prepareStatement(
						"SELECT * FROM subscription where id = ? ");
		consulta.setInt(1, subscripcionId.intValue());
		ResultSet res = consulta.executeQuery();

		if (res.next()) {
			Subscription subscripcion = new Subscription();
			subscripcion.setId(Long.parseLong(res
					.getString("id")));
			subscripcion.setUrl(res.getString("url"));

			subscripciones.add(subscripcion);
		}
		res.close();
		consulta.close();
		conex.desconectar();
		return subscripciones;
	}

	public List<Subscription> listarSubcripciones() throws Exception {
		List<Subscription> subscripciones = new ArrayList<Subscription>();
		DbConnection conex = new DbConnection();

		PreparedStatement consulta = (PreparedStatement) conex
				.getConnection().prepareStatement(
						"SELECT * FROM subscription");
		ResultSet res = consulta.executeQuery();

		while (res.next()) {
			Subscription subscripcion = new Subscription();
			subscripcion.setId(Long.parseLong(res
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