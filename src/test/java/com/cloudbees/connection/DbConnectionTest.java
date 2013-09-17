package com.cloudbees.connection;

import junit.framework.TestCase;

import org.junit.Test;

import com.mysql.jdbc.Connection;

public class DbConnectionTest extends TestCase {

	@Test
	public void testGetConnection() {
		Connection connection = new DbConnection().getConnection();
		assertNotNull(connection);
	}

	@Test
	public void testDesconectarDB() {
		DbConnection dbConnection = new DbConnection();
		dbConnection.desconectar();
		Connection connection = dbConnection.getConnection();
		assertNull(connection);
	}

}
