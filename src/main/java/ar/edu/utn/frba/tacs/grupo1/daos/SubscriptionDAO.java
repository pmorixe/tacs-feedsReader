package ar.edu.utn.frba.tacs.grupo1.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.DateFormatter;

import org.apache.log4j.lf5.util.DateFormatManager;
import org.joda.time.DateTime;

import ar.edu.utn.frba.tacs.grupo1.connection.DbConnection;
import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;

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
			statement.executeUpdate("UPDATE subscription "+
					" SET URL='"+subscription.getUrl() + "'"+
					" WHERE id="+
					subscription.getId().toString());
		} else{
			statement.executeUpdate("INSERT INTO subscription (url) VALUES ('"
				+ subscription.getUrl() +"')");
		}
		statement.close();
		conex.disconnect(); 
	}

	/**
	 * Permite consultar subcripcion a partir de id como parametro
	 * 
	 * @param subscripcionId
	 * @return
	 * @throws Exception 
	 */
	public List<Subscription> getSubscriptions(Long subscripcionId) throws Exception {
		List<Subscription> subscriptions = new ArrayList<Subscription>();
		DbConnection conex = new DbConnection();

		PreparedStatement query = (PreparedStatement) conex
				.getConnection().prepareStatement(
						"SELECT * FROM subscription where id = ? ");
		query.setInt(1, subscripcionId.intValue());
		ResultSet res = query.executeQuery();

		if (res.next()) {
			Subscription subscription = new Subscription();
			subscription.setId(Long.parseLong(res
					.getString("id")));
			subscription.setUrl(res.getString("url"));
			subscription.setSince(new DateTime(res.getString("since")).toDate());
			subscriptions.add(subscription);
		}
		res.close();
		query.close();
		conex.disconnect();
		return subscriptions;
	}

	public List<Subscription> listSubcripciones() throws Exception {
		List<Subscription> subscriptions = new ArrayList<Subscription>();
		DbConnection connection = new DbConnection();

		PreparedStatement query = (PreparedStatement) connection
				.getConnection().prepareStatement(
						"SELECT * FROM subscription");
		ResultSet res = query.executeQuery();

		while (res.next()) {
			Subscription subscription = new Subscription();
			subscription.setId(Long.parseLong(res
					.getString("id")));
			subscription.setUrl(res.getString("url"));
			SimpleDateFormat dateValue = new SimpleDateFormat("YYYY-MM-DD");
			Date fecha = dateValue.parse(res.getString("since"));
			DateTime since = new DateTime(fecha);
			subscription.setSince(since.toDate());
			subscriptions.add(subscription);
		}
		res.close();
		query.close();
		connection.disconnect();
		return subscriptions;
	}

}
