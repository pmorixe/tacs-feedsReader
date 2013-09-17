package com.cloudbees.connection;

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

	public DbConnection() {
		try {
			// obtenemos el driver de para mysql
			Class.forName("com.mysql.jdbc.Driver");
			// obtenemos la conexión
			connection = (Connection) DriverManager.getConnection(url, login,
					password);

			if (connection != null) {
				System.out.println("Conexión a base de datos " + bd + " OK\n");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** Permite retornar la conexión */
	public Connection getConnection() {
		return connection;
	}

	public void desconectar() {
		connection = null;
	}
}
