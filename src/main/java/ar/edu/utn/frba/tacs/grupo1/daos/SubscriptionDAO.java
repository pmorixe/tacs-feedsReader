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

public class SubscriptionDAO  extends DAO{

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

			subscriptions.add(subscription);
		}
		res.close();
		query.close();
		connection.disconnect();
		return subscriptions;
	}

}