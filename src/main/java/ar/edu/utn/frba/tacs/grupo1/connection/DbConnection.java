package ar.edu.utn.frba.tacs.grupo1.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DbConnection {

	static String bd = "feedsreader_development";
	static String login = "tacs2";
	static String password = "tacs2";
	static String url = "jdbc:mysql://ec2-23-21-211-172.compute-1.amazonaws.com/"
			+ bd;
	static String port = "3306";

	Connection connection = null;

	public DbConnection() throws Exception {
		// obtenemos el driver de para mysql
		Class.forName("com.mysql.jdbc.Driver");
		// obtenemos la conexi�n
		connection = (Connection) DriverManager.getConnection(url, login,
				password);
	}

	/** Permite retornar la conexi�n */
	public Connection getConnection() {
		return connection;
	}

	public void desconectar() {
		connection = null;
	}
}
